package com.magic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.magic.dto.EmployeesVO;
public class EmployeesDAO {

	private EmployeesDAO() {
		
	}
	private static EmployeesDAO instance = new EmployeesDAO();
	
	public static EmployeesDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		Connection conn = ds.getConnection();
		return conn;
	}
	public int userCheck(String id, String pwd, String lev) {
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from employee where id =?";
		try {	
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("pass").equals(pwd) && rs.getString("lev").equals(lev)) {
					result = 1;
				} else {
					result = 0;
				}
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
		
		return result;
	}
	
	
	public EmployeesVO getEmployee(String id) {
		EmployeesVO emVo = new EmployeesVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from employee where id =?";
		try {	
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				emVo.setId(id);
				emVo.setName(rs.getString("name"));
				emVo.setEnter(rs.getString("enter"));
				emVo.setGender(rs.getString("gender"));
				emVo.setLev(rs.getString("lev"));
				emVo.setPhone(rs.getString("phone"));
				emVo.setPass(rs.getString("pass"));
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
		return emVo;
	}
	public EmployeesVO updatePage(String id, String pwd, String name, String lev, String gender, String phone) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update employee set pass = ?, name = ?, lev = ?, gender = ?, phone = ? where id = ?";
		int result = -1;
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pwd);
			pstmt.setString(2, name);
			pstmt.setString(3, lev);
			pstmt.setString(4, gender);
			pstmt.setString(5, phone);
			pstmt.setString(6, id);
			result = pstmt.executeUpdate();


		} catch (Exception e) {
			e.getMessage();
		}  finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
		
		return getEmployee(id);
	}
	
	public EmployeesVO custom(String id, String pwd, String name, String lev, String gender, String phone) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into employee (id,pass,name,lev,gender,phone) "
				+ "values(?,?,?,?,?,?)";
		ResultSet rs = null;
		EmployeesVO emVo = null;

		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, lev);
			pstmt.setString(5, gender);
			pstmt.setString(6, phone);
			if (pstmt.executeUpdate() == 1) {
				emVo = getEmployee(id);
			} else {
				emVo = null;
			}
		

	
			
		} catch (Exception e) {
			e.getMessage();
		}  finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
		
		return emVo;
	}
}
