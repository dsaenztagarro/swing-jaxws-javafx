/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.route.routebuildingdate;

import hidrocon.core.database.routedate.entities.RouteDate;
import hidrocon.core.pattern.mvc.HidroController;
import hidrocon.core.utils.ActionKey;
import hidrocon.custom.Constant;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
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
public class RouteBuildingDateDetailsController extends HidroController {
    
    private JDialog dialog;
    
    private RouteDate routeDate;
    private boolean routeBuildingDateSaved;
    
    private RouteBuildingDateDetailsModel model;
    private RouteBuildingDateDetailsView view;
    
    public RouteBuildingDateDetailsController(RouteBuildingDateDetailsModel model, RouteBuildingDateDetailsView view) {
        this.model = model;
        this.view = view;
        view.buttonActionListeners(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
	if (action.equals(ActionKey.ROUTE_BUILDING_DATE_MOVE_UP)) {
            moveUpRouteBuildingDate();
	}
        else if (action.equals(ActionKey.ROUTE_BUILDING_DATE_MOVE_DOWN)) {
            moveDownRouteBuildingDate();
        }
        else if (action.equals(ActionKey.ROUTE_BUILDING_DATE_EDIT)) {
            editRouteBuildingDate();
        }        
        else if (action.equals(ActionKey.ROUTE_BUILDING_DATE_SAVE)) {
            saveRouteBuildingDate();
        }
        else if (action.equals(ActionKey.ROUTE_BUILDING_DATE_CLOSE)) {
            close();
        }
    }


    private void moveUpRouteBuildingDate() {
        List routeBuildingList = view.getRouteBuildingDateList();
        ArrayList list = new ArrayList();
        list.addAll(routeBuildingList);

        int indexSelected = view.getRouteBuildingDateSelectedIndex();
        int newIndexSelected = model.changeRouteBuildingDateOrder(list, indexSelected, Constant.MOVE_UP);
        if (newIndexSelected >-1) {
            view.setRouteBuildingDateList(list);
            view.selectRouteBuildingDateTableRow(newIndexSelected);
        }    
    }
    
    private void moveDownRouteBuildingDate() {
        List routeBuildingList = view.getRouteBuildingDateList();
        ArrayList list = new ArrayList();
        list.addAll(routeBuildingList);
        
        int indexSelected = view.getRouteBuildingDateSelectedIndex();
        int newIndexSelected = model.changeRouteBuildingDateOrder(list, indexSelected, Constant.MOVE_DOWN);
        if (newIndexSelected >-1) {
            view.setRouteBuildingDateList(list);
            view.selectRouteBuildingDateTableRow(newIndexSelected);
        }
    }
    
    private void saveRouteBuildingDate() {
        List list = view.getRouteBuildingDateList();
        model.updateRouteBuildingDateList(routeDate, list);
        
        view.setMode(Constant.VIEW_MODE_READONLY);
        close();
        model.showMessageRouteBuildingUpdated();
    }
    
    public void setRouteDate(RouteDate routeDate) {
        this.routeDate = routeDate;
        routeBuildingDateSaved = false;
        
        List list = model.getRouteBuildingDateList(this.routeDate.getId());
        view.setRouteBuildingDateList(list);
    }
    
    public boolean isRouteBuildingDateSaved() {
        return routeBuildingDateSaved;
    }
    
    private void editRouteBuildingDate() {
        view.setMode(Constant.VIEW_MODE_UPDATE);
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
                editRouteBuildingDate();
            }
        };   
        
        javax.swing.Action saveAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                saveRouteBuildingDate();
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
        inputMap.put(KeyStroke.getKeyStroke("F10"),"editRouteBuildingDate_F10");        
        inputMap.put(KeyStroke.getKeyStroke("F11"),"saveRouteBuildingDate_F11");
        inputMap.put(KeyStroke.getKeyStroke("F12"),"closeRouteBuildingDate_F12");
        mainPanel.getActionMap().put("editRouteBuildingDate_F10",editAction);
        mainPanel.getActionMap().put("saveRouteBuildingDate_F11",saveAction);
        mainPanel.getActionMap().put("closeRouteBuildingDate_F12",closeAction);        
    } 

    @Override
    public void mouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            editRouteBuildingDate();
        }
    }
    
}
