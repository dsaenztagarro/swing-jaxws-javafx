/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.custom.utils;

import java.awt.event.MouseListener;

/**
 *
 * @author David Sáenz Tagarro
 */
public interface ISelectableElement {
    void setSelected(boolean selected);
    void addSelectionMouseListener(MouseListener ml);
}
