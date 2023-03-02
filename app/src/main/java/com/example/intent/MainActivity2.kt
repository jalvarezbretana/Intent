package com.example.intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val intent = getIntent()

        // recibiendo valores del intent
        val clientsValue = intent.getIntExtra("clients", 0)
        val providersValue = intent.getIntExtra("providers", 0)
        val numClients = findViewById<TextView>(R.id.txtViewClients)
        val numProviders = findViewById<TextView>(R.id.txtViewProviders)
        numClients.text = "Clientes: $clientsValue"
        numProviders.text = "Providers: $providersValue"

        // enviando datos de la anterior activity
        intent.putExtra("greeting", "Greetings!");
        setResult(Activity.RESULT_OK, intent);

        finish()
    }
}