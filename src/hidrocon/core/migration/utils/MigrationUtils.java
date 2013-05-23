/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.core.migration.utils;

import hidrocon.core.database.building.entities.Building;
import hidrocon.core.database.building.manager.BuildingManager;
import hidrocon.core.database.meter.entities.Meter;
import hidrocon.core.database.meter.manager.MeterManager;
import hidrocon.core.database.meterreading.entities.MeterReading;
import hidrocon.core.database.migration.entities.MigrationBuilding;
import hidrocon.core.database.migration.entities.MigrationNeighbour;
import hidrocon.core.database.migration.manager.MigrationManager;
import hidrocon.core.database.neighbour.entities.Neighbour;
import hidrocon.core.database.neighbour.manager.NeighbourManager;
import hidrocon.core.database.neighbourmeter.entities.NeighbourMeter;
import hidrocon.core.database.neighbourmeter.entities.NeighbourMeterView;
import hidrocon.custom.Constant;
import hidrocon.core.utils.HidroStatus;
import hidrocon.webservice.Building;
import hidrocon.webservice.Neighbour;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author David Sáenz Tagarro
 */
public class MigrationUtils {
    
    private boolean isPendingScriptMeter = true;
    private boolean isPendingScriptMeterReading = true;
    
    public final int METER_TYPE_COLD_WATER = 1;
    public final int METER_TYPE_HOT_WATER = 2;

    public final String METER_TYPE_CODE_COLD_WATER = "CAF";
    public final String METER_TYPE_CODE_HOT_WATER = "CAC";
    
    private static List<MigrationBuilding> migrationBuildingList;
    private static List<Building> buildingList;
    
    public MigrationBuilding getMigrationBuilding(int buildingNumber) {
        if (migrationBuildingList==null) {
            MigrationManager mm = new MigrationManager();
            migrationBuildingList = mm.getAllMigrationBuilding();
        }
        for (int i=0; i<migrationBuildingList.size(); i++) {
            MigrationBuilding migrationBuilding = migrationBuildingList.get(i);
            if (migrationBuilding.getBuildingNumber().intValue() == buildingNumber) {
                return migrationBuilding;
            }
        }
        return null;
    } 

    public Building getBuilding(int buildingNumber) {
        if (buildingList==null) {
            BuildingManager mm = new BuildingManager();
            buildingList = mm.getAllBuilding();
        }
        for (int i=0; i<buildingList.size(); i++) {
            Building building = buildingList.get(i);
            if (building.getBuildingNumber().intValue() == buildingNumber) {
                return building;
            }
        }
        return null;
    }

    public void execute() {
        
        if (isPendingScriptMeter) {
            MeterManager mm = new MeterManager();
            NeighbourManager nm = new NeighbourManager();
            BuildingManager bm = new BuildingManager();

            List<Building> list = bm.getAllBuilding();
            for (Building building : list) {

                List<Neighbour> neighbourList = nm.getNeighbourList(building.getId());
                int numCWM = building.getNumberColdWaterMetersPerHome();
                int numHWM = building.getNumberHotWaterMetersPerHome();
                String buildingNumber = String.valueOf(building.getBuildingNumber());

                for (Neighbour neighbour : neighbourList) {
                    int neighbourId = neighbour.getId();
                    int neighbourNumber = neighbour.getNeighbourNumber();

                    for (int i=0; i<numCWM; i++) {
                        StringBuilder sbMeterCode = new StringBuilder();
                        sbMeterCode.append(METER_TYPE_CODE_COLD_WATER).
                                append("_").
                                append(buildingNumber).
                                append("_").
                                append(neighbourNumber).
                                append("_").
                                append(i+1);

                        Meter meter = new Meter();
                        meter.setSerialNumber(sbMeterCode.toString());
                        meter.setMeterModelId(1);
                        meter.setInstallationTypeId(4);
                        meter.setRecStatus(Constant.RECORD_STATUS_ACTIVE);
                        mm.createMeter(meter);

                        NeighbourMeter neighbourMeter = new NeighbourMeter();
                        neighbourMeter.setNeighbourId(neighbourId);
                        neighbourMeter.setMeterId(meter.getId());
                        nm.createNeighbourMeter(neighbourMeter);
                    }

                    for (int i=0; i<numHWM; i++) {
                        StringBuilder sbMeterCode = new StringBuilder();
                        sbMeterCode.append(METER_TYPE_CODE_HOT_WATER).
                                append("_").
                                append(buildingNumber).
                                append("_").
                                append(neighbourNumber).
                                append("_").                            
                                append(i+1);

                        Meter meter = new Meter();
                        meter.setSerialNumber(sbMeterCode.toString());
                        meter.setMeterModelId(2);
                        meter.setInstallationTypeId(4);
                        meter.setRecStatus(Constant.RECORD_STATUS_ACTIVE);
                        mm.createMeter(meter);

                        NeighbourMeter neighbourMeter = new NeighbourMeter();
                        neighbourMeter.setNeighbourId(neighbourId);
                        neighbourMeter.setMeterId(meter.getId());
                        nm.createNeighbourMeter(neighbourMeter);
                    }

                }
            }
        }
        
        if (isPendingScriptMeterReading) {
            BuildingManager bm = new BuildingManager();
            NeighbourManager nm = new NeighbourManager();            
            int order = 1;
            
            MigrationManager mm = new MigrationManager();
            List<MigrationNeighbour> migrationNeighbourList = mm.getAllMigrationNeighbour();
            for (MigrationNeighbour migrationNeighbour : migrationNeighbourList) {
                int buildingNumber = migrationNeighbour.getBuildingNumber();
                
                MigrationBuilding migrationBuilding = getMigrationBuilding(buildingNumber);
                
                if (migrationBuilding!=null) {
                    
                    Building building = bm.getBuilding(migrationBuilding.getBuildingCode());
                    
                    Neighbour neighbour = nm.getNeighbour(migrationNeighbour.getNeighbourNumber());
                    NeighbourMeterView coldWaterMeter = nm.getNeighbourMeterView(neighbour.getId(), 1);
                    NeighbourMeterView hotWaterMeter = nm.getNeighbourMeterView(neighbour.getId(), 2);

                    if (migrationBuilding.getNumberColdWaterMetersPerHome()<=1 &&
                        migrationBuilding.getNumberHotWaterMetersPerHome()<=1) {

                        if (coldWaterMeter!=null) {

                            addMeterReading(coldWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec12(), 
                                migrationNeighbour.getLeclecf12(), 
                                migrationNeighbour.getLecf12(), 
                                migrationNeighbour.getConsum12af());

                            addMeterReading(coldWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec11(), 
                                migrationNeighbour.getLeclecf11(), 
                                migrationNeighbour.getLecf11(), 
                                migrationNeighbour.getConsum11af());

                            addMeterReading(coldWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec10(), 
                                migrationNeighbour.getLeclecf10(), 
                                migrationNeighbour.getLecf10(), 
                                migrationNeighbour.getConsum10af());

                            addMeterReading(coldWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec9(), 
                                migrationNeighbour.getLeclecf9(), 
                                migrationNeighbour.getLecf9(), 
                                migrationNeighbour.getConsum9af());

                            addMeterReading(coldWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec8(), 
                                migrationNeighbour.getLeclecf8(), 
                                migrationNeighbour.getLecf8(), 
                                migrationNeighbour.getConsum8af());

                            addMeterReading(coldWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec7(), 
                                migrationNeighbour.getLeclecf7(), 
                                migrationNeighbour.getLecf7(), 
                                migrationNeighbour.getConsum7af());

                            addMeterReading(coldWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec6(), 
                                migrationNeighbour.getLeclecf6(), 
                                migrationNeighbour.getLecf6(), 
                                migrationNeighbour.getConsum6af());

                            addMeterReading(coldWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec5(), 
                                migrationNeighbour.getLeclecf5(), 
                                migrationNeighbour.getLecf5(), 
                                migrationNeighbour.getConsum5af());

                            addMeterReading(coldWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec4(), 
                                migrationNeighbour.getLeclecf4(), 
                                migrationNeighbour.getLecf4(), 
                                migrationNeighbour.getConsum4af());

                            addMeterReading(coldWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec3(), 
                                migrationNeighbour.getLeclecf3(), 
                                migrationNeighbour.getLecf3(), 
                                migrationNeighbour.getConsum3af());

                            addMeterReading(coldWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec2(), 
                                migrationNeighbour.getLeclecf2(), 
                                migrationNeighbour.getLecf2(), 
                                migrationNeighbour.getConsum2af());

                            addMeterReading(coldWaterMeter.getMeterId(), 
                                migrationBuilding.getFechant(), 
                                migrationNeighbour.getLeclecf1(), 
                                migrationNeighbour.getLecf1(), 
                                migrationNeighbour.getConsum1af());
                        }

                        if (hotWaterMeter!=null) {

                            addMeterReading(hotWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec12(), 
                                migrationNeighbour.getLeclecc12(), 
                                migrationNeighbour.getLecc12(), 
                                migrationNeighbour.getConsum12ac());

                            addMeterReading(hotWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec11(), 
                                migrationNeighbour.getLeclecc11(), 
                                migrationNeighbour.getLecc11(), 
                                migrationNeighbour.getConsum11ac());

                            addMeterReading(hotWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec10(), 
                                migrationNeighbour.getLeclecc10(), 
                                migrationNeighbour.getLecc10(), 
                                migrationNeighbour.getConsum10ac());

                            addMeterReading(hotWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec9(), 
                                migrationNeighbour.getLeclecc9(), 
                                migrationNeighbour.getLecc9(), 
                                migrationNeighbour.getConsum9ac());

                            addMeterReading(hotWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec8(), 
                                migrationNeighbour.getLeclecc8(), 
                                migrationNeighbour.getLecc8(), 
                                migrationNeighbour.getConsum8ac());

                            addMeterReading(hotWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec7(), 
                                migrationNeighbour.getLeclecc7(), 
                                migrationNeighbour.getLecc7(), 
                                migrationNeighbour.getConsum7ac());

                            addMeterReading(hotWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec6(), 
                                migrationNeighbour.getLeclecc6(), 
                                migrationNeighbour.getLecf6(), 
                                migrationNeighbour.getConsum6ac());

                            addMeterReading(hotWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec5(), 
                                migrationNeighbour.getLeclecc5(), 
                                migrationNeighbour.getLecc5(), 
                                migrationNeighbour.getConsum5ac());

                            addMeterReading(hotWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec4(), 
                                migrationNeighbour.getLeclecc4(), 
                                migrationNeighbour.getLecc4(), 
                                migrationNeighbour.getConsum4ac());

                            addMeterReading(hotWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec3(), 
                                migrationNeighbour.getLeclecc3(), 
                                migrationNeighbour.getLecc3(), 
                                migrationNeighbour.getConsum3ac());

                            addMeterReading(hotWaterMeter.getMeterId(), 
                                migrationBuilding.getFechlec2(), 
                                migrationNeighbour.getLeclecc2(), 
                                migrationNeighbour.getLecc2(), 
                                migrationNeighbour.getConsum2ac());

                            addMeterReading(hotWaterMeter.getMeterId(), 
                                migrationBuilding.getFechant(), 
                                migrationNeighbour.getLeclecc1(), 
                                migrationNeighbour.getLecc1(), 
                                migrationNeighbour.getConsum1ac());      
                        }
                        
                    } else {
                        System.out.println("MORE THAN 1 METER - SPECIAL TREATMENT (TODO)");
                    }
                    order++;
                } else {
                    System.out.println("Building Number Unknown: " + buildingNumber);
                }
            }
        }        
        
        System.out.println("Migration finished");
    }
    
    
    private void addMeterReading(int meterId, Date readingDate, int readValue, int registeredValue, int m3) {
        if (readingDate!=null) {
            HashMap parameters = new HashMap();
            parameters.put("meterId",String.valueOf(meterId));
            parameters.put("readingDate", readingDate);
            MeterManager meterManager = new MeterManager();
            List list = meterManager.getMeterReadingList(parameters);
            if (list==null || list.isEmpty()) {
                MeterReading mr = new MeterReading();
                mr.setMeterId(meterId);
                mr.setReadingDate(readingDate);
                mr.setReadValue(readValue);
                mr.setRegisteredValue(registeredValue);
                mr.setM3(m3); 
                mr.setStatusId(HidroStatus.METER_READING_READ_ONLY);
                meterManager.createMeterReading(mr);
            }        
        }
    }
}
