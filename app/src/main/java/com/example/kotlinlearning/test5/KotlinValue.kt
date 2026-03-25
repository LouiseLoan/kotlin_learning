package com.example.kotlinlearning.test5


val name = "Loan"
var level = "junior"

fun printResult(){
    level = "mid"
    println("Bonjour $name ton niveau est $level")
}

fun main(){
    printResult()
}