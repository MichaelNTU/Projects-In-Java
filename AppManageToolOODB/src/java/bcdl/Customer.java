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
public class Customer implements Serializable {
    private Long serialVersionUID = 1L;
     @Id @GeneratedValue(strategy=GenerationType.AUTO) Long id;
     
     private String customerName;
     private String street;
     private String customerCity;
     
     public void Customer(String customerName, String street, String customerCity){
     
     this.customerName = customerName;
     this.street = street;
     this.customerCity = customerCity;
     
     }
     public Long getId() {
        return id;
    }
     public String getcustomerName() {
        return customerName;
    }
     public String getstreet() {
        return street;
    }
     public String getcustomerCity() {
        return customerCity;
    }
      public String toString()
    {
        return "customerName: " + customerName +
                " street: " + street +
                "customerCity: " + customerCity ;
    }

//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Customer)) {
//            return false;
//        }
//        Customer other = (Customer) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "bcdl.Customer[ id=" + id + " ]";
//    }
    
}
