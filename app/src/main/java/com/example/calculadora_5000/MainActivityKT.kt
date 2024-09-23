package com.example.calculadora_5000

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var boton_suma: Button? = null
    var boton_resta: Button? = null
    var boton_mult: Button? = null
    var boton_div: Button? = null
    var edit_campo1: EditText? = null
    var edit_campo2: EditText? = null
    var view_resultado: TextView? = null
    var num1: Int = 0
    var num2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        boton_suma = findViewById(R.id.btn_suma)
        boton_resta = findViewById(R.id.btn_resta)
        boton_mult = findViewById(R.id.btn_mult)
        boton_div = findViewById(R.id.btn_div)
        edit_campo1 = findViewById(R.id.campo1)
        edit_campo2 = findViewById(R.id.campo2)
        view_resultado = findViewById(R.id.resultado)

        boton_suma.setOnClickListener(this)
        boton_resta.setOnClickListener(this)
        boton_mult.setOnClickListener(this)
        boton_div.setOnClickListener(this)
    }

    fun obtenerNumDeLosInputs(editText: EditText?): Int {
        if (editText!!.text.toString().isEmpty()) {
            Toast.makeText(this, "Ingrese Numerossssssss", Toast.LENGTH_SHORT).show()
            return 0
        }
        return editText.text.toString().toInt()
    }

    override fun onClick(view: View) {
        num1 = obtenerNumDeLosInputs(edit_campo1)
        num2 = obtenerNumDeLosInputs(edit_campo2)

        val id = view.id
        if (id == R.id.btn_suma) {
            view_resultado!!.text = "Resultado = " + (num1 + num2)
        } else if (id == R.id.btn_resta) {
            view_resultado!!.text = "Resultado = " + (num1 - num2)
        } else if (id == R.id.btn_mult) {
            view_resultado!!.text = "Resultado = " + (num1 * num2)
        } else if (id == R.id.btn_div) {
            view_resultado!!.text = "Resultado = " + (num1.toFloat() / num2.toFloat())
        }
    }
}