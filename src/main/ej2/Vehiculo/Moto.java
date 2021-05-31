package main.ej2.Vehiculo;

public class Moto extends Vehiculo{
    private static final double PESO = 300;
    private static final Integer RUEDAS = 2;

    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, RUEDAS);
    }

}
