package org.ktest.study.kotlin.extensions


val <T> List<T>.lastIndex: Int
    get() = this.size - 1

fun main() {

    val ints = listOf(1, 2, 3)
    val strings = listOf("Achan", "Amma", "Kiran", "Neena", "Tanvi")

    println("ints lastindex: ${ints.lastIndex}")
    println("strings lastindex: ${strings.lastIndex}")

}