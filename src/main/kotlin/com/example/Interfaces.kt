package com.example

interface Interfaces {

    // default methods
    fun getRandomInt(): Int = 3

    fun getRandomString(): String {
        return "randomString is ${getRandomInt()}"
    }

}

interface Interfaces2 {
    fun getRandomInt(): Int = 4
}


//conflict
class implementer : Interfaces, Interfaces2 {

    //resolve conflict with super<T>.fun() or custom implementation
    override fun getRandomInt(): Int {
        return super<Interfaces2>.getRandomInt() + super<Interfaces>.getRandomInt()
    }
}