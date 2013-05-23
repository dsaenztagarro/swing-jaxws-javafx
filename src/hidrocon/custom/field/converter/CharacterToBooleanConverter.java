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
public class CharacterToBooleanConverter extends Converter<Character,Boolean>{

    public static final int TRUE_FALSE_MODE = 1;
    public static final int YES_NO_MODE = 2;
    public static final int TRUE_FALSE_INVERSE_MODE = 3;
    
    private int mode;
    
    public CharacterToBooleanConverter(int mode) {
        this.mode = mode;
    }
    
    public Boolean convertForward(Character charObj) {
        if (charObj!=null) {
            if (mode == TRUE_FALSE_MODE) {
                return charObj.charValue() == Constant.CHARACTER_TRUE;    
            }
            else if (mode == YES_NO_MODE) {
                return charObj.charValue() == Constant.CHARACTER_YES;
            }
            else if (mode == TRUE_FALSE_INVERSE_MODE) {
                return charObj.charValue() == Constant.CHARACTER_FALSE;
            }            
        }
        return false;
        
    }

    public Character convertReverse(Boolean booleanObj) {
        if (mode == TRUE_FALSE_MODE) {
            return booleanObj.booleanValue()? Constant.CHARACTER_TRUE : Constant.CHARACTER_FALSE;
        }
        else if (mode == YES_NO_MODE) {
            return booleanObj.booleanValue()? Constant.CHARACTER_YES : Constant.CHARACTER_NO;
        }
        else if (mode == TRUE_FALSE_INVERSE_MODE) {
            return booleanObj.booleanValue()? Constant.CHARACTER_FALSE : Constant.CHARACTER_TRUE;
        }        
        return null;
    }    
}
