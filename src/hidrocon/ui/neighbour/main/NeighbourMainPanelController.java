/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.neighbour.main;

import hidrocon.core.pattern.mvc.HidroController;
import hidrocon.core.pattern.observer.AppEvent;
import hidrocon.core.utils.ActionKey;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.custom.Constant;
import hidrocon.webservice.Building;
import hidrocon.webservice.Neighbour;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
public class NeighbourMainPanelController extends HidroController {
    
    private JDialog dialog;
    
    private NeighbourMainPanelView view;
    private NeighbourMainPanelModel model;
    
    public NeighbourMainPanelController(NeighbourMainPanelModel model, NeighbourMainPanelView view) {
        this.view = view;
        this.model = model;
        
        model.addObserver(this);
        view.buttonActionListeners(this);
        view.tableKeyListeners(this);
        view.tableMouseListeners(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
        if (action.equals(ActionKey.NEIGHBOUR_CREATE)) {
            createNeighbour();
        }
        else if (action.equals(ActionKey.NEIGHBOUR_DELETE)) {
            deleteNeighbour();
        }
        else if (action.equals(ActionKey.NEIGHBOUR_UPDATE)) {
            showNeighbour();
        }   
        else if (action.equals(ActionKey.NEIGHBOUR_CLOSE)) {
            close();
        }           
        else if (action.equals(ActionKey.NEIGHBOUR_PRINT)) {
            printNeighbour();
        }           
    }
    
    @Override
    public void update(Observable o, Object arg) {
        AppEvent message = (AppEvent)arg;
        String action = message.getEventName();
        Object argument = message.getArgument();
        
        if (o instanceof NeighbourMainPanelModel) {
            if (action.equals(ObservableActionKey.SEARCH_INFO)) {
                doSearchInfo(argument);
            }
            else if (action.equals(ObservableActionKey.INFO_DELETED)) {
                doNeighbourDeleted();
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            showNeighbour();
        }
    }

    @Override
    public void keyPressed(KeyEvent evt) {
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            evt.consume();
            showNeighbour();
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
        }
    }
    
    public void setBuilding(Building building) {
        model.searchNeighbour(building);
    }
    
    public void doSearchInfo(Object object) {
        view.setNeighbourList((ArrayList)object);
    }
    
    private void close() {
        dialog.setVisible(false);
    }
    
    private void createNeighbour() {
        model.showPopupNeighbourDetails(Constant.VIEW_MODE_CREATION, null);
    }

    private void showNeighbour() {
        Neighbour neighbour = view.getNeighbourSelected();
        model.showPopupNeighbourDetails(Constant.VIEW_MODE_READONLY, neighbour);
    }
    
    private void deleteNeighbour() {
        Neighbour neighbour = view.getNeighbourSelected();  
        model.deleteNeighbour(neighbour);
    }

    private void doNeighbourDeleted() {
        model.showMessageNeighbourDeleted();
    }
    
    
    private void printNeighbour() {
        
    }

    protected void initKeyBinding() {
                
        javax.swing.Action createAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                createNeighbour();
            }
        };   
        
        javax.swing.Action updateAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                showNeighbour();
            }
        };        

        javax.swing.Action deleteAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                deleteNeighbour();
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
