package com.example.thedreamteam

import android.content.Intent
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
                    FiveButtonsScreen(
                        onButton1Click = {
                            val intent = Intent(this@MainActivity, StudentOneActivity::class.java)
                            startActivity(intent)
                        },
                        onButton2Click = {
                            val intent = Intent(this@MainActivity, StudentTwoActivity::class.java)
                            startActivity(intent)
                        },
                        onButton3Click = {
                            val intent = Intent(this@MainActivity, StudentThreeActivity::class.java)
                            startActivity(intent)
                        },
                        onButton4Click = {
                            val intent = Intent(this@MainActivity, StudentFourActivity::class.java)
                            startActivity(intent)
                        },
                        onButton5Click = {
                            val intent = Intent(this@MainActivity, StudentFiveActivity::class.java)
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun FiveButtonsScreen(
    onButton1Click: () -> Unit,
    onButton2Click: () -> Unit,
    onButton3Click: () -> Unit,
    onButton4Click: () -> Unit,
    onButton5Click: () -> Unit
) {
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
                clickedButton = "Student 1"
                onButton1Click()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Student 1")
        }

        Button(
            onClick = {
                clickedButton = "Student 2"
                onButton2Click()
            },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text("Student 2")
        }

        Button(
            onClick = {
                clickedButton = "Student 3"
                onButton3Click()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Student 3")
        }

        Button(
            onClick = {
                clickedButton = "Student 4"
                onButton4Click()
            },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text("Student 4")
        }

        Button(
            onClick = {
                clickedButton = "Student 5"
                onButton5Click()
            },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text("Student 5")
        }
    }
}