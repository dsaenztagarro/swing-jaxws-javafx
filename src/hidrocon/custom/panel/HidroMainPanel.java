/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom.panel;

import hidrocon.custom.Constant;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class HidroMainPanel extends JPanel {

	public HidroMainPanel() {
		super();
		setBackground(Constant.MAIN_PANEL_BACKGROUND);
        setMinimumSize(new Dimension(750,600));
		setPreferredSize(new Dimension(750,600));
	}
    
}
