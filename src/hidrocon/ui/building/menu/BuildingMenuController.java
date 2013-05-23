/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.building.menu;

import hidrocon.HidroconView;
import hidrocon.core.database.building.entities.Building;
import hidrocon.core.pattern.mvc.HidroController;
import hidrocon.core.pattern.observer.AppEvent;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.custom.tab.HidroTabButtonView;
import hidrocon.custom.tab.HidroTabKey;
import hidrocon.custom.tab.HidroTabPanelController;
import hidrocon.custom.tab.HidroTabPanelModel;
import hidrocon.custom.tab.HidroTabPanelView;
import hidrocon.custom.tab.ITabContainer;
import hidrocon.ui.building.main.BuildingMainPanelController;
import hidrocon.ui.building.main.BuildingMainPanelModel;
import hidrocon.ui.building.main.BuildingMainPanelView;
import hidrocon.ui.neighbour.main.NeighbourMainPanelController;
import hidrocon.ui.neighbour.main.NeighbourMainPanelModel;
import hidrocon.ui.neighbour.main.NeighbourMainPanelView;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JPanel;

/**
 *
 * @author David Sáenz Tagarro
 */
public class BuildingMenuController extends HidroController implements ITabContainer {

    private HidroTabPanelModel tabModel;
    private HidroTabPanelView tabView;
    private HidroTabPanelController tabController;
    private javax.swing.JPanel contentView;
    
    private BuildingMainPanelModel buildingMainPanelModel;    
    private BuildingMainPanelView buildingMainPanelView;
    private BuildingMainPanelController buildingMainPanelController;
    
    private NeighbourMainPanelModel neighbourMainModel;    
    private NeighbourMainPanelView neighbourMainView;
    private NeighbourMainPanelController neighbourMainController;      
    
    private HidroTabButtonView neighbourTabButtonView;
    
    private BuildingMenuModel model;
    private BuildingMenuView view;
    
    public BuildingMenuController(BuildingMenuModel model, BuildingMenuView view) {
        initTabContent();
        initTabPanel();
        
        this.view = view;
        this.model = model;
        
        view.add(tabView, BorderLayout.PAGE_START);
        view.add(contentView, BorderLayout.CENTER);     
    }
    
    @Override
    public void update(Observable o, Object arg) {
        AppEvent message = (AppEvent)arg;
        String action = message.getEventName();
        if (o instanceof BuildingMainPanelController) {
            if (action.equals(ObservableActionKey.ROW_SELECTED)) {
                setTabsEnabled(true);
            }
            else if (action.equals(ObservableActionKey.ROW_UNSELECTED)) {
                setTabsEnabled(false);
            }
        }
    }
    
    private void setTabsEnabled(boolean status) {
        neighbourTabButtonView.setEnabled(status);
    }
    
    private void initTabContent() {
        //Tabs:
        buildingMainPanelView = new BuildingMainPanelView();
        buildingMainPanelModel = new BuildingMainPanelModel();
        buildingMainPanelController = new BuildingMainPanelController(buildingMainPanelModel, buildingMainPanelView);
        buildingMainPanelController.addObserver(this);
        buildingMainPanelView.setMinimumSize(new Dimension(650,535));
        buildingMainPanelView.setPreferredSize(new Dimension(650,535));
        
        neighbourMainView = new NeighbourMainPanelView();
        neighbourMainModel = new NeighbourMainPanelModel();
        neighbourMainController = new NeighbourMainPanelController(neighbourMainModel, neighbourMainView);
        neighbourMainView.setMinimumSize(new Dimension(650,535));
        neighbourMainView.setPreferredSize(new Dimension(650,535));
        
        //Tab container:
        contentView = new JPanel();
        contentView.setLayout(new CardLayout());
        contentView.add(buildingMainPanelView,HidroTabKey.TAB_BUILDING_MAIN);
        contentView.add(neighbourMainView,HidroTabKey.TAB_NEIGHBOUR_MAIN);
        //controller.setDialog(this);      
    }
    
    private void initTabPanel() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        
        tabView = new HidroTabPanelView();
        tabModel = new HidroTabPanelModel();
        tabController = new HidroTabPanelController(tabModel, tabView);
        tabController.setContainerController(this);
        
        ArrayList tabList = new ArrayList();
        HidroTabButtonView buildingTabButtonView = new HidroTabButtonView();
        buildingTabButtonView.setName(HidroTabKey.TAB_BUILDING_MAIN);
        buildingTabButtonView.setText(resourceMap.getString("tab.building.main"));
        buildingTabButtonView.setComponent(buildingMainPanelView);
        buildingTabButtonView.setEnabled(true);
        buildingTabButtonView.setSelected(true);
        buildingTabButtonView.addMouseListener(tabController);
        tabList.add(buildingTabButtonView);
        
        neighbourTabButtonView = new HidroTabButtonView();
        neighbourTabButtonView.setName(HidroTabKey.TAB_NEIGHBOUR_MAIN);
        neighbourTabButtonView.setText(resourceMap.getString("tab.neighbour.main"));
        neighbourTabButtonView.setComponent(neighbourMainView);
        neighbourTabButtonView.setEnabled(false);
        neighbourTabButtonView.addMouseListener(tabController);
        tabList.add(neighbourTabButtonView);
        
        tabController.add(tabList);  
        tabController.selectFirstTab();
    }
    
    public void showTabContent(Component component) {
        if (component instanceof BuildingMainPanelView) {
            showBuildingMainTab();
        }
        if (component instanceof NeighbourMainPanelView) {
            showNeighbourMainTab();
        }       
    }
    
    public void showBuildingMainTab() {
        CardLayout cl = (CardLayout)contentView.getLayout();
        cl.show(contentView, HidroTabKey.TAB_BUILDING_MAIN);
    }
    
    public void showNeighbourMainTab() {
        Building building = buildingMainPanelController.getBuildingSelected();
        neighbourMainController.setBuilding(building);
        
        CardLayout cl = (CardLayout)contentView.getLayout();
        cl.show(contentView, HidroTabKey.TAB_NEIGHBOUR_MAIN);        
    }
}
