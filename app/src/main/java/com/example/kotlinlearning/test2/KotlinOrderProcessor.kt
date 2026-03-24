package com.example.kotlinlearning.test2

class KotlinOrderProcessor {

    /**
     *   1. Convertis en Kotlin
     *   2. getExpensiveItems() → remplace la boucle for par filter + map
     *   3. getTotalPrice() → remplace la boucle par sum() ou sumOf
     */

    fun getExpensiveItems(items: List<String>, prices: List<Double>) : List<String> {
        return items.zip(prices).filter { it.second > 50 }.map { it.first.uppercase() }
    }

    fun getTotalPrice(prices: List<Double>) : Double {
        return prices.sum()
    }


}

fun main(){
    val processor = KotlinOrderProcessor()

    val items = listOf("chaise", "table", "lampe", "stylo")
    val prices = listOf(80.0, 30.0, 120.0, 5.0)


    val totalPrice = prices.sum()

    println(totalPrice)
}