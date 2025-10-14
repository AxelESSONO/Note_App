package fr.dawan.noteapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.dawan.noteapp.ui.theme.Background

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun AuthScreen(
    onLogin : (String, String) -> Unit = { _, _ -> }
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val onEmailChange = { text : String ->
        email = text
    }
    val onPasswordChange = {text : String ->
        password = text
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 30.dp,
            alignment = Alignment.CenterVertically
        )
    ) {
        TextField(
            value = email,
            onValueChange = onEmailChange,
            label = { Text(text = "Email") },
            modifier = Modifier
                .fillMaxWidth(0.85f),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        TextField(
            value = password,
            onValueChange = onPasswordChange,
            label = { Text(text = "Password") },
            modifier = Modifier
                .fillMaxWidth(0.85f),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )

        Button(
            onClick = {
                onLogin(email, password)
            },
            modifier = Modifier
                .fillMaxWidth(0.85f)
        ) {
            Text(text = "Login")
        }

    }
}