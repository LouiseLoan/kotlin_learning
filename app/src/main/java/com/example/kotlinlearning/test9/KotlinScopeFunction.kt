package com.example.kotlinlearning.test9

data class Config(
    var baseUrl: String = "",
    var timeout: Int = 0,
    var isDebug: Boolean = false
)

val config = Config().apply {
    baseUrl = "http//test"
    timeout = 0
    isDebug = false
}.also {
    println("config added : $it")
}

fun main(){

    config

    val url: String? = null
    url?.let {
        println("URL : $it")
    }
}