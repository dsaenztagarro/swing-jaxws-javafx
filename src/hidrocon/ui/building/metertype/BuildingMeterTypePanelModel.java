/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.building.metertype;

import hidrocon.core.database.building.entities.Building;
import hidrocon.core.database.building.manager.BuildingManager;
import java.util.List;

/**
 *
 * @author David Sáenz Tagarro
 */
public class BuildingMeterTypePanelModel {
    
    public List getBuildingMeterTypeViewList(Building building) {
        List list = null;
        if (building!=null) {
            BuildingManager bm = new BuildingManager();
            list = bm.getBuildingMeterTypeViewList(building.getId());
        }
        return list;        
    }
    
}
