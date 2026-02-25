package com.gundes.jogo_memoria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gundes.jogo_memoria.ui.theme.JogomemoriaTheme
import com.gundes.jogo_memoria.utils.numeroParaImagem
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import com.gundes.jogo_memoria.utils.randomizer
import com.gundes.jogo_memoria.utils.verificador
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JogomemoriaTheme {
                Jogo(modifier = Modifier
                    .safeDrawingPadding()
                    .fillMaxSize())
            }
        }
    }
}

@Composable
fun Jogo(modifier: Modifier = Modifier){

    var tentativas by remember { mutableStateOf(0) }

    var a1 by remember { mutableStateOf(R.drawable.fundo) }
    var a2 by remember { mutableStateOf(R.drawable.fundo) }
    var a3 by remember { mutableStateOf(R.drawable.fundo) }

    var b1 by remember { mutableStateOf(R.drawable.fundo) }
    var b2 by remember { mutableStateOf(R.drawable.fundo) }
    var b3 by remember { mutableStateOf(R.drawable.fundo) }

    var c1 by remember { mutableStateOf(R.drawable.fundo) }
    var c2 by remember { mutableStateOf(R.drawable.fundo) }
    var c3 by remember { mutableStateOf(R.drawable.fundo) }

    var d1 by remember { mutableStateOf(R.drawable.fundo) }
    var d2 by remember { mutableStateOf(R.drawable.fundo) }
    var d3 by remember { mutableStateOf(R.drawable.fundo) }

    var numerosRandoms: Array<Int>

    var a1Imagem by remember { mutableStateOf(R.drawable.fundo) }
    var a2Imagem by remember { mutableStateOf(R.drawable.fundo) }
    var a3Imagem by remember { mutableStateOf(R.drawable.fundo) }

    var b1Imagem by remember { mutableStateOf(R.drawable.fundo) }
    var b2Imagem by remember { mutableStateOf(R.drawable.fundo) }
    var b3Imagem by remember { mutableStateOf(R.drawable.fundo) }

    var c1Imagem by remember { mutableStateOf(R.drawable.fundo) }
    var c2Imagem by remember { mutableStateOf(R.drawable.fundo) }
    var c3Imagem by remember { mutableStateOf(R.drawable.fundo) }

    var d1Imagem by remember { mutableStateOf(R.drawable.fundo) }
    var d2Imagem by remember { mutableStateOf(R.drawable.fundo) }
    var d3Imagem by remember { mutableStateOf(R.drawable.fundo) }

    fun voltarTudoAoFundo(){
        a1Imagem = R.drawable.fundo
        a2Imagem = R.drawable.fundo
        a3Imagem = R.drawable.fundo
        b1Imagem = R.drawable.fundo
        b2Imagem = R.drawable.fundo
        b3Imagem = R.drawable.fundo
        c1Imagem = R.drawable.fundo
        c2Imagem = R.drawable.fundo
        c3Imagem = R.drawable.fundo
        d1Imagem = R.drawable.fundo
        d2Imagem = R.drawable.fundo
        d3Imagem = R.drawable.fundo
    }

    var escolhas: MutableList<Int> = mutableListOf()
    val scope = rememberCoroutineScope()

    // 3x4
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Modo Hardcore", color = Color(0xff0d47a1), fontWeight = FontWeight(800), fontSize = 30.sp)
            Text(text = "Tentativas: $tentativas")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
            Button(
                onClick = {
                    a1Imagem = numeroParaImagem(a1)
                    escolhas.add(a1)

                    scope.launch {
                        if (verificador(escolhas, a1Imagem) == R.drawable.fundo) {
                            delay(1000)
                            voltarTudoAoFundo()
                            tentativas++
                            escolhas.clear()
                        }
                    }
                },
                modifier = Modifier.size(140.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Image(
                    painter = painterResource(a1Imagem),
                    contentDescription = "Carta",
                    modifier = Modifier.size(120.dp)
                )
            }
            Button(
                onClick = {
                     a2Imagem = numeroParaImagem(a2)
                     escolhas.add(a2)

                    scope.launch {
                        if (verificador(escolhas, a2Imagem) == R.drawable.fundo) {
                            delay(1000)
                            voltarTudoAoFundo()
                            tentativas++
                            escolhas.clear()
                        }
                    }
                },
                modifier = Modifier.size(140.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Image(
                    painter = painterResource(a2Imagem),
                    contentDescription = "Carta",
                    modifier = Modifier.size(120.dp)
                )
            }
            Button(
                onClick = {
                    a3Imagem = numeroParaImagem(a3)
                    escolhas.add(a3)

                    scope.launch {
                        if (verificador(escolhas, a3Imagem) == R.drawable.fundo) {
                            delay(1000)
                            voltarTudoAoFundo()
                            tentativas++
                            escolhas.clear()
                        }
                    }
                },
                modifier = Modifier.size(140.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Image(
                    painter = painterResource(a3Imagem),
                    contentDescription = "Carta",
                    modifier = Modifier.size(120.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
            Button(
                onClick = {
                    b1Imagem = numeroParaImagem(b1)
                    escolhas.add(b1)

                    scope.launch {
                        if (verificador(escolhas, b1Imagem) == R.drawable.fundo) {
                            delay(1000)
                            voltarTudoAoFundo()
                            tentativas++
                            escolhas.clear()
                        }
                    }
                },
                modifier = Modifier.size(140.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Image(
                    painter = painterResource(b1Imagem),
                    contentDescription = "Carta",
                    modifier = Modifier.size(120.dp)
                )
            }
            Button(
                onClick = {
                    b2Imagem = numeroParaImagem(b2)
                    escolhas.add(b2)

                    scope.launch {
                        if (verificador(escolhas, b2Imagem) == R.drawable.fundo) {
                            delay(1000)
                            voltarTudoAoFundo()
                            tentativas++
                            escolhas.clear()
                        }
                    }
                },
                modifier = Modifier.size(140.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Image(
                    painter = painterResource(b2Imagem),
                    contentDescription = "Carta",
                    modifier = Modifier.size(120.dp)
                )
            }
            Button(
                onClick = {
                    b3Imagem = numeroParaImagem(b3)
                    escolhas.add(b3)

                    scope.launch {
                        if (verificador(escolhas, b3Imagem) == R.drawable.fundo) {
                            delay(1000)
                            voltarTudoAoFundo()
                            tentativas++
                            escolhas.clear()
                        }
                    }
                },
                modifier = Modifier.size(140.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Image(
                    painter = painterResource(b3Imagem),
                    contentDescription = "Carta",
                    modifier = Modifier.size(120.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
            Button(
                onClick = {
                    c1Imagem = numeroParaImagem(c1)
                    escolhas.add(c1)

                    scope.launch {
                        if (verificador(escolhas, c1Imagem) == R.drawable.fundo) {
                            delay(1000)
                            voltarTudoAoFundo()
                            tentativas++
                            escolhas.clear()
                        }
                    }
                },
                modifier = Modifier.size(140.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Image(
                    painter = painterResource(c1Imagem),
                    contentDescription = "Carta",
                    modifier = Modifier.size(120.dp)
                )
            }
            Button(
                onClick = {
                    c2Imagem = numeroParaImagem(c2)
                    escolhas.add(c2)

                    scope.launch {
                        if (verificador(escolhas, c2Imagem) == R.drawable.fundo) {
                            delay(1000)
                            voltarTudoAoFundo()
                            tentativas++
                            escolhas.clear()
                        }
                    }
                },
                modifier = Modifier.size(140.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Image(
                    painter = painterResource(c2Imagem),
                    contentDescription = "Carta",
                    modifier = Modifier.size(120.dp)
                )
            }
            Button(
                onClick = {
                    c3Imagem = numeroParaImagem(c3)
                    escolhas.add(c3)

                    scope.launch {
                        if (verificador(escolhas, c3Imagem) == R.drawable.fundo) {
                            delay(1000)
                            voltarTudoAoFundo()
                            tentativas++
                            escolhas.clear()
                        }
                    }
                },
                modifier = Modifier.size(140.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Image(
                    painter = painterResource(c3Imagem),
                    contentDescription = "Carta",
                    modifier = Modifier.size(120.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
            Button(
                onClick = {
                    d1Imagem = numeroParaImagem(d1)
                    escolhas.add(d1)

                    scope.launch {
                        if (verificador(escolhas, d1Imagem) == R.drawable.fundo) {
                            delay(1000)
                            voltarTudoAoFundo()
                            tentativas++
                            escolhas.clear()
                        }
                    }
                },
                modifier = Modifier.size(140.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Image(
                    painter = painterResource(d1Imagem),
                    contentDescription = "Carta",
                    modifier = Modifier.size(120.dp)
                )
            }
            Button(
                onClick = {
                    d2Imagem = numeroParaImagem(d2)
                    escolhas.add(d2)

                    scope.launch {
                        if (verificador(escolhas, d2Imagem) == R.drawable.fundo) {
                            delay(1000)
                            voltarTudoAoFundo()
                            tentativas++
                            escolhas.clear()
                        }
                    }
                },
                modifier = Modifier.size(140.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Image(
                    painter = painterResource(d2Imagem),
                    contentDescription = "Carta",
                    modifier = Modifier.size(120.dp)
                )
            }
            Button(
                onClick = {
                    d3Imagem = numeroParaImagem(d3)
                    escolhas.add(d3)

                    scope.launch {
                        if (verificador(escolhas, d3Imagem) == R.drawable.fundo) {
                            delay(1000)
                            voltarTudoAoFundo()
                            tentativas++
                            escolhas.clear()
                        }
                    }

                },
                modifier = Modifier.size(140.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Image(
                    painter = painterResource(d3Imagem),
                    contentDescription = "Carta",
                    modifier = Modifier.size(120.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(modifier = Modifier.width(105.dp).height(50.dp), onClick = {
            voltarTudoAoFundo()
            tentativas = 0
            numerosRandoms = randomizer(arrayOf(a1,a2,a3,b1,b2,b3,c1,c2,c3,d1,d2,d3))

            a1 = numerosRandoms[0]
            a2 = numerosRandoms[1]
            a3 = numerosRandoms[2]

            b1 = numerosRandoms[3]
            b2 = numerosRandoms[4]
            b3 = numerosRandoms[5]

            c1 = numerosRandoms[6]
            c2 = numerosRandoms[7]
            c3 = numerosRandoms[8]

            d1 = numerosRandoms[9]
            d2 = numerosRandoms[10]
            d3 = numerosRandoms[11]
        }) {
            Text(text = "Play", fontSize = 20.sp)
        }
    }
}