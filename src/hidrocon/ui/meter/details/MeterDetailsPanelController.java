/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.meter.details;

import hidrocon.core.database.meter.entities.Meter;
import hidrocon.core.database.meterreading.entities.MeterReading;
import hidrocon.core.database.metertype.entities.MeterType;
import hidrocon.core.pattern.mvc.HidroController;
import hidrocon.core.utils.ActionKey;
import hidrocon.custom.Constant;
import hidrocon.custom.field.HidroDateField;
import hidrocon.custom.field.HidroIntegerField;
import hidrocon.custom.field.HidroTextField;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

/**
 *
 * @author David Sáenz Tagarro
 */
public class MeterDetailsPanelController extends HidroController {
    
    private JDialog dialog;
    
    private MeterType meterType;
    private Meter meter;
    private MeterReading meterReading;
    
    private MeterDetailsPanelView view;
    private MeterDetailsPanelModel model;
    
    public MeterDetailsPanelController(MeterDetailsPanelModel model, MeterDetailsPanelView view) {
        this.view = view;
        this.model = model;
        
        view.addController(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Object object = evt.getSource();
        
        if (object instanceof HidroTextField) {
            HidroTextField textField = (HidroTextField)object;
            String text = textField.getText();
            
            if (textField.getName().equals(MeterDetailsPanelView.FIELD_SERIAL_NUMBER)) {
                meter.setSerialNumber(text);
            }
        }
        else if (object instanceof HidroDateField) {
            HidroDateField dateField = (HidroDateField)object;
            Date date = (Date)dateField.getValue();
            
            if (dateField.getName().equals(MeterDetailsPanelView.FIELD_READING_DATE)) {
                meterReading.setReadingDate(date);
            }
        }
        else if (object instanceof HidroIntegerField) {
            HidroIntegerField integerField = (HidroIntegerField)object;
            int value = 0;
            if (integerField.getValue()!=null) {
                value = integerField.getValue().intValue();
            }
            
            if (integerField.getName().equals(MeterDetailsPanelView.FIELD_REGISTERED_VALUE)) {
                meterReading.setRegisteredValue(value);
            }
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if (action.equals(ActionKey.METER_DETAILS_EDIT)) {
            editMeter();
        }
        else if (action.equals(ActionKey.METER_DETAILS_SAVE)) {
            saveMeter();
        }   
        else if (action.equals(ActionKey.METER_DETAILS_CLOSE)) {
            close();
        }        
    }
    
    public void setMode(int mode) {
        if (mode == Constant.VIEW_MODE_CREATION) {
            meter = new Meter();
            meterReading = new MeterReading();
        }
        view.setMode(mode);
    }
    
    public void editMeter() {
        view.setMode(Constant.VIEW_MODE_UPDATE);
    }
    
    public void setMeterType(MeterType meterType) {
        this.meterType = meterType;
        view.writeData(meterType);
    }
    
    public void setMeter(Meter meter) {
        this.meter = meter;        
        view.writeData(meter);
    }
    
    private void saveMeter() {
        //boolean created = model.createMeter(meter);
        System.out.println("meter.id: " + meter.getId());
        model.createMeter(meter);
        /* if (created) {
            view.addComment(comment);
            model.showMessageMeterCreated();
        } */
    }
    
    private void close() {
        dialog.setVisible(false);
    }

    protected void initKeyBinding() {
                
        javax.swing.Action createAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                //createNeighbour();
            }
        };   
        
        javax.swing.Action updateAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                //updateNeighbour();
            }
        };        

        javax.swing.Action deleteAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                //deleteNeighbour();
            }
        };        
        
        JPanel mainPanel = view.getMainPanel();
        
        SwingUtilities.replaceUIActionMap(mainPanel, null);
        SwingUtilities.replaceUIInputMap(mainPanel, JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT, null);
        
        InputMap inputMap = mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke("F10"),"editNeighbour_F10");        
        inputMap.put(KeyStroke.getKeyStroke("F11"),"saveNeighbour_F11");
        inputMap.put(KeyStroke.getKeyStroke("F12"),"closeNeighbour_F12");
        
        mainPanel.getActionMap().put("createNeighbour_F10",createAction);
        mainPanel.getActionMap().put("udateNeighbour_F11",updateAction);
        mainPanel.getActionMap().put("deleteNeighbour_F12",deleteAction);        
    }     
    
    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }
    
}
