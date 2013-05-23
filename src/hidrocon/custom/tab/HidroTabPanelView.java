/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.custom.tab;

import hidrocon.custom.Constant;
import hidrocon.custom.panel.HidroGradientPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

/**
 *
 * @author David Sáenz Tagarro
 */
public class HidroTabPanelView extends HidroGradientPanel{
    
    public HidroTabPanelView() {
        super(VERTICAL);
		setPreferredSize(new Dimension(100,40));
		setMinimumSize(new Dimension(100,40));
        
		setForeground(new Color(39,39,39));
		setBackground(Constant.SECTION_PANEL_BACKGROUND);        

        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 0, 0));
            
		FlowLayout layout = new FlowLayout();
		layout.setVgap(0);
		layout.setHgap(10);
		layout.setAlignment(FlowLayout.LEFT);
		setLayout(layout);        
    }
    
}
