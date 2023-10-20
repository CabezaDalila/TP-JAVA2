package Model;

import java.util.ArrayList;
import java.util.Objects;


public abstract class Stand{
    private String idStand;
    private int superficie;
    private float precioM2;
    private Cliente cliente;
    private ArrayList<Accesorio>listaAccesorios;
    

    public Stand() {
    }

    public Stand(String idStand, int superficie, float precioM2, Cliente cliente, ArrayList<Accesorio> listaAccesorios) {
        this.idStand = idStand;
        this.superficie = superficie;
        this.precioM2 = precioM2;
        this.cliente = cliente;
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
        return cliente;
    }

    public void setUnCliente(Cliente unCliente) {
        this.cliente = unCliente;
    }

    public ArrayList<Accesorio> getListaAccesorios() {
        return listaAccesorios;
    }

    public void setListaAccesorios(ArrayList<Accesorio> listaAccesorios) {
        this.listaAccesorios = listaAccesorios;
    }
    
    public abstract float  valorTotalStand();
    
    //Cuando se llame al metodo toString de Stands va a llamar al toString de Accesorio automaticamente
    @Override
    public String toString() {
        return "Stand{" + "idStand=" + idStand + ", superficie=" + superficie + ", precioM2=" + precioM2 + ", unCliente=" + cliente + ", listaAccesorios=" + listaAccesorios + '}';
    }
    
}
    

