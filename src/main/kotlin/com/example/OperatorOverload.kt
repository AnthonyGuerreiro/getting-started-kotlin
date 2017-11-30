package com.example

class Header(val name: String)

infix fun Header.first(h: Header): Header {
    return this
}

fun useInfix() {
    val h1 = Header("h1")
    val h2 = Header("h2")
    val h3 = h1 first h2
}

operator infix fun Header.plus(h: Header): Header {
    return Header("$name ${h.name}")
}

fun usePlusOperator() {
    val h1 = Header("h1")
    val h2 = Header("h2")
    val h3 = h1 + h2
}

/*
The operators we can overload:

Unary:   + - !   ==   --
Binary:  + - * / %  .. += -= *= /= %= in [] () == != > < >= <=

*/