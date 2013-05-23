/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom.field;

import hidrocon.custom.Constant;
import hidrocon.custom.utils.HidroBorderFactory;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author David Sáenz Tagarro
 */
public class HidroTextField extends JTextField implements FocusListener {

	public HidroTextField() {
		super();
		initProperties();
	}

	private void initProperties() {
		setFocusLostStyle();
		setFont(Constant.TEXTFIELD_DEFAULT_FONT);
		setMargin(new Insets(15,15,15,15));
        setEditable(false);
        addFocusListener(this);
        
        setSelectionColor(Constant.TEXTFIELD_SELECTION_BACKGROUND);
        setSelectedTextColor(Constant.TEXTFIELD_SELECTION_FOREGROUND);
        
		addKeyListener(new java.awt.event.KeyAdapter() {
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
            setForeground(Color.BLACK); //new Color(43,40,83));
            setCaretPosition(getDocument().getLength());
        }
	}

	private void setFocusLostStyle() {
        if (isEditable()) {
            HidroBorderFactory hbf = HidroBorderFactory.getInstance();
            setBorder(hbf.getBorder(HidroBorderFactory.TEXTFIELD_UNSELECTED));
            setBackground(Constant.TEXTFIELD_BACKGROUND_FOCUS_LOST);
            setForeground(Color.BLACK);
        }
        unselectText();
	}
    
    private void unselectText() {
        setSelectionStart(0);
        setSelectionEnd(0);        
    }
    
    @Override
    public void setEditable(boolean editable) {
        HidroBorderFactory hbf = HidroBorderFactory.getInstance();
        
        super.setEditable(editable);
        if (editable) {
            if (hasFocus()) {
                //setFocusGainedStyle();
                setBorder(hbf.getBorder(HidroBorderFactory.TEXTFIELD_SELECTED));            
                setBackground(Constant.TEXTFIELD_BACKGROUND_FOCUS_GAINED);
                setForeground(Color.BLACK);
                //Bug ID: 4680302 - JTextField Caret Missing when enabling & disabling
                getCaret().setVisible(true);
                getCaret().setSelectionVisible(true);
                setCaretPosition(getDocument().getLength());
            } else {
                //setFocusLostStyle();
                setBorder(hbf.getBorder(HidroBorderFactory.TEXTFIELD_UNSELECTED));
                setBackground(Constant.TEXTFIELD_BACKGROUND_FOCUS_LOST);
                setForeground(Color.BLACK);
            }
            setCursor(new Cursor(Cursor.TEXT_CURSOR));
        } else {
            setBackground(Constant.TEXTFIELD_BACKGROUND_NOT_EDITABLE);
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    } 
}
