package dialogs.ventas;

import design.button.ButtonUI;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import static db.clases.Tables.PEDIDO;
import static puntocolor.Principal.cBtnNormal;
import static puntocolor.Principal.cBtnOver;
import static puntocolor.Principal.cBtnPress;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorTexto;
import static puntocolor.Principal.colorUI;
import static puntocolor.Principal.database;

/* @author Jose Luis */
public class DialogComentario extends javax.swing.JDialog {

    DSLContext create = DSL.using ( database.getConexion () , SQLDialect.POSTGRES_9_5 );

    boolean nuevo = true;

    private String titulo;

    private int codigo;

    public DialogComentario ( java.awt.Frame parent , boolean modal , String titulo , int idpedido ) {
        super ( parent , modal );
        initComponents ();
        this.setLocationRelativeTo ( null );
        this.setTitle ( titulo );
        this.codigo = idpedido;
        cargarForm ();
    }

    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblTitulo = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnCancelar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextArea();
        txtContador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(400, 250));
        setPreferredSize(new java.awt.Dimension(400, 250));
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

        btnGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnGuardar.setForeground(colorBG);
        btnGuardar.setText("Guardar");
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        toolBarTabla1.add(btnGuardar);
        btnGuardar.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));
        toolBarTabla1.add(jSeparator1);

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

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(colorUI, 2));
        jScrollPane3.setMinimumSize(new java.awt.Dimension(166, 100));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(166, 100));

        txtComentario.setBackground(colorBG);
        txtComentario.setColumns(20);
        txtComentario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtComentario.setLineWrap(true);
        txtComentario.setRows(5);
        txtComentario.setWrapStyleWord(true);
        txtComentario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtComentarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtComentarioKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(txtComentario);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(jScrollPane3, gridBagConstraints);

        txtContador.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtContador.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtContador.setText("0/250 Caracteres");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(txtContador, gridBagConstraints);

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

    private void txtComentarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComentarioKeyTyped
        // TODO add your handling code here:
        if ( txtComentario.getText ().length () == 250 ) {
            evt.consume ();
        }
    }//GEN-LAST:event_txtComentarioKeyTyped

    private void txtComentarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComentarioKeyReleased
        // TODO add your handling code here:
        if ( txtComentario.getText ().length () <= 250 ) {
            txtContador.setText (
                    txtComentario.getText ().length () + "/250 Caracteres"
            );
        }
    }//GEN-LAST:event_txtComentarioKeyReleased

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        create.update ( PEDIDO )
                .set ( PEDIDO.COMENTARIOS , txtComentario.getText () )
                .where ( PEDIDO.IDPEDIDO.equal ( codigo ) )
                .execute ();
        dispose ();
    }//GEN-LAST:event_btnGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPanel lblTitulo;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTextArea txtComentario;
    private javax.swing.JLabel txtContador;
    // End of variables declaration//GEN-END:variables

    private void cargarForm () {
        String comentario = create.select ( PEDIDO.COMENTARIOS )
                .from ( PEDIDO )
                .where ( PEDIDO.IDPEDIDO.equal ( codigo ) )
                .fetchOne ( PEDIDO.COMENTARIOS , String.class );
        txtComentario.setText ( comentario );
    }

}
