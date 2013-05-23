/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom.panel;

import javax.swing.JPanel;

/**
 *
 * @author David Sáenz Tagarro
 */
public class HidroPanel extends JPanel{
	
	public HidroPanel() {
		super();
		initProperties();
	}

	private void initProperties() {
		this.setOpaque(false);
		//this.setBackground(Constant.APPLICATION_BACKGROUND);
	}
}
