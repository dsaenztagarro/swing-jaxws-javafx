/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom.button.toolbar;

import hidrocon.custom.utils.HidroImageCache;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author david
 */
public class HidroToolBarButton extends JButton {

	public HidroToolBarButton() {
		super();
		setOpaque(false);
		setMaximumSize(new Dimension(32,32));
		setMinimumSize(new Dimension(32,32));
		setPreferredSize(new Dimension(32,32));
		//setBackground(Color.WHITE);
        //Bug ID: 5079694 JDialog doesn't respect setCursor
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setBorderPainted(false);
        setFocusable(false);
	}
    
    protected void setIcon(String fileName) {
        HidroImageCache ic = HidroImageCache.getInstance();
        ImageIcon img = ic.getImageIcon(fileName);
        if (img==null) {
            img = new javax.swing.ImageIcon(getClass().getResource("/hidrocon/resources/images/toolbar/"+fileName));
            ic.addImageIcon(fileName, img);
        }
		setIcon(img);        
    }    
    
    protected void setDisabledIcon(String fileName) {
        HidroImageCache ic = HidroImageCache.getInstance();
        ImageIcon img = ic.getImageIcon(fileName);
        if (img==null) {
            img = new javax.swing.ImageIcon(getClass().getResource("/hidrocon/resources/images/toolbar/"+fileName));
            ic.addImageIcon(fileName, img);
        }
		setIcon(img);        
    }       
    
}
