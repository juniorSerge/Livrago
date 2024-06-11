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
import androidx.compose.foundation.layout.size
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
import com.application.livrago.R

@Preview(showBackground = true)
@Composable
fun InfoLivreur() {
    Column(
        Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .background(color = Color(android.graphics.Color.parseColor("#ececec"))),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ConstraintLayout(){
            val (topImg, profile, retour)=createRefs()
            Image(
                painterResource(id = R.drawable.telechargements),null,
                Modifier
                    .fillMaxWidth()
                    .constrainAs(topImg) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .size(width = 400.dp, height = 185.dp)
            )
            Image(
                painterResource(id = R.drawable.profile),null,
                Modifier

                    .constrainAs(profile) {
                        top.linkTo(topImg.bottom)
                        bottom.linkTo(topImg.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)

                    }

            )
            Image(
                painterResource(id = R.drawable.retour),null,
                Modifier
                    .constrainAs(retour) {

                        top.linkTo(parent.top)
                        start.linkTo(parent.start)

                    }
                    .size(width = 40.dp, height = 40.dp)

            )

        }
        Text(text = "LIVREUR",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top=16.dp),
            color= Color(android.graphics.Color.parseColor("#747679"))

        )
        Text(text = "DETAILS DU LIVREUR",
            fontSize = 20.sp,
            color= Color(android.graphics.Color.parseColor("#747679"))

        )
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 10.dp)
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = androidx.compose.ui.graphics.Color.White
            ),
            shape = RoundedCornerShape(15)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painterResource(id = R.drawable.utilisateur),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 35.dp)
                        .clickable {}
                )
                Text(
                    text = "FOTSO",
                    color = androidx.compose.ui.graphics.Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 10.dp)
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = androidx.compose.ui.graphics.Color.White
            ),
            shape = RoundedCornerShape(15)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painterResource(id = R.drawable.utilisateur),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 35.dp) // Ajoute un espace entre l'image et le texte
                        .clickable {}
                )
                Text(
                    text = "YVAN",
                    color = androidx.compose.ui.graphics.Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 10.dp)
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = androidx.compose.ui.graphics.Color.White
            ),
            shape = RoundedCornerShape(15)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painterResource(id = R.drawable.nouveau),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 35.dp) // Ajoute un espace entre l'image et le texte
                        .clickable {}
                )
                Text(
                    text = "fotsoyvan@gmail.com",
                    color = androidx.compose.ui.graphics.Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 10.dp)
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = androidx.compose.ui.graphics.Color.White
            ),
            shape = RoundedCornerShape(15)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painterResource(id = R.drawable.telephone),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 35.dp) // Ajoute un espace entre l'image et le texte
                        .clickable {}
                )
                Text(
                    text = "+237 699999999",
                    color = androidx.compose.ui.graphics.Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Button(
            onClick = { /* TODO */ },
            Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp, top = 16.dp, bottom = 16.dp)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(android.graphics.Color.parseColor("#ff8000"))
            ),
            shape = RoundedCornerShape(15)
        ) {
            Text(
                text = "en savoir plus ",
                color = androidx.compose.ui.graphics.Color.White,
                fontSize = 18.sp,
                fontWeight= FontWeight.Bold
            )
        }







    }

}