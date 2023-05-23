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

public class AreaQuadActivity extends AppCompatActivity {

    private TextInputEditText textLado;
    private TextView textResultArea;
    private Button btnAreaQuad;
    private ImageButton btnInfoQuad;
    private Double valorLado;
    private String valor;
    private DecimalFormat decimal;
    public AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_quad);

        textLado = findViewById(R.id.campoLado);
        btnAreaQuad = findViewById(R.id.btnAreaQuad);
        textResultArea = findViewById(R.id.textResultArea);
        btnInfoQuad = findViewById(R.id.btnInfoQuad);
        decimal = new DecimalFormat("#,###.00");

        btnAreaQuad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validarCampo(textLado)) {
                    valorLado = Double.parseDouble(textLado.getText().toString());
                    textResultArea.setText("A área do quadrado é: \n" + decimal.format(CalculoArea.areaQuadrado(valorLado)));
                }
                else
                    Toast.makeText(getApplicationContext(), "Preencha o campo acima", Toast.LENGTH_LONG).show();
            }
        });

        btnInfoQuad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibeAlert();
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

    private void exibeAlert() {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Como é calculado a Área do Quadrado?");
        //define a mensagem
        builder.setMessage("A Área do Quadrado é calculado da seguinte forma: \n" +
                "L x L, ou L², (sendo 'L', o lado da figura!!!).");
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
