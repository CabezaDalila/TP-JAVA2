package Model;

import java.util.*;
import Excepciones.ClienteNoEncontrado;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * La clase `Feria` representa un evento de feria. Contiene información sobre la feria,
 * como su nombre, una lista de clientes, una lista de stands y una lista de accesorios.
 * También proporciona métodos para gestionar clientes, stands y accesorios, así como
 * serializar y deserializar la instancia de la feria.
 */
public class Feria implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Feria feria;

    private String nombreFeria;
    private Set<Cliente> listaClientes;
    private List<Stand> listaStands;
    private Set<Accesorio> listaAccesorios;

    /**
     * Constructor privado para crear una instancia de `Feria`.
     *
     * @param listaClientes    La lista de clientes de la feria.
     * @param listaStands      La lista de stands de la feria.
     * @param listaAccesorios  La lista de accesorios de la feria.
     */
    private Feria(Set<Cliente> listaClientes, Set<Stand> listaStands, Set<Accesorio> listaAccesorios) {
        this.listaClientes = new TreeSet<>(listaClientes);
        this.listaStands = new ArrayList<>(listaStands);
        this.listaAccesorios = new TreeSet<>(listaAccesorios);
    }

    /**
     * Obtiene una instancia única de la feria utilizando el patrón Singleton.
     *
     * @return La instancia única de la feria.
     */
    public static Feria getInstance() {
        if (feria == null) {
            Feria feriaSerializado = recuperaSerializado();
            if (feriaSerializado == null) {
                feria = new Feria(new HashSet<>(), new HashSet<>(), new TreeSet<>());
            } else {
                feria = feriaSerializado;
            }
        }
        return feria;
    }

    /**
     * Busca un cliente por su ID.
     *
     * @param idCliente El ID del cliente a buscar.
     * @return El cliente encontrado.
     * @throws ClienteNoEncontrado Si el cliente no se encuentra en la lista.
     */
    public Cliente buscaClientePorId(String idCliente) throws ClienteNoEncontrado {
        for (Cliente cliente : listaClientes) {
            if (cliente.getIdCliente().equals(idCliente)) {
                return cliente;
            }
        }
        throw new ClienteNoEncontrado("Error: ID no encontrado");
    }

    /**
     * Agrega un cliente a la lista de clientes de la feria.
     *
     * @param cliente El cliente a agregar.
     */
    public void agregaCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    /**
     * Agrega un accesorio a la lista de accesorios de la feria.
     *
     * @param accesorio El accesorio a agregar.
     */
    public void agregarAccesorio(Accesorio accesorio) {
        listaAccesorios.add(accesorio);
    }
    
     /**
     * Agrega un stand a la lista de stands de la feria.
     *
     * @param stand El stand a agregar.
     */
    public void agregaStand(Stand stand) {
        if (!listaStands.contains(stand)) {
            listaStands.add(stand);
        }
    }
    /**
     * Obtiene la lista de accesorios de la feria.
     *
     * @return La lista de accesorios.
     */
    public Set<Accesorio> getListaAccesorios() {
        return listaAccesorios;
    }

    /**
     * Obtiene la lista de stands de la feria.
     *
     * @return La lista de stands.
     */
    public List<Stand> getListaStands() {
        return listaStands;
    }

    /**
     * Obtiene la lista de clientes de la feria.
     *
     * @return La lista de clientes.
     */
    public Set<Cliente> getListaClientes() {
        return listaClientes;
    }

    /**
     * Ordena la lista de stands alfabéticamente.
     */
    public void ordenadListaStands() {
        Collections.sort(listaStands);
    }

    /**
     * Asocia stands a clientes en función de su ID.
     */
    public void agregaStandAcliente() {
        ArrayList<Stand> nuevaLista = new ArrayList();
        for (Cliente cliente : listaClientes) {
            for (Stand stand : listaStands) {
                if (stand.getUnCliente().getIdCliente().compareTo(cliente.getIdCliente()) == 0) {
                    nuevaLista.add(stand);
                }
            }
            cliente.agregaStands(nuevaLista);
            nuevaLista.clear();
        }
    }

    /**
     * Busca un accesorio por su descripción.
     *
     * @param descripcion La descripción del accesorio a buscar.
     * @return El accesorio encontrado o `null` si no se encuentra.
     */
    public Accesorio buscarAccesorioPorDescripcion(String descripcion) {
        for (Accesorio acc : listaAccesorios) {
            if (acc.getDescAccesorio().equalsIgnoreCase(descripcion)) {
                return acc;
            }
        }
        return null;
    }

    /**
     * Recupera la instancia serializada de la feria desde el archivo "Feria.ser".
     *
     * @return La instancia de la feria recuperada.
     */
    private static Feria recuperaSerializado() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Feria.ser"))) {
            return (Feria) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Clase Feria no encontrada: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
        return null;
    }

    /**
     * Serializa la instancia de la feria y la guarda en el archivo "Feria.ser".
     */
    public static void serializar() {
        File datos = new File("Feria.ser");
        if (datos.exists()) {
            datos.delete();
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Feria.ser"))) {
            out.writeObject(Feria.getInstance());
        } catch (NotSerializableException e) {
            System.out.println("Un objeto no es serializable: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }

    /**
     * Establece el nombre de la feria.
     *
     * @param nombreFeria El nombre de la feria.
     */
    public void setNombreFeria(String nombreFeria) {
        this.nombreFeria = nombreFeria;
    }

    /**
     * Obtiene el nombre de la feria.
     *
     * @return El nombre de la feria.
     */
    public String getNombreFeria() {
        return nombreFeria;
    }
}
