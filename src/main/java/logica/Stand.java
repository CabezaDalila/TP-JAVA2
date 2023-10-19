package logica;

import java.util.ArrayList;


public class Stand {
    private String idStand;
    private int superficie;
    private float precioM2;
    private Cliente unCliente;
    private ArrayList<Accesorio>listaAccesorios;

    public Stand() {
    }

    public Stand(String idStand, int superficie, float precioM2, Cliente unCliente, ArrayList<Accesorio> listaAccesorios) {
        this.idStand = idStand;
        this.superficie = superficie;
        this.precioM2 = precioM2;
        this.unCliente = unCliente;
        this.listaAccesorios = listaAccesorios;
    }

    public String getIdStand() {
        return idStand;
    }

    public void setIdStand(String idStand) {
        this.idStand = idStand;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public float getPrecio() {
        return precioM2;
    }

    public void setPrecio(float precio) {
        this.precioM2 = precio;
    }

    public Cliente getUnCliente() {
        return unCliente;
    }

    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }

    public ArrayList<Accesorio> getListaAccesorios() {
        return listaAccesorios;
    }

    public void setListaAccesorios(ArrayList<Accesorio> listaAccesorios) {
        this.listaAccesorios = listaAccesorios;
    }
    
    
}
