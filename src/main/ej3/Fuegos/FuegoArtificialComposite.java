package main.ej3.Fuegos;

import java.util.ArrayList;
import java.util.List;

public class FuegoArtificialComposite implements FuegoArtificialComponent {
    private List<FuegoArtificialComponent> fuegosDisponibles;

    public FuegoArtificialComposite() {
        this.fuegosDisponibles = new ArrayList<>();
    }

    public FuegoArtificialComposite(List<FuegoArtificialComponent> fuegosDisponibles) {
        this.fuegosDisponibles = new ArrayList<>(fuegosDisponibles);
    }

    public void agregarFuegoArtificial(FuegoArtificialComponent f){
        fuegosDisponibles.add(f);
    }

    @Override
    public void KABOOM() {
        for(FuegoArtificialComponent fuego : fuegosDisponibles){
            fuego.KABOOM();
        }
    }
}
