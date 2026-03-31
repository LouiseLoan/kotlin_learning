package com.example.kotlinlearning.test12

import kotlinx.coroutines.*

fun main() = runBlocking {

    // --- PARTIE A : identifier sur quel thread on tourne ---
    println("runBlocking thread: ${Thread.currentThread().name}")

    launch(Dispatchers.Default) {
        println("Default thread: ${Thread.currentThread().name}")
    }

    launch(Dispatchers.IO) {
        println("IO thread: ${Thread.currentThread().name}")
    }

    delay(100) // laisser les deux launch s'exécuter

    // --- PARTIE B : withContext pour changer de thread ---
    println("\n=== withContext ===")

    launch(Dispatchers.Default) {
        println("Début sur: ${Thread.currentThread().name}")

        val data = withContext(Dispatchers.IO) {
            // Simule un appel réseau
            println("Fetch sur: ${Thread.currentThread().name}")
            delay(300)
            "données récupérées"
        }

        // On est revenu sur Default automatiquement
        println("Retour sur: ${Thread.currentThread().name}")
        println("Résultat: $data")
    }

    delay(500)

    // --- PARTIE C : le pattern Android typique ---
    println("\n=== Pattern Android ===")

    suspend fun loadData(): String = withContext(Dispatchers.IO) {
        delay(200)
        "utilisateur: Loan"
    }

    launch {
        val result = loadData() // s'exécute sur IO, revient ici après
        println("Sur le thread courant: ${Thread.currentThread().name}")
        println(result)
    }

    delay(400)
}