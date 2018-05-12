
package clases;

import java.security.MessageDigest;

/* @author Jose Luis */
public class Encrypt {
    public static String EncrypSHA(String pass){
        String algorithm = "SHA-256";
        byte[] plainText = pass.getBytes();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        md.reset();
        md.update(plainText);
        byte[] encodedPassword = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encodedPassword.length; i++) {
            if ((encodedPassword[i] & 0xff) < 0x10) {
                sb.append("0");
            }
            sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
        }
        return sb.toString();
    }
    
    public static String EncrypMD5(String pass){
        String algorithm = "MD5";
        byte[] plainText = pass.getBytes();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        md.reset();
        md.update(plainText);
        byte[] encodedPassword = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encodedPassword.length; i++) {
            if ((encodedPassword[i] & 0xff) < 0x10) {
                sb.append("0");
            }
            sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
        }
        return sb.toString();
    }
    
}
