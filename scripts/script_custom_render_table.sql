create table custom_render_table (
table_name varchar(200) not null,
column_id int(11) not null,
cell_value varchar(10) not null,
icon_path varchar(200) not null);

alter table custom_render_table add primary key (table_name, column_id, cell_value);

insert into custom_render_table (table_name, column_id, cell_value, icon_path) values ('routeDateTable',1,'2','lock_lock_20x20.png');
insert into custom_render_table (table_name, column_id, cell_value, icon_path) values ('routeDateTable',1,'1','lock_unlock_20x20.png');

insert into custom_render_table (table_name, column_id, cell_value, icon_path) values ('routeBuildingDateTable',3,'F','button_favorite_24x24.png');

insert into custom_render_table (table_name, column_id, cell_value, icon_path) values ('neighbourMeterReadingTable',1,'1','button_blank_blue_20x20.png');
insert into custom_render_table (table_name, column_id, cell_value, icon_path) values ('neighbourMeterReadingTable',1,'2','button_blank_red_20x20.png');
insert into custom_render_table (table_name, column_id, cell_value, icon_path) values ('neighbourMeterReadingTable',1,'3','button_blank_gray_20x20.png');

insert into custom_render_table (table_name, column_id, cell_value, icon_path) values ('neighbourMeterReadingTable',5,'1','button_pause_20x20.png');
insert into custom_render_table (table_name, column_id, cell_value, icon_path) values ('neighbourMeterReadingTable',5,'2','calculator_20x20.png');
insert into custom_render_table (table_name, column_id, cell_value, icon_path) values ('neighbourMeterReadingTable',5,'3','button_next_20x20.png');
insert into custom_render_table (table_name, column_id, cell_value, icon_path) values ('neighbourMeterReadingTable',5,'4','button_add_20x20.png');
insert into custom_render_table (table_name, column_id, cell_value, icon_path) values ('neighbourMeterReadingTable',5,'5','button_upload_20x20.png');
insert into custom_render_table (table_name, column_id, cell_value, icon_path) values ('neighbourMeterReadingTable',5,'6','button_warning_20x20.png');
insert into custom_render_table (table_name, column_id, cell_value, icon_path) values ('neighbourMeterReadingTable',5,'7','button_refresh_back_20x20.png');

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