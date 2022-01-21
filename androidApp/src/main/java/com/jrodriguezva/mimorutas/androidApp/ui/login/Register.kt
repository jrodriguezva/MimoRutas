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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jrodriguezva.mimorutas.androidApp.ui.theme.AppTheme


@ExperimentalAnimationApi
@ExperimentalMaterial3Api
@Composable
fun Register(
    viewModel: RegisterViewModel = viewModel(),
    onBackPressed: () -> Unit = {},
    onSignIn: () -> Unit = {},
) {

    val state = viewModel.state

    var email by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val message = state.error?.let { stringResource(it) }

    LaunchedEffect(state.loggedIn) {
        if (state.loggedIn) {
            onSignIn()
        }
    }


    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text("Create your account!") },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onBackground,
                        )
                    }
                })
        },
        content = {
            Column(
                modifier = Modifier.padding(24.dp, 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Text(
                    text = "Create your account!",  //usa stringResource(id = R.string...)
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.onBackground,
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "User name") }, //usa stringResource(id = R.string...)
                    value = userName,
                    onValueChange = {
                        userName = it
                    },
                    isError = message != null,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = MaterialTheme.colorScheme.onBackground,
                        unfocusedLabelColor = MaterialTheme.colorScheme.onBackground,
                        textColor = MaterialTheme.colorScheme.onBackground,
                    ),
                    shape = RoundedCornerShape(10.dp)
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Email") }, //usa stringResource(id = R.string...)
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    isError = viewModel.state.error != null,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = MaterialTheme.colorScheme.onBackground,
                        unfocusedLabelColor = MaterialTheme.colorScheme.onBackground,
                        textColor = MaterialTheme.colorScheme.onBackground,
                    ),
                    shape = RoundedCornerShape(10.dp)
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = { Text(text = "Password") }, //usa stringResource(id = R.string...)
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    isError = message != null,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = MaterialTheme.colorScheme.onBackground,
                        unfocusedLabelColor = MaterialTheme.colorScheme.onBackground,
                        textColor = MaterialTheme.colorScheme.onBackground,
                    ),
                    shape = RoundedCornerShape(10.dp)
                )


                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    onClick = { viewModel.registerClicked(userName, email, password) },
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = if (state.loading) "Loading" else "Register") //usa stringResource(id = R.string...)
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
fun PreviewRegister() {
    AppTheme {
        Register()
    }
}