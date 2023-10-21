
package Model;

import java.util.ArrayList;
import java.util.Objects;



public class Cliente implements Comparable<Cliente>{
    private String idCliente;
    private String descCliente;
    private ArrayList<Stand> listaStands;

    public Cliente() {
    }

    public Cliente(String idCliente, String descCliente) {
        this.idCliente = idCliente;
        this.descCliente = descCliente;
    }

    public Cliente(String idCliente, String descCliente, ArrayList<Stand> listaStands) {
        this.idCliente = idCliente;
        this.descCliente = descCliente;
        this.listaStands = listaStands;
    }

    
    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getDescCliente() {
        return descCliente;
    }

    public void setDescCliente(String descCliente) {
        this.descCliente = descCliente;
    }

    public ArrayList<Stand> getListaStands() {
        return listaStands;
    }

    public void setListaStands(ArrayList<Stand> listaStands) {
        this.listaStands = listaStands;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idCliente);
        return hash;
    }

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

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", descCliente=" + descCliente + ", listaStands=" + listaStands + '}';
    }



    @Override
    public int compareTo(Cliente o) {
        return this.idCliente.compareTo(o.idCliente);
    }
    

    void agregaStand(ArrayList<Stand> nuevaLista) {
      if (listaStands == null) {
        listaStands = new ArrayList<>();
      }
       listaStands.addAll(nuevaLista);
        System.out.println("tamanio lista de stands de la clase cliente: "+listaStands.size()); 
         
    }
    
    
  
}
