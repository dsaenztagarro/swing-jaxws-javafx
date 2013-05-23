/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuildingListDialog.java
 *
 * Created on 25-sep-2011, 14:11:52
 */

package hidrocon.ui.route.dialog;

import hidrocon.HidroconView;
import hidrocon.core.database.routebuilding.manager.RouteBuildingManager;
import hidrocon.custom.button.toolbar.HidroExitButton;
import hidrocon.custom.button.toolbar.HidroSelectButton;
import hidrocon.custom.dialog.HidroDialog;
import hidrocon.core.database.route.entities.Route;
import hidrocon.core.database.route.manager.RouteManager;
import hidrocon.core.database.routedate.manager.RouteDateManager;
import hidrocon.custom.dialog.interfaces.ISelector;
import hidrocon.custom.legend.HidroDateSelectionLegend;
import hidrocon.custom.legend.HidroRouteSelectionLegend;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 *
 * @author david
 */
public final class RouteDateSelectionDialog extends HidroDialog implements ISelector {

    private Route routeSelected;
    private List listSelection;
    
    /** Creates new form BuildingListDialog */
    public RouteDateSelectionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initTopPanel();
        customizeComponents();
    }

	/*
	 * HidroDialog abstract methods implementation - BEGIN
	 */    
	protected void initTopPanel() {
		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
		topPanel.setTitle("  " + resourceMap.getString("routedateselection.toppanel.title"));

        HidroSelectButton selectButton = new HidroSelectButton();
        HidroExitButton exitButton = new HidroExitButton();
        
 		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //selectBuilding();
			}
		});
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});

        selectButton.setToolTipText(resourceMap.getString("routedateselection.toolbar.selectbutton.tooltip"));
        exitButton.setToolTipText(resourceMap.getString("routedateselection.toolbar.exitbutton.tooltip"));

        topPanel.addButton(selectButton);
        topPanel.addButton(exitButton);
	}
    
    protected void customizeComponents() {
        routeSelectionSection.setImageIcon(new HidroRouteSelectionLegend());                        
        dateSelectionSection.setImageIcon(new HidroDateSelectionLegend());
        initRouteTable();
    }
    
    private void initRouteTable() {
        routeTable.setTableHeader(null);
        routeTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {   
                if (routeTable.getSelectedRow() > -1) {
                    routeSelected = routeList.get(routeTable.convertRowIndexToModel(routeTable.getSelectedRow()));
                    loadRouteDate();
                }
            }
            public void mouseReleased(MouseEvent e){}                        
            public void mouseEntered(MouseEvent e){}            
            public void mouseExited(MouseEvent e){}
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        routeTable.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN){
                    routeSelected = routeList.get(routeTable.convertRowIndexToModel(routeTable.getSelectedRow()));
                    //System.out.println("mouseclicked.routeSelected: " + routeSelected);
                    loadRouteDate();                    
                }                 
            }
            public void keyPressed(KeyEvent e) {}
        });
        
        dateTable.setTableHeader(null);
    }    
    
    private void loadRouteDate() {
        System.out.println("loadRouteDate");
        if (routeSelected!=null) {
            getRouteDateList().clear();
            //setRouteDateList(new java.util.ArrayList());
            RouteDateManager rdm = new RouteDateManager();
            System.out.println("loadRouteDate.list: " + rdm.getAllRouteDate(routeSelected.getId()));
            getRouteDateList().addAll(rdm.getAllRouteDate(routeSelected.getId()));
            //propertyChangeSupport.firePropertyChange("routeDateList", oldRecord, getRouteDateList());
        }
    }    
    
    protected void enableAllFields(boolean enabled) {
        //do nothing
    }
	/*
	 * HidroDialog abstract methods implementation - END
	 */
    
    /*private void selectRoute() {
        listSelection = new java.util.ArrayList();
        int[] rowIndex = routeTable.getSelectedRows();
        for (int i=0; i<rowIndex.length; i++) {
            Building building = getRouteList().get(routeTable.convertRowIndexToModel(rowIndex[i]));
            listSelection.add(building);
            //System.out.println("building[" + i + "] = " + building.getInicial());
        }
        close();
    }*/
    
    private void close() {
        setVisible(false);
    }
    
    public boolean isSelection() {
        return listSelection!=null && !listSelection.isEmpty();
    }
    
    public List getSelection() {
        return listSelection;
    }
    
	public void reload() {
        listSelection = null;
        RouteBuildingManager rbm = new RouteBuildingManager();
		//Refresh table
		java.util.List<Route> oldRecord = this.getRouteList();
		setRouteList((List<Route>) org.jdesktop.observablecollections.ObservableCollections.observableList(rbm.getBuildingAvailableList()));
		propertyChangeSupport.firePropertyChange("routeList", oldRecord, getRouteList());
	}
	
    /** This method is called from within the constructor to
     * initialize the form.<Building>
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        RouteManager routeManager = new RouteManager();
        routeList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(routeManager.getAllRoute());
        routeDateList = org.jdesktop.observablecollections.ObservableCollections.observableList(new java.util.ArrayList<hidrocon.core.database.routedate.entities.RouteDate>());
        topPanel = new hidrocon.custom.panel.HidroTopPanel();
        mainPanel = new hidrocon.custom.panel.HidroMainPanel();
        routeSelectionSection = new hidrocon.custom.panel.HidroSectionPanel();
        routeScrollPane = new javax.swing.JScrollPane();
        routeTable = new hidrocon.custom.table.HidroDetailsTable();
        dateSelectionSection = new hidrocon.custom.panel.HidroSectionPanel();
        dateScrollPane = new javax.swing.JScrollPane();
        dateTable = new hidrocon.custom.table.HidroDetailsTable();
        leftFiller = new javax.swing.Box.Filler(new java.awt.Dimension(24, 0), new java.awt.Dimension(24, 0), new java.awt.Dimension(24, 32767));
        rightFiller = new javax.swing.Box.Filler(new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 32767));
        bottomFiller = new javax.swing.Box.Filler(new java.awt.Dimension(0, 25), new java.awt.Dimension(0, 25), new java.awt.Dimension(32767, 25));

        setBounds(new java.awt.Rectangle(0, 0, 400, 491));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setName("Form"); // NOI18N

        topPanel.setName("topPanel"); // NOI18N
        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

        mainPanel.setMinimumSize(new java.awt.Dimension(432, 456));
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(432, 456));
        mainPanel.setLayout(new java.awt.GridBagLayout());

        routeSelectionSection.setName("routeSelectionSection"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        mainPanel.add(routeSelectionSection, gridBagConstraints);

        routeScrollPane.setBorder(null);
        routeScrollPane.setName("routeScrollPane"); // NOI18N

        routeTable.setName("routeTable"); // NOI18N

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${routeList}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, routeTable, "");
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${routeName}"));
        columnBinding.setColumnName("Route Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        routeTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                processKeyPressed(evt);
            }
        });
        routeScrollPane.setViewportView(routeTable);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(RouteDateSelectionDialog.class);
        routeTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        routeTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("routeTable.columnModel.title0")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 150;
        mainPanel.add(routeScrollPane, gridBagConstraints);

        dateSelectionSection.setName("dateSelectionSection"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        mainPanel.add(dateSelectionSection, gridBagConstraints);

        dateScrollPane.setBorder(null);
        dateScrollPane.setName("dateScrollPane"); // NOI18N

        dateTable.setBorder(null);
        dateTable.setName("dateTable"); // NOI18N

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, routeDateList, dateTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${meterReadingDate}"));
        columnBinding.setColumnName("Meter Reading Date");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        dateTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dateTableprocessKeyPressed(evt);
            }
        });
        dateScrollPane.setViewportView(dateTable);
        dateTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        dateTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("dateTable.columnModel.title0")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 150;
        mainPanel.add(dateScrollPane, gridBagConstraints);

        leftFiller.setName("leftFiller"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        mainPanel.add(leftFiller, gridBagConstraints);

        rightFiller.setName("rightFiller"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        mainPanel.add(rightFiller, gridBagConstraints);

        bottomFiller.setName("bottomFiller"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(bottomFiller, gridBagConstraints);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    /** Closes the dialog */
	private void processKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_processKeyPressed
		int keyCode = evt.getKeyCode();
		if (keyCode == KeyEvent.VK_ENTER) {
			evt.consume();
		}
		else if (keyCode == KeyEvent.VK_ESCAPE) {
			//this.closeDialog(null);
		}
	}//GEN-LAST:event_processKeyPressed

    private void dateTableprocessKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateTableprocessKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTableprocessKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler bottomFiller;
    private javax.swing.JScrollPane dateScrollPane;
    private hidrocon.custom.panel.HidroSectionPanel dateSelectionSection;
    private hidrocon.custom.table.HidroDetailsTable dateTable;
    private javax.swing.Box.Filler leftFiller;
    private hidrocon.custom.panel.HidroMainPanel mainPanel;
    private javax.swing.Box.Filler rightFiller;
    private java.util.List<hidrocon.core.database.routedate.entities.RouteDate> routeDateList;
    private java.util.List<Route> routeList;
    private javax.swing.JScrollPane routeScrollPane;
    private hidrocon.custom.panel.HidroSectionPanel routeSelectionSection;
    private hidrocon.custom.table.HidroDetailsTable routeTable;
    private hidrocon.custom.panel.HidroTopPanel topPanel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables


    /**
     * @return the routeList
     */
    public java.util.List<Route> getRouteList() {
        return routeList;
    }

    /**
     * @param routeList the routeList to set
     */
    public void setRouteList(java.util.List<Route> routeList) {
        this.routeList = routeList;
    }

    /**
     * @return the routeDateList
     */
    public List getRouteDateList() {
        return routeDateList;
    }

    /**
     * @param routeDateList the routeDateList to set
     */
    public void setRouteDateList(List routeDateList) {
        this.routeDateList = routeDateList;
    }

    
}
