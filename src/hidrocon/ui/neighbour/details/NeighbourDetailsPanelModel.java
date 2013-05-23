/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.neighbour.details;

import hidrocon.HidroconView;

import hidrocon.core.generic.pattern.observer.AppEvent;
import hidrocon.core.pattern.mvc.HidroModel;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.ui.neighbour.main.NeighbourMainPanelModel;
import hidrocon.webservice.HidroconWS;
import hidrocon.webservice.HidroconWS_Service;
import hidrocon.webservice.Neighbour;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author David Sáenz Tagarro
 */
public class NeighbourDetailsPanelModel extends HidroModel {
    
    private class CreateNeighbourWorker extends SwingWorker<Neighbour,Void> {

        Neighbour neighbour = null;

        public CreateNeighbourWorker(Neighbour neighbour) {
            this.neighbour = neighbour;
        }
        
        @Override
        protected Neighbour doInBackground() throws Exception {
            HidroconWS_Service service = new HidroconWS_Service();
            HidroconWS port = service.getHidroconWSPort();
            port.createNeighbour(neighbour);
            return neighbour;
        }
        
        @Override
        public void done() {
            AppEvent message = null;
            try {
                message = new AppEvent(ObservableActionKey.INFO_CREATED,get());
            } catch (InterruptedException ex) {
                Logger.getLogger(NeighbourMainPanelModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(NeighbourMainPanelModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            notifyController(message);
        }
    }

    public void createNeighbour(Neighbour neighbour) {
        CreateNeighbourWorker worker = new CreateNeighbourWorker(neighbour);
        worker.execute();
    }
     
    public void showMessageNeighbourCreated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("neighbour.message.dialog.create"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);            
    }
    
    private class UpdateNeighbourWorker extends SwingWorker<Void,Void> {

        Neighbour neighbour = null;

        public UpdateNeighbourWorker(Neighbour neighbour) {
            this.neighbour = neighbour;
        }
        
        @Override
        protected Void doInBackground() throws Exception {
            HidroconWS_Service service = new HidroconWS_Service();
            HidroconWS port = service.getHidroconWSPort();
            port.updateNeighbour(neighbour);
            return null;
        }
        
        @Override
        public void done() {
            AppEvent message = null;
            try {
                message = new AppEvent(ObservableActionKey.INFO_UPDATED,get());
            } catch (InterruptedException ex) {
                Logger.getLogger(NeighbourMainPanelModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(NeighbourMainPanelModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            notifyController(message);
        }
    }

    public void updateNeighbour(Neighbour neighbour) {
        UpdateNeighbourWorker worker = new UpdateNeighbourWorker(neighbour);
        worker.execute();
    }    

    public void showMessageNeighbourUpdated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("neighbour.message.dialog.edit"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]); 
    }
    
}
