package com.example

import java.util.*

fun iterateCollectionOrArray() {
    val list = listOf(Person(1), Person(2), Person(3), null, Person(4))


    for (i in list) {
        println(i?.age)
    }

    for (i in list.filterNotNull()) {
        println(i.age)
    }

    for (i in list.indices) {
        println("$i is ${list[i]}")
    }

    list.forEachIndexed { i, e ->
        println("$i is $e")
    }

    for ((index, person) in list.withIndex()) {
        println("list[$index] is $person")
    }
}

fun iterateMap() {
    val map = TreeMap<String, Int>()
    map.put("John", 55)

    for ((name, age) in map) {
        println("$name is $age years old")
    }
}

//ranges
fun forLoop() {

    for (i in 1..20) {
        // i = [1,20]
    }

    for (i in 1 until 20) {
        // i = [1,20)
    }

    for (i in 20 downTo 1) {
        // i = [20,1]
    }
}