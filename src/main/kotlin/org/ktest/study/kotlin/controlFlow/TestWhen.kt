package org.ktest.study.kotlin.controlFlow

const val xVal = 100

fun main() {
    val x = 100


    when {  // here "when" used as replacement for if-else chains. Note: when takes no parameter
        x < 50 -> {
            println ("$x is less than 50")
        }
        x == 50 -> {
            println ("$x")
        }
        else -> {
            println ("$x is greater than 50")
        }
    }

    val ch = 'a'

    when (ch) { // "when" used like java switch statement.
        in 'a'..'h' -> {
            println("in a-h sequence")
        }
        in 'i'..'o' -> {
            println("in i-o sequence")
        }
        else -> {
            println("in p-z sequence")
        }

    }
}