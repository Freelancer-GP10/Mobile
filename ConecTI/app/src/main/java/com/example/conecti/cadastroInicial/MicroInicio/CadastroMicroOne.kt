package com.example.conecti.cadastroInicial.MicroInicio

import MicroViewModel
import UsuarioViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.conecti.RetrofitClient.context
import com.example.conecti.cadastroInicial.FreelaInicio.Background
import com.example.conecti.netWorkMIcro.ServiceMicro
import com.example.conecti.ui.theme.ConecTITheme


class CadastroMicroOne : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConecTITheme {
                Background()
                EtapaUmMMicro()
            }
        }
    }
}

@Composable
fun EtapaUmMMicro(viewModel: MicroViewModel = MicroViewModel(LocalContext.current)) {
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, // Centraliza horizontalmente
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {


        Spacer(modifier = Modifier.height(50.dp))


        val nomeEmpresa = remember { mutableStateOf("") }
        val cnpjEmpresa = remember { mutableStateOf("") }
        val telefoneEmpresa = remember { mutableStateOf("") }


        val listaRamos = listOf(
            "Predreiro",
            "Traficante",
            "Progamagador"
        )

        val expandeRamo = remember { mutableStateOf(false) }


        val selectedRamo = remember { mutableStateOf("") }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f),
            //       .background(Color.Red),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(95.dp))

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)

            ) {
                Spacer(modifier = Modifier.weight(1f)) // Ocupa todo o espaço à esquerda
                Text(
                    text = "Finalize seu registro",
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
                    text = "E fique por dentro de tudo!",
                )

                Spacer(modifier = Modifier.width(28.dp))

            }
            Spacer(modifier = Modifier.height(50.dp))

            OutlinedTextField(
                value = nomeEmpresa.value,
                onValueChange = { nomeEmpresa.value = it },
                label = { Text(text = "Nome") },
                modifier = Modifier
                    .height(60.dp)
            )




            OutlinedTextField(
                value = cnpjEmpresa.value,
                onValueChange = { cnpjEmpresa.value = it },
                label = { Text(text = "CPF") },
                modifier = Modifier
                    .height(60.dp)

            )
            Spacer(modifier = Modifier.padding(4.dp))

            OutlinedButton(
                onClick = { expandeRamo.value = true },
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

                        text = if (selectedRamo.value.isEmpty()) "Ramo" else selectedRamo.value,

                        modifier = Modifier
                            .weight(1f),
                        color = Color(0xFF4D4D4D),
                        fontWeight = FontWeight.W400,
                        fontSize = 18.sp
                    )
                }
                DropdownMenu(
                    expanded = expandeRamo.value,
                    onDismissRequest = { expandeRamo.value = false },
                    modifier = Modifier
                        .fillMaxWidth(0.68f)
                        .height(160.dp)
                        .background(Color(0xFF031224))
                ) {
                    listaRamos.forEach { option ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = option,
                                    color = Color.White
                                )
                            },
                            onClick = {
                                selectedRamo.value = option
                                expandeRamo.value = false
                            })
                        Divider(color = Color.White)
                    }
                }


            }

            Spacer(modifier = Modifier.padding(0.dp))

            OutlinedTextField(
                value = telefoneEmpresa.value,
                onValueChange = { telefoneEmpresa.value = it },
                label = { Text(text = "Telefone") },
                modifier = Modifier
                    .height(60.dp)

            )


            Spacer(modifier = Modifier.padding(4.dp))






            Spacer(modifier = Modifier.heightIn(38.dp))
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 25.dp),

                ) {
                OutlinedButton(
                    onClick = {
                        // Chamada para cadastrar
                        val cadastroDto = ServiceMicro.CadastrarEmpresaDto(
                            nome = nomeEmpresa.value,
                            cnpj = cnpjEmpresa.value,
                            ramo = selectedRamo.value,
                            telefone = telefoneEmpresa.value
                        )
                        viewModel.cadastrarEmpresa(cadastroDto) { response ->
                            if (response.isSuccessful) {
                                println("Empresa cadastrada com sucesso")
                            } else {
                                println("Erro ao cadastrar empresa: ${response.errorBody()?.string()}")
                            }
                        }
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
                        text = "Continuar"
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
fun GreetingPreview2() {
    ConecTITheme {
        Background()
        EtapaUmMMicro()
    }
}