/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon;

import hidrocon.core.migration.utils.MigrationUtils;
import hidrocon.core.utils.ActionKey;
import hidrocon.custom.Constant;
import hidrocon.ui.administrator.menu.AdministratorMenuController;
import hidrocon.ui.administrator.menu.AdministratorMenuModel;
import hidrocon.ui.administrator.menu.AdministratorMenuView;
import hidrocon.ui.building.menu.BuildingMenuController;
import hidrocon.ui.building.menu.BuildingMenuModel;
import hidrocon.ui.building.menu.BuildingMenuView;
import hidrocon.ui.comment.panels.CommentController;
import hidrocon.ui.comment.panels.CommentModel;
import hidrocon.ui.comment.panels.CommentView;
import hidrocon.ui.rate.panels.RateController;
import hidrocon.ui.rate.panels.RateModel;
import hidrocon.ui.rate.panels.RateView;
import hidrocon.ui.route.menu.RouteMenuController;
import hidrocon.ui.route.menu.RouteMenuModel;
import hidrocon.ui.route.menu.RouteMenuView;
import hidrocon.invoice.meterreading.menu.MeterReadingMenuController;
import hidrocon.invoice.meterreading.menu.MeterReadingMenuModel;
import hidrocon.invoice.meterreading.menu.MeterReadingMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author David Sáenz Tagarro
 */
public class HidroconController implements ActionListener {
    
    private HidroconView view;
    private HidroconModel model;
    
    private AdministratorMenuModel administratorModel;
    private AdministratorMenuView administratorView;
    private AdministratorMenuController administratorController;

    private CommentModel commentModel;
    private CommentView commentView;
    private CommentController commentController;
    
    private BuildingMenuModel buildingMenuModel;
    private BuildingMenuView buildingMenuView;    
    private BuildingMenuController buildingMenuController;

    private RouteMenuModel routeModel;
    private RouteMenuView routeView;
    private RouteMenuController routeController;
    
    private RateModel rateModel;
    private RateView rateView;
    private RateController rateController;
    
    private MeterReadingMenuModel meterReadingMenuModel;
    private MeterReadingMenuView meterReadingMenuView;
    private MeterReadingMenuController meterReadingMenuController;
    
    public HidroconController(HidroconView view, HidroconModel model) {
        this.view = view;
        this.model = model;
        
        view.initMenuAction(this);
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
        if (action.equals(ActionKey.MENU_MIGRATION)) {
            executeMigrationMenu();
        }
        else if (action.equals(ActionKey.MENU_ADMINISTRATOR)) {
            showAdministratorMenu();
        }
        else if (action.equals(ActionKey.MENU_COMMENT)) {
            showCommentMenu();
        }        
        else if (action.equals(ActionKey.MENU_ROUTE)) {
            showRouteMenu();
        }        
        else if (action.equals(ActionKey.MENU_BUILDING)) {
            showBuildingMenu();
        }                
        else if (action.equals(ActionKey.MENU_RATE)) {
            showRateMenu();
        }          
        else if (action.equals(ActionKey.MENU_METERREADING)) {
            showMeterReadingMenu();
        }          
        
    }
    
    public void showAdministratorMenu() {
        if (administratorView==null) {
            administratorModel = new AdministratorMenuModel();
            administratorView = new AdministratorMenuView(Constant.ENTITY_MANAGEMENT_MODE_DEFAULT);
            administratorController = new AdministratorMenuController(administratorModel, administratorView);
        }        
        view.setComponentObj(administratorView);
    }
    
    public void showCommentMenu() {
        if (commentView==null) {
            commentModel = new CommentModel();
            commentView = new CommentView();
            commentController = new CommentController(commentModel, commentView);
        }        
        view.setComponentObj(commentView);        
    }
    
    public void showRouteMenu() {
        if (routeView==null) {
            routeModel = new RouteMenuModel();
            routeView = new RouteMenuView();
            routeController = new RouteMenuController(routeModel, routeView);
        }        
        view.setComponentObj(routeView);        
    }

    public void showRateMenu() {
        if (rateView==null) {
            rateModel = new RateModel();
            rateView = new RateView(Constant.ENTITY_MANAGEMENT_MODE_DEFAULT);
            rateController = new RateController(rateModel, rateView);
        }        
        view.setComponentObj(rateView);        
    }
    
    public void showBuildingMenu() {
        if (buildingMenuView == null) {
            buildingMenuModel = new BuildingMenuModel();
            buildingMenuView = new BuildingMenuView();
            buildingMenuController = new BuildingMenuController(buildingMenuModel, buildingMenuView);
        }
        view.setComponentObj(buildingMenuView);
    }
    
    public void showMeterReadingMenu() {
        if (meterReadingMenuView == null) {
            meterReadingMenuModel = new MeterReadingMenuModel();
            meterReadingMenuView = new MeterReadingMenuView();            
            meterReadingMenuController = new MeterReadingMenuController(meterReadingMenuModel, meterReadingMenuView);
        }
        view.setComponentObj(meterReadingMenuView);
    }
    
    public void executeMigrationMenu() {
        MigrationUtils mu = new MigrationUtils();
        mu.execute();
    }
    
}
