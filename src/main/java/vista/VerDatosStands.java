
package vista;

import Excepciones.ClienteNoEncontrado;
import Modelo.Cliente;
import Modelo.Feria;
import Modelo.Stand;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que representa la ventana para visualizar y seleccionar Stands de Clientes.
 * Esta ventana muestra una lista de IDs de clientes y permite al usuario seleccionar un cliente
 * para ver información detallada sobre sus Stands.
 */
public class VerDatosStands extends javax.swing.JFrame {
    private static Feria feria;

    /**
     * Constructor de la clase VerDatosStands.
     * Este constructor inicializa la ventana y muestra una lista de IDs de clientes.
     * También configura la acción para seleccionar un cliente y ver sus Stands.
     */
    public VerDatosStands() {
        initComponents();
        this.feria=Feria.getInstance();
        titulo.setText("<html>ID's de los clientes: <br>" +"</html>");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaStands = new javax.swing.JTable();
        titulo = new javax.swing.JLabel();
        seleccionarCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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

        titulo.setText("jLabel1");

        seleccionarCliente.setText("Elegir Cliente ");
        seleccionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(seleccionarCliente))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(seleccionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void seleccionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarClienteActionPerformed
        String textoIngresado = JOptionPane.showInputDialog("Ingrese el ID del cliente del que quiere consultar sus Stands:");
        if (textoIngresado != null) {
            try {
                Cliente cliente = feria.buscaClientePorId(textoIngresado.toUpperCase());
                VerDatosCliente datosCliente = new VerDatosCliente(cliente);
                datosCliente.setVisible(true);
                datosCliente.setLocationRelativeTo(null);
            } catch (ClienteNoEncontrado e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        this.dispose();
    }//GEN-LAST:event_seleccionarClienteActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton seleccionarCliente;
    private javax.swing.JTable tablaStands;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

    
    /**
     * Método utilizado para cargar los datos de los clientes en la tabla de la ventana.
     * Muestra la lista de IDs de los clientes disponibles en la feria.
     */
    private void cargarTabla() {
         DefaultTableModel modeloTabla = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int colum) {
                return false;
            }

        };


        String titulos[] = {"ID"};
        modeloTabla.setColumnIdentifiers(titulos);

        tablaStands.setModel(modeloTabla);


        Set<Cliente> listaClientes = feria.getListaClientes();


        if (listaClientes != null) {
            for (Cliente cliente : listaClientes) {

                Object objeto[] = {cliente.getIdCliente()};

                modeloTabla.addRow(objeto);
            }
        }

        tablaStands.setModel(modeloTabla);
    }
}
