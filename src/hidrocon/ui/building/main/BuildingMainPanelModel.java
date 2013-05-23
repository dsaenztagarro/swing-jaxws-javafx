/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.building.main;

import hidrocon.HidroconApp;
import hidrocon.HidroconView;
import hidrocon.core.database.building.entities.Building;
import hidrocon.core.database.building.manager.BuildingManager;
import hidrocon.core.pattern.observer.AppEvent;
import hidrocon.core.pattern.mvc.HidroModel;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.custom.Constant;
import hidrocon.custom.dialog.HidroDialog;
import hidrocon.custom.dialog.interfaces.IEntityView;
import hidrocon.custom.utils.HidroDialogFactory;
import hidrocon.ui.neighbour.main.NeighbourMainPanelModel;
import hidrocon.webservice.HidroconWS;
import hidrocon.webservice.HidroconWS_Service;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author David Sáenz Tagarro
 */
public class BuildingMainPanelModel extends HidroModel {
    
    private class SearchBuildingWorker extends SwingWorker<List,Void> {
        
        @Override
        protected List doInBackground() throws Exception {
            HidroconWS_Service service = new HidroconWS_Service();
            HidroconWS port = service.getHidroconWSPort();
            List<hidrocon.webservice.Building> buildingList = port.getAllBuilding();
            return buildingList;
        }
        @Override
        public void done() {
            AppEvent message = null;
            try {
                message = new AppEvent(ObservableActionKey.SEARCH_INFO,get());
            } catch (InterruptedException ex) {
                Logger.getLogger(NeighbourMainPanelModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(NeighbourMainPanelModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            notifyController(message);
        }
    }        

    public void searchBuilding() {
        SearchBuildingWorker worker = new SearchBuildingWorker();
        worker.execute();
    }
    
	public void showNeighbourListDialog(Building building) {
        if (building!=null) {
            HidroDialogFactory hdf = HidroDialogFactory.getInstance();
            HidroDialog dialog = hdf.getDialog(HidroDialogFactory.NEIGHBOUR_LIST);
            IEntityView emDialog = (IEntityView)dialog;
            emDialog.setEntity(building);
            emDialog.setMode(Constant.ENTITY_MANAGEMENT_MODE_DEFAULT);           

            HidroconApp.getApplication().show(dialog);
        }
	}
    
	public boolean createBuilding(Building building) {
        if (building!=null) {
            HidroDialogFactory hdf = HidroDialogFactory.getInstance();
            HidroDialog dialog = hdf.getDialog(HidroDialogFactory.BUILDING_DETAILS);
            IEntityView emDialog = (IEntityView)dialog;
            emDialog.setEntity(building);
            emDialog.setMode(Constant.VIEW_MODE_CREATION);        
            HidroconApp.getApplication().show(dialog);

            if (emDialog.isEntityUpdated()) {
                BuildingManager buildingsManager = new BuildingManager();
                buildingsManager.createBuilding(building);
                return true;
            }
        }
        return false;
	}
    
    public void showMessageBuildingCreated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("building.message.dialog.create"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);                    
    }
    
	public boolean updateBuilding(Building building) {
		if (building!=null) {	
            HidroDialogFactory hdf = HidroDialogFactory.getInstance();
            HidroDialog dialog = hdf.getDialog(HidroDialogFactory.BUILDING_DETAILS);
            IEntityView emDialog = (IEntityView)dialog;
			emDialog.setEntity(building);
            emDialog.setMode(Constant.VIEW_MODE_READONLY);
			HidroconApp.getApplication().show(dialog);
            
			if (emDialog.isEntityUpdated()) {
				BuildingManager buildingManager = new BuildingManager();
				buildingManager.updateBuilding(building);
                return true;
			}
		}
        return false;
    }
    
    public void showMessageBuildingUpdated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("building.message.dialog.edit"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);         
    }
    
	public boolean deleteBuilding(Building building) {
		if (building!=null) {
			org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
			Object[] options = { resourceMap.getString("message.dialog.yes"), resourceMap.getString("message.dialog.no") };
			int optionSelected = JOptionPane.showOptionDialog(null, resourceMap.getString("building.message.dialog.delete.question"), "Atención",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				null, options, options[0]);

			if (optionSelected == 0) {
				BuildingManager buildingManager = new BuildingManager();
				buildingManager.deleteBuilding(building);
                return true;
			}
		}
        return false;
	}
    
    public void showMessageBuildingDeleted() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("building.message.dialog.delete"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);         
    }
    
}
