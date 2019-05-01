
package dialogs.compras;

import clases.Mensajes;
import static db.clases.Tables.CATEGORIA_INVENTARIO;
import static db.clases.Tables.COMPRAS;
import static db.clases.Tables.DETALLE_COMPRA;
import static db.clases.Tables.INVENTARIO;
import static db.clases.Tables.MEDIDA;
import static db.clases.Tables.UNIDAD_MEDIDA;
import design.button.ButtonUI;
import design.combobox.CategoriaInventario;
import design.combobox.ComboUI;
import design.combobox.Medida;
import design.combobox.Unidad;
import design.spinner.SpinnerUI;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import org.jooq.DSLContext;
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
public class DialogMateriaPrima extends javax.swing.JDialog {
    
    DefaultComboBoxModel dcmMedida = new DefaultComboBoxModel();
    DefaultComboBoxModel dcmUnidad = new DefaultComboBoxModel();
    DefaultComboBoxModel dcmCategoria = new DefaultComboBoxModel();
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    
    private boolean guardado = false;
    
    boolean nuevo = true;
    
    boolean hayCat = true;
    
    String CODIGOP;
    String CATEGORIAP;
    String padre;
    
    private String codigo;
    
    private int idInventario;

    public DialogMateriaPrima(java.awt.Frame parent, boolean modal, String padre, String titulo) {
        super(parent, modal);
        cargarCategoria();
        cargarMedidas();        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(titulo);
        cbxUnidad.setSelectedIndex(0);
        cbxCategoria.setSelectedIndex(0);
        this.padre = padre;
        switch(padre){
            case "inventarios":
                break;
            case "compras":
                spExist.setEnabled(false);
                spPrecio.setEnabled(false);
        }
        cbxCategoria.requestFocus();
    }
    
    public DialogMateriaPrima(java.awt.Frame parent, boolean modal, String titulo, int idmaterial, String categoria){
        super(parent, modal);
        this.nuevo = false;
        CATEGORIAP = categoria;
        cargarCategoria();
        cargarMedidas();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(titulo);
        cargarForm(idmaterial);
        cbxCategoria.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblTitulo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        cbxUnidad = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbxMedida = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        spPrecio = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        spMax = new javax.swing.JSpinner();
        spMin = new javax.swing.JSpinner();
        spExist = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(500, 675));
        setPreferredSize(new java.awt.Dimension(500, 675));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblTitulo.setBackground(colorBG);
        lblTitulo.setLayout(new java.awt.GridBagLayout());

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridBagLayout());

        lblCodigo.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblCodigo.setForeground(colorUI);
        lblCodigo.setText("CODIGO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel2.add(lblCodigo, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Categoria:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel2.add(jLabel4, gridBagConstraints);

        cbxCategoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbxCategoria.setModel(dcmCategoria);
        cbxCategoria.setSelectedIndex(-1);
        cbxCategoria.setMinimumSize(new java.awt.Dimension(150, 30));
        cbxCategoria.setPreferredSize(new java.awt.Dimension(150, 30));
        cbxCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCategoriaItemStateChanged(evt);
            }
        });
        cbxCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbxCategoriaKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        jPanel2.add(cbxCategoria, gridBagConstraints);
        cbxCategoria.setUI(new ComboUI(colorBG,java.awt.Color.GRAY));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("(*) Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel2.add(jLabel1, gridBagConstraints);

        txtNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombre.setMinimumSize(new java.awt.Dimension(200, 30));
        txtNombre.setPreferredSize(new java.awt.Dimension(200, 30));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        jPanel2.add(txtNombre, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Descripción:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel2.add(jLabel3, gridBagConstraints);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(166, 100));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(166, 100));

        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        jPanel2.add(jScrollPane1, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Unidad de Medida:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel2.add(jLabel5, gridBagConstraints);

        cbxUnidad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbxUnidad.setModel(dcmMedida);
        cbxUnidad.setSelectedIndex(-1);
        cbxUnidad.setMinimumSize(new java.awt.Dimension(150, 30));
        cbxUnidad.setPreferredSize(new java.awt.Dimension(150, 30));
        cbxUnidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxUnidadItemStateChanged(evt);
            }
        });
        cbxUnidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbxUnidadKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        jPanel2.add(cbxUnidad, gridBagConstraints);
        cbxUnidad.setUI(new ComboUI(colorBG,java.awt.Color.GRAY));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Medida");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel2.add(jLabel6, gridBagConstraints);

        cbxMedida.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbxMedida.setModel(dcmUnidad);
        cbxMedida.setMinimumSize(new java.awt.Dimension(150, 30));
        cbxMedida.setPreferredSize(new java.awt.Dimension(150, 30));
        cbxMedida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbxMedidaKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        jPanel2.add(cbxMedida, gridBagConstraints);
        cbxMedida.setUI(new ComboUI(colorBG,java.awt.Color.GRAY));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Precio de Compra");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel2.add(jLabel7, gridBagConstraints);

        spPrecio.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        spPrecio.setEditor(new JSpinner.NumberEditor(spPrecio, "0.0000"));
        spPrecio.setMinimumSize(new java.awt.Dimension(100, 30));
        spPrecio.setPreferredSize(new java.awt.Dimension(100, 30));
        spPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                spPrecioKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel2.add(spPrecio, gridBagConstraints);
        spPrecio.setUI(new SpinnerUI(colorBG,java.awt.Color.GRAY));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Minimo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel2.add(jLabel8, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Maximo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel2.add(jLabel9, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Existencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel2.add(jLabel10, gridBagConstraints);

        spMax.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        spMax.setEditor(new JSpinner.NumberEditor(spMax, "0.0000"));
        spMax.setMinimumSize(new java.awt.Dimension(100, 30));
        spMax.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel2.add(spMax, gridBagConstraints);
        spMax.setUI(new SpinnerUI(colorBG,java.awt.Color.GRAY));

        spMin.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        spMin.setEditor(new JSpinner.NumberEditor(spMin, "0.0000"));
        spMin.setMinimumSize(new java.awt.Dimension(100, 30));
        spMin.setPreferredSize(new java.awt.Dimension(100, 30));
        spMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                spMinKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel2.add(spMin, gridBagConstraints);
        spMin.setUI(new SpinnerUI(colorBG,java.awt.Color.GRAY));

        spExist.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        spExist.setEditor(new JSpinner.NumberEditor(spExist, "0.0000"));
        spExist.setMinimumSize(new java.awt.Dimension(100, 30));
        spExist.setPreferredSize(new java.awt.Dimension(100, 30));
        spExist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                spExistKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel2.add(spExist, gridBagConstraints);
        spExist.setUI(new SpinnerUI(colorBG,java.awt.Color.GRAY));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/64/File-info.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        lblTitulo.add(jPanel2, gridBagConstraints);

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(lblTitulo, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxUnidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxUnidadItemStateChanged
        // TODO add your handling code here:
        Medida m = (Medida) cbxUnidad.getSelectedItem();
        cargarUnidades(m.getId());
    }//GEN-LAST:event_cbxUnidadItemStateChanged

    private void cbxCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCategoriaItemStateChanged
        // TODO add your handling code here:
        CategoriaInventario cat = (CategoriaInventario) cbxCategoria.getSelectedItem();
        if(nuevo){
            lblCodigo.setText(cat.generarCodigo());
        }else{
            if(CATEGORIAP.equals(cat.getNombre())){
                lblCodigo.setText(CODIGOP);
            }else{
                lblCodigo.setText(cat.generarCodigo());
            }
        }
    }//GEN-LAST:event_cbxCategoriaItemStateChanged

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(isComplete()){
           if(nuevo){
               nuevoMaterial();
           }else{
               editarMaterial();
           } 
           setGuardado(true);
           dispose();
        }else{
            new Mensajes().mensajeError("Verificar los campos requeridos");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbxCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxCategoriaKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtNombre.requestFocus();
        }
    }//GEN-LAST:event_cbxCategoriaKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtDescripcion.requestFocus();
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            cbxUnidad.requestFocus();
        }
    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void cbxUnidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxUnidadKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            cbxMedida.requestFocus();
        }
    }//GEN-LAST:event_cbxUnidadKeyReleased

    private void cbxMedidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxMedidaKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            spPrecio.requestFocus();
        }
    }//GEN-LAST:event_cbxMedidaKeyReleased

    private void spPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spPrecioKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            spExist.requestFocus();
        }
    }//GEN-LAST:event_spPrecioKeyReleased

    private void spExistKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spExistKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            spMin.requestFocus();
        }
    }//GEN-LAST:event_spExistKeyReleased

    private void spMinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spMinKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            spMax.requestFocus();
        }
    }//GEN-LAST:event_spMinKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox<String> cbxMedida;
    private javax.swing.JComboBox<String> cbxUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JPanel lblTitulo;
    private javax.swing.JSpinner spExist;
    private javax.swing.JSpinner spMax;
    private javax.swing.JSpinner spMin;
    private javax.swing.JSpinner spPrecio;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void cargarMedidas(){
        Result<Record> result = create.select()
                .from(MEDIDA)
                .fetch();
        for (Record r : result) {
            dcmMedida.addElement(new Medida(r.getValue(MEDIDA.IDMEDIDA),r.getValue(MEDIDA.DETALLE)));
        }
    }
    
    private void cargarUnidades(int id){
        dcmUnidad.removeAllElements();
        Result<Record> result = create.select()
                .from(UNIDAD_MEDIDA)
                .where(UNIDAD_MEDIDA.IDMEDIDA.equal(id))
                .fetch();
        for (Record r: result){
            dcmUnidad.addElement(new Unidad(
                    r.getValue(UNIDAD_MEDIDA.IDUNIDAD),
                    r.getValue(UNIDAD_MEDIDA.DETALLE),
                    r.getValue(UNIDAD_MEDIDA.EQUIVALENCIA)
            ));
        }
    }
    
    private void cargarCategoria(){
        dcmCategoria.removeAllElements();
        Result<Record> result = create.select()
                .from(CATEGORIA_INVENTARIO)
                .orderBy(CATEGORIA_INVENTARIO.NOMBRE.asc())
                .fetch();
        if(result.size()>0){
            for (Record r : result) {
                dcmCategoria.addElement(new CategoriaInventario(r.getValue(CATEGORIA_INVENTARIO.IDCATEGORIA)
                        ,r.getValue(CATEGORIA_INVENTARIO.NOMBRE)
                        ,r.getValue(CATEGORIA_INVENTARIO.DESCRIPCION)));
            }
        }else{
            JOptionPane.showMessageDialog(null,"Se necesitan categorias");
            hayCat = false;
        }        
    }
    
    private void cargarForm(int idinventario){
        Record r = create.select()
                .from(INVENTARIO)
                .where(INVENTARIO.IDINVENTARIO.equal(idinventario))
                .fetchOne();
        txtNombre.setText(r.getValue(INVENTARIO.NOMBRE));
        txtDescripcion.setText(r.getValue(INVENTARIO.DESCRIPCION));
        this.CODIGOP = r.getValue(INVENTARIO.CODIGO);        
        for(int i=0; i<cbxCategoria.getItemCount(); i++){
            cbxCategoria.setSelectedIndex(i);
            CategoriaInventario cat = (CategoriaInventario) cbxCategoria.getSelectedItem();
            if(cat.getId() == r.getValue(INVENTARIO.IDCATEGORIA)){
                break;
            }            
        }
        boolean encuentra = false;
        for(int i=0; i<cbxUnidad.getItemCount(); i++){
           cbxUnidad.setSelectedIndex(i);
           for(int j=0; j<cbxMedida.getItemCount(); j++){
               cbxMedida.setSelectedIndex(j);
               Unidad un = (Unidad) cbxMedida.getSelectedItem();
               if(un.getId()==r.getValue(INVENTARIO.IDUNIDAD)){
                   encuentra =true;
                   break;
               }
           }
           if(encuentra){
               break;
           }
        }
        spPrecio.setValue(r.getValue(INVENTARIO.PRECIOCOMPRA).doubleValue());
        spMin.setValue(r.getValue(INVENTARIO.MINIMO));
        spMax.setValue(r.getValue(INVENTARIO.MAXIMO));
        spExist.setValue(r.getValue(INVENTARIO.EXISTENCIA));
        lblCodigo.setText(CODIGOP);
    }
    
    private int guardarCompra(){
        int idfactura = 0;
        Date date = new Date();
        java.sql.Date fecha = new java.sql.Date (date.getTime());
        double preciocompra = (double) spPrecio.getValue();
        double existencia = (double) spExist.getValue();
        double costo = preciocompra*existencia;
        BigDecimal total = BigDecimal.valueOf(costo);
        try{
            idfactura = create.insertInto(COMPRAS)
                .set(COMPRAS.FECHA,fecha)
                .set(COMPRAS.TIPODOCUMENTO,"INVENTARIO INICIAL")
                .set(COMPRAS.NUMERODOCUMENTO,"INVENTARIO INICIAL")
                .set(COMPRAS.TOTAL,total)
                .returning(COMPRAS.IDCOMPRA)
                .fetchOne().getValue(COMPRAS.IDCOMPRA);
        }catch(Exception e){
            System.out.println(e);
        }
        return idfactura;
    }
    
    private void guardarDetalleCompra(int idfactura,int idinventario){
        if(padre.equals("inventarios")){
            double preciocompra = (double) spPrecio.getValue();
            double cantidad = (double) spExist.getValue();
            BigDecimal precio = BigDecimal.valueOf(preciocompra);
            create.insertInto(DETALLE_COMPRA)
                    .set(DETALLE_COMPRA.IDINVENTARIO,this.getIdInventario())
                    .set(DETALLE_COMPRA.IDCOMPRA,idfactura)
                    .set(DETALLE_COMPRA.CANTIDAD,cantidad)
                    .set(DETALLE_COMPRA.PRECIOCOMPRA,precio)
                    .execute();
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
    
    public boolean isComplete(){
        return !(txtNombre.getText()==null || txtNombre.getText().equals(""));
    }

    private void nuevoMaterial() {
        CategoriaInventario categoria = (CategoriaInventario) cbxCategoria.getSelectedItem();
        Unidad unidad = (Unidad) cbxMedida.getSelectedItem();   
        BigDecimal precio = BigDecimal.valueOf((double) spPrecio.getValue());
            int idmaterial;
            idmaterial = create.insertInto(INVENTARIO)
                    .set(INVENTARIO.CODIGO,lblCodigo.getText())
                    .set(INVENTARIO.NOMBRE,txtNombre.getText())
                    .set(INVENTARIO.DESCRIPCION, txtDescripcion.getText())
                    .set(INVENTARIO.IDCATEGORIA, categoria.getId())
                    .set(INVENTARIO.IDUNIDAD, unidad.getId())
                    .set(INVENTARIO.PRECIOCOMPRA, precio)
                    .set(INVENTARIO.MINIMO, (double) spMin.getValue())
                    .set(INVENTARIO.MAXIMO, (double) spMax.getValue())
                    .set(INVENTARIO.EXISTENCIA, (double) spExist.getValue())
                    .returning(INVENTARIO.IDINVENTARIO)
                    .fetchOne().getValue(INVENTARIO.IDINVENTARIO);
            this.setIdInventario(idmaterial);
            int idfactura = guardarCompra();
            guardarDetalleCompra(idfactura,idmaterial);
    }

    private void editarMaterial() {
        CategoriaInventario categoria = (CategoriaInventario) cbxCategoria.getSelectedItem();
        Unidad unidad = (Unidad) cbxMedida.getSelectedItem(); 
        BigDecimal precio = new BigDecimal((double) spPrecio.getValue());
        create.update(INVENTARIO)
                    .set(INVENTARIO.CODIGO,lblCodigo.getText())
                    .set(INVENTARIO.NOMBRE,txtNombre.getText())
                    .set(INVENTARIO.DESCRIPCION, txtDescripcion.getText())
                    .set(INVENTARIO.IDCATEGORIA, categoria.getId())
                    .set(INVENTARIO.IDUNIDAD, unidad.getId())
                    .set(INVENTARIO.PRECIOCOMPRA, precio)
                    .set(INVENTARIO.MINIMO, (double) spMin.getValue())
                    .set(INVENTARIO.MAXIMO, (double) spMax.getValue())
                    .set(INVENTARIO.EXISTENCIA, (double) spExist.getValue())
                    .where(INVENTARIO.CODIGO.equal(CODIGOP))
                    .execute();
    }

    /**
     * @return the idInventario
     */
    public int getIdInventario() {
        return idInventario;
    }

    /**
     * @param idInventario the idInventario to set
     */
    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }
    
}
