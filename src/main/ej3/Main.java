package main.ej3;

import main.ej3.Fuegos.FuegoArtificialComponent;
import main.ej3.Fuegos.FuegoIndividual;
import main.ej3.Fuegos.FuegoArtificialComposite;
import main.ej3.Invitados.Invitado;
import main.ej3.Invitados.MeliInvitado;
import main.ej3.Invitados.NoneInvitado;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FuegoArtificialComposite fuegos = new FuegoArtificialComposite();
        fuegos.agregarFuegoArtificial(new FuegoIndividual("Kaboom"));
        fuegos.agregarFuegoArtificial(new FuegoIndividual("Chaskiboom"));
        FuegoArtificialComposite pack = new FuegoArtificialComposite(
                new ArrayList<>(List.of(new FuegoIndividual("Pium Pium"), new FuegoIndividual("Parapan")))
        );

        fuegos.agregarFuegoArtificial(pack);

        Invitado i1 = new MeliInvitado();
        Invitado i2 = new NoneInvitado();
        Invitado i3 = new MeliInvitado();
        Invitado i4 = new NoneInvitado();

        Evento evento = new Evento(new ArrayList<>(List.of(i1,i2,i3,i4)), fuegos);
        evento.comerTorta();
        evento.reventarFuegos();
    }
}
