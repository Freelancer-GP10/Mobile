package com.example.conecti.Micro

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
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
import com.example.conecti.buttonBars.BarraButtonMicro2
import com.example.conecti.Freela.CustomMenuItem
import com.example.conecti.Freela.SubMenusBotoes
import com.example.conecti.R
import com.example.conecti.ui.theme.ConecTITheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HIstoricoPayMicro : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConecTITheme {
                PerfilMicro3()
            }
        }
    }
}


// FUNÇÃO USADA PARA ADICONAR OS VALORES DOS COMPONETES
@Composable
fun componetesdePagamentoMicro(
    data: String,
    valor: String,

    ) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(87.dp)
            .padding(16.dp)
            .border(1.dp, Color.Gray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .border(3.dp, Color(0xFFCBE0F1))
                .background(Color(0xFFCBE0F1)),
            //.background(Color.Red),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = data,
                fontSize = 18.sp,
                modifier = Modifier
                    .weight(1.9f)
                    .padding(start = 10.dp)
            )

            Text(
                text = "R$: ${valor}",
                modifier = Modifier
                    .padding(end = 20.dp),
                fontSize = 18.sp,
            )
        }
    }
}

// AQUI ESTA O ÍCONE DO MENU E O CONTEUDO INICIAL VISIVEL
@Composable
fun MainContentMicro3(
    scope: CoroutineScope,
    iniciarJanela: DrawerState,
    valorDisponivel: String,
    valorBloqueado: String
) {
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
            modifier = Modifier.padding(
                start = 16.dp,
                top = 15.dp
            ), // Adiciona um espaçamento à esquerda
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
                    text = "Pay",
                    color = Color(0xFF215683),
                    fontSize = 38.sp,
                    modifier = Modifier
                        .padding(start = 30.dp, bottom = 0.dp)
                        .align(Alignment.Start),

                    )
                Spacer(modifier = Modifier.height(20.dp))

                Row {
                    Spacer(modifier = Modifier.width(20.dp))
                    Box(
                        modifier = Modifier
                            .background(Color(0xFF204A7B), shape = RoundedCornerShape(8.dp))
                            .padding(start = 0.dp, bottom = 0.dp)
                            .width(180.dp)
                            .height(60.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(-5.dp)
                        ) {

                            Text(
                                text = "Valor investido",
                                color = Color.White,
                                fontSize = 14.sp
                            )
                            Text(
                                text = "R$: ${valorDisponivel}",
                                color = Color.White
                            )
                        }

                    }
                    Spacer(modifier = Modifier.width(25.dp))

                    Box(
                        modifier = Modifier
                            .background(Color(0xFF204A7B), shape = RoundedCornerShape(8.dp))
                            .padding(start = 0.dp, bottom = 0.dp)
                            .width(145.dp)
                            .height(60.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(-5.dp)
                        ) {

                            Text(
                                text = "Saldo bloqueado",
                                color = Color.White,
                                fontSize = 14.sp
                            )
                            Text(
                                text = "R$: ${valorBloqueado}",
                                color = Color.White
                            )
                        }
                    }

                }

                Spacer(modifier = Modifier.height(35.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Histórico mais recente:",
                        modifier = Modifier
                            .padding(start = 25.dp),
                        fontSize = 19.sp,
                    )

                    Spacer(modifier = Modifier.width(24.dp))

                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(7.dp),
                        modifier = Modifier
                            .height(50.dp)
                            .width(100.dp)

                    ) {
                        Text(
                            text = "Sacar",
                            fontSize = 17.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 50.dp),
                    verticalArrangement = Arrangement.spacedBy(-15.dp) // Espaço de 4dp entre os itens
                ) {
                    items(12) { index ->
                        componetesdePagamentoMicro(
                            data = "16/Fev",
                            valor = "2.350,41"
                        )
                    }
                }


            }

        }
    }
}


// AQUI ESTA TODA PARTE DE LOGICA DO MENU LATERAL
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilMicro3() {

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
            MainContentMicro3(
                scope = scope,
                iniciarJanela = iniciarJanela,
                valorDisponivel = "2.350,41",
                valorBloqueado = "1.050,25"
            )
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
                    BarraButtonMicro2()
                }
            }

        }
    )
}

// ESTE DATA CLASS É PARA CHAMAR OS ICONES TIPO SETA ETC..
data class SubMenusBotoesMcro3(

    val icone: ImageVector,
    val texto_botao: String,
    val numeroNotificao: Int,
    val booleanNotificao: Boolean
)


// AQUI ESTA OS BOTÕES DE ESCOLHO DO MENU LATERAL
@Composable
fun CustomMenuItemMicro3(
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


@Preview(showBackground = true)
@Composable
fun GreetingPreview11() {
    ConecTITheme {
        PerfilMicro3()
    }
}