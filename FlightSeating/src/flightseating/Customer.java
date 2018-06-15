package flightseating;


import java.io.File;
import java.util.*;
import java.io.*;


/**
 *
 * @author Jordan
 */
public class Customer 
{
    //customer attributes
    public String customerName;
    public String ageType;
    public String classType;
    public String seatType;
    //constructors
    Customer()
    {
        
    }
    Customer(String name,String agetype, String classtype, String seattype)
    {
        this.customerName = name;
        this.ageType = agetype;
        this.classType = classtype;
        this.seatType = seattype;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAgeType() {
        return ageType;
    }

    public void setAgeType(String ageType) {
        this.ageType = ageType;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }
  
   
}
