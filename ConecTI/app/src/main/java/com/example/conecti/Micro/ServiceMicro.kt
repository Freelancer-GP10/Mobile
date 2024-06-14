package com.example.conecti.Micro

import UsuarioViewModel
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.twotone.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conecti.ButtonBars.BarraButton4
import com.example.conecti.ButtonBars.BarraButtonMicro4
import com.example.conecti.Freela.CustomMenuItem
import com.example.conecti.Freela.HistoricoPay
import com.example.conecti.Freela.Perfil_Freela_One
import com.example.conecti.Freela.ServiceFreela
import com.example.conecti.Freela.SubMenusBotoes
import com.example.conecti.Freela.WorkSpaceFreela
import com.example.conecti.R
import com.example.conecti.cadastroInicial.FreelaInicio.CadastroFreelaOne
import com.example.conecti.ui.theme.ConecTITheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ServiceMicro : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConecTITheme {
            PerfilMicro5()
            }
        }
    }
}

//AQUI ESTA AS VARIAVEIS E OS COMPONENTES DAS DEMANDAS
@Composable
fun componentesServiceMicro(
    tagTipo: String,
    titulo: String,
    empresa: String,
    description: String,
    valor: String,
    data: String

) {
    var expanded by remember { mutableStateOf(false) }
    val showExpandButton = description.length > 40
    val displayText =
        if (expanded || !showExpandButton) description else description.take(70) + "..."
    Box(
        modifier = Modifier
            //.fillMaxWidth()
            .fillMaxSize()
            //.height(200.dp)
            //.background(Color.Yellow)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(8.dp))
                .border(1.dp, Color(0xFF204A7B), RoundedCornerShape(8.dp))
            //.background(Color.Green)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.64f),
                //.background(Color.Red),
                horizontalAlignment = Alignment.Start

            ) {
                Text(
                    text = "[ ${tagTipo} ] - ${titulo}",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 8.dp, top = 15.dp)
                )
                Text(
                    text = "Empresa: ${empresa}",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 8.dp, top = 2.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val annotatedText = buildAnnotatedString {
                        append("Demanda: $displayText ")
                        if (showExpandButton) {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Blue,
                                    textDecoration = TextDecoration.Underline
                                )
                            ) {
                                append(if (expanded) "Ver menos" else "Ver mais")
                            }
                        }
                    }

                    ClickableText(
                        text = annotatedText,
                        onClick = {
                            if (showExpandButton) {
                                expanded = !expanded
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),

                        )
                }

            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.34f)
                    //.background(Color.Blue)
                    .align(Alignment.TopEnd),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "R$ ${valor}",
                    fontSize = 15.sp,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Inicio: ${data}",
                    fontSize = 15.sp
                )

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(top = 15.dp, bottom = 15.dp, end = 7.dp)
                        .height(40.dp)
                        .width(140.dp),
                    shape = RoundedCornerShape(7.dp)
                ) {
                    Text(
                        text = "Aguardando",
                        fontSize = 12.sp,

                        )
                }

            }
        }

    }
}

// AQUI ESTA O ÍCONE DO MENU E O CONTEUDO INICIAL VISIVEL
@Composable
fun MainContentMicro5(extras: Bundle?,scope: CoroutineScope, iniciarJanela: DrawerState, usuarioViewModel: UsuarioViewModel) {
val context = LocalContext.current
    val pesquisaPay = remember { mutableStateOf("") }
    var servicos =  usuarioViewModel.servicos.observeAsState().value


    LaunchedEffect(Unit) {
        usuarioViewModel.fetchProximosServicos()
    }

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
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Service",
                        color = Color(0xFF215683),
                        fontSize = 38.sp,
                        modifier = Modifier
                            .padding(start = 0.dp, bottom = 0.dp, end = 30.dp)
                    )

                    //Spacer(modifier = Modifier.width(25.dp)) // Espaço entre o texto e o botão

                    Button(
                        onClick = {
                            val adicionarDemandas = Intent(context, CadastrarServiceFinal::class.java)
                            context.startActivity(adicionarDemandas)
                        },
                        modifier = Modifier.padding(start = 30.dp),
                        shape = RoundedCornerShape (7.dp)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "Adicionar", fontSize = 15.sp)
                            Text(text = "Servico", fontSize = 15.sp)
                        }
                    }
                }



                Spacer(modifier = Modifier.height(20.dp))


                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    //.background(Color.Red)
                    //.padding(start = 30.dp),
                    horizontalArrangement = Arrangement.Center,

                    ) {

                    OutlinedTextField(
                        value = pesquisaPay.value,
                        onValueChange = { pesquisaPay.value = it },
                        label = {
                            Text(
                                "Pesquisar",
                                modifier = Modifier
                                    .fillMaxSize(),
                                textAlign = TextAlign.Start
                            )
                        },
                        modifier = Modifier
                            .width(280.dp) // Define a largura desejada
                            .height(58.dp), // Define a altura desejada
                        trailingIcon = {
                            IconButton(
                                onClick = {
                                    // Ação ao clicar no ícone de lupa
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.TwoTone.Search,
                                    contentDescription = "Pesquisar"
                                )
                            }
                        }
                    )

                }

                Spacer(modifier = Modifier.height(20.dp))


                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 50.dp),
                    verticalArrangement = Arrangement.spacedBy(-15.dp) // Espaço de 4dp entre os itens
                ) {

                    if(servicos != null){
                        items(items = servicos) { servico ->
                            componentesServiceMicro(
                                tagTipo = servico.nome?: "tag nula",
                                titulo = servico.nome?: "titulo nulo",
                                empresa = "nome da empresa"?: "nome Da empresa nulo",
                                description = servico.descricao?: "DEscricao sla",
                                valor =  "${servico.valor}"?: "valor nulo" ,
                                data =  "${servico.prazo}"?:"data nula"
                            )
                        }
                    }else{
                        Log.i("tag", "foi nullo")
                    }



                }


            }

        }
    }
}


// AQUI ESTA TODA PARTE DE LOGICA DO MENU LATERAL
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilMicro5() {
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

            MainContentMicro5(extras = null, scope = scope, iniciarJanela = iniciarJanela, usuarioViewModel=UsuarioViewModel(contexto))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 60.dp),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom


                // Alinha o Column na parte inferior central da tela
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    BarraButtonMicro4()
                }
            }
        }
    )

}

// ESTE DATA CLASS É PARA CHAMAR OS ICONES TIPO SETA ETC..
data class SubMenusBotoesMicro5(

    val icone: ImageVector,
    val texto_botao: String,
    val numeroNotificao: Int,
    val booleanNotificao: Boolean
)


// AQUI ESTA OS BOTÕES DE ESCOLHO DO MENU LATERAL
@Composable
fun CustomMenuItemMicro5(
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
fun GreetingPreview5() {
    ConecTITheme {
        PerfilMicro5()
    }
}
