package com.example.kotlinlearning.test13

import kotlinx.coroutines.*
import java.time.LocalTime

suspend fun fetchUser(id: Int): String {
    delay(500)
    return "user_$id"
}

suspend fun fetchStats(stats: Int): String {
    delay(500)
    return "stat = $stats"
}

suspend fun fetchError(): String {
    delay(500)
    throw Exception("Timeout")
}



fun main() = runBlocking {

    // OBJECTIF : Comprendre pourquoi try/catch se comporte différemment avec les coroutines
    val errorLaunch = launch {
        try {
            fetchError()
        } catch (e: Exception){
            println("Catch : ${e.message}")
        }
    }


    val handler = CoroutineExceptionHandler{_, exception ->
        println("Handler : ${exception.message} at : ${LocalTime.now()}")
    }

    val scope = CoroutineScope(Dispatchers.Default + handler)

    scope.launch {
        println("Coroutine 1 : ${fetchUser(1)}")
    }

    scope.launch {
        println("Coroutine 2 : ${fetchUser(2)}")
    }

    scope.launch {
        throw Exception("coroutine 3 plante")
    }

    delay(5000)


    val withSupervisorScope = supervisorScope {
        launch { println("get user = ${fetchUser(1)}") }
        launch { println("get stats = ${fetchStats(111)}") }
        launch { throw Exception("Error for notification") }
    }

    // 1 : Le CoroutineExceptionHandler fonctionne uniquement sur les coroutines racines (lancées directement sur un CoroutineScope).
    // À l'intérieur d'un supervisorScope ou coroutineScope, il est ignoré — les exceptions doivent être gérées avec try/catch localement.
    // 2 : coroutineScope renvoie une erreur pour tout les job si un est faux, et supervisorScope renvoie une erreur pour celui qui est faux mais fait quand meme fonctionner les autres.
    // 3 : Dans une vraie app Android, pour charger plusieurs sections d'un écran indépendamment j'utiliserais un supervisorScope.


}