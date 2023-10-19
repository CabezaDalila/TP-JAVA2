
package logica;

import java.util.ArrayList;


public class StandExterior extends Stand {

    public StandExterior() {
    }

    public StandExterior(String idStand, int superficie, float precioM2, Cliente unCliente, ArrayList<Accesorio> listaAccesorios) {
        super(idStand, superficie, precioM2, unCliente, listaAccesorios);
    }

  
}
