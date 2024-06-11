package com.application.livrago.ui.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material3.Button
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.application.livrago.R

@Composable
fun Payment(
    navController: NavController
) {

    var selectedOption by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.livrago),
            contentDescription = null,
            modifier = Modifier
                .width(176.dp)
                .height(100.dp)
                .padding(top = 20.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Choisissez votre méthode de paiement",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            RadioButtonWithLabel(
                text = "Mobile Money",
                selected = selectedOption == "Mobile Money",
                onClick = { selectedOption = "Mobile Money" }
            )

            RadioButtonWithLabel(
                text = "Orange Money",
                selected = selectedOption == "Orange Money",
                onClick = { selectedOption = "Orange Money" }
            )

            RadioButtonWithLabel(
                text = "Carte bancaire",
                selected = selectedOption == "Carte bancaire",
                onClick = { selectedOption = "Carte bancaire" }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                      when(selectedOption){
                          "Mobile Money" -> navController.navigate("MobileMoney")
                          "Orange Money" -> navController.navigate("OrangeMoney")
                          "Carte bancaire" -> navController.navigate("carteBancaire")
                      }
            },

            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF904B)
            ),
        ) {
            Text(
                text = "Confirmer votre choix",
                color = Color.White
            )
        }
    }
}

@Composable
fun RadioButtonWithLabel(text: String,
                         selected: Boolean,
                         onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color(0xFFFF904B)
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, color = Color.Black)
    }
}
