package com.example

// if lamda is the last arg of a function we can call specify it with a different syntax
fun test(a: Int, f: (Int) -> Unit) {
    f(a)
}

fun callTest() {
    test(3, ::println)
    test(3) { i -> println(i) }
    test(3) { println(it) }
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

// `with` accepts instance as argument
// `with` returns the result of the last expression, which is confusing; we should avoid using it
// The receiver becomes `this` in the lambda

// `with` should be used to call multiple methods on an object.
fun withExample() {
    val p = Person(3)
    val age: Int = with(p) {
        age = 2
        this.age = 2
        age
    }

    // example as `with` should be used:
    with(p) {
        // methods not implemented, just to show how `with` really should be used
//        add(this, credentials)
//        assign(this, work)
//        supervise(this)
    }

}

// `apply` accepts an instance as the receiver
// `apply` returns the receiver
// The receiver becomes `this` in the lambda.

// apply is used for post-construction configuration.
fun applyExample() {
    val p = Person(3)
    val p2 = p.apply {
        age = 3
    } // returns receiver
}

// `also` accepts an instance as the receiver
// `also` returns the receiver (not the result of the lambda)
// The receiver becomes `it` in the lambda

// used for extra processing, chaining requests
fun alsoExample() {
    Person(3)
        .also { println(it) }

    Person(4)
        .let { it.age }
        .also { print(it + 4) }
        .also { print(it + 5) }
        .run { print(this) }
}

// `run` accepts an instance as the receiver
// `run` returns the value of the last expression but we should avoid using it
// `run` runs a function with its receiver and returns the value in the last line
// The receiver becomes `this` in the lambda

// run is another function literal with receiver.
// It is used with lambdas that do not return values, but rather just create some side-effects
fun runExample(s: String) {

    // examples return value instead doing side effects for the purpose of demonstration

    // unnecessary elvis operator, just used as example
    val thing = Person(3)?.run {
        if (this == null) "it's a test" else "another test"
    }.toThing()


    // no receiver
    val bool = run {
        val t: Boolean = true
        if (t) t else !t
    }.or(false)
}

// `let` accepts an instance as the receiver
// `let` retunrns the result of the lambda
// The receiver becomes `it` in the lambda

// `let` is a non-monadic version of map:
// It accepts objects as parameters and returns the result of the lambda. Super-useful for conversions
fun letExample(s: String?) {

    val p: Person? = Person(3)
    val age: Int = p?.let {
        it.age * 4
    } ?: 5

//---------------------------------------------
//    ListExampleImpl().addNonNullable(s) // compilation error: addNonNullable can't add String?
    val number: Int = s?.let {
        ListExampleImpl().addNonNullable(it)
        3
    } ?: 2

    //both compile so we need to be careful if null is actually a valid value or not as we'd have in Java
    ListExampleImpl().add(null)
    ListExampleImpl().add("a")
}


/*

    also: additional processing on an object in a call chain
    apply: post-construction configuration
    let: conversion of value
    run: execute lambdas with side-effects and no result
    with: configure objects created somewhere else

 */