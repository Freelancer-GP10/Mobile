package com.example.conecti.Micro

import android.content.Intent
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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conecti.ButtonBars.BarraButtonMicro1
import com.example.conecti.Freela.CustomMenuItem
import com.example.conecti.R
import com.example.conecti.ui.theme.ConecTITheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class Perfil_Micro_Dois : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConecTITheme {
                PerfilMicro2()
            }
        }
    }
}


@Composable
fun MainContentMicro2(scope: CoroutineScope, iniciarJanela: DrawerState) {
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

            val nomeFreela = remember { mutableStateOf("") }
            val sobrenomeFreela = remember { mutableStateOf("") }
            val cpfFreela = remember { mutableStateOf("") }
            val telefoneFreela = remember { mutableStateOf("") }
            val emailFreela = remember { mutableStateOf("") }
            val senhaFreela = remember { mutableStateOf("") }

            val expandedLinguagem = remember { mutableStateOf(false) }
            val selectedLinguagem = remember { mutableStateOf("") }
            val listaLinguagens = listOf(
                "Java",
                "C",
                "C++",
                "C#",
                "Assemble"
            )
            val listaArea = listOf(
                "Front-End",
                "Back-End",
                "UX Design",
                "DevOps",
                "QA"
            )
            val listaFormacao = listOf(
                "ADS",
                "CCO",
                "SIS"
            )

            val expandedArea = remember { mutableStateOf(false) }
            val expandedFormacao = remember { mutableStateOf(false) }


            val selectedArea = remember { mutableStateOf("") }
            val selectedFormacao = remember { mutableStateOf("") }


            Column(
                modifier = Modifier
                    .fillMaxSize(),
                //            .background(Color.Red),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Perfil",
                    color = Color(0xFF215683),
                    fontSize = 38.sp,
                    modifier = Modifier
                        .padding(start = 30.dp, bottom = 0.dp)
                        .align(Alignment.Start),

                    )

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Dados Provados da Empresa",
                    modifier = Modifier
                        .padding(start = 30.dp, bottom = 40.dp)
                        .align(Alignment.Start),
                    fontSize = 17.sp

                )



                OutlinedTextField(
                    value = nomeFreela.value,
                    onValueChange = { nomeFreela.value = it },
                    label = { Text(text = "Nome da Empresa") },
                    modifier = Modifier
                        .height(60.dp)
                )

                Spacer(modifier = Modifier.padding(8.dp))


                OutlinedButton(
                    onClick = { expandedArea.value = true },
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    modifier = Modifier
                        .fillMaxWidth(0.717f)
                        .height(53.5.dp),
                    contentPadding = PaddingValues(
                        start = 16.dp,
                        top = 15.dp,
                        end = 0.dp,
                        bottom = 12.dp
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically, // Alinha o texto verticalmente
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(

                            text = if (selectedArea.value.isEmpty()) "Ramo" else selectedArea.value,

                            modifier = Modifier
                                .weight(1f),
                            color = Color(0xFF4D4D4D),
                            fontWeight = FontWeight.W400,
                            fontSize = 18.sp
                        )
                    }
                    DropdownMenu(
                        expanded = expandedArea.value,
                        onDismissRequest = { expandedArea.value = false },
                        modifier = Modifier
                            .fillMaxWidth(0.68f)
                            .height(260.dp)
                            .background(Color(0xFF031224))
                    ) {
                        listaArea.forEach { option ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = option,
                                        color = Color.White
                                    )
                                },
                                onClick = {
                                    selectedArea.value = option
                                    expandedArea.value = false
                                })
                            Divider(color = Color.White)
                        }
                    }


                }

                Spacer(modifier = Modifier.padding(4.dp))

                OutlinedTextField(
                    value = cpfFreela.value,
                    onValueChange = { cpfFreela.value = it },
                    label = { Text(text = "CNPJ") },
                    modifier = Modifier
                        .height(60.dp)

                )

                Spacer(modifier = Modifier.padding(4.dp))

                OutlinedTextField(
                    value = telefoneFreela.value,
                    onValueChange = { telefoneFreela.value = it },
                    label = { Text(text = "Telefone") },
                    modifier = Modifier
                        .height(60.dp)

                )
                Spacer(modifier = Modifier.padding(4.dp))


                OutlinedTextField(
                    value = emailFreela.value,
                    onValueChange = { emailFreela.value = it },
                    label = { Text(text = "Email") },
                    modifier = Modifier
                        .height(60.dp)
                )
                Spacer(modifier = Modifier.padding(4.dp))

                OutlinedTextField(
                    value = senhaFreela.value,
                    onValueChange = { senhaFreela.value = it },
                    label = { Text(text = "Senha") },
                    modifier = Modifier
                        .height(60.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),

                    )

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth(0.98f)
                        .padding(top = 30.dp)
                    //                .background(Color.Red)
                ) {

                    Button(
                        onClick = { /* Salvar */ },
                        modifier = Modifier
                            .width(100.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(7.dp)
                    ) {
                        Text(
                            text = "Salvar",
                            fontSize = 16.sp
                        )
                    }

                    Button(
                        onClick = { /* Editar */ },
                        modifier = Modifier
                            .width(100.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(7.dp)
                    ) {
                        Text(
                            text = "Editar",
                            fontSize = 16.sp
                        )
                    }

                    Button(
                        onClick = { /* Cancelar */ },
                        modifier = Modifier
                            .width(115.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(7.dp)
                    ) {
                        Text(
                            text = "Cancelar",
                            fontSize = 16.sp
                        )
                    }
                }
                //Spacer(modifier = Modifier.padding(bottom = 40.dp))

                Spacer(modifier = Modifier.padding(top = 120.dp))
            }

        }
    }
}


//AQUI ESTA TODA PARTE DO MENU LATERAL
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilMicro2() {
    val contexto = LocalContext.current

    val subMenus = listOf(
        SubMenusBotoesMicro2(Icons.Default.AccountCircle, "Perfil", 0, false),
        SubMenusBotoesMicro2(Icons.Rounded.Home, "WorkSpace", 32, true),
        SubMenusBotoesMicro2(Icons.Filled.Build, "Services", 32, true),
        SubMenusBotoesMicro2(Icons.Filled.ShoppingCart, "Pay", 0, false),
    )
    val subMenus2 = listOf(
        SubMenusBotoesMicro2(Icons.Default.ExitToApp, "Sair", 0, false),
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
                    CustomMenuItemMicro2(
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
                            } else if (it.texto_botao == "Services") {
                                val mainIntent = Intent(contexto, ServiceMicro::class.java)
                                contexto.startActivity(mainIntent)
                            } else if (it.texto_botao == "Pay") {
                                val mainIntent = Intent(contexto, HistoricoPayMicro::class.java)
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
            MainContentMicro2(scope = scope, iniciarJanela = iniciarJanela)
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


// DATA CLASS PARA PODER CHAMAR OS ICONES
@Composable
fun CustomMenuItemMicro2(
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


// AQUI ESTA OS BOTÕES DE ESCOLHO DO MENU LATERAL
data class SubMenusBotoesMicro2(

    val icone: ImageVector,
    val texto_botao: String,
    val numeroNotificao: Int,
    val booleanNotificao: Boolean
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview12() {
    ConecTITheme {
        PerfilMicro2()
    }
}