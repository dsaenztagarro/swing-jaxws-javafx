/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.neighbour.main;

import hidrocon.HidroconApp;
import hidrocon.HidroconView;
import hidrocon.core.pattern.mvc.HidroModel;
import hidrocon.core.pattern.observer.AppEvent;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.custom.Constant;
import hidrocon.custom.dialog.HidroDialog;
import hidrocon.custom.dialog.interfaces.IEntityView;
import hidrocon.custom.utils.HidroDialogFactory;
import hidrocon.webservice.Building;
import hidrocon.webservice.HidroconWS;
import hidrocon.webservice.HidroconWS_Service;
import hidrocon.webservice.Neighbour;
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
public class NeighbourMainPanelModel extends HidroModel {
    
    private class SearchNeighbourWorker extends SwingWorker<List,Void> {

        Building building = null;

        public SearchNeighbourWorker(Building building) {
            this.building = building;
        }
        
        @Override
        protected List doInBackground() throws Exception {
            HidroconWS_Service service = new HidroconWS_Service();
            HidroconWS port = service.getHidroconWSPort();
            hidrocon.webservice.Building wsbuilding = new hidrocon.webservice.Building();
            wsbuilding.setId(building.getId());
            List<hidrocon.webservice.Neighbour> neighbourList = port.searchNeighbour(wsbuilding);
            return neighbourList;
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
    
    public void searchNeighbour(Building building) {
        SearchNeighbourWorker worker = new SearchNeighbourWorker(building);
        worker.execute();
    }    
    
    private class DeleteNeighbourWorker extends SwingWorker<Void,Void> {

        Neighbour neighbour = null;

        public DeleteNeighbourWorker(Neighbour neighbour) {
            this.neighbour = neighbour;
        }
        
        @Override
        protected Void doInBackground() throws Exception {
            HidroconWS_Service service = new HidroconWS_Service();
            HidroconWS port = service.getHidroconWSPort();
            port.deleteNeighbour(neighbour);
            return null;
        }
        
        @Override
        public void done() {
            AppEvent message = null;
            try {
                message = new AppEvent(ObservableActionKey.INFO_DELETED,get());
            } catch (InterruptedException ex) {
                Logger.getLogger(NeighbourMainPanelModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(NeighbourMainPanelModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            notifyController(message);
        }
    }    
    
    public void deleteNeighbour(Neighbour neighbour) {
        if (neighbour != null) {
            org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
            Object[] options = { resourceMap.getString("message.dialog.yes"), resourceMap.getString("message.dialog.no") };
            int optionSelected = JOptionPane.showOptionDialog(null, resourceMap.getString("neighbour.message.dialog.delete.question"), "Atención",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);

            if (optionSelected == 0) {        
                DeleteNeighbourWorker worker = new DeleteNeighbourWorker(neighbour);
                worker.execute();
            }
        }
    }
    
    public void showMessageNeighbourDeleted() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("neighbour.message.dialog.delete"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]); 
    }
 
    public void showPopupNeighbourDetails(int mode, Neighbour neighbour) {
        HidroDialogFactory hdf = HidroDialogFactory.getInstance();
        HidroDialog dialog = hdf.getDialog(HidroDialogFactory.ADMINISTRATOR_DETAILS);
        IEntityView emDialog = (IEntityView)dialog;
        emDialog.setEntity(neighbour);
        emDialog.setMode(mode);        
        HidroconApp.getApplication().show(dialog);
    }
}
