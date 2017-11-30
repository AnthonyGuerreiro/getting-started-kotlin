package com.example

//primary constructor on class def, must call a superclass constructor
// Any fields declared as var or val are automatically declared as class fields. Other ones are local to constructor
class Something(val t: Int) : Person(t) {

    var t2: Int = 1

    //secondary constructors must call primary constructor
    constructor(t: Int, t2: Int) : this(t) {
        this.t2 = t2
    }
}

// without primary constructor
class Something2 : Person {
    constructor(t: Int) : super(t)
    constructor(t: Int, t2: Int) : super(t) {
        //
    }
}

class Something3(val t: Int) : Person(t) {
    init {
        //extra logic during constructor
    }
}