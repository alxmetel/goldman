/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.models;

import com.metel.goldman.objects.MapInfo;
import com.metel.goldman.objects.SavedMapInfo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Metel
 */
public class SaveGameTableModel extends AbstractTableModel {

    private final ArrayList<SavedMapInfo> list;

    public SaveGameTableModel(ArrayList<SavedMapInfo> list) {
        this.list = list;
    }
    
    public MapInfo getMapInfo(int index){
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = rowIndex + 1;
                break;
            case 1:
                value = list.get(rowIndex).getUser().getUsername();
                break;
            case 2:
                Date date = new Date(list.get(rowIndex).getSaveDate());
                value = dateFormat.format(date);
                break;
            case 3:
                value = list.get(rowIndex).getTotalScore();
                break;
            case 4:
                value = list.get(rowIndex).getTurnsCount();
                break;


            default:
                throw new IndexOutOfBoundsException("Column index out of bounds: " + // NOI18N
                        columnIndex);
        }
        return value;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?> clazz;
        switch (columnIndex) {
            case 0:
            case 3:
            case 4:
                clazz = Integer.class;
                break;
            case 1:
            case 2:
                clazz = String.class;
                break;
           

            default:
                throw new IndexOutOfBoundsException("Column index out of bounds: " + columnIndex);
        }
        return clazz;
    }

    @Override
    public String getColumnName(int column) {
        String columnName;
        switch (column) {
            case 0:
                columnName = "#";
                break;
            case 1:
                columnName = "Name";
                break;
            case 2:
                columnName = "Date";
                break;
            case 3:
                columnName = "Score";
                break;
            case 4:
                columnName = "Moves";
                break;
            default:
                throw new IndexOutOfBoundsException("Column index out of bounds: " + column);
        }
        return columnName;
    }
    
    public void deleteMapInfo(int index){
        list.remove(index);
    }

    public void refresh() {
        fireTableDataChanged();
    }
}