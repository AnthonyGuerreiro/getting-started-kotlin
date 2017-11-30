// above package declaration: If we want to specify a diferent class name generated for Java class for this file
// function write will then be callable by: Utils.write(..)
@file:JvmName("Utils")

package com.example

import java.util.function.Predicate

// Java has no default parameters. We have to specify @JvmOverloads if we want java interoperability
@JvmOverloads
fun write(s: String, count: Int = 1) {
    for (i in 1..count) {
        println(s)
    }
}

class JavaInteroperability {

    //create a lambda to interact with Java @FunctionalInterface:
    val pr = Predicate<Int>({ it % 2 == 0 })

    companion object {

        // allows java to access this through Utils.i instead Utils.getI()
        @JvmField
        val i: Int = 3

        // allow Utils.test() to be used from Java. Without this annotation, it will be usable through Utils.Companion.test()
        @JvmStatic
        fun test() {

        }
    }
}

/*
 Kotlin does not have checked exceptions. This lets java know this method throws this exception.
 Otherwise, java won't see it as declared and doesn't force us to catch or throw it.
 And if we try to catch it then the compiler will complain saying it can't throw that exception.
*/
@Throws(Exception::class)
fun withException() {
    throw Exception()
}

/*
 null safety: @Nullable and @NotNull annotations from JetBrains in Java help kotlin compiled.
 Should they be not present then kotlin won't know if returned values can be null or not.

 For that we need to check for nullability and/or make choices. Check Nullability.kt
*/