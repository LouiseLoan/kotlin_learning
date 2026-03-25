package com.example.kotlinlearning.test6

data class User(val name: String, val age: Int, val isPremium: Boolean)

/**
 *  1. Afficher seulement les utilisateurs majeurs (age >= 18)
 *   2. Afficher seulement les utilisateurs premium
 *   3. Afficher seulement les utilisateurs majeurs ET premium
 */

fun main() {
    val users = listOf(
        User("Loan", 25, true),
        User("Alice", 17, false),
        User("Bob", 32, true),
        User("Clara", 15, false),
        User("Marc", 28, false)
    )

    fun filterWithCondition(list: List<User>, condition: (User) -> Boolean): List<User> {
        var filteredList: List<User> = emptyList()
        for (u in list){
            if (condition(u)){
                filteredList = filteredList.plus(u)
            }
        }
        return filteredList
    }

    val result18plus = filterWithCondition(users, {u -> u.age >= 18})
    val resultPremiumOnly = filterWithCondition(users, {u -> u.isPremium})
    val resultBoth = filterWithCondition(users, {u -> u.isPremium && u.age >= 18})

    println(result18plus)
    println(resultPremiumOnly)
    println(resultBoth)
}