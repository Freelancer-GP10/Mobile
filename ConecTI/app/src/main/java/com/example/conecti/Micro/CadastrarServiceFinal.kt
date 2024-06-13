package com.example.conecti.Micro

import UsuarioViewModel
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.DatePicker
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conecti.Freela.CustomMenuItem
import com.example.conecti.Freela.WorkSpaceFreela
import com.example.conecti.R
import com.example.conecti.ui.theme.ConecTITheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.Calendar
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.conecti.network.Service
import com.example.conecti.ui.theme.ConecTITheme

class CadastrarServiceFinal : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConecTITheme {
               ServicoCadastro2()
            }
        }
    }
}


@Composable
fun MainContentMicroDemanda(scope: CoroutineScope, iniciarJanela: DrawerState,usuarioViewModel: UsuarioViewModel) {

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

        val context = LocalContext.current

        // Conteúdo principal da tela
        // Use weight(1f) para ocupar todo o espaço disponível na tela
        Box(
            modifier = Modifier
                .fillMaxSize()

        ) {

            val nomeServico = remember { mutableStateOf("") }
            val descricaoServico = remember { mutableStateOf("") }
            val valorServico = remember { mutableStateOf("") }


            val listaTipoServico = listOf(
                "Consultoria",
                "Desenvolvimento",
                "Design",
                "Marketing",
                "Outro"
            )
            val context = LocalContext.current

            val dataIncioSelecionada = remember { mutableStateOf("") }
            val dataFinalSelecionada = remember { mutableStateOf("") }
            val calendario = Calendar.getInstance()

            val datePickerDialogInicio = DatePickerDialog(
                context,
                { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                    dataIncioSelecionada.value = "$dayOfMonth/${month + 1}/$year"
                },
                calendario.get(Calendar.YEAR),
                calendario.get(Calendar.MONTH),
                calendario.get(Calendar.DAY_OF_MONTH)
            )

            val datePickerDialogFinal = DatePickerDialog(
                context,
                { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                    dataFinalSelecionada.value = "$dayOfMonth/${month + 1}/$year"
                },
                calendario.get(Calendar.YEAR),
                calendario.get(Calendar.MONTH),
                calendario.get(Calendar.DAY_OF_MONTH)
            )


            val expandedTipoServico = remember { mutableStateOf(false) }


            val selectTipoServico = remember { mutableStateOf("") }


            Column(
                modifier = Modifier
                    .fillMaxSize(),
                //            .background(Color.Red),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Adicionar serviço",
                    color = Color(0xFF215683),
                    fontSize = 28.sp,
                    modifier = Modifier
                        .padding(start = 30.dp, bottom = 5.dp)
                        .align(Alignment.Start),

                    )

                Spacer(modifier = Modifier.height(20.dp))


                IconButton(
                    onClick = {
                        val mainIntent = Intent(context, ServiceMicro::class.java)
                        context.startActivity(mainIntent)
                    },
                    modifier = Modifier
                        .padding(start = 35.dp, bottom = 10.dp)
                        .align(Alignment.Start)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(0xFF215683), // Cor do ícone
                        modifier = Modifier.size(48.dp)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly

                ) {
                    OutlinedTextField(
                        value = dataIncioSelecionada.value,
                        onValueChange = { dataIncioSelecionada.value = it },
                        label = { Text(text = "Data de Inicio") },
                        modifier = Modifier
                            .height(60.dp)
                            .fillMaxWidth(0.47f),
                        trailingIcon = {
                            IconButton(onClick = { datePickerDialogInicio.show() }) {
                                Icon(
                                    imageVector = Icons.Default.DateRange,
                                    contentDescription = "Selecionar Data"
                                )
                            }
                        }
                    )

                    OutlinedTextField(
                        value = dataFinalSelecionada.value,
                        onValueChange = { dataFinalSelecionada.value = it },
                        label = { Text(text = "Prazo final") },
                        modifier = Modifier
                            .height(60.dp)
                            .fillMaxWidth(0.8f),
                        trailingIcon = {
                            IconButton(onClick = { datePickerDialogFinal.show() }) {
                                Icon(
                                    imageVector = Icons.Default.DateRange,
                                    contentDescription = "Selecionar Data"
                                )
                            }
                        }
                    )


                }
                Spacer(modifier = Modifier.padding(8.dp))

                OutlinedTextField(
                    value = nomeServico.value,
                    onValueChange = { nomeServico.value = it },
                    label = { Text(text = "Nome do serviço") },
                    modifier = Modifier
                        .height(60.dp)
                        .fillMaxWidth(0.88f)

                )

                Spacer(modifier = Modifier.padding(8.dp))


                OutlinedButton(
                    onClick = { expandedTipoServico.value = true },
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    modifier = Modifier
                        .fillMaxWidth(0.88f)
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

                            text = if (selectTipoServico.value.isEmpty()) "Tipo do serviço" else selectTipoServico.value,

                            modifier = Modifier
                                .weight(1f),
                            color = Color(0xFF4D4D4D),
                            fontWeight = FontWeight.W400,
                            fontSize = 18.sp
                        )
                    }
                    DropdownMenu(
                        expanded = expandedTipoServico.value,
                        onDismissRequest = { expandedTipoServico.value = false },
                        modifier = Modifier
                            .fillMaxWidth(0.80f)
                            .height(260.dp)
                            .background(Color(0xFF031224))
                    ) {
                        listaTipoServico.forEach { option ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = option,
                                        color = Color.White
                                    )
                                },
                                onClick = {
                                    selectTipoServico.value = option
                                    expandedTipoServico.value = false
                                })
                            Divider(color = Color.White)
                        }
                    }


                }

                Spacer(modifier = Modifier.padding(4.dp))





                Spacer(modifier = Modifier.padding(4.dp))


                OutlinedTextField(
                    value = descricaoServico.value,
                    onValueChange = { descricaoServico.value = it },
                    label = { Text(text = "Descrição") },
                    modifier = Modifier
                        .height(180.dp)
                        .fillMaxWidth(0.88f)
                )
                Spacer(modifier = Modifier.padding(4.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Spacer(modifier = Modifier.width(25.dp))
                    OutlinedTextField(
                        value = valorServico.value,
                        onValueChange = { valorServico.value = it },
                        label = { Text(text = "R\$:  Valor") },
                        modifier = Modifier
                            .height(60.dp)
                            .fillMaxWidth(0.6f)
                    )

                }


                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth(0.98f)
                        .padding(top = 30.dp)
                ) {

                    Button(
                        onClick = {

                            val servico = Service.CadastrarServicoDto(
                                nome = nomeServico.value,
                                prazo = dataFinalSelecionada.value,
                                dataInicio = dataIncioSelecionada.value,
                                valor = valorServico.value.toDouble(),
                                descricao = descricaoServico.value
                            )
                            usuarioViewModel.cadastrarServico(servico)


                        },
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(60.dp),
                        shape = RoundedCornerShape(7.dp)
                    ) {
                        Text(
                            text = "Cadastrar",
                            fontSize = 18.sp
                        )
                    }


                }

                Spacer(modifier = Modifier.padding(top = 120.dp))
            }

        }
    }
}


//AQUI ESTA TODA PARTE DO MENU LATERAL
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServicoCadastro2() {
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
                    CustomMenuItemMicroDemanda(
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
            MainContentMicroDemanda(scope = scope, iniciarJanela = iniciarJanela, UsuarioViewModel(contexto))
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom

                // Alinha o Column na parte inferior central da tela
            ) {

            }

        }
    )
}


// DATA CLASS PARA PODER CHAMAR OS ICONES
@Composable
fun CustomMenuItemMicroDemanda(
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
data class SubMenusBotoesMicroDemanda(

    val icone: ImageVector,
    val texto_botao: String,
    val numeroNotificao: Int,
    val booleanNotificao: Boolean
)
        

@Preview(showBackground = true)
@Composable
fun GreetingPreview16() {
    ConecTITheme {
        ServicoCadastro2()
    }
}