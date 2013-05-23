/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.custom.utils;

import hidrocon.HidroconApp;
import java.util.HashMap;
import hidrocon.custom.dialog.HidroDialog;
import hidrocon.ui.administrator.dialog.AdministratorDetailsDialog;
import hidrocon.ui.administrator.dialog.AdministratorSelectionDialog;
import hidrocon.ui.building.dialog.BuildingDetailsDialog;
import hidrocon.ui.comment.panels.dialogs.CommentDetailsDialog;
import hidrocon.ui.meter.dialog.MeterCreationDialog;
import hidrocon.ui.neighbour.dialog.NeighbourDetailsDialog;
import hidrocon.ui.neighbour.dialog.NeighbourDialog;
import hidrocon.ui.rate.panels.dialogs.RateDetailsDialog;
import hidrocon.ui.rate.panels.dialogs.RateSelectionDialog;
import hidrocon.ui.route.dialog.BuildingSelectionDialog;
import hidrocon.ui.route.dialog.DateSelectionDialog;
import hidrocon.ui.route.dialog.RouteBuildingDateDetailsDialog;
import hidrocon.ui.route.dialog.RouteDateSelectionDialog;
import hidrocon.ui.route.dialog.RouteDetailsDialog;
import javax.swing.JFrame;

/**
 *
 * @author davlanca
 */
public class HidroDialogFactory {
    
    public static final int RATE_DETAILS = 1;
    public static final int ADMINISTRATOR_DETAILS = 2;
    public static final int COMMENT_DETAILS = 3;
    public static final int NEIGHBOUR_LIST = 4;
    public static final int NEIGHBOUR_DETAILS = 5;
    public static final int BUILDING_DETAILS = 6;
    public static final int BUILDING_DETAILS_ADMINISTRATOR = 7;
    public static final int BUILDING_DETAILS_RATE = 8;
    public static final int ROUTE_DETAILS = 9;
    public static final int ROUTE_DATE_SELECTION = 10;
    public static final int ROUTE_BUILDING_DATE_DETAILS = 11;
    public static final int ADMINISTRATOR_SELECTION = 12;
    public static final int DATE_SELECTION = 13;
    public static final int ROUTE_BUILDING_SELECTION = 14;
    public static final int RATE_SELECTION = 15;
    public static final int METER_CREATION = 16;
    
    private HashMap dialogs;
    private static HidroDialogFactory singleton;
    
    private HidroDialogFactory() {
        dialogs = new HashMap();
    }
    
    public static HidroDialogFactory getInstance() {
        if (singleton==null) {
            singleton = new HidroDialogFactory();
        }
        return singleton;
    }
    
    public HidroDialog getDialog(int id) {
        HidroDialog dialog = (HidroDialog)dialogs.get(String.valueOf(id));
        JFrame mainFrame = HidroconApp.getApplication().getMainFrame();
        
        if (dialog==null) {
            if (id == RATE_DETAILS) {
                dialog = new RateDetailsDialog(mainFrame,true);
            }
            else if (id == ADMINISTRATOR_DETAILS) {
                dialog = new AdministratorDetailsDialog(mainFrame, true);
            }
            else if (id == COMMENT_DETAILS) {
                dialog = new CommentDetailsDialog(mainFrame, true);
            }
            else if (id == BUILDING_DETAILS) {
                dialog = new BuildingDetailsDialog(mainFrame, true);
            }            
            else if (id == NEIGHBOUR_LIST) {
                dialog = new NeighbourDialog(mainFrame, true);
            }                        
            else if (id == NEIGHBOUR_DETAILS) {
                dialog = new NeighbourDetailsDialog(mainFrame, true);
            }            
            else if (id == BUILDING_DETAILS_ADMINISTRATOR) {
                dialog = new AdministratorDetailsDialog(mainFrame, true);
            }
            else if (id == BUILDING_DETAILS_RATE) {
                dialog = new RateDetailsDialog(mainFrame,true);
            }
            else if (id == ROUTE_DETAILS) {
                dialog = new RouteDetailsDialog(mainFrame,true);
            }            
            else if (id == ROUTE_DATE_SELECTION) {
                dialog = new RouteDateSelectionDialog(mainFrame,true);
            }
            else if (id == ROUTE_BUILDING_DATE_DETAILS) {
                dialog = new RouteBuildingDateDetailsDialog(mainFrame,true);
            }
            else if (id == ADMINISTRATOR_SELECTION) {
                dialog = new AdministratorSelectionDialog(mainFrame,true);
            }            
            else if (id == DATE_SELECTION) {
                dialog = new DateSelectionDialog(mainFrame,true);
            }            
            else if (id == ROUTE_BUILDING_SELECTION) {
                dialog = new BuildingSelectionDialog(mainFrame,true);
            }
            else if (id == RATE_SELECTION) {
                dialog = new RateSelectionDialog(mainFrame,true);
            }            
            else if (id == METER_CREATION) {
                dialog = new MeterCreationDialog(mainFrame,true);
            }            
            
            dialogs.put(String.valueOf(id),dialog);
        }

        dialog.centerParent();
        return dialog;
    }
    
    public void clear() {
        dialogs.clear();
        dialogs = null;
    }
    
}
