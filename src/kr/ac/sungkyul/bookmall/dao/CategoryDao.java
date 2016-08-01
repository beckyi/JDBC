package kr.ac.sungkyul.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.sungkyul.bookmall.vo.CategoryVo;

public class CategoryDao {
	
	public List<CategoryVo> getList() {
		List<CategoryVo> list = new ArrayList<CategoryVo>();
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
			String sql = "select no," + " category" + " from category order by no";

			rs = stmt.executeQuery(sql);

			// 5.결과처리
			while (rs.next()) {
				Long no = rs.getLong(1);
				String category = rs.getString(2);

				CategoryVo vo = new CategoryVo();
				vo.setNo(no);
				vo.setCategory(category);

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
	
	public int insert(CategoryVo vo) {
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
			String sql = "insert into category values(seq_category.nextval, ?)";	//자동으로 다음 번호에 저장
			pstmt = conn.prepareStatement(sql);

			// 4.바인딩
			pstmt.setString(1, vo.getCategory());

			// 5.query 실행
			count = pstmt.executeUpdate();

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
}
