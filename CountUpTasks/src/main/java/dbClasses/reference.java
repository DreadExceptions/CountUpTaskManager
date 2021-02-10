/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbClasses;

/**
 *
 * @author marquis
 */
public class reference {
    
    private String tableName;
    private int ID;
    private String name;
    private String description;

    public reference(String tblNm, int ID, String name, String description) {
        this.tableName = tblNm;
        this.ID = ID;
        this.name = name;
        this.description = description;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    //public static String selectList() {}
    
    //public static reference selectSingle(int id) {}
    
    //public String insertSingle() {}
    
    //public void deleteSingle() {}
    
    //public void updateSingle() {}
    
}
