package com.example.calculadorav2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class ImcActivity extends AppCompatActivity {

    Button botaoCalcular;
    FloatingActionButton fabModal;
    boolean retorno;
    TextInputEditText textAltura, textPeso;
    TextView textResult, infoIMC;
    private double alturaIMC, pesoIMC, totalIMC;
    AlertDialog alerta;
    ConstraintLayout constraintIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        final DecimalFormat formato = new DecimalFormat("#.##");

        botaoCalcular = findViewById(R.id.botaoCalcular);
        fabModal = findViewById(R.id.fabModal);
        textAltura = findViewById(R.id.editAltura);
        textPeso = findViewById(R.id.editPeso);
        textResult = findViewById(R.id.resultIMC);
        infoIMC = findViewById(R.id.infoIMC);
        constraintIMC = findViewById(R.id.constratintIMC);

        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(verificaCampo(textAltura, textPeso)){
                    alturaIMC = Double.parseDouble(textAltura.getText().toString());
                    pesoIMC = Double.parseDouble(textPeso.getText().toString());

                    totalIMC = pesoIMC / (Math.pow(alturaIMC, 2));

                    textResult.setText("" + formato.format(totalIMC));

                    if(totalIMC < 18.5){
                        infoIMC.setText("Peso Baixo!!!");
                        constraintIMC.setBackgroundColor(getResources().getColor(R.color.colorPesoBaixo));
                    }else if (totalIMC > 18.5 && totalIMC < 24.9){
                        infoIMC.setText("Peso Normal!!!");
                        constraintIMC.setBackgroundColor(getResources().getColor(R.color.colorPesoNormal));
                    }else if(totalIMC > 25.0 && totalIMC < 29.9){
                        infoIMC.setText("Sobrepeso!!!");
                        constraintIMC.setBackgroundColor(getResources().getColor(R.color.colorSobrepeso));
                    }else if(totalIMC > 30.0 && totalIMC < 34.9){
                        infoIMC.setText("Obesidade (Grau 1)");
                        constraintIMC.setBackgroundColor(getResources().getColor(R.color.colorObesidade1));
                    }else if(totalIMC > 35.0 && totalIMC < 39.9){
                        infoIMC.setText("Obesidade Severa (Grau 2)");
                        constraintIMC.setBackgroundColor(getResources().getColor(R.color.colorObesidade2));
                    }else{
                        infoIMC.setText("Obesidade Mórbida (Grau 3)");
                        constraintIMC.setBackgroundColor(getResources().getColor(R.color.colorObesidade3));
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Complete Todos os Campos!!!", Toast.LENGTH_LONG).show();
                }
            }
        });

        fabModal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaAlert();
            }
        });

    }

    public boolean verificaCampo(TextInputEditText numero1, TextInputEditText numero2){

        retorno = false;

        if(numero1.getText().toString().equals("") || numero2.getText().toString().equals("")){
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
        builder.setTitle("Como é calculado o IMC ?");
        //define a mensagem
        builder.setMessage("O IMC - Indice de Massa Corpórea é calculado da seguinte forma: \n" +
                "Peso / Altura².");
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
