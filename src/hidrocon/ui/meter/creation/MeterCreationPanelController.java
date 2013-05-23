/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.meter.creation;

import hidrocon.HidroconView;
import hidrocon.core.database.metertype.entities.MeterType;
import hidrocon.core.pattern.mvc.HidroController;
import hidrocon.core.utils.ActionKey;
import hidrocon.custom.Constant;
import hidrocon.custom.tab.HidroTabButtonView;
import hidrocon.custom.tab.HidroTabKey;
import hidrocon.custom.tab.HidroTabPanelController;
import hidrocon.custom.tab.HidroTabPanelModel;
import hidrocon.custom.tab.HidroTabPanelView;
import hidrocon.custom.tab.ITabContainer;
import hidrocon.ui.meter.details.MeterDetailsPanelController;
import hidrocon.ui.meter.details.MeterDetailsPanelModel;
import hidrocon.ui.meter.details.MeterDetailsPanelView;
import hidrocon.ui.meter.metertype.MeterTypePanelController;
import hidrocon.ui.meter.metertype.MeterTypePanelModel;
import hidrocon.ui.meter.metertype.MeterTypePanelView;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author David Sáenz Tagarro
 */
public class MeterCreationPanelController extends HidroController implements ITabContainer {
    
    private JDialog dialog;
    
    private HidroTabPanelModel tabModel;
    private HidroTabPanelView tabView;
    private HidroTabPanelController tabController;
    private javax.swing.JPanel contentView;
    
    private MeterDetailsPanelModel meterDetailsPanelModel;    
    private MeterDetailsPanelView meterDetailsPanelView;
    private MeterDetailsPanelController meterDetailsPanelController;
    
    private MeterTypePanelModel meterTypePanelModel;    
    private MeterTypePanelView meterTypePanelView;
    private MeterTypePanelController meterTypePanelController;
    
    private HidroTabButtonView hidroTabButton2View;
    
    private MeterCreationPanelView view;
    private MeterCreationPanelModel model;
    
    public MeterCreationPanelController(MeterCreationPanelModel model, MeterCreationPanelView view) {
        initTabContent();
        initTabPanel();
        
        this.view = view;
        this.model = model;
        
        meterTypePanelController.addMeterTypeNodeMouseListener(this);
        meterTypePanelView.addController(this);
        meterDetailsPanelView.addController(this);
        
        view.add(tabView, BorderLayout.PAGE_START);
        view.add(contentView, BorderLayout.CENTER);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if (action.equals(ActionKey.METER_TYPE_CLOSE)) {
            close();
        }
        else if (action.equals(ActionKey.METER_DETAILS_CLOSE)) {
            close();
        }
        else if (action.equals(ActionKey.METER_TYPE_SELECT)) {
            setTabSelected(HidroTabKey.TAB_METER_DETAILS);
        }        
    }
        
    private void initTabContent() {
        //Tabs:
        meterTypePanelView = new MeterTypePanelView();
        meterTypePanelModel = new MeterTypePanelModel();
        meterTypePanelController = new MeterTypePanelController(meterTypePanelModel, meterTypePanelView);
        meterTypePanelView.setMinimumSize(new Dimension(650,535));
        meterTypePanelView.setPreferredSize(new Dimension(650,535)); 
        
        meterDetailsPanelView = new MeterDetailsPanelView();
        meterDetailsPanelModel = new MeterDetailsPanelModel();
        meterDetailsPanelController = new MeterDetailsPanelController(meterDetailsPanelModel, meterDetailsPanelView);
        meterDetailsPanelController.setMode(Constant.VIEW_MODE_CREATION);
        meterDetailsPanelView.setMinimumSize(new Dimension(650,535));
        meterDetailsPanelView.setPreferredSize(new Dimension(650,535));
        
        //Tab container:
        contentView = new JPanel();
        contentView.setLayout(new CardLayout());
        contentView.add(meterTypePanelView,HidroTabKey.TAB_METER_TYPE);        
        contentView.add(meterDetailsPanelView,HidroTabKey.TAB_METER_DETAILS);
    }
    
    private void initTabPanel() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        
        tabView = new HidroTabPanelView();
        tabModel = new HidroTabPanelModel();
        tabController = new HidroTabPanelController(tabModel, tabView);
        tabController.setContainerController(this);
        tabController.setMode(HidroTabPanelController.TAB_MODE_STEP);
        
        ArrayList tabList = new ArrayList();
        HidroTabButtonView hidroTabButtonView = new HidroTabButtonView();
        hidroTabButtonView.setName(HidroTabKey.TAB_METER_TYPE);
        hidroTabButtonView.setText(resourceMap.getString("tab.step1"));
        hidroTabButtonView.setComponent(meterTypePanelView);
        hidroTabButtonView.setEnabled(true);
        hidroTabButtonView.setSelected(true);
        hidroTabButtonView.addMouseListener(tabController);
        tabList.add(hidroTabButtonView);
        
        hidroTabButton2View = new HidroTabButtonView();
        hidroTabButton2View.setName(HidroTabKey.TAB_METER_DETAILS);
        hidroTabButton2View.setText(resourceMap.getString("tab.step2"));
        hidroTabButton2View.setComponent(meterDetailsPanelView);
        hidroTabButton2View.setEnabled(false);
        hidroTabButton2View.addMouseListener(tabController);
        tabList.add(hidroTabButton2View);
        
        tabController.add(tabList);  
        tabController.selectFirstTab();
    }
    
    public void setTabEnabled(String name, boolean enabled) {
        if (name.equals(HidroTabKey.TAB_METER_TYPE)) {
            hidroTabButton2View.setEnabled(enabled);
        }
    }

    public void setTabSelected(String name) {
        tabController.selectTab(name);
    }
    
    public void showTabContent(Component component) {
		CardLayout cl = (CardLayout)contentView.getLayout();
        if (component instanceof MeterTypePanelView) {
            cl.show(contentView, HidroTabKey.TAB_METER_TYPE);
        }        
        if (component instanceof MeterDetailsPanelView) {
            showMeterDetailsTab();
        }
    }
    
    private void showMeterDetailsTab() {
        CardLayout cl = (CardLayout)contentView.getLayout();
        cl.show(contentView, HidroTabKey.TAB_METER_DETAILS);
        
        MeterType meterTypeSelected = meterTypePanelController.getMeterTypeSelected();
        meterDetailsPanelController.setMeterType(meterTypeSelected);
    }
    
    private void close() {
        restart();
        if (dialog!=null) {
            dialog.setVisible(false);
        }
    }
    
    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }   
    
    public void restart() {
        setTabSelected(HidroTabKey.TAB_METER_TYPE);
        meterTypePanelController.unselectMeterTypeNodeList();
    }    
    
}
