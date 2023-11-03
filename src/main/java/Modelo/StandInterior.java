package Model;

import java.util.ArrayList;

/**
 * La clase `StandInterior` es una subclase de la clase `Stand` que representa stands ubicados en áreas interiores de una feria. 
 * Estos stands heredan atributos y métodos de la clase base `Stand` y pueden personalizar su comportamiento según sus necesidades.
 */
public class StandInterior extends Stand {

    private static final long serialVersionUID = 1L;
    private int cantLuminarias;

    /**
     * Constructor vacío de la clase `StandInterior`. Inicializa un stand interior sin propiedades específicas.
     */
    public StandInterior() {
    }

    /**
     * Constructor de la clase `StandInterior` que inicializa todas las propiedades del stand interior.
     *
     * @param cantLuminarias  La cantidad de luminarias en el stand interior.
     * @param idStand         La identificación del stand.
     * @param superficie      La superficie del stand.
     * @param precioM2        El precio por metro cuadrado.
     * @param unCliente       El cliente asociado al stand.
     * @param listaAccesorios La lista de accesorios del stand.
     */
    public StandInterior(int cantLuminarias, String idStand, int superficie, float precioM2, Cliente unCliente, ArrayList<Accesorio> listaAccesorios) {
        super(idStand, superficie, precioM2, unCliente, listaAccesorios);
        this.cantLuminarias = cantLuminarias;
    }

    /**
     * Obtiene la cantidad de luminarias en el stand interior.
     *
     * @return La cantidad de luminarias.
     */
    public int getCantLuminarias() {
        return cantLuminarias;
    }

    /**
     * Establece la cantidad de luminarias en el stand interior.
     *
     * @param cantLuminarias La nueva cantidad de luminarias.
     */
    public void setCantLuminarias(int cantLuminarias) {
        this.cantLuminarias = cantLuminarias;
    }

    /**
     * Calcula el valor total del stand interior, que incluye el costo de los accesorios, el valor base del stand y un costo adicional por luminarias.
     *
     * @return El valor total del stand interior.
     */
    @Override
    public float valorTotalStand() {
        float total = sumaPrecioAccesorios() + super.valorTotalStand() + 1000 * cantLuminarias;
        return total;
    }
}
