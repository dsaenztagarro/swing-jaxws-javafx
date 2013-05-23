/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom.tab;

import hidrocon.custom.Constant;
import hidrocon.custom.HidroTitle;
import hidrocon.custom.panel.HidroGradientSemiRoundPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;

/**
 *
 * @author David Sáenz Tagarro
 */
public final class HidroTabButtonView extends HidroGradientSemiRoundPanel {

    private boolean selected;
    private int position;
    private Component component;
    private HidroTitle title;
    
	public HidroTabButtonView() {
		super(VERTICAL);
        setOpaque(false);
        setMinimumSize(new Dimension(150,45));
        setPreferredSize(new Dimension(150,45));
        setArcWidth(20);
        setArcHeight(20);
        
		setFont(Constant.DEFAULT_FONT);      
        setEnabled(true);
        setSelected(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        title = new HidroTitle();
        
        add(title);
	}
    
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (super.isEnabled()) {
            setMouseExitedStyle();            
        } else {
            setDisabledStyle();
        }
    }
    
    public void setText(String text) {
        this.title.setText(text);
    }
    
    public void setSelected(boolean selected) {
        this.selected = selected;
        if (!selected) {
            if (isEnabled()) {
                setMouseExitedStyle();
            }
        } else {
            setMouseEnteredStyle();
        }
    }
    
    public void setMouseEnteredStyle() {
        setForeground(new Color(0,0,34));
        setBackground(Constant.TOP_PANEL_FOREGROUND);        
    }
    
    public void setMouseExitedStyle() {
        setForeground(new Color(43,43,83));
        setBackground(Constant.TOP_PANEL_FOREGROUND);                                    
    }
    
    private void setDisabledStyle() {
        setForeground(new Color(15,15,15));
        setBackground(new Color(82,82,82));           
    }
    
    public boolean isSelected() {
        return this.selected;
    }
    
    public Component getComponent() {
       return component;
    }
    
    public void setComponent(Component component) {
        this.component = component;
    }
    
    public int getPosition() {
        return position;
    }
    
    public void setPosition(int position) {
        this.position = position;
    }
    
}
