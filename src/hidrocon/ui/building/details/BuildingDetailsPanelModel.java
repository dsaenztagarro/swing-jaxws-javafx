/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.building.details;

import hidrocon.HidroconApp;
import hidrocon.HidroconView;
import hidrocon.core.generic.pattern.observer.AppEvent;
import hidrocon.core.pattern.mvc.HidroModel;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.custom.Constant;
import hidrocon.custom.dialog.HidroDialog;
import hidrocon.custom.dialog.interfaces.IEntityView;
import hidrocon.custom.dialog.interfaces.ISelector;
import hidrocon.custom.utils.HidroDialogFactory;
import hidrocon.webservice.Administrator;
import hidrocon.webservice.Building;
import hidrocon.webservice.HidroconWS;
import hidrocon.webservice.HidroconWS_Service;
import hidrocon.webservice.Rate;
import java.awt.Component;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author David Sáenz Tagarro
 */
public class BuildingDetailsPanelModel extends HidroModel {
    
    private class CreateBuildingWorker extends SwingWorker<Building,Void> {

        Building building = null;

        public CreateBuildingWorker(Building building) {
            this.building = building;
        }
        
        @Override
        protected Building doInBackground() throws Exception {
            HidroconWS_Service service = new HidroconWS_Service();
            HidroconWS port = service.getHidroconWSPort();
            port.createBuilding(building);
            return building;
        }
        
        @Override
        public void done() {
            AppEvent message = null;
            try {
                message = new AppEvent(ObservableActionKey.INFO_CREATED,get());
            } catch (InterruptedException ex) {
                Logger.getLogger(BuildingDetailsPanelModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(BuildingDetailsPanelModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            notifyController(message);
        }
    }

    public void createBuilding(Building building) {
        CreateBuildingWorker worker = new CreateBuildingWorker(building);
        worker.execute();
    }
     
    public void showMessageBuildingCreated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("building.message.dialog.create"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);            
    }
    
    private class UpdateBuildingWorker extends SwingWorker<Void,Void> {

        Building building = null;

        public UpdateBuildingWorker(Building building) {
            this.building = building;
        }
        
        @Override
        protected Void doInBackground() throws Exception {
            HidroconWS_Service service = new HidroconWS_Service();
            HidroconWS port = service.getHidroconWSPort();
            port.updateBuilding(building);
            return null;
        }
        
        @Override
        public void done() {
            AppEvent message = null;
            try {
                message = new AppEvent(ObservableActionKey.INFO_UPDATED,get());
            } catch (InterruptedException ex) {
                Logger.getLogger(BuildingDetailsPanelModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(BuildingDetailsPanelModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            notifyController(message);
        }
    }

    public void updateBuilding(Building building) {
        UpdateBuildingWorker worker = new UpdateBuildingWorker(building);
        worker.execute();
    }    

    public void showMessageBuildingUpdated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("building.message.dialog.edit"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]); 
    }
    
    public void addRouteDate() {
        HidroDialogFactory hdf = HidroDialogFactory.getInstance();
        HidroDialog dialog = hdf.getDialog(HidroDialogFactory.ROUTE_DATE_SELECTION);
        HidroconApp.getApplication().show(dialog);         
        
        ISelector sDialog = (ISelector)dialog;
        if (sDialog.isSelection()) {
            Date date = (Date)sDialog.getSelection();
        }
    }
    
    public void deleteRouteDate() {
        //do nothing
    }  
        
    public void showPopupAdministratorDetails(Administrator administrator) {
        HidroDialogFactory hdf = HidroDialogFactory.getInstance();
        HidroDialog dialog = hdf.getDialog(HidroDialogFactory.BUILDING_DETAILS_ADMINISTRATOR);
        IEntityView emDialog = (IEntityView)dialog;
        emDialog.setEntity(administrator);
        emDialog.setMode(Constant.ENTITY_MANAGEMENT_MODE_SUMMARY);
        HidroconApp.getApplication().show(dialog);            
    }
    
    public void showPopupRateDetails(Rate rate) {        
        HidroDialogFactory hdf = HidroDialogFactory.getInstance();
        HidroDialog dialog = hdf.getDialog(HidroDialogFactory.BUILDING_DETAILS_RATE);
        IEntityView emDialog = (IEntityView)dialog;
        emDialog.setEntity(rate);
        emDialog.setMode(Constant.ENTITY_MANAGEMENT_MODE_SUMMARY);
        HidroconApp.getApplication().show(dialog);            
    }
    
    public Administrator updateAdministrator() {
        Administrator administrator = null;
        
        HidroDialogFactory hdf = HidroDialogFactory.getInstance();
        HidroDialog dialog = hdf.getDialog(HidroDialogFactory.ADMINISTRATOR_SELECTION);
        HidroconApp.getApplication().show(dialog);
        
        ISelector sDialog = (ISelector)dialog;
        if (sDialog.isSelection()) {
            administrator = (Administrator)sDialog.getSelection();
        }
        return administrator;
    }
    
    public void showRouteBuildingDate(Component component) {
        System.out.println("component: " + component);
    }
  
}
