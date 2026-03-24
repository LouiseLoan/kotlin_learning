package com.example.kotlinlearning.test3

import com.example.kotlinlearning.test3.KotlinNetworkResult.Success
import com.example.kotlinlearning.test4.isValidEmail

sealed class KotlinNetworkResult {
    data class Success(val data: String) : KotlinNetworkResult()
    data class Error(val message: String, val code: Int) : KotlinNetworkResult()

    fun handle(result: KotlinNetworkResult){
        when(result){
            is Success -> println("data = ${result.data}")
            is KotlinNetworkResult.Error -> println("Erreur ${result.code} : ${result.message}")
        }
    }
}