package com.example.kotlinlearning.test1

data class KotlinUserProfile(val name : String, val email : String, val phoneNumber : String?){


    fun getDisplayInfo() : String{
        return ("$name - $email - ${phoneNumber ?: "pas de téléphone"}")
    }

    fun getPhoneLength() : Int {
        val phoneLength = phoneNumber?.length ?: 0
        return phoneLength
    }
}