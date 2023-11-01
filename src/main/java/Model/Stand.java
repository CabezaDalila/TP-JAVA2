package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * La clase `Stand` representa un stand en una feria. Contiene información sobre
 * el stand, como su identificación, superficie, precio por metro cuadrado, cliente
 * asociado y una lista de accesorios. Esta es una clase abstracta que debe ser
 * extendida por clases concretas que definen el tipo de stand.
 */
public abstract class Stand implements Comparable<Stand>, Serializable {

    private static final long serialVersionUID = 1L;
    private String idStand;
    private int superficie;
    private float precioM2;
    private Cliente cliente;
    private ArrayList<Accesorio> listaAccesorios;

    /**
     * Compara este stand con otro en función de su identificación.
     *
     * @param o El stand a comparar.
     * @return Un valor negativo si este stand es menor que el stand pasado,
     *         un valor positivo si es mayor o 0 si son iguales.
     */
    @Override
    public int compareTo(Stand o) {
        return this.idStand.compareTo(o.idStand);
    }

    /**
     * Constructor vacío de la clase `Stand`. Inicializa todas las propiedades a sus valores predeterminados.
     */
    public Stand() {
    }

    /**
     * Constructor de la clase `Stand` que inicializa todas sus propiedades.
     *
     * @param idStand         La identificación del stand.
     * @param superficie      La superficie del stand.
     * @param precioM2        El precio por metro cuadrado.
     * @param cliente         El cliente asociado al stand.
     * @param listaAccesorios La lista de accesorios del stand.
     */
    public Stand(String idStand, int superficie, float precioM2, Cliente cliente, ArrayList<Accesorio> listaAccesorios) {
        this.idStand = idStand;
        this.superficie = superficie;
        this.precioM2 = precioM2;
        this.cliente = cliente;
        this.listaAccesorios = listaAccesorios;
    }

    /**
     * Devuelve la identificación del stand.
     *
     * @return La identificación del stand.
     */
    public String getIdStand() {
        return idStand;
    }

    /**
     * Establece la identificación del stand.
     *
     * @param idStand La identificación del stand.
     */
    public void setIdStand(String idStand) {
        this.idStand = idStand;
    }

    /**
     * Devuelve la superficie del stand.
     *
     * @return La superficie del stand.
     */
    public int getSuperficie() {
        return superficie;
    }

    /**
     * Establece la superficie del stand.
     *
     * @param superficie La superficie del stand.
     */
    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    /**
     * Devuelve el precio por metro cuadrado del stand.
     *
     * @return El precio por metro cuadrado del stand.
     */
    public float getPrecio() {
        return precioM2;
    }

    /**
     * Establece el precio por metro cuadrado del stand.
     *
     * @param precio El precio por metro cuadrado del stand.
     */
    public void setPrecio(float precio) {
        this.precioM2 = precio;
    }

    /**
     * Devuelve el cliente asociado al stand.
     *
     * @return El cliente asociado al stand.
     */
    public Cliente getUnCliente() {
        return cliente;
    }

    /**
     * Establece el cliente asociado al stand.
     *
     * @param unCliente El cliente asociado al stand.
     */
    public void setUnCliente(Cliente unCliente) {
        this.cliente = unCliente;
    }

    /**
     * Devuelve la lista de accesorios del stand.
     *
     * @return La lista de accesorios del stand.
     */
    public ArrayList<Accesorio> getListaAccesorios() {
        return listaAccesorios;
    }

    /**
     * Establece la lista de accesorios del stand.
     *
     * @param listaAccesorios La lista de accesorios del stand.
     */
    public void setListaAccesorios(ArrayList<Accesorio> listaAccesorios) {
        this.listaAccesorios = listaAccesorios;
    }

    /**
     * Agrega un accesorio a la lista de accesorios del stand.
     *
     * @param accesorio El accesorio a agregar.
     */
    public void agregaAccesorio(Accesorio accesorio) {
        listaAccesorios.add(accesorio);
    }

    /**
     * Calcula el valor total del stand multiplicando la superficie por el precio por metro cuadrado.
     *
     * @return El valor total del stand.
     */
    public float valorTotalStand() {
        return precioM2 * superficie;
    }

    /**
     * Devuelve una representación en cadena del stand que incluye su identificación, valor total, superficie,
     * precio por metro cuadrado, cliente asociado y lista de accesorios.
     *
     * @return Una representación en cadena del stand.
     */
    @Override
    public String toString() {
        return "Stand{" +
                "idStand='" + idStand + '\'' +
                ", Valor Stand=" + valorTotalStand() +
                ", superficie=" + superficie +
                ", precioM2=" + precioM2 +
                ", unCliente=" + cliente.getIdCliente() +
                ", listaAccesorios=" + listaAccesorios.toString() +
                '}';
    }

    /**
     * Calcula la suma total de precios de los accesorios en la lista de accesorios del stand.
     *
     * @return La suma total de precios de los accesorios.
     */
    public float sumaPrecioAccesorios() {
        float total = 0;
        for (Accesorio ac : listaAccesorios) {
            total += ac.getPrecioAlquiler();
        }
        return total;
    }

    /**
     * Devuelve el número de accesorios en la lista de accesorios del stand.
     *
     * @return El número de accesorios en la lista.
     */
    public int tamanioLista() {
        return listaAccesorios.size();
    }

    /**
     * Devuelve una cadena que contiene las descripciones de los accesorios en la lista de accesorios del stand.
     *
     * @return Una cadena con las descripciones de los accesorios.
     */
    public StringBuilder devuelveAccesorios() {
        ArrayList<Accesorio> lista = listaAccesorios;
        StringBuilder descripcionAccesorios = new StringBuilder();

        for (Accesorio accesorio : lista) {
            descripcionAccesorios.append(accesorio.getDescAccesorio()).append(", ");
        }
        
        if (descripcionAccesorios.length() > 0) {
            descripcionAccesorios.deleteCharAt(descripcionAccesorios.length() - 2);
        }
        return descripcionAccesorios;
    }


}
