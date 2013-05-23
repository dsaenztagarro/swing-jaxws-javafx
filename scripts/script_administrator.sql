alter table administrator add id INT(11) NOT NULL FIRST;
alter table administrator MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT, add PRIMARY KEY (id);

alter table administrator add email_address varchar(250) not null;
alter table administrator add rec_status CHAR(1) DEFAULT 'A' NOT NULL;

update administrator set obsadm = concat(obsadm,'\n', ob2adm);
alter table administrator drop column ob2adm;

alter table administrator change numadmor administrator_id int(11);
alter table administrator change nomadm administrator_name varchar(200);
alter table administrator change diradm address varchar(200);
alter table administrator change disadm zip_code varchar(10);
alter table administrator change proadm province varchar(100);
alter table administrator change pobadm city varchar(100);
alter table administrator change tel1adm phone_number varchar(20);
alter table administrator change tel2adm phone_number_2 varchar(20);
alter table administrator change faxadm fax varchar(50);
alter table administrator change sufij suffix varchar(20);
alter table administrator change presen presenter_name varchar(200);
alter table administrator change nifpresen presenter_nif varchar(20);
alter table administrator change sufij presenter_suffix varchar(10);
alter table administrator change entsuc presenter_entity varchar(200);
alter table administrator change obsadm observations varchar(2000);
alter table administrator change poradm reference int(11);

/*
@Entity
@Table(name = "administrator")
@NamedQueries({
	@NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a WHERE a.recStatus = 'A' ORDER BY a.administratorId asc"),
	@NamedQuery(name = "Administrator.findByAdministratorId", query = "SELECT a FROM Administrator a WHERE a.administratorId = :administratorId")})
*/
