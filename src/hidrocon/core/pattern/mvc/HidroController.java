/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.core.pattern.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author David Sáenz Tagarro
 */
public class HidroController extends Observable implements 
        ActionListener, 
        KeyListener, 
        MouseListener, 
        PropertyChangeListener,
        ListSelectionListener,
        Observer {

    public void actionPerformed(ActionEvent e) {
        //do nothing
    }
    
    public void keyTyped(KeyEvent e) {
        //do nothing
    }

    public void keyPressed(KeyEvent e) {
        //do nothing
    }

    public void keyReleased(KeyEvent e) {
        //do nothing
    }

    public void mouseClicked(MouseEvent e) {
        //do nothing
    }

    public void mousePressed(MouseEvent e) {
        //do nothing
    }

    public void mouseReleased(MouseEvent e) {
        //do nothing
    }

    public void mouseEntered(MouseEvent e) {
        //do nothing
    }

    public void mouseExited(MouseEvent e) {
        //do nothing
    }

    public void valueChanged(ListSelectionEvent e) {
        //do nothing
    }

    public void update(Observable o, Object arg) {
        //do nothing
    }

    public void propertyChange(PropertyChangeEvent evt) {
        //do nothing
    }
    
}
