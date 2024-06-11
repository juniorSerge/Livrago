package com.application.livrago.ui.composables

import android.util.Patterns
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.application.livrago.R
import com.application.livrago.domain.notifications.Dialog
import com.application.livrago.domain.notifications.NotificationService
import kotlinx.coroutines.delay

@Composable
fun CourseLivraison(
    navController: NavController
) {
    var selectedPickupAddress by remember {mutableStateOf<String?>(null) }
    var selectedDestinationAddress by remember { mutableStateOf<String?>(null) }
    var expandedPickup by remember { mutableStateOf(false) }
    var expandedDestination by remember { mutableStateOf(false)}
    var DestinatairePhone by remember { mutableStateOf("") }
    var clientPhone by remember { mutableStateOf("") }
    var pickupDetails by remember { mutableStateOf("") }
    var showNotificationService by remember { mutableStateOf(false) }
    var showNOTESService by remember { mutableStateOf(false) }
    var showErrorDialog by remember { mutableStateOf(false) }
    val addresses = listOf(
        "Bonanjo",
        "Akwa",
        "Bonapriso",
        "Deido",
        "Logbaba",
        "Bonamoussadi",
        "Makepe",
        "Bali",
        "Ndokoti",
        "New Bell",
        "Bepanda",
        "Nylon",
        "Bonaberi",
        "Cité des Palmiers",
        "Kotto",
        "Nyalla",
        "Mbanga-Bakoko",
        "Ndogpassi",
        "Brazzaville",
        "Ndogbong"
    )
    val amountMapping = mapOf(
        "Bonanjo" to mapOf(
            "Bonanjo" to 0, "Akwa" to 150, "Bonapriso" to 200, "Deido" to 250, "Logbaba" to 300,
            "Bonamoussadi" to 350, "Makepe" to 400, "Bali" to 450, "Ndokoti" to 500, "New Bell" to 550,
            "Bepanda" to 600, "Nylon" to 650, "Bonaberi" to 700, "Cité des Palmiers" to 750, "Kotto" to 800,
            "Nyalla" to 850, "Mbanga-Bakoko" to 900, "Ndogpassi" to 950, "Brazzaville" to 1000, "Ndogbong" to 1050
        ),
        "Akwa" to mapOf(
            "Bonanjo" to 150, "Akwa" to 0, "Bonapriso" to 100, "Deido" to 150, "Logbaba" to 200,
            "Bonamoussadi" to 250, "Makepe" to 300, "Bali" to 350, "Ndokoti" to 400, "New Bell" to 450,
            "Bepanda" to 500, "Nylon" to 550, "Bonaberi" to 600, "Cité des Palmiers" to 650, "Kotto" to 700,
            "Nyalla" to 750, "Mbanga-Bakoko" to 800, "Ndogpassi" to 850, "Brazzaville" to 900, "Ndogbong" to 950
        ),
        "Bonapriso" to mapOf(
            "Bonanjo" to 200, "Akwa" to 100, "Bonapriso" to 0, "Deido" to 150, "Logbaba" to 200,
            "Bonamoussadi" to 250, "Makepe" to 300, "Bali" to 350, "Ndokoti" to 400, "New Bell" to 450,
            "Bepanda" to 500, "Nylon" to 550, "Bonaberi" to 600, "Cité des Palmiers" to 650, "Kotto" to 700,
            "Nyalla" to 750, "Mbanga-Bakoko" to 800, "Ndogpassi" to 850, "Brazzaville" to 900, "Ndogbong" to 950
        ),
        "Deido" to mapOf(
            "Bonanjo" to 250, "Akwa" to 150, "Bonapriso" to 150, "Deido" to 0, "Logbaba" to 200,
            "Bonamoussadi" to 250, "Makepe" to 300, "Bali" to 350, "Ndokoti" to 400, "New Bell" to 450,
            "Bepanda" to 500, "Nylon" to 550, "Bonaberi" to 600, "Cité des Palmiers" to 650, "Kotto" to 700,
            "Nyalla" to 750, "Mbanga-Bakoko" to 800, "Ndogpassi" to 850, "Brazzaville" to 900, "Ndogbong" to 950
        ),
        "Logbaba" to mapOf(
            "Bonanjo" to 300, "Akwa" to 200, "Bonapriso" to 200, "Deido" to 200, "Logbaba" to 0,
            "Bonamoussadi" to 250, "Makepe" to 300, "Bali" to 350, "Ndokoti" to 400, "New Bell" to 450,
            "Bepanda" to 500, "Nylon" to 550, "Bonaberi" to 600, "Cité des Palmiers" to 650, "Kotto" to 700,
            "Nyalla" to 750, "Mbanga-Bakoko" to 800, "Ndogpassi" to 850, "Brazzaville" to 900, "Ndogbong" to 950
        ),
        "Bonamoussadi" to mapOf(
            "Bonanjo" to 350, "Akwa" to 250, "Bonapriso" to 250, "Deido" to 250, "Logbaba" to 250,
            "Bonamoussadi" to 0, "Makepe" to 100, "Bali" to 150, "Ndokoti" to 200, "New Bell" to 250,
            "Bepanda" to 300, "Nylon" to 350, "Bonaberi" to 400, "Cité des Palmiers" to 450, "Kotto" to 500,
            "Nyalla" to 550, "Mbanga-Bakoko" to 600, "Ndogpassi" to 650, "Brazzaville" to 700, "Ndogbong" to 750
        ),
        "Makepe" to mapOf(
            "Bonanjo" to 400, "Akwa" to 300, "Bonapriso" to 300, "Deido" to 300, "Logbaba" to 300,
            "Bonamoussadi" to 100, "Makepe" to 0, "Bali" to 100, "Ndokoti" to 150, "New Bell" to 200,
            "Bepanda" to 250, "Nylon" to 300, "Bonaberi" to 350, "Cité des Palmiers" to 400, "Kotto" to 450,
            "Nyalla" to 500, "Mbanga-Bakoko" to 550, "Ndogpassi" to 600, "Brazzaville" to 650, "Ndogbong" to 700
        ),
        "Bali" to mapOf(
            "Bonanjo" to 450, "Akwa" to 350, "Bonapriso" to 350, "Deido" to 350, "Logbaba" to 350,
            "Bonamoussadi" to 150, "Makepe" to 100, "Bali" to 0, "Ndokoti" to 100, "New Bell" to 150,
            "Bepanda" to 200, "Nylon" to 250, "Bonaberi" to 300, "Cité des Palmiers" to 350, "Kotto" to 400,
            "Nyalla" to 450, "Mbanga-Bakoko" to 500, "Ndogpassi" to 550, "Brazzaville" to 600, "Ndogbong" to 650
        ),
        "Ndokoti" to mapOf(
            "Bonanjo" to 500, "Akwa" to 400, "Bonapriso" to 400, "Deido" to 400, "Logbaba" to 400,
            "Bonamoussadi" to 200, "Makepe" to 150, "Bali" to 100, "Ndokoti" to 0, "New Bell" to 100,
            "Bepanda" to 150, "Nylon" to 200, "Bonaberi" to 250, "Cité des Palmiers" to 300, "Kotto" to 350,
            "Nyalla" to 400, "Mbanga-Bakoko" to 450, "Ndogpassi" to 500, "Brazzaville" to 550, "Ndogbong" to 600
        ),
        "New Bell" to mapOf(
            "Bonanjo" to 550, "Akwa" to 450, "Bonapriso" to 450, "Deido" to 450, "Logbaba" to 450,
            "Bonamoussadi" to 250, "Makepe" to 200, "Bali" to 150, "Ndokoti" to 100, "New Bell" to 0,
            "Bepanda" to 100, "Nylon" to 150, "Bonaberi" to 200, "Cité des Palmiers" to 250, "Kotto" to 300,
            "Nyalla" to 350, "Mbanga-Bakoko" to 400, "Ndogpassi" to 450, "Brazzaville" to 500, "Ndogbong" to 550
        ),
        "Bepanda" to mapOf(
            "Bonanjo" to 600, "Akwa" to 500, "Bonapriso" to 500, "Deido" to 500, "Logbaba" to 500,
            "Bonamoussadi" to 300, "Makepe" to 250, "Bali" to 200, "Ndokoti" to 150, "New Bell" to 100,
            "Bepanda" to 0, "Nylon" to 100, "Bonaberi" to 150, "Cité des Palmiers" to 200, "Kotto" to 250,
            "Nyalla" to 300, "Mbanga-Bakoko" to 350, "Ndogpassi" to 400, "Brazzaville" to 450, "Ndogbong" to 500
        ),
        "Nylon" to mapOf(
            "Bonanjo" to 650, "Akwa" to 550, "Bonapriso" to 550, "Deido" to 550, "Logbaba" to 550,
            "Bonamoussadi" to 350, "Makepe" to 300, "Bali" to 250, "Ndokoti" to 200, "New Bell" to 150,
            "Bepanda" to 100, "Nylon" to 0, "Bonaberi" to 100, "Cité des Palmiers" to 150, "Kotto" to 200,
            "Nyalla" to 250, "Mbanga-Bakoko" to 300, "Ndogpassi" to 350, "Brazzaville" to 400, "Ndogbong" to 450
        ),
        "Bonaberi" to mapOf(
            "Bonanjo" to 700, "Akwa" to 600, "Bonapriso" to 600, "Deido" to 600, "Logbaba" to 600,
            "Bonamoussadi" to 400, "Makepe" to 350, "Bali" to 300, "Ndokoti" to 250, "New Bell" to 200,
            "Bepanda" to 150, "Nylon" to 100, "Bonaberi" to 0, "Cité des Palmiers" to 100, "Kotto" to 150,
            "Nyalla" to 200, "Mbanga-Bakoko" to 250, "Ndogpassi" to 300, "Brazzaville" to 350, "Ndogbong" to 400
        ),
        "Cité des Palmiers" to mapOf(
            "Bonanjo" to 750, "Akwa" to 650, "Bonapriso" to 650, "Deido" to 650, "Logbaba" to 650,
            "Bonamoussadi" to 450, "Makepe" to 400, "Bali" to 350, "Ndokoti" to 300, "New Bell" to 250,
            "Bepanda" to 200, "Nylon" to 150, "Bonaberi" to 100, "Cité des Palmiers" to 0, "Kotto" to 100,
            "Nyalla" to 150, "Mbanga-Bakoko" to 200, "Ndogpassi" to 250, "Brazzaville" to 300, "Ndogbong" to 350
        ),
        "Kotto" to mapOf(
            "Bonanjo" to 800, "Akwa" to 700, "Bonapriso" to 700, "Deido" to 700, "Logbaba" to 700,
            "Bonamoussadi" to 500, "Makepe" to 450, "Bali" to 400, "Ndokoti" to 350, "New Bell" to 300,
            "Bepanda" to 250, "Nylon" to 200, "Bonaberi" to 150, "Cité des Palmiers" to 100, "Kotto" to 0,
            "Nyalla" to 100, "Mbanga-Bakoko" to 150, "Ndogpassi" to 200, "Brazzaville" to 250, "Ndogbong" to 300
        ),
        "Nyalla" to mapOf(
            "Bonanjo" to 850, "Akwa" to 750, "Bonapriso" to 750, "Deido" to 750, "Logbaba" to 750,
            "Bonamoussadi" to 550, "Makepe" to 500, "Bali" to 450, "Ndokoti" to 400, "New Bell" to 350,
            "Bepanda" to 300, "Nylon" to 250, "Bonaberi" to 200, "Cité des Palmiers" to 150, "Kotto" to 100,
            "Nyalla" to 0, "Mbanga-Bakoko" to 100, "Ndogpassi" to 150, "Brazzaville" to 200, "Ndogbong" to 250
        ),
        "Mbanga-Bakoko" to mapOf(
            "Bonanjo" to 900, "Akwa" to 800, "Bonapriso" to 800, "Deido" to 800, "Logbaba" to 800,
            "Bonamoussadi" to 600, "Makepe" to 550, "Bali" to 500, "Ndokoti" to 450, "New Bell" to 400,
            "Bepanda" to 350, "Nylon" to 300, "Bonaberi" to 250, "Cité des Palmiers" to 200, "Kotto" to 150,
            "Nyalla" to 100, "Mbanga-Bakoko" to 0, "Ndogpassi" to 100, "Brazzaville" to 150, "Ndogbong" to 200
        ),
        "Ndogpassi" to mapOf(
            "Bonanjo" to 950, "Akwa" to 850, "Bonapriso" to 850, "Deido" to 850, "Logbaba" to 850,
            "Bonamoussadi" to 650, "Makepe" to 600, "Bali" to 550, "Ndokoti" to 500, "New Bell" to 450,
            "Bepanda" to 400, "Nylon" to 350, "Bonaberi" to 300, "Cité des Palmiers" to 250, "Kotto" to 200,
            "Nyalla" to 150, "Mbanga-Bakoko" to 100, "Ndogpassi" to 0, "Brazzaville" to 100, "Ndogbong" to 150
        ),
        "Brazzaville" to mapOf(
            "Bonanjo" to 1000, "Akwa" to 900, "Bonapriso" to 900, "Deido" to 900, "Logbaba" to 900,
            "Bonamoussadi" to 700, "Makepe" to 650, "Bali" to 600, "Ndokoti" to 550, "New Bell" to 500,
            "Bepanda" to 450, "Nylon" to 400, "Bonaberi" to 350, "Cité des Palmiers" to 300, "Kotto" to 250,
            "Nyalla" to 200, "Mbanga-Bakoko" to 150, "Ndogpassi" to 100, "Brazzaville" to 0, "Ndogbong" to 100
        ),
        "Ndogbong" to mapOf(
            "Bonanjo" to 1050, "Akwa" to 950, "Bonapriso" to 950, "Deido" to 950, "Logbaba" to 950,
            "Bonamoussadi" to 750, "Makepe" to 700, "Bali" to 650, "Ndokoti" to 600, "New Bell" to 550,
            "Bepanda" to 500, "Nylon" to 450, "Bonaberi" to 400, "Cité des Palmiers" to 350, "Kotto" to 300,
            "Nyalla" to 250, "Mbanga-Bakoko" to 200, "Ndogpassi" to 150, "Brazzaville" to 100, "Ndogbong" to 0
        )
    )
    var showDialog by remember { mutableStateOf(false) }
    var showDialogNotesService by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }


    val amount = amountMapping[selectedPickupAddress]?.get(selectedDestinationAddress) ?: 0


    fun validateFields(): Boolean {
        if (selectedPickupAddress.isNullOrBlank() ||
            selectedDestinationAddress.isNullOrBlank() ||
            clientPhone.isBlank()
            || DestinatairePhone.isBlank())
        {
            errorMessage = "Veuillez remplir tous les champs."
            return false
        }

        val phoneRegex = Regex("^6[0-9]{8}\$")
        if (!phoneRegex.matches(clientPhone) || !phoneRegex.matches(DestinatairePhone))
        {
            errorMessage = "Veuillez saisir un numéro de téléphone valide."
            return false
        }

        if(clientPhone == DestinatairePhone)
        {
            errorMessage = "Comment la destination est egale a la source ?? Impossible."
            return false
        }

        if(selectedPickupAddress == selectedDestinationAddress)
        {
            errorMessage = "Comment la destination est egale a la source ?? Impossible."
            return false
        }

        return true
    }


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
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Course de livraison",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(20.dp))


        Text(
            text = "Veuillez renseignez les informations de votre course",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(20.dp))


        Text(
            text = " Adresse de recuperation du colis  ",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            OutlinedButton(onClick = { expandedPickup = !expandedPickup }) {
                Text(text = selectedPickupAddress ?: "Sélectionnez l'adresse de récupération")
            }
            DropdownMenu(
                expanded = expandedPickup,
                onDismissRequest = { expandedPickup = false }
            ) {
                addresses.forEach { address ->
                    DropdownMenuItem(
                        text = { Text(text = address) },
                        onClick = {
                            selectedPickupAddress = address
                            expandedPickup = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = clientPhone,
            onValueChange = { clientPhone = it },
            label = { Text("Numero de l'expediteur") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Adresse de destination  ",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            OutlinedButton(onClick = { expandedDestination = !expandedDestination })
            {
                Text(text = selectedDestinationAddress ?: "Sélectionnez l'adresse de destination")
            }
            DropdownMenu(
                expanded = expandedDestination,
                onDismissRequest = { expandedDestination = false }
            ) {
                addresses.forEach { address ->
                    DropdownMenuItem(
                        text = { Text(text = address) },
                        onClick = {
                            selectedDestinationAddress = address
                            expandedDestination = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = DestinatairePhone,
            onValueChange = { DestinatairePhone = it },
            label = { Text("Numero du destinataire") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))


        OutlinedTextField(
            value = pickupDetails,
            onValueChange = { pickupDetails = it },
            label = { Text(stringResource(id = R.string.details_hint)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )


        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Montant: $amount" + " FCFA" ,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )


        if (showErrorDialog) {
            AlertDialog(
                onDismissRequest = { showErrorDialog = false },
                title = { Text(text = "Erreur-livrago") },
                text = { Text(text = errorMessage) },
                confirmButton = {
                    Button(
                        onClick = { showErrorDialog = false },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF904B)
                        )
                    ) {
                        Text(text = "OK", color = MaterialTheme.colorScheme.primary)
                    }
                },

                dismissButton = null
            )
        }


        Spacer(modifier = Modifier.height(40.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Button(
                onClick = {
                    if (validateFields()) {
                        showDialog = true
                    } else {
                        showErrorDialog = true
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF904B)
                )
            ) {
                Text(
                    text = "Commander",
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.help_text),
            modifier = Modifier
                .padding(bottom = 20.dp)
                .clickable {
                    navController.navigate("home")
                },
            color = MaterialTheme.colorScheme.onBackground
        )

        if (showDialog) {
            CustomDialog(onDismiss = { showDialog = false },
                onValider = {
                    showNotificationService = true
                    showDialog = false
                }
            )
        }

        if (showNotificationService) {
            NotificationService()
            showNotificationService = false
            showNOTESService = true
        }

        if (showNOTESService) {
            LaunchedEffect(Unit) {
                delay(15000L)
                showDialogNotesService = true
            }
        }

        if (showDialogNotesService) {
            Dialog( onDismiss = {  showNOTESService = false
                showDialogNotesService = false
                navController.navigate("payements")
            })
        }

    }
}



