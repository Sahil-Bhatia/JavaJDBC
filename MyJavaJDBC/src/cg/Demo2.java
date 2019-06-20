package cg;


import java.sql.*;

public class Demo2 {

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
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//used to pass sql queries
		//Result set will only be concur read only, insensitive means changes not visible
		
		
		ResultSet rs=st.executeQuery("select * from account");
		rs.afterLast();//moves the cursor after last record
		System.out.println("==================");
		while(rs.previous()) {
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
