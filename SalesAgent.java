//create subclass
public class SalesAgent extends SalesEmployee{
    //constructor without arguments
    public SalesAgent(){
        super();
    }
    //constructor with arguments
    public SalesAgent(String firstName, String lastName, String ppsNumber){
        super(firstName, lastName, ppsNumber);
    }
    //overriding and implementing the calculatedCommission method
    public void calculateCommission(){
        //sales agent makes a commission of 10% on sales
        commission = (sales)*0.10;
    }//end method
}//end class