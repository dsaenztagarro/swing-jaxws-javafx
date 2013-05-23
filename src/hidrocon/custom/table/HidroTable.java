/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom.table;

import hidrocon.custom.Constant;
import java.awt.Color;
import java.awt.Dimension;
import java.math.BigInteger;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author david
 */
public class HidroTable extends JTable {

	public HidroTable() {
		super();
		initProperties();
	}

	private void initProperties() {
		JTableHeader header = getTableHeader();
		header.setFont(Constant.DEFAULT_FONT);
		header.setBackground(Constant.TABLE_HEADER_BACKGROUND);
		header.setForeground(Color.WHITE);
		header.setPreferredSize(new Dimension(this.getColumnModel().getTotalColumnWidth(), Constant.TABLE_ROW_HEIGHT));

        setFocusable(true);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setColumnSelectionAllowed(false);
		setRowSelectionAllowed(true);
		setFont(Constant.DEFAULT_FONT);
		setRowHeight(Constant.TABLE_ROW_HEIGHT);
		setAutoCreateRowSorter(true);
        //sssetAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		HidroRenderTable hidroRenderTable = new HidroRenderTable();
		setDefaultRenderer(Integer.class, hidroRenderTable);
        setDefaultRenderer(Long.class, hidroRenderTable);
        setDefaultRenderer(Float.class, hidroRenderTable);
		setDefaultRenderer(String.class, hidroRenderTable);
        setDefaultRenderer(Date.class, hidroRenderTable);
        setDefaultRenderer(Boolean.class, hidroRenderTable);
        setDefaultRenderer(Character.class, hidroRenderTable);
        setDefaultRenderer(BigInteger.class, hidroRenderTable);
        
        //setShowGrid(false);
        //setShowHorizontalLines(false);
        //setShowVerticalLines(false);
	}

	public void newFilter(String text, int column) {
		TableRowSorter sorter = new TableRowSorter(this.getModel());
		this.setRowSorter(sorter);
		RowFilter rf = null;
        //If current expression doesn't parse, don't update.
        try {
			rf = RowFilter.regexFilter(text, column);
            sorter.setRowFilter(rf);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
	}

	public void newNumberFilter(Number number, int column) {
		TableRowSorter sorter = new TableRowSorter(this.getModel());
		this.setRowSorter(sorter);
		RowFilter rf = null;
        //If current expression doesn't parse, don't update.
        try {
			rf = RowFilter.numberFilter(RowFilter.ComparisonType.EQUAL, number, column);
            sorter.setRowFilter(rf);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
	}

	public void clearFilter() {
		this.setRowSorter(null);
	}

}
