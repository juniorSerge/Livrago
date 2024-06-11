package com.application.livrago.domain.notifications

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.StarHalf
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.application.livrago.ui.screen.Dashboard

@Composable
fun RatingScreen(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 5,
    starsColor: Color = Color.Yellow,
    onRatingChange: (Double) -> Unit
) {
    var isHalfStar = (rating % 1) != 0.0

    Row{
        for (index in 1..stars){
            Icon(
                modifier =  modifier.clickable {
                    onRatingChange(index.toDouble())
                },
                contentDescription =null,
                tint = starsColor,
                imageVector = if (index <= rating){
                    Icons.Rounded.Star
                }else{
                    if(isHalfStar){
                        Icons.AutoMirrored.Rounded.StarHalf
                    }else{
                        Icons.Rounded.StarOutline
                    }
                }
            )
        }
    }
}
