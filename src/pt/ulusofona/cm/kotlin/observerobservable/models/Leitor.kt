package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.interfaces.Registavel

abstract class Leitor(var nome : String, private var registado: Boolean): Registavel {

    init {
        registado = false
    }

    override fun leitorAdicionadoComSucesso(){
        registado = true
    }

    override fun leitorRemovidoComSucesso(){
        registado = false
    }

    fun estaRegistado(): Boolean{
        return registado
    }

}