package kr.ac.sungkyul.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.sungkyul.bookmall.vo.CartVo;

public class CartDao {
	public List<CartVo> getList() {
		List<CartVo> list = new ArrayList<CartVo>();
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
			String sql = "select a.title, b.count, b.price from book a, cart b where a.no = b.book_no order by no";

			rs = stmt.executeQuery(sql);

			// 5.결과처리
			while (rs.next()) {
				String title = rs.getString(1);
				Integer count = rs.getInt(2);
				Integer price = rs.getInt(3);

				CartVo vo = new CartVo();
				vo.setTitle(title);
				vo.setCount(count);
				
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
	public int insert(CartVo vo) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.연결 얻어오기 (Connection 얻기)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "skudb", "skudb");
			
			String sql2 = "select price from book where no =?";
			pstmt.setLong(1, vo.getBook_no());
			rs = pstmt.executeQuery(sql2);
			
			rs.next();
			
			int sum = rs.getInt(1) * vo.getCount();
			
			
			// 3. PreparedStatement 준비 (? 인자값 전달 가능)
			String sql = "insert into cart values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4.바인딩
			pstmt.setLong(1, vo.getCustomer_no());
			pstmt.setLong(2, vo.getBook_no());
			pstmt.setInt(3, vo.getCount());
			pstmt.setInt(4, sum);

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
