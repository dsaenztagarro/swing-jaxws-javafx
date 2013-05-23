/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.custom.utils;

import hidrocon.custom.Constant;
import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author davlanca
 */
public class HidroBorderFactory {
    
    public static final int TEXTFIELD_SELECTED = 1;
    public static final int TEXTFIELD_UNSELECTED = 2;

    private static HidroBorderFactory singleton;
    
    private HidroBorderFactory() {
    }
    
    public static HidroBorderFactory getInstance() {
        if (singleton==null) {
            singleton = new HidroBorderFactory();
        }
        return singleton;
    }
    
    public Border getBorder(int id) {
        Border border = null;
        if (id == TEXTFIELD_SELECTED) {
            border = javax.swing.BorderFactory.createCompoundBorder(
                new LineBorder(new Color(43,40,83),1,false),
                javax.swing.BorderFactory.createEmptyBorder(1, 2, 1, 2));
        }
        else if (id == TEXTFIELD_UNSELECTED) {
            border = javax.swing.BorderFactory.createCompoundBorder(
                new LineBorder(Constant.TEXTFIELD_BORDER_COLOR,1,false),
                javax.swing.BorderFactory.createEmptyBorder(1, 2, 1, 2)); 
        }
        return border;
    }
    
}
