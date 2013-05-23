/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RateView.java
 *
 * Created on 14-sep-2011, 23:07:33
 */

package hidrocon.ui.rate.panels;

import hidrocon.HidroconView;
import hidrocon.core.database.rate.manager.RateManager;
import hidrocon.core.database.rate.entities.Rate;
import hidrocon.core.utils.ActionKey;
import hidrocon.custom.Constant;
import hidrocon.custom.button.toolbar.HidroDeleteButton;
import hidrocon.custom.button.toolbar.HidroExitButton;
import hidrocon.custom.button.toolbar.HidroInfoButton;
import hidrocon.custom.button.toolbar.HidroNewButton;
import hidrocon.custom.button.toolbar.HidroPrintButton;
import hidrocon.custom.button.toolbar.HidroSelectButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author david
 */
public class RateView extends hidrocon.custom.panel.HidroMainPanel {

    private int mode;
    
	private final int COLUMN_NUMBER = 0;
	private final int COLUMN_NAME = 1;

    HidroPrintButton printButton;
    HidroNewButton newButton;
    HidroInfoButton infoButton;
    HidroDeleteButton deleteButton;
    HidroSelectButton selectButton;
    HidroExitButton closeButton;
    
    /** Creates new form RateView */
    public RateView(int mode) {
        this.mode = mode;
        initComponents();
		initTopPanel();
        initSearchFields();
        initFocus();      
    }

	/*
	 * Toolbar initialization
	 */
    
	private void initTopPanel() {
		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
		if (this.mode == Constant.ENTITY_MANAGEMENT_MODE_DEFAULT) {
            topPanel.setTitle("  " + resourceMap.getString("rate.toppanel.title"));
        } 
        else if (this.mode == Constant.ENTITY_MANAGEMENT_MODE_SELECTION) {
            topPanel.setTitle("  " + resourceMap.getString("rate.selection.toppanel.title"));
        }
        
		printButton = new HidroPrintButton();
		newButton = new HidroNewButton();
		infoButton = new HidroInfoButton();
		deleteButton = new HidroDeleteButton();
        selectButton = new HidroSelectButton();
        closeButton = new HidroExitButton();        

		printButton.setToolTipText(resourceMap.getString("rate.toolbar.printbutton.tooltip"));
		newButton.setToolTipText(resourceMap.getString("rate.toolbar.newbutton.tooltip"));
		infoButton.setToolTipText(resourceMap.getString("rate.toolbar.infobutton.tooltip"));
		deleteButton.setToolTipText(resourceMap.getString("rate.toolbar.deletebutton.tooltip"));
        selectButton.setToolTipText(resourceMap.getString("rate.toolbar.selectbutton.tooltip"));
        closeButton.setToolTipText(resourceMap.getString("rate.toolbar.closebutton.tooltip"));
        
        if (mode == Constant.ENTITY_MANAGEMENT_MODE_DEFAULT) {
            topPanel.addButton(printButton);
            topPanel.addButton(newButton);
            topPanel.addButton(infoButton);
            topPanel.addButton(deleteButton);
        }
        if (mode == Constant.ENTITY_MANAGEMENT_MODE_SELECTION) {
            topPanel.addButton(selectButton);
            topPanel.addButton(closeButton);
        }           
	}
    
    private void initFocus() {
        //rateTable.setFocusCycleRoot(true);
        //rateTable.changeSelection(0,0,false,false);
        //rateTable.requestFocusInWindow();
    }
    
	public void refreshRateList() {
		java.util.List auxList = new java.util.ArrayList();
		auxList.addAll(rateList);
		rateList.clear();
		rateList.addAll(auxList);
	}    
    
    public Rate getRateSelected() {
		if (rateTable.getSelectedRow() > -1) {
			return rateList.get(rateTable.convertRowIndexToModel(rateTable.getSelectedRow()));
        }
        return null;
    }
    
    public void addRate(Rate rate) {
        rateList.add(rate);
    }
    
    public void removeRate(Rate rate) {
        rateList.remove(rate);        
    }
    
    /*
	 * Search filter methods
	 */

	private void initSearchFields() {
		initSearchNomAdmin();
		initSearchNumAdmin();
	}

	private void initSearchNomAdmin() {
		nomadmField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				newNomAdminFilter();
			}
			public void insertUpdate(DocumentEvent e) {
				newNomAdminFilter();
			}
			public void removeUpdate(DocumentEvent e) {
				newNomAdminFilter();
			}
		});
	}
	
	private void initSearchNumAdmin() {
		numadmField.getDocument().addDocumentListener(
            new DocumentListener() {
                public void changedUpdate(DocumentEvent e) {
                    newNumAdminFilter();
                }
                public void insertUpdate(DocumentEvent e) {
                    newNumAdminFilter();
                }
                public void removeUpdate(DocumentEvent e) {
                    newNumAdminFilter();
                }
            });
	}

    private void newNomAdminFilter() {
		String value = nomadmField.getText();
		if (value!=null && !value.equals("")) {
			clearOtherFilters(COLUMN_NAME);
			rateTable.newFilter(value, COLUMN_NAME);
		} else {
			rateTable.clearFilter();
		}
    }

    private void newNumAdminFilter() {		
		String value = numadmField.getText();
		if (value!=null && !value.equals("")) {
			clearOtherFilters(COLUMN_NUMBER);
			rateTable.newNumberFilter(new Integer(value), COLUMN_NUMBER);
		} else {
			rateTable.clearFilter();
		}
    }

	private void clearOtherFilters(int selectedColumn) {
		if (selectedColumn == COLUMN_NAME) {
			numadmField.setText("");
		}
		else if (selectedColumn == COLUMN_NUMBER) {
			nomadmField.setText("");
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        RateManager rateManager = new RateManager();
        rateList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(rateManager.getAllRate());
        topPanel = new hidrocon.custom.panel.HidroTopPanel();
        mainPanel = new hidrocon.custom.panel.HidroMainPanel();
        mainTopPanel = new hidrocon.custom.panel.HidroPanel();
        nomadmLabel = new hidrocon.custom.label.HidroLabel();
        nomadmField = new hidrocon.custom.field.HidroTextField();
        nomadmLegend = new hidrocon.custom.legend.FilterLegend();
        numadmLabel = new hidrocon.custom.label.HidroLabel();
        numadmField = new hidrocon.custom.field.HidroTextField();
        numadmLegend = new hidrocon.custom.legend.FilterLegend();
        rateScrollPane = new javax.swing.JScrollPane();
        rateTable = new hidrocon.custom.table.HidroTable();
        leftFiller = new javax.swing.Box.Filler(new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 32767));
        rightFiller = new javax.swing.Box.Filler(new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 0), new java.awt.Dimension(20, 32767));
        bottomFiller = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));

        setName("Form"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        topPanel.setName("topPanel"); // NOI18N
        add(topPanel, java.awt.BorderLayout.PAGE_START);

        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setLayout(new java.awt.BorderLayout());

        mainTopPanel.setName("mainTopPanel"); // NOI18N
        mainTopPanel.setPreferredSize(new java.awt.Dimension(712, 45));

        nomadmLabel.setName("nomadmLabel"); // NOI18N

        nomadmField.setName("nomadmField"); // NOI18N

        nomadmLegend.setName("nomadmLegend"); // NOI18N

        numadmLabel.setName("numadmLabel"); // NOI18N

        numadmField.setName("numadmField"); // NOI18N

        numadmLegend.setName("numadmLegend"); // NOI18N

        javax.swing.GroupLayout mainTopPanelLayout = new javax.swing.GroupLayout(mainTopPanel);
        mainTopPanel.setLayout(mainTopPanelLayout);
        mainTopPanelLayout.setHorizontalGroup(
            mainTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainTopPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(nomadmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomadmField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(nomadmLegend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(numadmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numadmField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(numadmLegend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(420, Short.MAX_VALUE))
        );
        mainTopPanelLayout.setVerticalGroup(
            mainTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainTopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numadmLegend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomadmLegend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nomadmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nomadmField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(numadmField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(numadmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(mainTopPanel, java.awt.BorderLayout.PAGE_START);

        rateScrollPane.setName("rateScrollPane"); // NOI18N

        rateTable.setName("rateTable"); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, rateList, rateTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${isDefault}"));
        columnBinding.setColumnName("Is Default");
        columnBinding.setColumnClass(Character.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${rateName}"));
        columnBinding.setColumnName("Rate Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        rateScrollPane.setViewportView(rateTable);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(RateView.class);
        rateTable.getColumnModel().getColumn(0).setMinWidth(80);
        rateTable.getColumnModel().getColumn(0).setMaxWidth(80);
        rateTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("rateTable.columnModel.title1")); // NOI18N
        rateTable.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("rateTable.columnModel.title0")); // NOI18N

        mainPanel.add(rateScrollPane, java.awt.BorderLayout.CENTER);

        leftFiller.setName("leftFiller"); // NOI18N
        mainPanel.add(leftFiller, java.awt.BorderLayout.LINE_START);

        rightFiller.setName("rightFiller"); // NOI18N
        mainPanel.add(rightFiller, java.awt.BorderLayout.LINE_END);

        bottomFiller.setName("bottomFiller"); // NOI18N
        mainPanel.add(bottomFiller, java.awt.BorderLayout.PAGE_END);

        add(mainPanel, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler bottomFiller;
    private javax.swing.Box.Filler leftFiller;
    private hidrocon.custom.panel.HidroMainPanel mainPanel;
    private hidrocon.custom.panel.HidroPanel mainTopPanel;
    private hidrocon.custom.field.HidroTextField nomadmField;
    private hidrocon.custom.label.HidroLabel nomadmLabel;
    private hidrocon.custom.legend.FilterLegend nomadmLegend;
    private hidrocon.custom.field.HidroTextField numadmField;
    private hidrocon.custom.label.HidroLabel numadmLabel;
    private hidrocon.custom.legend.FilterLegend numadmLegend;
    private java.util.List<Rate> rateList;
    private javax.swing.JScrollPane rateScrollPane;
    private hidrocon.custom.table.HidroTable rateTable;
    private javax.swing.Box.Filler rightFiller;
    private hidrocon.custom.panel.HidroTopPanel topPanel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the rateList
     */
    public java.util.List<Rate> getRateList() {
        return rateList;
    }

    /**
     * @param rateList the rateList to set
     */
    public void setRateList(java.util.List<Rate> rateList) {
        this.rateList = rateList;
    }

    public void buttonActionListeners(ActionListener al) {
        printButton.setActionCommand(ActionKey.RATE_PRINT);
		printButton.addActionListener(al);
		newButton.setActionCommand(ActionKey.RATE_CREATE);
        newButton.addActionListener(al);
        infoButton.setActionCommand(ActionKey.RATE_UPDATE);
		infoButton.addActionListener(al);
        deleteButton.setActionCommand(ActionKey.RATE_DELETE);
		deleteButton.addActionListener(al);        
        selectButton.setActionCommand(ActionKey.RATE_SELECT);
		selectButton.addActionListener(al);        
        closeButton.setActionCommand(ActionKey.RATE_CLOSE);
		closeButton.addActionListener(al);        
        
    }
    
    public void tableKeyListeners(KeyListener kl) {
        rateTable.addKeyListener(kl);
    }
    
    public void tableMouseListeners(MouseListener ml) {
        rateTable.addMouseListener(ml);
    }
    
}
