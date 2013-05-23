/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom.table;

import hidrocon.core.common.customrendertable.entities.CustomRenderTable;
import hidrocon.core.common.customrendertable.manager.CustomRenderTableManager;
import hidrocon.custom.Constant;
import hidrocon.custom.utils.HidroImageCache;
import java.awt.Color;
import java.awt.Component;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author david
 */
public class HidroRenderTable implements TableCellRenderer {

	protected JLabel toRender = new JLabel();
    
    private static List<CustomRenderTable> customRenderTableList;
    
	public HidroRenderTable() {
		toRender.setOpaque(true);
        toRender.setFocusable(true);
        //Border used as padding
        Border paddingBorder = BorderFactory.createEmptyBorder(10,10,10,10);
        toRender.setBorder(BorderFactory.createCompoundBorder(toRender.getBorder(),paddingBorder));        
        
	}

    protected void setColumnIcon(String fileName) {
        HidroImageCache ic = HidroImageCache.getInstance();
        ImageIcon img = ic.getImageIcon(fileName);
        if (img==null) {
            img = new javax.swing.ImageIcon(getClass().getResource("/hidrocon/resources/images/table/"+fileName));
            ic.addImageIcon(fileName, img);
        }
        toRender.setHorizontalAlignment(SwingConstants.CENTER);
		toRender.setIcon(img);        
    }
    
    
    protected void setCheckIcon() {
        setColumnIcon("ok_20x20.png");
    }
    /*
    protected void setFavoriteIcon() {
        setColumnIcon("button_favorite_24x24.png");
    }*/
    
    protected void setBooleanIcon(String fileName) {
        HidroImageCache ic = HidroImageCache.getInstance();
        ImageIcon img = ic.getImageIcon(fileName);
        if (img==null) {
            img = new javax.swing.ImageIcon(getClass().getResource("/hidrocon/resources/images/table/"+fileName));
            ic.addImageIcon(fileName, img);
        }
		toRender.setIcon(img);        
    }      

    protected boolean customRenderer(JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
        if (customRenderTableList==null) {
            CustomRenderTableManager crtm = new CustomRenderTableManager();
            customRenderTableList = crtm.getCustomRenderTableList();
        }
        boolean columnRenderTableFound = false;
        for (CustomRenderTable crt : customRenderTableList) {
            if (table.getName().equals(crt.getCustomRenderTablePK().getTableName()) &&
                column == crt.getCustomRenderTablePK().getColumnId()) {
                columnRenderTableFound = true;
                if (obj instanceof Character) {
                    if (crt.getCustomRenderTablePK().getCellValue().equals(((Character)obj).toString())) {
                        setColumnIcon(crt.getIconPath());
                    }
                }
                else if (obj instanceof String) {
                    if (crt.getCustomRenderTablePK().getCellValue().equals(obj)) {
                        setColumnIcon(crt.getIconPath());
                    }                    
                }
                else if (obj instanceof Integer) {
                    if (crt.getCustomRenderTablePK().getCellValue().equals(((Integer)obj).toString())) {
                        setColumnIcon(crt.getIconPath());
                    }                    
                }                
                else {
                    System.out.println("crt.getCustomRenderTablePK().getCellValue(): " + crt.getCustomRenderTablePK().getCellValue());
                    System.out.println("HidroRenderTable.obj: " + obj);
                }
            }
        }
        return columnRenderTableFound;
    } 
    
    private void resetTableCellRendererComponent(JTable table) {
		toRender.setFont(table.getFont());
        toRender.setIcon(null);
        toRender.setText("");
        toRender.setHorizontalAlignment(SwingConstants.LEFT);         
    }
    
	@Override
	public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
          
        resetTableCellRendererComponent(table);
        
        if (!customRenderer(table,obj,isSelected,hasFocus,row,column)) {
            
            //System.out.println("obj: " + obj.getClass() + " value: " + obj + " column: " + column);
            
            if (obj instanceof String) {
                toRender.setText((String)obj);
            }
            else if (obj instanceof Boolean) {
                if (((Boolean)obj).booleanValue()) {
                    setCheckIcon();
                }
            }
            else if (obj instanceof Character) {
                char charValue = ((Character)obj).charValue();
                if (charValue == Constant.CHARACTER_TRUE) {
                    setCheckIcon();
                }
            }            
            else if (obj instanceof Integer) {
                try {
                    toRender.setText(String.valueOf(((Integer)obj).intValue()));
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
            }
            else if (obj instanceof Long) {
                try {
                    toRender.setText(String.valueOf(((Long)obj).longValue()));
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
            }                        
            else if (obj instanceof Float) {
                try {
                    toRender.setText(String.valueOf(((Float)obj).floatValue()));
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
            }
            else if (obj instanceof BigInteger) {
                try {
                    toRender.setText(String.valueOf(((BigInteger)obj).intValue()));
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
            }            
            else if (obj instanceof Date) {
                try {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");                
                    toRender.setText(formatter.format((Date)obj));
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
            }
        }
        
        if (isSelected) {
            toRender.setBackground(new Color(88,88,88));
            toRender.setForeground(Color.WHITE);
        } else {
            if (row % 2 == 0) {
                toRender.setBackground(new Color(227,227,227)); //Color.cyan);
            } else {
                toRender.setBackground(new Color(184,184,184)); //Color.lightGray);
            }
            toRender.setForeground(Color.black);
        }
            
		return toRender;
	}
}
