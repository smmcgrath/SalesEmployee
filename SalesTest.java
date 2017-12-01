import java.util.Scanner; //Import Scanner
import java.util.List; //Import List
import java.util.ArrayList; //Import ArrayList
import java.io.*; // import streams
//import java decimal method
import java.text.DecimalFormat;

public class SalesTest{
        public static void main(String[] args){
            //create new instance of scanner
            Scanner input = new Scanner(System.in);
            //create new ArrayList populated with instances of salesEmployee
            List<SalesEmployee> SalesList = new ArrayList<SalesEmployee>();

            //Declare and initialise variables of the type integer11
            int employeeType = 0, i = 0;
            //get user to select the employee
            System.out.println("Please select the type of employee to be entered."
            + " \n\tEnter 1 for a sales person." 
            + " \n\tEnter 2 for a sales agent."
            + " \n\tEnter any other number for finish the list.");

            //assign next input to employee
            employeeType = input.nextInt();
            input.nextLine();
            //a while loop is used to make sure employee 11 or 2 is selected in ArrayList
            while (employeeType == 1 || employeeType == 2){
                //if and else statement to implement the decision of type of employee
                if(employeeType == 1){
                    SalesList.add(new SalesPerson());
                    System.out.print("Sales Person Selected\n");
                }
                else {
                    SalesList.add(new SalesAgent());
                    System.out.print("Sales Agent Selected");
                }
                //use input, getters & setters to assign values entered in console 
                System.out.println("Enter Employees First Name");
                String fn=input.nextLine();
                SalesList.get(i).setFirstName(fn);
                System.out.println("Enter Employees Last Name");
                String ln=input.nextLine();
                SalesList.get(i).setLastName(ln);
                System.out.println("Enter " + fn + " " + ln + "'s PPS Number");
                String ppsid=input.nextLine();
                SalesList.get(i).setPPS(ppsid);
                System.out.println("Enter total sales for " + fn + " " + ln);
                SalesList.get(i).sales=input.nextDouble();
                //Implement the calculateCommision method
                SalesList.get(i).calculateCommission();
                //Increment i
                i++;
                //clear the buffer
                input.nextLine();
                //gets user to select if they want to add to the list, and employee type
                System.out.println("Please select the type of employee to be entered."
                + " \n\tEnter 1 for a sales person." 
                + " \n\tEnter 2 for a sales agent."
                + " \n\tEnter any other number for finish the list.");
                employeeType=input.nextInt();
                input.nextLine();
            }
            //prints to list when while loop exited.
            System.out.println("Employee list complete.");
            input.close();
            //An enhanced for loop is used to iterate through the ArrayList
            for(SalesEmployee s: SalesList){
                //Print toString method to screen
                System.out.println(s.toString());
                }
            try{
                // create a connection stream (write bytes) 
                FileOutputStream fileStream = new FileOutputStream("EmployeeInfo.dat");
                
                // create a chain stream (allows objects to be written to a stream)
                ObjectOutputStream os = new ObjectOutputStream(fileStream);
                
                // call writeObject() on the Object stream
                os.writeObject(SalesList);
                
                os.close();
                
                }catch (Exception e) {
                    e.printStackTrace();
                }
            try{
                FileInputStream fileStream = new FileInputStream("EmployeeInfo.dat");
                
                ObjectInputStream os = new ObjectInputStream(fileStream);
                
                List<SalesEmployee> emp = (List<SalesEmployee>)os.readObject();
                
                for (SalesEmployee element:emp){
                System.out.println(element.toString());
                }
                
                os.close();
                
                } catch (Exception e) {
                e.printStackTrace();
                }
            try {
             
                FileWriter fileWriter = new FileWriter("EmployeeList.txt");
             
                BufferedWriter writer = new BufferedWriter(fileWriter);
                
                writer.write("Employee List \n");
                
                for(SalesEmployee element:SalesList){
                writer.write("First Name: " + element.getFirstName() + " \n ");
                writer.write("Last Name: " + element.getLastName() + " \n ");
                writer.write("PPS Number: " + element.getPPS() + " \n ");
                
                writer.close();
                }
                } catch(IOException e){
                e.printStackTrace();
                } 
            try{
                File employeeFile = new File("EmployeeList.txt");
               
                FileReader fileReader = new FileReader(employeeFile);
                
                BufferedReader reader = new BufferedReader(fileReader);
                
                String line = null;
                
                while ((line = reader.readLine()) != null){
                System.out.println(line);
                }
                
                reader.close();
                
                } catch (IOException e){
                e.printStackTrace();
                }
        }
}//end class

