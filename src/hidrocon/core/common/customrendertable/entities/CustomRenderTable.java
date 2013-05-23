/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.core.common.customrendertable.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David Sáenz Tagarro
 */
@Entity
@Table(name = "custom_render_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomRenderTable.findAll", query = "SELECT c FROM CustomRenderTable c"),
    @NamedQuery(name = "CustomRenderTable.findByTableName", query = "SELECT c FROM CustomRenderTable c WHERE c.customRenderTablePK.tableName = :tableName"),
    @NamedQuery(name = "CustomRenderTable.findByColumnId", query = "SELECT c FROM CustomRenderTable c WHERE c.customRenderTablePK.columnId = :columnId"),
    @NamedQuery(name = "CustomRenderTable.findByCellValue", query = "SELECT c FROM CustomRenderTable c WHERE c.customRenderTablePK.cellValue = :cellValue"),
    @NamedQuery(name = "CustomRenderTable.findByIconPath", query = "SELECT c FROM CustomRenderTable c WHERE c.iconPath = :iconPath")})
public class CustomRenderTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CustomRenderTablePK customRenderTablePK;
    @Basic(optional = false)
    @Column(name = "icon_path")
    private String iconPath;

    public CustomRenderTable() {
    }

    public CustomRenderTable(CustomRenderTablePK customRenderTablePK) {
        this.customRenderTablePK = customRenderTablePK;
    }

    public CustomRenderTable(CustomRenderTablePK customRenderTablePK, String iconPath) {
        this.customRenderTablePK = customRenderTablePK;
        this.iconPath = iconPath;
    }

    public CustomRenderTable(String tableName, int columnId, String cellValue) {
        this.customRenderTablePK = new CustomRenderTablePK(tableName, columnId, cellValue);
    }

    public CustomRenderTablePK getCustomRenderTablePK() {
        return customRenderTablePK;
    }

    public void setCustomRenderTablePK(CustomRenderTablePK customRenderTablePK) {
        this.customRenderTablePK = customRenderTablePK;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customRenderTablePK != null ? customRenderTablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomRenderTable)) {
            return false;
        }
        CustomRenderTable other = (CustomRenderTable) object;
        if ((this.customRenderTablePK == null && other.customRenderTablePK != null) || (this.customRenderTablePK != null && !this.customRenderTablePK.equals(other.customRenderTablePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hidrocon.core.common.customrendertable.entities.CustomRenderTable[ customRenderTablePK=" + customRenderTablePK + " ]";
    }
    
}
