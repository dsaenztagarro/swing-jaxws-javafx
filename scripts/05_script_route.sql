create table route (
id int(11) not null auto_increment,
route_name varchar(100) not null,
number_readings_per_year int(11) not null,
primary key(id));

insert into route (id, route_number, route_name, number_readings_per_year, rec_status) values (
1, 1, 'Recorrido personalizado', 0, 'A');

alter table building MODIFY COLUMN id INTEGER  NOT NULL AUTO_INCREMENT, add PRIMARY KEY (id);

create table route_building (
route_building_id int(11) not null auto_increment,
route_id int(11) not null,
order_id int(11) not null,
building_id int(11) not null,
primary key (route_building_id),
foreign key (route_id) references route (id),
foreign key (building_id) references building (id));

/*
create table route_building (
id int(11) not null auto_increment,
route_id int(11) not null,
order_id int(11) not null,
building_id int(11) not null,
primary key (id),
unique (route_id, building_id),
foreign key (route_id) references route (id),
foreign key (building_id) references building (id));
*/

create table route_date (
id int(11) not null auto_increment, 
route_id int(11) not null, 
reading_date date not null,
is_active char(1) default 'F' not null,
status_id int(11) not null,
primary key (id),
foreign key (route_id) references route(id));


create table route_building_date (
id int(11) not null auto_increment,
route_id int(11) not null,
order_id int(11) not null,
building_id int(11) not null,
route_date_id int(11) not null,
primary key (id),
foreign key (route_id) references route (id),
foreign key (building_id) references building (id),
foreign key (route_date_id) references route_date (id),
unique (route_id, building_id, route_date_id));


create or replace view route_view 
(id, route_name, number_readings_per_year, last_reading_date, next_reading_date) as
select 
r.id, 
r.route_name, 
r.number_readings_per_year, 
max(rd2.reading_date),
min(rd.reading_date) 
from 
((route r left join route_date rd on r.id = rd.route_id and rd.status_id <> 3)
left join route_date rd2 on r.id = rd2.route_id) 
group by r.id;


create or replace view route_building_view 
(route_building_id, route_id, order_id, building_id, building_code, building_address, building_route_is_default, building_meter_counter, building_number) as
select 
a.route_building_id,
a.route_id, 
a.order_id, 
b.id, 
b.building_code, 
b.address, 
b.route_is_default, 
(b.number_cold_water_meters+b.number_hot_water_meters), 
b.building_number
from route_building a inner join building b on a.building_id = b.id;
 

create or replace view route_building_date_view 
(route_building_date_id, route_id, route_name, order_id, building_id, building_code, building_address, building_route_is_default, building_meter_counter, building_number,
route_date_id, reading_date, status_id) as
select 
a.id,
a.route_id, 
r.route_name,
a.order_id, 
b.id, 
b.building_code, 
b.address, 
b.route_is_default, 
(b.number_cold_water_meters+b.number_hot_water_meters), 
b.building_number,
a.route_date_id,
c.reading_date,
c.status_id
from 
((route_building_date a inner join building b on a.building_id = b.id)
join route_date c on c.id = a.route_date_id)
join route r on a.route_id = r.id;

/*
@Entity
@Table(name = "route_building_date")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteBuildingDate.findAll", query = "SELECT r FROM RouteBuildingDate r"),
    @NamedQuery(name = "RouteBuildingDate.findByRouteDateId", query = "SELECT r FROM RouteBuildingDate r WHERE r.routeBuildingDatePK.routeDateId = :routeDateId"),
    @NamedQuery(name = "RouteBuildingDate.deleteByRouteDateId", query = "DELETE FROM RouteBuildingDate r WHERE r.routeBuildingDatePK.routeDateId = :routeDateId")})

@Entity
@Table(name = "route_building_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteBuildingView.findAll", query = "SELECT r FROM RouteBuildingView r"),
    @NamedQuery(name = "RouteBuildingView.findByRouteId", query = "SELECT r FROM RouteBuildingView r WHERE r.routeBuildingPK.routeId = :routeId ORDER BY r.orderId ASC")})

@Entity
@Table(name = "route_building_date_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteBuildingDateView.findAll", query = "SELECT r FROM RouteBuildingDateView r"),
    @NamedQuery(name = "RouteBuildingDateView.findByRouteDateId", query = "SELECT r FROM RouteBuildingDateView r WHERE r.routeBuildingDatePK.routeDateId = :routeDateId ORDER BY r.orderId ASC"),
    @NamedQuery(name = "RouteBuildingDateView.findByBuildingId", query = "SELECT r FROM RouteBuildingDateView r WHERE r.routeBuildingDatePK.buildingId = :buildingId ORDER BY r.meterReadingDate DESC")})
*/

insert into route (id, route_name, rec_status) values (
16,'Recorrido Personalizado', 'A');

insert into route (id, route_name, rec_status) values (
1,'Recorrido 1', 'A');
insert into route (id, route_name, rec_status) values (
2,'Recorrido 2', 'A');
insert into route (id, route_name, rec_status) values (
3,'Recorrido 3', 'A');
insert into route (id, route_name, rec_status) values (
4,'Recorrido 4', 'A');
insert into route (id, route_name, rec_status) values (
5,'Recorrido 5', 'A');
insert into route (id, route_name, rec_status) values (
6,'Recorrido 6', 'A');
insert into route (id, route_name, rec_status) values (
7,'Recorrido 7', 'A');
insert into route (id, route_name, rec_status) values (
8,'Recorrido 8', 'A');
insert into route (id, route_name, rec_status) values (
9,'Recorrido 9', 'A');
insert into route (id, route_name, rec_status) values (
10,'Recorrido 10', 'A');
insert into route (id, route_name, rec_status) values (
11,'Recorrido 11', 'A');
insert into route (id, route_name, rec_status) values (
12,'Recorrido 12', 'A');
insert into route (id, route_name, rec_status) values (
13,'Recorrido 13', 'A');
insert into route (id, route_name, rec_status) values (
14,'Recorrido 14', 'A');
insert into route (id, route_name, rec_status) values (
15,'Recorrido 15', 'A');



/*
@Entity
@Table(name = "route")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r"),
    @NamedQuery(name = "Route.findById", query = "SELECT r FROM Route r WHERE r.id = :id"),
    @NamedQuery(name = "Route.findByRouteName", query = "SELECT r FROM Route r WHERE r.routeName = :routeName"),
    @NamedQuery(name = "Route.findByRecStatus", query = "SELECT r FROM Route r WHERE r.recStatus = :recStatus")})


@Entity
@Table(name = "route_building")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteBuilding.findByRouteId", query = "SELECT r FROM RouteBuilding r WHERE r.routeBuildingsPK.routeId = :routeId ORDER BY r.orderId ASC"),
    @NamedQuery(name = "RouteBuilding.deleteByPK", query = "DELETE FROM RouteBuilding r WHERE r.routeBuildingsPK.routeId = :routeId AND r.routeBuildingsPK.buildingId = :buildingId"),
    @NamedQuery(name = "RouteBuilding.decreaseOrderAllRegistersByPK", query = "UPDATE RouteBuilding r SET r.orderId = r.orderId-1 WHERE r.routeBuildingsPK.routeId = :routeId AND r.orderId > :orderId"),
    @NamedQuery(name = "RouteBuilding.decreaseOrderByPK", query = "UPDATE RouteBuilding r SET r.orderId = r.orderId-1 WHERE r.routeBuildingsPK.routeId = :routeId AND r.routeBuildingsPK.buildingId = :buildingId"),
    @NamedQuery(name = "RouteBuilding.increaseOrderByPK", query = "UPDATE RouteBuilding r SET r.orderId = r.orderId+1 WHERE r.routeBuildingsPK.routeId = :routeId AND r.routeBuildingsPK.buildingId = :buildingId")
})

*/

/*
Gestión del tiempo y Métricas de Productividad  Individual
Negocio de la Consultoría
Calidad en Código
Trabajo en Equipo
*/