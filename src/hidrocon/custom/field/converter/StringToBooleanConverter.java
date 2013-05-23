/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.custom.field.converter;

import hidrocon.custom.Constant;
import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author David Sáenz Tagarro
 */
public class StringToBooleanConverter extends Converter<String,Boolean>{

    public static final int TRUE_FALSE_MODE = 1;
    public static final int YES_NO_MODE = 2;
    
    private int mode;
    
    public StringToBooleanConverter(int mode) {
        this.mode = mode;
    }
    
    public Boolean convertForward(String str) {
        System.out.println("str: " + str);
        if (str!=null) {
            if (mode == TRUE_FALSE_MODE) {
                return str.equals(Constant.TRUE);    
            }
            else if (mode == YES_NO_MODE) {
                return str.equals(Constant.YES);
            }
        }
        return false;
        
    }

    public String convertReverse(Boolean booleanObj) {
        System.out.println("booleanObj: " + booleanObj);
        if (mode == TRUE_FALSE_MODE) {
            return booleanObj.booleanValue()? Constant.TRUE : Constant.FALSE;
        }
        else if (mode == YES_NO_MODE) {
            return booleanObj.booleanValue()? Constant.YES : Constant.NO;
        }
        return null;
    }    
}
