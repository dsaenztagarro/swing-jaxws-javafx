/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.meter.metertype;

import hidrocon.core.database.metertype.manager.MeterTypeManager;
import java.util.List;

/**
 *
 * @author David Sáenz Tagarro
 */
public class MeterTypePanelModel {
    
    public List getMeterTypeList() {
        MeterTypeManager mtm = new MeterTypeManager();
        return mtm.getMeterTypeList();
    }
    
}
