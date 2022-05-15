package pt.ulusofona.cm.kotlin.observerobservable.models

class LeitorImpar(nome: String, registado: Boolean) : Leitor(nome, registado) {
    var numeros = mutableListOf<Int>()

    fun onReceiveNumero(numero : Int){
        if(numero % 2 != 0){
            numeros.add(numero)
        }
    }

    fun imprimeNumeros(): String{
        return "$nome leu os seguintes numeros impares: $numeros"
    }

}