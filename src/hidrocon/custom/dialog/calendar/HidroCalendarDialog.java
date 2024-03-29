/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RouteDetailsDialog.java
 *
 * Created on 09-oct-2011, 5:37:44
 */

package hidrocon.custom.dialog.calendar;

import hidrocon.HidroconView;
import hidrocon.core.database.route.entities.Route;
import hidrocon.custom.button.toolbar.HidroEditButton;
import hidrocon.custom.button.toolbar.HidroExitButton;
import hidrocon.custom.button.toolbar.HidroSaveButton;
import hidrocon.custom.dialog.HidroDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;
import javax.persistence.Transient;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

/**
 *
 * @author david
 */
public final class HidroCalendarDialog extends HidroDialog {

    private boolean routeEditable = false;
	private boolean routeSaved = false;
	
    /** Creates new form BuildingDetailsDialog */
    public HidroCalendarDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        
        initComponents();
		initTopPanel();
        initKeyBinding();
    }

	/*
	 * HidroDialog methods implementation
	 */
    
	protected void initTopPanel() {
		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
		topPanel.setTitle("  " + resourceMap.getString("route.details.toppanel.title"));

        HidroEditButton editButton = new HidroEditButton();
		HidroSaveButton saveButton = new HidroSaveButton();
        HidroExitButton exitButton = new HidroExitButton();
        
 		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                editRoute();
			}
		});       
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveRoute();
			}
		});
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
                
        saveButton.setToolTipText(resourceMap.getString("route.toolbar.editbutton.tooltip"));
		saveButton.setToolTipText(resourceMap.getString("route.toolbar.savebutton.tooltip"));
        exitButton.setToolTipText(resourceMap.getString("route.toolbar.exitbutton.tooltip"));

        topPanel.addButton(editButton);
		topPanel.addButton(saveButton);
        topPanel.addButton(exitButton);
	}

    protected void initKeyBinding() {
        javax.swing.Action editAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                editRoute();
            }
        };   
        
        javax.swing.Action saveAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                saveRoute();
            }
        };        

        javax.swing.Action closeAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                close();
            }
        };            
        SwingUtilities.replaceUIActionMap(mainPanel, null);
        SwingUtilities.replaceUIInputMap(mainPanel, JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT, null);
        
        InputMap inputMap = mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);        
        inputMap.put(KeyStroke.getKeyStroke("F11"),"saveRoute_F11");
        inputMap.put(KeyStroke.getKeyStroke("F12"),"closeRoute_F12");
        mainPanel.getActionMap().put("saveRoute_F11",saveAction);
        mainPanel.getActionMap().put("closeRoute_F12",closeAction);        
    }
    
    protected void initFocus() {
        //do nothing
    }
    
    protected void customizeComponents() {
        //do nothing
    }
    
    public void enableAllFields(boolean enabled) {
        //routenameField.setEditable(enabled);
        routeEditable = enabled;
    }
    
    private void editRoute() {
        if (!routeEditable) {
            enableAllFields(true);
            //routenameField.requestFocus();
        }
    }
    
	private void saveRoute() {
		routeSaved = true;
        close();
	}
	
    private void close() {
        setVisible(false);
        enableAllFields(false);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        route = new hidrocon.core.database.route.entities.Route();
        mainPanel = new hidrocon.custom.panel.HidroPanel();
        calendar = new com.toedter.calendar.JCalendar();
        topPanel = new hidrocon.custom.panel.HidroTopPanel();

        setBounds(new java.awt.Rectangle(0, 0, 315, 270));
        setName("Form"); // NOI18N

        mainPanel.setMaximumSize(new java.awt.Dimension(315, 235));
        mainPanel.setMinimumSize(new java.awt.Dimension(315, 235));
        mainPanel.setName("mainPanel"); // NOI18N

        calendar.setMinSelectableDate(new java.util.Date(631152074000L));
        calendar.setName("calendar"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        topPanel.setName("topPanel"); // NOI18N
        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar calendar;
    private hidrocon.custom.panel.HidroPanel mainPanel;
    private hidrocon.core.database.route.entities.Route route;
    private hidrocon.custom.panel.HidroTopPanel topPanel;
    // End of variables declaration//GEN-END:variables

	/*
	 * Binding fields
	 */

	@Transient
	public PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	@Override
	public void addPropertyChangeListener(PropertyChangeListener l) {
		propertyChangeSupport.addPropertyChangeListener(l);
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener l) {
		propertyChangeSupport.removePropertyChangeListener(l);
	}

    /*
     * Methods called from parent 
     */
    
	/**
	 * @return the Route
	 */ public Route getRoute() {
		return route;
	}

	/**
	 * @param building the building to set
	 */ 
	 public void setRoute(Route route) {
        enableAllFields(false);
        Route oldRecord = this.route;
        this.route = route;
        propertyChangeSupport.firePropertyChange("route", oldRecord, route);
	}
     
	public boolean isRouteSaved() {
		return this.routeSaved;
	}     

    /**
     * Setting dialog mode
     */
    
    public void setCreateMode() {
        enableAllFields(true);
        routeSaved = false;
    }
    
    public void setUpdateMode() {
        enableAllFields(false);
        routeSaved = false;
    }
    
    public Date getDateSelected() {
        return calendar.getDate();
    }
}
