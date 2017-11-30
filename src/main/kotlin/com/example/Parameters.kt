package com.example

// default args. Function body not required for single expression. "Function expression"
fun multiply(x: Int, y: Int = 2): Int = x * y

fun printMultiply3By2() = println("6=" + multiply(3))

// named parameters. If one parameter is named, all must be. order doesn't matter.
// works with default values
fun printMultiply4by5() = println("20=" + multiply(y = 5, x = 4))