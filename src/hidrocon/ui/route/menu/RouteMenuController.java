/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.route.menu;

import hidrocon.HidroconView;
import hidrocon.core.pattern.mvc.HidroController;
import hidrocon.core.pattern.observer.AppEvent;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.custom.tab.HidroTabButtonView;
import hidrocon.custom.tab.HidroTabKey;
import hidrocon.custom.tab.HidroTabPanelController;
import hidrocon.custom.tab.HidroTabPanelModel;
import hidrocon.custom.tab.HidroTabPanelView;
import hidrocon.custom.tab.ITabContainer;
import hidrocon.ui.route.building.RouteBuildingPanelController;
import hidrocon.ui.route.building.RouteBuildingPanelModel;
import hidrocon.ui.route.building.RouteBuildingPanelView;
import hidrocon.ui.route.date.RouteDatePanelController;
import hidrocon.ui.route.date.RouteDatePanelModel;
import hidrocon.ui.route.date.RouteDatePanelView;
import hidrocon.ui.route.main.RouteMainPanelController;
import hidrocon.ui.route.main.RouteMainPanelModel;
import hidrocon.ui.route.main.RouteMainPanelView;
import hidrocon.webservice.Route;
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
public class RouteMenuController extends HidroController implements ITabContainer {

    private HidroTabPanelModel tabModel;
    private HidroTabPanelView tabView;
    private HidroTabPanelController tabController;
    private javax.swing.JPanel contentView;

    private RouteMainPanelModel routeMainModel;    
    private RouteMainPanelView routeMainView;
    private RouteMainPanelController routeMainController;
    
    private RouteBuildingPanelModel routeBuildingModel;    
    private RouteBuildingPanelView routeBuildingView;
    private RouteBuildingPanelController routeBuildingController;
    
    private RouteDatePanelModel routeDateModel;    
    private RouteDatePanelView routeDateView;
    private RouteDatePanelController routeDateController;      
    
    private RouteMenuModel model;
    private RouteMenuView view;
    
    private HidroTabButtonView routeBuildingTabButtonView;
    private HidroTabButtonView routeDateTabButtonView;
    
    public RouteMenuController(RouteMenuModel model, RouteMenuView view) {
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
        if (o instanceof RouteMainPanelController) {
            if (action.equals(ObservableActionKey.ROW_SELECTED)) {
                setTabsEnabled(true);
            }
            else if (action.equals(ObservableActionKey.ROW_UNSELECTED)) {
                setTabsEnabled(false);
            }
        }
    }
    
    private void setTabsEnabled(boolean status) {
        routeBuildingTabButtonView.setEnabled(status);
        routeDateTabButtonView.setEnabled(status); 
    }
    
    private void initTabContent() {
        //Tabs:
        routeMainView = new RouteMainPanelView();
        routeMainModel = new RouteMainPanelModel();
        routeMainController = new RouteMainPanelController(routeMainModel, routeMainView);
        routeMainView.setMinimumSize(new Dimension(650,535));
        routeMainView.setPreferredSize(new Dimension(650,535));
        
        routeBuildingView = new RouteBuildingPanelView();
        routeBuildingModel = new RouteBuildingPanelModel();
        routeBuildingController = new RouteBuildingPanelController(routeBuildingModel, routeBuildingView);
        routeBuildingView.setMinimumSize(new Dimension(650,535));
        routeBuildingView.setPreferredSize(new Dimension(650,535));

        routeDateView = new RouteDatePanelView();
        routeDateModel = new RouteDatePanelModel();
        routeDateController = new RouteDatePanelController(routeDateModel, routeDateView);
        routeDateView.setMinimumSize(new Dimension(650,535));
        routeDateView.setPreferredSize(new Dimension(650,535));
        
        //Tab container:
        contentView = new JPanel();
        contentView.setLayout(new CardLayout());
        contentView.add(routeMainView,HidroTabKey.TAB_ROUTE_MAIN);
        contentView.add(routeBuildingView,HidroTabKey.TAB_ROUTE_BUILDING);
        contentView.add(routeDateView,HidroTabKey.TAB_ROUTE_DATE);
        //controller.setDialog(this);      
    }
    
    private void initTabPanel() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        
        tabView = new HidroTabPanelView();
        tabModel = new HidroTabPanelModel();
        tabController = new HidroTabPanelController(tabModel, tabView);
        tabController.setContainerController(this);
        
        ArrayList tabList = new ArrayList();
        HidroTabButtonView routeTabButtonView = new HidroTabButtonView();
        routeTabButtonView.setName(HidroTabKey.TAB_ROUTE_MAIN);
        routeTabButtonView.setText(resourceMap.getString("tab.route.main"));
        routeTabButtonView.setComponent(routeMainView);
        routeTabButtonView.setEnabled(true);
        routeTabButtonView.setSelected(true);
        routeTabButtonView.addMouseListener(tabController);
        tabList.add(routeTabButtonView);
        
        routeBuildingTabButtonView = new HidroTabButtonView();
        routeBuildingTabButtonView.setName(HidroTabKey.TAB_ROUTE_BUILDING);
        routeBuildingTabButtonView.setText(resourceMap.getString("tab.route.building"));
        routeBuildingTabButtonView.setComponent(routeBuildingView);
        routeBuildingTabButtonView.setEnabled(false);
        routeBuildingTabButtonView.addMouseListener(tabController);
        tabList.add(routeBuildingTabButtonView);
        
        routeDateTabButtonView = new HidroTabButtonView();
        routeDateTabButtonView.setName(HidroTabKey.TAB_ROUTE_DATE);
        routeDateTabButtonView.setText(resourceMap.getString("tab.route.date"));
        routeDateTabButtonView.setComponent(routeDateView);
        routeDateTabButtonView.setEnabled(false);
        routeDateTabButtonView.addMouseListener(tabController);
        tabList.add(routeDateTabButtonView);
        
        tabController.add(tabList);  
        tabController.selectFirstTab();
    }
    
    public void showTabContent(Component component) {
        if (component instanceof RouteMainPanelView) {
            showRouteMainTab();
        }
        if (component instanceof RouteBuildingPanelView) {
            showRouteBuildingTab();
        }       
        if (component instanceof RouteDatePanelView) {
            showRouteDateTab();
        }               
    }      
    
    public void showRouteMainTab() {
        CardLayout cl = (CardLayout)contentView.getLayout();
        cl.show(contentView, HidroTabKey.TAB_ROUTE_MAIN);
    }
    
    public void showRouteBuildingTab() {
        Route route = routeMainController.getRouteSelected();
        routeBuildingController.setRoute(route);
        
        CardLayout cl = (CardLayout)contentView.getLayout();
        cl.show(contentView, HidroTabKey.TAB_ROUTE_BUILDING);        
    }
    
    public void showRouteDateTab() {
        Route route = routeMainController.getRouteSelected();
        routeDateController.setRoute(route);
        
        CardLayout cl = (CardLayout)contentView.getLayout();
        cl.show(contentView, HidroTabKey.TAB_ROUTE_DATE);        
    }
    
}
