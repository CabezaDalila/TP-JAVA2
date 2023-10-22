package Model;

import java.util.ArrayList;
import java.util.List;
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
    
    public void agregaAccesorio(Accesorio accesorio){
        listaAccesorios.add(accesorio);
    }
    public abstract float  valorTotalStand();
    
    //Cuando se llame al metodo toString de Stands va a llamar al toString de Accesorio automaticamente
    @Override
    public String toString() {
        return "Stand{" + "idStand=" + idStand +", Valor Stand="+valorTotalStand() + ", superficie=" + superficie + ", precioM2=" + precioM2 + ", unCliente=" + cliente + ", listaAccesorios=" + listaAccesorios + '}';
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
                
                // Eliminar la coma y el espacio dek final
                if(descripcionAccesorios.length()>0){
                    descripcionAccesorios.deleteCharAt(descripcionAccesorios.length()-2);
                }
        return descripcionAccesorios;
    }
   
}
    

