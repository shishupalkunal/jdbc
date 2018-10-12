package durga;

import java.sql.*;

public class Lab2 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","803213");
			String sql="select * from students";
			st=con.createStatement();
			rs=st.executeQuery(sql);
		    while(rs.next()) {
	                 String sid=rs.getString(1);
	                 String sn=rs.getString(2);
	                 String em=rs.getString(3);
	                 long ph=rs.getLong(4);
	                 String ci=rs.getString(5);
				System.out.println(sid+"\t"+sn+"\t"+em+"\t"+ph+"\t"+ci);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(st!=null)
					st.close();
				if(con!=null)
					con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
			}

		}


	
