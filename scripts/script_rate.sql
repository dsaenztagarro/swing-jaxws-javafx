alter table rate add is_default char(1) NOT NULL DEFAULT 'F' FIRST;
alter table rate add rate_name varchar(200) NOT NULL FIRST;
alter table rate add id INT(11) NOT NULL FIRST;
alter table `hidrocon`.`rate` MODIFY COLUMN `id` INTEGER  NOT NULL AUTO_INCREMENT, add PRIMARY KEY (`id`);
alter table rate add rec_status char(1) NOT NULL DEFAULT 'A';

alter table rate add constraint unique_rate_name unique (rate_name);

update rate set rate_name = 'Tarifa general', is_default = 'T' where id=1;

alter table rate change b1c1 bloque1_aduccion_invierno double;
alter table rate change b2c1 bloque2_aduccion_invierno double;
alter table rate change b3c1 bloque3_aduccion_invierno double;
alter table rate change b4c1 bloque4_aduccion_invierno double;

alter table rate change b1c2 bloque1_distribucion_invierno double;
alter table rate change b2c2 bloque2_distribucion_invierno double;
alter table rate change b3c2 bloque3_distribucion_invierno double;
alter table rate change b4c2 bloque4_distribucion_invierno double;

alter table rate change b1a1 bloque1_saneamiento_invierno double;
alter table rate change b2a1 bloque2_saneamiento_invierno double;
alter table rate change b3a1 bloque3_saneamiento_invierno double;
alter table rate change b4a1 bloque4_saneamiento_invierno double;

alter table rate change b1a2 bloque1_depuracion_invierno double;
alter table rate change b2a2 bloque2_depuracion_invierno double;
alter table rate change b3a2 bloque3_depuracion_invierno double;
alter table rate change b4a2 bloque4_depuracion_invierno double;

alter table rate change v1c1 bloque1_aduccion_verano double;
alter table rate change v2c1 bloque2_aduccion_verano double;
alter table rate change v3c1 bloque3_aduccion_verano double;
alter table rate change v4c1 bloque4_aduccion_verano double;

alter table rate change v1c2 bloque1_distribucion_verano double;
alter table rate change v2c2 bloque2_distribucion_verano double;
alter table rate change v3c2 bloque3_distribucion_verano double;
alter table rate change v4c2 bloque4_distribucion_verano double;

alter table rate change v1a1 bloque1_saneamiento_verano double;
alter table rate change v2a1 bloque2_saneamiento_verano double;
alter table rate change v3a1 bloque3_saneamiento_verano double;
alter table rate change v4a1 bloque4_saneamiento_verano double;

alter table rate change v1a2 bloque1_depuracion_verano double;
alter table rate change v2a2 bloque2_depuracion_verano double;
alter table rate change v3a2 bloque3_depuracion_verano double;
alter table rate change v4a2 bloque4_depuracion_verano double;

alter table rate change ivaca iva_cuota_canal int(11) not null;
alter table rate change ivahi iva_hidrocon int(11) not null;

alter table rate change adu percent_aduccion double;
alter table rate change dis percent_distribucion double;
alter table rate change dep percent_depuracion double;
alter table rate change alc percent_alcantarillado double;
