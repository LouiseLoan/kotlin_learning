package com.example.kotlinlearning.test8

data class Order(val userId: String, val product: String, val amount: Double)

/**
 * 1. Regroupe les commandes par userId
 *   2. Trie les commandes par amount du plus cher au moins cher
 *   3. Calcule le total de toutes les commandes avec fold
 */

val orders = listOf(
    Order("loan", "Kotlin Book", 29.99),
    Order("alice", "Android Course", 49.99),
    Order("loan", "Clean Code", 19.99),
    Order("bob", "Jetpack Compose", 39.99),
    Order("alice", "Git Guide", 9.99)
)

fun main(){

    println(orders.groupBy { it.userId })
    println(orders.sortedByDescending { it.amount })

    val orderAmount = orders.fold(0.0, {acc, order -> acc + order.amount})

    println(orderAmount)

}