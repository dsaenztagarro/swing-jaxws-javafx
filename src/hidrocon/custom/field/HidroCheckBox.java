/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.custom.field;

import hidrocon.custom.Constant;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;

/**
 *
 * @author David Sáenz Tagarro
 */
public class HidroCheckBox extends JCheckBox implements FocusListener{
	
    public HidroCheckBox() {
		super();
		initProperties();
	}

	private void initProperties() {
		setFocusLostStyle();
		setFont(Constant.DEFAULT_FONT);
        setEnabled(false);
        //setMinimumSize(new Dimension(2,19));
        //setPreferredSize(new Dimension(2,19));
		//setMargin(new Insets(15,15,15,15));
        addFocusListener(this);
        
		addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
				int keyCode = evt.getKeyCode();
				if (keyCode == KeyEvent.VK_ENTER) {
					evt.consume();
					transferFocus();
				}
            }
        });
	}

    /*
     * FocusListener Interface Implementarion
     */
    
    public void focusGained(FocusEvent evt) {
        setFocusGainedStyle();
    }
    
    public void focusLost(FocusEvent evt) {
        setFocusLostStyle();
    }
    
	private void setFocusGainedStyle() {
        setBorder(new LineBorder(new Color(43,40,83),1,false));
        setBackground(Constant.MAIN_PANEL_BACKGROUND);
        setForeground(Color.BLACK); //new Color(43,40,83));
        //setCaretPosition(getDocument().getLength());
	}

	private void setFocusLostStyle() {
        setBorder(new LineBorder(Constant.TEXTFIELD_BORDER_COLOR,1,false));
        setBackground(Constant.MAIN_PANEL_BACKGROUND);
        setForeground(Color.BLACK);
	}
    
    /* private void unselectText() {
        setSelectionStart(0);
        setSelectionEnd(0);        
    } */
    
    @Override
    public void setEnabled(boolean editable) {
        super.setEnabled(editable);
        
        if (editable) {
            if (hasFocus()) {
                setBorder(new LineBorder(new Color(43,40,83),1,false));
                setBackground(Constant.MAIN_PANEL_BACKGROUND);
                setForeground(Color.BLACK);
            } else {
                setBorder(new LineBorder(Constant.TEXTFIELD_BORDER_COLOR,1,false));
                setBackground(Constant.MAIN_PANEL_BACKGROUND);
                setForeground(Color.BLACK);
            }
        } else {
            setBackground(Constant.MAIN_PANEL_BACKGROUND);
            setForeground(Color.BLACK);
        }
    }     
}
