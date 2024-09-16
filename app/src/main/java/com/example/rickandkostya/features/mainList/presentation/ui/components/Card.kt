package com.example.rickandkostya.features.mainList.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.rickandkostya.ui.theme.UiTheme


@Composable
fun Card(
    painter: Painter,
    title: String,
    status: String,
    lastLocation: String,
    firstSee: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
    ) {
        Row {
            Image(
                painter = painter,
                contentDescription = "avatar",
                modifier = Modifier.size(120.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column() {
                Text(
                    text = title,
                    style = UiTheme.typography.H2,
                    color = UiTheme.colors.orange
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Chip()
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = status,
                        style = UiTheme.typography.H3,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Last known location:",
                    style = UiTheme.typography.H3,
                    color = UiTheme.colors.neuralDisabled
                )
                Text(
                    text = lastLocation,
                    style = UiTheme.typography.H3,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "First see in:",
                    style = UiTheme.typography.H3,
                    color = UiTheme.colors.neuralDisabled
                )
                Text(
                    text = firstSee,
                    style = UiTheme.typography.H3,
                    color = Color.White
                )
            }
        }
    }

}


