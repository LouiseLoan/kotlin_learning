package com.example.kotlinlearning.test11

import kotlinx.coroutines.*

// 1. Une suspend function qui simule un appel réseau
suspend fun fetchUserName(id: Int): String {
    delay(500) // simule latence réseau
    return "User_$id"
}

// 2. Une suspend function qui simule une autre opération
suspend fun fetchUserScore(id: Int): Int {
    delay(300)
    return id * 100
}

fun main() = runBlocking {

    // --- PARTIE A : exécution séquentielle ---
    println("=== Séquentiel ===")
    val start1 = System.currentTimeMillis()

    val name = fetchUserName(1)      // attend 500ms
    val score = fetchUserScore(1)    // attend 300ms ensuite

    println("$name → score: $score")
    println("Temps: ${System.currentTimeMillis() - start1}ms") // ~800ms

    // --- PARTIE B : exécution parallèle avec async ---
    println("\n=== Parallèle ===")
    val start2 = System.currentTimeMillis()

    val nameDeferred = async { fetchUserName(2) }
    val scoreDeferred = async { fetchUserScore(2) }

    val name2 = nameDeferred.await()
    val score2 = scoreDeferred.await()

    println("$name2 → score: $score2")
    println("Temps: ${System.currentTimeMillis() - start2}ms") // ~500ms (le max des deux)

    // --- PARTIE C : launch (pas de valeur de retour) ---
    println("\n=== Launch ===")
    val job = launch {
        delay(200)
        println("Job terminé!")
    }

    println("Job lancé, on continue...")
    job.join() // attend que le job finisse
    println("Tout est fini.")
}