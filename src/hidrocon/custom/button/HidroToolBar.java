/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom.button;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JToolBar;

/**
 *
 * @author david
 */
public class HidroToolBar extends JToolBar {

	public HidroToolBar() {
		super();
		setOpaque(false);
		setBorderPainted(false);
		setBackground(Color.WHITE);
		//setPreferredSize(new Dimension(200,32));
		FlowLayout layout = new FlowLayout();
		layout.setVgap(0);
		layout.setHgap(5);
		layout.setAlignment(TOP);
		setLayout(layout);
	}
}
