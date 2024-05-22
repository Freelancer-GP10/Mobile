package com.example.conecti

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.conecti.ui.theme.ConecTITheme
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.ui.graphics.Brush

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.model.Circle

class Cadastro_Freela_Dois : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConecTITheme {
                Background()
                EtapaUm8()
            }
        }
    }
}


@Composable
fun EtapaUm8() {

    val areaAtuacao = remember {
        mutableStateOf(TextFieldValue())
    }

    val nFuncionarios = remember {
        mutableStateOf(TextFieldValue())
    }




    Row(
        modifier = Modifier.fillMaxWidth()
    ) {

        var expanded = remember { mutableStateOf(false) }
        val selectedOption = remember { mutableStateOf("") }
        val options = listOf(
            "Tecnologia da Informação",
            "Saúde e Medicina",
            "Educação",
            "Financeira e Bancária",
            "Agricultura",
            "Energia e Sustentabilidade",
            "Varejo",
            "Construção e Imóveis",
            "Alimentos e Bebidas",
            "Automobilística",
            "Entretenimento e Mídia",
            "Turismo e Hospitalidade",
            "Manufatura",
            "Telecomunicações",
            "Serviços de Consultoria",
            "Transporte e Logística",
            "Moda e Vestuário",
            "Outros"
        )

        val expandedArea = remember { mutableStateOf(false) }
        val expandedLinguagem = remember { mutableStateOf(false) }
        val expandedFormacao = remember { mutableStateOf(false) }

        val selectedArea = remember { mutableStateOf("") }
        val selectedLinguagem = remember { mutableStateOf("") }
        val selectedFormacao = remember { mutableStateOf("") }


        val selectedOption2 = remember { mutableStateOf("") }
        val listaArea = listOf(
            "Front-End",
            "Back-End",
            "UX Design",
            "DevOps",
            "QA"
        )
        val listaLinguagens = listOf(
            "Java",
            "C",
            "C++",
            "C#",
            "Assemble"
        )
        val listaFormacao = listOf(
            "ADS",
            "CCO",
            "SIS"
        )
        val expandIcon =
            if (expandedArea.value) Icons.Default.KeyboardArrowUp else Icons.Default.ArrowDropDown


        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center


        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.Center)


            ) {


                Box(
                    modifier = Modifier
                        .height(100.dp)


                ) {


                    OutlinedButton(
                        onClick = { expandedArea.value = true },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(59.5.dp),
                        contentPadding = PaddingValues(
                            start = 0.dp,
                            top = 15.dp,
                            end = 19.dp,
                            bottom = 12.dp
                        )

                    ) {

                        Row() {


                            Text(

                                text = if (selectedArea.value.isEmpty()) "  Area de atuação" else selectedArea.value,

                                modifier = Modifier
                                    .fillMaxWidth(),

                                color = Color(0xFF031224),
                                fontWeight = FontWeight.W400,
                                fontSize = 24.sp
                            )



                        }
                        DropdownMenu(
                            expanded = expandedArea.value,
                            onDismissRequest = { expandedArea.value = false },
                            modifier = Modifier
                                .fillMaxWidth(0.9f)
                                .height(160.dp)
                                .background(Color(0xFF031224))
                        ) {
                            listaArea.forEach { option ->
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            color = Color.White,
                                            text = option
                                        )
                                    },
                                    // contentPadding = PaddingValues(start = 16.dp, top = 8.dp, end = 33.dp, bottom = 8.dp),

                                    onClick = {
                                        selectedArea.value = option
                                        expandedArea.value = false
                                    },

                                    )
                                Divider(color = Color.White)
                            }
                        }
                    }
                }


                OutlinedButton(
                    onClick = { expandedLinguagem.value = true },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(59.5.dp),
                    contentPadding = PaddingValues(
                        start = 0.dp,
                        top = 15.dp,
                        end = 19.dp,
                        bottom = 12.dp
                    )

                ) {

                    Row() {


                        Text(

                            text = if (selectedLinguagem.value.isEmpty()) "  Linguagem de Dominio" else selectedLinguagem.value,

                            modifier = Modifier
                                .fillMaxWidth(),
                            color = Color(0xFF031224),
                            fontWeight = FontWeight.W400,
                            fontSize = 23.sp
                        )

                        IconButton(
                            onClick = { expandedArea.value = !expandedArea.value },
                            modifier = Modifier
                                .padding(end = 8.dp)
                        ) {
                            Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                        }

                    }
                    DropdownMenu(
                        expanded = expandedLinguagem.value,
                        onDismissRequest = { expandedLinguagem.value = false },
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(160.dp)
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
                Spacer(modifier = Modifier.height(40.dp))

                OutlinedButton(
                    onClick = { expandedFormacao.value = true },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(59.5.dp),
                    contentPadding = PaddingValues(
                        start = 0.dp,
                        top = 15.dp,
                        end = 19.dp,
                        bottom = 12.dp
                    )

                ) {

                    Row() {


                        Text(

                            text = if (selectedFormacao.value.isEmpty()) "  Formação" else selectedFormacao.value,

                            modifier = Modifier
                                .fillMaxWidth(),
                            color = Color(0xFF031224),
                            fontWeight = FontWeight.W400,
                            fontSize = 23.sp
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Dropdown arrow",
                            tint = Color(0xFF031224)
                        )


                    }
                    DropdownMenu(
                        expanded = expandedFormacao.value,
                        onDismissRequest = { expandedFormacao.value = false },
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(160.dp)
                            .background(Color(0xFF031224))
                    ) {
                        listaFormacao.forEach { option ->
                            DropdownMenuItem(
                                text = { Text(text = option, color = Color.White) },
                                onClick = {
                                    selectedFormacao.value = option
                                    expandedFormacao.value = false
                                })
                            Divider(color = Color.White)

                        }
                    }
                }

                Spacer(modifier = Modifier.height(80.dp))



                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                )  {

                    OutlinedButton(
                        onClick = { /*TODO*/ },
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
                            text = "Continuar")



                    }
                    Spacer(modifier = Modifier.width(30.dp))
                }



            }



            Column(
                modifier = Modifier
                    .offset(y = 300.dp)
                    .height(50.dp)
                    .width(130.dp)
                    .size(20.dp)

            ) {

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Canvas(
                        modifier = Modifier.weight(1f)
                    ) {
                        drawCircle(
                            color = Color.White,
                            radius = 22f,
                            center = center
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Canvas(
                        modifier = Modifier.weight(1f)
                    ) {
                        drawCircle(
                            color = Color(0xFF204A7B),
                            radius = 22f,
                            center = center
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Canvas(
                        modifier = Modifier.weight(1f)
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


    }


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview7() {
    ConecTITheme {
        Background()
        EtapaUm8()
    }
}