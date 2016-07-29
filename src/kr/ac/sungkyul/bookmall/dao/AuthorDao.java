package kr.ac.sungkyul.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.sungkyul.bookmall.vo.AuthorVo;

public class AuthorDao {
	
	public int update(AuthorVo vo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url,"skudb","skudb");
			
			//3. SQL 준비
			String sql = "update author set name=?, description=? where no = ?";
			pstmt = conn.prepareStatement(sql);
			
			//4. 바인딩
			pstmt.setString(1,vo.getName());
			pstmt.setString(2,vo.getDescription());
			pstmt.setLong(3,vo.getNo());
			
			//5. SQL 실행
			count = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public int delete(){
		Connection conn = null;
		Statement stmt = null;
		int count = 0;
		
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url,"skudb","skudb");
			
			//3. SQL 준비
			String sql = "delete from author";
			stmt = conn.createStatement();
			count = stmt.executeUpdate(sql);
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.: "+e);
		} catch (SQLException e) {
			System.out.println("SQL ERROR: "+e);
		}finally{
			try {
				if(stmt != null){
					stmt.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("SQL ERROR: "+e);
			}
		}
		return count;
	}
	
	public int delete(Long no){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url,"skudb","skudb");
			
			//3. SQL 준비
			String sql = "delete from author where no = ?";
			pstmt = conn.prepareStatement(sql);
			
			//4. 바인딩
			pstmt.setLong(1,no);
			
			//5. SQL 실행
			count = pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.: "+e);
		} catch (SQLException e) {
			System.out.println("SQL ERROR: "+e);
		}finally{
			try {
				if(pstmt != null){
					pstmt.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("SQL ERROR: "+e);
			}
		}
		return count;
	}
	
	public int insert(AuthorVo vo) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.연결 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "skudb", "skudb");

			// 3. Prestatement 준비
			// String sql= "insert into author values(seq_author.nextval,'"+vo.getName()+"', '"+vo.getDescription()+",)";
			String sql = "insert into author values(seq_author.nextval, ?, ?)";	//자동으로 다음 번호에 저장
			pstmt = conn.prepareStatement(sql);

			// 4.바인딩
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getDescription());

			// 5.query 실행
			count = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("드라이버 로딩 실패: " + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				// 6.자원정리
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();

				}
			} catch (SQLException e) {
				System.out.println("error: " + e);
			}
		}
		return count;
	}

	public List<AuthorVo> getList() {
		List<AuthorVo> list = new ArrayList<AuthorVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.연결 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "skudb", "skudb");

			// 3. statement 생성
			stmt = conn.createStatement();

			// 4. sql문 실행
			String sql = "select	no," + "	name," + "	description" + "	from author order by no";

			rs = stmt.executeQuery(sql);

			// 5.결과처리
			while (rs.next()) {
				long no = rs.getInt(1);
				String name = rs.getString(2);
				String description = rs.getString(3);

				AuthorVo vo = new AuthorVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setDescription(description);

				list.add(vo);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("드라이버 로딩 실패: " + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				// 6.자원정리
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();

				}
			} catch (SQLException e) {
				System.out.println("error: " + e);
			}
		}
		return list;
	}
}
