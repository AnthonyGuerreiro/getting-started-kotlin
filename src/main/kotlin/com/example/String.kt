package com.example

fun stringsAreEqual(x: String, y: String): Boolean = x == y //no .equals() required. operator is overloaded.

fun containsSubStringCaseInsensitive(x: String, y: String): Boolean = x.contains(y, true)
