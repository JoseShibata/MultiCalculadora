package com.example.calculadorav2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class JcompostoActivity extends AppCompatActivity {

    TextInputEditText campoVInicial, campoVMensal, campoTXJuros, campoPMeses;
    Button btnCalcular;
    FloatingActionButton fabModal;
    AlertDialog alerta;
    TextView textFinal, textInvestido, textJuros;
    private double vInicial, vMensal, txJuros, totalJuros, totalInvestido ,montante, qtdMeses;
    private boolean retorno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jcomposto);

        final DecimalFormat formato = new DecimalFormat("#.##");

        campoVInicial = findViewById(R.id.valInicial);
        campoVMensal = findViewById(R.id.valMensal);
        campoTXJuros = findViewById(R.id.txJuros);
        campoPMeses = findViewById(R.id.periodoMeses);
        btnCalcular = findViewById(R.id.btnCalcular);
        fabModal = findViewById(R.id.fabModal);

        textFinal = findViewById(R.id.textFinal);
        textInvestido = findViewById(R.id.textInvestido);
        textJuros = findViewById(R.id.textJuros);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(verificaCampo(campoVInicial, campoVMensal, campoPMeses, campoTXJuros)){

                    vInicial = Double.parseDouble(campoVInicial.getText().toString());
                    vMensal = Double.parseDouble(campoVMensal.getText().toString());
                    qtdMeses = Double.parseDouble(campoPMeses.getText().toString());
                    txJuros = Double.parseDouble(campoTXJuros.getText().toString());

                    totalInvestido = Double.valueOf(formato.format(vInicial + (vMensal*qtdMeses)));
                    montante = Double.valueOf(formato.format(totalInvestido*Math.pow((1+(txJuros/100)), qtdMeses)));

                    totalJuros = Double.valueOf(formato.format(montante-totalInvestido));

                    textFinal.setText("Total Investido: \n " + totalInvestido);
                    textInvestido.setText("Valor total final: \n " + montante);
                    textJuros.setText("Total de Juros: \n " + totalJuros);

                }else
                    Toast.makeText(getApplicationContext(), "Complete Todos os Campos!!!", Toast.LENGTH_LONG).show();

            }
        });

        fabModal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaAlert();
            }
        });

    }

    public boolean verificaCampo(TextInputEditText numero1, TextInputEditText numero2, TextInputEditText numero3, TextInputEditText numero4){

        retorno = false;

        if(numero1.getText().toString().equals("") || numero2.getText().toString().equals("")
                || numero3.getText().toString().equals("") || numero4.getText().toString().equals("")){
            retorno = false;
        }else{
            retorno = true;
        }
        return retorno;
    }

    private void criaAlert() {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Como é calculado os Juros Compostos ?");
        //define a mensagem
        builder.setMessage("Os Juros Compostos são calculados da seguinte forma: \n" +
                "Montante = Total Investido x (1 + Taxa de Juros)^Tempo de Aplicação.");
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
