package com.application.livrago.ui.screen.personnal


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.application.livrago.R

@Composable
fun Empreinte(navController: NavController) {

    Column(
        Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .background(color = Color(android.graphics.Color.parseColor("#ececec"))),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            val (topImg, button) = createRefs()

            Image(
                painterResource(id = R.drawable.empreintedigitale),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(topImg) {
                        top.linkTo(parent.top, 290.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

            Button(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .constrainAs(button) {
                        bottom.linkTo(parent.bottom, -390.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)

                    }
                    .padding(start = 32.dp, end = 32.dp, top = 26.dp, bottom = 16.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(android.graphics.Color.parseColor("#ff8000"))
                ),
                shape = RoundedCornerShape(15)
            ) {
                Text(
                    text = "enregistrer votre empreinte",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Button(
                onClick = { /* TODO */ },
                Modifier

                    .fillMaxWidth()
                    .padding(start = 0.dp, end = 0.dp, top = 0.dp, bottom = 0.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor =Color(android.graphics.Color.parseColor("#ff8000"))
                ),
                shape = RoundedCornerShape(15)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painterResource(id = R.drawable.retour),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 80.dp)
                            .clickable {
                                navController.navigate("compte_utilisateur")
                            }

                    )
                    Text(
                        text = "Empreintes",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight= FontWeight.Bold
                    )
                }

            }
        }

    }
    }

