package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * La clase abstracta `Stand` representa un stand en una feria. Los stands pueden ser de tipo StandInterior o StandExterior, y comparten atributos como el ID, superficie, precio por metro cuadrado (M2), cliente y una lista de accesorios.
 */
public abstract class Stand implements Comparable<Stand>, Serializable {
    private static final long serialVersionUID = 1L;
    private String idStand;
    private int superficie;
    private float precioM2;
    private Cliente cliente;
    private ArrayList<Accesorio> listaAccesorios;

    /**
     * Constructor por defecto de la clase `Stand`.
     */
    public Stand() {
    }

    /**
     * Constructor que crea un stand con información específica.
     * @param idStand El ID del stand.
     * @param superficie La superficie del stand.
     * @param precioM2 El precio por metro cuadrado.
     * @param cliente El cliente que alquila el stand.
     * @param listaAccesorios Una lista de accesorios asociados al stand.
     */
    public Stand(String idStand, int superficie, float precioM2, Cliente cliente, ArrayList<Accesorio> listaAccesorios) {
        this.idStand = idStand;
        this.superficie = superficie;
        this.precioM2 = precioM2;
        this.cliente = cliente;
        this.listaAccesorios = listaAccesorios;
    }

    /**
     * Calcula y devuelve el valor total del stand basado en la superficie y el precio por metro cuadrado.
     * @return El valor total del stand.
     */
    public float valorTotalStand() {
        return precioM2 * superficie;
    }

    /**
     * Agrega un accesorio a la lista de accesorios del stand.
     * @param accesorio El accesorio a agregar.
     */
    public void agregaAccesorio(Accesorio accesorio) {
        listaAccesorios.add(accesorio);
    }
    
    /**
     * Obtiene el ID del stand.
     * @return El ID del stand.
     */
    public String getIdStand() {
        return idStand;
    }

    /**
     * Obtiene la superficie del stand.
     * @return La superficie del stand.
     */
    public int getSuperficie() {
        return superficie;
    }

    /**
     * Obtiene el precio por metro cuadrado del stand.
     * @return El precio por metro cuadrado del stand.
     */
    public float getPrecio() {
        return precioM2;
    }
    
    /**
     * Obtiene el cliente que alquila el stand.
     * @return El cliente que alquila el stand.
     */
    public Cliente getUnCliente() {
        return cliente;
    }
    
    /**
     * Obtiene la lista de accesorios asociados al stand.
     * @return La lista de accesorios del stand.
     */
    public ArrayList<Accesorio> getListaAccesorios() {
        return listaAccesorios;
    }
    
    /**
     * Establece la superficie del stand.
     * @param superficie La nueva superficie del stand.
     */
    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    /**
     * Establece el ID del stand.
     * @param idStand El nuevo ID del stand.
     */
    public void setIdStand(String idStand) {
        this.idStand = idStand;
    }

    /**
     * Establece el precio por metro cuadrado del stand.
     * @param precio El nuevo precio por metro cuadrado.
     */
    public void setPrecio(float precio) {
        this.precioM2 = precio;
    }

    /**
     * Establece el cliente que alquila el stand.
     * @param unCliente El nuevo cliente que alquila el stand.
     */
    public void setUnCliente(Cliente unCliente) {
        this.cliente = unCliente;
    }
    
    /**
     * Establece la lista de accesorios asociados al stand.
     * @param listaAccesorios La nueva lista de accesorios.
     */
    public void setListaAccesorios(ArrayList<Accesorio> listaAccesorios) {
        this.listaAccesorios = listaAccesorios;
    }

    /**
     * Compara dos stands según su ID para ordenarlos.
     * @param o El stand a comparar.
     * @return Un valor negativo, cero o positivo si este stand es menor, igual o mayor que el stand proporcionado, respectivamente.
     */
    @Override
    public int compareTo(Stand o) {
        return this.idStand.compareTo(o.idStand);
    }

    /**
     * Calcula la suma total de precios de los accesorios asociados al stand.
     * @return La suma total de precios de accesorios.
     */
    public float sumaPrecioAccesorios() {
        float total = 0;
        for (Accesorio ac : listaAccesorios) {
            total += ac.getPrecioAlquiler();
        }
        return total;
    }

    /**
     * Obtiene el número de accesorios en la lista del stand.
     * @return El número de accesorios.
     */
    public int tamanioLista() {
        return listaAccesorios.size();
    }

    /**
     * Devuelve una cadena que representa la descripción de los accesorios asociados al stand.
     * @return Una cadena con la descripción de los accesorios.
     */
    public StringBuilder devuelveAccesorios() {
        ArrayList<Accesorio> lista = listaAccesorios;
        StringBuilder descripcionAccesorios = new StringBuilder();

        for (Accesorio accesorio : lista) {
            descripcionAccesorios.append(accesorio.getDescAccesorio()).append(", ");
        }

        // Eliminar la coma y el espacio del final
        if (descripcionAccesorios.length() > 0) {
            descripcionAccesorios.deleteCharAt(descripcionAccesorios.length() - 2);
        }
        return descripcionAccesorios;
    }

    /**
     * Compara si dos stands son iguales basados en su ID.
     * @param obj El objeto a comparar con el stand.
     * @return `true` si son iguales, `false` en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Stand other = (Stand) obj;
        return Objects.equals(this.idStand, other.idStand);
    }

    /**
     * Calcula el hash code del stand basado en su ID.
     * @return El hash code del stand.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.idStand);
        return hash;
    }

    /**
     * Genera una representación de cadena del stand, incluyendo su ID, valor, superficie, precio por metro cuadrado, cliente y lista de accesorios.
     * @return Una representación de cadena del stand.
     */
    @Override
    public String toString() {
        return "Stand{" + "idStand=" + idStand + ", Valor Stand=" + valorTotalStand() + ", superficie=" + superficie + ", precioM2=" + precioM2 + ", unCliente=" + cliente.getIdCliente() + ", listaAccesorios=" + listaAccesorios.toString() + '}';
    }
}
