package DataBase_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class DataBase {
    
   public static Connection connect;
    
    
     public static void main(String[] args) throws SQLException {
        new DataBase().getconnection();
         if (connect != null) {
        System.out.println("Connected");
    }
    }

public static Connection getconnection() throws SQLException {
        if (connect == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection("jdbc:mysql://localhost/softwareengineering2", "root", "");
      //  flag = true;
            } catch (ClassNotFoundException ex) {
                System.out.println("class not found");
                
            } catch (SQLException ex) {
                System.out.println("sql exception happens ");
               
            }
        }
        return connect;
    }

    public static void disconnect() {
        if (connect != null) {

            connect = null;
        }
        


    }    
    
    
    
    
    
}/* if(per== "week"){
                           // Statement st=connect.createStatement();
                            st.executeQuery("select * from weeklychart");
                            while(rs.next()){
                            %>
                                <option><%=rs.getString("period")%></option>
                                 <% 
                            }
                            } 




  if(per=="Month"){
                            Statement st=connect.createStatement();
                            ResultSet rs=st.executeQuery("select * from monthlychart");
                            while(rs.next()){
                                %>
                                <option><%=rs.getString("period")%></option>
                                 <%
                            }
                           }else*/ 
