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

public class AreaLosangoActivity extends AppCompatActivity {

    private TextInputEditText campoDiagMaior, campoDiagMenor;
    private Button btnAreaLos, btnExibeCalculo;
    private ImageButton btnInfoLos;
    private TextView textAreaLos;
    private Double diagonalMaior, diagonalMenor;
    private DecimalFormat decimal;
    private AlertGerenciador gerenciadorAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_losango);

        campoDiagMaior = findViewById(R.id.campoDiagMaior);
        campoDiagMenor = findViewById(R.id.campoDiagMenor);
        btnAreaLos = findViewById(R.id.btnAreaLos);
        textAreaLos = findViewById(R.id.textAreaLos);
        btnInfoLos = findViewById(R.id.btnInfoLos);
        btnExibeCalculo = findViewById(R.id.btnExibeCalculo);
        gerenciadorAlert = new AlertGerenciador(this);
        decimal = new DecimalFormat("#,###.00");

        btnAreaLos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validarCampo(campoDiagMaior, campoDiagMenor)){
                    diagonalMaior = Double.parseDouble(campoDiagMaior.getText().toString());
                    diagonalMenor = Double.parseDouble(campoDiagMenor.getText().toString());
                    textAreaLos.setText("A área do losango é: \n" + CalculoArea.areaLosango(diagonalMaior, diagonalMenor));
                    btnExibeCalculo.setVisibility(View.VISIBLE);
                }
                else
                    Toast.makeText(getApplicationContext(), "Preencha os campos acima", Toast.LENGTH_LONG).show();
            }
        });

        btnInfoLos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gerenciadorAlert.comoCalcularAreaLosango();
            }
        });

        btnExibeCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaCalculo(diagonalMaior, diagonalMenor);
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

    private void criaCalculo(double dMaior, double dMenor){

        StringBuffer buffer = new StringBuffer();
        buffer.append("A  =  ( D  *  d)  /  2\n" );
        buffer.append("A  =  ( " + dMaior + "  *  " + dMenor + " ) / 2 \n");
        buffer.append("A  =    " + (dMaior * dMenor) + "  /  2 \n");
        buffer.append("A  =    " + decimal.format(CalculoArea.areaLosango(dMaior, dMenor)));
        gerenciadorAlert.calculoAreaLosango(buffer);

    }

}
