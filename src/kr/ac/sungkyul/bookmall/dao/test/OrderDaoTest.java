package kr.ac.sungkyul.bookmall.dao.test;

import java.util.List;

import kr.ac.sungkyul.bookmall.dao.OrderDao;
import kr.ac.sungkyul.bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
//		testOrderDaoInsert();
//		testOrderDaoGetList();
	}
	
	public static void testOrderDaoGetList(){
		OrderDao dao = new OrderDao();
		List<OrderVo> list =dao.getList();
		
		for( OrderVo vo : list ) {
			System.out.println( vo );
		}
	}
	
	public static void testOrderDaoInsert(){
		OrderVo vo = new OrderVo();
		OrderDao dao = new OrderDao();
		
		vo.setNo(1l);
		vo.setPrice("54800");
		vo.setAddress("beckyi@naver.com");
		vo.setCustomer_no(1l);
		dao.insert(vo);
	}

}
