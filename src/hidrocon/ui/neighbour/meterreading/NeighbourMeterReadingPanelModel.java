/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.neighbour.meterreading;

import hidrocon.core.database.neighbour.entities.Neighbour;
import hidrocon.core.database.neighbour.manager.NeighbourManager;
import hidrocon.core.generic.pattern.observer.AppEvent;
import hidrocon.core.pattern.mvc.HidroModel;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.ui.neighbour.main.NeighbourMainPanelModel;
import hidrocon.webservice.HidroconWS;
import hidrocon.webservice.HidroconWS_Service;
import hidrocon.webservice.Neighbour;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;

/**
 *
 * @author David Sáenz Tagarro
 */
public class NeighbourMeterReadingPanelModel extends HidroModel {
            
    private class SearchNeighbourMeterReadingWorker extends SwingWorker<Neighbour,Void> {

        Neighbour neighbour = null;

        public SearchNeighbourMeterReadingWorker(Neighbour neighbour) {
            this.neighbour = neighbour;
        }
        
        @Override
        protected Neighbour doInBackground() throws Exception {
            HidroconWS_Service service = new HidroconWS_Service();
            HidroconWS port = service.getHidroconWSPort();
            HashMap parameters = new HashMap();
            parameters.put("neighbourId",String.valueOf(neighbour.getId()));
            return port.getNeighbourMeterReadingList(neighbour);
        }
        
        @Override
        public void done() {
            AppEvent message = null;
            try {
                message = new AppEvent(ObservableActionKey.SEARCH_NEIGHBOUR_METER_READING,get());
            } catch (InterruptedException ex) {
                Logger.getLogger(NeighbourMainPanelModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(NeighbourMainPanelModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            notifyController(message);
        }
    }
        
    public void searchNeighbourMeterReading(Neighbour neighbour) {
        SearchNeighbourMeterReadingWorker worker = new SearchNeighbourMeterReadingWorker(neighbour);
        worker.execute();
    }

}
