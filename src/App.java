import java.io.BufferedInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class App {
    public static void main(String[] args) throws Exception {
            try{
                Connection con;
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "");
                Statement stmt;
                stmt=con.createStatement();
                String query="select * FROM student";
                ResultSet result=stmt.executeQuery(query);
                System.out.println(con.getClientInfo());
                while(result.next()){
                    int id;
                    String name,phone,city;
                    id=result.getInt(1);
                    name=result.getString(2);
                    phone=result.getString(3);
                    city=result.getString(4);
                    System.out.println(id+"\t"+name+"\t"+phone+"\t"+city);
                }
    
            }catch(Exception e){
                e.getMessage();
            }
    }
}
