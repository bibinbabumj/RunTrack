package com.bibin.babu.software.developer.auth.presentation.register

sealed interface RegisterAction {
    data object OnTogglePasswordVisibilityClick : RegisterAction
    data object OnRegisterClick : RegisterAction
    data object OnLoginClick : RegisterAction


}