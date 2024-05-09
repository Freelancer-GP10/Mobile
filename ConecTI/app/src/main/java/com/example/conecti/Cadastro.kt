package com.example.conecti

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conecti.ui.theme.ConecTITheme

class Cadastro : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConecTITheme {
                LoginScreenCadastro(this) // Passando a instância da atividade atual
            }
        }
    }
}
@Composable
fun LoginScreenCadastro(activity: Activity) {
    val contexto = activity

    Surface(color = MaterialTheme.colorScheme.background) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.White, Color(127, 184, 197)),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        ) {
            Image(
                painter = painterResource(id = R.mipmap.logo),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .size(100.dp)
                    .padding(top = 20.dp),
                contentScale = ContentScale.Fit
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Como você deseja\n" +
                            "se registrar?",
                    fontSize = 30.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Button(
                    onClick = {
                        val cadastroFrellaTres = Intent(contexto, CadastroFrellaTres::class.java)
                        contexto.startActivity(cadastroFrellaTres)
                    },
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .padding(top = 60.dp)
                        .width(290.dp)
                        .height(71.dp)
                ) {

                    Text(
                        text = "Freelancer",
                        fontSize = 24.sp,
                        color = Color.White,
                        modifier = Modifier // Adicionando o argumento opcional nomeado
                    )
                }

                Text(
                    text = "Ou",
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier // Adicionando o argumento opcional nomeado
                )

                Button(
                    onClick = {},
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .width(290.dp)
                        .height(71.dp)
                ) {
                    Text(
                        text = "Microempreendedor",
                        fontSize = 24.sp,
                        color = Color.White,
                        modifier = Modifier // Adicionando o argumento opcional nomeado
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewLoginScreenCadastro() {
    LoginScreenCadastro(Activity())
}
