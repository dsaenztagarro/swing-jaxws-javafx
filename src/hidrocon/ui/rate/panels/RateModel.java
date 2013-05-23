/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.rate.panels;

import hidrocon.HidroconApp;
import hidrocon.HidroconView;
import hidrocon.core.database.rate.entities.Rate;
import hidrocon.core.database.rate.manager.RateManager;
import hidrocon.custom.Constant;
import hidrocon.custom.dialog.HidroDialog;
import hidrocon.custom.dialog.interfaces.IEntityView;
import hidrocon.custom.utils.HidroDialogFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author David Sáenz Tagarro
 */
public class RateModel {
    
	public boolean createRate(Rate rate) {
        if (rate!=null) {
            HidroDialogFactory hdf = HidroDialogFactory.getInstance();
            HidroDialog dialog = hdf.getDialog(HidroDialogFactory.RATE_DETAILS);
            IEntityView emDialog = (IEntityView)dialog;
            emDialog.setEntity(rate);
            emDialog.setMode(Constant.VIEW_MODE_CREATION);        
            HidroconApp.getApplication().show(dialog);

            if (emDialog.isEntityUpdated()) {
                RateManager ratesManager = new RateManager();
                ratesManager.createRate(rate);
                return true;
            }
        }
        return false;
	}
    
    public void showMessageRateCreated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("rate.message.dialog.create"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);                    
    }
    
	public boolean updateRate(Rate rate) {
		if (rate!=null) {	
            HidroDialogFactory hdf = HidroDialogFactory.getInstance();
            HidroDialog dialog = hdf.getDialog(HidroDialogFactory.RATE_DETAILS);
            IEntityView emDialog = (IEntityView)dialog;
			emDialog.setEntity(rate);
            emDialog.setMode(Constant.VIEW_MODE_READONLY);
			HidroconApp.getApplication().show(dialog);
            
			if (emDialog.isEntityUpdated()) {
				RateManager rateManager = new RateManager();
				rateManager.updateRate(rate);
                return true;
			}
		}
        return false;
    }
    
    public void showMessageRateUpdated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("rate.message.dialog.edit"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);         
    }
    
	public boolean deleteRate(Rate rate) {
		if (rate!=null) {
			org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
			Object[] options = { resourceMap.getString("message.dialog.yes"), resourceMap.getString("message.dialog.no") };
			int optionSelected = JOptionPane.showOptionDialog(null, resourceMap.getString("rate.message.dialog.delete.question"), "Atención",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				null, options, options[0]);

			if (optionSelected == 0) {
				RateManager rateManager = new RateManager();
				rateManager.deleteRate(rate);
                return true;
			}
		}
        return false;
	}
    
    public void showMessageRateDeleted() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("rate.message.dialog.delete"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);         
    }
    
}
