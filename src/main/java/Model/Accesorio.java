package Model;

import java.io.Serializable;

public class Accesorio implements Comparable<Accesorio>, Serializable {

    private static final long serialVersionUID = 1L;
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

    @Override
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

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    @Override
    public String toString() {
        return "Accesorio{" + "idAccesorio=" + idAccesorio + ", descAccesorio=" + descAccesorio + ", precioAlquiler=" + precioAlquiler + '}';
    }

}
