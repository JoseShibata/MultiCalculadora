package com.example.calculadorav2.calculos;

public class CalculoArea {

    public static double areaQuadrado(double valorLado){
        return valorLado*valorLado;
    }

    public static Double areaRetangulo(double valorBase, double valorAltura) {
        return valorBase * valorAltura;
    }

    public static Double areaTriangulo(double valorBase, double valorAltura) {
        return (valorBase * valorAltura)/2;
    }

    public static Double areaTrapezio(double valorBaseMaior, double valorBaseMenor, double valorAltura){
        return ((valorBaseMaior + valorBaseMenor)*valorAltura)/2;
    }

    public static Double areaLosango(double diagonalMaior, double diagonalMenor){
        return (diagonalMaior * diagonalMenor) / 2;
    }

    public static Double areaCirculo(double raio){
          return Math.PI * Math.pow(raio, 2);
    }

}
