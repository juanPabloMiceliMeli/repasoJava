package main.ej2;

import main.ej2.Socorrista.Socorrista;
import main.ej2.Socorrista.SocorristaAuto;
import main.ej2.Socorrista.SocorristaMoto;
import main.ej2.Vehiculo.Auto;
import main.ej2.Vehiculo.Moto;
import main.ej2.Vehiculo.Vehiculo;

import java.util.*;

public class Carrera {
    private double distancia;
    private Integer premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private Socorrista socorristaAutos;
    private Socorrista socorristaMotos;

    //Si la lista de vehiculos no es conocida desde un principio
    public Carrera(double distancia, Integer premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.socorristaAutos = new SocorristaAuto();
        this.socorristaMotos = new SocorristaMoto();
        setListaDeVehiculos(new ArrayList<>());
    }

    public Carrera(double distancia, Integer premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, List<Vehiculo> listaDeVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.socorristaAutos = new SocorristaAuto();
        this.socorristaMotos = new SocorristaMoto();
        setListaDeVehiculos(listaDeVehiculos);
    }

    public void darDeAltaVehiculo(Vehiculo v){
        if(listaDeVehiculos.size() >= cantidadDeVehiculosPermitidos){
            throw new RuntimeException("Quisiste meter mas vehiculos de los permitidos");
        }
        listaDeVehiculos.add(v);
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        darDeAltaVehiculo(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }
    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        darDeAltaVehiculo(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo v){
        listaDeVehiculos.remove(v);
    }

    public void eliminarVehiculoConPatente(String patente){
        listaDeVehiculos.removeIf((v) -> v.getPatente().equals(patente));
    }
    //                velocidad*aceleracion
    // tiempo = ----------------------------------
    //           2*anguloDeGiro*(peso-ruedas*100)
    public Double getTiempo(Vehiculo v){
        double numerador = v.getVelocidad()*v.getAceleracion();
        double denominador = 2* v.getAnguloDeGiro()*(v.getPeso()- v.getRuedas()*100);
        return numerador/denominador;
    }

    public Vehiculo getGanador(){
        System.out.println("Hacemos una carrera con los vehiculos presentes");
        for(Vehiculo v : listaDeVehiculos){
            System.out.println(v.getPatente()+" tardo "+getTiempo(v)+" segunos.");
        }
        if(listaDeVehiculos.size() <= 0){
            throw new RuntimeException("No hay competidores");
        }
        Vehiculo v =  listaDeVehiculos.stream()
                        .min(Comparator.comparing(this::getTiempo))
                        .orElse(null);

        System.out.println("#######################################################");
        System.out.println("Vehiculo ganador: "+v.getPatente());
        System.out.println("#######################################################");
        return v;
    }

    public void socorrer(String patente){
        Vehiculo v = listaDeVehiculos.stream()
                .filter((_v) -> _v.getPatente().equals(patente))
                .findFirst()
                .orElse(null);
        if(v == null){
            throw new RuntimeException("El vehiculo con dicha patente no existe.");
        }
        if(v.getRuedas() == 4){
            //Es un auto
            socorrerAuto(patente);
        }else if(v.getRuedas() == 2){
            //Es una moto
            socorrerMoto(patente);
        }else{
            throw new RuntimeException("Dicha patente es manejada por un vehiculo ilegal.");
        }
    }

    private void socorrerAuto(String patente){
        this.socorristaAutos.socorrer(patente);
    }
    private void socorrerMoto(String patente){
        this.socorristaMotos.socorrer(patente);
    }


    /************************************************
    ***************SETTERS AND GETTERS***************
    ************************************************/
    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Integer getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Integer premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        if(listaDeVehiculos.size() > cantidadDeVehiculosPermitidos){
            throw new RuntimeException("Quisiste meter mas vehiculos de los permitidos");
        }
        this.listaDeVehiculos = new ArrayList<>(listaDeVehiculos);
    }
}
