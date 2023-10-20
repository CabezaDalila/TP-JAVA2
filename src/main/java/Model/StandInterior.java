
package Model;

import java.util.ArrayList;


public class StandInterior extends Stand{
    private int cantLuminarias;

    public StandInterior() {
    }


    public StandInterior(int cantLuminarias, String idStand, int superficie, float precioM2, Cliente unCliente, ArrayList<Accesorio> listaAccesorios) {
        super(idStand, superficie, precioM2, unCliente, listaAccesorios);
        this.cantLuminarias = cantLuminarias;
    }

    public int getCantLuminarias() {
        return cantLuminarias;
    }

    public void setCantLuminarias(int cantLuminarias) {
        this.cantLuminarias = cantLuminarias;
    }
    public float  valorTotalStand(){
    // DESARROLLAR
    return 0;
    }

}
