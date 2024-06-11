package com.application.myapp


import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.application.livrago.R
import com.application.livrago.domain.model.User
import coil.compose.rememberImagePainter
import coil.request.ImageRequest


@Composable
fun Compte_Profil(
    navController: NavController,
    currentUser: User?,
    onSignOut : ()->Unit,
    ){
    Column(
        Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .background(color = Color(android.graphics.Color.
            parseColor("#ececec"))),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            ConstraintLayout() {
                val (topImg, profile) = createRefs()
                Image(
                    painterResource(id = R.drawable.top_background),
                    null,
                    Modifier
                        .fillMaxWidth()
                        .constrainAs(topImg) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)

                        }
                )


                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(data = currentUser?.profilePictureUrl)
                            .apply(block = fun ImageRequest.Builder.() {
                                placeholder(R.drawable.profile)
                                error(R.drawable.account)
                            }).build()
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .constrainAs(profile) {
                            top.linkTo(topImg.bottom)
                            bottom.linkTo(topImg.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )


            }

            Text(
                text = "${currentUser?.username}",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp),
                color = Color(android.graphics.Color.parseColor("#747679"))

            )

            Text(
                text = "ngadeuorland@gmail.com",
                fontSize = 20.sp,
                color = Color(android.graphics.Color.parseColor("#747679"))

            )


            Button(
                onClick = { navController.navigate("home") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 10.dp)
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White
                ),
                shape = RoundedCornerShape(15)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painterResource(id = R.drawable.ic_1),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 35.dp)
                            .clickable {}
                    )
                    Text(
                        text = "Mes avis",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }


            Button(
                onClick = { navController.navigate("update_profil") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 10.dp)
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White
                ),
                shape = RoundedCornerShape(15)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painterResource(id = R.drawable.ic_2),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 35.dp)
                            .clickable {}
                    )
                    Text(
                        text = "Parametres de compte",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Button(
                onClick = {  navController.navigate("update_profil") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 10.dp)
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White
                ),
                shape = RoundedCornerShape(15)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painterResource(id = R.drawable.ic_3),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 35.dp) // Ajoute un espace entre l'image et le texte
                            .clickable {}
                    )
                    Text(
                        text = "Informations personnelles",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Button(
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 10.dp)
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White
                ),
                shape = RoundedCornerShape(15)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painterResource(id = R.drawable.ic_4),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 35.dp)
                            .clickable {}
                    )
                    Text(
                        text = "notifications",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Button(
                onClick = {  navController.navigate("finger_settings") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 10.dp)
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White
                ),
                shape = RoundedCornerShape(15)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painterResource(id = R.drawable.ic_5),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 35.dp)
                            .clickable {}
                    )
                    Text(
                        text = "Parametres d'empreinte",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Button(
                onClick = { onSignOut() },
                Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, end = 32.dp, top = 16.dp, bottom = 16.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(android.graphics.Color.parseColor("#fd3132"))
                ),
                shape = RoundedCornerShape(15)
            ) {
                Text(
                    text = "se deconnecter",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }


    }


}



