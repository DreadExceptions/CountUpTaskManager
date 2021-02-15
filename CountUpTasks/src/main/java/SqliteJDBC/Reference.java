/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqliteJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marquis
 */
public class Reference {
    
    int RefID;
    String Title;
    String Description;
    
    public Reference (int rfd, String ttl, String dscrpt) {
        this.RefID = rfd;
        this.Title = ttl;
        this.Description = dscrpt;
    }
    
    public Reference (int rfd, String ttl) {
        this.RefID = rfd;
        this.Title = ttl;
    }

    public int getRefID() {
        return RefID;
    }

    public void setRefID(int RefID) {
        this.RefID = RefID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    public ArrayList<Reference> referencesSQL (String tblNm) {
        GeneralJDBC jdbc = new GeneralJDBC();
        ArrayList<Reference> refSet = new ArrayList();
        
        try {
            Connection conn = jdbc.connect();
            PreparedStatement pstmt = conn.prepareStatement(jdbc.getSELECTREF() + tblNm + ";");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                refSet.add(new Reference(rs.getInt("REFID"), rs.getString("TITLE")));
            }//end While Loop
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return refSet;
        
    }
    
    public ArrayList<Reference> referencesWDescSQL (String tblNm) {
        GeneralJDBC jdbc = new GeneralJDBC();
        ArrayList<Reference> refSet = new ArrayList();
        
        try {
            Connection conn = jdbc.connect();
            PreparedStatement pstmt = conn.prepareStatement(jdbc.getSELECTREF() + tblNm + ";");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                refSet.add(new Reference(rs.getInt("REFID"), rs.getString("TITLE"), rs.getString("DESCRIPTION")));
            }//end While Loop
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return refSet;
    }
    
}
