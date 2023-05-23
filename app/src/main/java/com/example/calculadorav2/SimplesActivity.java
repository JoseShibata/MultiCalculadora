package com.example.calculadorav2;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.example.calculadorav2.calculos.Operacoes;

public class SimplesActivity extends AppCompatActivity {

    Button botaoSoma, botaoSub, botaoMulti, botaoDivi, botaoPorcentagem;
    TextView textResultado, textPorcentagem1, textPorcentagem2;
    TextInputEditText campo1, campo2;
    Double valor1, valor2;
    Boolean retorno;
    Operacoes operacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simples);

        //operacoes = new Operacoes();

        botaoSoma = findViewById(R.id.btnSoma);
        botaoSub = findViewById(R.id.btnSub);
        botaoMulti = findViewById(R.id.btnMulti);
        botaoDivi = findViewById(R.id.btnDivi);
        botaoPorcentagem = findViewById(R.id.btnPorcentagem);
        textResultado = findViewById(R.id.textResult);
        textPorcentagem1 = findViewById(R.id.textJuros1);
        textPorcentagem2 = findViewById(R.id.textJuros2);
        campo1 = findViewById(R.id.campo1);
        campo2 = findViewById(R.id.campo2);

        botaoSoma.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(verificaCampo(campo1, campo2)){
                    valor1 = Double.parseDouble(campo1.getText().toString());
                    valor2 = Double.parseDouble(campo2.getText().toString());
                    textResultado.setText("" + Operacoes.soma(valor1, valor2));
                    textPorcentagem1.setText("");
                    textPorcentagem2.setText("");
                }else
                    Toast.makeText(getApplicationContext(), "Complete Todos os Campos!!!", Toast.LENGTH_LONG).show();
            }
        });
        botaoSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificaCampo(campo1, campo2)){
                    valor1 = Double.parseDouble(campo1.getText().toString());
                    valor2 = Double.parseDouble(campo2.getText().toString());
                    textResultado.setText("" + Operacoes.subtracao(valor1, valor2));
                    textPorcentagem1.setText("");
                    textPorcentagem2.setText("");
                }else
                    Toast.makeText(getApplicationContext(), "Complete Todos os Campos!!!", Toast.LENGTH_LONG).show();
            }

        });
        botaoMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificaCampo(campo1, campo2)) {
                    valor1 = Double.parseDouble(campo1.getText().toString());
                    valor2 = Double.parseDouble(campo2.getText().toString());
                    textResultado.setText("" + Operacoes.multiplicacao(valor1, valor2));
                    textPorcentagem1.setText("");
                    textPorcentagem2.setText("");
                }else
                    Toast.makeText(getApplicationContext(), "Complete Todos os Campos!!!", Toast.LENGTH_LONG).show();
            }
        });
        botaoDivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificaCampo(campo1, campo2)){
                    valor1 = Double.parseDouble(campo1.getText().toString());
                    valor2 = Double.parseDouble(campo2.getText().toString());
                    textResultado.setText("" + Operacoes.divisao(valor1,valor2));
                    textPorcentagem1.setText("");
                    textPorcentagem2.setText("");
                }else
                    Toast.makeText(getApplicationContext(), "Complete Todos os Campos!!!", Toast.LENGTH_LONG).show();
            }
        });

        botaoPorcentagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificaCampo(campo1, campo2)){
                    valor1 = Double.parseDouble(campo1.getText().toString());
                    valor2 = Double.parseDouble(campo2.getText().toString());
                    textResultado.setText("Valor da Porcentagem: " + Operacoes.porcentagem(valor1,valor2));
                    textPorcentagem1.setText("Desconto do Valor Total: " + (valor1 - Operacoes.porcentagem(valor1, valor2)));
                    textPorcentagem2.setText("Acréscimo do Valor Total: " + (valor1 + Operacoes.porcentagem(valor1, valor2)));
                }else
                    Toast.makeText(getApplicationContext(), "Complete Todos os Campos!!!", Toast.LENGTH_LONG).show();
            }
        });

    }

    public boolean verificaCampo(TextInputEditText numero1, TextInputEditText numero2) {

        retorno = false;

        if (numero1.getText().toString().equals("") || numero2.getText().toString().equals("")) {
            retorno = false;
        } else {
            retorno = true;
        }
        return retorno;
    }
}
