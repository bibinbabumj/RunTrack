package com.bibin.babu.software.developer.auth.presentation.intro

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.bibin.babu.software.developer.core.presentation.designsystem.RunTrackTheme

@Composable
fun IntroScreenRoute(
    onSignUpClick: () -> Unit,
    onSignInClick: () -> Unit,
) {
    IntroScreen(onAction = { action ->
        when (action) {
            IntroAction.OnSignInClick -> onSignUpClick()
            IntroAction.OnSignUpClick -> onSignInClick()
        }

    })
}

@Composable
fun IntroScreen(
    onAction: (IntroAction) -> Unit,
) {

}

@Preview
@Composable
fun IntroScreenPreview() {
    RunTrackTheme {
        IntroScreen(onAction = {})
    }

}