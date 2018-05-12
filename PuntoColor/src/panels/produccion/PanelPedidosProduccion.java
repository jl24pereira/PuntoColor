package panels.produccion;

import clases.Fechero;
import com.mrlonee.swing.animation.AnimatedPanel;
import static db.clases.Tables.DETALLE_PEDIDO;
import static db.clases.Tables.INVENTARIO;
import static db.clases.Tables.PEDIDO;
import static db.clases.Tables.PRODUCTO;
import static db.clases.Tables.RECETA;
import static db.clases.Tables.V_MEDIDAS;
import static db.clases.Tables.V_PEDIDOS;
import design.button.ButtonUI;
import design.combobox.ComboUI;
import design.lista.Proveedor;
import design.tabbedpane.TabbedPanelUI;
import design.tabla.CellRenderer;
import design.tabla.HeaderCellRenderer;
import design.textfield.TextFieldUI;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.SelectQuery;
import org.jooq.impl.DSL;
import static puntocolor.Principal.database;
import javax.swing.table.JTableHeader;
import static puntocolor.Principal.cBtnNormal;
import static puntocolor.Principal.cBtnOver;
import static puntocolor.Principal.cBtnPress;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorTexto;
import static puntocolor.Principal.colorUI;

/*@author Jose Luis */
public class PanelPedidosProduccion extends AnimatedPanel implements Runnable {

    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    DefaultListModel<Proveedor> modelo = new DefaultListModel<>();

    DefaultTableModel dtmPedidos;
    DefaultTableModel dtmMisPedidos;

    boolean corriendo = false;
    boolean iniciar = true;
    Thread hilo;

    public PanelPedidosProduccion() {
        this.setAnimationType(AnimatedPanel.AnimationType.SlideAnimationFromTop);
        initComponents();
        dtmPedidos = (DefaultTableModel) tPedidos.getModel();
        dibujarTablas();
        cargarTablaPedidos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        popPedidos = new javax.swing.JPopupMenu();
        itemFinalizar = new javax.swing.JMenuItem();
        pMain = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        cbxFiltroCategoria = new javax.swing.JComboBox<>();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        txtFiltroCategoria = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btnActualizar = new javax.swing.JButton();
        pTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pTabs = new javax.swing.JPanel();
        tpInventario = new javax.swing.JTabbedPane();
        pGestion = new javax.swing.JPanel();
        pTabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tPedidos = new javax.swing.JTable();

        itemFinalizar.setText("Finalizar Producción");
        itemFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFinalizarActionPerformed(evt);
            }
        });
        popPedidos.add(itemFinalizar);

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                formAncestorRemoved(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        pMain.setBackground(new java.awt.Color(102, 102, 102));
        pMain.setOpaque(false);
        pMain.setLayout(new java.awt.GridBagLayout());

        toolBarTabla1.setBackground(colorUI);
        toolBarTabla1.setBorder(null);
        toolBarTabla1.setFloatable(false);
        toolBarTabla1.setRollover(true);
        toolBarTabla1.setMaximumSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.setMinimumSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.setPreferredSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.add(jSeparator9);

        cbxFiltroCategoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbxFiltroCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar todo", "Categoria", "Codigo Categoria" }));
        cbxFiltroCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(colorUI, 2));
        cbxFiltroCategoria.setMaximumSize(new java.awt.Dimension(150, 40));
        cbxFiltroCategoria.setMinimumSize(new java.awt.Dimension(150, 40));
        cbxFiltroCategoria.setPreferredSize(new java.awt.Dimension(150, 40));
        cbxFiltroCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxFiltroCategoriaItemStateChanged(evt);
            }
        });
        toolBarTabla1.add(cbxFiltroCategoria);
        cbxFiltroCategoria.setUI(new ComboUI(colorBG,cBtnNormal));
        toolBarTabla1.add(jSeparator7);

        txtFiltroCategoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtFiltroCategoria.setMaximumSize(new java.awt.Dimension(150, 40));
        txtFiltroCategoria.setMinimumSize(new java.awt.Dimension(150, 40));
        txtFiltroCategoria.setPreferredSize(new java.awt.Dimension(150, 40));
        txtFiltroCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroCategoriaKeyReleased(evt);
            }
        });
        toolBarTabla1.add(txtFiltroCategoria);
        txtFiltroCategoria.setUI(new TextFieldUI(
            "Buscar...", colorUI, cBtnNormal, colorBG
        ));
        toolBarTabla1.add(jSeparator8);

        btnActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnActualizar.setForeground(colorTexto);
        btnActualizar.setText("Actualizar Pedidos");
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.setFocusable(false);
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        toolBarTabla1.add(btnActualizar);
        btnActualizar.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pMain.add(toolBarTabla1, gridBagConstraints);

        pTitulo.setOpaque(false);
        pTitulo.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(colorUI);
        jLabel1.setText("Pedidos en Producción");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        pTitulo.add(jLabel1, gridBagConstraints);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/64/wizard64.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pTitulo.add(jLabel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pMain.add(pTitulo, gridBagConstraints);

        pTabs.setOpaque(false);
        pTabs.setLayout(new java.awt.GridBagLayout());

        tpInventario.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tpInventario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tpInventario.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tpInventarioStateChanged(evt);
            }
        });

        pGestion.setBackground(colorBG);
        pGestion.setForeground(new java.awt.Color(153, 153, 0));
        pGestion.setLayout(new java.awt.GridBagLayout());

        pTabla.setMinimumSize(new java.awt.Dimension(300, 100));
        pTabla.setOpaque(false);
        pTabla.setPreferredSize(new java.awt.Dimension(450, 100));
        pTabla.setLayout(new java.awt.GridBagLayout());

        tPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "No.", "Fecha", "Detalle", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tPedidos.setComponentPopupMenu(popPedidos);
        tPedidos.setRowHeight(30);
        tPedidos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tPedidos.getTableHeader().setReorderingAllowed(false);
        tPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tPedidosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tPedidos);
        if (tPedidos.getColumnModel().getColumnCount() > 0) {
            tPedidos.getColumnModel().getColumn(0).setMinWidth(0);
            tPedidos.getColumnModel().getColumn(0).setPreferredWidth(0);
            tPedidos.getColumnModel().getColumn(0).setMaxWidth(0);
            tPedidos.getColumnModel().getColumn(1).setMinWidth(100);
            tPedidos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tPedidos.getColumnModel().getColumn(1).setMaxWidth(100);
            tPedidos.getColumnModel().getColumn(2).setMinWidth(100);
            tPedidos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tPedidos.getColumnModel().getColumn(2).setMaxWidth(100);
            tPedidos.getColumnModel().getColumn(4).setMinWidth(150);
            tPedidos.getColumnModel().getColumn(4).setPreferredWidth(150);
            tPedidos.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pTabla.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pGestion.add(pTabla, gridBagConstraints);

        tpInventario.addTab("<html><body align=\"center\">Gestión de<br>Pedidos</body></html>", pGestion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pTabs.add(tpInventario, gridBagConstraints);
        tpInventario.setUI(new TabbedPanelUI(colorUI,colorBG));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pMain.add(pTabs, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(pMain, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxFiltroCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroCategoriaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFiltroCategoriaItemStateChanged

    private void txtFiltroCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroCategoriaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroCategoriaKeyReleased

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        cargarTablaPedidos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void itemFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFinalizarActionPerformed
        // TODO add your handling code here:
        int idpedido = (int) tPedidos.getValueAt(tPedidos.getSelectedRow(), 0);
        create.update(PEDIDO)
                .set(PEDIDO.ESTADO, "FINALIZADO")
                .where(PEDIDO.IDPEDIDO.equal(idpedido))
                .execute();
        descontarInventario();
        cargarTablaPedidos();
    }//GEN-LAST:event_itemFinalizarActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        // TODO add your handling code here:
        iniciarBusqueda();
    }//GEN-LAST:event_formAncestorAdded

    private void formAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorRemoved
        // TODO add your handling code here:
        finalizarBusqueda();
    }//GEN-LAST:event_formAncestorRemoved

    private void tpInventarioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tpInventarioStateChanged
        // TODO add your handling code here:
        if (tpInventario.getSelectedIndex() == 0) {

            //cargarDialogMaterial();
        } else {
            //cargarDialogCategoria();
        }
    }//GEN-LAST:event_tpInventarioStateChanged

    private void tPedidosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPedidosMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int currentRow = tPedidos.rowAtPoint(point);
        tPedidos.setRowSelectionInterval(currentRow, currentRow);
        String estado = (String) tPedidos.getValueAt(tPedidos.getSelectedRow(), 4);
    }//GEN-LAST:event_tPedidosMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JComboBox<String> cbxFiltroCategoria;
    private javax.swing.JMenuItem itemFinalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JPanel pGestion;
    private javax.swing.JPanel pMain;
    private javax.swing.JPanel pTabla;
    private javax.swing.JPanel pTabs;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JPopupMenu popPedidos;
    private javax.swing.JTable tPedidos;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTabbedPane tpInventario;
    private javax.swing.JTextField txtFiltroCategoria;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaPedidos() {
        for (int i = 0; i < tPedidos.getRowCount(); i++) {
            dtmPedidos.removeRow(i);
            i -= 1;
        }
        SelectQuery<Record> query = create.selectQuery();
        query.addFrom(V_PEDIDOS);
        query.addConditions(V_PEDIDOS.ESTADO.equal("PRODUCCION"));
        query.addOrderBy(V_PEDIDOS.FECHA.asc());
        query.addOrderBy(V_PEDIDOS.NUMERO.asc());
        Result<Record> result = query.fetch();
        for (Record r : result) {
            Object[] row = {
                r.getValue(V_PEDIDOS.IDPEDIDO),
                r.getValue(V_PEDIDOS.NUMERO),
                Fechero.baseToReal(r.getValue(V_PEDIDOS.FECHA)),
                r.getValue(V_PEDIDOS.COMENTARIOS),
                r.getValue(V_PEDIDOS.ESTADO)
            };
            dtmPedidos.addRow(row);
        }
        if (tPedidos.getRowCount() > 0) {
            tPedidos.changeSelection(0, 1, false, false);
        }
    }

    private void dibujarTablas() {
        tPedidos.setGridColor(colorUI);
        JTableHeader jtableHeader = tPedidos.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tPedidos.setTableHeader(jtableHeader);

        tPedidos.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text center", new Color(113, 205, 245)));
        tPedidos.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text center", new Color(113, 205, 245)));
        tPedidos.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("text", new Color(113, 205, 245)));
        tPedidos.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("pedido", new Color(113, 205, 245)));
        tPedidos.repaint();
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Busqueda Disenios");
        System.out.println("Inicia Hilo: " + Thread.currentThread().getName());
        while (corriendo) {
            try {
                Thread.sleep(1000 * 60 * 3);
                if (!corriendo) {
                    break;
                }
                System.out.println("Hilo: " + Thread.currentThread().getName() + " Buscando...");
                cargarTablaPedidos();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("finaliza Hilo: " + Thread.currentThread().getName());
    }

    private void iniciarBusqueda() {
        if (!corriendo) {
            corriendo = true;
            iniciar = true;
            arrancarBusqueda();
        }
    }

    private void finalizarBusqueda() {
        corriendo = false;
        iniciar = false;
        hilo.interrupt();
    }

    private void arrancarBusqueda() {
        if (iniciar) {
            hilo = new Thread(this);
            hilo.start();
        }
    }

    private void descontarInventario() {
        int contadorMinimos = 0;
        ArrayList<String> enMinimos = new ArrayList<String>();
        int idpedido = (int) tPedidos.getValueAt(tPedidos.getSelectedRow(), 0);
        int productoDescontado = 0;
        SelectQuery<Record> query = create.selectQuery();
        query.addFrom(DETALLE_PEDIDO);
        query.addConditions(DETALLE_PEDIDO.IDPEDIDO.equal(idpedido));
        Result<Record> resPedido = query.fetch();
        System.out.println("El pedido es: " + idpedido);
        for (Record recPedido : resPedido) {
            SelectQuery<Record> queryProducto = create.selectQuery();
            queryProducto.addFrom(PRODUCTO);
            queryProducto.addConditions(PRODUCTO.IDPRODUCTO.equal(recPedido.getValue(DETALLE_PEDIDO.IDPRODUCTO)));
            Result<Record> resProducto = queryProducto.fetch();
            System.out.println("EL PEDIDO TIENE: " + recPedido.getValue(DETALLE_PEDIDO.IDPRODUCTO));
            for (Record recProducto : resProducto) {
                System.out.println("DESCONDO MATERIALES DE PRODUCCION");
                /*descontar los materiales que van en diseño*/
                SelectQuery<Record> queryReceta = create.selectQuery();
                queryReceta.addFrom(RECETA);
                queryReceta.addConditions(RECETA.IDPRODUCTO.equal(recProducto.getValue(PRODUCTO.IDPRODUCTO))
                        .and(RECETA.DESCONTAREN.equal("PRODUCCION")));
                Result<Record> resReceta = queryReceta.fetch();
                for (Record recReceta : resReceta) {
                    System.out.println("MATERIAL ES: " + recReceta.getValue(RECETA.IDINVENTARIO));
                    System.out.println("Cantidad de producto = " + recPedido.getValue(DETALLE_PEDIDO.CANTIDAD));
                    SelectQuery<Record> queryMaterial;
                    System.out.println("Descuento de receta es: " + recReceta.getValue(RECETA.DESCARGO));
                    System.out.println("UN. MEDIDA EN DESCUENTO ES: " + recReceta.getValue(RECETA.IDUNIDAD));
                    double descuento = transformarMaterial(recReceta.getValue(RECETA.IDINVENTARIO), recReceta.getValue(RECETA.IDUNIDAD), recReceta.getValue(RECETA.DESCARGO));
                    Record material = create.select()
                            .from(INVENTARIO)
                            .where(INVENTARIO.IDINVENTARIO.equal(recReceta.getValue(RECETA.IDINVENTARIO)))
                            .fetchOne();
                    double enInventario = material.getValue(INVENTARIO.EXISTENCIA);
                    double minimos = material.getValue(INVENTARIO.MINIMO);
                    System.out.println("EN INVENTARIO TENGO: " + enInventario);
                    double descuentoInventario = 0;
                    if (recPedido.getValue(DETALLE_PEDIDO.ESPECIAL)) {
                        System.out.println("QUIERO DESCONTAR: " + (descuento * recPedido.getValue(DETALLE_PEDIDO.CANTIDAD) * (recPedido.getValue(DETALLE_PEDIDO.ANCHO)
                                * recPedido.getValue(DETALLE_PEDIDO.LARGO))));
                        descuentoInventario = (descuento * recPedido.getValue(DETALLE_PEDIDO.CANTIDAD) * (recPedido.getValue(DETALLE_PEDIDO.ANCHO)
                                * recPedido.getValue(DETALLE_PEDIDO.LARGO)));
                    } else {
                        System.out.println("QUIERO DESCONTAR: " + (descuento * recPedido.getValue(DETALLE_PEDIDO.CANTIDAD)));
                        descuentoInventario = (descuento * recPedido.getValue(DETALLE_PEDIDO.CANTIDAD));
                    }
                    System.out.println("QUEDARA: " + (enInventario - (descuento * recPedido.getValue(DETALLE_PEDIDO.CANTIDAD))));
                    //double descuentoInventario = (descuento*recPedido.getValue(DETALLE_PEDIDO.CANTIDAD));
                    double existencia = enInventario - descuentoInventario;
                    create.update(INVENTARIO)
                            .set(INVENTARIO.EXISTENCIA, existencia)
                            .where(INVENTARIO.IDINVENTARIO.equal(recReceta.getValue(RECETA.IDINVENTARIO)))
                            .execute();
                    if (existencia < minimos) {
                        enMinimos.add(material.getValue(INVENTARIO.NOMBRE));
                        contadorMinimos++;
                    }
                }
            }
        }
        /*if(!enMinimos.isEmpty()){
            JList list = new JList(enMinimos.toArray());
            JPanel panelx = new JPanel();
            panelx.add(list);
            JOptionPane.showMessageDialog(null, panelx);
        }*/
    }

    private double transformarMaterial(int idmaterial, int unMedidaReceta, double descargoReceta) {

        Record r = create
                .select(INVENTARIO.IDUNIDAD)
                .from(INVENTARIO)
                .where(INVENTARIO.IDINVENTARIO.equal(idmaterial))
                .fetchOne();

        int unMedidaMaterial = r.getValue(INVENTARIO.IDUNIDAD);

        Record medidasMaterial = create
                .select()
                .from(V_MEDIDAS)
                .where(V_MEDIDAS.IDUNIDAD.equal(unMedidaMaterial))
                .fetchOne();

        double eqHijoMaterial = medidasMaterial.getValue(V_MEDIDAS.EQUIVALENCIA);
        double eqPadreMaterial = medidasMaterial.getValue(V_MEDIDAS.EQUIVALENCIAPADRE);
        int idHijoMaterial = medidasMaterial.getValue(V_MEDIDAS.IDUNIDAD);
        int idPadreMaterial = medidasMaterial.getValue(V_MEDIDAS.UNIDADPADRE);

        Record medidasReceta = create
                .select()
                .from(V_MEDIDAS)
                .where(V_MEDIDAS.IDUNIDAD.equal(unMedidaReceta))
                .fetchOne();

        double eqHijoReceta = medidasReceta.getValue(V_MEDIDAS.EQUIVALENCIA);
        double eqPadreReceta = medidasReceta.getValue(V_MEDIDAS.EQUIVALENCIAPADRE);
        int idHijoReceta = medidasReceta.getValue(V_MEDIDAS.IDUNIDAD);
        int idPadreReceta = medidasReceta.getValue(V_MEDIDAS.UNIDADPADRE);

        if (unMedidaMaterial == unMedidaReceta) {
            System.out.println("DESCUENTA LO MISMO: " + descargoReceta);
            return descargoReceta;
        } else {
            if (idPadreMaterial == idHijoReceta) {
                return eqHijoMaterial;
            } else if (idPadreReceta == idHijoMaterial) {
                return eqHijoReceta;
            } else {
                return (descargoReceta * eqHijoReceta) / eqHijoMaterial;
            }
        }
    }
}
