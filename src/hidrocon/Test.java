/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author david
 */
@Entity
@Table(name = "TEST", catalog = "hidrocon", schema = "")
@NamedQueries({
	@NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t"),
	@NamedQuery(name = "Test.findById", query = "SELECT t FROM Test t WHERE t.id = :id"),
	@NamedQuery(name = "Test.findByName", query = "SELECT t FROM Test t WHERE t.name = :name")})
public class Test implements Serializable {
	@Transient
	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @Column(name = "id")
	private BigDecimal id;
	@Basic(optional = false)
    @Column(name = "name")
	private String name;

	public Test() {
	}

	public Test(BigDecimal id) {
		this.id = id;
	}

	public Test(BigDecimal id, String name) {
		this.id = id;
		this.name = name;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		BigDecimal oldId = this.id;
		this.id = id;
		changeSupport.firePropertyChange("id", oldId, id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		String oldName = this.name;
		this.name = name;
		changeSupport.firePropertyChange("name", oldName, name);
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Test)) {
			return false;
		}
		Test other = (Test) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "hidrocon.Test[id=" + id + "]";
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);
	}

}
