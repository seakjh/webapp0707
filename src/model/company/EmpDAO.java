package model.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EmpDAO {
	
	public void insert(Connection con) throws SQLException {
		PreparedStatement pstmt = null;
		
		String sql = "insert into emp(empno, name, sal, deptno)";
		sql += " values(8888, '애플', 700, 50)";
		
		pstmt = con.prepareStatement(sql);
		pstmt.executeUpdate();
	}
	
}
