package cg;

import java.util.*;
import java.sql.*;

public class Demo4 {

	public static void main(String[] args)  {
		
		try {
			//Load the driver
			
			
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hr";
		String pass="hr";
		
		
		Connection con=DriverManager.getConnection(url,user,pass);
		System.out.println("Connected");
		con.setAutoCommit(false);//tells that do not commit after every dml statement
		//Java application automatically commits so setAutoCommit false
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Account Id: ");
		int id=sc.nextInt();
		System.out.println("Enter Mobile Number: ");
		long mb=sc.nextLong();
		System.out.println("Enter Accountholder name: ");
		String ah=sc.nextLine();
		System.out.println("Enter Initial balance: ");
		double bal=sc.nextDouble();
		//dynamic query
		String sqlQuery="insert into account values(?,?,?,?)";
		
		
		PreparedStatement st=con.prepareStatement(sqlQuery);
		st.setInt(1, id);;
		st.setLong(2, mb);
		st.setString(3, ah);
		st.setDouble(4, bal);
		int insertRec=st.executeUpdate();
		System.out.println("Inserted Records:"+insertRec);
		
		con.commit();
		con.close();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage()+" "+e.getErrorCode()+" "+e.getSQLState());
			e.printStackTrace();
		}
		
		
		
	}

}
