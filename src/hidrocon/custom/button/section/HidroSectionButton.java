/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom.button.section;

import hidrocon.custom.utils.HidroImageCache;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author david
 */
public class HidroSectionButton extends JButton {

	public HidroSectionButton() {
		super();
		setOpaque(false);
		setMaximumSize(new Dimension(24,24));
		setMinimumSize(new Dimension(24,24));
		setPreferredSize(new Dimension(24,24));
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
            img = new javax.swing.ImageIcon(getClass().getResource("/hidrocon/resources/images/section/"+fileName));
            ic.addImageIcon(fileName, img);
        }
		setIcon(img);        
    }    
    
}
