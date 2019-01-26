/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcdl;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author mikeo
 */
@Entity
public class Branch implements Serializable {
    private static final Long serialVersionUID = 1L;
     @Id @GeneratedValue(strategy=GenerationType.AUTO) Long id;
     
      private String branchName ;
      private int assets ;
      private String branchCity ;
      private Date entrygDate;
      
      public Branch(){
      }
      
      public Branch(String branchName,int assets,String branchCity){
      this.branchName = branchName;
      this.assets = assets;
      this.branchCity = branchCity;  
      this.entrygDate = new Date(System.currentTimeMillis());
     } 
      public Long getId() {
        return id;
    }
      public String getbranchName() {
        return branchName;
    }
       public int getassets() {
        return assets;
    }
        public String getbranchCity() {
        return branchCity;
    }
//        public String toString() {
//        return String.format("(%d, %d, %d)", this.branchName, this.assets, this.branchCity);
//    }

         public String toString()
    {
        return "branchName: " + branchName +
                " assets: " + assets +
                " branchCity: " + branchCity + "entryDate" + entrygDate;
    }


    
}
