package main;

import java.util.Scanner;

import cls.memberClass;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
	
		boolean run = true;

		Scanner sc = new Scanner(System.in);
		
		memberClass mcls = new memberClass();
		
		while(true) {
			System.out.println("메뉴를 골라보세요.");
			System.out.println("1. 사원 추가");
			System.out.println("2. 사원 삭제");
			System.out.println("3. 사원 수정");
			System.out.println("4. 사원 전체 검색");
			System.out.println("5. 사원 검색");
			System.out.println("6. 종료");
			
			int number = sc.nextInt();
			
			switch (number) {
			case 1: mcls.insertEmployee();
					break;
			case 2: mcls.deleteMember();
					break;
			case 3: mcls.updateMember();
					break;
			case 4: mcls.selectAll();
					break;
			case 5: mcls.selectOne();
					break;
			case 6: run=false;
					break;
			
			}
			
		}
		
	}

}
