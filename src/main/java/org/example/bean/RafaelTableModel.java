/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.bean;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafael-vieira
 */
public class RafaelTableModel extends DefaultTableModel {

    public RafaelTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
