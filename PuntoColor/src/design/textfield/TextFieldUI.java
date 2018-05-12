package design.textfield;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JComponent;

import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.text.JTextComponent;

public class TextFieldUI extends BasicTextFieldUI implements FocusListener {
    
    private String hint = "";
    private Color  hintColor = Color.WHITE;
    private Color borderColor = Color.BLACK;
    private Color fondo = Color.WHITE;
    
    public TextFieldUI(){
        super();
    }
    
    public TextFieldUI(Color borderColor, Color fondo){
        this.borderColor = borderColor;
        this.fondo = fondo;
    }
    
    public TextFieldUI(String hint, Color hintColor, Color borderColor) {
        this.hint = hint;
        this.hintColor = hintColor;
        this.borderColor = borderColor;
    } 
    
    public TextFieldUI(String hint, Color hintColor, Color borderColor, Color fondo) {
        this.hint = hint;
        this.hintColor = hintColor;
        this.borderColor = borderColor;
        this.fondo = fondo;
    } 
    
    private void repaint() {
        if (getComponent() != null) {            
            getComponent().repaint();
        }
    }
    
    @Override
    protected void paintSafely(Graphics g) {
        super.paintSafely(g);
        JTextComponent component = getComponent();
        if (component.getText().length() == 0 && !component.hasFocus()) {
            g.setColor(borderColor);
            int padding = (component.getHeight() - component.getFont().getSize()) / 2;
            int inset = 3;
            g.drawString(hint, inset, component.getHeight() - padding - inset);
        }
        component.setBackground(fondo);
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        repaint();
    }
    
    @Override
    public void focusLost(FocusEvent e) {
        repaint();
    }
    
    @Override
    public void installListeners() {
        super.installListeners();
        getComponent().addFocusListener(this);
        //getComponent().setMargin(new java.awt.Insets(2, 25, 2, 2));
        getComponent().setBorder(new javax.swing.border.LineBorder(borderColor, 2, true));
    }
    
    @Override
    public void uninstallListeners() {
        super.uninstallListeners();
        getComponent().removeFocusListener(this);
    }
    
    
}
