package com.example.calculadorav2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton botaoCSimples, botaoJComposto, botaoConversor, botaoTabuada, botaoArea;
    Layout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoCSimples = findViewById(R.id.btnSimples);
        botaoJComposto = findViewById(R.id.btnJComposto);
        botaoConversor = findViewById(R.id.btnConversor);
        botaoTabuada = findViewById(R.id.btnTabuada);
        botaoArea = findViewById(R.id.btnArea);

        botaoCSimples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SimplesActivity.class);
                startActivity(intent);
            }
        });

        botaoJComposto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),JcompostoActivity.class);
                startActivity(intent);
            }
        });

        botaoConversor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ImcActivity.class);
                startActivity(intent);
            }
        });

        botaoTabuada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TabuadaActivity.class);
                startActivity(intent);
            }
        });

        botaoArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibeAlert();
            }
        });

    }

    public void exibeAlert(){

        Intent intent = new Intent(getApplicationContext(), ModalareaActivity.class);
        startActivity(intent);

    }

}
