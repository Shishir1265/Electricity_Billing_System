package electricity;

import java.sql.*;  

public class Conn{
    public Connection c;
    public Statement s;
    public Conn(){  
        try{  
<<<<<<< HEAD
            Class.forName("com.mysql.cj.jdbc.Driver");  
=======
            Class.forName("com.mysql.jdbc.Driver");  
>>>>>>> b6b7790224d388c0f05a7cfa341fef09c9e01d72
            c =DriverManager.getConnection("jdbc:mysql:///ebs","root","shishi");    
            s =c.createStatement();  
            System.out.println("connected :)");
                       
        }catch(Exception e){ 
            System.out.println("Ooops there's an error!");
            e.printStackTrace();
        }  
    }  
}  
