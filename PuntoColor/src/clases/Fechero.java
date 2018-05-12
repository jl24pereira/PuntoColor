
package clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author JL Desk */
public class Fechero {
    
    public static String baseToReal(java.sql.Date fecha){
        SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date = new java.util.Date(fecha.getTime());
        return d.format(date);
    }

    public static java.sql.Timestamp realToBase(java.util.Date fecha){
        return new java.sql.Timestamp (fecha.getTime());
    }
    
    public static Calendar DateToCalendar(java.util.Date date){ 
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
    
    public static String dateToString(java.util.Date fecha){
        SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
         return d.format(fecha);
    }
    
    public static java.util.Date stringToDate(String date){
        SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date fecha = null;
        try {
            fecha = d.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Fechero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fecha;
    }
}
