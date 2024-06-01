package org.example.bean;

import javax.swing.JTable;

public class CustomizedJTable extends JTable {

    public CustomizedJTable(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
        this.getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
