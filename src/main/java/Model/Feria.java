package Model;

import java.util.*;
import Excepciones.ClienteNoEncontrado;
import xml.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Feria implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Feria feria;

    private String nombreFeria;

    private Set<Cliente> listaClientes;
    private List<Stand> listaStands;
    private Set<Accesorio> listaAccesorios;

    private Feria(Set<Cliente> listaClientes, Set<Stand> listaStands, Set<Accesorio> listaAccesorios) {
        this.listaClientes = new TreeSet<>(listaClientes);
        this.listaStands = new ArrayList<>(listaStands);
        this.listaAccesorios = new TreeSet<>(listaAccesorios);
    }

    //Singleton
    public static Feria getInstance() {
        if (feria == null) {
            Feria feriaSerializado = feria.recuperaSerializado();
            if (feriaSerializado == null) {
                feria = new Feria(new HashSet<>(), new HashSet<>(), new TreeSet<>());
            } else {
                feria = feriaSerializado;
            }
        }
        return feria;
    }

    public Cliente buscaClientePorId(String idCliente) throws ClienteNoEncontrado {
        for (Cliente cliente : listaClientes) {
            if (cliente.getIdCliente().equals(idCliente)) {
                return cliente;
            }
        }
        throw new ClienteNoEncontrado("Error: ID no encontrado");
    }

    public void agregaCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void agregarAccesorio(Accesorio accesorio) {
        listaAccesorios.add(accesorio);
    }

    public Set<Accesorio> getListaAccesorios() {
        return listaAccesorios;
    }

    public List<Stand> getListaStands() {
        return listaStands;
    }

    public Set<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void agregaStand(Stand stand) {
        if (!listaStands.contains(stand)) {
            listaStands.add(stand);
        }
    }

    public void ordenadListaStands() {
        Collections.sort(listaStands);
    }

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

    public Accesorio buscarAccesorioPorDescripcion(String descripcion) {
        for (Accesorio acc : listaAccesorios) {
            if (acc.getDescAccesorio().equalsIgnoreCase(descripcion)) {
                return acc;
            }
        }
        return null;
    }

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

    public void setNombreFeria(String nombreFeria) {
        this.nombreFeria = nombreFeria;
    }

    public String getNombreFeria() {
        return nombreFeria;
    }
  
}
