/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.neighbour.meterreading;

import hidrocon.core.database.neighbourmeterreading.entities.NeighbourMeterReadingView;
import hidrocon.core.generic.pattern.observer.AppEvent;
import hidrocon.core.pattern.mvc.HidroController;
import hidrocon.core.utils.ActionKey;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.webservice.Neighbour;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

/**
 *
 * @author David Sáenz Tagarro
 */
public class NeighbourMeterReadingPanelController extends HidroController {
    
    private Neighbour neighbour;
    
    private NeighbourMeterReadingPanelView view;
    private NeighbourMeterReadingPanelModel model;
    
    public NeighbourMeterReadingPanelController(NeighbourMeterReadingPanelModel model, NeighbourMeterReadingPanelView view) {
        this.view = view;
        this.model = model;
        
        view.buttonActionListeners(this);
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
          
        if (action.equals(ActionKey.NEIGHBOUR_DETAILS_EDIT)) {
            editNeighbour();
        }
        else if (action.equals(ActionKey.NEIGHBOUR_DETAILS_SAVE)) {
            saveNeighbour();
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
        
        if (o instanceof NeighbourMeterReadingPanelModel) {
            if (action.equals(ObservableActionKey.SEARCH_INFO)) {
                doSearchNeighbourMeterReading(argument);
            }
            else if (action.equals(ObservableActionKey.INFO_UPDATED)) {
                showMessageNeighbourUpdated();
            }
        }
    }    

    public void setNeighbour(Neighbour neighbour) {
        this.neighbour = neighbour;
        
        model.searchNeighbourMeterReading(neighbour);
        view.writeData(nmrvList);
    }
    
    private void doSearchNeighbourMeterReading(Object argument) {
        List<NeighbourMeterReadingView> neighbourMeterReadingList = (ArrayList)argument;
        view.writeData(neighbourMeterReadingList);
    }
    
    private void deleteMeter() {
        
    }
    
    private void saveMeter() {
        
    }
    
    private void saveNeighbour() {
        /*
        Neighbour neighbour = new Neighbour();  
        boolean created = model.createNeighbour(neighbour);
        if (created) {
            view.addNeighbour(neighbour);
            model.showMessageNeighbourCreated();
        }*/
    }
    
    private void editNeighbour() {
        /*
        Neighbour neighbour = view.getNeighbourSelected();  
        boolean deleted = model.deleteNeighbour(neighbour);
        if (deleted) {
            view.removeNeighbour(neighbour);
            model.showMessageNeighbourDeleted();
        }*/
    }
        
    private void printNeighbour() {
        
    }

    public void mouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            //updateNeighbourMeterReading();
        }
    }

    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void keyPressed(KeyEvent evt) {
        int keyCode = evt.getKeyCode();
/*
        if (keyCode == KeyEvent.VK_ENTER) {
            evt.consume();
            updateNeighbour();
        }
        else if (keyCode == KeyEvent.VK_F4) {
            evt.consume();
            deleteNeighbour();
        }
        else if (keyCode == KeyEvent.VK_F6) {
            evt.consume();
            createNeighbour();
        }
        else if (keyCode == KeyEvent.VK_ESCAPE) {
            close();
        }*/
    }

    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
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
    
}
