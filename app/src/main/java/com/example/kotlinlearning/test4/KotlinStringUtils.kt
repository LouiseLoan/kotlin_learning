package com.example.kotlinlearning.test4

fun String.capitalize() : String {
    return this.substring(0,1).uppercase() + this.substring(1).lowercase()
}

fun String.isValidEmail() : Boolean {
    return this.isNotEmpty() && this.contains("@") && this.contains(".")
}

fun String.removeSpaces() : String {
    return this.replace(" ", "_")
}

fun main(){
    println("test test".removeSpaces())
}

// Utilisation
//  "text".capitalize
//  "text".isValidEmail