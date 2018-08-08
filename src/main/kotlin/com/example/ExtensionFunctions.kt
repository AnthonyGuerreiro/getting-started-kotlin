package com.example

/*
In Kotlin we can "add" methods to classes that were not created by us.

In this example we add .toThing() to String.
*/

class Thing(val name: String)

fun String.toThing() = Thing(this)

fun createThings() {
    val things = MutableList(0) { Thing("") }

    // package level function in class Clazz. import my.package.showLogin() or import my.package.*
    // would be required if in another package
    showLogin()

    things.add("one".toThing())
    things.add("another".toThing())
}
