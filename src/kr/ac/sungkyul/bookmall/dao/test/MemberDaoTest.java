package kr.ac.sungkyul.bookmall.dao.test;

import java.util.List;

import kr.ac.sungkyul.bookmall.dao.MemberDao;
import kr.ac.sungkyul.bookmall.vo.CustomerVo;


public class MemberDaoTest {
	
	public static void main(String[] args) {
//		testAuthorDaoInsert();
		testMemeberDaoGetList();
	}
	
	public static void testMemeberDaoGetList(){
		MemberDao dao = new MemberDao();
		List<CustomerVo> list =dao.getList();
		
		for( CustomerVo vo : list ) {
			System.out.println( vo );
		}
	}
	
	public static void testAuthorDaoInsert(){
		CustomerVo vo = new CustomerVo();
		MemberDao dao = new MemberDao();
		
		vo.setName("최재은");
		vo.setPhone("01012345678");
		vo.setEmail("beckyi@naver.com");
		vo.setPass("je1234");
		
		dao.insert(vo);
	}
}
