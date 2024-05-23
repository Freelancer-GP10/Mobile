package com.example.conecti.cadastroInicio.InicioFreela

import  android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CadastroFrellaDois : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Background()
                    EtapaDoisFreela()


                }
            }
        }
    }
}



@Composable
fun EtapaDoisFreela() {

    val entradaEmail = remember { mutableStateOf("") }
    val entradaSenha = remember { mutableStateOf("") }
    val entradaPapel = remember { mutableStateOf("Freelancer") }
    val entradaConfirmarSenha = remember { mutableStateOf("") }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, // Centraliza horizontalmente
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)

        ) {
            Spacer(modifier = Modifier.weight(1f)) // Ocupa todo o espaço à esquerda
            Text(
                text = "Faça seu registro!",
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.width(25.dp))
        }

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.weight(1f)) //
            Text(
                text = "Já possui cadastro? ",
            )
            Text(
                text = "Login",
                color = Color(0xFF204A7B)
            )
            Spacer(modifier = Modifier.width(28.dp))

        }
        Spacer(modifier = Modifier.height(46.dp))

        OutlinedTextField(
            value = entradaEmail.value,
            onValueChange = { entradaEmail.value = it },
            label = {
                Text(
                    fontSize = 20.sp,
                    color = Color(0xFF031224),
                    fontWeight = FontWeight.W400, text = "Email"
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = entradaSenha.value,
            onValueChange = { entradaSenha.value = it },
            label = {
                Text(
                    fontSize = 20.sp,
                    color = Color(0xFF031224),
                    fontWeight = FontWeight.W400, text = "Senha"
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = entradaConfirmarSenha.value,
            onValueChange = { entradaConfirmarSenha.value = it },
            label = {
                Text(
                    fontSize = 20.sp,
                    color = Color(0xFF031224),
                    fontWeight = FontWeight.W400,
                    text = "Confirmar Senha"
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        )
        //  shape = RoundedCornerShape(8.dp),
        //                        border = BorderStroke(2.dp, Color(0xFF204A7B)),
        //                        colors = ButtonDefaults.buttonColors(Color.Transparent),


        Spacer(modifier = Modifier.height(70.dp))

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedButton(
                onClick = {


                },
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(2.dp, Color(0xFF204A7B)),
                modifier = Modifier
                    .width(140.dp)
                    .height(50.dp)
            ) {
                Text(
                    fontSize = 21.sp,
                    color = Color(0xFF204A7B),
                    fontWeight = FontWeight.W400,
                    text = "Cadastrar"
                )
            }

            Spacer(modifier = Modifier.width(20.dp))
        }

    }
    Spacer(modifier = Modifier.height(10.dp))



    Column( verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End, // Centraliza horizontalmente
        modifier = Modifier
            .fillMaxHeight(0.94f)


    ) {


        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Canvas(
                modifier = Modifier
                    .size(44.dp)
            ) {
                drawCircle(
                    color = Color.White,
                    radius = 22f,
                    center = center
                )
            }



            Canvas(
                modifier = Modifier
                    .size(44.dp)
            ) {
                drawCircle(
                    color = Color(0xFF204A7B),
                    radius = 22f,
                    center = center
                )
            }

        }


    }

}


@Preview(showBackground = true)
@Composable
fun FreelaTresPreview() {
    MaterialTheme {
        Background()
        EtapaDoisFreela()

    }
}