/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.custom.table;

import hidrocon.custom.Constant;
import hidrocon.custom.panel.HidroGradientPanel;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author David Sáenz Tagarro
 */
public class HidroHeaderRenderTable extends HidroGradientPanel implements TableCellRenderer {
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
      boolean hasFocus, int rowIndex, int vColIndex) {
    setDirection(this.VERTICAL);
		setForeground(Constant.SECTION_PANEL_FOREGROUND);
		setBackground(Constant.SECTION_PANEL_BACKGROUND);
    setOpaque(false);
      //setText(value.toString());
    setToolTipText((String) value);
    return this;
  }

}