package org.ktest.study.kotlin.controlFlow

import java.awt.Color

const val xVal = 100

enum class TRAFFIC_LIGHT {
    RED,
    BLUE,
    GREEN,
    YELLOW
}

fun getMyColor(): TRAFFIC_LIGHT = TRAFFIC_LIGHT.GREEN

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

    val y = getMyColor()
    println("----------------------------------------")
    println("y: $y")
    when (y) {
    TRAFFIC_LIGHT.RED  -> println("Stop")
    TRAFFIC_LIGHT.YELLOW -> println("Hold")
    TRAFFIC_LIGHT.BLUE, TRAFFIC_LIGHT.GREEN -> println("go")
    }

}

