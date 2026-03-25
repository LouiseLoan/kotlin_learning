package com.example.kotlinlearning.test7

data class Session(val userId: String, val token: String, val isActive: Boolean){
    companion object {
        fun createGuest(): Session {
            return Session("guest", "none",false)
        }
    }
}

object SessionManager{
    val sessionList = mutableListOf<Session>()

    fun addSession(session: Session){
        sessionList.add(session)
    }
}

fun main(){
    val session1 = Session("loan123", "abc", true)
    val session2 = Session("bob", "xyz", false)

    SessionManager.addSession(session1)
    SessionManager.addSession(session2)

    val guestSession = Session.createGuest()
    SessionManager.addSession((guestSession))

    println(SessionManager.sessionList)
}