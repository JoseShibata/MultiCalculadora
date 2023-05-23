package com.example.calculadorav2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.nio.Buffer;

public class TabuadaActivity extends AppCompatActivity {

    TextInputEditText campoMultiplicado, campoMultiplicador;
    ImageButton btnInfo;
    Button btnCalcular;
    TextView textResultado;
    AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabuada);

        campoMultiplicado = findViewById(R.id.campoMultiplicado);
        campoMultiplicador = findViewById(R.id.campoMultiplicador);
        textResultado = findViewById(R.id.textResultado);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnInfo = findViewById(R.id.btnInfo);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                verificaELista(campoMultiplicado, campoMultiplicador);

            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaAlert();
            }
        });

    }

    public void verificaELista(TextInputEditText campo1, TextInputEditText campo2){

        int valor1, valor2;

        if(campo1.getText().toString().equals("") || campo2.getText().toString().equals("")){

            Toast.makeText(getApplicationContext(),"Todos os campos devem estar preenchidos!!!", Toast.LENGTH_LONG).show();

        }else{

            valor1 = Integer.parseInt(campo1.getText().toString());
            valor2 = Integer.parseInt(campo2.getText().toString());

            if(valor2 > 999){
                Toast.makeText(getApplicationContext(),"Digite apenas numeros menores que 1000", Toast.LENGTH_LONG).show();
            }else{

                StringBuffer buffer = new StringBuffer();

                for (int i = 0; i <= valor2; i++){

                    buffer.append(valor1 + " x " + i + " = " + (valor1 * i) + "\n");

                }
                textResultado.setText(buffer);
            }
        }
    }

    public void criaAlert(){
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("O que é o Multiplicador??");
        //define a mensagem
        builder.setMessage("O Multiplicador é o numero por quantas vezes voçê quer multiplicar. \n \n" +
                "Na escola, geralmente multiplicamos até 10, aqui, podemos multiplicar até 999.");
        //define um botão como positivo
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }

}
