package kr.ac.sungkyul.bookmall.dao.test;

import java.util.List;

import kr.ac.sungkyul.bookmall.dao.CartDao;
import kr.ac.sungkyul.bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		testCartDaoInsert();
		testCartDaoGetList();
	}
	
	public static void testCartDaoGetList(){
		CartDao dao = new CartDao();
		List<CartVo> list =dao.getList();
		
		for( CartVo vo : list ) {
			System.out.println( vo );
		}
	}
	
	public static void testCartDaoInsert(){
		CartVo vo = new CartVo();
		CartDao dao = new CartDao();

		vo.setCustomer_no(1l);
		vo.setBook_no(1l);
		vo.setCount(2);		
		
		dao.insert(vo);
		
	}
}
