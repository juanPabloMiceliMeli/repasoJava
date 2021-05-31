package main.ej3;

import main.ej3.Fuegos.FuegoArtificialComponent;
import main.ej3.Invitados.Invitado;

import java.util.List;

public class Evento {
    private List<Invitado> invitados;
    private FuegoArtificialComponent fuegos;

    public Evento(List<Invitado> invitados, FuegoArtificialComponent fuegos) {
        this.invitados = invitados;
        this.fuegos = fuegos;
    }

    public void reventarFuegos(){
        fuegos.KABOOM();
    }

    public void comerTorta(){
        for(Invitado i : invitados){
            i.eat();
        }
    }

    public void agregarInvitado(Invitado i){
        invitados.add(i);
    }
}
