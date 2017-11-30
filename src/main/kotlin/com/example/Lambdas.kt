package com.example

// if lamda is the last arg of a function we can call specify it with a different syntax
fun test(a: Int, f: (Int) -> Unit) {
    f(a)
}

fun callTest() {
    test(3, ::println)
    test(3, { i -> println(i) })
    test(3, { println(it) })
    test(3) {
        println(it)
    }
}

/*
 In Kotlin, lambdas can mutate values from other scopes. Unlike in java where those values must be
either final or effectively final. The Jvm imposes the same restrictions on these lambdas but the kotlin
compiler works around it by generating different bytecode
 */
fun mutate() {
    var n: Int = 3
    for (i in 1..10) {
        println {
            n++
        }
    }
}

// with and apply: opens a scope where "this" is the received
fun withExample() {
    val p = Person(3)
    with (p){
        age = 2 // no need to do p.age = 2, p is the context
    } //returns Unit
}

fun applyExample() {
    val p = Person(3)
    val p2 = p.apply {
        age = 3
    } // returns receiver
}