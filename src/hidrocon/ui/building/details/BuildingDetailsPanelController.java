/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.building.details;

import hidrocon.core.generic.pattern.observer.AppEvent;
import hidrocon.core.pattern.mvc.HidroController;
import hidrocon.core.utils.ActionKey;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.custom.Constant;
import hidrocon.webservice.Administrator;
import hidrocon.webservice.Building;
import hidrocon.webservice.Rate;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
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
public class BuildingDetailsPanelController extends HidroController {
    
    private int mode;
    private JDialog dialog;
    private Building building;
    private Administrator administrator;
    private Rate rate;
    private ArrayList routeBuildingDateList;
    
    private BuildingDetailsPanelModel model;
    private BuildingDetailsPanelView view;

    public BuildingDetailsPanelController(BuildingDetailsPanelModel model, BuildingDetailsPanelView view) {
        this.model = model;
        this.view = view;
        this.routeBuildingDateList = new ArrayList();
        
        view.addController(this);
        initRateList();
        initKeyBinding();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
        if (action.equals(ActionKey.BUILDING_DETAILS_CREATE_ROUTE_BUILDING_DATE)) {
            addRouteDate();
        }
        else if (action.equals(ActionKey.BUILDING_DETAILS_DELETE_ROUTE_BUILDING_DATE)) {
            model.deleteRouteDate();
        }        
        else if (action.equals(ActionKey.BUILDING_DETAILS_SELECT_ADMINISTRATOR)) {
            selectAdministrator();
        }
        else if (action.equals(ActionKey.BUILDING_DETAILS_VIEW_ADMINISTRATOR)) {
            showAdministrator();
        }        
        else if (action.equals(ActionKey.BUILDING_DETAILS_VIEW_RATE)) {
            showRate();
        }        
        else if (action.equals(ActionKey.BUILDING_DETAILS_SHOW_NEXT_TAB)) {
            showNextTab();
        }         
        else if (action.equals(ActionKey.BUILDING_DETAILS_SHOW_PREVIOUS_TAB)) {
            showPreviousTab();
        }     
        else if (action.equals(ActionKey.BUILDING_DETAILS_EDIT)) {
            editBuilding();
        }     
        else if (action.equals(ActionKey.BUILDING_DETAILS_CLOSE)) {
            close();
        }     
        
    }
    
    @Override
    public void update(Observable o, Object arg) {
        AppEvent message = (AppEvent)arg;
        String action = message.getEventName();
        Object argument = message.getArgument();
        
        if (o instanceof BuildingDetailsPanelModel) {
            if (action.equals(ObservableActionKey.INFO_CREATED)) {
                showMessageBuildingCreated();
            }
            else if (action.equals(ObservableActionKey.INFO_UPDATED)) {
                showMessageBuildingUpdated();
            }
        }
    }
    
    public void showMessageBuildingCreated() {
        model.showMessageBuildingCreated();
        close();
    }
    
    public void showMessageBuildingUpdated() {
        model.showMessageBuildingUpdated();
        close();
    }
    
    @Override
    public void keyPressed(KeyEvent evt) {
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
                evt.consume();
                //model.updateBuilding(view.getBuildingSelected(),view);
        }
        else if (keyCode == KeyEvent.VK_F1) {
                evt.consume();
                //model.showNeighbourListDialog(view.getBuildingSelected());
        }
        else if (keyCode == KeyEvent.VK_F4) {
                evt.consume();
                //model.deleteBuilding(view.getBuildingSelected(),view);
        }
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        Component component = evt.getComponent();
        if (component == view.getRouteBuildingDateTable()) {
            if (evt.getClickCount() == 2) {
                model.showRouteBuildingDate(component);
            }
        }
    }
    
    private void close() {
        dialog.setVisible(false);
    }
    
    private void showRate() {
        model.showPopupRateDetails(rate);
    }
    
    private void editBuilding() {
        view.setMode(Constant.VIEW_MODE_UPDATE);        
    }
    
    private void saveBuilding() {
        
    }
    
    private void showNextTab() {
        view.showDetails2();
    }
    
    private void showPreviousTab() {
        view.showDetails1();
    }
    
    private void selectAdministrator() {
        administrator = model.updateAdministrator();
        view.loadAdministrator(administrator);        
    }
    
    private void showAdministrator() {
        model.showPopupAdministratorDetails(administrator);
    }
    
    private void addRouteDate() {
        model.addRouteDate();
    }
    
    private void initKeyBinding() {

        javax.swing.Action showRateAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                showRate();
            }
        };   
        
        javax.swing.Action showAdministratorAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                showAdministrator();
            }
        };   
                
        javax.swing.Action editAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                editBuilding();
            }
        };   
        
        javax.swing.Action saveAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                model.saveBuilding();
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
        inputMap.put(KeyStroke.getKeyStroke("F8"),"showRate_F8");
        inputMap.put(KeyStroke.getKeyStroke("F9"),"showAdministrator_F9");
        inputMap.put(KeyStroke.getKeyStroke("F10"),"editBuilding_F10");        
        inputMap.put(KeyStroke.getKeyStroke("F11"),"saveBuilding_F11");
        inputMap.put(KeyStroke.getKeyStroke("F12"),"closeBuilding_F12");
        
        mainPanel.getActionMap().put("showRate_F8",showRateAction);
        mainPanel.getActionMap().put("showAdministrator_F9",showAdministratorAction);                
        mainPanel.getActionMap().put("editBuilding_F10",editAction);
        mainPanel.getActionMap().put("saveBuilding_F11",saveAction);
        mainPanel.getActionMap().put("closeBuilding_F12",closeAction);        
    }

    /**
     * @param building the building to set
     */
    public void setBuilding(Building building) {
        this.building = building;
        AdministratorManager am = new AdministratorManager();
        administrator = am.getAdministrator(building.getAdministratorId());            
        
        RateManager rm = new RateManager();
        rate = rm.getRate(building.getRateId());   
            
        routeBuildingDateList.clear();
        RouteBuildingDateManager rbdm = new RouteBuildingDateManager();
        routeBuildingDateList.addAll(rbdm.getRouteBuildingDateListByBuildingId(building.getId()));

        view.writeData(building, administrator, routeBuildingDateList);
    }

    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }

    private void initRateList() {
        RateManager rm = new RateManager();
        List list = rm.getAllRate();
        view.setRateList(list);        
    }
    
}
