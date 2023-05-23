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

public class AreaTrapezioActivity extends AppCompatActivity {

    private ImageButton btnInfoTrap;
    private TextInputEditText campoBaseMaior, campoBaseMenor, campoAlturaTrap;
    private Button btnAreaTrap;
    private TextView textAreaTrap;
    private Double valorBaseMaior, valorBaseMenor, valorAlturaTrap;
    private DecimalFormat decimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_trapezio);

        btnInfoTrap = findViewById(R.id.btnInfoTrap);
        campoBaseMaior = findViewById(R.id.campoBaseMaior);
        campoBaseMenor = findViewById(R.id.campoBaseMenor);
        campoAlturaTrap = findViewById(R.id.campoAlturaTrap);
        btnAreaTrap = findViewById(R.id.btnAreaTrap);
        textAreaTrap = findViewById(R.id.textAreaTrap);
        decimal = new DecimalFormat("#,###.00");

        btnAreaTrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validarCampo(campoBaseMaior, campoBaseMenor, campoAlturaTrap)){

                    valorBaseMaior = Double.parseDouble(campoBaseMaior.getText().toString());
                    valorBaseMenor = Double.parseDouble(campoBaseMenor.getText().toString());
                    valorAlturaTrap = Double.parseDouble(campoAlturaTrap.getText().toString());

                    textAreaTrap.setText("A Área do Trapézio é: \n" + decimal.format(CalculoArea.areaTrapezio(valorBaseMaior, valorBaseMenor, valorAlturaTrap)));
                }else
                    Toast.makeText(getApplicationContext(), "Preencha os campos acima", Toast.LENGTH_LONG).show();
            }
        });

        btnInfoTrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibeAlert();
            }
        });

    }

    public boolean validarCampo(TextInputEditText campoBaseMaior, TextInputEditText campoBaseMenor, TextInputEditText campoAlturaTrap){
        boolean retorno;
        if (campoBaseMaior.getText().toString().equals("") || campoBaseMenor.getText().toString().equals("") ||
                campoAlturaTrap.getText().toString().equals("")){
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
        builder.setTitle("Como é calculado a Área do Trapézio?");
        //define a mensagem
        builder.setMessage("A Área do Trapézio é calculado da seguinte forma: \n" +
                "((B + b) x H)/2, (sendo 'B', a base maior da figura, 'b', a base menor da figura e 'H' a altura da mesma!!!).");
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
