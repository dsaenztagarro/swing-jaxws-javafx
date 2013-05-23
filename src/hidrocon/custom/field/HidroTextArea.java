/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom.field;

import hidrocon.custom.Constant;
import hidrocon.custom.utils.HidroBorderFactory;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 *
 * @author david
 */
public class HidroTextArea extends JTextArea implements FocusListener {

	public HidroTextArea() {
		super();
		initProperties();
	}

	private void initProperties() {
		setFocusLostStyle();
		setFont(Constant.TEXTFIELD_DEFAULT_FONT);
		setMargin(new Insets(15,15,15,15));
        setEditable(false);
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
        if (isEditable()) {
            HidroBorderFactory hbf = HidroBorderFactory.getInstance();
            setBorder(hbf.getBorder(HidroBorderFactory.TEXTFIELD_SELECTED));
            setBackground(Constant.TEXTFIELD_BACKGROUND_FOCUS_GAINED);
            setForeground(Color.BLACK);
        }
	}

	private void setFocusLostStyle() {
        if (isEditable()) {
            HidroBorderFactory hbf = HidroBorderFactory.getInstance();
            setBorder(hbf.getBorder(HidroBorderFactory.TEXTFIELD_UNSELECTED));
            setBackground(Constant.TEXTFIELD_BACKGROUND_FOCUS_LOST);
            setForeground(Color.BLACK);
        }
	}
    
    @Override
    public void setEditable(boolean editable) {
        super.setEditable(editable);
        if (editable) {
            if (hasFocus()) {
                setBackground(Constant.TEXTFIELD_BACKGROUND_FOCUS_GAINED);
            } else {
                setBackground(Constant.TEXTFIELD_BACKGROUND_FOCUS_LOST);
            }
        } else {
            setBackground(Constant.TEXTFIELD_BACKGROUND_NOT_EDITABLE);
        }
    }   
    
}
