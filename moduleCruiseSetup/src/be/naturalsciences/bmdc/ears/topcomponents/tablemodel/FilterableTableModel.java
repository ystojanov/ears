/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.naturalsciences.bmdc.ears.topcomponents.tablemodel;

import java.util.List;

/**
 *
 * @author Thomas Vandenberghe
 */
public interface FilterableTableModel {
    
     public List<Integer> getRowsByQueryAndColumn(String searchBy, String column);
     
     public int findColumn(String name);
}
