/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.custom.panel;

import hidrocon.custom.Constant;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author David Sáenz Tagarro
 */
public class HidroItemContentPanel extends HidroGradientRoundPanel implements MouseListener {
    
    private boolean selected;
    private boolean enabled;
    
    public HidroItemContentPanel() {
        super(VERTICAL);
		setForeground(Constant.ITEM_CONTENT_PANEL_FOREGROUND);
		setBackground(Constant.ITEM_CONTENT_PANEL_BACKGROUND);        
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
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if (enabled) {
            setDisabledStyle();
        } else {
            setMouseExitedStyle();
        }
    }
    
    private void setMouseEnteredStyle() {
        setBackground(Constant.ITEM_CONTENT_PANEL_BACKGROUND_OVER);
        setForeground(Constant.ITEM_CONTENT_PANEL_FOREGROUND_OVER);       
    }
    
    private void setMouseExitedStyle() {
        setForeground(Constant.ITEM_CONTENT_PANEL_FOREGROUND);
        setBackground(Constant.ITEM_CONTENT_PANEL_BACKGROUND);        
    }
    
    private void setDisabledStyle() {
        setForeground(Constant.ITEM_CONTENT_PANEL_FOREGROUND_OFF);
        setBackground(Constant.ITEM_CONTENT_PANEL_BACKGROUND_OFF);        
    }
    
    public void mouseClicked(MouseEvent e) {
        setSelected(!selected);
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        if (enabled) {
            setMouseEnteredStyle();
        }
    }

    public void mouseExited(MouseEvent e) {
        if (enabled) {
            setMouseExitedStyle();
        }
    }    
}
