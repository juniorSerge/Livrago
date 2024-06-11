package com.application.livrago.ui.composables

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.application.livrago.R
import com.application.livrago.ui.composables.Routes

@Composable
fun RegisterScreen(navController: NavController) {

    var fullName by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    var showErrorDialog by remember { mutableStateOf(false) }

    fun validateFields(): Boolean {
        if (fullName.isBlank() || phoneNumber.isBlank() || email.isBlank()
            || password.isBlank()) {
            errorMessage = "Veuillez remplir tous les champs."
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            errorMessage = "Veuillez saisir une adresse email valide."
            return false
        }
        val phoneRegex = Regex("^6[0-9]{8}\$")
        if (!phoneRegex.matches(phoneNumber)) {
            errorMessage = "Veuillez saisir un numéro de téléphone valide."
            return false
        }

        if (password.length < 6) {
            errorMessage = "Le mot de passe doit contenir au moins 6 caractères."
            return false
        }
        return true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(150.dp)
                .padding(top = 20.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Hello, Inscrivez-vous",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = fullName,
            onValueChange = { fullName = it },
            label = { Text("Nom complet") },
            leadingIcon = {
                Image(painterResource(id = R.drawable.person),
                    contentDescription = "Person Icon")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Téléphone") },
            leadingIcon = {
                Image(painterResource(id = R.drawable.phone),
                    contentDescription = "Phone Icon")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Adresse email") },
            leadingIcon = {
                Image(painterResource(id = R.drawable.calendar_icon),
                    contentDescription = "Calendar Icon")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Mot de passe") },
            leadingIcon = {
                Image(painterResource(id = R.drawable.lock),
                    contentDescription = "Lock Icon")
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                if (validateFields()) {
                    // viewModel.addUser(fullName, phoneNumber, email, password)
                    fullName = ""
                    phoneNumber = ""
                    email = ""
                    password = ""
                    navController.navigate(Routes.loginScreen)
                } else {
                    showErrorDialog = true
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF904B)
            ),
        ) {
            Text(text = "Inscription", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Ou alors, Connectez vous",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {
                    navController.navigate(Routes.loginScreen)
                }
        )

        if (showErrorDialog) {
            AlertDialog(
                onDismissRequest = { showErrorDialog = false },
                title = { Text(text = "Erreur") },
                text = { Text(text = errorMessage) },
                confirmButton = {
                    Button(
                        onClick = { showErrorDialog = false },
                        colors = ButtonDefaults.buttonColors(Color.Transparent)
                    ) {
                        Text(text = "OK",
                            color = MaterialTheme.colorScheme.primary)
                    }
                },
                dismissButton = null
            )
        }
    }
}
