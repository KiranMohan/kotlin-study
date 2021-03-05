package org.ktest.study.kotlin.classes.delegation

interface  Base {
    fun print()
    fun speak()
    fun shout()
    var message: String
}

class BaseImpl(message: String): Base {

    override var message: String = message
        set(value) {
            field = value
        }


    override fun print() {
        println("Printing: $message")
    }

    override fun speak() {
        println("Speaking: $message")
    }

    override fun shout() {
        println("Base Shout: $message")
    }
}

class Derived(var b: Base): Base by b {

    override fun shout() {
        println ("Shouting: ${b.message}")
    }

    fun serve(action: (String) -> Unit) {
        action(message)
    }
}

fun main() {

    val base = BaseImpl ("Hello World")
    val derived = Derived(base)

    derived.print()
    derived.speak()
    derived.shout()

    derived.message = "Hello Kiran"

    derived.print()
    derived.speak()
    derived.shout()

    base.shout()

    derived.serve { println("String length: ${it.length}") }
}