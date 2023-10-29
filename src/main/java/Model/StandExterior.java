
package Model;
import java.io.Serializable;
import java.util.ArrayList;


public class StandExterior extends Stand implements Serializable{
    private static final long serialVersionUID = 1L;
    public StandExterior() {
    }

    public StandExterior(String idStand, int superficie, float precioM2, Cliente unCliente, ArrayList<Accesorio> listaAccesorios) {
        super(idStand, superficie, precioM2, unCliente, listaAccesorios);
    }

    public float  valorTotalStand(){
        float total= getSuperficie()*getPrecio() + sumaPrecioAccesorios();
        int tamanio=tamanioLista();
       
        return tamanio >= 3? total-=total*0.1f : total;
    }
}
/*superficie * precio m2 +
suma precios accesorios (si se contrataron 3 o más accesorios, se aplica un descuento del 10% sobre
el precio de cada accesorio)*/