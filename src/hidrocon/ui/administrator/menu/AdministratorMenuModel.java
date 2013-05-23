/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.administrator.menu;

import hidrocon.HidroconApp;
import hidrocon.HidroconView;
import hidrocon.core.generic.pattern.observer.AppEvent;
import hidrocon.core.pattern.mvc.HidroModel;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.custom.dialog.HidroDialog;
import hidrocon.custom.dialog.interfaces.IEntityView;
import hidrocon.custom.utils.HidroDialogFactory;
import hidrocon.webservice.HidroconWS;
import hidrocon.webservice.HidroconWS_Service;
import hidrocon.webservice.Administrator;
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
public class AdministratorMenuModel extends HidroModel {
    
    private class SearchAdministratorWorker extends SwingWorker<List,Void> {

        Administrator administrator = null;

        public SearchAdministratorWorker(Administrator administrator) {
            this.administrator = administrator;
        }
        
        @Override
        protected List doInBackground() throws Exception {
            HidroconWS_Service service = new HidroconWS_Service();
            HidroconWS port = service.getHidroconWSPort();
            hidrocon.webservice.Administrator wsadministrator = new hidrocon.webservice.Administrator();
            wsadministrator.setId(administrator.getId());
            List<hidrocon.webservice.Administrator> administratorList = port.getAllAdministrators();
            return administratorList;
        }
        
        @Override
        public void done() {
            AppEvent message = null;
            try {
                message = new AppEvent(ObservableActionKey.SEARCH_INFO,get());
            } catch (InterruptedException ex) {
                Logger.getLogger(AdministratorMenuModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(AdministratorMenuModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            notifyController(message);
        }
    }
    
    public void searchAdministrator(Administrator administrator) {
        SearchAdministratorWorker worker = new SearchAdministratorWorker(administrator);
        worker.execute();
    }    
    
    private class DeleteAdministratorWorker extends SwingWorker<Void,Void> {

        Administrator administrator = null;

        public DeleteAdministratorWorker(Administrator administrator) {
            this.administrator = administrator;
        }
        
        @Override
        protected Void doInBackground() throws Exception {
            HidroconWS_Service service = new HidroconWS_Service();
            HidroconWS port = service.getHidroconWSPort();
            port.deleteAdministrator(administrator);
            return null;
        }
        
        @Override
        public void done() {
            AppEvent message = null;
            try {
                message = new AppEvent(ObservableActionKey.SEARCH_INFO,get());
            } catch (InterruptedException ex) {
                Logger.getLogger(AdministratorMenuModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(AdministratorMenuModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            notifyController(message);
        }
    }    
    
    public void deleteAdministrator(Administrator administrator) {
        if (administrator != null) {
            org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
            Object[] options = { resourceMap.getString("message.dialog.yes"), resourceMap.getString("message.dialog.no") };
            int optionSelected = JOptionPane.showOptionDialog(null, resourceMap.getString("administrator.message.dialog.delete.question"), "Atención",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);

            if (optionSelected == 0) {        
                DeleteAdministratorWorker worker = new DeleteAdministratorWorker(administrator);
                worker.execute();
            }
        }
    }
    
    public void showMessageAdministratorDeleted() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("administrator.message.dialog.delete"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]); 
    }
    
    public void showPopupAdministratorDetails(int mode, Administrator administrator) {
        HidroDialogFactory hdf = HidroDialogFactory.getInstance();
        HidroDialog dialog = hdf.getDialog(HidroDialogFactory.ADMINISTRATOR_DETAILS);
        IEntityView emDialog = (IEntityView)dialog;
        emDialog.setEntity(administrator);
        emDialog.setMode(mode);        
        HidroconApp.getApplication().show(dialog);
    }
    
}
