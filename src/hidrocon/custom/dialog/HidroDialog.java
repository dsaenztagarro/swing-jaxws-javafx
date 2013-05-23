/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.custom.dialog;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.persistence.Transient;
import javax.swing.JDialog;

/**
 *
 * @author davlanca
 */
public abstract class HidroDialog extends JDialog {
    
    //TODO: Create setMode()
    public static final int CREATION_MODE = 1;
    public static final int VIEW_MODE = 2;
    public static final int EDIT_MODE = 3;
    
    public HidroDialog(java.awt.Frame owner, boolean modal) {
        super(owner, modal);
        setResizable(false);
        //setUndecorated(true);
        //setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setAutoRequestFocus(true);
        setLocationRelativeTo(null);        
    }
    
    /*
     * Binding methods - BEGIN
     */
    
	@Transient
	protected PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    @Override
	public void addPropertyChangeListener(PropertyChangeListener l) {
		propertyChangeSupport.addPropertyChangeListener(l);
	}

    @Override
	public void removePropertyChangeListener(PropertyChangeListener l) {
		propertyChangeSupport.removePropertyChangeListener(l);
	}    
    
    /*
     * Binding methods - END
     */
    
    /*
     * Center dialog methods - BEGIN
     */
    
    // centers the dialog within the screen [1.1]
    //  (put that in the Frame/Dialog class)
    public void centerScreen() {
      Dimension dim = getToolkit().getScreenSize();
      Rectangle abounds = getBounds();
      setLocation((dim.width - abounds.width) / 2,
          (dim.height - abounds.height) / 2);
      requestFocus();
    }    
    
    // centers the dialog within the parent container [1.1]
    //  (put that in the Dialog class)
    public void centerParent () {
      int x;
      int y;

      // Find out our parent 
      Container myParent = getParent();
      Point topLeft = myParent.getLocationOnScreen();
      Dimension parentSize = myParent.getSize();

      Dimension mySize = getSize();

      if (parentSize.width > mySize.width) 
        x = ((parentSize.width - mySize.width)/2) + topLeft.x;
      else 
        x = topLeft.x;

      if (parentSize.height > mySize.height) 
        y = ((parentSize.height - mySize.height)/2) + topLeft.y;
      else 
        y = topLeft.y;

      setLocation (x, y);
      requestFocus();
    }          
    
    /*
     * Center dialog methods - END
     */    

}
