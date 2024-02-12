package com.example.mobilecomputing

sealed interface UserEvent {
    object SaveUser: UserEvent
    data class SetUserName(val userName: String): UserEvent
}