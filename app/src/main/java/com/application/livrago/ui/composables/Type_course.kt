package com.application.livrago.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.ButtonDefaults
import androidx.navigation.NavController
import com.application.livrago.R

@Composable
fun Type_course(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(id = R.string.app_logo),
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = stringResource(id = R.string.welcome_message),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "", // Placeholder for username
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.ride_type_question),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(80.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { navController.navigate("moto_taxi") },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF904B)
                )
            ) {
                Text(
                    text = stringResource(id = R.string.button1_text),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }



            Button(
                onClick = {  navController.navigate("course_livraison") },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF904B)
                ),
            ) {
                Text(
                    text = stringResource(id = R.string.button2_text),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }



        Spacer(modifier = Modifier.weight(1f))


        Text(
            text = stringResource(id = R.string.help_text),
            modifier = Modifier
                .clickable {
                    navController.navigate("home")
                }
                .padding(bottom = 20.dp),
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}