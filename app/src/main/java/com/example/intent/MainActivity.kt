package com.example.intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text


val RESULT_ONE = 1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var chgBtn = findViewById<Button>(R.id.changeBtn1)


        chgBtn.setOnClickListener {
            // Instanciacion de Intent para mandarlo a la segunda activity
            val intent = Intent(this, MainActivity2::class.java)

            // envia data a la segunda activity
            intent.putExtra("clients", 5)
            intent.putExtra("providers", 50)


            startActivityForResult(intent, RESULT_ONE)
        }
    }

    // Funcion llamada cuando la segunda actividad pone un resultado
    @Deprecated("Deprecated a partir de API 30")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val greeting = findViewById<TextView>(R.id.textViewResult)

        // Checkea si el resultado es correcto
        if (resultCode != Activity.RESULT_OK) return
        when(requestCode) {
            RESULT_ONE -> {
                // Si Intent es not null muestra un greeting
                if (data != null) {
                    greeting.text = data.getStringExtra("greeting")
                }
                else {}
            }
        }
    }
}