/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.route.building;

import hidrocon.HidroconApp;
import hidrocon.HidroconView;
import hidrocon.core.database.building.entities.Building;
import hidrocon.core.database.route.entities.Route;
import hidrocon.core.database.routebuilding.entities.RouteBuilding;
import hidrocon.core.database.routebuilding.entities.RouteBuildingPK;
import hidrocon.core.database.routebuilding.entities.RouteBuildingView;
import hidrocon.core.database.routebuilding.manager.RouteBuildingManager;
import hidrocon.custom.Constant;
import hidrocon.custom.dialog.HidroDialog;
import hidrocon.custom.dialog.interfaces.ISelector;
import hidrocon.custom.utils.HidroDialogFactory;
import hidrocon.custom.utils.OrderedListUtils;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author David Sáenz Tagarro
 */
public class RouteBuildingPanelModel {
    
    public List getRouteBuildingList(Route route) {
        RouteBuildingManager rdm = new RouteBuildingManager();
        return rdm.getRouteBuildingViewList(route.getId());
    }
    
	public boolean createRouteBuilding(Route routeSelected, int routeBuildingListSize) {
        if (routeSelected!=null) {
            Route route = new Route();
            route.setRecStatus(Constant.RECORD_STATUS_ACTIVE);

            HidroDialogFactory hdf = HidroDialogFactory.getInstance();
            HidroDialog dialog = hdf.getDialog(HidroDialogFactory.ROUTE_BUILDING_SELECTION);
            ISelector isDialog = (ISelector)dialog;
            HidroconApp.getApplication().show(dialog);

            if (isDialog.isSelection()) {
                RouteBuildingManager rbm = new RouteBuildingManager();
                java.util.List<Building> buildingListSelection = (java.util.List<Building>)isDialog.getSelection();
                int count = routeBuildingListSize;
                for (Building building : buildingListSelection) {
                    count++;
                    RouteBuilding rb = new RouteBuilding();
                    RouteBuildingPK rbPK = new RouteBuildingPK(routeSelected.getId(), building.getId());
                    rb.setRouteBuildingPK(rbPK);
                    rb.setOrderId(count);

                    rbm.createRouteBuilding(rb);
                }
                return true;
            }            
        }
        return false;
	}
    
    public void showMessageRouteBuildingCreated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("routebuilding.message.dialog.create"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);            
    }
    
	public boolean deleteRouteBuilding(RouteBuildingView rbv) {
		if (rbv != null) {
			org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
			Object[] options = { resourceMap.getString("message.dialog.yes"), resourceMap.getString("message.dialog.no") };
			int optionSelected = JOptionPane.showOptionDialog(null, resourceMap.getString("routebuilding.message.dialog.delete.question"), "Atención",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				null, options, options[0]);

			if (optionSelected == 0) {
                RouteBuildingManager rbm = new RouteBuildingManager();
                int rows = rbm.deleteRouteBuilding(rbv.getRouteBuildingPK(), rbv.getOrderId());

                if (rows>0) {
                    return true;
                }
            }
		}
        return false;
	}    
    
    public void showMessageRouteBuildingDeleted() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options2 = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("routebuilding.message.dialog.delete"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options2, options2[0]);                
    }
    
	public int changeRouteBuildingOrder(List<RouteBuildingView> routeBuildingList, int indexSelected, int moveDirection) {
        if (indexSelected > -1) {
            int newIndexSelected = OrderedListUtils.changeOrder(routeBuildingList, indexSelected, moveDirection);
            return newIndexSelected;
        }
        return -1;
	}   
    
    public void updateRouteBuildingList(Route route, List<RouteBuildingView> routeBuildingList) {
        RouteBuildingManager rbm = new RouteBuildingManager();
        rbm.updateRouteBuildingList(route.getId(), routeBuildingList);
    }

    public void showMessageRouteBuildingUpdated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options2 = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("routebuilding.message.dialog.update"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options2, options2[0]);                
    }
    
}
