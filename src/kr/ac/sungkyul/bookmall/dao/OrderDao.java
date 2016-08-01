package kr.ac.sungkyul.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.sungkyul.bookmall.vo.OrderVo;

public class OrderDao {
	public List<OrderVo> getList() {
		List<OrderVo> list = new ArrayList<OrderVo>();
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
			String sql = "select a.no, b.name, b.email, a.price, a.address from list a,customer b where a.customer_no = b.no order by a.no";

			rs = stmt.executeQuery(sql);

			// 5.결과처리
			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String email = rs.getString(2);
				String price = rs.getString(3);
				String address = rs.getString(4);

				OrderVo vo = new OrderVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setEmail(email);
				vo.setPrice(price);
				vo.setAddress(address);

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
	
	public int insert(OrderVo vo) {
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
			String sql = "insert into customer values(seq_list.nextval, ?, ?, ?)";	//자동으로 다음 번호에 저장
			pstmt = conn.prepareStatement(sql);

			// 4.바인딩
			pstmt.setString(1, vo.getPrice());
			pstmt.setString(2, vo.getAddress());
			pstmt.setLong(3, vo.getCustomer_no());

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
