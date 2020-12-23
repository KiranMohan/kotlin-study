package org.ktest.study.kotlin.classes.shape

import org.ktest.study.kotlin.utils.format

class Square (side: Double): Rectangle(side, side) { // inheritence syntax

    var side: Double
        get() = length
        set(value) {
            length = value
            width = value
        }

    override var length: Double
        get() = super.length
        set(value) {
            super.length = value
            super.width = value
        }

    override var width: Double
        get() = super.width
        set(value) {
            super.length = value
            super.width = value
        }

    override fun draw() {
        println("drawing Square with side: ${length.format(2)}")
    }
}