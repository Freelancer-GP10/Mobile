package com.example.conecti

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.security.NetworkSecurityPolicy
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conecti.Freela.Perfil1
import com.example.conecti.Freela.Perfil5
import com.example.conecti.Micro.PerfilMicro1
import com.example.conecti.Micro.PerfilMicro4
import com.example.conecti.Micro.WorkSpaceMicro
import com.example.conecti.ui.theme.ConecTITheme
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            configureNetworkSecurityExceptions()
            ConecTITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Perfil1()
                }
            }
        }
    }
}
private fun configureNetworkSecurityExceptions() {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) return

    try {
        // Cria um contexto SSL permitindo tráfego não seguro
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, null, null)
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.socketFactory)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

@Composable
fun LoginScreen(name: String, modifier: Modifier = Modifier) {

    val contexto = LocalContext.current
    Surface(color = MaterialTheme.colorScheme.background) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            BackgroundImage()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "ConecTI",
                    fontSize = 44.sp,
                    color = MaterialTheme.colorScheme.background,
                )
                Text(
                    text = "A química da conexão perfeita!",
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.padding(top = 16.dp)
                )

                // Botão 1 - Cadastrar-se
                Button(
                    onClick = {
                        val cadastro = Intent(contexto, Cadastro::class.java)
                        contexto.startActivity(cadastro)
                    },
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .padding(top = 60.dp)
                        .width(218.dp)
                        .height(60.dp)
                ) {
                    Text(

                               text = "Cadastrar-se",
                        fontSize = 24.sp,
                        color = Color.White,
                        style = TextStyle(
                            fontFamily = FontFamily.Serif,

                            )
                    )
                }

                Button(
                    onClick = {
                        val login = Intent(contexto, Login::class.java)
                        contexto.startActivity(login)
                    },
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .width(218.dp)
                        .height(60.dp),
                    shape = MaterialTheme.shapes.medium
                ) {
                    // Text wrapped with Modifier

                        Text(
                            text = "Entrar",
                            fontSize = 24.sp,
                            color = Color.White,
                            style = TextStyle(fontFamily = FontFamily.Serif)
                        )

                }
            }
        }
    }
}

@Composable
fun BackgroundImage() {
    val backgroundImage = painterResource(id = R.mipmap.imagem_fundo_login) // Substitua
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConecTITheme {
        Perfil1()
    }
}