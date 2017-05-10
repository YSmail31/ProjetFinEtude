/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiprocEDF;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ismail
 */
public class Modele extends AbstractTableModel {

    ArrayList<Task> ts;
    String nomColonne[]=new String[]{"Id","Calcul","Deadline","Periode"};

    public Modele(ArrayList<Task> ts) {
        this.ts = ts;
    }
    
    @Override
    public int getRowCount() {
        return ts.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Task t=ts.get(rowIndex);
        switch(columnIndex)
        {
            case 0:return t.getId();
            case 1:return t.getC();
            case 2:return t.getD();
            case 3:return t.getT();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return nomColonne[column];
    }
    
    
}
