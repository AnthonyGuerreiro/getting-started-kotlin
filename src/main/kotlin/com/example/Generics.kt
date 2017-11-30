package com.example

fun <T> first(t1: T, t2: T): T {
    return t1
}

fun <T : Comparable<T>> max(t1: T, t2: T): T {
    return if (t1 > t2) t1 else t2
}

/*
 reified saves generic type so that it can be used in runtime.
 works only on inline functions.
*/
inline fun <reified T> isA(value: Any) = value is T

// wildcard is *
// needs reified
inline fun <reified T> List<*>.typeOf(): List<T> {
    return filterIsInstance<T>()
}