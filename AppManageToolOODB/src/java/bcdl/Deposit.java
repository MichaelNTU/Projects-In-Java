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
public class Deposit implements Serializable {
     private Long serialVersionUID = 1L;
     @Id @GeneratedValue(strategy=GenerationType.AUTO) Long id;
     
     private String customerName;
     private String  branchName ;
     private Long  accountNumber ;
     private Long  balance ;
     
     
     public void Deposit(String customerName,String  branchName,Long  accountNumber,Long  balance){
     
         this.customerName = customerName;
         this.branchName = branchName;
         this.accountNumber = accountNumber;
         this.balance = balance;
     
     
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
     public Long getaccountNumber() {
        return accountNumber;
    }
      public Long getbalance() {
        return balance;
    }
      
      public String toString()
    {
        return "branchName: " + customerName +
                " branchName: " + branchName +
                " accountNumber: " + accountNumber +                
                " balance: " + balance;
    }


    
}
