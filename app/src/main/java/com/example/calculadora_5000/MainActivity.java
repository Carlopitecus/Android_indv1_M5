package com.example.calculadora_5000;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.annotation.Retention;

import kotlin.contracts.Returns;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button boton_suma, boton_resta, boton_mult, boton_div;
    EditText edit_campo1, edit_campo2;
    TextView view_resultado;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        boton_suma = findViewById(R.id.btn_suma);
        boton_resta = findViewById(R.id.btn_resta);
        boton_mult = findViewById(R.id.btn_mult);
        boton_div = findViewById(R.id.btn_div);
        edit_campo1 = findViewById(R.id.campo1);
        edit_campo2 = findViewById(R.id.campo2);
        view_resultado = findViewById(R.id.resultado);

        boton_suma.setOnClickListener(this);
        boton_resta.setOnClickListener(this);
        boton_mult.setOnClickListener(this);
        boton_div.setOnClickListener(this);
    }

    public int obtenerNumDeLosInputs(EditText editText){
        if (editText.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese Numerossssssss", Toast.LENGTH_SHORT).show();
            return  0;
        }
        return Integer.parseInt(editText.getText().toString());
    }

    @Override
    public void onClick(View view) {
        num1 = obtenerNumDeLosInputs(edit_campo1);
        num2 = obtenerNumDeLosInputs(edit_campo2);

        int id = view.getId();
        if (id == R.id.btn_suma) {
            view_resultado.setText("Resultado = " + (num1 + num2));
        } else if (id == R.id.btn_resta) {
            view_resultado.setText("Resultado = " + (num1 - num2));
        } else if (id == R.id.btn_mult) {
            view_resultado.setText("Resultado = " + (num1 * num2));
        } else if (id == R.id.btn_div) {
            view_resultado.setText("Resultado = " + ((float) num1 / (float) num2));
        }
    }
}