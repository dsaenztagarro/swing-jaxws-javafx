/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MeterNodeView.java
 *
 * Created on 06-dic-2011, 13:53:35
 */
package hidrocon.component.meter;

import hidrocon.HidroconView;
import hidrocon.core.database.neighbourmeter.entities.NeighbourMeter;
import hidrocon.core.database.neighbourmeter.entities.NeighbourMeterView;
import hidrocon.custom.button.section.HidroDeleteButton;
import hidrocon.custom.button.section.HidroSaveButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;

/**
 *
 * @author David Sáenz Tagarro
 */
public class MeterCounterNodeView extends javax.swing.JPanel {

    private HidroDeleteButton deleteButton;
    private HidroSaveButton saveButton;
    
    /** Creates new form MeterNodeView */
    public MeterCounterNodeView() {
        initComponents();
        setMinimumSize(new Dimension(231, 93));
        setMaximumSize(new Dimension(231, 93));
        setPreferredSize(new Dimension(231, 93));
        
        //initTopPanel();*/
    }
    
	protected void initTopPanel() {
		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
		
		saveButton = new HidroSaveButton();
		deleteButton = new HidroDeleteButton();
        		
		deleteButton.setToolTipText(resourceMap.getString("neighbour.details.toolbar.savebutton.tooltip"));
		saveButton.setToolTipText(resourceMap.getString("neighbour.details.toolbar.exitbutton.tooltip"));
        
        //topPanel.addButton(saveButton);
        //topPanel.addButton(deleteButton);
	}
    
    public void writeData(NeighbourMeterView nmv) {
        //topPanel.setTitle("  " + nmv.getMeterTypeName()); 
        //topPanel.setImageIcon(new HidroCustomLegend(nmv.getMeterTypeName(), nmv.getMeterTypeImagePath()));
        //serialNumberField.setText(nmv.getSerialNumber());
        
        legendPanel.setHexLightColor(nmv.getHexLightColor());
        legendPanel.setHexDarkColor(nmv.getHexDarkColor());
    }
    
    public void readData(NeighbourMeter neighbourMeter) {
        
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

        mainPanel = new hidrocon.custom.panel.HidroItemContentPanel();
        jPanel1 = new javax.swing.JPanel();
        serialNumberLabel = new hidrocon.custom.label.HidroLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        legendPanel = new hidrocon.custom.panel.HidroLegendPanel();

        setName("Form"); // NOI18N
        setOpaque(false);
        setLayout(new java.awt.BorderLayout(0, 2));

        mainPanel.setBorder(null);
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setLayout(new java.awt.BorderLayout());

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        serialNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(MeterCounterNodeView.class);
        serialNumberLabel.setText(resourceMap.getString("serialNumberLabel.text")); // NOI18N
        serialNumberLabel.setFont(resourceMap.getFont("serialNumberLabel.font")); // NOI18N
        serialNumberLabel.setName("serialNumberLabel"); // NOI18N
        jPanel1.add(serialNumberLabel, java.awt.BorderLayout.CENTER);

        filler1.setName("filler1"); // NOI18N
        jPanel1.add(filler1, java.awt.BorderLayout.PAGE_START);

        mainPanel.add(jPanel1, java.awt.BorderLayout.CENTER);

        legendPanel.setName("legendPanel"); // NOI18N
        mainPanel.add(legendPanel, java.awt.BorderLayout.WEST);

        add(mainPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel jPanel1;
    private hidrocon.custom.panel.HidroLegendPanel legendPanel;
    private hidrocon.custom.panel.HidroItemContentPanel mainPanel;
    private hidrocon.custom.label.HidroLabel serialNumberLabel;
    // End of variables declaration//GEN-END:variables

    public void setMode(int mode) {
        
    }
    
    public void buttonActionListeners(ActionListener al) {
        //deleteButton.setActionCommand(HidroAction.METER_DELETE);
		//deleteButton.addActionListener(al);
        //saveButton.setActionCommand(HidroAction.METER_SAVE);
		//saveButton.addActionListener(al);
    }  

}
