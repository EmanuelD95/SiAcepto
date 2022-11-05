package com.emanuel.siacepto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.emanuel.siacepto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var contador: Int = 0

    private val preguntas = arrayOf(
        "¿Dónde nos ves viviendo dentro de 10 años?",
        "¿Qué esperas que yo contribuya en nuestro matrimonio?",
        "¿Qué esperas estar haciendo cuando tengas 45 años?",
        "¿Dónde te quisieras jubilar?",
        "¿Si éste fuese tu ultimo día de vida, cómo lo vivieras?",
        "¿Qué tan frecuente te gusta tener tiempo para ti mismo?",
        "¿Qué tan frecuente te gusta reunirte con tus amigos?",
        "¿Qué tan lejos deseas vivir de tus padres?",
        "¿Cuáles días festivos pasaremos con tu familia? ¿Con la mía?",
        "¿Cómo te trataron tus padres?"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mostrarPregunta()
        binding.btnNext.setOnClickListener{
            if (contador >= preguntas.size-1) contador = 0
            else contador++

            mostrarPregunta()
        }
        binding.btnAnterior.setOnClickListener {
            if (contador <= 0) contador = preguntas.size-1
            else contador--
            mostrarPregunta()
        }
    }

    fun mostrarPregunta (){
        binding.tvNumero.text = "${contador+1}"
        binding.tvContador.text = "${contador+1}/10"
        binding.tvPregunta.text = "${preguntas[contador]}"
    }
}
