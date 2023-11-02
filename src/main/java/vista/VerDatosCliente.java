package vista;

import Model.Cliente;
import Model.Stand;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * La clase `VerDatosCliente` representa una ventana de la interfaz de usuario que muestra información detallada sobre los stands
 * de un cliente específico. Muestra una lista de stands asociados al cliente, incluyendo detalles como ID, superficie, precio por metro cuadrado y accesorios.
 */
public class VerDatosCliente extends javax.swing.JFrame {

    private Cliente cliente;

    /**
     * Constructor de la clase `VerDatosCliente`. Recibe un objeto de la clase `Cliente` como parámetro y lo asocia con la instancia actual.
     * Inicializa la interfaz de usuario y muestra información básica sobre el cliente en la etiqueta de datos.
     * @param cliente El cliente del cual se mostrarán los detalles de los stands.
     */
    public VerDatosCliente(Cliente cliente) {
        this.cliente = cliente;
        initComponents();
        datosCte.setText("<html>Datos de los Stands del cliente: <br>" + cliente.getDescCliente() + ", con ID: " + cliente.getIdCliente() + "</html>");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaStands = new javax.swing.JTable();
        datosCte = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        tablaStands.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaStands);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        datosCte.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        datosCte.setForeground(new java.awt.Color(0, 0, 0));
        datosCte.setText("Datos de los Stands del cliente: ");
        jPanel1.add(datosCte, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Método que se ejecuta cuando la ventana se abre. Carga la tabla con los detalles de los stands asociados al cliente.
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel datosCte;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaStands;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Carga y muestra la información detallada de los stands asociados al cliente en una tabla de la interfaz gráfica.
     */
    private void cargarTabla() {

        DefaultTableModel modeloTabla = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int colum) {
                return false;
            }

        };


        String titulos[] = {"ID", "Superficie", "Precio M2", "Accesorios"};
        modeloTabla.setColumnIdentifiers(titulos);

        tablaStands.setModel(modeloTabla);


        List<Stand> listaStands = cliente.getListaStands();


        if (listaStands != null) {
            for (Stand stand : listaStands) {

                StringBuilder descripcionAccesorios = stand.devuelveAccesorios();

                Object objeto[] = {stand.getIdStand(), stand.getSuperficie(), stand.getPrecio(), descripcionAccesorios};

                modeloTabla.addRow(objeto);
            }
        }

        tablaStands.setModel(modeloTabla);

    }
}
