/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom.field;

import hidrocon.custom.Constant;
import hidrocon.custom.utils.HidroBorderFactory;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.NumberFormatter;
import javax.swing.text.DefaultFormatterFactory;
/**
 *
 * @author David Sáenz Tagarro
 * @
 */
public class HidroIntegerField extends JFormattedTextField implements FocusListener {

	private NumberFormatter numberFormatter = null;

	public HidroIntegerField() {
		super();
		initProperties();
	}

	private void initProperties() {
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("#0");
        decimalFormat.setParseIntegerOnly(true);
		numberFormatter = new NumberFormatter(decimalFormat);
        numberFormatter.setValueClass(java.lang.Integer.class);
		setFocusLostStyle();
		setFont(Constant.TEXTFIELD_DEFAULT_FONT);
		setFormatterFactory(new DefaultFormatterFactory(numberFormatter));
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
		
		/*addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				setFocusGainedStyle();
				final HidroIntegerField obj = (HidroIntegerField)e.getComponent();
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						System.out.println("obj: " + obj);
						obj.selectAll();
					}
				});
			}

			public void focusLost(FocusEvent e) {
				setFocusLostStyle();
				if (!e.isTemporary() && isEnabled() ) {
					String content = this.getText();
					if (!content.equals("1") && !content.equals("2")) {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								Toolkit.getDefaultToolkit().beep();
							}
						});
						//System.out.println("illegal value! " + content );
						//SwingUtilities.invokeLater(new FocusEvent(this,FocusEvent.FOCUS_GAINED));
					}
				}
			}

		});*/
	}

    @Override
    public void setValue(Object obj) {
        if (obj instanceof Integer) {
            super.setValue(obj);
        } else {
            super.setText("");
        }
    }
    
    @Override
    public Integer getValue() {
        return (Integer)super.getValue();
    }
    
	public void setMaxValue(int max) {
		numberFormatter.setMaximum(max);

	}

	public void setMinValue(int min) {
		numberFormatter.setMinimum(min);
	}

    
    /*
     * FocusListener Interface Implementation
     */

	public void focusGained(FocusEvent e) {
		setFocusGainedStyle();
		/*final HidroIntegerField obj = (HidroIntegerField)e.getComponent();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				System.out.println("obj: " + obj);
				obj.selectAll();
			}
		});*/
	}

	public void focusLost(FocusEvent e) {
		setFocusLostStyle();
		/*if (!e.isTemporary() && isEnabled() ) {
			String content = this.getText();
			if (!content.equals("1") && !content.equals("2")) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						System.out.println("beep!!");
						Toolkit.getDefaultToolkit().beep();
					}
				});
				//System.out.println("illegal value! " + content );
				//SwingUtilities.invokeLater(new FocusEvent(this,FocusEvent.FOCUS_GAINED));
			}
		}*/
	}

	private void setFocusGainedStyle() {
        if (isEditable()) {
            HidroBorderFactory hbf = HidroBorderFactory.getInstance();
            setBorder(hbf.getBorder(HidroBorderFactory.TEXTFIELD_SELECTED));
            setBackground(Constant.TEXTFIELD_BACKGROUND_FOCUS_GAINED);
            setForeground(Color.BLACK);
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
	}
    
    @Override
    public void setEditable(boolean editable) {
        super.setEditable(editable);
        HidroBorderFactory hbf = HidroBorderFactory.getInstance();
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
