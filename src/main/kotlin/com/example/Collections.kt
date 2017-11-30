package com.example

import java.util.*
import java.util.function.Predicate

fun lists() {
    var list = listOf(1, 2)
    list = arrayListOf(1, 2)
    list = mutableListOf(1, 2)

    var nullAllowedList = listOf<Int?>(1, 2)
    var nullableList: List<Int>? = null
    var nullableNullAllowedList: List<Int?>? = null
}

fun sets() {
    var set = setOf(1, 2)
    set = hashSetOf(1, 2)
    set = mutableSetOf(1, 2)

    var nullAllowedSet = setOf<Int?>(1, 2)
}

fun maps() {
    var map = mapOf("A" to 1, "B" to 2)
    map = hashMapOf("A" to 1, "B" to 2)
    map = mutableMapOf("A" to 1, "B" to 2)

    var ages = TreeMap<String, Int>()
}


// Kotlin provides same operations on arrays as on collections. filter, map, ...
fun referenceArrays() {
    var array = arrayOf(Person(1), Person(2))
    array = Array(2) { Person(it) }
    var arrayOfNullValues = arrayOfNulls<Int>(3)
}

//byteArray, charArray, ...
fun primitiveArrays() {
    var intArray = intArrayOf(1, 2)

    intArray = IntArray(2)
    intArray[0] = 1
    intArray[1] = 2
}


/*
   Java interoperability

   - java does not distinguish in compile time if collections are immutable or not

   - when overriding java collections, we have to think about:
     - is the collection nullable/mutable
     - are the members nullable/mutable
       - in java, List<com.example.Person> is nullable, both the list and the elements. The list may be mutable or not.

     Say we implement a java interface that has method:  com.example.getVoid process(List<com.example.Person> people);
     Because we're dealing with Platform types,
      When overriding that method, we have to decide its signature:
        override fun process(people: List<com.example.Person>)
        override fun process(people: List<com.example.Person>?)
        override fun process(people: List<com.example.Person?>)
        override fun process(people: List<com.example.Person?>?)
        override fun process(people: MutableList<com.example.Person>)
        ...

 */

fun operations() {
    var list = listOf(1, 2)

    //applies on the moment. good for short collections
    val other = list.filter { it % 2 == 0 }.map { 10 * it }

    // lazy. like stream. best if list is huge. only evaluates when we will use the seq
    val otherSeq = list.asSequence().filter { it % 2 == 0 }.map { 10 * it }

    list.filterNotNull()
    list.filterIsInstance<Int>()
    list.firstOrNull { it % 2 == 0 }
    list.first { it % 2 == 0 } //NoSuchElementException if none
    list.last { it % 2 == 0 }
    list.lastOrNull { it % 2 == 0 }
    list.first()
    list.last()
    list.toHashSet()
    list.toMutableList()
    list.toTypedArray()
    val all = list.all { it % 2 == 0 } // true if all match
    val any = list.any { it % 2 == 0 } // true if any matches
    list.count()
    list.count { it % 2 == 0 }
    list.find { it % 2 == 0 } //returns first matching or null
    val predicate: (Int) -> Boolean = { it % 2 == 0 }
    list.first(predicate) // using predicate as var instead direct lambda, parentheses are required
    list.sum()

    /*
      Lambdas are created once and reused every time unless they mutate state.
       In the examples above, the lambda { it % 2 == 0 } was created only once (maybe twice? for the time it was assigned
      to a val).
     */


    //create a lambda to interact with Java @FunctionalInterface:
    val pr = Predicate<Int>({ it % 2 == 0 })


    //reduce
    list.fold(0, { a, b -> a + b })
    list.fold(1, { a, b -> a * b })
    list.foldRight(0, { a, b -> a + b })

    val mutable = mutableListOf(1, 2)
    mutable += 3 //add 3 to list
}