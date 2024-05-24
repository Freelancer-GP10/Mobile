package com.example.conecti.ButtonBars

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.conecti.Micro.HistoricoPayMicro
import com.example.conecti.Micro.Perfil_Micro_One
import com.example.conecti.Micro.ServiceMicro
import com.example.conecti.Micro.WorkSpaceMicro
import com.example.conecti.ui.theme.ConecTITheme

class ButtonBarMicro : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConecTITheme {

            }
        }
    }
}
// FUNÇÃO DO BARRA BUTTON  - PARTE 1

@Composable
fun BarraButtonMicro1() {
    val contexto2 = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .background(Color(0xFF215683))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.width(90.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth(0.7f) // ajuste conforme necessário
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

                IconButton(
                    onClick = {
                        val mainIntent = Intent(contexto2, HistoricoPayMicro::class.java)
                        contexto2.startActivity(mainIntent)
                    },
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .height(60.dp)
                        .width(90.dp)
                    //.background(Color.Red)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Continuar",
                        tint = Color.White,
                        modifier = Modifier.size(66.dp)
                    )
                }
            }
        }
    }
}

// FUNÇÃO DO BARRA BUTTON - PARTE 2

@Composable
fun BarraButtonMicro2() {
    val contexto2 = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .background(Color(0xFF215683))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 16.dp)
            ) {
                IconButton(
                    onClick = {
                        val mainIntent = Intent(contexto2, Perfil_Micro_One::class.java)
                        contexto2.startActivity(mainIntent)
                    },
                    modifier = Modifier
                        .padding(start = 0.dp)
                        .height(60.dp)
                        .width(90.dp)
                    //   .background(Color.Red)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color.White,
                        modifier = Modifier.size(66.dp)
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth(0.7f) // ajuste conforme necessário
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

                IconButton(
                    onClick = {
                        val mainIntent = Intent(contexto2, WorkSpaceMicro::class.java)
                        contexto2.startActivity(mainIntent)
                    },
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .height(60.dp)
                        .width(90.dp)
                    //.background(Color.Red)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Continuar",
                        tint = Color.White,
                        modifier = Modifier.size(66.dp)
                    )
                }
            }
        }
    }
}


// FUNÇÃO DO BARRA BUTTON - PARTE 3

@Composable
fun BarraButtonMicro3() {
    val contexto2 = LocalContext.current
    val contexto4 = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .background(Color(0xFF215683))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 16.dp)
            ) {
                IconButton(
                    onClick = {
                        val mainIntent = Intent(contexto2, HistoricoPayMicro::class.java)
                        contexto2.startActivity(mainIntent)
                    },
                    modifier = Modifier
                        .padding(start = 0.dp)
                        .height(60.dp)
                        .width(90.dp)
                    //   .background(Color.Red)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color.White,
                        modifier = Modifier.size(66.dp)
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth(0.7f) // ajuste conforme necessário
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

                IconButton(
                    onClick = {
                        val mainIntent2 = Intent(contexto4, ServiceMicro::class.java)
                        contexto4.startActivity(mainIntent2)
                    },
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .height(60.dp)
                        .width(90.dp)
                    //.background(Color.Red)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Continuar",
                        tint = Color.White,
                        modifier = Modifier.size(66.dp)
                    )
                }
            }
        }
    }
}

// FUNÇÃO DO BARRA BUTTON - PARTE 4

@Composable
fun BarraButtonMicro4() {
    val contexto = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .background(Color(0xFF215683))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 16.dp)
            ) {
                IconButton(
                    onClick = {
                        val mainIntent = Intent(contexto, WorkSpaceMicro::class.java)
                        contexto.startActivity(mainIntent)
                    },
                    modifier = Modifier
                        .padding(start = 0.dp)
                        .height(60.dp)
                        .width(90.dp)
                    //   .background(Color.Red)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color.White,
                        modifier = Modifier.size(66.dp)
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth(0.7f) // ajuste conforme necessário
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
                }
                Spacer(modifier = Modifier.width(90.dp))
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview15() {
    ConecTITheme {
    }
}