package pt.ulusofona.cm.kotlin.observerobservable.models

class LeitorPar(nome: String) : Leitor(nome) {
    var numeros = mutableListOf<Int>()

    fun onReceiveNumero(numero : Int){
        if(numero % 2 == 0){
            numeros.add(numero)
        }
    }

    fun imprimeNumeros(): String{
        return "$nome leu os seguintes numeros pares: $numeros"
    }

}