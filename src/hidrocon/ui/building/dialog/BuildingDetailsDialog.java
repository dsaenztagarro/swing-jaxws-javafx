/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuildingDetailsDialog.java
 *
 * Created on 29-nov-2011, 7:16:41
 */
package hidrocon.ui.building.dialog;

import hidrocon.HidroconView;
import hidrocon.core.database.building.entities.Building;
import hidrocon.custom.dialog.HidroDialog;
import hidrocon.custom.dialog.interfaces.IEntityView;
import hidrocon.custom.tab.HidroTabButtonView;
import hidrocon.custom.tab.HidroTabKey;
import hidrocon.custom.tab.HidroTabPanelController;
import hidrocon.custom.tab.HidroTabPanelModel;
import hidrocon.custom.tab.HidroTabPanelView;
import hidrocon.custom.tab.ITabContainer;
import hidrocon.ui.building.details.BuildingDetailsPanelController;
import hidrocon.ui.building.details.BuildingDetailsPanelModel;
import hidrocon.ui.building.details.BuildingDetailsPanelView;
import hidrocon.ui.building.invoice.BuildingInvoicePanelController;
import hidrocon.ui.building.invoice.BuildingInvoicePanelModel;
import hidrocon.ui.building.invoice.BuildingInvoicePanelView;
import hidrocon.ui.building.metertype.BuildingMeterTypePanelController;
import hidrocon.ui.building.metertype.BuildingMeterTypePanelModel;
import hidrocon.ui.building.metertype.BuildingMeterTypePanelView;
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
public class BuildingDetailsDialog extends HidroDialog implements ITabContainer,IEntityView {

    private HidroTabPanelModel tabModel;
    private HidroTabPanelView tabView;
    private HidroTabPanelController tabController;
    private javax.swing.JPanel contentView;
    
    private BuildingDetailsPanelModel detailsModel;    
    private BuildingDetailsPanelView detailsView;
    private BuildingDetailsPanelController detailsController;
    
    private BuildingMeterTypePanelModel meterTypeModel;    
    private BuildingMeterTypePanelView meterTypeView;
    private BuildingMeterTypePanelController meterTypeController;    

    private BuildingInvoicePanelModel invoiceModel;    
    private BuildingInvoicePanelView invoiceView;
    private BuildingInvoicePanelController invoiceController;    
    
    /** Creates new form BuildingDetailsDialog */
    public BuildingDetailsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initContent();
    }
    
    private void initContent() {
        initTabContent();
        initTabPanel();
        
        detailsController.setDialog(this);
        
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        getContentPane().add(tabView, BorderLayout.PAGE_START);
        getContentPane().add(contentView, BorderLayout.CENTER);
        
        //HidroBlockingLayerUI layerUI = new HidroBlockingLayerUI();
        //JLayer<JPanel> jlayerMain = new JLayer<JPanel>(view, layerUI);
        //getContentPane().add(jlayerMain);
        pack();        
    }
    
    private void initTabContent() {
        //Tabs:
        detailsView = new BuildingDetailsPanelView();
        detailsModel = new BuildingDetailsPanelModel();
        detailsController = new BuildingDetailsPanelController(detailsModel, detailsView);
        detailsView.setMinimumSize(new Dimension(650,535));
        detailsView.setPreferredSize(new Dimension(650,535));
        
        meterTypeView = new BuildingMeterTypePanelView();
        meterTypeModel = new BuildingMeterTypePanelModel();
        meterTypeController = new BuildingMeterTypePanelController(meterTypeModel, meterTypeView);
        meterTypeView.setMinimumSize(new Dimension(650,535));
        meterTypeView.setPreferredSize(new Dimension(650,535)); 

        invoiceView = new BuildingInvoicePanelView();
        invoiceModel = new BuildingInvoicePanelModel();
        invoiceController = new BuildingInvoicePanelController(invoiceModel, invoiceView);
        invoiceView.setMinimumSize(new Dimension(650,535));
        invoiceView.setPreferredSize(new Dimension(650,535)); 
        
        //Tab container:
        contentView = new JPanel();
        contentView.setLayout(new CardLayout());
        contentView.add(detailsView,HidroTabKey.TAB_BUILDING_DETAILS_GENERAL);
        contentView.add(meterTypeView,HidroTabKey.TAB_BUILDING_DETAILS_METER_TYPE);
        contentView.add(invoiceView,HidroTabKey.TAB_BUILDING_DETAILS_INVOICE);
        
        //controller.setDialog(this);
        setMinimumSize(new Dimension(650,575));
        setMaximumSize(new Dimension(650,575));
        setPreferredSize(new Dimension(650,575));        
    }
    
    private void initTabPanel() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        
        tabView = new HidroTabPanelView();
        tabModel = new HidroTabPanelModel();
        tabController = new HidroTabPanelController(tabModel, tabView);
        tabController.setContainerController(this);
        
        ArrayList tabList = new ArrayList();
        HidroTabButtonView hidroTabButtonView = new HidroTabButtonView();
        hidroTabButtonView.setName(HidroTabKey.TAB_BUILDING_DETAILS_GENERAL);
        hidroTabButtonView.setText(resourceMap.getString("tab.building.details.general"));
        hidroTabButtonView.setComponent(detailsView);
        hidroTabButtonView.setSelected(true);
        hidroTabButtonView.setEnabled(true);
        hidroTabButtonView.addMouseListener(tabController);
        tabList.add(hidroTabButtonView);
        
        HidroTabButtonView hidroTabButton2View = new HidroTabButtonView();
        hidroTabButton2View.setName(HidroTabKey.TAB_BUILDING_DETAILS_METER_TYPE);
        hidroTabButton2View.setText(resourceMap.getString("tab.building.details.metertype"));
        hidroTabButton2View.setComponent(meterTypeView);
        hidroTabButton2View.setEnabled(true);
        hidroTabButton2View.addMouseListener(tabController);
        tabList.add(hidroTabButton2View);
        
        HidroTabButtonView hidroTabButton3View = new HidroTabButtonView();
        hidroTabButton3View.setName(HidroTabKey.TAB_BUILDING_DETAILS_INVOICE);
        hidroTabButton3View.setText(resourceMap.getString("tab.building.details.invoice"));
        hidroTabButton3View.setComponent(invoiceView);
        hidroTabButton3View.setEnabled(true);
        hidroTabButton3View.addMouseListener(tabController);
        tabList.add(hidroTabButton3View);
        
        tabController.add(tabList);  
        tabController.selectFirstTab();
    }
    
    public void showTabContent(Component component) {
		CardLayout cl = (CardLayout)contentView.getLayout();
        if (component instanceof BuildingDetailsPanelView) {
            cl.show(contentView, HidroTabKey.TAB_BUILDING_DETAILS_GENERAL);
        }        
        if (component instanceof BuildingMeterTypePanelView) {
            cl.show(contentView, HidroTabKey.TAB_BUILDING_DETAILS_METER_TYPE);
        }
        if (component instanceof BuildingInvoicePanelView) {
            cl.show(contentView, HidroTabKey.TAB_BUILDING_DETAILS_INVOICE);
        }        
    }
    
    public void setMode(int mode) {
        detailsView.setMode(mode);
    }

    public void setEntity(Object building) {
        detailsController.setBuilding((Building)building);
        meterTypeController.setBuilding((Building)building);
        invoiceController.setBuilding((Building)building);        
    }
    
    public boolean isEntityUpdated() {
        return false; //administratorSaved;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
