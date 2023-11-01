package Model.Reportes;

import Excepciones.ListaVacia;
import Model.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ReporteAccesorios {

    private static Feria feria;

    public ReporteAccesorios() {
        this.feria = Feria.getInstance();
    }

    public Map<String, Integer> reporteAccesoriosOrdenAlfabetico() {
        Map<String, Integer> AccOrdenada = new TreeMap<>();
        for (Stand stand : feria.getListaStands()) {
            ArrayList<Accesorio> listaAccStand = stand.getListaAccesorios();
            for (Accesorio acc : listaAccStand) {
                String descAccesorio = acc.getDescAccesorio().toUpperCase();
                AccOrdenada.putIfAbsent(descAccesorio, 0);
                int valorActual = AccOrdenada.get(descAccesorio);
                valorActual++;
                AccOrdenada.put(descAccesorio, valorActual);
            }

        }
        return AccOrdenada;
    }

    public void generaTxtReporteAccesorios() throws IOException, ListaVacia  {
        String Archivo = "Reporte de Accesorios.txt";
        FileWriter fileWriter = new FileWriter(Archivo);
        if(feria.getListaAccesorios()!= null){
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write("Listado de accesorios ordenado alfabeticamente por su descripcion:\n");
                Map<String, Integer> accOrdenados = reporteAccesoriosOrdenAlfabetico();
                Set<Accesorio> listaAcc = feria.getListaAccesorios();
                for (Map.Entry<String, Integer> entry : accOrdenados.entrySet()) {
                    bufferedWriter.write("Descripcion Accesorio: " + entry.getKey() + "\n");
                    bufferedWriter.write("Cantidad de usos: " + entry.getValue() + "\n");
                    Accesorio acc = feria.buscarAccesorioPorDescripcion(entry.getKey());
                    bufferedWriter.write("Precio: " + acc.getPrecioAlquiler() + "\n");

                }
                    bufferedWriter.write("\n");
            }
        }
        else
            throw new ListaVacia("Error: Lista de accesorios vacia");
    }
}
