package com.gundes.jogo_memoria.utils

import com.gundes.jogo_memoria.R

fun randomizer(arr: Array<Int>): Array<Int>{
    var nums = arrayOf(1,1,2,2,3,3,4,4,5,5,6,6)
    var it = 0

    for(num in nums.toList().shuffled()){
        it += 1
        when(it){
            1 -> arr[0] = num
            2 -> arr[1] = num
            3 -> arr[2] = num
            4 -> arr[3] = num
            5 -> arr[4] = num
            6 -> arr[5] = num
            7 -> arr[6] = num
            8 -> arr[7] = num
            9 -> arr[8] = num
            10 -> arr[9] = num
            11 -> arr[10] = num
            12 -> arr[11] = num
        }
    }

    return arr
}

fun numeroParaImagem(num: Int): Int{
    return when(num){
        1 -> R.drawable.circulo
        2 -> R.drawable.triangulo
        3 -> R.drawable.quandrado
        4 -> R.drawable.cruz
        5 -> R.drawable.losango
        6 -> R.drawable.paralelogramo
        else -> R.drawable.fundo
    }
}

fun verificador(escolhas: MutableList<Int>, cardAtual: Int): Int{
    if(escolhas.size < 2){
        return cardAtual
    }

    if(escolhas[0] != escolhas[1]){
        return R.drawable.fundo

    }else{
        return cardAtual

    }
}