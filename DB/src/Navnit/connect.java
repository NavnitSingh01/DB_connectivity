package Navnit;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class connect {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Login2","root","");
		System.out.println("database connected");
		Statement smt = con.createStatement(); 
		
		String query="INSERT INTO `details`(`name`, `roll.no`, `course`, `email`) VALUES ('Badal',1321057,'BCA','badal@gmail.com')";
        smt.execute(query);
        String query1="INSERT INTO `details`(`name`, `roll.no`, `course`, `email`) VALUES ('Raj',1321081,'BCA','raj@gmail.com')";
        smt.execute(query1);
		System.out.println("data inserted succesfully");
		String qurey2="UPDATE `details` SET `email`='singh@gmail.com' WHERE `roll.no`=1321057";
		smt.execute(qurey2);
		System.out.println("Data updated");
		String qurey3="DELETE FROM `details` WHERE `roll.no`=1321057";
		smt.execute(qurey3);
		System.out.println("Data deleted");
		con.close();

	}

}
