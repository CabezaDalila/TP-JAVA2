
package logica;

import java.util.ArrayList;



public class Cliente {
    private String idCliente;
    private String descCliente;
    private ArrayList<Stand> listaStands;

    public Cliente() {
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
    
    
}
