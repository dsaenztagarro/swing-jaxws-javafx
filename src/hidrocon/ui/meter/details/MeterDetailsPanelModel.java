/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.meter.details;

import hidrocon.HidroconView;
import hidrocon.core.database.meter.entities.Meter;
import hidrocon.core.database.meter.manager.MeterManager;
import javax.swing.JOptionPane;

/**
 *
 * @author David Sáenz Tagarro
 */
public class MeterDetailsPanelModel {
        
	public void createMeter(Meter meter) {
        MeterManager meterManager = new MeterManager();
        meterManager.createMeter(meter);
	}   
    
    public void showMessageMeterCreated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("meter.message.dialog.create"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);            
    }
}
