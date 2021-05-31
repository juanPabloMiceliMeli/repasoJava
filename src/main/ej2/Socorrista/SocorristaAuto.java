package main.ej2.Socorrista;

public class SocorristaAuto implements Socorrista{

    @Override
    public void socorrer(String patente) {
        System.out.println("Socorriendo auto "+patente);
    }
}
