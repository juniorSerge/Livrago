package com.application.livrago.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.application.livrago.ui.composables.Routes
import kotlin.random.Random


object Data{
    val listPersons = listOf(
        "Orland ngandeu",
        "Naruto Uzumaki",
        "Sasuke Uchiha",
        "Sakura Haruno",
        "Kakashi Hatake"
    )
}


@Composable
fun PersonItem(fullName: String){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
    ){
        Box(
            modifier = Modifier
                .size(50.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(50))
                .background(Color(Random.nextInt()))//pour donner un background aleatoire
        ){
            Text(
                text = fullName.first().uppercase(),//on recupere la premiere lettre de la chaine et on la mets en maj
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.Center)
            )

        }
        Text(
            text = fullName,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun Liste(navController: NavController) {

    Column {
        Button(onClick = {
            navController.navigate(Routes.profileScreen)
        }) {
            Text(text = "NAVIGUER")
        }
        LazyColumn {
            items(Data.listPersons){fullName ->
                PersonItem(fullName = fullName)}
        }
    }

//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState())
//    ) {
//        Data.listPersons.forEach{
//            PersonItem(fullName = it)
//        }
//    }
}

@Preview(showSystemUi = true)
@Composable
fun PersonListPreview()
{
    LazyColumn {
        items(Data.listPersons){fullName ->
            PersonItem(fullName = fullName)
        }
    }
}
