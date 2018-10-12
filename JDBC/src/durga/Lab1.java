package durga;

import java.sql.*;
import java.io.*;

public class Lab1 {

	public static void main(String[] args){
Connection con=null;
Statement st=null;
try {
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","803213");
	String sql="insert into students values(99,'Sri','sri@jlc',999,'patna')";
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
	try {
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
