package com.example.conecti

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conecti.ui.theme.ConecTITheme

class CadastroFreelaOne : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConecTITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EtapaUm()
                    Background()
                }
            }
        }
    }
}

@Composable
fun Background() {
    val corHexadecimal = 0xFF9ED4DF
    val corInteira = corHexadecimal.toInt()
    // Substitua R.drawable.background_image pelo ID de sua imagem
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        Color(android.graphics.Color.parseColor("#FF9ED4DF"))
                    )
                )
            )
    ) {


        Image(
            painter = painterResource(id = R.mipmap.logo),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopStart) // Alinha a imagem ao canto superior esquerdo
                .size(100.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun EtapaUm() {

    val entradaNome = remember { mutableStateOf("") }
    val entradaSobrenome = remember { mutableStateOf("") }
    val entradaCpf = remember { mutableStateOf("") }
    val entradaTelefone = remember { mutableStateOf("") }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, // Centraliza horizontalmente
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
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



        Spacer(modifier = Modifier.height(50.dp))


        OutlinedTextField(
            value = entradaNome.value,
            onValueChange = { entradaNome.value = it },
            label = {
                Text(
                    fontSize = 20.sp,
                    color = Color(0xFF031224),
                    fontWeight = FontWeight.W400, text = "Nome"
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = entradaSobrenome.value,
            onValueChange = { entradaSobrenome.value = it },
            label = {
                Text(
                    fontSize = 20.sp,
                    color = Color(0xFF031224),
                    fontWeight = FontWeight.W400, text = "Sobrenome"
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = entradaCpf.value,
            onValueChange = { entradaCpf.value = it },
            label = {
                Text(
                    fontSize = 20.sp,
                    color = Color(0xFF031224),
                    fontWeight = FontWeight.W400,
                    text = "CPF"
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = entradaTelefone.value,
            onValueChange = { entradaTelefone.value = it },
            label = {
                Text(
                    fontSize = 20.sp,
                    color = Color(0xFF031224),
                    fontWeight = FontWeight.W400,
                    text = "Telefone"
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        )


        Spacer(modifier = Modifier.height(45.dp))

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedButton(
                onClick = { /*TODO*/ },
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
                    text = "Continuar"
                )
            }

            Spacer(modifier = Modifier.width(20.dp))
        }

    }




    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End, // Centraliza horizontalmente
        modifier = Modifier
            .fillMaxHeight(0.9f)


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
                    color = Color(0xFF204A7B),
                    radius = 22f,
                    center = center
                )
            }

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
                    color = Color.White,
                    radius = 22f,
                    center = center
                )
            }

        }


    }

}


@Preview(showBackground = true)
@Composable
fun FreelaOnePreview() {
    MaterialTheme {
        BackgroundImage()
        EtapaUm()

    }
}