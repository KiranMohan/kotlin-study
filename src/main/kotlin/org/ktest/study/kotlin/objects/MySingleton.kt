package org.ktest.study.kotlin.objects

object MySingleton {
    val value1 = 10
    var value2 = 20
        set(value) { field = value * 2 }
}

fun main() {
    println("value1 : ${MySingleton.value1}, value2: ${MySingleton.value2}")
    MySingleton.value2 = 30
    println("value1 : ${MySingleton.value1}, value2: ${MySingleton.value2}")
}


data class Event(val eventName: String, val eventValue: String)

abstract class Listener(
    val ListenerType: String
) {
    abstract fun handle(e: Event)
}

object MouseListener: Listener("MouseListener") {
    override fun handle(e: Event) {
        TODO("Not yet implemented")
    }
}

object KeyboardListener: Listener("KeyboardListener") {
    override fun handle(e: Event) {
        TODO("Not yet implemented")
    }
}