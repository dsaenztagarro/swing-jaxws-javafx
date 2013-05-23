/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.rate.panels.details;

import hidrocon.core.generic.pattern.observer.AppEvent;
import hidrocon.core.pattern.mvc.HidroController;
import hidrocon.core.utils.ActionKey;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.custom.Constant;
import hidrocon.webservice.Rate;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Observable;
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
public class RateDetailsController extends HidroController {
    
    private int mode;
    private JDialog dialog;
    private Rate rate;
    
    private RateDetailsModel model;
    private RateDetailsView view;
    
    public RateDetailsController(RateDetailsModel model, RateDetailsView view) {
        this.model = model;
        this.view = view;
        view.buttonActionListeners(this);
        initKeyBinding();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
        if (action.equals(ActionKey.RATE_DETAILS_EDIT)) {
            editRate();
        }        
        else if (action.equals(ActionKey.RATE_DETAILS_SAVE)) {
            saveRate();
        }
        else if (action.equals(ActionKey.RATE_DETAILS_CLOSE)) {
            close();
        }        
    }

    @Override
    public void update(Observable o, Object arg) {
        AppEvent message = (AppEvent)arg;
        String action = message.getEventName();
        Object argument = message.getArgument();
        
        if (o instanceof RateDetailsModel) {
            if (action.equals(ObservableActionKey.INFO_CREATED)) {
                showMessageRateCreated();
            }
            else if (action.equals(ObservableActionKey.INFO_UPDATED)) {
                showMessageRateUpdated();
            }
        }
    }
    
    public void showMessageRateCreated() {
        model.showMessageRateCreated();
        close();
    }
    
    public void showMessageRateUpdated() {
        model.showMessageRateUpdated();
        close();
    }
    
    public void setRate(Rate rate) {
        this.rate = rate;
        
        view.writeData(rate);
    }
    
    private void editRate() {
        view.setMode(Constant.VIEW_MODE_UPDATE);
    }
    
    private void saveRate() {
        view.readData(rate);
        if (mode == Constant.VIEW_MODE_CREATION) {
            model.createRate(rate);
        }
        else if (mode == Constant.VIEW_MODE_UPDATE) {
            model.updateRate(rate);
        }
    }
    
    private void close() {
        if (dialog!=null) {
            dialog.setVisible(false);
        }
    }
    
    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }
    
    protected void initKeyBinding() {
        javax.swing.Action editAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                editRate();
            }
        };   
        
        javax.swing.Action saveAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                saveRate();
            }
        };        

        javax.swing.Action closeAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                close();
            }
        };        
        
        JPanel mainPanel = view.getMainPanel();
        
        SwingUtilities.replaceUIActionMap(mainPanel, null);
        SwingUtilities.replaceUIInputMap(mainPanel, JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT, null);
        
        InputMap inputMap = mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke("F10"),"editRate_F10");        
        inputMap.put(KeyStroke.getKeyStroke("F11"),"saveRate_F11");
        inputMap.put(KeyStroke.getKeyStroke("F12"),"closeRate_F12");
        mainPanel.getActionMap().put("editRate_F10",editAction);
        mainPanel.getActionMap().put("saveRate_F11",saveAction);
        mainPanel.getActionMap().put("closeRate_F12",closeAction);        
    } 
    
}
