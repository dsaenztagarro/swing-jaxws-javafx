create table meter_category(
id int(11) not null auto_increment,
category_name varchar(100) not null,
image_path varchar(500) not null,
primary key(id));

insert into meter_category(id, category_name, parent, path) values (1,'Contador de agua',0,'1');
insert into meter_category(id, category_name, parent, path) values (2,'Contador de gas',0,'1');
 
create table meter_type (
id int(11) not null auto_increment,
meter_type_code varchar(10) not null,
meter_type_name varchar(100) not null,
hex_light_color varchar(10) not null,
hex_dark_color varchar(10) not null,
primary key(id));

insert into meter_type (id, meter_type_code, meter_type_name, hex_light_color, hex_dark_color) values (1, 'CAF', 'Contador de Agua Fria', '7d9cef','020d49');
insert into meter_type (id, meter_type_code, meter_type_name, hex_light_color, hex_dark_color) values (2, 'CAC', 'Contador de Agua Caliente', 'ff0000', '8f0000');
insert into meter_type (id, meter_type_code, meter_type_name, hex_light_color, hex_dark_color) values (3, 'CG', 'Contador de Gas', '00a623', '00310a');
insert into meter_type (id, meter_type_code, meter_type_name, hex_light_color, hex_dark_color) values (4, 'CC', 'Contador de Calefacción', 'd00259', '520023');


create table installation_type (
id int(11) not null auto_increment,
installation_name varchar(200) not null,
description varchar(2000) not null,
primary key(id));

insert into installation_type(id, installation_name, description) values (
1,'Contador único', 'Se trata del contador que controla el consumo total de la finca suministrada, no existiendo contadores posteriores a este que estén gestionados por el Canal de Isabel II.');
insert into installation_type(id, installation_name, description) values (
2,'Contador divisionario principal', 'Es un contador instalado en la acometida, que conecta una batería de contadores con la red de distribución y controla el consumo total de la finca.');
insert into installation_type(id, installation_name, description) values (
3,'Contador colectivo principal', 'Es un contador instalado entre la red de distribución del Canal de Isabel II y la red de distribución de titularidad privada, que controla los consumos realizados en dicha red privada y en los contadores secundarios instalados en la misma que sean gestionados comercialmente por el Canal de Isabel II.');
insert into installation_type(id, installation_name, description) values (
4,'Contador divisionario secundario', 'Es un contador instalado en una batería, que controla los consumos individuales de que se compone una finca, vivienda, local y otros usos.');

/****************************************************************
METER
*****************************************************************/

create table meter_model (
id int(11) not null auto_increment,
brand varchar(200) not null,
model_name varchar(2000) not null,
diameter int(11) not null default 0,
meter_type_id int(11) not null,
primary key (id),
foreign key (meter_type_id) references meter_type(id));

insert into meter_model (id,brand,model_name,diameter,meter_type_id) values(
1,'','Contador Standard agua fría',0,1);
insert into meter_model (id,brand,model_name,diameter,meter_type_id) values(
2,'','Contador Standard agua caliente',0,2);

create table meter (
id int(11) not null auto_increment,
serial_number varchar(50) not null,
meter_model_id int(11) not null,
installation_type_id int(11) not null,
rec_status char(1) default 'A' not null,
primary key(id),
foreign key (meter_model_id) references meter_model(id),
foreign key (installation_type_id) references installation_type(id));

create table meter_reading (
id int(11) not null auto_increment,
meter_id int(11),
meter_reading_number int(11) not null,
reading_date date not null,
read_value int(11),
registered_value int(11),
m3 int(11),
status_id int(11) not null,
primary key(id),
foreign key (meter_id) references meter (id),
foreign key (status_id) references status (id));


/****************************************************************
NEIGHBOUR
*****************************************************************/

create table neighbour_meter (
id int(11) not null auto_increment,
neighbour_id int(11),
meter_id int(11),
primary key(id),
foreign key (meter_id) references meter (id),
foreign key (neighbour_id) references neighbour (id));


create table neighbour_reading_date (
id int(11) not null auto_increment,
neighbour_id int(11),
route_building_date_id int(11),
meter_reading_id int(11),
primary key(id),
foreign key (meter_id) references meter (id),
foreign key (neighbour_id) references neighbour (id));


create or replace view neighbour_meter_view 
(neighbour_meter_id, neighbour_id, meter_id, serial_number, installation_type_id, meter_model_id, brand, model_name, diameter, meter_type_id, meter_type_name, hex_light_color, hex_dark_color) as
select 
a.id,
a.neighbour_id, 
a.meter_id, 
b.serial_number,
b.installation_type_id, 
c.id,
c.brand,
c.model_name,
c.diameter, 
c.meter_type_id,
d.meter_type_name,
d.hex_light_color,
d.hex_dark_color
from 
(((neighbour_meter a join meter b on a.meter_id = b.id)
join meter_model c on b.meter_model_id = c.id)
join meter_type d on c.meter_type_id = d.id)
where 
b.rec_status = 'A';


create or replace view neighbour_meter_reading_view 
(meter_reading_id, neighbour_meter_id, neighbour_id, meter_id, serial_number, meter_type_id, reading_date, read_value, registered_value, m3, status_id) as
select 
c.id,
a.neighbour_id, 
a.meter_id,
b.serial_number,
e.id,
d.id,
c.reading_date,
c.read_value, 
c.registered_value, 
c.m3
c.status_id
from 
((((neighbour_meter a join meter b on a.meter_id = b.id)
join meter_reading c on b.id = c.meter_id)
join meter_model d on d.id = b.meter_model_id)  
join meter_type e on e.id = d.meter_type_id);

/*

module - 1- Neighbour Meter Reading Status

status_id
1 - ausente (no cambia el valor)
2 - ausente con estimativa (calcula el valor)
3 - consumo normal
4 - consumo normal un poco superior
5 - consumo normal un poco superior 
6 - error de lector
7 - contador al reves
*/

/****************************************************************
BUILDING
*****************************************************************/

create table building_meter (
id int(11) not null auto_increment,
building_id int(11),
meter_id int(11),
primary key(id),
foreign key (meter_id) references meter (id),
foreign key (building_id) references building (id));

create table building_meter_type (
id int(11) not null auto_increment,
building_id int(11),
meter_type_id int(11),
rec_status char(1) default 'A' not null,
primary key(id),
foreign key (building_id) references building (id),
foreign key (meter_type_id) references meter_type (id));

create or replace view building_meter_type_view 
(building_meter_type_id, building_id, meter_type_id, meter_type_code, meter_type_name, meter_type_image_path) as
select 
a.id,
a.building_id, 
a.meter_type_id, 
b.meter_type_code, 
b.meter_type_name, 
b.image_path
from 
(building_meter_type a join meter_type b on a.meter_type_id = b.id)
where 
a.rec_status = 'A';

/*
@Entity
@Table(name = "meter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meter.findById", query = "SELECT m FROM Meter m WHERE m.id = :id")})

@Entity
@Table(name = "neighbour_meter_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NeighbourMeterView.findAll", query = "SELECT n FROM NeighbourMeterView n"),
    @NamedQuery(name = "NeighbourMeterView.findByNeighbourMeterId", query = "SELECT n FROM NeighbourMeterView n WHERE n.neighbourMeterId = :neighbourMeterId"),
    @NamedQuery(name = "NeighbourMeterView.findByNeighbourId", query = "SELECT n FROM NeighbourMeterView n WHERE n.neighbourId = :neighbourId"),
    @NamedQuery(name = "NeighbourMeterView.findByNeighbourIdAndMeterTypeId", query = "SELECT n FROM NeighbourMeterView n WHERE n.neighbourId = :neighbourId AND n.meterTypeId = :meterTypeId"),
    @NamedQuery(name = "NeighbourMeterView.findByMeterName", query = "SELECT n FROM NeighbourMeterView n WHERE n.meterName = :meterName"),
    @NamedQuery(name = "NeighbourMeterView.findByMeterTypeId", query = "SELECT n FROM NeighbourMeterView n WHERE n.meterTypeId = :meterTypeId"),
    @NamedQuery(name = "NeighbourMeterView.findByMeterTypeName", query = "SELECT n FROM NeighbourMeterView n WHERE n.meterTypeName = :meterTypeName")})


@Entity
@Table(name = "neighbour_meter_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NeighbourMeterView.findAll", query = "SELECT n FROM NeighbourMeterView n"),
    @NamedQuery(name = "NeighbourMeterView.findByNeighbourMeterId", query = "SELECT n FROM NeighbourMeterView n WHERE n.neighbourMeterId = :neighbourMeterId"),
    @NamedQuery(name = "NeighbourMeterView.findByNeighbourId", query = "SELECT n FROM NeighbourMeterView n WHERE n.neighbourId = :neighbourId"),
    @NamedQuery(name = "NeighbourMeterView.findByMeterId", query = "SELECT n FROM NeighbourMeterView n WHERE n.meterId = :meterId"),
    @NamedQuery(name = "NeighbourMeterView.findBySerialNumber", query = "SELECT n FROM NeighbourMeterView n WHERE n.serialNumber = :serialNumber"),
    @NamedQuery(name = "NeighbourMeterView.findByInstallationTypeId", query = "SELECT n FROM NeighbourMeterView n WHERE n.installationTypeId = :installationTypeId"),
    @NamedQuery(name = "NeighbourMeterView.findByMeterModelId", query = "SELECT n FROM NeighbourMeterView n WHERE n.meterModelId = :meterModelId"),
    @NamedQuery(name = "NeighbourMeterView.findByBrand", query = "SELECT n FROM NeighbourMeterView n WHERE n.brand = :brand"),
    @NamedQuery(name = "NeighbourMeterView.findByModelName", query = "SELECT n FROM NeighbourMeterView n WHERE n.modelName = :modelName"),
    @NamedQuery(name = "NeighbourMeterView.findByDiameter", query = "SELECT n FROM NeighbourMeterView n WHERE n.diameter = :diameter"),
    @NamedQuery(name = "NeighbourMeterView.findByMeterTypeId", query = "SELECT n FROM NeighbourMeterView n WHERE n.meterTypeId = :meterTypeId"),
    @NamedQuery(name = "NeighbourMeterView.findByMeterTypeName", query = "SELECT n FROM NeighbourMeterView n WHERE n.meterTypeName = :meterTypeName"),
    @NamedQuery(name = "NeighbourMeterView.findByNeighbourIdAndMeterTypeId", query = "SELECT n FROM NeighbourMeterView n WHERE n.neighbourId = :neighbourId AND n.meterTypeId = :meterTypeId")})
*/

