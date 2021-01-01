package org.ktest.study.kotlin.objects

interface Factory<T> {
    fun create(): T
}

class MyClass {
    companion object : Factory<MyClass> {
        override fun create(): MyClass = MyClass()
    }
}

val f: Factory<MyClass> = MyClass

fun main() {
    var myClass = f.create()
}