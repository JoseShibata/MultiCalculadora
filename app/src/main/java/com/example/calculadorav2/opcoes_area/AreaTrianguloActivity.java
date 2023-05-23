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

public class AreaTrianguloActivity extends AppCompatActivity {

    TextInputEditText campoBaseTri, campoAlturaTri;
    ImageButton btnInfoTri;
    Button btnAreaTri;
    TextView textAreaTri;
    Double valorBase, valorAltura;
    private DecimalFormat decimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_triangulo);

            campoBaseTri = findViewById(R.id.campoBaseTri);
            campoAlturaTri = findViewById(R.id.campoAlturaTri);
            btnInfoTri = findViewById(R.id.btnInfoTri);
            btnAreaTri = findViewById(R.id.btnAreaTri);
            textAreaTri = findViewById(R.id.textAreaTri);
            decimal = new DecimalFormat("#,###.00");

            btnAreaTri.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (validarCampo(campoBaseTri, campoAlturaTri)) {
                        valorBase = Double.parseDouble(campoBaseTri.getText().toString());
                        valorAltura = Double.parseDouble(campoAlturaTri.getText().toString());

                        textAreaTri.setText("A Á" +
                                "rea do Triângulo é: \n" + decimal.format(CalculoArea.areaTriangulo(valorBase, valorAltura)));
                    }else
                        Toast.makeText(getApplicationContext(), "Preencha os campos acima", Toast.LENGTH_LONG).show();
                }
            });
            btnInfoTri.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    exibeAlert();
                }
            });
    }

    public boolean validarCampo(TextInputEditText campoBase, TextInputEditText campoAltura){
        boolean retorno;
        if (campoBase.getText().toString().equals("") || campoAltura.getText().toString().equals("")){
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
        builder.setTitle("Como é calculado a Área do Triângulo?");
        //define a mensagem
        builder.setMessage("A Área do Triângulo é calculado da seguinte forma: \n" +
                "B x H/2, (sendo 'B', a base da figura e 'H' a altura da mesma!!!).");
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
