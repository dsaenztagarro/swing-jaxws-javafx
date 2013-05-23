/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.administrator.details;

import hidrocon.core.generic.pattern.observer.AppEvent;
import hidrocon.core.pattern.mvc.HidroController;
import hidrocon.core.utils.ActionKey;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.custom.Constant;
import hidrocon.ui.neighbour.main.NeighbourMainPanelModel;
import hidrocon.webservice.Administrator;
import java.awt.event.ActionEvent;
import java.util.Observable;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

/**
 *
 * @author David Sáenz Tagarro
 */
public class AdministratorDetailsController extends HidroController {
    
    private int mode;
    private JDialog dialog;
    private Administrator administrator;
    
    private AdministratorDetailsModel model;
    private AdministratorDetailsView view;
    
    public AdministratorDetailsController(AdministratorDetailsModel model, AdministratorDetailsView view) {
        this.model = model;
        this.view = view;
        view.buttonActionListeners(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
        if (action.equals(ActionKey.ADMINISTRATOR_DETAILS_EDIT)) {
            editAdministrator();
        }        
        else if (action.equals(ActionKey.ADMINISTRATOR_DETAILS_SAVE)) {
            saveAdministrator();
        }
        else if (action.equals(ActionKey.ADMINISTRATOR_DETAILS_CLOSE)) {
            close();
        }        
    }

    @Override
    public void update(Observable o, Object arg) {
        AppEvent message = (AppEvent)arg;
        String action = message.getEventName();
        Object argument = message.getArgument();
        
        if (o instanceof NeighbourMainPanelModel) {
            if (action.equals(ObservableActionKey.INFO_CREATED)) {
                showMessageAdministratorCreated();
            }
            else if (action.equals(ObservableActionKey.INFO_UPDATED)) {
                showMessageAdministratorUpdated();
            }
        }
    }
    
    public void showMessageAdministratorCreated() {
        model.showMessageAdministratorCreated();
        close();
    }
    
    public void showMessageAdministratorUpdated() {
        model.showMessageAdministratorUpdated();
        close();
    }
    
    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
        
        view.writeData(administrator);
    }
    
    private void editAdministrator() {
        view.setMode(Constant.VIEW_MODE_UPDATE);
    }
    
    private void saveAdministrator() {
        view.readData(administrator);
        if (mode == Constant.VIEW_MODE_CREATION) {
            model.createAdministrator(administrator);
        }
        else if (mode == Constant.VIEW_MODE_UPDATE) {
            model.updateAdministrator(administrator);
        }
    }
    
    private void close() {
        if (dialog!=null) {
            dialog.setVisible(false);
        }
    }
    
    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }
    
    protected void initKeyBinding() {
        javax.swing.Action editAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                editAdministrator();
            }
        };   
        
        javax.swing.Action saveAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                saveAdministrator();
            }
        };        

        javax.swing.Action closeAction = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                close();
            }
        };        
        
        JPanel mainPanel = view.getMainPanel();
        
        SwingUtilities.replaceUIActionMap(mainPanel, null);
        SwingUtilities.replaceUIInputMap(mainPanel, JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT, null);
        
        InputMap inputMap = mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke("F10"),"editAdministrator_F10");        
        inputMap.put(KeyStroke.getKeyStroke("F11"),"saveAdministrator_F11");
        inputMap.put(KeyStroke.getKeyStroke("F12"),"closeAdministrator_F12");
        mainPanel.getActionMap().put("editAdministrator_F10",editAction);
        mainPanel.getActionMap().put("saveAdministrator_F11",saveAction);
        mainPanel.getActionMap().put("closeAdministrator_F12",closeAction);        
    } 
    
}
