package com.example.mobilecomputing

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class SettingsViewModel(
    private val dao: UserDao
): ViewModel() {
    private val _state = MutableStateFlow(UserState())

    fun onEvent(event: UserEvent) {
        if (event is UserEvent.SetUserName) {
            _state.update { it.copy(
                userName = event.userName
            ) }
        }
    }
}