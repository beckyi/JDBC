package kr.ac.sungkyul.hr.app;

import java.util.List;
import java.util.Scanner;

import kr.ac.sungkyul.hr.dao.EmployeeDao;
import kr.ac.sungkyul.hr.vo.EmployeeVo;

public class HRApp {

	public static void main(String[] args) {
//		searchByName();
		searchBySalary();
	}

	
	
	private static void searchBySalary() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("임금 (최저  최고)>> ");
		
		int minSalary = scanner.nextInt();
		int maxSalary = scanner.nextInt();
		
		//코드작성
		EmployeeDao dao = new EmployeeDao();
		List<EmployeeVo> list = dao.getList(minSalary,maxSalary);
		System.out.println("["+minSalary + ":" + maxSalary +"] 결과가 "+ list.size()+"개 출력됩니다.");
		System.out.println("============================================================");
		
		for(EmployeeVo vo : list){
			System.out.println(vo.getFirstName()+" "+vo.getLastName()+"		"+vo.getSalary());
		}
		scanner.close();
		
	}

	private static void searchByName() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름 입력>> ");
		String name = scanner.nextLine();
		
		EmployeeDao dao = new EmployeeDao();
		List<EmployeeVo> list = dao.getList(name);
		
		System.out.println("============================================================");
		System.out.println(list.size());
		for(EmployeeVo vo : list){
			System.out.println(vo);
		}
		scanner.close();
		
	}

}
