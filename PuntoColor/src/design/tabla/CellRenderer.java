
package design.tabla;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/* @author jlpereira */
public class CellRenderer extends DefaultTableCellRenderer {
    private String tipo="text";
    private final Font courier = new Font( "Courier New",Font.PLAIN ,12 );
    private final Font normal = new Font( "Arial",Font.PLAIN ,12 );
    private final Font bold = new Font( "Arial",Font.BOLD ,12 );
    private final JLabel label = new JLabel();
    private final Color fondo;
    
    public CellRenderer(String tipo, Color fondo ){
        this.tipo = tipo;
        this.fondo = fondo;
    }
    
    @Override
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column ){ 
        if (selected) {                
            this.setBackground( fondo );                        
        }else{
            this.setBackground(Color.WHITE);
        }
        
        if( tipo.equals("hour")){
            this.setHorizontalAlignment( JLabel.CENTER );
            if(value==null){
                this.setText( "" );
            }else{  
                this.setText( "" + value );
            }
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            this.setFont(normal);            
            return this;
        }
                
        if( tipo.equals("text")){
            this.setHorizontalAlignment( JLabel.LEFT );
            this.setText( "" + value );
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            this.setFont(normal);            
            return this;
        }
        
        if( tipo.equals("text center")){
            this.setHorizontalAlignment( JLabel.CENTER );  
            this.setText( "" + value );
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            this.setFont(normal);            
            return this;
        } 
        
        if( tipo.equals("num")){           
            this.setHorizontalAlignment( JLabel.CENTER );
            this.setText( ""+ value );            
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            this.setFont(bold);            
            return this;   
        }
        
        if( tipo.equals("num1")){           
            this.setHorizontalAlignment( JLabel.CENTER );
            this.setText( ""+ value );            
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,100,155) );            
            this.setFont(bold);            
            return this;   
        }
        
        if( tipo.equals("num2")){           
            this.setHorizontalAlignment( JLabel.CENTER );
            this.setText( ""+ value );            
            this.setForeground( (selected)?new Color(255,255,255):new Color(32,117,32) );            
            this.setFont(bold);            
            return this;   
        }
        
        if( tipo.equals("num3")){           
            this.setHorizontalAlignment( JLabel.CENTER );
            this.setText( ""+ value );            
            this.setForeground( (selected)?new Color(255,255,255):new Color(155,0,0) );            
            this.setFont(bold);            
            return this;   
        }
        
        if( tipo.equals("num4")){           
            this.setHorizontalAlignment( JLabel.CENTER );
            this.setText( ""+ value );            
            this.setForeground( (selected)?new Color(255,255,255):new Color(205,100,0) );            
            this.setFont(bold);            
            return this;   
        }
        
        if( tipo.equals("precio")){           
            this.setHorizontalAlignment( JLabel.RIGHT );
            this.setText( "" + value );            
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            this.setFont(bold);            
            return this;   
        }
        
        if( tipo.equals("booleano")){
            this.setHorizontalAlignment( JLabel.CENTER );
             this.setFont(bold);              
            if(String.valueOf(value).equals("true")){
                this.setForeground( (selected)?new Color(255,255,255):new Color(33, 97, 26));
                this.setText("APLICADO");
            }else{
                this.setForeground( (selected)?new Color(255,255,255):new Color(254, 69, 78) );
                this.setText("NO APLICADO");
            }          
            return this;   
        }
        
        if( tipo.equals("caja")){
            this.setHorizontalAlignment( JLabel.CENTER );
             this.setFont(bold);              
            if(String.valueOf(value).equals("true")){
                this.setForeground( (selected)?new Color(255,255,255):new Color(33, 97, 26));
                this.setText("ACTIVA");
            }else{
                this.setForeground( (selected)?new Color(255,255,255):new Color(254, 69, 78) );
                this.setText("NO ACTIVA");
            }          
            return this;   
        }
        
        if( tipo.equals("pago")){
            this.setHorizontalAlignment( JLabel.CENTER );
             this.setFont(bold);              
            if(String.valueOf(value).equals("true")){
                this.setForeground( (selected)?new Color(255,255,255):new Color(33, 97, 26));
                this.setText("CANCELADA");
            }else{
                this.setForeground( (selected)?new Color(255,255,255):new Color(254, 69, 78) );
                this.setText("PENDIENTE");
            }          
            return this;   
        }
        
        if( tipo.equals("pedido")){
            this.setHorizontalAlignment( JLabel.CENTER );
            this.setFont(bold);
            switch(String.valueOf(value)){
                case "ESPERA":                  
                    this.setForeground( (selected)?new Color(255,255,255):new Color(224, 0, 35)); 
                    this.setText(""+value);
                    break;
                case "DISEÑO":                  
                    this.setForeground( (selected)?new Color(255,255,255):new Color(237, 116, 0)); 
                    this.setText(""+value);
                    break;
                case "PRODUCCION":                  
                    this.setForeground( (selected)?new Color(255,255,255):new Color(237, 200, 0)); 
                    this.setText(""+value);
                    break;
                case "FINALIZADO":                  
                    this.setForeground( (selected)?new Color(255,255,255):new Color(0, 181, 32)); 
                    this.setText(""+value);
                    break;
                default:
                    this.setForeground( (selected)?new Color(255,255,255):new Color(73, 190, 240)); 
                    this.setText(""+value);
                    break;
            }
            return this;   
        }
        
        return this;
    }
    
}
