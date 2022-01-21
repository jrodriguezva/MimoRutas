package com.jrodriguezva.mimorutas.androidApp.ui.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jrodriguezva.mimorutas.androidApp.ui.theme.AppTheme

@ExperimentalAnimationApi
@ExperimentalMaterial3Api
@Composable
fun Login(
    viewModel: LoginViewModel = viewModel(),
    onLoggedIn: () -> Unit = {},
    onClickSignUp: () -> Unit = {}
) {
    val state = viewModel.state

    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }

    val message = state.error?.let { stringResource(it) }

    LaunchedEffect(state.loggedIn) {
        if (state.loggedIn) {
            onLoggedIn()
        }
    }
    if (!state.loggedIn)
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("Welcome back!") },
                )
            },
            content = {
                Column(
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Bottom),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    Text(
                        modifier = Modifier.padding(top = 5.dp),
                        text = "Login to your account",  //usa stringResource(id = R.string...)
                        style = MaterialTheme.typography.displaySmall,
                        color = MaterialTheme.colorScheme.onBackground,
                    )

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text(text = "User name") }, //usa stringResource(id = R.string...)
                        value = userName,
                        isError = message != null,
                        onValueChange = {
                            userName = it
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = MaterialTheme.colorScheme.onBackground,
                            unfocusedLabelColor = MaterialTheme.colorScheme.onBackground,
                            textColor = MaterialTheme.colorScheme.onBackground
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    )

                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        label = { Text(text = "Password") }, //usa stringResource(id = R.string...)
                        value = password,
                        onValueChange = {
                            password = it
                        },
                        visualTransformation =
                        if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                        isError = message != null,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        trailingIcon = {
                            IconButton(onClick = { passwordHidden = !passwordHidden }) {
                                val visibilityIcon =
                                    if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                                // Please provide localized description for accessibility services
                                val description = if (passwordHidden) "Show password" else "Hide password"
                                Icon(
                                    imageVector = visibilityIcon,
                                    contentDescription = description,
                                    tint = MaterialTheme.colorScheme.onBackground
                                )
                            }
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = MaterialTheme.colorScheme.onBackground,
                            unfocusedLabelColor = MaterialTheme.colorScheme.onBackground,
                            textColor = MaterialTheme.colorScheme.onBackground
                        ),
                    )

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        shape = RoundedCornerShape(20.dp),
                        onClick = { viewModel.loginClicked(userName, password) }
                    ) {
                        Text(text = if (state.loading) "Loading" else "Login")  //usa stringResource(id = R.string...)
                    }

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp),
                        onClick = onClickSignUp
                    ) {
                        Text(text = "Sign up")  //usa stringResource(id = R.string...)
                    }

                    AnimatedVisibility(message != null) {
                        if (message != null) {
                            Text(
                                text = message,
                                color = MaterialTheme.colorScheme.error,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            })
}

@ExperimentalAnimationApi
@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewConversation() {
    AppTheme {
        Login()
    }
}

