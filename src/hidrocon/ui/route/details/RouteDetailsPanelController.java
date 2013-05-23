/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.route.details;

import hidrocon.core.generic.pattern.observer.AppEvent;
import hidrocon.core.pattern.mvc.HidroController;
import hidrocon.core.utils.ActionKey;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.custom.Constant;
import hidrocon.webservice.Route;
import java.awt.event.ActionEvent;
import java.util.Observable;
import javax.swing.JDialog;

/**
 *
 * @author David Sáenz Tagarro
 */
public class RouteDetailsPanelController extends HidroController {
    
    private JDialog dialog;
    private Route route;
    
    private RouteDetailsPanelModel model;
    private RouteDetailsPanelView view;
    
    public RouteDetailsPanelController(RouteDetailsPanelModel model, RouteDetailsPanelView view) {
        this.model = model;
        this.view = view;
        view.buttonActionListeners(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
        if (action.equals(ActionKey.ROUTE_DETAILS_EDIT)) {
            editRoute();
        }        
        else if (action.equals(ActionKey.ROUTE_DETAILS_SAVE)) {
            saveRoute();
        }
        else if (action.equals(ActionKey.ROUTE_DETAILS_CLOSE)) {
            close();
        }        
    }

    @Override
    public void update(Observable o, Object arg) {
        AppEvent message = (AppEvent)arg;
        String action = message.getEventName();
        Object argument = message.getArgument();
        
        if (o instanceof RouteDetailsPanelModel) {
            if (action.equals(ObservableActionKey.INFO_CREATED)) {
                showMessageAdministratorCreated();
            }
            else if (action.equals(ObservableActionKey.INFO_UPDATED)) {
                showMessageAdministratorUpdated();
            }
        }
    }
    
    public void showMessageAdministratorCreated() {
        model.showMessageRouteCreated();
        close();
    }
    
    public void showMessageAdministratorUpdated() {
        model.showMessageRouteUpdated();
        close();
    }
    
    public void setRoute(Route route) {
        this.route = route;
        
        view.writeData(route);
    }
    
    private void editRoute() {
        view.setMode(Constant.VIEW_MODE_UPDATE);
    }
    
    private void saveRoute() {
        view.readData(route);
        close();
    }
    
    private void close() {
        if (dialog!=null) {
            dialog.setVisible(false);
        }
    }
    
    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }
}
