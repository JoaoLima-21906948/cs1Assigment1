package pt.ulusofona.cm.kotlin.observerobservable.classes

import pt.ulusofona.cm.kotlin.observerobservable.excecoes.LeitorInexistenteException
import pt.ulusofona.cm.kotlin.observerobservable.excecoes.LimiteDeLeitoresAtingidoException
import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNumeroListener

class GeradorNumerico(var maxleitores : Int,private var numeros: List<Int>){
    private var leitores = mutableListOf<OnNumeroListener>()

    fun adicionarLeitor(leitor : OnNumeroListener){
        if(leitores.size < maxleitores){
            leitores.add(leitor)
            leitor.leitorAdicionadoComSucesso()
        }else{
            throw LimiteDeLeitoresAtingidoException(gerador = "CorreioDaLusofona", numero_leitores = maxleitores.toString())
        }
    }

    fun removerLeitor(leitor : OnNumeroListener) {
        if (leitores.contains(leitor)) {
            leitores.remove(leitor)
            leitor.leitorRemovidoComSucesso()
        } else {
            throw LeitorInexistenteException()
        }
    }

    private fun notificarLeitores() {
        leitores.forEach { leitor ->
            numeros.forEach {
                leitor.onReceiveNumero(it)
            }
        }
    }

    fun iniciar() {
        notificarLeitores()
    }

}