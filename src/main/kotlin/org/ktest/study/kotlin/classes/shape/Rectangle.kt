package org.ktest.study.kotlin.classes.shape

import org.ktest.study.kotlin.interfaces.org.ktest.study.kotlin.interfaces.Shape
import org.ktest.study.kotlin.utils.format
import kotlin.math.sqrt

open class Rectangle(length: Double, width: Double) : Shape{

    open var length = length        // "open" functions to be overridden by subclass
        get() = field                   // getter
        set(value) { field = value }    // setter

    open var width = width
        get() = field
        set(value) { field = value }

    override fun draw() {
        println("drawing Rectangle with length: ${length.format(2)} and width: ${width.format(2)}")
    }

    override fun zoom(x: Double) {
        val sqrtX = sqrt(x)
        length *= sqrtX
        width *= sqrtX
    }
}