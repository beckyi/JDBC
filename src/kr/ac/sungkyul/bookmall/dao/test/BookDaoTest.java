package kr.ac.sungkyul.bookmall.dao.test;

import java.util.List;

import kr.ac.sungkyul.bookmall.dao.AuthorDao;
import kr.ac.sungkyul.bookmall.dao.BookDao;
import kr.ac.sungkyul.bookmall.vo.AuthorVo;
import kr.ac.sungkyul.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		testBookDaoInsert();
		testBookDaoGetList();
//		testBookDaoUpdate();
//		testBookDaoDeleteAll();
//		testBookDaoGetList();
	}
	
	public static void testBookDaoInsert(){
		BookVo bvo = new BookVo();
//		vo.setTitle("플라톤");
//		vo.setRate(4);
//		vo.setAuthor_no(4l);
		BookDao dao = new BookDao();
//		dao.insert(vo);

		bvo.setTitle("트와일라잇");
		bvo.setRate(1);
		bvo.setStatus(0);	//재고있음-0 / 대여중-1
		bvo.setAuthor_no(1l);
		dao.insert(bvo);
		
		bvo.setTitle("뉴문");
		bvo.setRate(1);
		bvo.setStatus(0);	//재고있음-0 / 대여중-1
		bvo.setAuthor_no(1l);
		dao.insert(bvo);
		
		bvo.setTitle("이클립스");
		bvo.setRate(1);
		bvo.setStatus(0);	//재고있음-0 / 대여중-1
		bvo.setAuthor_no(1l);
		dao.insert(bvo);
		
		bvo.setTitle("브레이킹던");
		bvo.setRate(1);
		bvo.setStatus(0);	//재고있음-0 / 대여중-1
		bvo.setAuthor_no(1l);
		dao.insert(bvo);
		
		bvo.setTitle("아리랑");
		bvo.setRate(1);
		bvo.setStatus(0);	//재고있음-0 / 대여중-1
		bvo.setAuthor_no(2l);
		dao.insert(bvo);
		
		bvo.setTitle("젊은그들");
		bvo.setRate(1);
		bvo.setStatus(0);	//재고있음-0 / 대여중-1
		bvo.setAuthor_no(3l);
		dao.insert(bvo);
		
		bvo.setTitle("아프니까 청춘이다");
		bvo.setRate(1);
		bvo.setStatus(0);	//재고있음-0 / 대여중-1
		bvo.setAuthor_no(4l);
		dao.insert(bvo);
		
		bvo.setTitle("귀천");
		bvo.setRate(1);
		bvo.setStatus(0);	//재고있음-0 / 대여중-1
		bvo.setAuthor_no(6l);
		dao.insert(bvo);
		
		bvo.setTitle("태백산맥");
		bvo.setRate(1);
		bvo.setStatus(0);	//재고있음-0 / 대여중-1
		bvo.setAuthor_no(2l);
		dao.insert(bvo);
		
		bvo.setTitle("풀하우스");
		bvo.setRate(1);
		bvo.setStatus(0);	//재고있음-0 / 대여중-1
		bvo.setAuthor_no(5l);
		dao.insert(bvo);
	}
	
	public static void testBookDaoGetList(){
		BookDao dao = new BookDao();
		List<BookVo> list = dao.getList();
		
		for( BookVo bvo : list ) {
			System.out.println( bvo );
		}
	}
	
	public static void testBookDaoDelete(){
		BookDao dao = new BookDao();
		int count = dao.delete(1L);
		System.out.println("삭제된 row 수: "+count);
	}
	
	public static void testBookDaoDeleteAll(){
		BookDao dao = new BookDao();
		int count = dao.delete();
		System.out.println("전체 삭제된 row 수: "+count);
	}
	
	public static void testBookDaoUpdate(){
		BookDao dao = new BookDao();
		BookVo bvo = new BookVo();
		
		bvo.setNo(6L);
		bvo.setTitle("뽀로리");
		bvo.setRate(4);
		bvo.setAuthor_no(1l);
		
		dao.update(bvo);
	}

}
