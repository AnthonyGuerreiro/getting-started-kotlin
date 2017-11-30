package com.example

import java.time.LocalDate

fun returnIfExpression(): Int {


    val isOddDay = LocalDate.now().dayOfMonth.rem(2) == 1

    return if (isOddDay) {
        println("last statement is if's return value")
        1
    } else {
        2
    }
}