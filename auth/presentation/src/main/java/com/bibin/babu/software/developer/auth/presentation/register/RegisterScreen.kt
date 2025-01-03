package com.bibin.babu.software.developer.auth.presentation.register

import GradientBackground
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bibin.babu.software.developer.auth.domain.PasswordValidationState
import com.bibin.babu.software.developer.auth.domain.UserDataValidator
import com.bibin.babu.software.developer.auth.presentation.R
import com.bibin.babu.software.developer.core.presentation.designsystem.CheckIcon
import com.bibin.babu.software.developer.core.presentation.designsystem.CrossIcon
import com.bibin.babu.software.developer.core.presentation.designsystem.EmailIcon
import com.bibin.babu.software.developer.core.presentation.designsystem.Poppins
import com.bibin.babu.software.developer.core.presentation.designsystem.RunTrackTheme
import com.bibin.babu.software.developer.core.presentation.designsystem.RuntrackGray
import com.bibin.babu.software.developer.core.presentation.designsystem.RuntrackGreen
import com.bibin.babu.software.developer.core.presentation.designsystem.RuntrackRed
import com.bibin.babu.software.developer.core.presentation.designsystem.components.RunTrackActionButton
import com.bibin.babu.software.developer.core.presentation.designsystem.components.RunTrackPasswordTextField
import com.bibin.babu.software.developer.core.presentation.designsystem.components.RunTrackTextField
import org.koin.androidx.compose.koinViewModel

@Composable
fun RegisterScreenRoot(
    onSignInClick: () -> Unit,
    onSuccessfulRegistration: () -> Unit,
    viewModel: RegisterViewModel = koinViewModel()
) {
    RegisterScreen(
        state = viewModel.state,
        onAction = viewModel::onAction
    )

}

@Composable
private fun RegisterScreen(
    state: RegisterState,
    onAction: (RegisterAction) -> Unit
) {

    GradientBackground {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 32.dp)
                .padding(top = 8.dp)


        ) {

            Text(
                text = stringResource(id = R.string.create_account),
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(8.dp))


            val annotatedString = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontFamily = Poppins,
                        color = RuntrackGray
                    )
                ) {
                    append(stringResource(id = R.string.already_have_account) + " ")
                    pushStringAnnotation(
                        tag = "clickable_text",
                        annotation = stringResource(id = R.string.login)
                    )

                    withLink(
                        link = LinkAnnotation.Clickable(
                            tag = "clickable_text",
                            linkInteractionListener = {
                                onAction(RegisterAction.OnLoginClick)
                            }
                        )
                    ) {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = Poppins,
                                color = MaterialTheme.colorScheme.primary
                            )
                        ) {
                            append(stringResource(id = R.string.login))
                        }
                    }
                }
            }

            Text(text = annotatedString)
            Spacer(modifier = Modifier.height(48.dp))
            RunTrackTextField(
                state = state.email,
                startIcon = EmailIcon,
                endIcon = if (state.isEmailValid) {
                    CheckIcon
                } else null,
                hint = stringResource(id = R.string.example_email),
                title = stringResource(id = R.string.email),
                modifier = Modifier.fillMaxWidth(),
                additionalInfo = stringResource(id = R.string.must_be_a_valid_email),
                keyboardType = KeyboardType.Email
            )
            Spacer(modifier = Modifier.height(16.dp))

            RunTrackPasswordTextField(
                state = state.password,
                onTogglePasswordVisibility = { RegisterAction.OnTogglePasswordVisibilityClick },
                title = stringResource(id = R.string.password),
                hint = stringResource(id = R.string.password),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            PasswordRequirement(
                text = stringResource(
                    id = R.string.at_least_x_characters,
                    UserDataValidator.MIN_PASSWORD_LENGTH
                ), isValid = state.passwordValidationState.hasMinLength
            )
            Spacer(modifier = Modifier.height(8.dp))
            PasswordRequirement(
                text = stringResource(id = R.string.at_least_one_number),
                isValid = state.passwordValidationState.hasNumber
            )
            Spacer(modifier = Modifier.height(8.dp))
            PasswordRequirement(
                text = stringResource(id = R.string.contain_lower_case),
                isValid = state.passwordValidationState.hasLowercaseCharacter
            )
            Spacer(modifier = Modifier.height(8.dp))
            PasswordRequirement(
                text = stringResource(id = R.string.conatin_upper_case),
                isValid = state.passwordValidationState.hasUppercaseCharacter
            )

            Spacer(modifier = Modifier.width(32.dp))

            RunTrackActionButton(text = stringResource(id = R.string.register),
                isLoading = state.isRegistering,
                enabled = state.canRegister,
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    onAction(RegisterAction.OnRegisterClick)
                })
        }

    }


}

@Composable
private fun PasswordRequirement(
    text: String,
    isValid: Boolean,
    modifier: Modifier = Modifier

) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = if (isValid) {
                CheckIcon
            } else {
                CrossIcon
            }, contentDescription = null,
            tint = if (isValid) {
                RuntrackGreen
            } else {
                RuntrackRed
            }
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 12.sp)


    }
}

@Preview
@Composable
private fun RegisterScreenPreview() {

    RunTrackTheme {
        RegisterScreen(
            state = RegisterState(
                passwordValidationState = PasswordValidationState(
                    hasMinLength = true,
                    hasNumber = true,
                    hasLowercaseCharacter = true,
                    hasUppercaseCharacter = true
                )
            ),
            onAction = {}
        )

    }

}



