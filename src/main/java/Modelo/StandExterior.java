package Modelo;

import java.util.ArrayList;

/**
 * La clase `StandExterior` es una subclase de la clase `Stand` que representa stands en áreas exteriores de una feria. 
 * Estos stands heredan atributos y métodos de la clase base `Stand` y pueden personalizar su comportamiento según sus necesidades.
 */
public class StandExterior extends Stand {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor vacío de la clase `StandExterior`. Inicializa un stand exterior sin propiedades específicas.
     */
    public StandExterior() {
    }

    /**
     * Constructor de la clase `StandExterior` que inicializa todas las propiedades del stand exterior.
     *
     * @param idStand         La identificación del stand.
     * @param superficie      La superficie del stand.
     * @param precioM2        El precio por metro cuadrado.
     * @param unCliente       El cliente asociado al stand.
     * @param listaAccesorios La lista de accesorios del stand.
     */
    public StandExterior(String idStand, int superficie, float precioM2, Cliente unCliente, ArrayList<Accesorio> listaAccesorios) {
        super(idStand, superficie, precioM2, unCliente, listaAccesorios);
    }

    /**
     * Calcula el valor total del stand exterior, teniendo en cuenta tanto el precio base del stand como el costo de los accesorios.
     * Si el número de accesorios en la lista es igual o superior a 3, se aplica un descuento del 10% al valor total.
     *
     * @return El valor total del stand exterior.
     */
    @Override
    public float valorTotalStand() {
        float total = super.valorTotalStand() + sumaPrecioAccesorios();
        int tamanio = tamanioLista();

        return tamanio >= 3 ? total -= total * 0.1f : total;
    }
}
