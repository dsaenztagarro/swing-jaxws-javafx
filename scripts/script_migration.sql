/*

dbf2mysql -vvv -h localhost -U adminHidrocon -P hidrocon123 -d hidrocon -t migration_building -c -f COMUN.DBF

dbf2mysql -vvv -h localhost -U adminHidrocon -P hidrocon123 -d hidrocon -t migration_neighbour -c -f vecin.dbf

*/

alter table migration_neighbour add id INT(11) NOT NULL FIRST;
alter table `hidrocon`.`migration_neighbour` MODIFY COLUMN `id` INTEGER  NOT NULL AUTO_INCREMENT, add PRIMARY KEY (`id`);

alter table migration_building add id INT(11) NOT NULL FIRST;
alter table `hidrocon`.`migration_building` MODIFY COLUMN `id` INTEGER  NOT NULL AUTO_INCREMENT, add PRIMARY KEY (`id`);

alter table migration_building change numfinca building_number int(11);
alter table migration_building change inicial building_code varchar(20);
alter table migration_building change edificio type_name varchar(200);
alter table migration_building change dir address varchar(200);
alter table migration_building change distrito zip_code varchar(10);
alter table migration_building change numlectano number_readings_per_year int(11);
alter table migration_building change numcontaf number_cold_water_meters int(11);
alter table migration_building change numcontacs number_hot_water_meters int(11);
alter table migration_building change numafviv number_cold_water_meters_per_home int(11);
alter table migration_building change numacviv number_hot_water_meters_per_home int(11);
alter table migration_building change nombcontac contact_name varchar(200);
alter table migration_building change telcontac contact_phone_number varchar(20);
alter table migration_building change telcontac2 contact_phone_number_2 varchar(20);
alter table migration_building change obs1 observations varchar(2000);
alter table migration_building change obs2 reader_observations varchar(2000);
alter table migration_building change bloqtari bill_per_blocks char(1);
alter table migration_building change ptsm3af ammount_m3_cold_water int(11);
alter table migration_building change ptsm3ac ammount_m3_hot_water int(11);
alter table migration_building change diametro diameter_migration_building int(11);
alter table migration_building change diameviv diameter_home int(11);
alter table migration_building change provincia province varchar(100);
alter table migration_building change colegiado administrator_id int(11);
alter table migration_building change model model_id int(11);

alter table migration_building change nombavi notice_name varchar(200);
alter table migration_building change diravi notice_address varchar(200);
alter table migration_building change distavi notice_zip_code varchar(10);
alter table migration_building change numavi notice_number int(11);

alter table migration_building change numviv number_neighbours int(11);
alter table migration_building change disco support_type_code varchar(1);
alter table migration_building change iesa support_extenal_id int(11);


ALTER TABLE migration_building MODIFY COLUMN fechinicio DATE  DEFAULT NULL;

ALTER TABLE migration_building MODIFY COLUMN fechlec2 DATE  DEFAULT NULL;
ALTER TABLE migration_building MODIFY COLUMN fechlec3 DATE  DEFAULT NULL;
ALTER TABLE migration_building MODIFY COLUMN fechlec4 DATE  DEFAULT NULL;
ALTER TABLE migration_building MODIFY COLUMN fechlec5 DATE  DEFAULT NULL;
ALTER TABLE migration_building MODIFY COLUMN fechlec6 DATE  DEFAULT NULL;
ALTER TABLE migration_building MODIFY COLUMN fechlec7 DATE  DEFAULT NULL;
ALTER TABLE migration_building MODIFY COLUMN fechlec8 DATE  DEFAULT NULL;
ALTER TABLE migration_building MODIFY COLUMN fechlec9 DATE  DEFAULT NULL;
ALTER TABLE migration_building MODIFY COLUMN fechlec10 DATE  DEFAULT NULL;
ALTER TABLE migration_building MODIFY COLUMN fechlec11 DATE  DEFAULT NULL;
ALTER TABLE migration_building MODIFY COLUMN fechlec12 DATE  DEFAULT NULL;

ALTER TABLE migration_building MODIFY COLUMN proxlec1 DATE  DEFAULT NULL;
ALTER TABLE migration_building MODIFY COLUMN proxlec2 DATE  DEFAULT NULL;
ALTER TABLE migration_building MODIFY COLUMN proxlec3 DATE  DEFAULT NULL;
ALTER TABLE migration_building MODIFY COLUMN proxlec4 DATE  DEFAULT NULL;
ALTER TABLE migration_building MODIFY COLUMN proxlec5 DATE  DEFAULT NULL;
ALTER TABLE migration_building MODIFY COLUMN proxlec6 DATE  DEFAULT NULL;
ALTER TABLE migration_building MODIFY COLUMN proxlec DATE  DEFAULT NULL;

ALTER TABLE migration_building MODIFY COLUMN fechact DATE  DEFAULT NULL;
ALTER TABLE migration_building MODIFY COLUMN fechant DATE  DEFAULT NULL;



update migration_building set fechinicio = null where fechinicio = '0000-00-00';

update migration_building set fechlec2 = null where fechlec2 = '0000-00-00';
update migration_building set fechlec3 = null where fechlec3 = '0000-00-00';
update migration_building set fechlec4 = null where fechlec4 = '0000-00-00';
update migration_building set fechlec5 = null where fechlec5 = '0000-00-00';
update migration_building set fechlec6 = null where fechlec6 = '0000-00-00';
update migration_building set fechlec7 = null where fechlec7 = '0000-00-00';
update migration_building set fechlec8 = null where fechlec8 = '0000-00-00';
update migration_building set fechlec9 = null where fechlec9 = '0000-00-00';
update migration_building set fechlec10 = null where fechlec10 = '0000-00-00';
update migration_building set fechlec11 = null where fechlec11 = '0000-00-00';
update migration_building set fechlec12 = null where fechlec12 = '0000-00-00';

update migration_building set fechant = null where fechant = '0000-00-00';
update migration_building set fechact = null where fechact = '0000-00-00';

update migration_building set proxlec2 = null where proxlec2 = '0000-00-00';
update migration_building set proxlec3 = null where proxlec3 = '0000-00-00';
update migration_building set proxlec4 = null where proxlec4 = '0000-00-00';
update migration_building set proxlec5 = null where proxlec5 = '0000-00-00';
update migration_building set proxlec6 = null where proxlec6 = '0000-00-00';
update migration_building set proxlec1 = null where proxlec1 = '0000-00-00';
update migration_building set proxlec = null where proxlec = '0000-00-00';


alter table migration_neighbour change numfinca building_number int(11);
alter table migration_neighbour change numorden neighbour_number int(11);
alter table migration_neighbour change nombre neighbour_name varchar(200);
alter table migration_neighbour change tel phone_number varchar(20);
alter table migration_neighbour change piso floor varchar(20);


ALTER TABLE migration_neighbour MODIFY COLUMN ultilectu DATE  DEFAULT NULL;
ALTER TABLE migration_neighbour MODIFY COLUMN ultilpp40 DATE  DEFAULT NULL;
ALTER TABLE migration_neighbour MODIFY COLUMN newaf DATE  DEFAULT NULL;
ALTER TABLE migration_neighbour MODIFY COLUMN newac DATE  DEFAULT NULL;

update migration_neighbour set ultilectu = null where ultilectu = '0000-00-00';
update migration_neighbour set ultilpp40 = null where ultilpp40 = '0000-00-00';
update migration_neighbour set newaf = null where newaf = '0000-00-00';
update migration_neighbour set newac = null where newac = '0000-00-00';


