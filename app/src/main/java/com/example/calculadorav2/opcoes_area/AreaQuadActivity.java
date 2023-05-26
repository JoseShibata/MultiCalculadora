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

public class AreaQuadActivity extends AppCompatActivity {

    private TextInputEditText textLado;
    private TextView textResultArea;
    private Button btnAreaQuad, btnExibeCalculo;
    private ImageButton btnInfoQuad;
    private Double valorLado;
    private String valor;
    private DecimalFormat decimal;
    private AlertGerenciador gerenciadorAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_quad);

        textLado = findViewById(R.id.campoLado);
        btnAreaQuad = findViewById(R.id.btnAreaQuad);
        btnExibeCalculo = findViewById(R.id.btnExibeCalculo);
        textResultArea = findViewById(R.id.textResultArea);
        btnInfoQuad = findViewById(R.id.btnInfoQuad);
        gerenciadorAlert = new AlertGerenciador(this);
        decimal = new DecimalFormat("#,###.00");

        btnAreaQuad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validarCampo(textLado)) {
                    valorLado = Double.parseDouble(textLado.getText().toString());
                    textResultArea.setText("A área do quadrado é: \n" + decimal.format(CalculoArea.areaQuadrado(valorLado)));
                    btnExibeCalculo.setVisibility(View.VISIBLE);
                }
                else
                    Toast.makeText(getApplicationContext(), "Preencha o campo acima", Toast.LENGTH_LONG).show();
            }
        });

        btnInfoQuad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gerenciadorAlert.comoCalcularAreaQuadradrado();
            }
        });

        btnExibeCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaCalculo(valorLado);
            }
        });

    }

    public boolean validarCampo(TextInputEditText sideField){

        boolean retorno;

        if (sideField.getText().toString().equals("")){
            retorno = false;
        }else{
            retorno = true;
        }
        return retorno;
    }

    private void criaCalculo(double lado){

        StringBuffer buffer = new StringBuffer();
        buffer.append("A  =  ( L  *  L ) \n" );
        buffer.append("A  =  " + lado + "  *  " + lado + " \n");
        buffer.append("A  =    " + decimal.format(CalculoArea.areaQuadrado(lado)));
        gerenciadorAlert.calculoAreaQuadrado(buffer);

    }

}
