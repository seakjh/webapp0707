package model.company;

import java.sql.Connection;
import java.sql.SQLException;

import commons.db.PoolManager;

/*
 * 모델 파트의 복잡한 업무 영역을 단순화 시키기 위해
 * 또 하나의 계층을 둠으로써, 트랜젝션 처리, CRUD이외의 업무등을 
 * 처리할 수 있다..
 */
public class MemberService {
	private PoolManager pool;
	private DeptDAO deptDAO;
	private EmpDAO empDAO;

	/*
	public void regist() {
		Connection con = pool.getConnection();
		try {
			con.setAutoCommit(false);
			
			int result = deptDAO.insert(con);
			int result2 = empDAO.insert(con);
			
			if(result==1 && result2==1) {
				con.commit();				
			}
			else {
				con.rollback();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		pool.freeConnection(con);
	}
	*/
	/*
	public void regist() {
		Connection con = pool.getConnection();
		try {
			con.setAutoCommit(false);
			
			int result = deptDAO.insert(con);
			int result2 = empDAO.insert(con);
			
			if (result != 1 && result2 != 1) {
				throw new SQLException(); //에러발생
			}
			
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		pool.freeConnection(con);
	}
	*/
	public void regist() {
		Connection con = pool.getConnection();
		try {
			con.setAutoCommit(false);
			
			deptDAO.insert(con);
			empDAO.insert(con);
			
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		pool.freeConnection(con);
	}
	
	public void setPool(PoolManager pool) {
		this.pool = pool;
	}
	
	public void setDeptDAO(DeptDAO deptDAO) {
		this.deptDAO = deptDAO;
	}
	
	public void setEmpDAO(EmpDAO empDAO) {
		this.empDAO = empDAO;
	}
	
}
