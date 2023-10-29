
package Model;

import java.io.Serializable;
import java.util.ArrayList;


public class StandInterior extends Stand implements Serializable{
    private static final long serialVersionUID = 1L;

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
        float total=sumaPrecioAccesorios() + getPrecio()*getSuperficie() + 1000*cantLuminarias;
        return total;
        
    }

}
