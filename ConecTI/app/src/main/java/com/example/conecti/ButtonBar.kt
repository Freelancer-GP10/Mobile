package com.example.conecti

import android.annotation.SuppressLint
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.material3.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.conecti.ui.ui.theme.ConecTITheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NavBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConecTITheme {

            }
        }
    }
}

// FUNÇÃO DO BARRA BUTTON
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BarraButton() {
    var temporarySelectedItem = rememberSaveable { mutableStateOf(-1) }

    var bottomNavState = rememberSaveable { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier.fillMaxWidth(),
                containerColor = Color(0xFF215683)
            ) {
                NavigationBarItem(
                    selected = bottomNavState.value == 1 || temporarySelectedItem.value == 1,
                    onClick = {

                    },
                    icon = {
                        Box(
                            modifier = Modifier
                                .width(90.dp)
                                .height(60.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = if (bottomNavState.value == 0) Icons.Default.ArrowBack
                                else Icons.Outlined.ArrowBack,
                                contentDescription = "Back",
                                modifier = Modifier.size(54.dp),
                                tint = Color.White
                            )
                        }
                    }
                )

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .width(130.dp)
                        .height(40.dp)
                        .align(Alignment.CenterVertically),

                    ) {
                    Canvas(
                        modifier = Modifier
                            .size(42.dp)
                    ) {
                        drawCircle(
                            color = Color(0xFF3492FF),
                            radius = 22f,
                            center = center
                        )
                    }

                    Canvas(
                        modifier = Modifier
                            .size(42.dp)
                    ) {
                        drawCircle(
                            color = Color.White,
                            radius = 22f,
                            center = center
                        )
                    }

                    Canvas(
                        modifier = Modifier
                            .size(42.dp)
                    ) {
                        drawCircle(
                            color = Color.White,
                            radius = 22f,
                            center = center
                        )
                    }

                }

                NavigationBarItem(
                    selected = bottomNavState.value == 1 || temporarySelectedItem.value == 1,
                    onClick = {

                    },
                    icon = {
                        Box(
                            modifier = Modifier
                                .width(90.dp)
                                .height(60.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = if (bottomNavState.value == 1) Icons.Default.ArrowForward
                                else Icons.Outlined.ArrowForward,
                                contentDescription = "Forward",
                                modifier = Modifier.size(54.dp),
                                tint = Color.White
                            )
                        }
                    }
                )
            }
        }
    ) {
        LaunchedEffect(temporarySelectedItem) {
            delay(200)
            temporarySelectedItem.value = -1
        }
    }
}


// FUNÇÃO DO BARRA BUTTON
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BarraButton2() {
    var temporarySelectedItem = rememberSaveable { mutableStateOf(-1) }

    var bottomNavState = rememberSaveable { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier.fillMaxWidth(),
                containerColor = Color(0xFF215683)
            ) {
                NavigationBarItem(
                    selected = bottomNavState.value == 1 || temporarySelectedItem.value == 1,
                    onClick = {

                    },
                    icon = {
                        Box(
                            modifier = Modifier
                                .width(90.dp)
                                .height(60.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = if (bottomNavState.value == 0) Icons.Default.ArrowBack
                                else Icons.Outlined.ArrowBack,
                                contentDescription = "Back",
                                modifier = Modifier.size(54.dp),
                                tint = Color.White
                            )
                        }
                    }
                )

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .width(130.dp)
                        .height(40.dp)
                        .align(Alignment.CenterVertically),

                    ) {
                    Canvas(
                        modifier = Modifier
                            .size(42.dp)
                    ) {
                        drawCircle(
                            color = Color.White,
                            radius = 22f,
                            center = center
                        )
                    }

                    Canvas(
                        modifier = Modifier
                            .size(42.dp)
                    ) {
                        drawCircle(
                            color = Color(0xFF3492FF),
                            radius = 22f,
                            center = center
                        )
                    }

                    Canvas(
                        modifier = Modifier
                            .size(42.dp)
                    ) {
                        drawCircle(
                            color = Color.White,
                            radius = 22f,
                            center = center
                        )
                    }

                }

                NavigationBarItem(
                    selected = bottomNavState.value == 1 || temporarySelectedItem.value == 1,
                    onClick = {

                    },
                    icon = {
                        Box(
                            modifier = Modifier
                                .width(90.dp)
                                .height(60.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = if (bottomNavState.value == 1) Icons.Default.ArrowForward
                                else Icons.Outlined.ArrowForward,
                                contentDescription = "Forward",
                                modifier = Modifier.size(54.dp),
                                tint = Color.White
                            )
                        }
                    }
                )
            }
        }
    ) {
        LaunchedEffect(temporarySelectedItem) {
            delay(200)
            temporarySelectedItem.value = -1
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    ConecTITheme {
        BarraButton()
    }
}
