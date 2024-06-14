package com.example.conecti.cadastroInicial.FreelaInicio

import ModelFreela
import UsuarioViewModel
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conecti.Micro.ServiceMicro
import com.example.conecti.R
import com.example.conecti.RetrofitClient.context
import com.example.conecti.netWorkFreela.ServiceFreela
import com.example.conecti.network.Service
import com.example.conecti.ui.theme.ConecTITheme

class CadastroFreelaOne : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConecTITheme {
                Background()
                EtapaUmFreela( UsuarioViewModel(this))
            }
        }
    }

}


@Composable
fun Background() {
    val corHexadecimal = 0xFF9ED4DF
    val corInteira = corHexadecimal.toInt()
    // Substitua R.drawable.background_image pelo ID de sua imagem
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        Color(android.graphics.Color.parseColor("#FF9ED4DF"))
                    )
                )
            )
    ) {


        Image(
            painter = painterResource(id = R.mipmap.logo),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopStart) // Alinha a imagem ao canto superior esquerdo
                .size(100.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun EtapaUmFreela(modelFrela : UsuarioViewModel) {
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, // Centraliza horizontalmente
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {


        Spacer(modifier = Modifier.height(50.dp))


        val nomeFreela = remember { mutableStateOf("") }
        val sobrenomeFreela = remember { mutableStateOf("") }
        val cpfFreela = remember { mutableStateOf("") }
        val telefoneFreela = remember { mutableStateOf("") }
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
                .fillMaxWidth()
                .fillMaxHeight(0.9f),
            //       .background(Color.Red),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)

            ) {
                Spacer(modifier = Modifier.weight(1f)) // Ocupa todo o espaço à esquerda
                Text(
                    text = stringResource(R.string.finalize_registro_cadastro_freelaMicro_one),
                    fontSize = 30.sp
                )
                Spacer(modifier = Modifier.width(25.dp))
            }

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.weight(1f)) //
                Text(
                    text = stringResource(R.string.fique_por_dentro_cadastro_freelaMicro_one),
                )

                Spacer(modifier = Modifier.width(28.dp))

            }
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = nomeFreela.value,
                onValueChange = { nomeFreela.value = it },
                label = { Text(text = stringResource(R.string.label_nome)) },
                modifier = Modifier
                    .height(60.dp)
            )

            OutlinedTextField(
                value = sobrenomeFreela.value,
                onValueChange = { sobrenomeFreela.value = it },
                label = { Text(text = stringResource(R.string.label_sobrenome)) },
                modifier = Modifier
                    .height(60.dp)
            )

            Spacer(modifier = Modifier.padding(0.dp))

            OutlinedTextField(
                value = cpfFreela.value,
                onValueChange = { cpfFreela.value = it },
                label = { Text(text = stringResource(R.string.label_cpf)) },
                modifier = Modifier
                    .height(60.dp)

            )

            Spacer(modifier = Modifier.padding(0.dp))

            OutlinedTextField(
                value = telefoneFreela.value,
                onValueChange = { telefoneFreela.value = it },
                label = { Text(text = stringResource(R.string.label_telefone)) },
                modifier = Modifier
                    .height(60.dp)

            )


            Spacer(modifier = Modifier.padding(4.dp))

            OutlinedButton(
                onClick = { expandedArea.value = true },
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                modifier = Modifier
                    .fillMaxWidth(0.78f)
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

                        text = if (selectedArea.value.isEmpty())  stringResource(R.string.label_area_atuacao) else selectedArea.value,

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

            OutlinedButton(
                onClick = { expandedLinguagem.value = true },
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                modifier = Modifier
                    .fillMaxWidth(0.78f)
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

                        text = if (selectedLinguagem.value.isEmpty())  stringResource(R.string.label_linguagem_atuacao) else selectedLinguagem.value,

                        modifier = Modifier
                            .weight(1f),
                        color = Color(0xFF4D4D4D),
                        fontWeight = FontWeight.W400,
                        fontSize = 18.sp
                    )
                }
                DropdownMenu(
                    expanded = expandedLinguagem.value,
                    onDismissRequest = { expandedLinguagem.value = false },
                    modifier = Modifier
                        .fillMaxWidth(0.68f)
                        .height(260.dp)
                        .background(Color(0xFF031224))
                ) {
                    listaLinguagens.forEach { option ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = option,
                                    color = Color.White
                                )
                            },
                            onClick = {
                                selectedLinguagem.value = option
                                expandedLinguagem.value = false
                            })
                        Divider(color = Color.White)
                    }
                }


            }


            Spacer(modifier = Modifier.padding(4.dp))

            OutlinedButton(
                onClick = { expandedFormacao.value = true },
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                modifier = Modifier
                    .fillMaxWidth(0.78f)
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

                        text = if (selectedFormacao.value.isEmpty()) stringResource(R.string.label_formacao) else selectedFormacao.value,

                        modifier = Modifier
                            .weight(1f),
                        color = Color(0xFF4D4D4D),
                        fontWeight = FontWeight.W400,
                        fontSize = 18.sp
                    )
                }
                DropdownMenu(
                    expanded = expandedFormacao.value,
                    onDismissRequest = { expandedFormacao.value = false },
                    modifier = Modifier
                        .fillMaxWidth(0.68f)
                        .height(160.dp)
                        .background(Color(0xFF031224))
                ) {
                    listaFormacao.forEach { option ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = option,
                                    color = Color.White
                                )
                            },
                            onClick = {
                                selectedFormacao.value = option
                                expandedFormacao.value = false
                            })
                        Divider(color = Color.White)
                    }
                }


            }

            Spacer(modifier = Modifier.heightIn(38.dp))
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 25.dp),

                ) {
                OutlinedButton(
                    onClick = {
                        modelFrela.cadastrarFreelancer(
                            ServiceFreela.freelaDetailsDto(
                                nomeFreela.value,
                                sobrenomeFreela.value,
                                cpfFreela.value,
                                telefoneFreela.value,
                                selectedArea.value,
                                selectedLinguagem.value,
                                selectedFormacao.value
                            )
                        )
                        val serviceFreela = Intent(context, com.example.conecti.Freela.ServiceFreela::class.java)
                        context.startActivity(serviceFreela)
                    },

                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(2.dp, Color(0xFF204A7B)),
                    modifier = Modifier
                        .width(140.dp)
                        .height(50.dp)
                ) {
                    Text(
                        fontSize = 21.sp,
                        color = Color(0xFF204A7B),
                        fontWeight = FontWeight.W400,
                        text = stringResource(R.string.botao_continuar)
                    )
                }

            }


        }

    }











    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End, // Centraliza horizontalmente
        modifier = Modifier
            .fillMaxHeight(0.94f)


    ) {


        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Canvas(
                modifier = Modifier
                    .size(44.dp)
            ) {
                drawCircle(
                    color = Color(0xFF204A7B),
                    radius = 22f,
                    center = center
                )
            }

            Canvas(
                modifier = Modifier
                    .size(44.dp)
            ) {
                drawCircle(
                    color = Color.White,
                    radius = 22f,
                    center = center
                )
            }


        }


    }

}


@Preview(showBackground = true)
@Composable
fun FreelaOnePreview() {
    MaterialTheme {
        Background()
       // EtapaUmFreela( UsuarioViewModel(null))
    }
}