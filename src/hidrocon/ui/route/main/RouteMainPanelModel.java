/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.route.main;

import hidrocon.HidroconApp;
import hidrocon.HidroconView;
import hidrocon.core.database.route.entities.Route;
import hidrocon.core.database.route.manager.RouteManager;
import hidrocon.custom.Constant;
import hidrocon.custom.dialog.HidroDialog;
import hidrocon.custom.dialog.interfaces.IEntityView;
import hidrocon.custom.utils.HidroDialogFactory;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author David Sáenz Tagarro
 */
public class RouteMainPanelModel {
    
    public List getAllRoute() {
        RouteManager routeManager = new RouteManager();
        return routeManager.getAllRoute();
    }
    
    public Route getRoute(int id) {
        RouteManager rm = new RouteManager();
        return rm.getRoute(id);
    }
    
	public boolean createRoute(Route route) {
        if (route!=null) {
            HidroDialogFactory hdf = HidroDialogFactory.getInstance();
            HidroDialog dialog = hdf.getDialog(HidroDialogFactory.ROUTE_DETAILS);
            IEntityView emDialog = (IEntityView)dialog;
            emDialog.setEntity(route);
            emDialog.setMode(Constant.VIEW_MODE_CREATION);        
            HidroconApp.getApplication().show(dialog);

            if (emDialog.isEntityUpdated()) {
                RouteManager routesManager = new RouteManager();
                routesManager.createRoute(route);
                return true;
            }
        }
        return false;
	}
    
    public void showMessageRouteCreated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("route.message.dialog.create"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);                    
    }
    
	public boolean updateRoute(Route route) {
		if (route!=null) {	
            HidroDialogFactory hdf = HidroDialogFactory.getInstance();
            HidroDialog dialog = hdf.getDialog(HidroDialogFactory.ROUTE_DETAILS);
            IEntityView emDialog = (IEntityView)dialog;
			emDialog.setEntity(route);
            emDialog.setMode(Constant.VIEW_MODE_READONLY);
			HidroconApp.getApplication().show(dialog);
            
			if (emDialog.isEntityUpdated()) {
				RouteManager routeManager = new RouteManager();
				routeManager.updateRoute(route);
                return true;
			}
		}
        return false;
    }
    
    public void showMessageRouteUpdated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("route.message.dialog.edit"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);         
    }
    
	public boolean deleteRoute(Route route) {
		if (route!=null) {
			org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
			Object[] options = { resourceMap.getString("message.dialog.yes"), resourceMap.getString("message.dialog.no") };
			int optionSelected = JOptionPane.showOptionDialog(null, resourceMap.getString("route.message.dialog.delete.question"), "Atención",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				null, options, options[0]);

			if (optionSelected == 0) {
				RouteManager routeManager = new RouteManager();
				routeManager.deleteRoute(route);
                return true;
			}
		}
        return false;
	}
    
    public void showMessageRouteDeleted() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("route.message.dialog.delete"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);         
    }
    
    
}
