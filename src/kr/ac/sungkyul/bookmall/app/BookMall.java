package kr.ac.sungkyul.bookmall.app;

import java.util.List;
import java.util.Scanner;

import kr.ac.sungkyul.bookmall.dao.AuthorDao;
import kr.ac.sungkyul.bookmall.dao.BookDao;
import kr.ac.sungkyul.bookmall.vo.AuthorVo;
import kr.ac.sungkyul.bookmall.vo.BookVo;

public class BookMall {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.print("대여 하고 싶은 책의 번호를 입력하세요:");
		int num = key.nextInt();
		
		updateStatus(num,1);
		
		System.out.println("*****도서 정보 출력하기******");
		displayBookInfo();
	}
	
	public static void displayBookInfo(){
		BookDao dao = new BookDao();
		List<BookVo> list =dao.getBList();
		
		for( BookVo vo : list ) {
			String state = null;
			if(vo.getStatus()==1){
				state = "대여중";
			}else{
				state = "재고있음";
			}
			System.out.println("책제목: "+vo.getTitle()+" 저자: "+vo.getAuthorName()+"	대여유무:"+state);
			
		}
	}
	
	public static void updateStatus(int num,int status){
		BookDao dao = new BookDao();
//		BookVo vo = new BookVo();
//		
//		vo.setNo((long)num);
//		vo.setStatus(staus);
		
		dao.StatusUpdate((long)num,status);
	}

}
