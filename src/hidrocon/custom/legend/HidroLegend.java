/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.custom.legend;

import hidrocon.custom.Constant;
import hidrocon.custom.utils.HidroImageCache;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author davlanca
 */
public class HidroLegend extends JLabel {
    
    public HidroLegend() {
        setForeground(Color.WHITE);
        setFont(Constant.DEFAULT_FONT);
    }

    protected void setIcon(String fileName, boolean isDefaultPath) {
        HidroImageCache ic = HidroImageCache.getInstance();
        ImageIcon img = ic.getImageIcon(fileName);
        if (img==null) {
            if (isDefaultPath) {
                img = new javax.swing.ImageIcon(getClass().getResource("/hidrocon/resources/images/legend/"+fileName));
            } else {
                img = new javax.swing.ImageIcon(getClass().getResource(fileName));
            }
            ic.addImageIcon(fileName, img);
        }
		setIcon(img);        
    }
    
    protected void setIcon(String fileName) {
        setIcon(fileName, true);
    }
    
}
