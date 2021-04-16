package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.memberDto;

public class memberDao {

	private static memberDao dao = null;
	
	private memberDao() {
		DBConnection.initConnection();
	}
	
	public static memberDao getInstance() {
		if(dao == null) {
			dao = new memberDao();
		}
		return dao;
		
	}
	
	public boolean insertMember(memberDto dto) {
		
		String sql = " INSERT INTO EMPOLYEE(EMPID, NAME, JOBID, PHONE, HIREDATE) "
					+" VALUES(EMP_SEQ.NEXTVAL, ?, ?, ? ,?) ";
		
		Connection conn = DBConnection.getConnection();	
		PreparedStatement psmt = null;
		
		int count  = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getJobid());
			psmt.setString(3, dto.getPhone());
			psmt.setString(4, dto.getHiredate());
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			DBClose.close(conn, psmt, null);			
		}
		return count>0?true:false;
		
	}
	
	public boolean deleteMember(String name) {
			
			String sql = " DELETE FROM EMPOLYEE "
						+" WHERE NAME = "+name;
			
			Connection conn = DBConnection.getConnection();	
			PreparedStatement psmt = null;
			
			int count  = 0;
			
			try {
				psmt = conn.prepareStatement(sql);
				count = psmt.executeUpdate();
				
			} catch (SQLException e) {			
				e.printStackTrace();
			}finally {
				DBClose.close(conn, psmt, null);			
			}
			return count>0?true:false;
			
		}
	
	public boolean updateMember(memberDto dto) {
		
		String sql = " UPDATE EMPOLYEE "
					+" SET PHONE = ? "
					+" WHERE NAME = ? ";
		
		Connection conn = DBConnection.getConnection();	
		PreparedStatement psmt = null;
		
		int count  = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getPhone());
			psmt.setString(2, dto.getName());
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			DBClose.close(conn, psmt, null);			
		}
		return count>0?true:false;
	}
	
	public List<memberDto> selectAll(){
		
		String sql = " SELECT EMPID, NAME, JOBID, PHONE, HIREDATE "
					+ " FROM EMPLYEE ";
		
		Connection conn = DBConnection.getConnection();	
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<memberDto> list = new ArrayList<memberDto>();
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				memberDto dto = new memberDto(
												rs.getInt(1),
												rs.getString(2),
												rs.getString(3),
												rs.getString(4),
												rs.getString(5));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(conn, psmt, rs);			
		}
		return list;
		
	}
	
public memberDto selectOne(String name){
		
		String sql = " SELECT EMPID, NAME, JOBID, PHONE, HIREDATE "
					+ " FROM EMPLYEE "
					+ " WHERE NAME = " + name;
		
		Connection conn = DBConnection.getConnection();	
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		memberDto dto = null;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			
			if(rs.next()) {
				dto = new memberDto(
									rs.getInt(1),
									rs.getString(2),
									rs.getString(3),
									rs.getString(4),
									rs.getString(5));
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(conn, psmt, rs);			
		}
		return dto;
		
	}

	
	
}
