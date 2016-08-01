package kr.ac.sungkyul.bookmall.dao.test;

import java.util.List;

import kr.ac.sungkyul.bookmall.dao.AuthorDao;
import kr.ac.sungkyul.bookmall.dao.BookDao;
import kr.ac.sungkyul.bookmall.vo.AuthorVo;
import kr.ac.sungkyul.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
//		testBookDaoInsert();
		testBookDaoGetList();
//		testBookDaoUpdate();
//		testBookDaoDeleteAll();
//		testBookDaoGetList();
	}
	
	public static void testBookDaoInsert(){
		
		BookVo vo = new BookVo();
//		vo.setTitle("플라톤");
//		vo.setRate(4);
//		vo.setAuthor_no(4l);
		BookDao dao = new BookDao();
//		dao.insert(vo);
		
		vo.setTitle("어린왕자");
		vo.setPrice(9800);
		vo.setAuthor_no(1l);	//생텍쥐페리
		vo.setCategory_no(2l);
		dao.insert(vo);
		
		vo.setTitle("JAVA 정석");
		vo.setPrice(27000);
		vo.setAuthor_no(2l);	//남궁성
		vo.setCategory_no(4l);
		dao.insert(vo);
		
		vo.setTitle("시민의 교양");
		vo.setPrice(15000);
		vo.setAuthor_no(3l);	//채사장
		vo.setCategory_no(1l);
		dao.insert(vo);
		
		vo.setTitle("인연");
		vo.setPrice(9000);
		vo.setAuthor_no(4l);	//피천득
		vo.setCategory_no(3l);
		dao.insert(vo);
		
		vo.setTitle("지적대화");
		vo.setPrice(16000);
		vo.setAuthor_no(3l);	//채사장
		vo.setCategory_no(1l);
		dao.insert(vo);
		
	}
	
	public static void testBookDaoGetList(){
		BookDao dao = new BookDao();
		List<BookVo> list = dao.getList();
		
		for( BookVo vo : list ) {
			System.out.println( vo );
		}
	}
	
//	public static void testBookDaoDelete(){
//		BookDao dao = new BookDao();
//		int count = dao.delete(1L);
//		System.out.println("삭제된 row 수: "+count);
//	}
//	
//	public static void testBookDaoDeleteAll(){
//		BookDao dao = new BookDao();
//		int count = dao.delete();
//		System.out.println("전체 삭제된 row 수: "+count);
//	}
//	
//	public static void testBookDaoUpdate(){
//		BookDao dao = new BookDao();
//		BookVo bvo = new BookVo();
//		
//		bvo.setNo(6L);
//		bvo.setTitle("뽀로리");
//		bvo.setRate(4);
//		bvo.setAuthor_no(1l);
//		
//		dao.update(bvo);
//	}

}
