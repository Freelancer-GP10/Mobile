    package com.example.conecti

    import android.content.Intent
    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.size
    import androidx.compose.foundation.layout.width
    import androidx.compose.material3.Button
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Surface
    import androidx.compose.material3.Text
    import androidx.compose.material3.TextField
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Brush
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.platform.LocalContext
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.text.TextStyle
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import com.example.conecti.ui.theme.ConecTITheme

    class Cadastro_Free : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                ConecTITheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        LoginScreenCadastro_Free(null)
                    }
                }
            }
        }
    }

    @Composable
    fun LoginScreenCadastro_Free(extras: Bundle?) {
        val contexto = LocalContext.current
        var nomeValue by remember { mutableStateOf("") }
        var sobrenomeValue by remember { mutableStateOf("") }
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
                ) { val contexto = LocalContext.current
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
                        text = "Faça seu registro!",
                        fontSize = 24.sp,
                        color = Color.Black
                    )

                    TextField(
                        value = nomeValue,
                        onValueChange = { nomeValue = it },
                        modifier = Modifier
                            .padding(top = 60.dp)
                            .padding(horizontal = 16.dp)
                            .height(50.dp)
                            .fillMaxWidth()
                            .background(color = Color.Transparent),
                        textStyle = TextStyle(color = Color.Black)
                    )

                    TextField(
                        value = sobrenomeValue,
                        onValueChange = { sobrenomeValue = it },
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .padding(horizontal = 16.dp)
                            .height(50.dp)
                            .fillMaxWidth()
                            .background(color = Color.White),
                        textStyle = TextStyle(color = Color.Black)
                    )
                }
            }
        }
    }
            }}}

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview2() {
        ConecTITheme {
            LoginScreenCadastro_Free(null)
        }
    }