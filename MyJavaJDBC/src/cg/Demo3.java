package cg;


import java.sql.*;

public class Demo3 {

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
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//used to pass sql queries
		//Result set will only be concur UPDATE, sensitive means changes  visible
		
		
		ResultSet rs=st.executeQuery("select aid,mobileno,accountholder,balance from account");//for update we have to specify columns
		rs.afterLast();//moves the cursor after last record
		System.out.println("==================");
		while(rs.previous()) {
			int a_id=rs.getInt("aid");
			if(a_id==101) {
				rs.updateString("accountholder", "Raja Sharma");//to update in resultset
				rs.updateDouble(4, 70000.0);
				rs.updateRow();//to update in database
			}
			long mobile=rs.getLong("mobileno");//either column name or column number 
			String ah=rs.getString(3);
			double bal=rs.getDouble(4);
			
			System.out.println("Account Id: "+a_id+" Mobile: "+mobile+" Name: "+ah+" Balance: "+bal);;
			System.out.println("==================");
			
		}
		con.close();
		
	}

}
