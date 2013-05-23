/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.administrator.details;

import hidrocon.HidroconView;
import hidrocon.core.generic.pattern.observer.AppEvent;
import hidrocon.core.pattern.mvc.HidroModel;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.webservice.Administrator;
import hidrocon.webservice.HidroconWS;
import hidrocon.webservice.HidroconWS_Service;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author David Sáenz Tagarro
 */
public class AdministratorDetailsModel extends HidroModel {
    
    private class CreateAdministratorWorker extends SwingWorker<Administrator,Void> {

        Administrator administrator = null;

        public CreateAdministratorWorker(Administrator administrator) {
            this.administrator = administrator;
        }
        
        @Override
        protected Administrator doInBackground() throws Exception {
            HidroconWS_Service service = new HidroconWS_Service();
            HidroconWS port = service.getHidroconWSPort();
            port.createAdministrator(administrator);
            return administrator;
        }
        
        @Override
        public void done() {
            AppEvent message = null;
            try {
                message = new AppEvent(ObservableActionKey.INFO_CREATED,get());
            } catch (InterruptedException ex) {
                Logger.getLogger(AdministratorDetailsModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(AdministratorDetailsModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            notifyController(message);
        }
    }

    public void createAdministrator(Administrator Administrator) {
        CreateAdministratorWorker worker = new CreateAdministratorWorker(Administrator);
        worker.execute();
    }
     
    public void showMessageAdministratorCreated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("administrator.message.dialog.create"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);            
    }
    
    private class UpdateAdministratorWorker extends SwingWorker<Void,Void> {

        Administrator administrator = null;

        public UpdateAdministratorWorker(Administrator administrator) {
            this.administrator = administrator;
        }
        
        @Override
        protected Void doInBackground() throws Exception {
            HidroconWS_Service service = new HidroconWS_Service();
            HidroconWS port = service.getHidroconWSPort();
            port.updateAdministrator(administrator);
            return null;
        }
        
        @Override
        public void done() {
            AppEvent message = null;
            try {
                message = new AppEvent(ObservableActionKey.INFO_UPDATED,get());
            } catch (InterruptedException ex) {
                Logger.getLogger(AdministratorDetailsModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(AdministratorDetailsModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            notifyController(message);
        }
    }

    public void updateAdministrator(Administrator Administrator) {
        UpdateAdministratorWorker worker = new UpdateAdministratorWorker(Administrator);
        worker.execute();
    }    

    public void showMessageAdministratorUpdated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("administrator.message.dialog.edit"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]); 
    }
    
}
