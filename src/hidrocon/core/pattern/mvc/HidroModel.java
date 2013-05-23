/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.core.pattern.mvc;

import java.util.Observable;

/**
 *
 * @author David Sáenz Tagarro
 */
public class HidroModel extends Observable {
    
    protected void notifyController(Object argument) {
        setChanged();
        notifyObservers(argument);
    }
    
}
