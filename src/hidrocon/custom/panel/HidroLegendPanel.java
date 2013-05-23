/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom.panel;

import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author david
 */
public final class HidroLegendPanel extends HidroGradientRoundPanel {
    
	private final Color FOREGROUND_COLD_WATER = new Color(125,156,239); 
	private final Color BACKGROUND_COLD_WATER = new Color(2,13,73);
    
	public HidroLegendPanel() {
		super(VERTICAL);
        setMinimumSize(new Dimension(10,20));
        setMaximumSize(new Dimension(10,9999));
        loadDefaultColor();
	}
    
    public void setHexLightColor(String hex) {
        int intValue = Integer.parseInt(hex,16);
        Color aColor = new Color(intValue);        
        setForeground(aColor);
    }

    public void setHexDarkColor(String hex) {
        int intValue = Integer.parseInt(hex,16);
        Color aColor = new Color(intValue);        
        setBackground(aColor);
    }
    
    private void loadDefaultColor() {
        setForeground(FOREGROUND_COLD_WATER);
        setBackground(BACKGROUND_COLD_WATER);
    }
        
}
