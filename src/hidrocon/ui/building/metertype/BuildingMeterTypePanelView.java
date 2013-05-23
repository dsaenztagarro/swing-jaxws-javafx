/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuildingMeterTypePanelView.java
 *
 * Created on 25-dic-2011, 6:39:12
 */
package hidrocon.ui.building.metertype;

import hidrocon.HidroconView;
import hidrocon.core.utils.ActionKey;
import hidrocon.custom.button.section.HidroSaveButton;
import hidrocon.custom.button.toolbar.HidroEditButton;
import hidrocon.custom.button.toolbar.HidroExitButton;
import hidrocon.custom.legend.HidroMeterLegend;
import hidrocon.custom.legend.HidroSeveralDataLegend;
import hidrocon.component.meter.MeterNodeView;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author David Sáenz Tagarro
 */
public class BuildingMeterTypePanelView extends javax.swing.JPanel {

    HidroEditButton editButton;
    HidroSaveButton saveButton;
    HidroExitButton exitButton;
    
    /** Creates new form BuildingMeterTypePanelView */
    public BuildingMeterTypePanelView() {
        initComponents();
        initTopPanel();
        customizeComponents();
    }

    protected void customizeComponents() {
		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        //Sections:
        //Details 2 panel:
        meterSection.setImageIcon(new HidroMeterLegend());
        severalDataSection.setImageIcon(new HidroSeveralDataLegend());
    }
    
	protected void initTopPanel() {
		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
		topPanel.setTitle("  " + resourceMap.getString("neighbour.details.toppanel.title"));
		
		editButton = new HidroEditButton();
		saveButton = new HidroSaveButton();
		exitButton = new HidroExitButton();
        		
		editButton.setToolTipText(resourceMap.getString("neighbourmeter.details.toolbar.editbutton.tooltip"));
		saveButton.setToolTipText(resourceMap.getString("neighbourmeter.details.toolbar.savebutton.tooltip"));
		exitButton.setToolTipText(resourceMap.getString("neighbourmeter.details.toolbar.exitbutton.tooltip"));
        
		topPanel.addButton(editButton);
		topPanel.addButton(saveButton);
        topPanel.addButton(exitButton);
        
        //arrowRightButton.setVisible(true);
	}
    
    public void writeData(List<MeterNodeView> meterViewList) {
        //meterPanel.removeAll();
        for (MeterNodeView meterView : meterViewList) {
            //meterPanel.add(meterView);
        }
    }    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        topPanel = new hidrocon.custom.panel.HidroTopPanel();
        mainPanel = new hidrocon.custom.panel.HidroPanel();
        meterSection = new hidrocon.custom.panel.HidroSectionPanel();
        left2Filler = new javax.swing.Box.Filler(new java.awt.Dimension(25, 25), new java.awt.Dimension(25, 25), new java.awt.Dimension(25, 32767));
        right2Filler = new javax.swing.Box.Filler(new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 32767));
        severalDataSection = new hidrocon.custom.panel.HidroSectionPanel();
        severalDataPanel = new hidrocon.custom.panel.HidroPanel();
        bottom2Filler = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));

        setName("Form"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        topPanel.setMaximumSize(new java.awt.Dimension(580, 35));
        topPanel.setName("topPanel"); // NOI18N
        add(topPanel, java.awt.BorderLayout.PAGE_START);

        mainPanel.setMaximumSize(new java.awt.Dimension(560, 575));
        mainPanel.setMinimumSize(new java.awt.Dimension(560, 575));
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(560, 575));
        mainPanel.setRequestFocusEnabled(false);
        mainPanel.setLayout(new java.awt.GridBagLayout());

        meterSection.setName("meterSection"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        mainPanel.add(meterSection, gridBagConstraints);

        left2Filler.setName("left2Filler"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        mainPanel.add(left2Filler, gridBagConstraints);

        right2Filler.setName("right2Filler"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        mainPanel.add(right2Filler, gridBagConstraints);

        severalDataSection.setName("severalDataSection"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        mainPanel.add(severalDataSection, gridBagConstraints);

        severalDataPanel.setMinimumSize(new java.awt.Dimension(0, 100));
        severalDataPanel.setName("severalDataPanel"); // NOI18N

        javax.swing.GroupLayout severalDataPanelLayout = new javax.swing.GroupLayout(severalDataPanel);
        severalDataPanel.setLayout(severalDataPanelLayout);
        severalDataPanelLayout.setHorizontalGroup(
            severalDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        severalDataPanelLayout.setVerticalGroup(
            severalDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        mainPanel.add(severalDataPanel, gridBagConstraints);

        bottom2Filler.setName("bottom2Filler"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(bottom2Filler, gridBagConstraints);

        add(mainPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler bottom2Filler;
    private javax.swing.Box.Filler left2Filler;
    private hidrocon.custom.panel.HidroPanel mainPanel;
    private hidrocon.custom.panel.HidroSectionPanel meterSection;
    private javax.swing.Box.Filler right2Filler;
    private hidrocon.custom.panel.HidroPanel severalDataPanel;
    private hidrocon.custom.panel.HidroSectionPanel severalDataSection;
    private hidrocon.custom.panel.HidroTopPanel topPanel;
    // End of variables declaration//GEN-END:variables

    public void buttonActionListeners(ActionListener al) {
        editButton.setActionCommand(ActionKey.NEIGHBOUR_DETAILS_EDIT);
		editButton.addActionListener(al);        
        saveButton.setActionCommand(ActionKey.NEIGHBOUR_DETAILS_SAVE);
		saveButton.addActionListener(al);        
        exitButton.setActionCommand(ActionKey.NEIGHBOUR_DETAILS_CLOSE);
		exitButton.addActionListener(al);        
    }
    
    public JPanel getMainPanel() {
        return mainPanel;
    }

}