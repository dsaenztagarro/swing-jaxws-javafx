/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 *
 * @author david
 */
public class HidroTitle extends JLabel {

	public HidroTitle() {
		super();
		initProperties();
	}

	private void initProperties() {
		this.setForeground(Color.WHITE);
		this.setFont(Constant.TITLE_FONT);
		this.setForeground(Color.WHITE);
	}
}
