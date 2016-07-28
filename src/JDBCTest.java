import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.연결 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url,"hr","hr");
			//3. statement 샐성
			stmt = conn.createStatement();
			//4.SQL문 실행
			String sql= "select employee_id,"+"	first_name,"+"	last_name,"+"	salary"+"	from employees";
			
			//5.결과처리
			rs = stmt.executeQuery(sql);

			while(rs.next()){
				int employee_id =rs.getInt(1);
				String firstName =  rs.getString(2);
				String lastName =  rs.getString(3);
				int salary =rs.getInt(4);
				
				System.out.println(employee_id+": "+firstName+" "+lastName+": "+salary);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("드라이버 로딩 실패: "+e);
		} catch (SQLException e) {
			System.out.println("error: "+e);
		} finally {
			try{
				//6.자원정리
				if(rs != null){
					rs.close();
				}
				if(conn != null){
					conn.close();

				}
			}catch(SQLException e) {
				System.out.println("error: "+e);
			}
		}
	}
}
