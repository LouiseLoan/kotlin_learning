package com.example.kotlinlearning.test10

/**
 * Mon exercice : Écris une fonction classifyHttpStatus(code: Int): String qui :
 *   - 200 → "OK"
 *   - 201 → "Créé"
 *   - in 400..499 → "Erreur client"
 *   - in 500..599 → "Erreur serveur"
 *   - else → "Inconnu"
 */

fun classifyHttpStatus(code: Int): String {
    return when (code) {
        200 -> "OK"
        201 -> "cree"
        in 400..499 -> "Erreur client"
        in 500..599 -> "Erreur serveur"
        else -> "inconnu"
    }
}

/**
 *  Écris une fonction qui prend une List<Product> et affiche, pour chaque produit avec stock > 0 :
 *   "[id] name — price€ (stock unités)"
 *   → en utilisant destructuring dans le forEach
 */

data class Product(val id: Int, val name: String, val price: Double, val stock: Int)

val products = listOf(
    Product(111, "Table", 70.0, 0),
    Product(222, "chaise", 30.0, 4),
    Product(333, "lampe", 10.0, 10),
    Product(444, "canape", 100.0, 0),
    Product(555, "TV", 200.0, 6))

fun displayAvailableProductData(productList: List<Product>) {
    productList.forEach { (id, name, price, stock) -> if (stock > 0 ) println("[$id] $name - $price€ ($stock)") }
}


fun main(){
    println(classifyHttpStatus(200))
    println(classifyHttpStatus(201))
    println(classifyHttpStatus(450))
    println(classifyHttpStatus(550))
    println(classifyHttpStatus(999))

    displayAvailableProductData(products)
}

