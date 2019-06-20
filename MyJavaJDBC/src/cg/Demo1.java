package cg;


import java.sql.*;

public class Demo1 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		
		try {//Load the driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		//jdbc,oracle protocol and thin is network protocol
		//for remote access ip address is required
		//port no. is 1521 //xe stands for sid database instance name express edition
		String user="hr";
		String pass="hr";
		
		Connection con=DriverManager.getConnection(url,user,pass);
		
		System.out.println("Connected");
		Statement st=con.createStatement();//used to pass sql queries
		ResultSet rs=st.executeQuery("select * from account");
		System.out.println("==================");
		while(rs.next()) {
			int a_id=rs.getInt("aid");
			long mobile=rs.getLong("mobileno");//either column name or column number 
			String ah=rs.getString(3);
			double bal=rs.getDouble(4);
			
			System.out.println("Account Id: "+a_id+" Mobile: "+mobile+" Name: "+ah+" Balance: "+bal);;
			System.out.println("==================");
			
		}
		con.close();
		
	}

}
