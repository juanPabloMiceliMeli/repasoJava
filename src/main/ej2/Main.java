package main.ej2;

import main.ej2.Vehiculo.Auto;
import main.ej2.Vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(1000, 5000000, "Copa Piston", 3);
        carrera.darDeAltaMoto(100,10,2,"moto1");
        carrera.darDeAltaAuto(100, 10, 1, "auto1");
        System.out.println(carrera.getGanador());
        System.out.println("Socorremos al auto");
        carrera.socorrer("auto1");
        System.out.println("Socorremos a la moto");
        carrera.socorrer("moto1");

    }
}
