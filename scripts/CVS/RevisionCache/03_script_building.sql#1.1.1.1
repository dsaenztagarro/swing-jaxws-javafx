alter table building add id INT(11) NOT NULL FIRST;
alter table building MODIFY COLUMN id INTEGER  NOT NULL AUTO_INCREMENT, add PRIMARY KEY (id);

alter table building change numfinca building_number int(11);
alter table building change inicial building_code varchar(20);
alter table building change edificio type_name varchar(200);
alter table building change dir address varchar(200);
alter table building change distrito zip_code varchar(10);
alter table building change numlectano number_readings_per_year int(11);
alter table building change numcontaf number_cold_water_meters int(11);
alter table building change numcontacs number_hot_water_meters int(11);
alter table building change numafviv number_cold_water_meters_per_home int(11);
alter table building change numacviv number_hot_water_meters_per_home int(11);
alter table building change nombcontac contact_name varchar(200);
alter table building change telcontac contact_phone_number varchar(20);
alter table building change telcontac2 contact_phone_number_2 varchar(20);
alter table building change obs1 observations varchar(2000);
alter table building change obs2 reader_observations varchar(2000);
alter table building change bloqtari bill_per_blocks char(1);
alter table building change ptsm3af ammount_m3_cold_water int(11);
alter table building change ptsm3ac ammount_m3_hot_water int(11);
alter table building change diametro diameter_building int(11);
alter table building change diameviv diameter_home int(11);
alter table building change provincia province varchar(100);
alter table building change colegiado administrator_id int(11);
alter table building change model model_id int(11);

alter table building change nombavi notice_name varchar(200);
alter table building change diravi notice_address varchar(200);
alter table building change distavi notice_zip_code varchar(10);
alter table building change numavi notice_number int(11);

alter table building change numviv number_neighbours int(11);
alter table building change disco support_type_code varchar(1);
alter table building change iesa support_extenal_id int(11);

alter table building add related_bank_ccc_details varchar(200);
alter table building add related_bank_iban varchar(4);
alter table building add related_bank_entity varchar(4);
alter table building add related_bank_office varchar(4);
alter table building add related_bank_dc varchar(2);
alter table building add related_bank_account varchar(10);

alter table building add hidrocon_bank_iban varchar(4);
alter table building add hidrocon_bank_entity varchar(4);
alter table building add hidrocon_bank_office varchar(4);
alter table building add hidrocon_bank_dc varchar(2);
alter table building add hidrocon_bank_account varchar(10);

alter table building add route_is_default char(1) default 'T' not null;
alter table building add rate_is_default char(1) default 'T' not null;
alter table building add rate_id INT(11) NOT NULL;
alter table building add rec_status CHAR(1) DEFAULT 'A' NOT NULL;

alter table building add rec_status CHAR(1) DEFAULT 'A' NOT NULL;
alter table building add rec_status CHAR(1) DEFAULT 'A' NOT NULL;
alter table building add rec_status CHAR(1) DEFAULT 'A' NOT NULL;

alter table building drop column proxlec;
alter table building drop column proxlec1;
alter table building drop column proxlec2;
alter table building drop column proxlec3;
alter table building drop column proxlec4;
alter table building drop column proxlec5;
alter table building drop column proxlec6;

alter table building drop column fechact;
alter table building drop column fechant;

alter table building drop column fechlec2;
alter table building drop column fechlec3;
alter table building drop column fechlec4;
alter table building drop column fechlec5;
alter table building drop column fechlec6;
alter table building drop column fechlec7;
alter table building drop column fechlec8;
alter table building drop column fechlec9;
alter table building drop column fechlec10;
alter table building drop column fechlec11;
alter table building drop column fechlec12;

update building set related_bank_ccc_details = concat(banco2,' ',dirsuc2,' ',cta2);
alter table building drop column banco2;
alter table building drop column dirsuc2;
alter table building drop column cta2;

/*
alter table building drop column banco;
alter table building drop column sucursal;
alter table building drop column cta;
*/

update building set hidrocon_bank_entity = substring(ccc,1,4);
update building set hidrocon_bank_office = substring(ccc,5,4);
update building set hidrocon_bank_dc = substring(ccc,9,2);
update building set hidrocon_bank_account = substring(ccc,11,10);
alter table building drop column ccc;

update building set bill_per_blocks = 'T' where bill_per_blocks = 'S';
update building set bill_per_blocks = 'F' where bill_per_blocks = 'N';

alter table building add foreign key (administrator_id) references administrator (administrator_id);

update building set rate_id = 1;

update building b set b.route_is_default = 'T' where id = 9;

/* alter table building change model estimate_reading_type_code varchar(1); */

/*
@Entity
@Table(name = "building")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Building.findAll", query = "SELECT f FROM Building f WHERE f.recStatus = 'A' ORDER BY f.buildingId ASC"),
    @NamedQuery(name = "Building.findAllAvailable", query = "SELECT f from Building f WHERE NOT f.id IN (SELECT b.routeBuildingsPK.buildingId FROM RouteBuildings b) ORDER BY f.buildingId ASC"),
	@NamedQuery(name = "Building.findById", query = "SELECT f FROM Building f WHERE f.id = :id")})
*/