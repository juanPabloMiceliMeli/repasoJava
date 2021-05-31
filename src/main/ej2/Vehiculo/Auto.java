package main.ej2.Vehiculo;

public class Auto extends Vehiculo{
    private static final double PESO = 1000;
    private static final Integer RUEDAS = 4;

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, RUEDAS);
    }



}
