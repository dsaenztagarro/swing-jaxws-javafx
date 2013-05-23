/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.route.date;

import hidrocon.HidroconApp;
import hidrocon.HidroconView;
import hidrocon.core.database.route.entities.Route;
import hidrocon.core.database.routedate.entities.RouteDate;
import hidrocon.core.database.routedate.manager.RouteDateManager;
import hidrocon.core.utils.HidroStatus;
import hidrocon.custom.Constant;
import hidrocon.custom.dialog.HidroDialog;
import hidrocon.custom.dialog.interfaces.IEntityView;
import hidrocon.custom.dialog.interfaces.ISelector;
import hidrocon.custom.utils.HidroDialogFactory;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author David Sáenz Tagarro
 */
public class RouteDatePanelModel {
    
	public int createRouteDate(Route route) {
        HidroDialogFactory hdf = HidroDialogFactory.getInstance();
        HidroDialog dialog = hdf.getDialog(HidroDialogFactory.DATE_SELECTION);
        ISelector isDialog = (ISelector)dialog;
        HidroconApp.getApplication().show(dialog);

        if (isDialog.isSelection()) {
            Date dateSelected = (Date)isDialog.getSelection();
            RouteDateManager rdm = new RouteDateManager();
            if (!rdm.contains(route.getId(),dateSelected)) {
                RouteDate routedate =  new RouteDate();
                routedate.setRouteId(route.getId());
                routedate.setReadingDate(dateSelected); 
                routedate.setStatusId(HidroStatus.METER_READING_EDITABLE);
                rdm.createRouteDate(routedate);
                return 0;
            } else {
                return 1;
            }
        }
        return -1;
	}
    
    public void showMessageRouteDateCreated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("routedate.message.dialog.create"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);                    
    }

    public void showMessageErrorRouteDateCreated(int error) {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        String message = "";
        if (error == 1) {
            message = resourceMap.getString("routedate.message.dialog.create.error.contains");
        }
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, message, resourceMap.getString("message.attention"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
            null, options, options[0]);                
    }
    
    public List getRouteDateList(Route route) {
        RouteDateManager rdm = new RouteDateManager();
        return rdm.getAllRouteDate(route.getId());
    }
    
	public boolean deleteRouteDate(RouteDate routeDate) {
        if (routeDate != null) {
			org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
			Object[] options = { resourceMap.getString("message.dialog.yes"), resourceMap.getString("message.dialog.no") };
			int optionSelected = JOptionPane.showOptionDialog(null, resourceMap.getString("routedate.message.dialog.delete.question"), "Atención",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				null, options, options[0]);

			if (optionSelected == 0) {
                RouteDateManager rdm = new RouteDateManager();
                rdm.deleteRouteDate(routeDate);
                return true;
            }
        }
        return false;
	}
    
    public void showMessageRouteDateDeleted() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options2 = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("routedate.message.dialog.delete"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options2, options2[0]);                        
    }
    
    public void updateRouteBuildingDate(RouteDate routeDate) {
		if (routeDate != null) {
            HidroDialogFactory hdf = HidroDialogFactory.getInstance();
            HidroDialog dialog = hdf.getDialog(HidroDialogFactory.ROUTE_BUILDING_DATE_DETAILS);
            IEntityView emDialog = (IEntityView)dialog;
            emDialog.setEntity(routeDate);
            emDialog.setMode(Constant.VIEW_MODE_READONLY);  
            HidroconApp.getApplication().show(dialog);
            
  			if (emDialog.isEntityUpdated()) {

            }
        }
    }    
    
}
