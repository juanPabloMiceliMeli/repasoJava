package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Prenda pNike1 = new Prenda("Nike", "Buzo");
        Prenda pNike2 = new Prenda("Nike", "Pantalon");
        Prenda pNike3 = new Prenda("Nike", "Gorra");
        List<Prenda> lNike = new ArrayList<Prenda>(List.of(pNike1, pNike2, pNike3));

        Prenda pAdidas1 = new Prenda("Adidas", "Buzo");
        Prenda pAdidas2 = new Prenda("Adidas", "Pantalon");
        Prenda pAdidas3 = new Prenda("Adidas", "Campera");
        List<Prenda> lAdidas = new ArrayList<Prenda>(List.of(pAdidas1, pAdidas2, pAdidas3));

        Prenda pTopper1 = new Prenda("Topper", "Remera");
        Prenda pTopper2 = new Prenda("Topper", "Medias");
        Prenda pTopper3 = new Prenda("Topper", "Zapatillas");
        List<Prenda> lTopper = new ArrayList<Prenda>(List.of(pTopper1, pTopper2, pTopper3));

        GuardaRopa gr = new GuardaRopa();

        System.out.println("\nGuardo prendas nike");
        Integer codigoNike = gr.guardarPrendas(lNike);
        gr.mostrarPrendas();
        System.out.println("\nGuardo prendas adidas");
        Integer codigoAdidas = gr.guardarPrendas(lAdidas);
        gr.mostrarPrendas();
        System.out.println("\nRetiro prendas nike");
        List<Prenda> prendasNike = gr.devolverPrendas(codigoNike);
        System.out.println(prendasNike.toString());
        System.out.println("\nGuardo prendas topper");
        Integer codigoTopper = gr.guardarPrendas(lTopper);
        gr.mostrarPrendas();
        System.out.println("\nFin");
    }
}
