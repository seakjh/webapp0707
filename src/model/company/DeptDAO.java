package model.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeptDAO {
	
	public void insert(Connection con) throws SQLException { //나 말고 나를 호출한 자가 예외처리하셈
		PreparedStatement pstmt = null;
		
		String sql = "insert into dept(deptno, dname, loc)";
		sql += " values(50, 'IT', '서울')";
		
		pstmt = con.prepareStatement(sql);
		pstmt.executeUpdate();

	}
	
}
