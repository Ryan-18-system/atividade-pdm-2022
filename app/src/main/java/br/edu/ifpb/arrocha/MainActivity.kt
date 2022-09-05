package br.edu.ifpb.arrocha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var etNumero: EditText
    private lateinit var  bnArrocha: Button
    private lateinit var arrocha: Arrocha
    private lateinit var lGanhou: LinearLayout
    private lateinit var lPerdeu: LinearLayout
    private  lateinit var lJogo:  LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.arrocha = Arrocha()

        this.lGanhou = findViewById(R.id.llGanhou)
        this.lPerdeu = findViewById(R.id.llPerdeu)
        this.lJogo = findViewById(R.id.llMain)
        this.etNumero = findViewById(R.id.etNumero)
        this.bnArrocha = findViewById(R.id.btArrocha)
        this.bnArrocha.setOnClickListener(OnClickBotao())

        this.lGanhou.setOnClickListener{resetGame()}
        this.lPerdeu.setOnClickListener{resetGame()}
    }

    private fun resetGame(){
        this.lGanhou.visibility = View.INVISIBLE
        this.lPerdeu.visibility = View.INVISIBLE
        this.lJogo.visibility = View.VISIBLE
        this.arrocha = Arrocha()
        Toast.makeText(this,"Novo Jogo!",Toast.LENGTH_SHORT).show()
    }

    inner  class OnClickBotao: View.OnClickListener{
        override fun onClick(p0: View?) {

            var numero = this@MainActivity.etNumero.text.toString().toInt()

            var msg = this@MainActivity.arrocha.jogar(numero)

            if (this@MainActivity.arrocha.getStatus() == Status.EXECUTANDO){
                Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
            }else if(this@MainActivity.arrocha.getStatus() == Status.GANHOU){
                this@MainActivity.lGanhou.visibility = View.VISIBLE
                this@MainActivity.lJogo.visibility= View.INVISIBLE
            }else if(this@MainActivity.arrocha.getStatus() == Status.PERDEU){
                this@MainActivity.lPerdeu.visibility = View.VISIBLE
                this@MainActivity.lJogo.visibility= View.INVISIBLE
            }

            this@MainActivity.etNumero.setText("")

        }
    }




}
