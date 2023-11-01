package Model.Reportes;

import Excepciones.ListaVacia;
import Model.Accesorio;
import Model.Feria;
import Model.Stand;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ReporteStands {

    private static Feria feria;

    public ReporteStands() {
        this.feria = Feria.getInstance();
    }

    //Recorrido con stream
    public List<Stand> ordenaStandDescendentePorValor() {
        List<Stand> listaOrdenada = feria.getListaStands().stream()
                .sorted((stand1, stand2) -> Float.compare(stand2.valorTotalStand(), stand1.valorTotalStand()))
                .toList();
        return listaOrdenada;
    }
    //Recorrido con iterator

    public float valorPromedioStands() {
        float suma = 0;
        int cont = 0;
        Iterator<Stand> it = feria.getListaStands().iterator();
        while (it.hasNext()) {
            Stand stand = it.next();
            suma = +stand.valorTotalStand();
            cont++;
        }
        return cont > 0 ? suma / cont : 0;
    }

    //Recorrido con for each
    //Se podria haber usado NIO.2 que es mas nuevo, y mejora el uso
    public void generaTxtReporteStands() throws IOException, ListaVacia{
        String Archivo = "Reporte de Stands.txt";
        FileWriter fileWriter = new FileWriter(Archivo);
        if(ordenaStandDescendentePorValor()!= null){
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write("Listado completo de stands ordenados descendentemente por su valor total:\n");
                List<Stand> listaStandsOrdenados = ordenaStandDescendentePorValor();
                for (Stand stand : listaStandsOrdenados) {
                    bufferedWriter.write("Id Stand: " + stand.getIdStand());
                    bufferedWriter.write(" Valor del Stand: " + stand.valorTotalStand());
                    bufferedWriter.write(" Superficie: " + stand.getSuperficie());
                    bufferedWriter.write(" Precio metro2: " + stand.getPrecio() + "\n");
                    bufferedWriter.write("Listado de accesorios:\n");
                    for (Accesorio acc : stand.getListaAccesorios()) {
                        bufferedWriter.write(acc.getIdAccesorio() + "\n");
                    }
                    bufferedWriter.write("\n");
                }
                String valorPromedio = String.valueOf(valorPromedioStands());
                bufferedWriter.write("Valor promedio de los stands: " + valorPromedio + "\n");

            }
        }
        else
            throw new ListaVacia("Error: Lista de stands vacia");
    }
}
