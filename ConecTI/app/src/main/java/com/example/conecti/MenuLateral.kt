package com.example.conecti

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conecti.ui.theme.ConecTITheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MenuLateral : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConecTITheme {
                Menu()
            }

        }
    }
}

@Composable
fun MainContent(scope: CoroutineScope, iniciarJanela: DrawerState) {
    IconButton(
        onClick = {
            scope.launch {
                iniciarJanela.open()
            }
        },
        modifier = Modifier.padding(top = 6.dp, start = 6.dp ), // Adiciona um espaçamento de 8dp na parte inferior
    ) {
        Icon(
            imageVector = Icons.Filled.Menu,
            contentDescription = "menu Icon",
            tint = Color(0xFF50FAAB),
            modifier = Modifier.size(40.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Menu() {

    val subMenus = listOf(
        SubMenusBotoes(Icons.Default.AccountCircle, "Perfil", 0, false),
        SubMenusBotoes(Icons.Rounded.Home, "WorkSpace", 32, true),
        SubMenusBotoes(Icons.Filled.Build, "Services", 32, true),
        SubMenusBotoes(Icons.Filled.ShoppingCart, "Pay", 0, false),
        SubMenusBotoes(Icons.Filled.Call, "Contato", 0, false)
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
                    .fillMaxSize()
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
                    .fillMaxHeight() // Preenche toda a altura disponível
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
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        Modifier.wrapContentSize(),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.CenterHorizontally,


                        ) {

                        Image(
                            painter = painterResource(id = R.mipmap.luva),
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
                        }
                    )
                }



                Spacer(modifier = Modifier.height(40.dp))
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

            }
        }
    }, drawerState = iniciarJanela,
        content = {
            MainContent(scope = scope, iniciarJanela = iniciarJanela )
        }
    )
}

data class SubMenusBotoes(

    val icone: ImageVector,
    val texto_botao: String,
    val numeroNotificao: Int,
    val booleanNotificao: Boolean
)

@Composable
fun CustomMenuItem(
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
fun GreetingPreview3() {
    ConecTITheme {
        Menu()
    }
}