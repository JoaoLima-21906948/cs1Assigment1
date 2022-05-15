package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNoticiaListener
import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNumeroListener

class Bufo(nome: String, registado: Boolean) : Leitor(nome, registado),OnNoticiaListener,OnNumeroListener {
    private var numeros = mutableListOf<Int>()
    private var noticias = mutableListOf<Noticia>()

    override fun onReceiveNumero(numero : Int){
        numeros.add(numero)
    }

    override fun onReceiveNoticia(noticia : Noticia){
        noticias.add(noticia)
    }

    fun imprimeNumeros() : String{
        return "$nome escutou os seguintes numeros: $numeros"
    }

    fun imprimeNoticias() : String{
        return "$nome leu as seguintes noticias: $noticias"
    }
}