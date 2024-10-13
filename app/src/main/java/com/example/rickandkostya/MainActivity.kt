package com.example.rickandkostya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.rickandkostya.features.mainList.presentation.ui.MainScreen
import com.example.rickandkostya.ui.theme.RickAndKostyaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndKostyaTheme {
                   MainScreen()
                }
            }
        }
    }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RickAndKostyaTheme {
        MainScreen()
    }
}