package main.ej3.Fuegos;

public class FuegoIndividual implements FuegoArtificialComponent {
    private String sound;

    public FuegoIndividual(String sound) {
        this.sound = sound;
    }

    @Override
    public void KABOOM() {
        System.out.println(this.sound+"!!!");
    }
}
