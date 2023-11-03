package Modelo.Reportes;

import Excepciones.ListaVacia;
import Modelo.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * La clase `ReporteAccesorios` se encarga de generar un informe de accesorios en la feria.
 * Este informe incluye la cantidad de usos y el precio de alquiler de cada accesorio, ordenado alfabéticamente por su descripción.
 */
public class ReporteAccesorios {

    private static Feria feria;

    /**
     * Constructor de la clase `ReporteAccesorios`. Inicializa la instancia de la feria.
     */
    public ReporteAccesorios() {
        this.feria = Feria.getInstance();
    }

    /**
     * Genera un mapa que contiene la cantidad de usos de cada accesorio, ordenado alfabéticamente por su descripción.
     *
     * @return Un mapa con la descripción del accesorio como clave y la cantidad de usos como valor.
     */
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

    /**
     * Genera un archivo de texto que contiene el informe de accesorios, incluyendo la descripción, cantidad de usos y precio de alquiler.
     *
     * @throws IOException  Si ocurre un error de E/S al escribir el archivo.
     * @throws ListaVacia   Si la lista de accesorios en la feria está vacía.
     */
    public void generaTxtReporteAccesorios() throws IOException, ListaVacia {
       if (!feria.getListaAccesorios().isEmpty()) {
            String Archivo = "Reporte de Accesorios.txt";
             FileWriter fileWriter = new FileWriter(Archivo);
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write("Listado de accesorios ordenado alfabéticamente por su descripción:\n");
                Map<String, Integer> accOrdenados = reporteAccesoriosOrdenAlfabetico();
                for (Map.Entry<String, Integer> entry : accOrdenados.entrySet()) {
                    bufferedWriter.write("Descripcion Accesorio: " + entry.getKey() + "\n");
                    bufferedWriter.write("Cantidad de usos: " + entry.getValue() + "\n");
                    Accesorio acc = feria.buscarAccesorioPorDescripcion(entry.getKey());
                    bufferedWriter.write("Precio: " + acc.getPrecioAlquiler() + "\n");
                }
                bufferedWriter.write("\n");
            }
        } else {
            throw new ListaVacia("Error: Lista de accesorios vacía");
        }
    }
}
