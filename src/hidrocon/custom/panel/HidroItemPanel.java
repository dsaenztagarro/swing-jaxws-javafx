/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom.panel;

import hidrocon.custom.Constant;
import hidrocon.custom.HidroTitle;
import hidrocon.custom.button.HidroToolBar;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author david
 */
public class HidroItemPanel extends HidroGradientRoundPanel {

    private JLabel icon;
	private HidroTitle title;
	private HidroToolBar toolbar;
    private javax.swing.Box.Filler leftFiller;
    
	public HidroItemPanel() {
		super(VERTICAL);
		setPreferredSize(new Dimension(100,26));
        setMinimumSize(new Dimension(100,26));
        setMaximumSize(new Dimension(9999,26));
		setForeground(Constant.ITEM_PANEL_FOREGROUND);
		setBackground(Constant.ITEM_PANEL_BACKGROUND);
        setLayout(new BorderLayout());
        
        initComponents();
	}
    
	private void initComponents() {
        leftFiller = new javax.swing.Box.Filler(new java.awt.Dimension(10, 20), new java.awt.Dimension(10, 20), new java.awt.Dimension(10, 20));
        title = new HidroTitle();
		toolbar = new HidroToolBar();        
        
        add(leftFiller, java.awt.BorderLayout.WEST);
        add(toolbar,java.awt.BorderLayout.EAST);
	}

    public void setImageIcon(JLabel icon) {
        this.icon = icon;
        
        add(this.icon, java.awt.BorderLayout.CENTER);
        
    }
    
	public void setTitle(String text) {
		title.setText(text);
	}

	public void addButton(JButton button) {
		toolbar.add(button);
	}
    
}
