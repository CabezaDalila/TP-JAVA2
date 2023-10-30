package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public abstract class Stand implements Comparable<Stand>, Serializable{
    private static final long serialVersionUID = 1L;
    private String idStand;
    private int superficie;
    private float precioM2;
    private Cliente cliente;
    private ArrayList<Accesorio>listaAccesorios;
    
    @Override
    public int compareTo(Stand o){
        return this.idStand.compareTo(o.idStand);
    }
    

    public Stand() {
    }

    public Stand(String idStand, int superficie, float precioM2, Cliente cliente, ArrayList<Accesorio> listaAccesorios) {
        this.idStand = idStand;
        this.superficie = superficie;
        this.precioM2 = precioM2;
        this.cliente = cliente;
        this.listaAccesorios = listaAccesorios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.idStand);
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
        final Stand other = (Stand) obj;
        return Objects.equals(this.idStand, other.idStand);
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
    
    public void agregaAccesorio(Accesorio accesorio){
        listaAccesorios.add(accesorio);
    }
    public abstract float  valorTotalStand();//podria ser no abs y sup*precio podria eesatr aca, no es obligacion q sea abs para q sea polimorfo
    
    @Override
    public String toString() {
        return "Stand{" + "idStand=" + idStand +", Valor Stand="+valorTotalStand() + ", superficie=" + superficie + ", precioM2=" + precioM2 + ", unCliente=" + cliente.getIdCliente() + ", listaAccesorios=" + listaAccesorios.toString() + '}';
    }
    public float sumaPrecioAccesorios(){
        float total=0;
        for(Accesorio ac : listaAccesorios){
            total+=ac.getPrecioAlquiler();
        }
        return total;
    }
    
    public int tamanioLista(){
        return listaAccesorios.size();
    }
    
    public StringBuilder devuelveAccesorios(){
        ArrayList<Accesorio> lista=listaAccesorios;
                StringBuilder descripcionAccesorios = new StringBuilder();
                
                for(Accesorio accesorio:lista){
                    descripcionAccesorios.append(accesorio.getDescAccesorio()).append(", ");
                }
                
                // Eliminar la coma y el espacio del final
                if(descripcionAccesorios.length()>0){
                    descripcionAccesorios.deleteCharAt(descripcionAccesorios.length()-2);
                }
        return descripcionAccesorios;
    }
   

}
    

