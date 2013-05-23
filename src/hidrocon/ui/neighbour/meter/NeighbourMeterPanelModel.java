/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.neighbour.meter;

import hidrocon.HidroconApp;
import hidrocon.core.database.neighbour.entities.Neighbour;
import hidrocon.core.database.neighbour.manager.NeighbourManager;
import hidrocon.core.database.neighbourmeter.entities.NeighbourMeter;
import hidrocon.custom.dialog.HidroDialog;
import hidrocon.custom.utils.HidroDialogFactory;
import java.util.List;

/**
 *
 * @author David Sáenz Tagarro
 */
public class NeighbourMeterPanelModel {
    
    public List getNeighbourMeterViewList(Neighbour neighbour) {
        List list = null;
        if (neighbour!=null) {
            NeighbourManager nm = new NeighbourManager();
            list = nm.getNeighbourMeterViewList(neighbour.getId());
        }
        return list;        
    }
    
	public NeighbourMeter createNeighbourMeter() {
        //if (comment!=null) {
            HidroDialogFactory hdf = HidroDialogFactory.getInstance();
            HidroDialog dialog = hdf.getDialog(HidroDialogFactory.METER_CREATION);
            //IEntityManager emDialog = (IEntityManager)dialog;
            //emDialog.setEntity(comment);
            //emDialog.setMode(Constant.ENTITY_MANAGEMENT_MODE_CREATION);        
            HidroconApp.getApplication().show(dialog);

            /*if (emDialog.isEntityUpdated()) {
                CommentManager commentsManager = new CommentManager();
                commentsManager.createComment(comment);
                return true;
            }*/
        //}
        return null;
	}  
    
}
