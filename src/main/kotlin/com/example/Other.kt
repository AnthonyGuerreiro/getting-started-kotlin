package com.example

// object keyword: creates singleton
// companion object in a class: Similar to static methods. A singleton that is this class' companion
// it can also extend or implement other classes/interfaces

class Test {

    companion object : Interfaces {
        val i: Int = getRandomInt()
        fun log(s: String) = println(s)
    }
}