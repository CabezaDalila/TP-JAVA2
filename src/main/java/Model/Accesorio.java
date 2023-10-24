
package Model;


public class Accesorio implements Comparable<Accesorio>{
    private String idAccesorio;
    private String descAccesorio;
    private double precioAlquiler;

    public Accesorio() {
    }

    public Accesorio(String idAccesorio, String descAccesorio, double precioAlquiler) {
        this.idAccesorio = idAccesorio;
        this.descAccesorio = descAccesorio;
        this.precioAlquiler = precioAlquiler;
    }

    public String getIdAccesorio() {
        return idAccesorio;
    }
            
    public void setIdAccesorio(String idAccesorio) {
        this.idAccesorio = idAccesorio;
    }

    public int compareTo(Accesorio otroAccesorio) {
       return this.idAccesorio.compareTo(otroAccesorio.idAccesorio);
    }

    public String getDescAccesorio() {
        return descAccesorio;
    }

    public void setDescAccesorio(String descAccesorio) {
        this.descAccesorio = descAccesorio;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(float precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }
    
   /* public void muestraListaAccesorios(){
        for(Accesorio miAccesorio: listaAccesorios){
            System.out.println("ID Accesorio: "+miAccesorio.getIdAccesorio());
        }
    }*/

    @Override
    public String toString() {
        return "Accesorio{" + "idAccesorio=" + idAccesorio + ", descAccesorio=" + descAccesorio + ", precioAlquiler=" + precioAlquiler + '}';
    }

    int compare(Accesorio acc2) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}