package com.example

val void = { println("Hello World") }

val mult = { x: Int, y: Int -> x * y }
val mult2: (Int, Int) -> Int = { x, y -> x * y }

/*

 Lambdas generate an anonymous class with a method every time we create a lambda.
 This can have overhead.

 We can inline function calls to improve performance for lambdas

 */

inline fun <T> first(items: Collection<T>, predicate: (T) -> Boolean): T? {
    return items.firstOrNull(predicate)
}

fun testFirstInlined() {
    val list = listOf(1, 2, 3, 4)
    val predicate: (Int) -> Boolean = { it % 2 == 0 }

    //compile code doesn't call inlined com.example.first(), it instead copies its body here
    val first = first(list, predicate)
}

/*

 Not every function can be inlined.
  If we take the lambda into a variable to use later: cannot be inlined

  Kotlin collection operators are inlined: filter, map.. not in sequences though because we have to hold the value to use later,
  so in some cases working sequences is actually more expensive than the collections



 */