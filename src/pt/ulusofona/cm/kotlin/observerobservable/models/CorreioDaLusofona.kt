package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LeitorInexistenteException
import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LimiteDeLeitoresAtingidoException
import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNoticiaListener

class CorreioDaLusofona(var maxleitores : Int,private var noticias: List<Noticia>){
    private var leitores = mutableListOf<OnNoticiaListener>()

    fun adicionarLeitor(leitor : OnNoticiaListener){
        if(leitores.size < maxleitores){
            leitores.add(leitor)
            leitor.leitorAdicionadoComSucesso()
        }else{
             throw LimiteDeLeitoresAtingidoException(gerador = "CorreioDaLusofona", numero_leitores = maxleitores.toString())
        }
    }

    fun removerLeitor(leitor : OnNoticiaListener) {
        if (leitores.contains(leitor)) {
            leitores.remove(leitor)
            leitor.leitorRemovidoComSucesso()
        } else {
            throw LeitorInexistenteException()
        }
    }

    private fun notificarLeitores() {
        leitores.forEach { leitor ->
            noticias.forEach {
                leitor.onReceiveNoticia(it)
            }
        }
    }

    fun iniciar() {
        notificarLeitores()
    }

}