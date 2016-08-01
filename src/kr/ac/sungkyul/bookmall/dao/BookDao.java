package kr.ac.sungkyul.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.sungkyul.bookmall.vo.BookVo;

public class BookDao {
	public int insert(BookVo vo) {
		
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.연결 얻어오기 (Connection 얻기)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "skudb", "skudb");

			// 3. PreparedStatement 준비 (? 인자값 전달 가능)
			String sql = "insert into book values(seq_book.nextval, ?, ?, ?, ?)";	//자동으로 다음 번호에 저장
			pstmt = conn.prepareStatement(sql);
			
			System.out.println("title:" + vo.getTitle());
			System.out.println("price:" + vo.getPrice());
			System.out.println("Ano:" + vo.getAuthor_no());
			System.out.println("Cno:" + vo.getCategory_no());
			
			// 4.바인딩
			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setLong(3, vo.getAuthor_no());
			pstmt.setLong(4, vo.getCategory_no());

			// 5.query 실행
			count = pstmt.executeUpdate();
			System.out.println(2);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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

	public List<BookVo> getList() {
		List<BookVo> list = new ArrayList<BookVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.연결 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "skudb", "skudb");

			// 3. statement 생성 (쿼리문을 전달)
			stmt = conn.createStatement();

			// 4. sql문 실행
			String sql = "select title," + " price" + " from book order by no";

			rs = stmt.executeQuery(sql);

			// 5.결과처리
			while (rs.next()) {
				String title = rs.getString(1);
				Integer price = rs.getInt(2);

				BookVo vo = new BookVo();
				vo.setTitle(title);
				vo.setPrice(price);
				
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
	
//	public int update(BookVo bvo){
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		int count = 0;
//		
//		try {
//			//1. 드라이버 로딩
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			
//			//2. Connection 얻어오기
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			conn = DriverManager.getConnection(url,"skudb","skudb");
//			
//			//3. SQL 준비
//			String sql = "update book set title=?, rate=?, author_no=? where no = ?";
//			pstmt = conn.prepareStatement(sql);
//			
//			//4. 바인딩
//			pstmt.setString(1,bvo.getTitle());
//			pstmt.setInt(2,bvo.getRate());
//			pstmt.setLong(3,bvo.getAuthor_no());
//			pstmt.setLong(4,bvo.getNo());
//			
//			//5. SQL 실행
//			count = pstmt.executeUpdate();
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return count;
//	}
//	
//	public int delete(){
//		Connection conn = null;
//		Statement stmt = null;
//		int count = 0;
//		
//		try {
//			//1. 드라이버 로딩
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			
//			//2. Connection 얻어오기
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			conn = DriverManager.getConnection(url,"skudb","skudb");
//			
//			//3. SQL 준비
//			String sql = "delete from book";
//			stmt = conn.createStatement();
//			
//			count = stmt.executeUpdate(sql);
//			
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버를 찾을 수 없습니다.: "+e);
//		} catch (SQLException e) {
//			System.out.println("SQL ERROR: "+e);
//		}finally{
//			try {
//				if(stmt != null){
//					stmt.close();
//				}
//				if(conn != null){
//					conn.close();
//				}
//			} catch (SQLException e) {
//				System.out.println("SQL ERROR: "+e);
//			}
//		}
//		return count;
//	}
//	
//	public int delete(Long no){
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		int count = 0;
//		
//		try {
//			//1. 드라이버 로딩
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			
//			//2. Connection 얻어오기
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			conn = DriverManager.getConnection(url,"skudb","skudb");
//			
//			//3. SQL 준비
//			String sql = "delete from book where no = ?";
//			pstmt = conn.prepareStatement(sql);
//			
//			//4. 바인딩
//			pstmt.setLong(1,no);
//			
//			//5. SQL 실행
//			count = pstmt.executeUpdate();
//			
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버를 찾을 수 없습니다.: "+e);
//		} catch (SQLException e) {
//			System.out.println("SQL ERROR: "+e);
//		}finally{
//			try {
//				if(pstmt != null){
//					pstmt.close();
//				}
//				if(conn != null){
//					conn.close();
//				}
//			} catch (SQLException e) {
//				System.out.println("SQL ERROR: "+e);
//			}
//		}
//		return count;
//	}
//	
//	public int StatusUpdate(long num, int status){
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int count = 0;
//		
//		try {
//			//1. 드라이버 로딩
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			
//			//2. Connection 얻어오기
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			conn = DriverManager.getConnection(url,"skudb","skudb");
//			
//			//3. SQL 준비
//			String sql = "update book set status=? where no = ?";
//			pstmt = conn.prepareStatement(sql);
//			
//			//4. 바인딩
//			pstmt.setInt(1, status);
//			pstmt.setLong(2, num);
//			
//			//5. SQL 실행
//			count = pstmt.executeUpdate();
//			
//			//결과 말 출력
//			String sql2 = "select title from book where no=?";
//			pstmt = conn.prepareStatement(sql2);
//			//4. 바인딩
//			pstmt.setLong(1, num);
//			
//			rs = pstmt.executeQuery();
//			rs.next();
//			
//			System.out.println(rs.getString(1) + "(가) 대여 됐습니다.");
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return count;
//	}
//	
//	public List<BookVo> getBList() {
//		List<BookVo> list = new ArrayList<BookVo>();
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//
//		try {
//			// 1.드라이버 로딩
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//
//			// 2.연결 얻어오기
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			conn = DriverManager.getConnection(url, "skudb", "skudb");
//
//			// 3. statement 생성 (쿼리문을 전달)
//			stmt = conn.createStatement();
//
//			// 4. sql문 실행
//			String sql = "select a.title, b.name, a.status FROM book a, author b where a.author_no = b.no ORDER BY a.no";
//
//			rs = stmt.executeQuery(sql);
//
//			// 5.결과처리
//			while (rs.next()) {
//				String title = rs.getString(1);
//				String authorname = rs.getString(2);
//				int status = rs.getInt(3);
//
//				BookVo bvo = new BookVo();
//				bvo.setTitle(title);
//				bvo.setAuthorName(authorname);
//				bvo.setStatus(status);
//
//				list.add(bvo);
//			}
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			// e.printStackTrace();
//			System.out.println("드라이버 로딩 실패: " + e);
//		} catch (SQLException e) {
//			System.out.println("error: " + e);
//		} finally {
//			try {
//				// 6.자원정리
//				if (rs != null) {
//					rs.close();
//				}
//				if (stmt != null) {
//					stmt.close();
//				}
//				if (conn != null) {
//					conn.close();
//
//				}
//			} catch (SQLException e) {
//				System.out.println("error: " + e);
//			}
//		}
//		return list;
//	}

}

