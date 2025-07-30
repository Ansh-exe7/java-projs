package bank.management.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    public Conn(){

        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/chamar","root","114198");
            s = c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
