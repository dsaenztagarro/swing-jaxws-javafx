/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.custom.utils;

import hidrocon.custom.Constant;
import java.util.List;

/**
 *
 * @author David Sáenz Tagarro
 */
public class OrderedListUtils {
    
    public static int changeOrder(List list, int index, int direction) {
        int newIndex = -1;
        if (direction == Constant.MOVE_UP) {
            if (index>0) {
                newIndex = index -1;
                IOrderedElement moveUpElement = (IOrderedElement)list.get(index);
                moveUpElement.setOrderId(moveUpElement.getOrderId()-1);
                IOrderedElement moveDownElement = (IOrderedElement)list.get(newIndex);
                moveDownElement.setOrderId(moveDownElement.getOrderId()+1);
                //to force refresh list binding
                list.remove(moveUpElement);
                list.add(newIndex,moveUpElement);
                list.remove(moveDownElement);
                list.add(index,moveDownElement);                
            } 
        } else if (direction == Constant.MOVE_DOWN) {
            if (index<list.size()-1) {
                newIndex = index+1;
                IOrderedElement moveDownElement = (IOrderedElement)list.get(index);
                moveDownElement.setOrderId(moveDownElement.getOrderId()+1);
                IOrderedElement moveUpElement = (IOrderedElement)list.get(newIndex);
                moveUpElement.setOrderId(moveUpElement.getOrderId()-1);
                //to force refresh list binding
                list.remove(moveDownElement);
                list.add(newIndex,moveDownElement);
                list.remove(moveUpElement);
                list.add(index,moveUpElement);
            } 
        }
        return newIndex;
    }
    
}
