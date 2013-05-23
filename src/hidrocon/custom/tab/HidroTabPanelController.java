/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.custom.tab;

import hidrocon.core.pattern.mvc.HidroController;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 *
 * @author David Sáenz Tagarro
 */
public class HidroTabPanelController extends HidroController {

    public static final int TAB_MODE_DEFAULT = 0;
    public static final int TAB_MODE_STEP = 1;
    
    private int mode;
    
    private HidroTabPanelView view;
    private HidroTabPanelModel model;
    
    private HidroTabButtonView lastTab;
    private List<HidroTabButtonView> tabList;
            
    private ITabContainer container;
    
    public HidroTabPanelController(HidroTabPanelModel model, HidroTabPanelView view) {
        this.model = model;
        this.view = view;
        mode = TAB_MODE_DEFAULT;
    }
    
    public void setMode(int mode) {
        this.mode = mode;
    }
    
    public void add(List<HidroTabButtonView> tabList) {
        for (int i=0; i<tabList.size(); i++) {
            HidroTabButtonView tabButton = (HidroTabButtonView)tabList.get(i);
            tabButton.setPosition(i);
            view.add(tabButton);
        }
        this.tabList = tabList;
    }
    
    public void selectFirstTab() {
        if (tabList.size()>0) {
            HidroTabButtonView tab = (HidroTabButtonView)tabList.get(0);
            selectTab(tab);
        }        
    }

    private void selectTab(HidroTabButtonView tab) {
        if (lastTab!=null) {
            lastTab.setSelected(false);
        }        
        tab.setEnabled(true);
        tab.setSelected(true);
        container.showTabContent(tab.getComponent());
        lastTab = tab;        
    }
    
    private HidroTabButtonView findTabByName(String name) {
        for (HidroTabButtonView tab : tabList) {
            if (tab.getName().equals(name)) {
                return tab;
            }
        }      
        return null;
    }
    
    private boolean isStepMode() {
        return mode == TAB_MODE_STEP;
    }
    
    public void selectTab(String name) {
        HidroTabButtonView tab = findTabByName(name);
        selectTab(tab);
        if (isStepMode()) {
            for (int i=0; i<tab.getPosition(); i++) {
                tabList.get(i).setEnabled(false);
            }
            for (int i=tab.getPosition()+1; i<tabList.size(); i++) {
                tabList.get(i).setEnabled(false);
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        HidroTabButtonView tab = (HidroTabButtonView)e.getComponent();
        Component component = tab.getComponent();
        
        if (!tab.isSelected() && tab.isEnabled()) {
            if (container != null) {
                container.showTabContent(component);
            }
            
            tab.setSelected(true);
            lastTab.setSelected(false);
            lastTab = tab;
        }
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        HidroTabButtonView tab = (HidroTabButtonView)e.getComponent();
        if (tab.isEnabled() && !tab.isSelected()) {
            tab.setMouseEnteredStyle();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        HidroTabButtonView tab = (HidroTabButtonView)e.getComponent();
        if (tab.isEnabled() && !tab.isSelected()) {
            tab.setMouseExitedStyle();
        }
    }
    
    public void setContainerController(ITabContainer container) {
        this.container = container;
    }
    
}
