package com.example.conecti

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.conecti.ui.theme.ConecTITheme
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import com.example.conecti.ui.theme.AzulFundo

class Perfil_Free : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConecTITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    ProfileScreen(null)
                    Menu()

                }
            }
        }
    }
}

@Composable
fun ProfileScreen(extras: Bundle?) {

    val contexto = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp)

        ) {
//            IconButton(
//                onClick = { },
//                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
//            ) {
//                Icon(Icons.Default.Menu, contentDescription = "Menu")
//            }

            Spacer(modifier = Modifier.height(70.dp))



            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .weight(1f)
            ) {
                item {
                    ProfileSection()
                }

                item {
                    PortfolioSection()
                }

                item {
                    NavigationButtons(
                        onBackClick = {
                            val cadastroFree = Intent(contexto, Cadastro_Free::class.java)
                            contexto.startActivity(cadastroFree)
                        },
                        onForwardClick = { /* Ação ao clicar em avançar */ }
                    )
                }
            }
        }

        // Retângulo azul na parte inferior da tela
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .align(Alignment.BottomCenter)
                .background(AzulFundo)
        ){

        }

    }
}

@Composable
fun ProfileSection() {
    Surface(
        modifier = Modifier
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .border(1.dp, Color.Black) // Adiciona uma borda preta à seção
            .fillMaxWidth(), // Preenche a largura
        color = Color.White
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start // Alinha a coluna mais para a esquerda
        ) {
            Text(
                text = "Perfil",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "usuario",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "E-mail: usuario@example.com",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Senha: *****",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End, // Alinha o Row à direita
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f)) // Adiciona um espaço flexível para empurrar o botão para a direita
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .height(40.dp) // Define a altura do botão como 40dp
                        .width(100.dp)
                ) {
                    Text(text = "Editar")
                }
            }
        }
    }
}


@Composable
fun PortfolioSection() {
    Surface(
        modifier = Modifier
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(10.dp)) // Adiciona bordas arredondadas ao Surface
            .border(1.dp, Color.Black) // Adiciona uma borda preta ao redor do Surface
            .fillMaxWidth(), // Preenche a largura
        color = Color.White
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Olá Freelancer, Seu Portfólio?",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Guardamos seu portfólio para que possamos fazer análises e indicar onde deve estar melhorando!\n" +
                        "\nVocê pode realizar a atualização dele ou até mesmo baixar o seu portfólio que temos guardado!",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Spacer(modifier = Modifier.height(25.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = 48.dp)
                ) {
                    Text(text = "Atualizar")
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = 48.dp)
                ) {
                    Text(text = "Baixar")
                }

            }
        }
    }
}

@Composable
fun NavigationButtons(onBackClick: () -> Unit, onForwardClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly, // Ajusta o espaçamento entre os botões
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavigationButton(Icons.Default.ArrowBack, "Voltar", onBackClick)
        NavigationButton(Icons.Default.ArrowForward, "Avançar", onForwardClick)
    }
}

@Composable
fun NavigationButton(
    icon: ImageVector,
    contentDescription: String,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(48.dp) // Define o tamanho dos botões
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    ConecTITheme {
        ProfileScreen(null)
        Menu()

    }
}
