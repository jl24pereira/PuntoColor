
package dialogs.compras;

import clases.Fechero;
import static db.clases.Tables.COMPRAS;
import static db.clases.Tables.PAGOS_COMPRAS;
import static db.clases.Tables.V_ASOCIADO_RECETA;
import static db.clases.Tables.V_COMPRAS;
import static db.clases.Tables.V_DETALLE_COMPRA;
import design.button.ButtonUI;
import design.tabla.CellRenderer;
import design.tabla.HeaderCellRenderer;
import java.awt.Color;
import java.math.BigDecimal;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record5;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import static org.jooq.impl.DSL.sum;
import static puntocolor.Principal.cBtnNormal;
import static puntocolor.Principal.cBtnOver;
import static puntocolor.Principal.cBtnPress;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorTexto;
import static puntocolor.Principal.colorUI;
import static puntocolor.Principal.database;

/* @author Jose Luis */
public class DialogProductosAsociados extends javax.swing.JDialog {
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    
    private boolean guardado = false;
    
    boolean nuevo = true;
    
    boolean pagado = false;
    
    DefaultTableModel dtmDetalle;
    
    int idmaterial;

    public DialogProductosAsociados(java.awt.Frame parent, boolean modal, String titulo, int id) {
        super(parent, modal);  
        initComponents();
        dtmDetalle = (DefaultTableModel) tDetalle.getModel();
        this.setLocationRelativeTo(null);
        this.setTitle(titulo);
        this.idmaterial = id;
        dibujarTablaFacturas();
        cargarTablaDetalle();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pBody = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnCancelar = new javax.swing.JButton();
        pProveedor = new javax.swing.JPanel();
        lblMensaje = new javax.swing.JLabel();
        lblMensaje1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pDetalle = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDetalle = new javax.swing.JTable();
        lblMensaje2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(430, 500));
        setPreferredSize(new java.awt.Dimension(430, 500));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pBody.setBackground(colorBG);
        pBody.setLayout(new java.awt.GridBagLayout());

        toolBarTabla1.setBackground(colorUI);
        toolBarTabla1.setBorder(null);
        toolBarTabla1.setFloatable(false);
        toolBarTabla1.setRollover(true);
        toolBarTabla1.setMaximumSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.setMinimumSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.setPreferredSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.add(jSeparator2);

        btnCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCancelar.setForeground(colorTexto);
        btnCancelar.setText("Salir");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        toolBarTabla1.add(btnCancelar);
        btnCancelar.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pBody.add(toolBarTabla1, gridBagConstraints);

        pProveedor.setOpaque(false);
        pProveedor.setLayout(new java.awt.GridBagLayout());

        lblMensaje.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblMensaje.setText("No se puede Eliminar el Material");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pProveedor.add(lblMensaje, gridBagConstraints);

        lblMensaje1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblMensaje1.setText("Esta Asociado con los siguientes Productos:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pProveedor.add(lblMensaje1, gridBagConstraints);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/64/alert64.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pProveedor.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        pBody.add(pProveedor, gridBagConstraints);

        pDetalle.setOpaque(false);
        pDetalle.setLayout(new java.awt.GridBagLayout());

        tDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Ciodigo", "Detalle"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tDetalle.setRowHeight(30);
        jScrollPane1.setViewportView(tDetalle);
        if (tDetalle.getColumnModel().getColumnCount() > 0) {
            tDetalle.getColumnModel().getColumn(0).setMinWidth(0);
            tDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
            tDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
            tDetalle.getColumnModel().getColumn(1).setMinWidth(75);
            tDetalle.getColumnModel().getColumn(1).setPreferredWidth(75);
            tDetalle.getColumnModel().getColumn(1).setMaxWidth(75);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pDetalle.add(jScrollPane1, gridBagConstraints);

        lblMensaje2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblMensaje2.setForeground(new java.awt.Color(153, 0, 0));
        lblMensaje2.setText("Elimine el material en receta de productos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        pDetalle.add(lblMensaje2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pBody.add(pDetalle, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(pBody, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblMensaje1;
    private javax.swing.JLabel lblMensaje2;
    private javax.swing.JPanel pBody;
    private javax.swing.JPanel pDetalle;
    private javax.swing.JPanel pProveedor;
    private javax.swing.JTable tDetalle;
    private javax.swing.JToolBar toolBarTabla1;
    // End of variables declaration//GEN-END:variables
      
    private void cargarTablaDetalle(){
        for(int i=0; i<tDetalle.getRowCount(); i++){
            dtmDetalle.removeRow(i);
            i-=1;
        }
        Result<?> result = create.select()
                .from(V_ASOCIADO_RECETA)
                .where(V_ASOCIADO_RECETA.IDINVENTARIO.equal(this.idmaterial))
                .fetch();
        for (Record r : result){
            Object[] row = {
                r.getValue(V_ASOCIADO_RECETA.IDPRODUCTO),
                r.getValue(V_ASOCIADO_RECETA.CODIGO),
                r.getValue(V_ASOCIADO_RECETA.NOMBRE)
            };
            dtmDetalle.addRow(row);
        }
        
    }
    
    private void dibujarTablaFacturas(){
         tDetalle.setGridColor(colorUI);
        
        JTableHeader jtableHeader = tDetalle.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tDetalle.setTableHeader(  jtableHeader );
        
        tDetalle.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tDetalle.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tDetalle.repaint();
    }
    
}
