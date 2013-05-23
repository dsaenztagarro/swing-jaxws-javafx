alter table comment add id INT(11) NOT NULL FIRST;
alter table `hidrocon`.`comment` MODIFY COLUMN `id` INTEGER  NOT NULL AUTO_INCREMENT, add PRIMARY KEY (`id`);

alter table comment add rec_status CHAR(1) DEFAULT 'A' NOT NULL;

alter table comment change nummensaje comment_number int(11);
alter table comment change mensaje comment_text varchar(2000);

/*
@Entity
@Table(name = "comment")
@NamedQueries({
	@NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c WHERE recStatus = 'A' order by c.nummensaje"),
	@NamedQuery(name = "Comment.findById", query = "SELECT c FROM Comment c WHERE c.id = :id"),
	@NamedQuery(name = "Comment.findByNummensaje", query = "SELECT c FROM Comment c WHERE c.nummensaje = :nummensaje"),
	@NamedQuery(name = "Comment.findByMensaje", query = "SELECT c FROM Comment c WHERE c.mensaje = :mensaje")})
*/