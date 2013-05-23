/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.neighbour.menu;

import hidrocon.HidroconView;
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
import javax.swing.JPanel;

/**
 *
 * @author David Sáenz Tagarro
 */
public class NeighbourMenuController implements ITabContainer {

    private HidroTabPanelModel tabModel;
    private HidroTabPanelView tabView;
    private HidroTabPanelController tabController;
    private javax.swing.JPanel contentView;
    
    private BuildingMainPanelModel buildingMainModel;    
    private BuildingMainPanelView buildingMainView;
    private BuildingMainPanelController buildingMainController;
    
    private NeighbourMainPanelModel neighbourMainModel;    
    private NeighbourMainPanelView neighbourMainView;
    private NeighbourMainPanelController neighbourMainController;      
    
    private NeighbourMenuModel model;
    private NeighbourMenuView view;
    
    public NeighbourMenuController(NeighbourMenuModel model, NeighbourMenuView view) {
        initTabContent();
        initTabPanel();
        
        this.view = view;
        this.model = model;
        
        view.add(tabView, BorderLayout.PAGE_START);
        view.add(contentView, BorderLayout.CENTER);        
    }
    
    private void initTabContent() {
        //Tabs:
        buildingMainView = new BuildingMainPanelView();
        buildingMainModel = new BuildingMainPanelModel();
        buildingMainController = new BuildingMainPanelController(buildingMainModel, buildingMainView);
        buildingMainView.setMinimumSize(new Dimension(650,535));
        buildingMainView.setPreferredSize(new Dimension(650,535));
        
        neighbourMainView = new NeighbourMainPanelView();
        neighbourMainModel = new NeighbourMainPanelModel();
        neighbourMainController = new NeighbourMainPanelController(neighbourMainModel, neighbourMainView);
        neighbourMainView.setMinimumSize(new Dimension(650,535));
        neighbourMainView.setPreferredSize(new Dimension(650,535));
        
        //Tab container:
        contentView = new JPanel();
        contentView.setLayout(new CardLayout());
        contentView.add(buildingMainView,HidroTabKey.TAB_BUILDING_MAIN);
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
        HidroTabButtonView hidroTabButtonView = new HidroTabButtonView();
        hidroTabButtonView.setName(HidroTabKey.TAB_BUILDING_MAIN);
        hidroTabButtonView.setText(resourceMap.getString("tab.building.main"));
        hidroTabButtonView.setComponent(buildingMainView);
        hidroTabButtonView.setEnabled(true);
        hidroTabButtonView.setSelected(true);
        hidroTabButtonView.addMouseListener(tabController);
        tabList.add(hidroTabButtonView);
        
        HidroTabButtonView hidroTabButton3View = new HidroTabButtonView();
        hidroTabButton3View.setName(HidroTabKey.TAB_NEIGHBOUR_MAIN);
        hidroTabButton3View.setText(resourceMap.getString("tab.neighbour.main"));
        hidroTabButton3View.setComponent(neighbourMainView);
        hidroTabButton3View.setEnabled(true);
        hidroTabButton3View.addMouseListener(tabController);
        tabList.add(hidroTabButton3View);
        
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
        Building building = buildingMainController.getBuildingSelected();
        neighbourMainController.setBuilding(building);
        
        CardLayout cl = (CardLayout)contentView.getLayout();
        cl.show(contentView, HidroTabKey.TAB_NEIGHBOUR_MAIN);        
    }
}
