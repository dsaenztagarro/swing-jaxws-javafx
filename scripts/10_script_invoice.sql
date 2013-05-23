create table invoice_type (
id int(11) not null auto_increment,
invoice_type_name varchar(100) not null,
primary key(id));


create table rate_type (
id int(11) not null auto_increment,
rate_type_name varchar(10) not null,
primary key(id));

insert into rate_type (id, rate_type_name) values (1, 'Aducción');
insert into rate_type (id, rate_type_name) values (2, 'Distribución');
insert into rate_type (id, rate_type_name) values (3, 'Alcantarillado');
insert into rate_type (id, rate_type_name) values (4, 'Depuración');


create table use_group (
id int(11) not null auto_increment,
use_name varchar(10) not null,
description varchar(100) not null,
primary key(id),
foreign key (rate_id) references rate(id));

insert into use_group (id, use_name, description) values (
1,'Usos domésticos','Tendrán la consideración de usos domésticos los destinados exclusivamente a viviendas. Se incluirán en este grupo de usos las urbanizaciones cuyas instalaciones de abastecimiento y saneamiento todavía no hayan sido recibidas por los municipios a que correspondan, que tendrán el carácter de abonado único');

insert into use_group (id, use_name, description) values (
2,'Usos asimilados al doméstico','Tendrán la consideración de usos asimilados a los domésticos los que se realicen para calefacción, garajes, jardines, piscina y demás servicios comunes en régimen de comunidad, así como los locales de una misma finca sin acometida independiente');

insert into use_group (id, use_name, description) values (
3,'Usos comerciales e industriales','Se consideran usos comerciales o industriales los realizados en tomas contratadas exclusivamente para actividades de este tipo, así como cualquier otra actividad productiva, incluidas las de carácter agrícola, ganadero o cinegético. Se incluirán también en este grupo los suministros destinados exclusivamente a usos comunes de centros comerciales o industriales');

insert into use_group (id, use_name, description) values (
4,'Usos asimilados al comercial','Tendrán la consideración de usos asimilados a comercial, los que se realicen en dependencias de organismos oficiales de la Administración Central, Autonómica o Local donde se lleven a cabo actividades administrativas, servicios, enseñanza, cuarteles, Definiciones de aplicación para el desarrollo de esta Orden hospitales, polideportivos, cementerios y otros de la misma naturaleza. Igualmente tendrán esta consideración los consumos registrados en tomas destinadas a obras, extinción de incendios y sedes de organismos internacionales o representaciones de otros Estados');

insert into use_group (id, use_name, description) values (
5,'Otros usos','Tendrán la consideración de otros usos todos aquellos no incluidos en los anteriores grupos y los que se realicen en acometidas destinadas a riegos en general, fuentes públicas, parques y jardines públicos y privados, así como los solares');


create table rate_deposit(
id int(11) not null auto_increment,
rate_id int(11) not null,
rate_type_id int(11) not null,
use_group_id int(11) not null,
expression varchar(100) not null,
primary key(id),
foreign key (rate_id) references rate(id),
foreign key (use_group_id) references use_group(id),
foreign key (rate_type_id) references rate_type(id));

insert into rate_deposit(id, rate_id, rate_type_id, use_group_id, expression) values (
1,1,1,1,'0,0167*(D^2+225*N)');
