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

public class AreaLosangoActivity extends AppCompatActivity {

    private TextInputEditText campoDiagMaior, campoDiagMenor;
    private Button btnAreaLos;
    private ImageButton btnInfoLos;
    private TextView textAreaLos;
    private Double diagonalMaior, diagonalMenor;
    private DecimalFormat decimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_losango);

        campoDiagMaior = findViewById(R.id.campoDiagMaior);
        campoDiagMenor = findViewById(R.id.campoDiagMenor);
        btnAreaLos = findViewById(R.id.btnAreaLos);
        textAreaLos = findViewById(R.id.textAreaLos);
        btnInfoLos = findViewById(R.id.btnInfoLos);
        decimal = new DecimalFormat("#,###.00");

        btnAreaLos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validarCampo(campoDiagMaior, campoDiagMenor)){
                    diagonalMaior = Double.parseDouble(campoDiagMaior.getText().toString());
                    diagonalMenor = Double.parseDouble(campoDiagMenor.getText().toString());
                    textAreaLos.setText("A área do losango é: \n" + CalculoArea.areaLosango(diagonalMaior, diagonalMenor));
                }
                else
                    Toast.makeText(getApplicationContext(), "Preencha os campos acima", Toast.LENGTH_LONG).show();
            }
        });

        btnInfoLos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibeAlert();
            }
        });

    }

    public boolean validarCampo(TextInputEditText diagMaior, TextInputEditText diagMenor){
        boolean retorno;
        if (diagMaior.getText().toString().equals("") || diagMenor.getText().toString().equals("")){
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
        builder.setMessage("A Área do Losango é calculado da seguinte forma: \n" +
                "(D * d)/2, (sendo 'D', a diagonal maior da figura e 'd', a diagonal menor da figura!!!).");
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
