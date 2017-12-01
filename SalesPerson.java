//create subclass
public class SalesPerson extends SalesEmployee{
//create constructor
    public SalesPerson(){
        super();
        }
        //create constructor with parameters
        public SalesPerson(String firstName, String lastName, String ppsNumber){
            //pulls the constructor with parameters from the superclass SalesEmployee
            super(firstName, lastName, ppsNumber);
        }
        //overriding and implementing the calculateCommissino method found in the Superclass
        public void calculateCommission(){
            commission = (sales) * 0.15;
            //A sales Person makes 15% commission on sales
        }
}//end class 
