package durga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class Account{
	int bal;
	int dabal,sabal,danbal,sanbal;
	public void transfer(int sa,int da,int amt) {
		Connection con=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		try {
			con=jdbcutil.getMySQLConnection();
			con.setAutoCommit(false);
			ps1=con.prepareStatement("select bal from Account10 where accno=?");
			ps1.setInt(1,da);
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next())
				dabal=rs1.getInt(1);
			else
		      throw new InvalidAccountNumberException(da);
			danbal=dabal+amt;
			ps2=con.prepareStatement("update Account10 set bal=? where accno=?");
			ps2.setInt(1,danbal);
			ps2.setInt(2,da);
			ps2.executeUpdate();
			System.out.println("***"+da+"Updated");
			ps1.setInt(1,sa);
			rs1=ps1.executeQuery();
			if(rs1.next()) {
				sabal=rs1.getInt(1);
			}else {
				throw new InvalidAccountNumberException(sa);
			}
			if(sabal>=amt) {
				sanbal=sabal-amt;
			}else {
				throw new InsufficientFundexception();
			}
			ps2.setInt(1,sanbal);
			ps2.setInt(2, sa);
			ps2.executeUpdate();
			con.commit();
			System.out.println("****"+sa+"Updated");
			System.out.println("****fund transfer***");
		}catch(Exception e) {
			System.out.println(e);
			try {
				con.rollback();
			}catch(Exception e1) {}
		}finally {
			jdbcutil.cleanup(ps1, con);
			jdbcutil.cleanup(ps2, con);
		}
	}
}
