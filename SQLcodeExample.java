/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlcodeexample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Ryan
 */
public class SQLcodeExample  {
   public static void main (String[ ] args)  {

      try {								
         String host  = "jdbc:mysql://localhost/STUDENT";                            
         String uName = "bsmith"; 
         String uPass = "roxie"; 
   
         // 2. THE PURPOSE (RESULT) OF THE FOLLOWING API CALL IS this establishes a connection to the host with the user name and password.
         Connection conn = DriverManager.getConnection(host, uName, uPass);    
         
         // 3. THE PURPOSE (RESULT) OF THE FOLLOWING API CALLS IS The below statment executes a query by selecting the database Stu_id Then it gets the table Stu_Name from Row Stu_Class_1.
         Statement stmt = conn.createStatement();                         
         String sql = "select  Stu_id, Stu_Name from Stu_Class_1";                                       
         ResultSet rs = stmt.executeQuery (sql);                                   
                                         
         System.out.println("Displaying student information: ");     
    
         
         // 4. THE RESULT OF THE FOLLOWING API CALLS IS PRINT TO THE CONSOLE Stu_id AND ASSOCIATE THE ID WITH Stu_Name
         while (rs.next()) {

             System.out.println ("Student id " + rs.getString("Stu_id");  
             System.out.println (" is associated with student name " + rs.getString("Stu_Name");  
         }    	                                                               
   
      } 
      // 5. THE PURPOSE OF THE FOLLOWING CATCH BLOCK IS Throw an SQLexception IF THE FOLLOWING TRY STATEMENT IS FALSE
      catch ( SQLException err ) {
         System.out.println(err.getMessage());

      }
      finally {
         // CLOSES THE CONNECTION TO THE DATABASE
         conn.close();
      }
   }
}