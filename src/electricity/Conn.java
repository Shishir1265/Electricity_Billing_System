package electricity;

import java.sql.*;  

public class Conn{
    public Connection c;
    public Statement s;
    public Conn(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///ebs","root","shishi");    
            s =c.createStatement();  
            System.out.println("connected :)");
                       
        }catch(Exception e){ 
            System.out.println("Ooops there's an error!");
            e.printStackTrace();
        }  
    }  
}  
