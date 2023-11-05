package vista;

import Modelo.*;
import Excepciones.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import xml.*;

/**
 * La clase `PantallaPrincipal` representa la interfaz de usuario principal de la aplicación.
 * Desde esta interfaz, los usuarios pueden acceder a diferentes funcionalidades, como cargar datos XML,
 * ver stands y acceder a informes.
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    private static Feria feria;
    
     private VerDatosStands datosStands;
    
    /**
     * Constructor de la clase `PantallaPrincipal`. Inicializa la interfaz de usuario y la instancia de `Feria`.
     * También verifica si existe un archivo de datos. Si no existe, solicita al usuario el nombre del perfil.
     */
    public PantallaPrincipal() {
        initComponents();
        this.feria = Feria.getInstance();

        File datos = new File("Feria.ser");
        if (!datos.exists()) {
            String nombrePerfil = JOptionPane.showInputDialog(null, "Ingrese el nombre del Perfil", "Nombre del Perfil",
                    JOptionPane.PLAIN_MESSAGE);
            if (nombrePerfil == null || nombrePerfil.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se ingresaron datos. El programa se cerrara.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            } else {
                feria.setNombreFeria(nombrePerfil);
            }
        }
        setTitle("Perfil del usuario " + feria.getNombreFeria());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirma = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios?", "Guardar cambios",
                        JOptionPane.YES_NO_OPTION);
                if (confirma == JOptionPane.YES_OPTION) {
                    feria.serializar();
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnCargarDatos = new javax.swing.JButton();
        btnStands = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        Principal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        jPanel3.setBackground(new java.awt.Color(0, 51, 153));

        btnCargarDatos.setBackground(new java.awt.Color(0, 51, 153));
        btnCargarDatos.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        btnCargarDatos.setForeground(new java.awt.Color(255, 255, 255));
        btnCargarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icono-subir.png"))); // NOI18N
        btnCargarDatos.setText("Cargar datos XML");
        btnCargarDatos.setBorder(null);
        btnCargarDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarDatosActionPerformed(evt);
            }
        });

        btnStands.setBackground(new java.awt.Color(0, 51, 153));
        btnStands.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        btnStands.setForeground(new java.awt.Color(255, 255, 255));
        btnStands.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icono-stand.png"))); // NOI18N
        btnStands.setText("Ver Stands");
        btnStands.setBorder(null);
        btnStands.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStands.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnStandsStateChanged(evt);
            }
        });
        btnStands.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStandsActionPerformed(evt);
            }
        });

        btnReportes.setBackground(new java.awt.Color(0, 51, 153));
        btnReportes.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icono-reporte.png"))); // NOI18N
        btnReportes.setText("Reportes");
        btnReportes.setBorder(null);
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        Principal.setText("Principal");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnStands, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnCargarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(Principal)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCargarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStands, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        Principal.setBackground(new java.awt.Color(0, 51, 153));

        Principal.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N

        Principal.setForeground(new java.awt.Color(255, 255, 255));

        Principal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icono-casa.png"))); // NOI18N

        Principal.setBorder(null);

        Principal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icono-casa.png")));

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Empresa XX");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stand02.jpg"))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(0, 102, 204));

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Stands Personalizados para Ferias y Exposiciones");
        jPanel5.add(jLabel2);

        jLabel7.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Explora Nuestros Servicios y Accesorios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Maneja el evento de clic en el botón de "Reportes". Abre una ventana para mostrar informes.
     * @param evt Evento de clic en el botón.
     */
    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        Reportes ventanaReportes = new Reportes();
        ventanaReportes.setVisible(true);
        ventanaReportes.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnReportesActionPerformed

   /**
    * Maneja el evento de acción cuando se hace clic en el botón "Stands".
    *
    * Este método verifica si hay datos de stands cargados en la feria. Si no hay datos,
    * muestra un mensaje de error. En caso contrario, abre la ventana "VerDatosStands" para
    * mostrar la información de los stands y la ubica en el centro de la pantalla.
    *
    * @param evt El evento de acción generado por hacer clic en el botón "Stands".
    */
    private void btnStandsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStandsActionPerformed
        if(feria.getListaStands().size()==0)
            JOptionPane.showMessageDialog(this, "No hay datos cargados", "Error en la Carga", JOptionPane.ERROR_MESSAGE);
        else{
            datosStands=new VerDatosStands();
            datosStands.setVisible(true);
            datosStands.setLocationRelativeTo(null);
        }
       
    }//GEN-LAST:event_btnStandsActionPerformed
    
    /**
     * Maneja el evento de clic en el botón de "Cargar datos XML". Permite cargar datos desde un archivo XML.
     * @param evt Evento de clic en el botón.
     */
    private void btnCargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarDatosActionPerformed
        if (feria.getListaStands().size() == 0) {
            CargaXML cargador = new CargaXML();
            boolean cargaExitosa = cargador.cargarStandsXML(feria);
            if (cargaExitosa) {
                JOptionPane.showMessageDialog(this, "La carga fue exitosa", "Carga Exitosa", JOptionPane.INFORMATION_MESSAGE);
                feria.agregaStandAcliente();
            } else {
                JOptionPane.showMessageDialog(this, "Hubo un error en la carga", "Error en la Carga", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Los datos ya fueron cargados", "Error en la Carga", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnCargarDatosActionPerformed
    
    private void btnStandsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnStandsStateChanged

    }//GEN-LAST:event_btnStandsStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Principal;
    private javax.swing.JButton btnCargarDatos;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnStands;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
