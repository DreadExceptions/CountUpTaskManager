/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqliteJDBC;

/**
 *
 * @author marquis
 */
public class FieldAccess {
    
    private String FieldName;
    private String FieldValue;

    public FieldAccess(String FieldName, String FieldValue) {
        this.FieldName = FieldName;
        this.FieldValue = FieldValue;
    }

    public String getFieldName() {
        return FieldName;
    }

    public void setFieldName(String FieldName) {
        this.FieldName = FieldName;
    }

    public String getFieldValue() {
        return FieldValue;
    }

    public void setFieldValue(String FieldValue) {
        this.FieldValue = FieldValue;
    }
    
    
    
}
