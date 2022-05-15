package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNumeroListener

class LeitorPar(nome: String) : Leitor(nome), OnNumeroListener {
    var numeros = mutableListOf<Int>()

    override fun onReceiveNumero(numero : Int){
        if(numero % 2 == 0){
            numeros.add(numero)
        }
    }

    fun imprimeNumeros(): String{
        return "$nome leu os seguintes numeros pares: $numeros"
    }

}