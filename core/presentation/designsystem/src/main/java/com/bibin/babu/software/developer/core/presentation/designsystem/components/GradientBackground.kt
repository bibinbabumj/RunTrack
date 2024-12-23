package com.bibin.babu.software.developer.core.presentation.designsystem.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bibin.babu.software.developer.core.presentation.designsystem.RunTrackTheme

@Composable
fun GradientBackground(
    modifier: Modifier = Modifier,
    hasToolbar: Boolean = true,
    content: @Composable ColumnScope.() -> Unit
){


}

@Preview
@Composable
private fun GradientBackgroundPreview(){
    RunTrackTheme {
        GradientBackground (
            modifier = Modifier.fillMaxSize()
        ){

        }
    }
}
