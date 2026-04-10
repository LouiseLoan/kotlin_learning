package com.example.kotlinlearning.test14

fun <T> safeGet(list : List<T>, index : Int) : T? {
    return if (index < 0 || index >= list.size) null
    else list[index]
}

fun <T : Number> sum(list: List<T>): Double {
    return list.sumOf { it.toDouble() }
}

inline fun <reified T> filterByType(list: List<Any>): List<T> {
    return list.filter { it is T }.map { it as T }
}


fun main(){
    val listTest = listOf(1,2,3,4,5)
    val mixedListTest = listOf(1,2,3, "un", "deux", "trois")

    println(safeGet(listTest,4))

    println(sum(listTest))

    println(filterByType<String>(mixedListTest))
}