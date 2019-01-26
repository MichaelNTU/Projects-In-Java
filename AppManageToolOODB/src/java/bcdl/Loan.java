/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcdl;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author mikeo
 */
@Entity
public class Loan implements Serializable {
     private  Long serialVersionUID = 1L;
     @Id @GeneratedValue(strategy=GenerationType.AUTO) Long id;
     
     private String customerName;
     private String  branchName ;
     private Long loanNumber;
     private Long amount;
     
     public void Loan(String customerName,String  branchName,Long loanNumber,Long amount){
         
         this.customerName = customerName;
         this.branchName = branchName;
         this.loanNumber = loanNumber;
         this.amount = amount;
     
     
     }
     public Long getId() {
        return id;
    }
     public String getcustomerName() {
        return customerName;
    }
     public String getbranchName() {
        return branchName;
    }
     public Long getloanNumber() {
        return loanNumber;
    }
      public Long getamount() {
        return amount;
    }
       public String toString()
    {
        return "branchName: " + customerName +
                " branchName: " + branchName +
                " loanNumber: " + loanNumber +                
                " amount: " + amount;
    }


    
}
