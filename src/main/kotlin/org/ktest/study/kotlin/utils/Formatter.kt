package org.ktest.study.kotlin.utils

fun Double.format(digits: Int) = "%.${digits}f".format(this)