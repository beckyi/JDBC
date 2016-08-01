package kr.ac.sungkyul.bookmall.dao.test;

import java.util.List;

import kr.ac.sungkyul.bookmall.dao.CategoryDao;
import kr.ac.sungkyul.bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
//		testCategoryDaoInsert();
		testCategoryDaoGetList();
	}
	
	public static void testCategoryDaoGetList(){
		CategoryDao dao = new CategoryDao();
		List<CategoryVo> list =dao.getList();
		
		for( CategoryVo vo : list ) {
			System.out.println( vo );
		}
	}
	
	public static void testCategoryDaoInsert(){
		CategoryVo vo = new CategoryVo();
		CategoryDao dao = new CategoryDao();

		vo.setCategory("인문");
		dao.insert(vo);
		
		vo.setCategory("소설");
		dao.insert(vo);
		
		vo.setCategory("수필");
		dao.insert(vo);
		
		vo.setCategory("컴퓨터/IT");
		dao.insert(vo);
	}

}
