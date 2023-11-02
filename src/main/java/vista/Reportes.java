package vista;

import Excepciones.ListaVacia;
import Model.*;
import Model.Reportes.*;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
* La clase `Reportes` representa la interfaz de usuario para generar y mostrar informes relacionados con accesorios y stands de la feria.
* Proporciona funcionalidades para generar archivos TXT con datos de accesorios y stands, calcular el valor promedio de los stands,
* y mostrar tablas con información detallada sobre accesorios y stands.
*/
public class Reportes extends javax.swing.JFrame {

    private static Feria feria;
    ReporteAccesorios reporteAccesorios = new ReporteAccesorios();
    ReporteStands reposteStands = new ReporteStands();

    /**
     * Constructor de la clase `Reportes`. Inicializa la interfaz de usuario y obtiene la instancia de la feria.
     * Calcula el valor promedio de los stands y carga las tablas con información detallada sobre accesorios y stands.
     */
    public Reportes() {
        initComponents();
        feria = Feria.getInstance();
        float valorPromedio = reposteStands.valorPromedioStands();
        promedio.setText(String.format("%.2f", valorPromedio));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        cargarTablaStand();
        cargarTablaAcc();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaReporteAccesorios = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaReporteStands = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBtnDescargarAcc = new javax.swing.JButton();
        jBtnDescargarStands = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        promedio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TablaReporteAccesorios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TablaReporteAccesorios);

        TablaReporteStands.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TablaReporteStands);

        jLabel1.setText("Accesorios ");

        jLabel2.setText("Stands");

        jBtnDescargarAcc.setText("Descargar");
        jBtnDescargarAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDescargarAccActionPerformed(evt);
            }
        });

        jBtnDescargarStands.setText("Descargar");
        jBtnDescargarStands.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDescargarStandsActionPerformed(evt);
            }
        });

        jLabel3.setText("Valor promedio stand:");

        promedio.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnDescargarStands))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnDescargarAcc))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(promedio))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jBtnDescargarAcc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnDescargarStands)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(promedio))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de descarga del informe de accesorios a un archivo de texto.
     * Muestra un mensaje de éxito o error en la generación del archivo.
     */
    private void jBtnDescargarAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDescargarAccActionPerformed
        try {
            reporteAccesorios.generaTxtReporteAccesorios();
            JOptionPane.showMessageDialog(null, "El archivo TXT fue generado con éxito");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "El archivo NO fue generado", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ListaVacia e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jBtnDescargarAccActionPerformed
    
    /**
     * Maneja el evento de descarga del informe de stands a un archivo de texto.
     * Muestra un mensaje de éxito o error en la generación del archivo.
     */
    private void jBtnDescargarStandsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDescargarStandsActionPerformed
        /*try {
            reposteStands.generaTxtReporteStands();
            JOptionPane.showMessageDialog(null, "El archivo TXT fue generado con éxito");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "El archivo NO fue generado", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ListaVacia e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }*/
        try {
        reposteStands.generaTxtReporteStands();
        JOptionPane.showMessageDialog(null, "El archivo TXT fue generado con éxito");
    } catch (ListaVacia e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "El archivo NO fue generado", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jBtnDescargarStandsActionPerformed
    
    /**
     * Carga y muestra la información detallada de los stands en la tabla de la interfaz gráfica.
     * Los datos se obtienen del informe generado por la clase `ReporteStands`.
     */
    private void cargarTablaStand() {

        DefaultTableModel modeloTabla = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int colum) {
                return false;
            }

        };

        String titulos[] = {"ID", "Valor", "Superficie", "Precio M2", "Cliente", "Accesorios"};
        modeloTabla.setColumnIdentifiers(titulos);

        TablaReporteStands.setModel(modeloTabla);

        List<Stand> listaStands = reposteStands.ordenaStandDescendentePorValor();


        if (listaStands != null) {
            for (Stand stand : listaStands) {
                StringBuilder descripcionAccesorios = stand.devuelveAccesorios();
                Object objeto[] = {stand.getIdStand(), stand.valorTotalStand(), stand.getSuperficie(), stand.getPrecio(), stand.getUnCliente().getIdCliente(), descripcionAccesorios};
                modeloTabla.addRow(objeto);
            }
        }

        TablaReporteStands.setModel(modeloTabla);

    }
    /**
     * Carga y muestra la información detallada de los accesorios en la tabla de la interfaz gráfica.
     * Los datos se obtienen del informe generado por la clase `ReporteAccesorios`.
     */
    private void cargarTablaAcc()  {

        DefaultTableModel modeloTabla = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int colum) {
                return false;
            }

        };
        
        String titulos[] = {"ID", "Descripcion", "Precio", "Cant de usos"};
        modeloTabla.setColumnIdentifiers(titulos);
        TablaReporteAccesorios.setModel(modeloTabla);
        Map<String, Integer> listaUsos = reporteAccesorios.reporteAccesoriosOrdenAlfabetico();

        for (Map.Entry<String, Integer> entry : listaUsos.entrySet()) {
            Integer valor = entry.getValue();
            String clave = entry.getKey();
            Accesorio accesorio = feria.buscarAccesorioPorDescripcion(clave);

            if (accesorio != null) {
                Object objeto[] = {accesorio.getIdAccesorio(), accesorio.getDescAccesorio(), accesorio.getPrecioAlquiler(), valor};
                modeloTabla.addRow(objeto);
            }

        }

        TablaReporteAccesorios.setModel(modeloTabla);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaReporteAccesorios;
    private javax.swing.JTable TablaReporteStands;
    private javax.swing.JButton jBtnDescargarAcc;
    private javax.swing.JButton jBtnDescargarStands;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel promedio;
    // End of variables declaration//GEN-END:variables
}
