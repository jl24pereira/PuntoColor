
package dialogs.produccion;

import static db.clases.Tables.CATEGORIA_INVENTARIO;
import static db.clases.Tables.CATEGORIA_PRODUCTO;
import design.button.ButtonUI;
import design.textfield.TextFieldUI;
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
public class DialogCategoriaProducto extends javax.swing.JDialog {
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    
    private boolean guardado = false;
    
    boolean nuevo = true;
    
    int idCat;
    private String codigo;

    public DialogCategoriaProducto(java.awt.Frame parent, boolean modal, String titulo) {
        super(parent, modal);  
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(titulo);
    }
    
    public DialogCategoriaProducto(java.awt.Frame parent, boolean modal, String titulo, int idCat){
        super(parent, modal);
        this.nuevo = false;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(titulo);
        this.idCat = idCat;
        cargarForm(idCat);
    }

    @SuppressWarnings("unchecked")
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
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(450, 250));
        setPreferredSize(new java.awt.Dimension(450, 250));
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
        btnGuardar.setForeground(colorTexto);
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        btnCancelar.setText("Cancelar");
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

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("(*) Nombre de Cat.:");
        jLabel3.setMaximumSize(new java.awt.Dimension(135, 17));
        jLabel3.setMinimumSize(new java.awt.Dimension(135, 17));
        jLabel3.setPreferredSize(new java.awt.Dimension(135, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        jPanel5.add(jLabel3, gridBagConstraints);

        txtNombre.setMinimumSize(new java.awt.Dimension(100, 30));
        txtNombre.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel5.add(txtNombre, gridBagConstraints);
        txtNombre.setUI(new TextFieldUI(colorUI,colorBG));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("(*) Codigo de Cat.:");
        jLabel4.setMaximumSize(new java.awt.Dimension(135, 17));
        jLabel4.setMinimumSize(new java.awt.Dimension(135, 17));
        jLabel4.setPreferredSize(new java.awt.Dimension(135, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        jPanel5.add(jLabel4, gridBagConstraints);

        txtCodigo.setMinimumSize(new java.awt.Dimension(100, 30));
        txtCodigo.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel5.add(txtCodigo, gridBagConstraints);
        txtCodigo.setUI(new TextFieldUI(colorUI,colorBG));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/128/Bookmark128.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel5.add(jLabel1, gridBagConstraints);

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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(nuevo){
            create.insertInto(CATEGORIA_PRODUCTO)
                    .set(CATEGORIA_PRODUCTO.NOMBRE,txtNombre.getText())
                    .set(CATEGORIA_PRODUCTO.CODIGOCATEGORIA, txtCodigo.getText())
                    .execute();
        }else{
            create.update(CATEGORIA_PRODUCTO)
                    .set(CATEGORIA_PRODUCTO.NOMBRE,txtNombre.getText())
                    .where(CATEGORIA_PRODUCTO.IDCATEGORIA.equal(idCat))
                    .execute();
        }
        setGuardado(true);
        dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPanel lblTitulo;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    
    
    private void cargarForm(int idCat){
        Record r = create.select()
                .from(CATEGORIA_PRODUCTO)
                .where(CATEGORIA_PRODUCTO.IDCATEGORIA.equal(idCat))
                .fetchOne();
        txtNombre.setText(r.getValue(CATEGORIA_PRODUCTO.NOMBRE));
        txtCodigo.setText(r.getValue(CATEGORIA_PRODUCTO.CODIGOCATEGORIA));
    }

    /**
     * @return the guardado
     */
    public boolean isGuardado() {
        return guardado;
    }

    /**
     * @param guardado the guardado to set
     */
    public void setGuardado(boolean guardado) {
        this.guardado = guardado;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
}
