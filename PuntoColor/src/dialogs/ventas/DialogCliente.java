
package dialogs.ventas;

import clases.CategoriaCliente;
import static db.clases.Tables.CATEGORIA_CLIENTE;
import static db.clases.Tables.CLIENTE;
import static db.clases.Tables.PROVEEDOR;
import design.button.ButtonUI;
import design.combobox.ComboUI;
import design.textfield.TextFieldUI;
import javax.swing.DefaultComboBoxModel;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
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
public class DialogCliente extends javax.swing.JDialog {
    
    DefaultComboBoxModel dcmCategoria = new DefaultComboBoxModel();
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    
    private boolean guardado = false;
    
    boolean nuevo = true;
    
    boolean hayCat = true;
    
    int idProv;

    public DialogCliente(java.awt.Frame parent, boolean modal, String titulo) {
        super(parent, modal);       
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(titulo);
        cargarCategoriasCliente();
    }
    
    /*public DialogCliente(java.awt.Frame parent, boolean modal, String titulo, int idProv){
        super(parent, modal);
        this.nuevo = false;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(titulo);
        this.idProv = idProv;
        cargarForm(idProv);
    }*/

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
        pFormulario = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblMail = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        jSeparator5 = new javax.swing.JSeparator();
        lblGiro = new javax.swing.JLabel();
        txtGiro = new javax.swing.JTextField();
        txtNIT = new javax.swing.JTextField();
        lblNIT = new javax.swing.JLabel();
        lblIVA = new javax.swing.JLabel();
        txtIVA = new javax.swing.JTextField();
        lblRepresentante = new javax.swing.JLabel();
        txtRepresentante = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox<>();

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

        pFormulario.setBackground(new java.awt.Color(255, 255, 255));
        pFormulario.setMinimumSize(new java.awt.Dimension(400, 600));
        pFormulario.setOpaque(false);
        pFormulario.setPreferredSize(new java.awt.Dimension(400, 600));
        pFormulario.setLayout(new java.awt.GridBagLayout());

        lblNombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNombre.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblNombre, gridBagConstraints);

        txtNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombre.setMinimumSize(new java.awt.Dimension(6, 30));
        txtNombre.setPreferredSize(new java.awt.Dimension(6, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtNombre, gridBagConstraints);
        txtNombre.setUI(new TextFieldUI(colorUI,colorBG));

        lblDireccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblDireccion.setText("Direccion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblDireccion, gridBagConstraints);

        txtDireccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDireccion.setMinimumSize(new java.awt.Dimension(6, 30));
        txtDireccion.setPreferredSize(new java.awt.Dimension(6, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtDireccion, gridBagConstraints);
        txtDireccion.setUI(new TextFieldUI(colorUI,colorBG));

        lblTelefono.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTelefono.setText("Telefono:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblTelefono, gridBagConstraints);

        txtTelefono.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTelefono.setMinimumSize(new java.awt.Dimension(6, 30));
        txtTelefono.setPreferredSize(new java.awt.Dimension(6, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtTelefono, gridBagConstraints);
        txtTelefono.setUI(new TextFieldUI(colorUI,colorBG));

        lblMail.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblMail.setText("E-Mail:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblMail, gridBagConstraints);

        txtMail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtMail.setMinimumSize(new java.awt.Dimension(6, 30));
        txtMail.setPreferredSize(new java.awt.Dimension(6, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtMail, gridBagConstraints);
        txtMail.setUI(new TextFieldUI(colorUI,colorBG));

        lblTipo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTipo.setText("Tipo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblTipo, gridBagConstraints);

        cbxTipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONSUMIDOR FINAL", "CREDITO FISCAL" }));
        cbxTipo.setBorder(javax.swing.BorderFactory.createLineBorder(colorUI, 2));
        cbxTipo.setMinimumSize(new java.awt.Dimension(200, 30));
        cbxTipo.setPreferredSize(new java.awt.Dimension(200, 30));
        cbxTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(cbxTipo, gridBagConstraints);
        cbxTipo.setUI(new ComboUI(colorBG,colorUI));

        jSeparator5.setMinimumSize(new java.awt.Dimension(0, 2));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        pFormulario.add(jSeparator5, gridBagConstraints);

        lblGiro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblGiro.setText("Giro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblGiro, gridBagConstraints);

        txtGiro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtGiro.setEnabled(false);
        txtGiro.setMinimumSize(new java.awt.Dimension(6, 30));
        txtGiro.setPreferredSize(new java.awt.Dimension(6, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtGiro, gridBagConstraints);
        txtGiro.setUI(new TextFieldUI(colorUI,colorBG));

        txtNIT.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNIT.setEnabled(false);
        txtNIT.setMinimumSize(new java.awt.Dimension(300, 30));
        txtNIT.setPreferredSize(new java.awt.Dimension(300, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtNIT, gridBagConstraints);
        txtNIT.setUI(new TextFieldUI(colorUI,colorBG));

        lblNIT.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNIT.setText("NIT:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblNIT, gridBagConstraints);

        lblIVA.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblIVA.setText("IVA:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblIVA, gridBagConstraints);

        txtIVA.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtIVA.setEnabled(false);
        txtIVA.setMinimumSize(new java.awt.Dimension(300, 30));
        txtIVA.setPreferredSize(new java.awt.Dimension(300, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtIVA, gridBagConstraints);
        txtIVA.setUI(new TextFieldUI(colorUI,colorBG));

        lblRepresentante.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblRepresentante.setText("Representante:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblRepresentante, gridBagConstraints);

        txtRepresentante.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtRepresentante.setEnabled(false);
        txtRepresentante.setMinimumSize(new java.awt.Dimension(6, 30));
        txtRepresentante.setPreferredSize(new java.awt.Dimension(6, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtRepresentante, gridBagConstraints);
        txtRepresentante.setUI(new TextFieldUI(colorUI,colorBG));

        lblCategoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCategoria.setText("Categoria:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblCategoria, gridBagConstraints);

        cbxCategoria.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbxCategoria.setModel(dcmCategoria);
        cbxCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(colorUI, 2));
        cbxCategoria.setMinimumSize(new java.awt.Dimension(200, 30));
        cbxCategoria.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(cbxCategoria, gridBagConstraints);
        cbxCategoria.setUI(new ComboUI(colorBG,colorUI));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        lblTitulo.add(pFormulario, gridBagConstraints);

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
        try{
            clases.CategoriaCliente cc = (clases.CategoriaCliente) cbxCategoria.getSelectedItem();
            if(nuevo){
                create.insertInto(CLIENTE)
                        .set(CLIENTE.NOMBRE,txtNombre.getText())
                        .set(CLIENTE.DIRECCION,txtDireccion.getText())
                        .set(CLIENTE.TELEFONO,txtTelefono.getText())
                        .set(CLIENTE.EMAIL,txtMail.getText())
                        .set(CLIENTE.TIPO, cbxTipo.getSelectedItem().toString())
                        .set(CLIENTE.GIRO, txtGiro.getText())
                        .set(CLIENTE.IVA, txtIVA.getText())
                        .set(CLIENTE.NIT, txtNIT.getText())
                        .set(CLIENTE.REPRESENTANTE,txtRepresentante.getText())
                        .set(CLIENTE.IDCATEGORIA, cc.getIdcategoria())
                        .execute();
            }else{
            }
            setGuardado(true);
        }catch(Exception e){
            System.out.println(e);
            setGuardado(false);
        }        
        dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbxTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoItemStateChanged
        // TODO add your handling code here:
        if(cbxTipo.getSelectedIndex()==0){
            seleccionCF();
        }else{
            seleccionDF();
        }
    }//GEN-LAST:event_cbxTipoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblGiro;
    private javax.swing.JLabel lblIVA;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblNIT;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRepresentante;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JPanel lblTitulo;
    private javax.swing.JPanel pFormulario;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtGiro;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNIT;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRepresentante;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
    
    private void cargarForm(int idProveedor){
        /*Record r = create.select()
                .from(PROVEEDOR)
                .where(PROVEEDOR.IDPROVEEDOR.equal(idProv))
                .fetchOne();
        txtNombre.setText(r.getValue(PROVEEDOR.NOMBRE));
        txtNombre.setText(r.getValue(PROVEEDOR.NOMBRE));
        txtGiro.setText(r.getValue(PROVEEDOR.GIRO));
        txtNIT.setText(r.getValue(PROVEEDOR.NIT));
        txtIVA.setText(r.getValue(PROVEEDOR.IVA));
        txtDireccion.setText(r.getValue(PROVEEDOR.DIRECCION));
        txtTelefono.setText(r.getValue(PROVEEDOR.TELEFONO));
        txtMail.setText(r.getValue(PROVEEDOR.EMAIL));
        txtRepresentante.setText(r.getValue(PROVEEDOR.REPRESENTANTE));
        txtCta.setText(r.getValue(PROVEEDOR.CTABANCARIA));
        cbxTipo.setSelectedItem(r.getValue(PROVEEDOR.TIPOPROVEEDOR));
        spPlazo.setValue(r.getValue(PROVEEDOR.PLAZO));
        spLimite.setValue(r.getValue(PROVEEDOR.LIMITE).doubleValue());*/
    }
    
    private void cargarCategoriasCliente(){
        dcmCategoria.removeAllElements();
        Result<Record> result = create.select()
                .from(CATEGORIA_CLIENTE).fetch();
        for (Record r : result) {
            dcmCategoria.addElement(
                    new CategoriaCliente(
                            r.getValue(CATEGORIA_CLIENTE.IDCATEGORIA),
                            r.getValue(CATEGORIA_CLIENTE.CATEGORIA)
                    )
            );
        }
        
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

    private void seleccionCF() {
        txtGiro.setEnabled(false);
        txtNIT.setEnabled(false);
        txtIVA.setEnabled(false);
        txtRepresentante.setEnabled(false);
        txtGiro.setText("");
        txtNIT.setText("");
        txtIVA.setText("");
        txtRepresentante.setText("");
    }

    private void seleccionDF() {
        txtGiro.setEnabled(true);
        txtNIT.setEnabled(true);
        txtIVA.setEnabled(true);
        txtRepresentante.setEnabled(true);
    }
    
}
