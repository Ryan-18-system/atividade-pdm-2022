package br.edu.ifpb.arrocha
import android.util.Log
import java.util.*
import kotlin.random.Random


class Arrocha {
    private var maior : Int;
    private var menor : Int;
    private var secreto: Int;
    private var status: Status;



    init {
        var random = Random(Calendar.getInstance().timeInMillis)
        this.maior = 100
        this.menor = 1
        //gerar número aleatório
        this.secreto = random.nextInt(this.menor,this.maior)
        this.status = Status.EXECUTANDO

        Log.i("APP_ARROCHA",this.secreto.toString())
        Log.w("APP_ARROCHA", "(${this.menor},${this.maior})")

    }


    fun jogar(chute:Int): String? {
        var mensagem = ""

        if(this.status == Status.EXECUTANDO){
            if(this.secreto == chute || (!this.isValido(chute))){
                this.status = Status.PERDEU
            }else{
                if(chute < this.secreto) {
                    this.menor = chute
                    mensagem = "O seu número é menor do que o secreto"
                }
                else{
                    this.maior = chute
                    mensagem = "o seu número é maior do que o secreto"
                }
                if(this.isArrochado()){
                    this.status = Status.GANHOU
                }else{
                    return mensagem
                }

            }
        }

        return null
    }

    private fun isValido(chute: Int):Boolean{
        return chute > this.menor && chute < this.maior
    }

    private fun isArrochado():Boolean{
        return menor + 1 == maior - 1
    }

    fun getStatus():Status{
        return this.status
    }
}