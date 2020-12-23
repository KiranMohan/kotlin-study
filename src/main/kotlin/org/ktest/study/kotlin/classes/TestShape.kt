package org.ktest.study.kotlin.classes

import org.ktest.study.kotlin.classes.shape.Rectangle
import org.ktest.study.kotlin.classes.shape.Square
import org.ktest.study.kotlin.interfaces.org.ktest.study.kotlin.interfaces.Shape

fun main() {
    val shape: Shape = Rectangle(10.0, 20.0)
    shape.draw()
    shape.zoom(50.0)
    shape.draw()
    if (shape is Rectangle) {
        shape.length = 30.0 // shape is automatically cast to Rectangle (smart cast by kotlin)
    }
    shape.draw()

    println("---------------------------------")

    val shape2: Shape = Square(30.0)
    shape2.draw()
    shape2.zoom(50.0)
    shape2.draw()
    if (shape2 is Square) {
        shape2.side = 70.0  // shape2 is automatically cast to Square (smart cast by kotlin)
        println("square side ${shape2.side}")
    }
    shape2.draw()

}