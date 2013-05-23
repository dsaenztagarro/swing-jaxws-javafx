/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.custom.utils;

import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author davlanca
 */
public class HidroImageCache {
    
    private HashMap images;
    private static HidroImageCache singleton;
    
    private HidroImageCache() {
        images = new HashMap();
    }
    
    public static HidroImageCache getInstance() {
        if (singleton==null) {
            singleton = new HidroImageCache();
        }
        return singleton;
    }
    
    public void addImageIcon(String name, ImageIcon image) {
        images.put(name, image);
    }
    
    public ImageIcon getImageIcon(String name) {
        Object img = images.get(name);
        return (ImageIcon) img;
    }
    
    public void clear() {
        images.clear();
        images = null;
    }
    
}
