package com.example

// primary constructor
abstract class Shape(val area: Int)

//primary constructor. defines side as object property
class Square(val side: Int) : Shape(side * side)

//primary constructor. does not define any extra property
class Square2(side: Int) : Shape(side * side)

class Square3(val side: Int) : Shape(side * side) {
    init {
        println("Custom logic here. side=$side; area=$area")
    }
}

//Alternative to com.example.Square
class Square4 : Shape {
    val side: Int

    constructor(side: Int) : super(side * side) {
        this.side = side
    }

}

// secondary constructor
class Square5(val side: Int) : Shape(side * side) {

    //secondary constructor can't add fields through var/val.
    //these can be in primary constructor, with or without default values, or in class body
    constructor(sideFraction: Int, multiplier: Int) : this(sideFraction * multiplier) {
        // other logic here
    }
}

// package level function used in ExtensionFunctions.kt for example
fun showLogin() {
    val login = Login(password = "secret")
    val login2 = login.copy(password = "secret2")

    val (username, password) = login2
    println("login2: $login2 has username=$username and password=$password")

    // deconstruction uses methods x.component1(), x.component2(), x....., x.componentN()
    // created for the data classes under the hood
}


// data classes provide with default hashcode, equals, toString and methods out of the box.
// They can be deconstructed and cannot be extended.
data class Login(val username: String = "john", val password: String)

// sealed classes: Sort of like enums but more powerful.
// A sealed class is a class that can only be extended by the enumerated subclasses. In this example,
//  Student can only be extended by UnivStudent and HighSchoolStudent
// A sealed class is abstract.
sealed class Student(age: Int) : Person(age) {
    data class UnivStudent(val name: String) : Student(18)
    data class HighSchoolStudent(val name: String) : Student(15)
}

fun createStudent(name: String, age: Int) {
    when (age) {
        in 1..18 -> Student.HighSchoolStudent(name)
        else -> Student.UnivStudent(name)
    }
}