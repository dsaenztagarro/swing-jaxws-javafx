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

/**
 *
 * @author david
 */
public class HidroTopPanel extends HidroGradientPanel {

	private HidroTitle title;
	private HidroToolBar toolbar;

	public HidroTopPanel() {
		super(VERTICAL);
		setPreferredSize(new Dimension(100,35));
		setMinimumSize(new Dimension(100,35));
        
		//setForeground(Constant.TOP_PANEL_FOREGROUND);
		//setBackground(Constant.TOP_PANEL_BACKGROUND);
        setForeground(Constant.TOP_PANEL_FOREGROUND);
        setBackground(Constant.TOP_PANEL_BACKGROUND); //new Color(0,67,191));        
		//setBorder(new LineBorder(Constant.TOP_PANEL_FOREGROUND,1,true));
		//setBorder(new LineBorder(Constant.MENU_BAR_FOREGROUND,4));
		setLayout(new BorderLayout());
		
		initComponents();
	}
    
	private void initComponents() {
		title = new HidroTitle();
		toolbar = new HidroToolBar();

		add(title, java.awt.BorderLayout.WEST);
		add(toolbar,java.awt.BorderLayout.EAST);
	}

	public void setTitle(String text) {
		title.setText(text);
	}

	public void addButton(JButton button) {
		toolbar.add(button);
	}

}
