package main.ej2.Socorrista;

import main.ej2.Vehiculo.Vehiculo;

public class SocorristaMoto implements Socorrista{
    @Override
    public void socorrer(String patente) {
        System.out.println("Socorriendo moto "+patente);
    }
}
