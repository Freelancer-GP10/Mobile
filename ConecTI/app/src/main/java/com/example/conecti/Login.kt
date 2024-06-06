package com.example.conecti

import UsuarioViewModel
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.conecti.cadastroInicial.FreelaInicio.CadastroFreelaOne
import com.example.conecti.cadastroInicial.MicroInicio.CadastroMicroOne
import com.example.conecti.network.Service
import com.example.conecti.ui.theme.ConecTITheme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val contexto = LocalContext.current
            ConecTITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreenLogin(null, UsuarioViewModel(contexto))
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

    val usuarioAutenticado = usuarioViewModel.usuarioAutenticado.observeAsState().value

    Surface(color = MaterialTheme.colorScheme.background) {
        Box(
            modifier = Modifier
                .fillMaxSize()
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
                    text = stringResource(R.string.login_faca),
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.background
                )
                Text(
                    text = stringResource(R.string.nao_pssuo_cadastro),
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.padding(top = 16.dp)
                )
                OutlinedTextField(
                    value = emailValue,
                    onValueChange = { emailValue = it },
                    modifier = Modifier
                        .padding(top = 60.dp)
                        .padding(horizontal = 16.dp)
                        .height(60.dp)
                        .fillMaxWidth(),
                    label = { Text(text = "Email", color = Color.White)},
                    textStyle = TextStyle(color = Color.White)
                )
                OutlinedTextField(
                    value = passwordValue,
                    onValueChange = { passwordValue = it },
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .padding(horizontal = 16.dp)
                        .height(60.dp)
                        .fillMaxWidth(),
                    textStyle = TextStyle(color = Color.White),
                    label = { Text("Senha", color = Color.White) },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
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
                    Text(text = stringResource(R.string.voltar_botton))
                }

                Button(
                    onClick = {
                        try {
                            val usuarioLoginDto = Service.UsuarioLoginDto(
                                email = emailValue, // use o email fornecido pelo usuário
                                senha = passwordValue  // use a senha fornecida pelo usuário
                            )
                            usuarioViewModel.loginUsuario(usuarioLoginDto)

                        } catch (e: Exception) {
                            // Exibe uma mensagem de erro se o login falhar
                            Toast.makeText(contexto, "Erro ao fazer login: ${e.message}", Toast.LENGTH_LONG).show()
                        }
                    },
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .width(112.dp)
                ) {
                    Text(text =  stringResource(R.string.entrar_botton) )
                }
                }

            }
        }

        if (usuarioAutenticado != null) {
            if (usuarioAutenticado.papel == "Freelancer") {
                val cadastroFreela = Intent(contexto, CadastroFreelaOne::class.java)
                contexto.startActivity(cadastroFreela)
                Toast.makeText(
                    contexto,
                    "Redirecionando para a tela de cadastro do Freelancer",
                    Toast.LENGTH_LONG
                ).show()
            } else if (usuarioAutenticado.papel.toString() == "Microempreendedor") {
                val cadastroMicro = Intent(contexto, CadastroMicroOne::class.java)
                contexto.startActivity(cadastroMicro)
                Toast.makeText(
                    contexto,
                    "Redirecionando para a tela de cadastro do Microempreendedor",
                    Toast.LENGTH_LONG
                ).show()
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
        val contexto = LocalContext.current
        LoginScreenLogin(null, UsuarioViewModel(contexto))
    }
}
