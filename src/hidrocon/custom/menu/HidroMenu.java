/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom.menu;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.border.LineBorder;

/**
 *
 * @author david
 */
public class HidroMenu extends JMenu {

	public HidroMenu() {
		super();
		initProperties();
	}

	private void initProperties() {
		setOpaque(true);
		setBorder(new LineBorder(new Color(159,197,255),1,true));
		setBorderPainted(false);
		setFont(new Font("Arial",Font.BOLD,14));
		setBackground(new Color(197,213,238));
		setForeground(new Color(0,89,223));
	}
}

