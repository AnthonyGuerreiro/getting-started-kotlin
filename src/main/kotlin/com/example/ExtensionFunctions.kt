package com.example

/*
In Kotlin we can "add" methods to classes that were not created by us.

In this example we add .toThing() to String.
*/

class Thing(val name: String)

fun String.toThing() = Thing(this)

fun createThings() {
    val things = MutableList(0) { Thing("") }

    things.add("one".toThing())
    things.add("another".toThing())
}