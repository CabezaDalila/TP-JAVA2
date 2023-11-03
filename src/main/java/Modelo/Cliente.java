
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * La clase `Cliente` representa un cliente en el sistema. Puede utilizarse para
 * almacenar información sobre clientes, como su ID, descripción y una lista de
 * stands asociados a ese cliente.
 *
 * Esta clase implementa la interfaz `Comparable`, lo que permite comparar
 * instancias de `Cliente` en función de su ID.
 */
public class Cliente implements Comparable<Cliente>, Serializable {

    private static final long serialVersionUID = 1L;
    private String idCliente;
    private String descCliente;
    private ArrayList<Stand> listaStands;

    /**
     * Crea un nuevo objeto `Cliente` sin valores iniciales. Deberás establecer
     * los valores de las propiedades por separado utilizando los métodos setter.
     */
    public Cliente() {
    }

    /**
     * Crea un nuevo objeto `Cliente` con valores iniciales especificados.
     *
     * @param idCliente El ID del cliente.
     * @param descCliente La descripción del cliente.
     */
    public Cliente(String idCliente, String descCliente) {
        this.idCliente = idCliente;
        this.descCliente = descCliente;
    }

    /**
     * Compara este cliente con otro cliente en función de sus IDs.
     *
     * @param otroCliente El otro cliente a comparar.
     * @return Un valor negativo si este cliente es menor, un valor positivo si
     * es mayor o cero si son iguales.
     */
    @Override
    public int compareTo(Cliente otroCliente) {
        return this.idCliente.compareTo(otroCliente.idCliente);
    }
    
    /**
     * Agrega una lista de stands a los stands del cliente.
     *
     * @param nuevaLista La lista de stands que se va a agregar.
     */
    void agregaStands(ArrayList<Stand> nuevaLista) {
        if (listaStands == null) {
            listaStands = new ArrayList<>();
        }
        listaStands.addAll(nuevaLista);
    }
    
    /**
     * Obtiene el ID del cliente.
     *
     * @return El ID del cliente.
     */
    public String getIdCliente() {
        return idCliente;
    }
     /**
     * Obtiene la descripción del cliente.
     *
     * @return La descripción del cliente.
     */
    public String getDescCliente() {
        return descCliente;
    }
    /**
     * Obtiene la lista de stands asociados a este cliente.
     *
     * @return La lista de stands del cliente.
     */
    public ArrayList<Stand> getListaStands() {
        return listaStands;
    }

    /**
     * Establece el ID del cliente.
     *
     * @param idCliente El nuevo ID del cliente.
     */
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Establece la descripción del cliente.
     *
     * @param descCliente La nueva descripción del cliente.
     */
    public void setDescCliente(String descCliente) {
        this.descCliente = descCliente;
    }

    /**
     * Establece la lista de stands asociados a este cliente.
     *
     * @param listaStands La nueva lista de stands del cliente.
     */
    public void setListaStands(ArrayList<Stand> listaStands) {
        this.listaStands = listaStands;
    }

    /**
     * Calcula el valor hash para este objeto `Cliente`.
     *
     * @return El valor hash del objeto.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idCliente);
        return hash;
    }

    /**
     * Compara este cliente con otro objeto para determinar si son iguales.
     *
     * @param obj El objeto a comparar con este cliente.
     * @return `true` si los objetos son iguales, `false` en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.idCliente, other.idCliente);
    }

    /**
     * Obtiene una representación en cadena de este objeto `Cliente`.
     *
     * @return Una cadena que describe el objeto `Cliente` con sus propiedades.
     */
    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", descCliente=" + descCliente + ", listaStands=" + listaStands + '}';
    }
}
