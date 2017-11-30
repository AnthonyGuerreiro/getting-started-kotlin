package com.example

import java.math.BigInteger

/*
tailrec functions' bytecode generated as iterative function for improved performance
tailrec must assume a form to work: First do the job then recursive call




https://stackoverflow.com/questions/33923/what-is-tail-recursion
In traditional recursion, the typical model is that you perform your recursive calls first, and then you take the return value of the recursive call and calculate the result. In this manner, you don't get the result of your calculation until you have returned from every recursive call.

In tail recursion, you perform your calculations first, and then you execute the recursive call, passing the results of your current step to the next recursive step. This results in the last statement being in the form of "(return (recursive-function params))" (I think that's the syntax for Lisp). Basically, the return value of any given recursive step is the same as the return value of the next recursive call.

The consequence of this is that once you are ready to perform your next recursive step, you don't need the current stack frame any more. This allows for some optimization. In fact, with an appropriately written compiler, you should never have a stack overflow snicker with a tail recursive call. Simply reuse the current stack frame for the next recursive step. I'm pretty sure Lisp does this.


*/

fun fib(n: Int): BigInteger {
    return fib(n, BigInteger("0"), BigInteger("1"))
}

tailrec fun fib(n: Int, a: BigInteger, b: BigInteger): BigInteger {
    if (n == 0) return a
    return fib(n - 1, a + b, a)
}

// don't
fun classicRecursiveFib(n: Int): BigInteger {
    if (n == 1) {
        return BigInteger("1")
    }
    return classicRecursiveFib(n - 1) + classicRecursiveFib(n - 2)
}

fun main(args: Array<String>) {
    println(fib(100000))
}