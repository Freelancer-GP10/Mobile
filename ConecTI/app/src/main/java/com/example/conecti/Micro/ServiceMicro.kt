package com.example.conecti.Micro

import UsuarioViewModel
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.conecti.ButtonBars.BarraButtonMicro4
import com.example.conecti.Freela.CustomMenuItem
import com.example.conecti.Freela.SubMenusBotoes
import com.example.conecti.R
import com.example.conecti.ui.theme.ConecTITheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ServiceMicro : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConecTITheme {
                val viewModel: UsuarioViewModel = viewModel()
                ServicoScreen(servicoViewModel = viewModel)
            }
        }
    }
}

@Composable
fun componentesServiceMicro(
    id: String,
    titulo: String,

    description: String,
    valor: String,
    data: String
) {
    var expanded by remember { mutableStateOf(false) }
    val showExpandButton = description.length > 40
    val displayText = if (expanded || !showExpandButton) description else description.take(70) + "..."

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(8.dp))
                .border(1.dp, Color(0xFF204A7B), RoundedCornerShape(8.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.66f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "[ $id ] - $titulo",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 8.dp, top = 15.dp)
                )
                Text(
                    text = "Empresa: ",
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
                            .padding(bottom = 8.dp)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.34f)
                    .align(Alignment.TopEnd),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "R$ $valor",
                    fontSize = 15.sp,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Inicio: $data",
                    fontSize = 15.sp
                )
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(top = 15.dp, bottom = 15.dp, end = 10.dp)
                        .height(40.dp)
                        .width(125.dp),
                    shape = RoundedCornerShape(7.dp)
                ) {
                    Text(
                        text = "Aguardando",
                        fontSize = 10.sp,
                    )
                }
            }
        }
    }
}

@Composable
fun ServicoScreen(servicoViewModel: UsuarioViewModel = viewModel()) {
    val servicos by servicoViewModel.servicos.observeAsState(initial = emptyList())
    val errorMessage by servicoViewModel.errorMessage.observeAsState("")

    LaunchedEffect(Unit) {
        servicoViewModel.fetchProximosServicos()
    }

    if (errorMessage.isNotEmpty()) {
        Text(text = errorMessage, modifier = Modifier.padding(16.dp))
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            items(servicos.size) { servico ->
                componentesServiceMicro(
                    id = servicos[servico].id.toString(),
                    titulo = servicos[servico].nome,
                    description = servicos[servico].descricao,
                    valor = servicos[servico].valor.toString(),
                    data = servicos[servico].dataInicio.toString()
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}


    @Composable
    fun MainContentMicro5(scope: CoroutineScope, iniciarJanela: DrawerState) {
        val pesquisaPay = remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 15.dp)
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
                ),
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "menu Icon",
                    tint = Color(0xFF50FAAB),
                    modifier = Modifier.size(40.dp)
                )
            }

            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 24.dp)
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            text = "Service",
                            color = Color(0xFF215683),
                            fontSize = 38.sp,
                            modifier = Modifier.padding(start = 0.dp, bottom = 10.dp)
                        )

                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .height(60.dp)
                                .width(125.dp),
                            shape = RoundedCornerShape(7.dp)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Aguardando",
                                    fontSize = 14.sp,
                                )
                                Text(
                                    text = "Serviço",
                                    fontSize = 14.sp,
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        OutlinedTextField(
                            value = pesquisaPay.value,
                            onValueChange = { pesquisaPay.value = it },
                            label = {
                                Text(
                                    "Pesquisar",
                                    modifier = Modifier.fillMaxSize(),
                                    textAlign = TextAlign.Start
                                )
                            },
                            modifier = Modifier
                                .width(280.dp)
                                .height(58.dp),
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

                    // Substituir a lista estática pelo ServicoScree
                    ServicoScreen()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun PerfilMicro5() {
        val contexto = LocalContext.current
        val subMenus = listOf(
            SubMenusBotoes(Icons.Default.AccountCircle, "Perfil", 0, false),
            SubMenusBotoes(Icons.Rounded.Home, "WorkSpace", 32, true),
            SubMenusBotoes(Icons.Filled.Build, "Services", 32, true),
            SubMenusBotoes(Icons.Filled.ShoppingCart, "Pay", 0, false)
        )
        val subMenus2 = listOf(
            SubMenusBotoes(Icons.Default.ExitToApp, "Sair", 0, false)
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
                                    Color(0xFF2978B5),
                                    Color(0xFF3C99DC)
                                )
                            )
                        )
                        .padding(vertical = 24.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.side_nav_bar),
                        contentDescription = "logo empresa",
                        modifier = Modifier
                            .padding(4.dp)
                            .size(200.dp)
                            .align(Alignment.CenterHorizontally)
                            .clip(CircleShape)
                    )

//                subMenus.forEach { item ->
//                    CustomMenuItem(item = item) {
//                        selecilionarSubMenu.value = item
//                        scope.launch {
//                            iniciarJanela.close()
//                        }
////                        if (item.nome == "Perfil") {
////                            val telaPerfilMicro =
////                                Intent(contexto, com.example.conecti.Perfil_Micro_One::class.java)
////                            contexto.startActivity(telaPerfilMicro)
////                        }
////                        if (item.nome == "Services") {
////                            val telaServicesMicro =
////                                Intent(contexto, com.example.conecti.Micro.ServiceMicro::class.java)
////                            contexto.startActivity(telaServicesMicro)
////                        }
//                    }
//                }
                }
            }
        }, drawerState = iniciarJanela) {
            Scaffold(
                bottomBar = {
                    BarraButtonMicro4(
//                    home = {
//                        val home = Intent(contexto, com.example.conecti.Telas::class.java)
//                        contexto.startActivity(home)
//                    },
//                    services = {
//                        val services =
//                            Intent(contexto, com.example.conecti.Micro.ServiceMicro::class.java)
//                        contexto.startActivity(services)
//                    },
//
                    )
                },
                content = { paddingValues ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {
                        MainContentMicro5(scope, iniciarJanela)
                    }
                }
            )
        }
    }

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    ConecTITheme {
        PerfilMicro5()

    }
}
