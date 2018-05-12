
package clases;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/*@author Jose Luis */

public class ImageConverter {
    
    public static Image byteToImage(byte[] bytes) throws IOException{
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("jpg"); 
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        return reader.read(0, param);
    }
    
    public static byte [] imageToByte(File img) throws IOException{
        byte [] arreglo;
        arreglo = Files.readAllBytes(img.toPath());
        return arreglo;
    }
}
