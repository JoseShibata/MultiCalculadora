package com.example.calculadorav2.opcoes_area;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculadorav2.AlertGerenciador;
import com.example.calculadorav2.R;
import com.example.calculadorav2.calculos.CalculoArea;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class AreaCirculoActivity extends AppCompatActivity {

    private TextInputEditText campoValorRaio;
    private Button btnAreaCirc, btnExibeCalculo;
    private ImageButton btnInfoCirc;
    private TextView textAreaCirc;
    private Double valorRaio;
    private DecimalFormat decimal;
    private AlertGerenciador gerenciadorAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_circulo);

        campoValorRaio = findViewById(R.id.campoValorRaio);
        btnAreaCirc = findViewById(R.id.btnAreaCirc);
        btnInfoCirc = findViewById(R.id.btnInfoCirc);
        textAreaCirc = findViewById(R.id.textAreaCirc);
        btnExibeCalculo = findViewById(R.id.btnExibeCalculo);
        gerenciadorAlert = new AlertGerenciador(this);

        btnAreaCirc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validarCampo(campoValorRaio)){
                    decimal = new DecimalFormat("#,###.00");
                    valorRaio =  Double.parseDouble(campoValorRaio.getText().toString());
                    textAreaCirc.setText("A área do Circulo é: \n" + decimal.format(CalculoArea.areaCirculo(valorRaio)));
                    btnExibeCalculo.setVisibility(View.VISIBLE);

                }else
                    Toast.makeText(getApplicationContext(), "Preencha os campos acima", Toast.LENGTH_LONG).show();

            }
        });

        btnInfoCirc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gerenciadorAlert.comoCalcularAreaCirculo();
            }
        });

        btnExibeCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaCalculo(valorRaio);
            }
        });

    }

    public boolean validarCampo(TextInputEditText valorRaio){
        boolean retorno;
        if (valorRaio.getText().toString().equals("")){
            retorno = false;
        }else{
            retorno = true;
        }
        return retorno;
    }

    private void criaCalculo(double raio){

        StringBuffer buffer = new StringBuffer();
        buffer.append("A  =   π    *       r² \n" );
        buffer.append("A  =  3,14  *  " + raio + "² \n");
        buffer.append("A  =  3,14  *  " + Math.pow(raio, 2) + "\n");
        buffer.append("A  = " + decimal.format(CalculoArea.areaCirculo(raio)));
        gerenciadorAlert.calculoAreaCirculo(buffer);

    }
}
