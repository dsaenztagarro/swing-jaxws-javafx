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
public class HidroLabel extends JLabel {
    
	public HidroLabel() {
		super();
		initProperties();
	}

	private void initProperties() {
		this.setForeground(Constant.LABEL_FOREGROUND);
		this.setFont(Constant.DEFAULT_FONT);
	}
    
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (enabled) {
            this.setForeground(Constant.LABEL_FOREGROUND);
        } else {
            this.setForeground(Constant.LABEL_FOREGROUND_OFF);
        }
    }

}
