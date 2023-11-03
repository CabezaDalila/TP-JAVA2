package Modelo;

import java.io.Serializable;

/**
 * La clase `Accesorio` representa un objeto accesorio en el sistema.
 * Puede utilizarse para almacenar información sobre accesorios, como su ID,
 * descripción y precio de alquiler.
 *
 * Esta clase implementa la interfaz `Comparable`, lo que permite comparar
 * instancias de `Accesorio` en función de su ID.
 *
 * La clase es serializable para permitir su almacenamiento y recuperación.
 */
public class Accesorio implements Comparable<Accesorio>, Serializable {

    private static final long serialVersionUID = 1L;
    private String idAccesorio;
    private String descAccesorio;
    private double precioAlquiler;

    /**
     * Crea un nuevo objeto `Accesorio` sin valores iniciales. Se debera
     * establecer los valores de las propiedades por separado utilizando
     * los métodos setter.
     */
    public Accesorio() {
    }

    /**
     * Crea un nuevo objeto `Accesorio` con valores iniciales especificados.
     *
     * @param idAccesorio El ID del accesorio.
     * @param descAccesorio La descripción del accesorio.
     * @param precioAlquiler El precio de alquiler del accesorio.
     */
    public Accesorio(String idAccesorio, String descAccesorio, double precioAlquiler) {
        this.idAccesorio = idAccesorio;
        this.descAccesorio = descAccesorio;
        this.precioAlquiler = precioAlquiler;
    }

    /**
     * Compara este accesorio con otro accesorio en función de sus IDs.
     *
     * @param otroAccesorio El otro accesorio a comparar.
     * @return Un valor negativo si este accesorio es menor, un valor positivo
     * si es mayor o cero si son iguales.
     */
    @Override
    public int compareTo(Accesorio otroAccesorio) {
        return this.idAccesorio.compareTo(otroAccesorio.idAccesorio);
    }

    /**
     * Obtiene el ID del accesorio.
     *
     * @return El ID del accesorio.
     */
    public String getIdAccesorio() {
        return idAccesorio;
    }
    /**
     * Obtiene la descripción del accesorio.
     *
     * @return La descripción del accesorio.
     */
    public String getDescAccesorio() {
        return descAccesorio;
    }
    
      /**
     * Obtiene el precio de alquiler del accesorio.
     *
     * @return El precio de alquiler del accesorio.
     */
    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    /**
     * Establece el precio de alquiler del accesorio.
     *
     * @param precioAlquiler El nuevo precio de alquiler del accesorio.
     */
    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }
    
    /**
     * Establece el ID del accesorio.
     *
     * @param idAccesorio El nuevo ID del accesorio.
     */
    public void setIdAccesorio(String idAccesorio) {
        this.idAccesorio = idAccesorio;
    }
    /**
     * Establece la descripción del accesorio.
     *
     * @param descAccesorio La nueva descripción del accesorio.
     */
    public void setDescAccesorio(String descAccesorio) {
        this.descAccesorio = descAccesorio;
    }

    /**
     * Devuelve una representación en cadena de este objeto `Accesorio`.
     *
     * @return Una cadena que describe el objeto `Accesorio` con sus propiedades.
     */
    @Override
    public String toString() {
        return "Accesorio{" +
               "idAccesorio=" + idAccesorio +
               ", descAccesorio=" + descAccesorio +
               ", precioAlquiler=" + precioAlquiler +
               '}';
    }
}
