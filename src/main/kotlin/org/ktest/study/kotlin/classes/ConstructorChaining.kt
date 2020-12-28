package org.ktest.study.kotlin.classes

class ConstructorChaining constructor(a:Int, b:Int, c:Int){
    public val a:Int = a
    public val b:Int = b
    public val c:Int = c

    constructor(a:Int, b:Int) : this(a, b, 10)
    constructor(a:Int): this(a, 10, 10)
    constructor(): this(10,10,10)

    override fun toString(): String {
        return "ConstChaining(a=$a, b=$b, c=$c)"
    }

}

class ConstChaining2 constructor(
    val a: Int,
    val b: Int,
    val c: Int
) {

    constructor(a: Int, b: Int) : this(a, b, 10)
    constructor(a: Int) : this(a, 10, 10)
    constructor() : this(10, 10, 10)

    override fun toString(): String {
        return "ConstChaining2(a=$a, b=$b, c=$c)"
    }
}

fun main() {
    val c = ConstructorChaining()
    println("------------------------")
    println(c)
    println("------------------------")
    println("${c.a}, ${c.b}, ${c.c}")
    println("------------------------")
}