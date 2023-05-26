package com.example.calculadorav2;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

public class AlertGerenciador {

    private Context contexto;
    AlertDialog.Builder builder;

    public AlertGerenciador(Context contexto) {
        this.contexto = contexto;
    }

    public void comoCalcularAreaQuadradrado(){
        builder = new AlertDialog.Builder(contexto);
        //define o titulo
        builder.setTitle("Como é calculado a Área do Quadrado?");
        //define a mensagem
        builder.setMessage("A Área do Quadrado é calculado da seguinte forma: \n" +
                            "L x L, ou L², (sendo 'L', o lado da figura!!!).");
        //define um botão como positivo
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        }).show();
    }

    public void calculoAreaQuadrado(StringBuffer calculo){
        builder = new AlertDialog.Builder(contexto);
        builder.setTitle("Calculo Área do Quadrado");
        //define a mensagem
        builder.setMessage(calculo);
        //define um botão como positivo
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        }).show();
    }

    public void comoCalcularAreaCirculo(){
        builder = new AlertDialog.Builder(contexto);
        //define o titulo
        builder.setTitle("Como é calculado a Área do Circulo?");
        //define a mensagem
        builder.setMessage("A Área do Circulo é calculado da seguinte forma: \n" +
                "Pi * r², (sendo 'Pi', o valor de 3,1415 e 'r²', a metade da circunferência da figura, vezes ele mesmo!!!).");
        //define um botão como positivo
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        }).show();
    }

    public void calculoAreaCirculo(StringBuffer calculo){
        builder = new AlertDialog.Builder(contexto);
        builder.setTitle("Calculo Área do Círculo");
        //define a mensagem
        builder.setMessage(calculo);
        //define um botão como positivo
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        }).show();
    }

    public void comoCalcularAreaLosango(){
        builder = new AlertDialog.Builder(contexto);
        //define o titulo
        builder.setTitle("Como é calculado a Área do Losango?");
        //define a mensagem
        builder.setMessage("A Área do Losango é calculado da seguinte forma: \n" +
                "(D * d)/2, (sendo 'D', a diagonal maior da figura e 'd', a diagonal menor da figura!!!).");
        //define um botão como positivo
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        }).show();
    }

    public void calculoAreaLosango(StringBuffer calculo){
        builder = new AlertDialog.Builder(contexto);
        builder.setTitle("Calculo Área do Círculo");
        //define a mensagem
        builder.setMessage(calculo);
        //define um botão como positivo
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        }).show();
    }

}
