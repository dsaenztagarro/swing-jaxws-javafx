/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom.field;

import hidrocon.custom.Constant;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

/**
 *
 * @author David Sáenz Tagarro
 */
public class HidroComboBox extends JComboBox implements FocusListener {

	public HidroComboBox() {
		super();
		initProperties();
	}

	private void initProperties() {
		setFocusLostStyle();
		setFont(Constant.TEXTFIELD_DEFAULT_FONT);
        setEditable(false);
        setEnabled(false);
        setMinimumSize(new Dimension(2,19));
        setPreferredSize(new Dimension(2,19));
		//setMargin(new Insets(15,15,15,15));
        addFocusListener(this);
        
        //setSelectionColor(Constant.TEXTFIELD_SELECTION_BACKGROUND);
        //setSelectedTextColor(Constant.TEXTFIELD_SELECTION_FOREGROUND);
        
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
        System.out.println("focus gained");
    }
    
    public void focusLost(FocusEvent evt) {
        setFocusLostStyle();
        System.out.println("focus lost");
    }
    
	private void setFocusGainedStyle() {
        setBorder(new LineBorder(new Color(43,40,83),1,false));
        setBackground(Constant.TEXTFIELD_BACKGROUND_FOCUS_GAINED);
        setForeground(Color.BLACK); //new Color(43,40,83));
        //setCaretPosition(getDocument().getLength());
	}

	private void setFocusLostStyle() {
        setBorder(new LineBorder(Constant.TEXTFIELD_BORDER_COLOR,1,false));
        setBackground(Constant.TEXTFIELD_BACKGROUND_FOCUS_LOST);
        setForeground(Color.BLACK);
	}
    
    /* private void unselectText() {
        setSelectionStart(0);
        setSelectionEnd(0);        
    } */
    
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (enabled) {
            if (hasFocus()) {
                //setFocusGainedStyle();
                setBorder(new LineBorder(new Color(43,40,83),1,false));
                setBackground(Constant.TEXTFIELD_BACKGROUND_FOCUS_GAINED);
                setForeground(Color.BLACK);
                //Bug ID: 4680302 - JTextField Caret Missing when enabling & disabling
                //getCaret().setVisible(true);
                //getCaret().setSelectionVisible(true);
                //setCaretPosition(getDocument().getLength());
            } else {
                //setFocusLostStyle();
                setBorder(new LineBorder(Constant.TEXTFIELD_BORDER_COLOR,1,false));
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
