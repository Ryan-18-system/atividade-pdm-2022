package br.edu.ifpb.arrocha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class ResultadoActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private lateinit var tvIntervalo: TextView
    private lateinit var tvNumeroSorteado: TextView
    private lateinit var llResultado: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        this.tvResult = findViewById(R.id.tvResultado)
        this.tvIntervalo = findViewById(R.id.tvIntervalo)
        this.llResultado = findViewById(R.id.llResultado)
        this.tvNumeroSorteado = findViewById(R.id.tvNumeroSorteado)

        if(intent.hasExtra("JOGO")){
            var jogo = intent.getSerializableExtra("JOGO") as Arrocha

            if(jogo.getStatus() == Status.GANHOU){
                this.tvResult.setText(jogo.getStatus().toString())
                this.tvNumeroSorteado.setText("O Número sorteado é: ${jogo.getSecreto()}")
                this.tvIntervalo.setText("O intervalo é ${jogo.getMenor()} e ${jogo.getMaior()}")

            }else{
                this.tvResult.setText(jogo.getStatus().toString())
                this.tvNumeroSorteado.setText("O Número sorteado é: ${jogo.getSecreto()}")
                this.tvIntervalo.setText("O intervalo é ${jogo.getMenor()} e ${jogo.getMaior()}")
            }


        }

    }

}