package main;

import java.util.*;

public class GuardaRopa {
    private Integer contador;
    private Map<Integer, List<Prenda> > prendas;

    public GuardaRopa() {
        this.contador = 0;
        this.prendas = new HashMap<Integer, List<Prenda>>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.prendas.put(this.contador, listaDePrenda);
        return contador++;
    }

    public void mostrarPrendas(){
        for(int i = 0; i < contador; i++){
            if(this.prendas.containsKey(i)){
                System.out.println("Prenda "+i+": "+this.prendas.get(i).toString());
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.prendas.remove(numero);
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "prendas=" + prendas +
                '}';
    }
}
