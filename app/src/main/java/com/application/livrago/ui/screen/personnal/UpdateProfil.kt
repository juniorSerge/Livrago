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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.application.livrago.R
import com.application.livrago.domain.model.User

@Composable
fun UpdateProfil (
    navController: NavController,
    currentUser: User?,
) {
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


            Image(
                painterResource(id = R.drawable.retour),null,
                Modifier
                    .constrainAs(retour) {

                        top.linkTo(parent.top)
                        start.linkTo(parent.start)

                    }
                    .size(width = 40.dp, height = 40.dp)
                    .clickable {
                        navController.navigate("compte_utilisateur")
                    }

            )

        }
        Button(
            onClick = { },
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
                    painterResource(id = R.drawable.utilisateur),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable {}
                )
                Text(
                    text = "name:",
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(end = 5.dp)

                )

                Text(
                    text = "${currentUser?.username}",
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(end = 30.dp)

                )
                Image(
                    painterResource(id = R.drawable.boutonmodifier),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 2.dp)
                        .clickable {}
                        .size(width = 75.dp, height = 45.dp)
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
                backgroundColor = Color.White
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
                        .padding(end = 5.dp)
                        .clickable {}
                )
                Text(
                    text = "surname:",
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(end = 5.dp)

                )

                Text(
                    text = "${currentUser?.username}",
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(end = 80.dp)

                )
                Image(
                    painterResource(id = R.drawable.boutonmodifier),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 2.dp)
                        .clickable {}
                        .size(width = 20.dp, height = 45.dp)
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
                backgroundColor = Color.White
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
                        .padding(end = 5.dp)
                        .clickable {}
                        .size(width = 20.dp, height = 45.dp)
                )


                Text(
                    text = "ngadeuorland@gmail.com",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(end = 40.dp)

                )
                Image(
                    painterResource(id = R.drawable.boutonmodifier),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 2.dp)
                        .clickable {}
                        .size(width = 20.dp, height = 45.dp)
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
                backgroundColor = Color.White
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
                        .padding(end = 65.dp)
                        .clickable {}
                        .size(width = 25.dp, height = 45.dp)
                )


                Text(
                    text = "+237 699999999",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(end = 47.dp)

                )
                Image(
                    painterResource(id = R.drawable.boutonmodifier),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 2.dp)
                        .clickable {}
                        .size(width = 20.dp, height = 45.dp)
                )
            }
        }



    }
}