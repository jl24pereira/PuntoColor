
package design.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;

/* @author Jose Luis */

public class ButtonUI extends BasicButtonUI implements MouseListener{
    
    private Color     hoverColor   = new Color(240, 240, 240);
    private Color     normalColor  = new Color(240, 240, 240);
    private Color     pressedColor = new Color(240, 240, 240);
    private Color     btnFontColor;
    private ImageIcon normalIcon;
    private ImageIcon hoverIcon;
    private ImageIcon pressedIcon;
    private Font      btnFont;
    
    protected Border m_borderRaised = UIManager.getBorder("Button.border");

    public ButtonUI() {
        super();
    }

    public ButtonUI(Color normalColor, Color hoverColor, Color pressedColor) {
        this(normalColor, hoverColor, pressedColor, null, Color.BLACK);
    }
    
    public ButtonUI(Color normalColor, Color hoverColor, Color pressedColor, Font btnFont, Color btnFontColor) {
        this.normalColor = normalColor;
        this.hoverColor = hoverColor;
        this.pressedColor = pressedColor;
        this.btnFont = btnFont;
        this.btnFontColor = btnFontColor;
    }
    
    public ButtonUI(ImageIcon normalIcon, ImageIcon hoverIcon, ImageIcon pressedIcon) {
        this(normalIcon, hoverIcon, pressedIcon, null, Color.BLACK);
    }
    
    public ButtonUI(ImageIcon normalIcon, ImageIcon hoverIcon, ImageIcon pressedIcon, Font btnFont, Color btnFontColor) {
        this.normalIcon = normalIcon;
        this.hoverIcon = hoverIcon;
        this.pressedIcon = pressedIcon;
        this.btnFont = btnFont;
        this.btnFontColor = btnFontColor;
    }
    
    public ButtonUI(Color normalColor, Color hoverColor, Color pressedColor,ImageIcon normalIcon){
        this.normalColor = normalColor;
        this.hoverColor = hoverColor;
        this.pressedColor = pressedColor;
        this.normalIcon = normalIcon;
    }
    
    public void paint(Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        Dimension d = b.getSize();
        g.setFont(c.getFont());
        FontMetrics fm = g.getFontMetrics();
        g.setColor(b.getForeground());
        String caption = b.getText();
        int x = (d.width - fm.stringWidth(caption)) / 2;
        int y = (d.height + fm.getAscent()) / 2;
        g.drawString(caption, x, y);

  }

  public Dimension getPreferredSize(JComponent c) {
      Dimension d = super.getPreferredSize(c);
      if (m_borderRaised != null) {
          Insets ins = m_borderRaised.getBorderInsets(c);
          d.setSize(d.width + ins.left + ins.right, d.height + ins.top
          + ins.bottom);
      }
      return d;
  }
    
    @Override
    public void installUI(JComponent comp) {
        super.installUI(comp);
        comp.addMouseListener(this);
    }

    @Override
    public void uninstallUI(JComponent comp) {
        super.uninstallUI(comp); 
        comp.removeMouseListener(this);
    }

    @Override
    protected void installDefaults(AbstractButton btn) {
        super.installDefaults(btn);
        btn.setBorder(null);
        //btn.setIcon(this.normalIcon);
        btn.setBackground(this.normalColor);
        //btn.setForeground(this.btnFontColor);
        //btn.setFont(this.btnFont);
        //btn.setHorizontalTextPosition(SwingConstants.CENTER);
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
        changeButtonStyle((JButton) e.getComponent(), this.pressedColor, this.pressedIcon);
    }
    
    @Override
    public void mousePressed(MouseEvent e){
        changeButtonStyle((JButton) e.getComponent(), this.pressedColor, this.pressedIcon);
    }
    
    @Override
    public void mouseReleased(MouseEvent e){
        changeButtonStyle((JButton)e.getComponent(), this.normalColor, this.normalIcon);
    }
    
    @Override
    public void mouseEntered(MouseEvent e){
        changeButtonStyle((JButton) e.getComponent(), this.hoverColor, this.hoverIcon);
    }
    
    @Override
    public void mouseExited(MouseEvent e){
        changeButtonStyle((JButton)e.getComponent(), this.normalColor, this.normalIcon);
    }
    
    private void changeButtonStyle(JButton btn, Color color, ImageIcon icon){
        btn.setBackground(color);
        
        //btn.setIcon(icon);
    }
}


