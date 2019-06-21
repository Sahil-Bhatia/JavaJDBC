package cg;

import java.util.*;
import java.sql.*;

public class Demo6 {

	public static void main(String[] args) throws SQLException  {
		Connection con=null;
		PreparedStatement updateSt=null;
		PreparedStatement selectSt=null;
		//PreparedStatement updateSt=null;
		
		try {
		
			
		//Load the driver
		//DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		//Java 1.8 automatically loads the driver
		//No need to write Class.forName or DriverManager.registerDriver
			
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hr";
		String pass="hr";
		
		
		con=DriverManager.getConnection(url,user,pass);
		System.out.println("Connected");
		con.setAutoCommit(false);//tells that do not commit after every dml statement
		//Java application automatically commits so setAutoCommit false
		Scanner sc=new Scanner(System.in);
		
		/*System.out.println("Enter your Account Id: ");
		int id=sc.nextInt();
		selectSt=con.prepareStatement("select * from account where aid=?");
		selectSt.setInt(1, id);
		ResultSet rs1=selectSt.executeQuery();
		double bal1=0.0 ;
		long mb1=0L;
		String ah1="";
		if(rs1!=null) {//resultset cannot be null
			if(rs1.next()) {
				System.out.println(rs1.getString(3));
				bal1=rs1.getDouble(4);
				mb1=rs1.getLong("mobileno");
				ah1=rs1.getString("accountholder");
				System.out.println("Your balance is: "+bal1);
				
			}
			else {
				System.out.println("Not Found");
			}
			
		}
		
		System.out.println("Enter another Account Id: ");
		int id1=sc.nextInt();
		selectSt.setInt(1, id1);
		ResultSet rs2=selectSt.executeQuery();
		double bal2=0.0;
		long mb2=0L;
		String ah2="";
		
		if(rs2!=null) {
			
			if(rs2.next()) {
				System.out.println(rs2.getString(3));
				bal2=rs2.getDouble("balance");
				mb2=rs2.getLong("mobileno");
				ah2=rs2.getString(3);
				System.out.println("your balance: "+bal2);
			}else {
				System.out.println("Not Found");
			}
		}
		
		
		
		System.out.println("Enter amount to transfer: ");
		double amount=sc.nextDouble();
		updateSt=con.prepareStatement("update account set mobileno=?, accountholder=?, balance=? where aid=?");
		updateSt.setLong(1, mb1);
		updateSt.setString(2,ah1);
		updateSt.setDouble(3,bal1-amount);
		updateSt.setInt(4, id);
		int i1=updateSt.executeUpdate();
		System.out.println("Account updated"+i1);
		
		updateSt.setLong(1,mb2);
		updateSt.setString(2, ah2);
		updateSt.setDouble(3, bal2+amount);
		updateSt.setInt(4, id1);
		
		i1+=updateSt.executeUpdate();
		System.out.println("Account updated"+i1);
		
		//Both accounts to be updated else rollback hence add rollback in catch block
		*/
		
		
		System.out.println("Enter account id for deleting account: ");
		int del_aid=sc.nextInt();
		updateSt=con.prepareStatement("delete from  account  where aid=?");
		updateSt.setInt(1, del_aid);
		int i3=updateSt.executeUpdate();
		System.out.println(i3+ " Accounts Deleted");
		
		con.commit();
	}
		catch(SQLException e) {
			con.rollback();
			System.out.println(e.getMessage()+" "+e.getErrorCode()+" "+e.getSQLState());
			e.printStackTrace();
		}finally {
			System.out.println("Closing Connection");
			if(con!=null) con.close();
		}
		
		
		
	}

}
