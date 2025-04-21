
package project_x;
 import java.sql.*;
import javafx.scene.control.Alert;
public class DatabaseConectivity {
    Connection link;
   public Connection databaseConnectivity() throws Exception{
       String url="jdbc:mysql://localhost:3306/Ekub";
       String username="root";
       String password="Teddy123";
       Class.forName("com.mysql.cj.jdbc.Driver");
       link=DriverManager.getConnection(url, username, password);
      
      return link;
      
                  
               
   } 
    
}
