/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.route.routebuildingdate;

import hidrocon.HidroconApp;
import hidrocon.HidroconView;
import hidrocon.core.database.building.entities.Building;
import hidrocon.core.database.building.manager.BuildingManager;
import hidrocon.core.database.routebuildingdate.entities.RouteBuildingDateView;
import hidrocon.core.database.routebuildingdate.manager.RouteBuildingDateManager;
import hidrocon.core.database.routedate.entities.RouteDate;
import hidrocon.custom.Constant;
import hidrocon.custom.dialog.HidroDialog;
import hidrocon.custom.dialog.interfaces.IEntityView;
import hidrocon.custom.utils.HidroDialogFactory;
import hidrocon.custom.utils.OrderedListUtils;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author David Sáenz Tagarro
 */
public class RouteBuildingDateDetailsModel {
    
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
    
    public List getRouteBuildingDateList(int routeDateId) {
        RouteBuildingDateManager rbdm = new RouteBuildingDateManager();
        List<RouteBuildingDateView> list = rbdm.getRouteBuildingDateList(routeDateId);
        return list;
        
    }
	public int changeRouteBuildingDateOrder(List<RouteBuildingDateView> routeBuildingDateList, int indexSelected, int moveDirection) {
        if (indexSelected > -1) {
            int newIndexSelected = OrderedListUtils.changeOrder(routeBuildingDateList, indexSelected, moveDirection);
            return newIndexSelected;
        }
        return -1;
	}   
    
    public void showMessageRouteBuildingUpdated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options2 = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("routebuildingdate.message.dialog.update"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options2, options2[0]);                
    }
    
    public void updateRouteBuildingDateList(RouteDate routeDate, List<RouteBuildingDateView> routeBuildingDateList) {
        RouteBuildingDateManager rbdm = new RouteBuildingDateManager();
        rbdm.updateRouteBuildingDate(routeDate.getId(), routeBuildingDateList);
    }
    
}
