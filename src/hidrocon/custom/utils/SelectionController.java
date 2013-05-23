/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.custom.utils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 *
 * @author David Sáenz Tagarro
 */
public class SelectionController implements MouseListener {
    
    private ArrayList<ISelectableElement> selectableElementList;
    
    public SelectionController() {
        selectableElementList = new ArrayList();
    }
    
    public void addSelectableElement(ISelectableElement element) {
        selectableElementList.add(element);
    }

    public void mouseClicked(MouseEvent e) {
        ISelectableElement elementSelected = (ISelectableElement)e.getSource();
        for (ISelectableElement element : selectableElementList) {
            element.setSelected(false);
        }
        elementSelected.setSelected(true);
        
    }

    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
