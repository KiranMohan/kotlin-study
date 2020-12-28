package org.ktest.study.kotlin.arrays

fun main() {
    val arr1 = IntArray(10) {it -> it + 1}
    val arr2 = Array<Int>(5) {index -> index * index} // creates [0, 1, 4, 9, 16]


    println("--------- arr1 ---------")
    for ((index, value) in arr1.withIndex()) {
        println("$index: $value")
    }
    println("--------- arr2 ---------")
    for ((index, value) in arr2.withIndex()) {
        println("$index: $value")
    }
    println("------------------------")

    println("arr1[9] = ${arr1[9]}")
    println("arr1.get(5) = ${arr1.get(5)}")
}