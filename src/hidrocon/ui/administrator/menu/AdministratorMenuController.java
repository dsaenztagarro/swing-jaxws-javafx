/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.administrator.menu;

import hidrocon.core.generic.pattern.observer.AppEvent;
import hidrocon.core.pattern.mvc.HidroController;
import hidrocon.core.utils.ActionKey;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.custom.Constant;
import hidrocon.webservice.Administrator;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JDialog;

/**
 *
 * @author David Sáenz Tagarro
 */
public class AdministratorMenuController extends HidroController {
    
    private JDialog dialog;
    
    private Administrator selection;
    
    private AdministratorMenuModel model;
    private AdministratorMenuView view;
    
    public AdministratorMenuController(AdministratorMenuModel model, AdministratorMenuView view) {
        this.model = model;
        this.view = view;
        view.buttonActionListeners(this);
        view.tableKeyListeners(this);
        view.tableMouseListeners(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
        if (action.equals(ActionKey.ADMINISTRATOR_CREATE)) {
            createAdministrator();
        }        
        else if (action.equals(ActionKey.ADMINISTRATOR_UPDATE)) {
            showAdministrator();
        }
        else if (action.equals(ActionKey.ADMINISTRATOR_DELETE)) {
            deleteAdministrator();
        }        
        else if (action.equals(ActionKey.ADMINISTRATOR_SELECT)) {
            selectAdministrator();
        }        
        else if (action.equals(ActionKey.ADMINISTRATOR_CLOSE)) {
            close();
        }        
        
    }

    @Override
    public void update(Observable o, Object arg) {
        AppEvent message = (AppEvent)arg;
        String action = message.getEventName();
        Object argument = message.getArgument();
        
        if (o instanceof AdministratorMenuModel) {
            if (action.equals(ObservableActionKey.SEARCH_INFO)) {
                doSearchInfo(argument);
            }
            else if (action.equals(ObservableActionKey.INFO_DELETED)) {
                doAdministratorDeleted();
            }
        }
    }

    public void doSearchInfo(Object object) {
        view.setAdministratorList((ArrayList)object);
    }
    
    private void createAdministrator() {
        Administrator administrator = new Administrator();  
        administrator.setRecStatus(Constant.RECORD_STATUS_ACTIVE);
        model.showPopupAdministratorDetails(Constant.VIEW_MODE_CREATION, administrator);
    }
    
    private void showAdministrator() {
        Administrator administrator = view.getAdministratorSelected();  
        model.showPopupAdministratorDetails(Constant.VIEW_MODE_READONLY, administrator);
    }
    
    private void deleteAdministrator() {
        Administrator administrator = view.getAdministratorSelected();  
        boolean deleted = model.deleteAdministrator(administrator);
    }
    
    private void doAdministratorDeleted() {
        view.removeAdministrator(administrator);
        model.showMessageAdministratorDeleted();        
    }
    
    private void selectAdministrator() {
        selection = view.getAdministratorSelected();
        if (selection!=null) {
            close();
        }
    }
    
    private void close() {
        if (dialog!=null) {
            dialog.setVisible(false);
        }
    }
    
    public void clearSelection() {
        selection = null;
    }
    
    public Administrator getAdministratorSelected() {
        return selection;
    }
    
    public boolean isAdministratorSelected() {
        return selection!=null;
    }

    @Override
    public void keyPressed(KeyEvent evt) {
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_F8) {
            createAdministrator();
            evt.consume();
        }
        else if (keyCode == KeyEvent.VK_ENTER) {
            showAdministrator();
            evt.consume();
        }
        else if (keyCode == KeyEvent.VK_F9) {
            deleteAdministrator();
            evt.consume();
        }  
    }
    
    public void mouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            evt.consume();
            showAdministrator();
        }
    }

    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }
}
