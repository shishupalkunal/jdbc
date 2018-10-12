package durga;

import java.sql.*;
import durga.jdbcutil;
public class Lab3 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try {
			con=jdbcutil.getMySQLConnection();
			String sql="insert into students values(98,'deepak','deepak@jlc',98765,'dhn')";
			st=con.createStatement();
			int x=st.executeUpdate(sql);
			if(x==1) {
				System.out.println("Record inserted");
			}else {
				System.out.println("Record not inserted");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			jdbcutil.cleanup(st, con);
		}
			}

		}

