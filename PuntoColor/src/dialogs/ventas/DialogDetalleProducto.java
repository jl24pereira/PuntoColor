package dialogs.ventas;

import clases.ImageConverter;

import static db.clases.Tables.PRODUCTO;

import design.button.ButtonUI;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import static puntocolor.Principal.cBtnNormal;
import static puntocolor.Principal.cBtnOver;
import static puntocolor.Principal.cBtnPress;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorTexto;
import static puntocolor.Principal.colorUI;
import static puntocolor.Principal.database;

/* @author Jose Luis */
public class DialogDetalleProducto extends javax.swing.JDialog {

    DSLContext create = DSL.using ( database.getConexion () , SQLDialect.POSTGRES_9_5 );

    boolean nuevo = true;

    private int idproducto;

    public DialogDetalleProducto ( java.awt.Frame parent , boolean modal , int idproducto ) {
        super ( parent , modal );
        initComponents ();
        this.setLocationRelativeTo ( null );
        this.setTitle ( "Detalle de Producto" );
        this.idproducto = idproducto;
        cargarForm ();
    }

    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblTitulo = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnCancelar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(400, 600));
        setPreferredSize(new java.awt.Dimension(400, 600));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblTitulo.setBackground(colorBG);
        lblTitulo.setLayout(new java.awt.GridBagLayout());

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
        btnCancelar.setText("Volver");
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
        lblTitulo.add(toolBarTabla1, gridBagConstraints);

        jPanel5.setMinimumSize(new java.awt.Dimension(400, 201));
        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(286, 200));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        lblNombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblNombre.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel5.add(lblNombre, gridBagConstraints);

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblFoto.setMaximumSize(new java.awt.Dimension(256, 256));
        lblFoto.setMinimumSize(new java.awt.Dimension(256, 256));
        lblFoto.setPreferredSize(new java.awt.Dimension(256, 256));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel5.add(lblFoto, gridBagConstraints);

        lblColor.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblColor.setText("Color");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel5.add(lblColor, gridBagConstraints);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(colorUI, 2));
        jScrollPane3.setMinimumSize(new java.awt.Dimension(166, 100));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(166, 100));

        txtDetalle.setBackground(colorBG);
        txtDetalle.setColumns(20);
        txtDetalle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDetalle.setLineWrap(true);
        txtDetalle.setRows(5);
        txtDetalle.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtDetalle);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(jScrollPane3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        lblTitulo.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(lblTitulo, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose ();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel lblTitulo;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTextArea txtDetalle;
    // End of variables declaration//GEN-END:variables

    private void cargarForm () {
        try {
            Record r = create.select ()
                    .from ( PRODUCTO )
                    .where ( PRODUCTO.IDPRODUCTO.equal ( this.idproducto ) )
                    .fetchOne ();
            lblNombre.setText ( r.getValue ( PRODUCTO.NOMBRE ) );
            lblColor.setText ( r.getValue ( PRODUCTO.COLOR ) );
            Image img = ImageConverter.byteToImage ( r.getValue ( PRODUCTO.IMAGEN ) );
            Rectangle rect = lblFoto.getBounds ();
            Icon icon = new ImageIcon ( img.getScaledInstance ( 200 , 200 , Image.SCALE_DEFAULT ) );
            lblFoto.setIcon ( icon );
            txtDetalle.setText ( r.getValue ( PRODUCTO.DETALLE ) );
        } catch ( IOException ex ) {
            Logger.getLogger ( DialogDetalleProducto.class.getName () ).log ( Level.SEVERE , null , ex );
        }
    }

}
