/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.neighbour.details;

import hidrocon.core.generic.pattern.observer.AppEvent;
import hidrocon.core.pattern.mvc.HidroController;
import hidrocon.core.utils.ActionKey;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.custom.Constant;
import hidrocon.ui.neighbour.main.NeighbourMainPanelModel;
import hidrocon.webservice.Neighbour;
import java.awt.event.ActionEvent;
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
public class NeighbourDetailsPanelController extends HidroController {
    
    private int mode;
    
    private JDialog dialog;
    
    private Neighbour neighbour;
    
    private NeighbourDetailsPanelView view;
    private NeighbourDetailsPanelModel model;
    
    public NeighbourDetailsPanelController(NeighbourDetailsPanelModel model, NeighbourDetailsPanelView view) {
        this.view = view;
        this.model = model;
        
        view.buttonActionListeners(this);
    }
    
    public void setMode(int mode) {
        this.mode = mode;
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if (action.equals(ActionKey.NEIGHBOUR_DETAILS_EDIT)) {
            editNeighbour();
        }
        else if (action.equals(ActionKey.NEIGHBOUR_DETAILS_SAVE)) {
            saveNeighbour();
        }   
        else if (action.equals(ActionKey.NEIGHBOUR_DETAILS_CLOSE)) {
            close();
        }
        else if (action.equals(ActionKey.METER_DELETE)) {
            deleteMeter();
        }        
        else if (action.equals(ActionKey.METER_SAVE)) {
            saveMeter();
        }        
        
    }
    
    @Override
    public void update(Observable o, Object arg) {
        AppEvent message = (AppEvent)arg;
        String action = message.getEventName();
        Object argument = message.getArgument();
        
        if (o instanceof NeighbourMainPanelModel) {
            if (action.equals(ObservableActionKey.INFO_CREATED)) {
                showMessageNeighbourCreated();
            }
            else if (action.equals(ObservableActionKey.INFO_UPDATED)) {
                showMessageNeighbourUpdated();
            }
        }
    }
    
    private void saveNeighbour() {
        view.readData(neighbour);
        if (mode == Constant.VIEW_MODE_CREATION) {
            model.createNeighbour(neighbour);
        }
        else if (mode == Constant.VIEW_MODE_UPDATE) {
            model.updateNeighbour(neighbour);
        }        
    }
    
    public void setNeighbour(Neighbour neighbour) {
        this.neighbour = neighbour;        
        view.writeData(neighbour);
    }
    
    private void editNeighbour() {
        //view.set
    }
    
    private void showMessageNeighbourCreated() {
        model.showMessageNeighbourCreated();
        close();
    }
    
    private void showMessageNeighbourUpdated() {
        model.showMessageNeighbourUpdated();
        close();
    }

    private void close() {
        dialog.setVisible(false);
    }
    
    private void saveMeter() {
        
    }
    
    private void deleteMeter() {
        
    }
        
    private void printNeighbour() {
        
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
