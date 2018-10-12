package durga;
import java.sql.*;
import durga.jdbcutil;
public class Lab4 {
public static void main(String[] args) {
Connection con=null;
Statement st=null;
ResultSet rs=null;
try {
	con=jdbcutil.getMySQLConnection();
	String qry="select * from students";
	st=con.createStatement();
	rs=st.executeQuery(qry);
	if(rs.next()) {
		do {
			 String sid=rs.getString(1);
             String sn=rs.getString(2);
             String em=rs.getString(3);
             long ph=rs.getLong(4);
             String ci=rs.getString(5);
		System.out.println(sid+"\t"+sn+"\t"+em+"\t"+ph+"\t"+ci);
		}while(rs.next());
	}else
		System.out.println("no Record found");
}catch(Exception e) {
	e.printStackTrace();
}
finally {
	jdbcutil.cleanup(st, con);
}
	}

}
