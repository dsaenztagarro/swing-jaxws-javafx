/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom.label;

import hidrocon.custom.Constant;
import javax.swing.JLabel;

/**
 *
 * @author David Sáenz Tagarro
 */
public class HidroXSLabel extends JLabel {

	public HidroXSLabel() {
		super();
		initProperties();
	}

	private void initProperties() {
		this.setForeground(Constant.LABEL_FOREGROUND);
		this.setFont(Constant.SMALL_FONT);
	}
}
