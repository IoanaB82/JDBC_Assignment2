import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
//nu tb sa importam ceva java.util pt exceptie pt ca este inclus in celelalte doua importuri

public class Assignment2{
  public static Connection getConnection() throws Exception{
    //facem chestia asta ca sa testam daca se face legatura la server cu un utilizator si parola
    try{
      String url = "jdbc:mysql://localhost:3306/sqlandjava";
      String username = "user";
      String password = "password";
      Connection conn = DriverManager.getConnection(url, username, password);
      System.out.println("Connected to database!");
      return conn;
    } catch(Exception e){System.out.println(e);}
    return null;

  }

  public static void main(String[] args) throws Exception{
  //hampus recomanda ca in Windows sa folosim cmd pentru a scrie codul ca sa nu avem erori aiurea
//Get Connection
  Connection conn = getConnection();

  //create statement
  Statement statement = conn.createStatement();

  //Execute SQL Query
  ResultSet res = statement.executeQuery("select * from cars");

  //process ResultSet
  while(res.next()){
    System.out.println(res.getString("car_id")+": "+res.getString("brand")+" "+res.getString("color"));
  }
  }

}
