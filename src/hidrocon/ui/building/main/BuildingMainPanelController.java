/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.building.main;

import hidrocon.core.database.building.entities.Building;
import hidrocon.core.pattern.mvc.HidroController;
import hidrocon.core.pattern.observer.AppEvent;
import hidrocon.core.utils.ActionKey;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.webservice.Building;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

/**
 * Notified events:
 * 
 * @author David Sáenz Tagarro
 */
public class BuildingMainPanelController extends HidroController {
    
    private Building buildingSelected;
    
    private BuildingMainPanelModel model;
    private BuildingMainPanelView view;
    
    public BuildingMainPanelController(BuildingMainPanelModel model, BuildingMainPanelView view) {
        this.model = model;
        this.view = view;
        
        view.addController(this);
        model.addObserver(this);
        model.searchBuilding();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
        if (action.equals(ActionKey.BUILDING_VIEW_NEIGHBOURS)) {
            showNeighbourList();
        }
        else if (action.equals(ActionKey.BUILDING_CREATE)) {
            createBuilding();
        }        
        else if (action.equals(ActionKey.BUILDING_UPDATE)) {
            //updateBuilding();
        }
        else if (action.equals(ActionKey.BUILDING_DELETE)) {
            deleteBuilding();
        }        
    }
    
    @Override
    public void keyPressed(KeyEvent evt) {
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
                evt.consume();
                //updateBuilding();
        }
        else if (keyCode == KeyEvent.VK_F1) {
            evt.consume();
            showNeighbourList();
        }
        else if (keyCode == KeyEvent.VK_F4) {
            evt.consume();
            deleteBuilding();
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent evt) {
        Component component = evt.getComponent();
        buildingSelected = view.getBuildingSelected();
        
        if (evt.getClickCount() == 2) {
            evt.consume();
            //updateBuilding();
        }
    }
    
    @Override
    public void update(Observable o, Object arg) {
        AppEvent message = (AppEvent)arg;
        String action = message.getEventName();
        Object argument = message.getArgument();
        
        if (o instanceof BuildingMainPanelModel) {
            if (action.equals(ObservableActionKey.SEARCH_INFO)) {
                doSearchInfo(argument);
            }
            /*else if (action.equals(ObservableActionKey.ROW_UNSELECTED)) {
                setTabsEnabled(false);
            }*/
        }
    }    

    public void doSearchInfo(Object object) {
        view.setBuildingList((ArrayList)object);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        AppEvent message = null;
        if (!e.getValueIsAdjusting()) {
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
            if (lsm.isSelectionEmpty()) {
                message = new AppEvent(ObservableActionKey.ROW_UNSELECTED);
            } else {
                Building building = view.getBuildingSelected();
                message = new AppEvent(ObservableActionKey.ROW_SELECTED, building);
            }
        }
        if (message != null) {
            this.setChanged();
            this.notifyObservers(message);
        }
    }    
    
    private void showNeighbourList() {
        Building building = view.getBuildingSelected();
        model.showNeighbourListDialog(building);
    }

    private void createBuilding() {
        Building building = new Building();  
        boolean created = model.createBuilding(building);
        if (created) {
            view.addBuilding(building);
            model.showMessageBuildingCreated();
        }
    }
    
    private void updateBuilding() {
        Building building = view.getBuildingSelected();  
        boolean updated = model.updateBuilding(building);
        if (updated) {
            view.refreshBuildingList();
            model.showMessageBuildingUpdated();
        }
    }
    
    private void deleteBuilding() {
        Building building = view.getBuildingSelected();  
        boolean deleted = model.deleteBuilding(building);
        if (deleted) {
            buildingSelected = null;
            view.removeBuilding(building);
            model.showMessageBuildingDeleted();
        }
    }
    
    public Building getBuildingSelected() {
        return view.getBuildingSelected();
    }    
    
}
