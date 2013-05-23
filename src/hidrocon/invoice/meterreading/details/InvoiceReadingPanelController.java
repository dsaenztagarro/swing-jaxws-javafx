/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.invoice.meterreading.details;

import hidrocon.component.meter.MeterReadingPanelView;
import hidrocon.component.meterreadingregister.MeterReadingRegisterView;
import hidrocon.component.neighbour.NeighbourPanelView;
import hidrocon.core.database.building.entities.Building;
import hidrocon.core.database.neighbour.entities.Neighbour;
import hidrocon.core.database.neighbourmeter.entities.NeighbourMeterView;
import hidrocon.core.database.neighbourmeterreading.entities.NeighbourMeterReadingView;
import hidrocon.core.pattern.mvc.HidroController;
import hidrocon.core.pattern.observer.AppEvent;
import hidrocon.core.utils.ActionKey;
import hidrocon.core.utils.ObservableActionKey;
import hidroconfx.invoice.InvoiceReadingFXController;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javafx.application.Platform;

/**
 *
 * @author David Sáenz Tagarro
 */
public class InvoiceReadingPanelController extends HidroController {
    
    private Building building;
    
    private InvoiceReadingPanelView view;
    private InvoiceReadingPanelModel model;
    
    public InvoiceReadingPanelController(InvoiceReadingPanelModel model, InvoiceReadingPanelView view) {
        this.view = view;
        this.model = model;
        
        view.addController(this);
    }

    /*
     * Process events from InvoiceReadingPanelView component
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
          
        if (action.equals(ActionKey.NEIGHBOUR_DETAILS_EDIT)) {
            //editNeighbour();
        }
        else if (action.equals(ActionKey.NEIGHBOUR_DETAILS_SAVE)) {
            //saveNeighbour();
        }   
        else if (action.equals(ActionKey.METER_DELETE)) {
            //deleteMeter();
        }        
        else if (action.equals(ActionKey.METER_SAVE)) {
            //saveMeter();
        }                
    }

    @Override
    public void update(Observable o, Object arg) {
        AppEvent message = (AppEvent)arg;
        String action = message.getEventName();

        if (o instanceof InvoiceReadingFXController) {
            if (action.equals(ObservableActionKey.FX2SWING_SAVE_NEIGHBOUR_READING)) {
                System.out.println("FX Event!!!");
            }
            else if (action.equals(ObservableActionKey.FX2SWING_SAVE_NEIGHBOUR_READING)) {
                System.out.println("FX Event!!!");
            }
        }
    }
    
    private void notifyFXPanel() {
        Platform.runLater(new Runnable() { 
            @Override
            public void run() {
                //fxlabel.setText("Swing button clicked!"); 
            }
        });        
    }
    
    public void setBuilding(Building building) {
        this.building = building;
        
        //view.removeAllMeterReadingRegisters();
        InvoiceReadingPanelModel model = new InvoiceReadingPanelModel();
        List<Neighbour> neighbourList = model.getBuildingNeighbourList(building);
        for (Neighbour neighbour : neighbourList) {
            NeighbourPanelView neighbourPanelView = new NeighbourPanelView();
            neighbourPanelView.writeData(neighbour);
            
            List<NeighbourMeterReadingView> nmrList = model.getNeighbourMeterReadingList(neighbour);

            
            List<NeighbourMeterView> nmvList = model.getNeighbourMeterViewList(neighbour);
            List<MeterReadingPanelView> meterReadingPanelViewList = new ArrayList();;
            for (NeighbourMeterView nmv : nmvList) {
                MeterReadingPanelView meterReadingPanelView = new MeterReadingPanelView();
                meterReadingPanelView.buttonActionListeners(this);
                meterReadingPanelView.writeData(nmv);
                meterReadingPanelViewList.add(meterReadingPanelView);

                MeterReadingPanelView meterReadingPanelView2 = new MeterReadingPanelView();
                meterReadingPanelView2.buttonActionListeners(this);
                meterReadingPanelView2.writeData(nmv);
                meterReadingPanelViewList.add(meterReadingPanelView2);                
            }
            
            MeterReadingRegisterView register = new MeterReadingRegisterView();
            register.writeData(neighbourPanelView, meterReadingPanelViewList);
            //view.addMeterReadingRegister(register);
        }
    }
    
}
