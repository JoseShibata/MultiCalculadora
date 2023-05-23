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

import com.example.calculadorav2.R;
import com.example.calculadorav2.calculos.CalculoArea;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class AreaCirculoActivity extends AppCompatActivity {

    private TextInputEditText campoValorRaio;
    private Button btnAreaCirc;
    private ImageButton btnInfoCirc;
    private TextView textAreaCirc;
    private Double valorRaio;
    private DecimalFormat decimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_circulo);

        campoValorRaio = findViewById(R.id.campoValorRaio);
        btnAreaCirc = findViewById(R.id.btnAreaCirc);
        btnInfoCirc = findViewById(R.id.btnInfoCirc);
        textAreaCirc = findViewById(R.id.textAreaCirc);

        btnAreaCirc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validarCampo(campoValorRaio)){
                    decimal = new DecimalFormat("#,###.00");
                    valorRaio =  Double.parseDouble(campoValorRaio.getText().toString());
                    textAreaCirc.setText("A área do Circulo é: \n" + decimal.format(CalculoArea.areaCirculo(valorRaio)));
                }else
                    Toast.makeText(getApplicationContext(), "Preencha os campos acima", Toast.LENGTH_LONG).show();

            }
        });

        btnInfoCirc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibeAlert();
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

    private void exibeAlert() {

        AlertDialog alerta;

        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Como é calculado a Área do Losango?");
        //define a mensagem
        builder.setMessage("A Área do Circulo é calculado da seguinte forma: \n" +
                "Pi * r², (sendo 'Pi', o valor de 3,1415 e 'r²', a metade da circunferência da figura, vezes ele mesmo!!!).");
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
