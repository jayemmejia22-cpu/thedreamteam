package com.example.thedreamteam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppScreen()
                }
            }
        }
    }
}

@Composable
fun AppScreen() {
    var showSecondScreen by remember { mutableStateOf(false) }

    if (showSecondScreen) {
        BackButtonScreen {
            showSecondScreen = false
        }
    } else {
        FiveButtonsScreen(
            onButton1Click = { showSecondScreen = true }
        )
    }
}

@Composable
fun FiveButtonsScreen(onButton1Click: () -> Unit) {
    var clickedButton by remember { mutableStateOf("None") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Last clicked: $clickedButton",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Button(
            onClick = {
                clickedButton = "Button 1"
                onButton1Click()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Button 1")
        }

        Button(
            onClick = { clickedButton = "Button 2" },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text("Button 2")
        }

        Button(
            onClick = {
                clickedButton = "Button 3"
                onButton1Click()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Button 3")
        }

        Button(
            onClick = { clickedButton = "Button 4" },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text("Button 4")
        }

        Button(
            onClick = { clickedButton = "Button 5" },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text("Button 5")
        }
    }
}

@Composable
fun BackButtonScreen(onBackClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = onBackClick) {
            Text("Back")
        }
    }
}


@Composable
fun ButtonThreeScreen(onBackClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = onBackClick) {
            Text("Back")
        }
    }
}