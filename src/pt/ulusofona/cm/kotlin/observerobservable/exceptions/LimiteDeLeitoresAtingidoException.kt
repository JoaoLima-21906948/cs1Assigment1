package pt.ulusofona.cm.kotlin.observerobservable.exceptions


class LimiteDeLeitoresAtingidoException(gerador: String,numero_leitores: String): Exception("$gerador atingiu o número máximo de leitores: $numero_leitores")