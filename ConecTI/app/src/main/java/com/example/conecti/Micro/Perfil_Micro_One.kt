package com.example.conecti.Micro

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conecti.BarraButton1
import com.example.conecti.BarraButtonMicro1
import com.example.conecti.Freela.CustomMenuItem
import com.example.conecti.Freela.Perfil_Freela_Dois
import com.example.conecti.Freela.SubMenusBotoes
import com.example.conecti.R
import com.example.conecti.ui.theme.ConecTITheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class Perfil_Micro_One : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConecTITheme {
                PerfilMicro1()
            }
        }
    }
}

@Composable
fun MainContentMicro1(scope: CoroutineScope, iniciarJanela: DrawerState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 15.dp) // Adiciona um espaçamento na parte superior da tela
    ) {
        IconButton(
            onClick = {
                scope.launch {
                    iniciarJanela.open()
                }
            },
            modifier = Modifier.padding(start = 16.dp, top = 15.dp), // Adiciona um espaçamento à esquerda
        ) {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "menu Icon",
                tint = Color(0xFF50FAAB),
                modifier = Modifier.size(40.dp)
            )
        }

        // Conteúdo principal da tela
        // Use weight(1f) para ocupar todo o espaço disponível na tela
        Box(
            modifier = Modifier
                .fillMaxSize()

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 24.dp)

            ) {


                Text(
                    text = "Perfil",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.W400,
                    color = Color(0xFF215683),
                    modifier = Modifier
                        .padding(start = 30.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .weight(1f)
                ) {
                    item {
                        ProfileSectionMicro1()
                    }

                    item {
                        PortfolioSection()
                    }


                }
            }

            // Retângulo azul na parte inferior da tela


        }
    }
}


// AQUI ESTA TODA PARTE DE LOGICA DO MENU LATERAL
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilMicro1() {
    val contexto = LocalContext.current

    val subMenus = listOf(
        SubMenusBotoes(Icons.Default.AccountCircle, "Perfil", 0, false),
        SubMenusBotoes(Icons.Rounded.Home, "WorkSpace", 32, true),
        SubMenusBotoes(Icons.Filled.Build, "Services", 32, true),
        SubMenusBotoes(Icons.Filled.ShoppingCart, "Pay", 0, false),
     )
    val subMenus2 = listOf(
        SubMenusBotoes(Icons.Default.ExitToApp, "Sair", 0, false),
    )
    var selecilionarSubMenu = remember {
        mutableStateOf(subMenus[0])
    }

    val iniciarJanela = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(drawerContent = {
        ModalDrawerSheet {

            Column(
                Modifier
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF062949),
                                Color(0xFE1B5D94),
                                Color(0xFE074370),
                                Color(0xFE1B5D94)
                            ), // Cores do gradiente, do início ao fim
                            startY = 2500f, // Posição final do gradiente no eixo x
                            endY = 0f // Posição inicial do gradiente no eixo x
                        )
                    )
                    // Preenche toda a altura disponível
                    .padding(
                        start = 25.dp,
                        top = 30.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    ), // Ajusta o espaçamento
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(260.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        Modifier.wrapContentSize(),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.CenterHorizontally,


                        ) {

                        Image(
                            painter = painterResource(id = R.mipmap.tiringa),
                            contentDescription = "profile pic",
                            modifier = Modifier
                                .size(150.dp)
                                .clip(CircleShape)
                                .scale(2f, 2f)

                        )
                        Text(
                            text = "RECEBA! ",
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp),
                            fontSize = 28.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }


                }

                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    thickness = 1.dp,
                    color = Color(0xFE0D60A5)
                )
                Spacer(modifier = Modifier.height(10.dp))

                subMenus.forEach {
                    CustomMenuItem(
                        icon = it.icone,
                        text = it.texto_botao,
                        badgeCount = it.numeroNotificao,
                        colorVetor = Color(0xFF50FAAB),
                        onClick = {
                            selecilionarSubMenu.value = it

                            scope.launch {
                                iniciarJanela.close()
                            }
                            if (it.texto_botao == "Perfil") {
                                val mainIntent = Intent(contexto, Perfil_Micro_One::class.java)
                                contexto.startActivity(mainIntent)
                            } else if (it.texto_botao == "WorkSpace") {
                                val mainIntent = Intent(contexto, WorkSpaceMicro::class.java)
                                contexto.startActivity(mainIntent)
                            }else if (it.texto_botao == "Services") {
                                val mainIntent = Intent(contexto, ServiceMicro::class.java)
                                contexto.startActivity(mainIntent)
                            }else if (it.texto_botao == "Pay") {
                                val mainIntent = Intent(contexto, HIstoricoPayMicro::class.java)
                                contexto.startActivity(mainIntent)
                            }

                        }
                    )
                }



                Spacer(modifier = Modifier.height(25.dp))
                Row {
                    Spacer(modifier = Modifier.width(80.dp))
                    subMenus2.forEach {
                        CustomMenuItem(
                            icon = it.icone,
                            text = it.texto_botao,
                            badgeCount = it.numeroNotificao,
                            colorVetor = Color(0xFF50FAAB),
                            onClick = {
                                selecilionarSubMenu.value = it

                                scope.launch {
                                    iniciarJanela.close()
                                }
                            }
                        )
                    }

                }
                Spacer(modifier = Modifier.height(35.dp))

            }
        }
    }, drawerState = iniciarJanela,
        content = {
           MainContentMicro1(scope = scope, iniciarJanela = iniciarJanela)
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom


                // Alinha o Column na parte inferior central da tela
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    BarraButtonMicro1()
                }
            }

        }
    )
}

// ESTE DATA CLASS É PARA CHAMAR OS ICONES TIPO SETA ETC..
data class SubMenusBotoes1Micro1(

    val icone: ImageVector,
    val texto_botao: String,
    val numeroNotificao: Int,
    val booleanNotificao: Boolean
)


// AQUI ESTA OS BOTÕES DE ESCOLHO DO MENU LATERAL
@Composable
fun CustomMenuItemMicro1(
    icon: ImageVector,
    text: String,
    badgeCount: Int = 0,
    colorVetor: Color,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .clickable { onClick() }
            .padding(16.dp)
            .fillMaxWidth(), // Preencher a largura
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start // Alinhamento à esquerda
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = colorVetor,
            modifier = Modifier.size(38.dp) // Tamanho aumentado dos ícones
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.weight(1f) // Ocupar o espaço disponível
        )
        if (badgeCount > 0) {
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .background(Color.Red)
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = badgeCount.toString(),
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        }
    }
}


// YAGO & ISAIAS FEZ - AQUI ESTA O QUADRADO DE PERFIL
@Composable
fun ProfileSectionMicro1() {
    val contexto4 = LocalContext.current

    Surface(
        modifier = Modifier
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .border(1.dp, Color.Black) // Adiciona uma borda preta à seção
            .fillMaxWidth(), // Preenche a largura
        color = Color.White
    ) {
        Box(
            modifier = Modifier
                .padding(14.dp)
        ) {

            Column(
                modifier = Modifier
                    .width(156.dp)
                    .height(180.dp),
                horizontalAlignment = Alignment.Start

            ) {

                Text(
                    text = "Usuario:",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 2.dp, top = 10.dp)
                )
                Text(
                    text = "Receba FIH",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 20.dp)
                )

                Text(
                    text = "Email:",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 2.dp)
                )

                Text(
                    text = "usuario@example.com",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                Text(
                    text = "Senha:",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 1.dp)
                )
                Text(
                    text = "**************",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            Column(
                modifier = Modifier
                    .height(180.dp)
                    .width(155.dp)
                    .align(alignment = Alignment.TopEnd),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Spacer(modifier = Modifier.height(8.dp))

                Image(
                    painter = painterResource(id = R.mipmap.tiringa),
                    contentDescription = "profile pic",
                    modifier = Modifier
                        .size(90.dp)
                        .clip(CircleShape)
                        .scale(2f, 2f)


                )

                Spacer(modifier = Modifier.height(30.dp))
                OutlinedButton(
                    onClick = {
                        val mainIntent2 = Intent(contexto4, Perfil_Micro_Dois::class.java)
                        contexto4.startActivity(mainIntent2)
                    },
                    modifier = Modifier
                        .height(40.dp) // Define a altura do botão como 40dp
                        .width(100.dp),
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(1.dp, Color(0xFF215683)),

                    ) {
                    Text(
                        text = "Editar",
                        fontSize = 19.sp,
                    )
                }
            }


        }
    }
}


// YAGO FEZ - AQUI ESTA O PORTIFOLIO DO CARA
@Composable
fun PortfolioSection() {
    Spacer(modifier = Modifier.height(35.dp))
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
                text = "Olá, microempresário!?",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 25.dp, top = 10.dp)
            )
            Text(
                text = "Seus pagamentos são nossa prioridade quando o assunto e segurança!\n" +
                        "\nVocê pode tanto atualizar as formas de pagamento que você utiliza quanto baixar o relatório de todos os seus pagamentos!",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 27.dp)
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


@Preview(showBackground = true)
@Composable
fun GreetingPreview7() {
    ConecTITheme {
      PerfilMicro1()
    }
}