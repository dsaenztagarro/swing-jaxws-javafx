/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.invoice.meterreading.menu;

import hidrocon.HidroconView;
import hidrocon.core.database.building.entities.Building;
import hidrocon.custom.tab.HidroTabButtonView;
import hidrocon.custom.tab.HidroTabKey;
import hidrocon.custom.tab.HidroTabPanelController;
import hidrocon.custom.tab.HidroTabPanelModel;
import hidrocon.custom.tab.HidroTabPanelView;
import hidrocon.custom.tab.ITabContainer;
import hidrocon.ui.building.main.BuildingMainPanelController;
import hidrocon.ui.building.main.BuildingMainPanelModel;
import hidrocon.ui.building.main.BuildingMainPanelView;
import hidrocon.invoice.meterreading.details.InvoiceReadingPanelController;
import hidrocon.invoice.meterreading.details.InvoiceReadingPanelModel;
import hidrocon.invoice.meterreading.details.InvoiceReadingPanelView;
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
public final class MeterReadingMenuController implements ITabContainer {

    private HidroTabPanelModel tabModel;
    private HidroTabPanelView tabView;
    private HidroTabPanelController tabController;
    private javax.swing.JPanel contentView;
    
    private BuildingMainPanelModel buildingMainModel;    
    private BuildingMainPanelView buildingMainView;
    private BuildingMainPanelController buildingMainController;

    private InvoiceReadingPanelModel invoiceReadingPanelModel;    
    private InvoiceReadingPanelView invoiceReadingPanelView;
    private InvoiceReadingPanelController invoiceReadingPanelController;
    
    private MeterReadingMenuModel model;
    private MeterReadingMenuView view;
    
    public MeterReadingMenuController(MeterReadingMenuModel model, MeterReadingMenuView view) {
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
        
        invoiceReadingPanelView = new InvoiceReadingPanelView();
        invoiceReadingPanelModel = new InvoiceReadingPanelModel();
        invoiceReadingPanelController = new InvoiceReadingPanelController(invoiceReadingPanelModel, invoiceReadingPanelView);
        invoiceReadingPanelView.setMinimumSize(new Dimension(650,535));
        invoiceReadingPanelView.setPreferredSize(new Dimension(650,535));
        
        //Tab container:
        contentView = new JPanel();
        contentView.setLayout(new CardLayout());
        contentView.add(buildingMainView,HidroTabKey.TAB_METERREADING_MAIN);
        contentView.add(invoiceReadingPanelView,HidroTabKey.TAB_METERREADING_DETAILS);
        //controller.setDialog(this);     
    }
    
    private void initTabPanel() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        
        tabView = new HidroTabPanelView();
        tabModel = new HidroTabPanelModel();
        tabController = new HidroTabPanelController(tabModel, tabView);
        
        ArrayList tabList = new ArrayList();
        HidroTabButtonView hidroTabButtonView = new HidroTabButtonView();
        hidroTabButtonView.setName(HidroTabKey.TAB_METERREADING_MAIN);
        hidroTabButtonView.setText(resourceMap.getString("tab.meterreading.main"));
        hidroTabButtonView.setComponent(buildingMainView);
        hidroTabButtonView.setEnabled(true);
        hidroTabButtonView.setSelected(true);
        hidroTabButtonView.addMouseListener(tabController);
        tabList.add(hidroTabButtonView);
        
        HidroTabButtonView hidroTabButton2View = new HidroTabButtonView();
        hidroTabButton2View.setName(HidroTabKey.TAB_METERREADING_DETAILS);
        hidroTabButton2View.setText(resourceMap.getString("tab.meterreading.details"));
        hidroTabButton2View.setComponent(invoiceReadingPanelView);
        hidroTabButton2View.setEnabled(true);
        hidroTabButton2View.addMouseListener(tabController);
        tabList.add(hidroTabButton2View);
        
        tabController.setContainerController(this);
        tabController.add(tabList);  
        tabController.selectFirstTab();
    }
    
    public void showTabContent(Component component) {
        if (component instanceof BuildingMainPanelView) {
            showBuildingTab();
        }
        if (component instanceof InvoiceReadingPanelView) {
            showBuildingNeighbourMeterReadingTab();
        }        
    }  
    
    public void showBuildingTab() {
        CardLayout cl = (CardLayout)contentView.getLayout();
        cl.show(contentView, HidroTabKey.TAB_METERREADING_MAIN);
    }
    
    public void showBuildingNeighbourMeterReadingTab() {
        Building building = buildingMainController.getBuildingSelected();
        invoiceReadingPanelController.setBuilding(building);
        
        CardLayout cl = (CardLayout)contentView.getLayout();
        cl.show(contentView, HidroTabKey.TAB_METERREADING_DETAILS);
    }    
    
}
