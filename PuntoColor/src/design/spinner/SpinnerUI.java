
package design.spinner;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicSpinnerUI;

/* @author PereiraHP */
public class SpinnerUI extends BasicSpinnerUI{
    
    private Color base;
    private Color fondo;
    
    public SpinnerUI(Color fondo, Color base){
        this.fondo = fondo;
        this.base = base;
    }
    
    @Override
    protected Component createNextButton() {
        Component c = createArrowButton(SwingConstants.EAST);
        c.setName("Spinner.nextButton");
        installNextButtonListeners(c);
        return c;
    }
    
    @Override
    protected Component createPreviousButton() {
        Component c = createArrowButton(SwingConstants.WEST);
        c.setName("Spinner.previousButton");
        installPreviousButtonListeners(c);
        return c;
    }
    
    private Component createArrowButton(int direccion) { 
        JButton b = new BasicArrowButton(direccion,
                base, //Color de fondo
                Color.WHITE,//sombra
                Color.WHITE,//darkShadow
                Color.WHITE //highlight
        );
        Border buttonBorder = UIManager.getBorder("Spinner.arrowButtonBorder");
        if (buttonBorder instanceof UIResource) {
            b.setBorder(new CompoundBorder(buttonBorder, null));
        } else {
            b.setBorder(buttonBorder);
        }
        b.setInheritsPopupMenu(true);
        b.setBorder(BorderFactory.createLineBorder(base,2));
        b.setContentAreaFilled(false); 
        return b;
    }
   
    @Override
    protected JComponent createEditor() {
        JComponent editor = spinner.getEditor();
        editor.setName("Spinner.editor");
        updateEditorAlignment(editor);
        return editor;
    }
    
    private void updateEditorAlignment(JComponent editor) {
        if (editor instanceof JSpinner.DefaultEditor) {
            // if editor alignment isn't set in LAF, we get 0 (CENTER) here
            int alignment = UIManager.getInt("Spinner.editorAlignment");
            JTextField text = ((JSpinner.DefaultEditor)editor).getTextField();
            text.setBackground(fondo);
            text.setHorizontalAlignment(alignment);
        }
    }
     
    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        c.removeAll();
        c.setLayout(new BorderLayout() {
            @Override
            public void addLayoutComponent(Component comp, Object constraints) {
                if (constraints.equals("Editor")) {
                    constraints = CENTER;
                }
                //comp.setBackground(fondo);
                super.addLayoutComponent(comp, constraints);
            }
        });
        c.setBorder(new javax.swing.border.LineBorder(base, 2, true));
        c.add(createNextButton(), BorderLayout.EAST);
        c.add(createPreviousButton(), BorderLayout.WEST);
        c.add(createEditor(), BorderLayout.CENTER);
    }
    
}
