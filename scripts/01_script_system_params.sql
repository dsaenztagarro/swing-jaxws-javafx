create table system_params (
param_name varchar(200) not null , 
param_value varchar(200) not null,
param_description varchar(1000) not null,
primary key (param_name));

insert into system_params (param_name, param_value, param_description) values (
'STATUS_METER_READING_NEW','3','');
/*insert into system_params (param_name, param_value, param_description) values (
'ROUTE_BUILDING_DATE_STATUS_ID_NEW','1','');
*/

create table module(
id int(11) not null auto_increment,
module_name varchar(200) not null,
primary key (id));

insert into module values (1,'Meter Reading Module');
insert into module values (2,'Route Date Module')

create table status(
id int(11) not null,
status_name varchar(200) not null,
module_id int(11),
primary key (id),
foreign key (module_id) references module (id));

insert into status (id,status_name,module_id) values(1,'Editable',1);
insert into status (id,status_name,module_id) values(2,'Sólo lectura',1);
insert into status (id,status_name,module_id) values(3,'Pendiente',2);
insert into status (id,status_name,module_id) values(4,'Activo',2);
insert into status (id,status_name,module_id) values(5,'Finalizado',2);