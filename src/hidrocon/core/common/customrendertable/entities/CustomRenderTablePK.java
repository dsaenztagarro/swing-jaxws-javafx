/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.core.common.customrendertable.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author David Sáenz Tagarro
 */
@Embeddable
public class CustomRenderTablePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "table_name")
    private String tableName;
    @Basic(optional = false)
    @Column(name = "column_id")
    private int columnId;
    @Basic(optional = false)
    @Column(name = "cell_value")
    private String cellValue;

    public CustomRenderTablePK() {
    }

    public CustomRenderTablePK(String tableName, int columnId, String cellValue) {
        this.tableName = tableName;
        this.columnId = columnId;
        this.cellValue = cellValue;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getColumnId() {
        return columnId;
    }

    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    public String getCellValue() {
        return cellValue;
    }

    public void setCellValue(String cellValue) {
        this.cellValue = cellValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tableName != null ? tableName.hashCode() : 0);
        hash += (int) columnId;
        hash += (cellValue != null ? cellValue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomRenderTablePK)) {
            return false;
        }
        CustomRenderTablePK other = (CustomRenderTablePK) object;
        if ((this.tableName == null && other.tableName != null) || (this.tableName != null && !this.tableName.equals(other.tableName))) {
            return false;
        }
        if (this.columnId != other.columnId) {
            return false;
        }
        if ((this.cellValue == null && other.cellValue != null) || (this.cellValue != null && !this.cellValue.equals(other.cellValue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hidrocon.core.common.customrendertable.entities.CustomRenderTablePK[ tableName=" + tableName + ", columnId=" + columnId + ", cellValue=" + cellValue + " ]";
    }
    
}
