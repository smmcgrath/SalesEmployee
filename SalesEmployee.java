//import streams
import java.io.*;
//import java decimal method
import java.text.DecimalFormat;
//create abstract class SalesEmployee
    abstract public class SalesEmployee implements Serializable {
            //create a new instance of decimal format
            public static DecimalFormat df = new DecimalFormat("€####.00");
            //declare variables
            private String firstName, lastName, ppsNumber;
            protected double sales, commission;
            //create SalesEmployee default constructor
            public SalesEmployee(){
                this.firstName = "Not known";
                this.lastName = "Not known";
                this.ppsNumber = "Not known";
            }
        //create new SalesEmployee constructor with parameters
        public SalesEmployee(String firstName, String lastName, String ppsNumber){
            this.firstName = firstName;
            this.lastName = lastName;
            this.ppsNumber = ppsNumber;
        }
        //getters and setters for private variables
        public String getFirstName(){
            return firstName;
        }
        public void setFirstName(String fName){
            this.firstName = fName;
        }
        public String getLastName(){
            return lastName;
        }
        public void setLastName(String lName){
            this.lastName = lName;
        }
        public String getPPS(){
            return ppsNumber;
        }
        public void setPPS(String PPSNo){
            this.ppsNumber = PPSNo; 
        }  
        
        //override toString method
        public String toString(){
            return "SalesEmployee [First Name = " + firstName + ", Last Name = " + lastName + 
            ", PPS Number = " + ppsNumber + ", Sales = " + df.format(sales) + ", Commission = " +
            df.format(commission);
        }
        //create abstract method calculateCommission
        abstract void calculateCommission();
    }//end class