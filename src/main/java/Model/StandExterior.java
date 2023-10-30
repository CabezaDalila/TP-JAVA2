package Model;

import java.util.ArrayList;

public class StandExterior extends Stand {

    private static final long serialVersionUID = 1L;

    public StandExterior() {
    }

    public StandExterior(String idStand, int superficie, float precioM2, Cliente unCliente, ArrayList<Accesorio> listaAccesorios) {
        super(idStand, superficie, precioM2, unCliente, listaAccesorios);
    }

    @Override
    public float valorTotalStand() {
        float total =super.valorTotalStand() + sumaPrecioAccesorios();
        int tamanio = tamanioLista();

        return tamanio >= 3 ? total -= total * 0.1f : total;
    }
}

