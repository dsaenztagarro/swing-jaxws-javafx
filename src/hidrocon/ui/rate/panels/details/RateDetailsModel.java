/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.rate.panels.details;

import hidrocon.HidroconView;
import hidrocon.core.generic.pattern.observer.AppEvent;
import hidrocon.core.pattern.mvc.HidroModel;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.webservice.HidroconWS;
import hidrocon.webservice.HidroconWS_Service;
import hidrocon.webservice.Rate;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author David Sáenz Tagarro
 */
public class RateDetailsModel extends HidroModel {
    
    private class CreateRateWorker extends SwingWorker<Rate,Void> {

        Rate rate = null;

        public CreateRateWorker(Rate rate) {
            this.rate = rate;
        }
        
        @Override
        protected Rate doInBackground() throws Exception {
            HidroconWS_Service service = new HidroconWS_Service();
            HidroconWS port = service.getHidroconWSPort();
            port.createRate(rate);
            return rate;
        }
        
        @Override
        public void done() {
            AppEvent message = null;
            try {
                message = new AppEvent(ObservableActionKey.INFO_CREATED,get());
            } catch (InterruptedException ex) {
                Logger.getLogger(RateDetailsModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(RateDetailsModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            notifyController(message);
        }
    }

    public void createRate(Rate Rate) {
        CreateRateWorker worker = new CreateRateWorker(Rate);
        worker.execute();
    }
     
    public void showMessageRateCreated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("rate.message.dialog.create"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);            
    }
    
    private class UpdateRateWorker extends SwingWorker<Void,Void> {

        Rate rate = null;

        public UpdateRateWorker(Rate rate) {
            this.rate = rate;
        }
        
        @Override
        protected Void doInBackground() throws Exception {
            HidroconWS_Service service = new HidroconWS_Service();
            HidroconWS port = service.getHidroconWSPort();
            port.updateRate(rate);
            return null;
        }
        
        @Override
        public void done() {
            AppEvent message = null;
            try {
                message = new AppEvent(ObservableActionKey.INFO_UPDATED,get());
            } catch (InterruptedException ex) {
                Logger.getLogger(RateDetailsModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(RateDetailsModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            notifyController(message);
        }
    }

    public void updateRate(Rate Rate) {
        UpdateRateWorker worker = new UpdateRateWorker(Rate);
        worker.execute();
    }    

    public void showMessageRateUpdated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("rate.message.dialog.edit"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]); 
    }

}
