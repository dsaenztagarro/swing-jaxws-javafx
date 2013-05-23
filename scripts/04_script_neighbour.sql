alter table neighbour add id INT(11) NOT NULL FIRST;
alter table `hidrocon`.`neighbour` MODIFY COLUMN `id` INTEGER  NOT NULL AUTO_INCREMENT, add PRIMARY KEY (`id`);

alter table neighbour add rec_status CHAR(1) DEFAULT 'A' NOT NULL;

alter table neighbour change numfinca building_number int(11);
alter table neighbour change numorden neighbour_number int(11);
alter table neighbour change nombre neighbour_name varchar(200);
alter table neighbour change tel phone_number varchar(20);
alter table neighbour change piso floor varchar(20);

alter table neighbour add bank_iban varchar(4);
alter table neighbour add bank_entity varchar(4);
alter table neighbour add bank_office varchar(4);
alter table neighbour add bank_dc varchar(2);
alter table neighbour add bank_account varchar(10);
alter table neighbour add bank_ccc_details varchar(200);

update neighbour set bank_ccc_details = concat(banco,' ',sucursal,' ',cuenta,' ',cccvec);
alter table neighbour drop column banco;
alter table neighbour drop column sucursal;
alter table neighbour drop column cuenta;
alter table neighbour drop column c;

alter table neighbour drop column consum12af;
alter table neighbour drop column consum12ac;
alter table neighbour drop column consum11af;
alter table neighbour drop column consum11ac;
alter table neighbour drop column consum10af;
alter table neighbour drop column consum10ac;
alter table neighbour drop column consum9af;
alter table neighbour drop column consum9ac;
alter table neighbour drop column consum8af;
alter table neighbour drop column consum8ac;
alter table neighbour drop column consum7af;
alter table neighbour drop column consum7ac;
alter table neighbour drop column consum6af;
alter table neighbour drop column consum6ac;
alter table neighbour drop column consum5af;
alter table neighbour drop column consum5ac;
alter table neighbour drop column consum4af;
alter table neighbour drop column consum4ac;
alter table neighbour drop column consum3af;
alter table neighbour drop column consum3ac;
alter table neighbour drop column consum2ac;
alter table neighbour drop column consum2af;
alter table neighbour drop column consum1ac;
alter table neighbour drop column consum1af;

alter table neighbour drop column ptsaf12;
alter table neighbour drop column ptsac12;
alter table neighbour drop column ptsaf11;
alter table neighbour drop column ptsac11;
alter table neighbour drop column ptsaf10;
alter table neighbour drop column ptsac10;
alter table neighbour drop column ptsaf9;
alter table neighbour drop column ptsac9;
alter table neighbour drop column ptsaf8;
alter table neighbour drop column ptsac8;
alter table neighbour drop column ptsaf7;
alter table neighbour drop column ptsac7;
alter table neighbour drop column ptsaf6;
alter table neighbour drop column ptsac6;
alter table neighbour drop column ptsaf5;
alter table neighbour drop column ptsac5;
alter table neighbour drop column ptsaf4;
alter table neighbour drop column ptsac4;
alter table neighbour drop column ptsaf3;
alter table neighbour drop column ptsac3;
alter table neighbour drop column ptsaf2;
alter table neighbour drop column ptsac2;
alter table neighbour drop column ptsaf1;
alter table neighbour drop column ptsac1;

alter table neighbour drop column comen12;
alter table neighbour drop column comen11;
alter table neighbour drop column comen10;
alter table neighbour drop column comen9;
alter table neighbour drop column comen8;
alter table neighbour drop column comen7;
alter table neighbour drop column comen6;
alter table neighbour drop column comen5;
alter table neighbour drop column comen4;
alter table neighbour drop column comen3;
alter table neighbour drop column comen2;
alter table neighbour drop column comen1;

alter table neighbour drop column comenau12;
alter table neighbour drop column comenau11;
alter table neighbour drop column comenau10;
alter table neighbour drop column comenau9;
alter table neighbour drop column comenau8;
alter table neighbour drop column comenau7;
alter table neighbour drop column comenau6;
alter table neighbour drop column comenau5;
alter table neighbour drop column comenau4;
alter table neighbour drop column comenau3;
alter table neighbour drop column comenau2;
alter table neighbour drop column comenau1;

alter table neighbour drop column lecf12;
alter table neighbour drop column lecf11;
alter table neighbour drop column lecf10;
alter table neighbour drop column lecf9;
alter table neighbour drop column lecf8;
alter table neighbour drop column lecf7;
alter table neighbour drop column lecf6;
alter table neighbour drop column lecf5;
alter table neighbour drop column lecf4;
alter table neighbour drop column lecf3;
alter table neighbour drop column lecf2;
alter table neighbour drop column lecf1;

alter table neighbour drop column leclecf12;
alter table neighbour drop column leclecf11;
alter table neighbour drop column leclecf10;
alter table neighbour drop column leclecf9;
alter table neighbour drop column leclecf8;
alter table neighbour drop column leclecf7;
alter table neighbour drop column leclecf6;
alter table neighbour drop column leclecf5;
alter table neighbour drop column leclecf4;
alter table neighbour drop column leclecf3;
alter table neighbour drop column leclecf2;
alter table neighbour drop column leclecf1;

alter table neighbour drop column lecc12;
alter table neighbour drop column lecc11;
alter table neighbour drop column lecc10;
alter table neighbour drop column lecc9;
alter table neighbour drop column lecc8;
alter table neighbour drop column lecc7;
alter table neighbour drop column lecc6;
alter table neighbour drop column lecc5;
alter table neighbour drop column lecc4;
alter table neighbour drop column lecc3;
alter table neighbour drop column lecc2;
alter table neighbour drop column lecc1;

alter table neighbour drop column leclecc12;
alter table neighbour drop column leclecc11;
alter table neighbour drop column leclecc10;
alter table neighbour drop column leclecc9;
alter table neighbour drop column leclecc8;
alter table neighbour drop column leclecc7;
alter table neighbour drop column leclecc6;
alter table neighbour drop column leclecc5;
alter table neighbour drop column leclecc4;
alter table neighbour drop column leclecc3;
alter table neighbour drop column leclecc2;
alter table neighbour drop column leclecc1;

update neighbour n set building_number = (select id from building b where b.building_number = n.building_number);
alter table neighbour change building_number building_id int(11);

/*
@Entity
@Table(name = "neighbour")
@NamedQueries({
	@NamedQuery(name = "Neighbour.findById", query = "SELECT v FROM Neighbour v WHERE v.id = :id"),
	@NamedQuery(name = "Neighbour.findByBuildingNumber", query = "SELECT v FROM Neighbour v WHERE v.buildingNumber = :buildingNumber order by v.neighbourNumber asc"),
    @NamedQuery(name = "Neighbour.findByNeighbourNumber", query = "SELECT v FROM Neighbour v WHERE v.neighbourNumber = :neighbourNumber")})
*/