package com.example.calculadorav2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.calculadorav2.opcoes_area.AreaCirculoActivity;
import com.example.calculadorav2.opcoes_area.AreaLosangoActivity;
import com.example.calculadorav2.opcoes_area.AreaQuadActivity;
import com.example.calculadorav2.opcoes_area.AreaRetActivity;
import com.example.calculadorav2.opcoes_area.AreaTrapezioActivity;
import com.example.calculadorav2.opcoes_area.AreaTrianguloActivity;

import java.util.Objects;

public class ModalareaActivity extends AppCompatActivity {

    private ImageButton area_quadrado, area_retangulo, area_trapezio, area_triangulo, area_losango, area_circulo;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modalarea);

        setTitle("Cálculo de Área");

        area_quadrado = findViewById(R.id.area_quadrado);
        area_retangulo = findViewById(R.id.area_retangulo);
        area_trapezio = findViewById(R.id.area_trapezio);
        area_triangulo = findViewById(R.id.area_triangulo);
        area_losango = findViewById(R.id.area_losango);
        area_circulo = findViewById(R.id.area_circulo);

        area_quadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(getApplicationContext(), AreaQuadActivity.class);
                startActivity(intent);
            }
        });

        area_retangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(getApplicationContext(), AreaRetActivity.class);
                startActivity(intent);

            }
        });

        area_triangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), AreaTrianguloActivity.class);
                startActivity(intent);
            }
        });

        area_trapezio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), AreaTrapezioActivity.class);
                startActivity(intent);
            }
        });

        area_losango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), AreaLosangoActivity.class);
                startActivity(intent);
            }
        });

        area_circulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), AreaCirculoActivity.class);
                startActivity(intent);
            }
        });

    }

}
