package com.example

fun safeCall(i: Int?) {
    //only compares if i != null. Otherwise returns null
    val compare: Int? = i?.compareTo(3)
}

fun elvis(i: Int?): Int {
    // returns the right value if the left evaluates to null
    return i?.compareTo(3) ?: 2
}

fun assertion(i: Int?) {
    //asserts it is not null: throws NullPointerException if it is.
    // Also, smartcast to non-nullable. From this line on, i is Int, not Int?
    i!!.compareTo(3)

    i.compareTo(3) //safe because being here, exception not thrown above, smart cast occurred.
}

interface A {
    fun doStuff()
}


fun safeCast(i: Any) {
    //comparable is either a comparable or null if i is not comparable
    val a: A? = i as? A
    a?.doStuff()
}

fun let(s: String?) {
    //let allows us to call functions that receive non-nullable type with a nullable.
    //useful specially if we don't own those functions and can't change them

//    ListExampleImpl().addNonNullable(s) // compilation error
    s?.let { ListExampleImpl().addNonNullable(it) } // let block only executed if s != null
    //both compile so we need to be careful if null is actually a valid value or not as we'd have in Java
    ListExampleImpl().add(null)
    ListExampleImpl().add("a")


}

/*
Java may not help kotlin compiler know if params are nullable or not with annotations.
When such happens, the variables are "Platform types". We can't declare values of those types.
String! -> Either String or String? , compiler doesn't know
Int!    -> Either Int or Int? , compiler doens't know

It is up to the developer to understand how to use these, it's the dev's responsability.
We may of course use the safe operators on these.
*/
fun test() {
    val example = ListExampleImpl()

    //both compile. Java may throw NPE if it doesn't accept null
    example.add(null)
    example.add("s")

    // both compile. The second will throw NPE if java code returns null
    val s: String? = example.get(1)
    val s2: String = example.get(1)


}

/*
 Overriding or implementing java classes/interfaces
*/
class ListExample2 : ListExample {

    override fun add(element: String?) {
        // Developer gets to choose arg type: String or String?
    }

    override fun addNonNullable(element: String) {
        // Java annotation forces String arg
    }

    override fun get(index: Int?): String? {
        // Developer gets to choose arg type: Int or Int?
        // Developer gets to choose return type: String or String?
        return ""
    }

}