package com.application.livrago.ui.composables

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun LoginScreen(navController: NavController) {


    var password by remember {
        mutableStateOf("")
    }

    var phoneNumber by remember {
        mutableStateOf("")
    }

    var errorMessage by remember { mutableStateOf("") }
    var showErrorDialog by remember { mutableStateOf(false) }



    fun validateFields(): Boolean {
        if ( phoneNumber.isBlank() || password.isBlank()) {
            errorMessage = "Veuillez remplir tous les champs."
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
        modifier  = Modifier.fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Image(
            painter = painterResource(id = R.drawable.log_livrago),
            contentDescription ="logo de login",
            modifier = Modifier.size(150.dp)
        )
        Text(
            text = "Bienvenue chez Livrago !",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Connexion a votre compte "
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Numéro de Téléphone") },
            leadingIcon = {
                Image(painterResource(id = R.drawable.phone),
                    contentDescription = "Phone Icon")
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

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (validateFields()) {
                // connexion a  la base de données firebase
                //  connectUserData(userName, email, password)
                phoneNumber = ""
                password = ""
                navController.navigate("Dashboard")
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
            Text(text = "Connexion")
        }

        if (showErrorDialog) {
            AlertDialog(
                onDismissRequest = { showErrorDialog = false },
                title = { Text(text = "Erreur-livrago") },
                text = { Text(text = errorMessage) },
                confirmButton = {
                    Button(
                        onClick = { showErrorDialog = false },
                        colors = ButtonDefaults.buttonColors(Color.Transparent)
                    ) {
                        Text(text = "OK", color = MaterialTheme.colorScheme.primary)
                    }
                },
                dismissButton = null
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Mot de passe oublie ?",
            modifier = Modifier.clickable {}
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Nouveau chez keyce ? S'incrire",
            modifier = Modifier.clickable {
                navController.navigate(Routes.registerScreen)
            }
        )

        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = " Ou connectez vous avec"
        )

        Row(
           modifier = Modifier
               .fillMaxWidth()
               .padding(20.dp),
               horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "logo facebook",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        //facebook clickable
                        navController.navigate("signin")
                    }
            )


            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "logo google",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        navController.navigate("signin")
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.twitter),
                contentDescription = "logo twitter",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        //twitter clickable
                        navController.navigate("signin")
                    }
            )
        }

    }
}