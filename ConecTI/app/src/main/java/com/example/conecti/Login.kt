package com.example.conecti

import UsuarioViewModel
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.conecti.network.Service
import com.example.conecti.ui.theme.ConecTITheme
class Login : ComponentActivity() {
    private val usuarioViewModel: UsuarioViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConecTITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreenLogin(null, usuarioViewModel = usuarioViewModel)
                }
            }
        }
    }
}

@Composable
fun LoginScreenLogin(extras: Bundle?, usuarioViewModel: UsuarioViewModel) {
    val contexto = LocalContext.current
    var emailValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }

    Surface(color = MaterialTheme.colorScheme.background) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            BackgroundImageLogin()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Faça seu login!",
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.background
                )
                Text(
                    text = "Não possui cadastro? Cadastre-se!",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.padding(top = 16.dp)
                )
                TextField(
                    value = emailValue,
                    onValueChange = { emailValue = it },
                    modifier = Modifier
                        .padding(top = 60.dp)
                        .padding(horizontal = 16.dp)
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(color = Color.Transparent),
                    textStyle = TextStyle(color = Color.Black)
                )

                TextField(
                    value = passwordValue,
                    onValueChange = { passwordValue = it },
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .padding(horizontal = 16.dp)
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(color = Color.White),
                    textStyle = TextStyle(color = Color.Black)
                )

                // Botão Voltar para MainActivity
                Button(
                    onClick = {
                        val mainIntent = Intent(contexto, MainActivity::class.java)
                        contexto.startActivity(mainIntent)
                    },
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .padding(top = 80.dp)
                        .width(112.dp)
                ) {
                    Text(text = "Voltar")
                }

                Button(
                    onClick = {
                        usuarioViewModel.login(
                            Service.UsuarioLoginDto(
                                email = emailValue,
                                senha = passwordValue
                            ),
                            onLoginSuccess = {
                                // Lógica para lidar com o sucesso do login
                                // Por exemplo, redirecionar para outra tela
                              //  val intent = Intent(contexto, TelaPrincipal::class.java)
                                //contexto.startActivity(intent)
                            },
                            onError = { errorMessage ->
                                // Lógica para lidar com o erro de login
                                // Por exemplo, exibir uma mensagem de erro na tela
                                // ou fazer algo para informar o usuário sobre o erro
                                println("Erro de login: $errorMessage")
                            }
                        )
                    },
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .width(112.dp)
                ) {
                    Text(text = "Entrar")
                }

            }
        }
    }
}



@Composable
fun BackgroundImageLogin() {
    val backgroundImage = painterResource(id = R.mipmap.imagem_fundo_login) // Substitua R.drawable.
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = backgroundImage,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }
}


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        LoginScreenLogin(null, UsuarioViewModel(LocalContext.current))
    }
}
