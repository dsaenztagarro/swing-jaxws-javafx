/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.route.date;

import hidrocon.core.database.route.entities.Route;
import hidrocon.core.database.routedate.entities.RouteDate;
import hidrocon.core.utils.ActionKey;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class RouteDatePanelController implements ActionListener, KeyListener, MouseListener {
    
    private JDialog dialog;
    
    private Route routeSelected;
    private RouteDate routeDateSelected;

    private RouteDatePanelModel model;
    private RouteDatePanelView view;
    
    public RouteDatePanelController(RouteDatePanelModel model, RouteDatePanelView view) {
        this.model = model;
        this.view = view;
        view.buttonActionListeners(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
        if (action.equals(ActionKey.ROUTE_BUILDING_DATE_UPDATE)) {
            updateRouteBuildingDate();
        }
        else if (action.equals(ActionKey.ROUTE_DATE_CREATE)) {
            createRouteDate();
        }        
        else if (action.equals(ActionKey.ROUTE_DATE_DELETE)) {
            deleteRouteDate();
        }                
    }

    public void setRoute(Route route) {
        this.routeSelected = route;
        
        view.setRouteDateList(model.getRouteDateList(routeSelected));
    }
    
    private void updateRouteBuildingDate() {
        model.updateRouteBuildingDate(routeDateSelected);
    }

    private void createRouteDate() {
        int result = model.createRouteDate(routeSelected);
        if (result == 0) {
            view.setRouteDateList(model.getRouteDateList(routeSelected));
            model.showMessageRouteDateCreated();
        } else {
            model.showMessageErrorRouteDateCreated(result);
        }
    }
    
    private void deleteRouteDate() { 
        boolean deleted = model.deleteRouteDate(routeDateSelected);
        if (deleted) {
            //view.removeRouteDate(routeDateSelected);
            view.setRouteDateList(model.getRouteDateList(routeSelected));
            routeDateSelected = null;
            model.showMessageRouteDateDeleted();
        }        
    }
    
    private void close() {
        if (dialog!=null) {
            dialog.setVisible(false);
        }
    }
        
    public void keyTyped(KeyEvent e) {
        //do nothing
    }

    public void keyPressed(KeyEvent evt) {
        int keyCode = evt.getKeyCode();

    }

    public void keyReleased(KeyEvent e) {
        //do nothing
    }
    
    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }
    
    protected void initKeyBinding() {
        javax.swing.Action editAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                updateRouteBuildingDate();
            }
        };   
        
        javax.swing.Action createAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                createRouteDate();
            }
        };        

        javax.swing.Action deleteAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                deleteRouteDate();
            }
        };        
        
        JPanel mainPanel = view.getMainPanel();
        
        SwingUtilities.replaceUIActionMap(mainPanel, null);
        SwingUtilities.replaceUIInputMap(mainPanel, JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT, null);
        
        InputMap inputMap = mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke("F10"),"editRouteDate_F10");        
        inputMap.put(KeyStroke.getKeyStroke("F11"),"createRouteDate_F11");
        inputMap.put(KeyStroke.getKeyStroke("F12"),"deleteRouteDate_F12");
        mainPanel.getActionMap().put("editRouteDate_F10",editAction);
        mainPanel.getActionMap().put("createRouteDate_F11",createAction);
        mainPanel.getActionMap().put("deleteRouteDate_F12",deleteAction);        
    } 


    public void mouseClicked(MouseEvent evt) {
        routeDateSelected = view.getRouteDateSelected();
        
        if (evt.getClickCount() == 2) {
            updateRouteBuildingDate();
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
    
}
