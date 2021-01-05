package org.ktest.study.kotlin.dsl.xml

/*

<?xml version="1.0" encoding="UTF-8"?>
<playlist>
    <track filetype="mp3">
        <name>z</name>
        <artist>abcdef</artist>
        <file>/x/y/z.mp3</file>
    <track>
    <track filetype="mp3">
        <name>m</name>
        <artist>qwerty</artist>
        <file>/k/l/m.mp3</file>
    <track>
</playlist>
* */

const val DEFAULT_XML_HEADER="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"

abstract class Element {
    abstract fun render(builder: StringBuilder, indent: String = "");
}

class Attribute(val attribute:String, val value: String) {
    fun render(builder: java.lang.StringBuilder): Unit {
        builder.append(" ${attribute}=\"${value}\"")
    }
}

open class Tag(val name: String, vararg attributes: Attribute) : Element() {


    override fun render(builder: StringBuilder, indent: String) {

        // begin tag
        builder.append("${indent}<${name}");
        renderAttributes(builder)
        builder.append(">")
        if (children[0] !is TextElement)
            builder.append("\n")

        // add child nodes
        children.forEach {it.render(builder, "${indent}    ")}

        // end tag
        if (children[0] is TextElement)
            builder.append("</${name}>\n")
        else
            builder.append("${indent}</${name}>\n")
    }

    protected fun <T: Tag> initTag(tag: T, init: T.() -> Unit): T {
        tag.init()
        children.add(tag)
        return tag
    }

    protected val children = arrayListOf<Element>()
    protected val myAttributes = arrayListOf<Attribute>(*attributes)

    private fun renderAttributes(builder: StringBuilder) {
        myAttributes.forEach { attribute ->
            attribute.render(builder)
        }
    }

}

open class TagWithText(name: String, vararg attributes: Attribute): Tag(name, *attributes) {
    operator fun String.unaryPlus() {
        children.add(TextElement(this))
    }
}

class TextElement(val text: String): Element() {
    override fun render(builder: StringBuilder, indent: String) {
        builder.append(text)
    }
}

class Name: TagWithText("name")
class Artist: TagWithText("artist")
class File: TagWithText("file")

class Track (vararg attributes: Attribute) : Tag("track", *attributes) {
    fun name(init: Name.() -> Unit) = initTag(Name(), init)
    fun artist(init: Artist.() -> Unit) = initTag(Artist(), init)
    fun file(init: File.() -> Unit) = initTag(File(), init)
}

class PlayList: Tag("playlist") {
    fun track (vararg attributes: Attribute, init: Track.() -> Unit) = initTag(Track(*attributes), init)
}

class XML(vararg attributes: Attribute) : Tag("xml", *attributes) {
    init {
        if (attributes.isEmpty()) {
            myAttributes.add(Attribute("version", "1.0"))
            myAttributes.add(Attribute("encoding", "UTF-8"))
        }
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        render(stringBuilder, "")
        return stringBuilder.toString()
    }

    fun playlist(init: PlayList.() -> Unit) = initTag(PlayList(), init)
}

fun xml(vararg attributes: Attribute, init: XML.() -> Unit): XML {
    var xml = XML(*attributes)
    xml.init()
    return xml
}

fun main() {
    var playlist = xml {
        playlist {
            track(Attribute("filetype", "mp3")) {
                name {+"z"}
                artist {+"abcdef"}
                file { +"/x/y/z.mp3"}
            }
            track(Attribute("filetype", "aac")) {
                name {+"m"}
                artist {+"qwerty"}
                file { +"/k/l/m.mp3"}
            }

        }
    }

    println(playlist)
}
