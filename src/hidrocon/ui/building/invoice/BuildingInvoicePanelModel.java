/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.building.invoice;

import hidrocon.HidroconApp;
import hidrocon.HidroconView;
import hidrocon.core.database.building.entities.Building;
import hidrocon.core.database.neighbour.entities.Neighbour;
import hidrocon.core.database.neighbour.manager.NeighbourManager;
import hidrocon.custom.Constant;
import hidrocon.custom.dialog.HidroDialog;
import hidrocon.custom.dialog.interfaces.IEntityView;
import hidrocon.custom.utils.HidroDialogFactory;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author David Sáenz Tagarro
 */
public class BuildingInvoicePanelModel {
    
    public List getNeighbourList(Building building) {
        List list = null;
        if (building!=null) {
            NeighbourManager nm = new NeighbourManager();
            list = nm.getNeighbourList(building.getId());
        }
        return list;
    }
    
	public boolean createNeighbour(Neighbour neighbour) {
        HidroDialogFactory hdf = HidroDialogFactory.getInstance();
        HidroDialog dialog = hdf.getDialog(HidroDialogFactory.NEIGHBOUR_DETAILS);
        IEntityView emDialog = (IEntityView)dialog;
        emDialog.setEntity(neighbour);
        emDialog.setMode(Constant.VIEW_MODE_CREATION);        
        HidroconApp.getApplication().show(dialog);

		if (emDialog.isEntityUpdated()) {
			NeighbourManager neighboursManager = new NeighbourManager();
			neighboursManager.createNeighbour(neighbour);
            return true;
		}
        return false;
	}   
    
    public void showMessageNeighbourCreated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("neighbour.message.dialog.create"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);            
    }
    
	public boolean updateNeighbour(Neighbour neighbour) {
		if (neighbour != null) {
            HidroDialogFactory hdf = HidroDialogFactory.getInstance();
            HidroDialog dialog = hdf.getDialog(HidroDialogFactory.NEIGHBOUR_DETAILS);
            IEntityView emDialog = (IEntityView)dialog;
			emDialog.setEntity(neighbour);
            emDialog.setMode(Constant.VIEW_MODE_READONLY);
			HidroconApp.getApplication().show(dialog);
            
			if (emDialog.isEntityUpdated()) {
				NeighbourManager buildingManager = new NeighbourManager();
				buildingManager.updateNeighbour(neighbour);
                return true;
			}
		}
        return false;
	}

    public void showMessageNeighbourUpdated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("neighbour.message.dialog.edit"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]); 
    }
    
	public boolean deleteNeighbour(Neighbour neighbour) {
		if (neighbour != null) {
			org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
			Object[] options = { resourceMap.getString("message.dialog.yes"), resourceMap.getString("message.dialog.no") };
			int optionSelected = JOptionPane.showOptionDialog(null, resourceMap.getString("neighbour.message.dialog.delete.question"), "Atención",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				null, options, options[0]);

			if (optionSelected == 0) {
				NeighbourManager neighbourManager = new NeighbourManager();
				neighbourManager.deleteNeighbour(neighbour);
                return true;
			}
		}
        return false;
	}

    public void showMessageNeighbourDeleted() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("neighbour.message.dialog.delete"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]); 
    }
    
    public List getNeighbourMeterReadingList(Neighbour neighbour) {
        List list = null;
        if (neighbour!=null) {
            NeighbourManager nm = new NeighbourManager();
            HashMap parameters = new HashMap();
            parameters.put("neighbourId",String.valueOf(neighbour.getId()));
            list = nm.getNeighbourMeterReadingList(parameters);
        }
        return list;
    }
    
    public List getNeighbourMeterViewList(Neighbour neighbour) {
        List list = null;
        if (neighbour!=null) {
            NeighbourManager nm = new NeighbourManager();
            list = nm.getNeighbourMeterViewList(neighbour.getId());
        }
        return list;        
    }
}
