package cls;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.memberDao;
import dto.memberDto;

public class memberClass {

	Scanner sc = new Scanner(System.in);
	
	public void insertEmployee() {
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("부서 : ");
		String jobid = sc.next();
		
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		System.out.print("고용일 : ");
		String hiredate = sc.next();
		
		memberDao dao = memberDao.getInstance();
		boolean b = dao.insertMember(new memberDto(name, jobid, phone, hiredate));
		if(b) {
			System.out.println("정상적으로 추가 되었습니다");
			return;
		}
		
		System.out.println("추가되지 않았습니다");
	}
	
	public void deleteMember() {
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		memberDao dao = memberDao.getInstance();
		boolean b = dao.deleteMember(name);
		if(b) {
			System.out.println("정상적으로 삭제 되었습니다");
			return;
		}
		
		System.out.println("삭제에 실패");
	}
	
	public void updateMember() {
		
		System.out.print("변경할 사람의 이름을 작성하시오.");
		String name = sc.next();
		
		System.out.print("변경할 전화번호를 작성하시오.");
		String phone = sc.next();
		
		memberDao dao = memberDao.getInstance();
		boolean b = dao.updateMember(new memberDto(name, null, phone, null));
		if(b) {
			System.out.println("정상적으로 수정 되었습니다");
			return;
		}
		
		System.out.println("삭제에 실패");
	}
	
	public List<memberDto> selectAll(){
		
		memberDao dao = memberDao.getInstance();
		List<memberDto> list = dao.selectAll();
		
		return list;
		
	}
	
	public memberDto selectOne(){
		
		System.out.print("검색할 사람의 이름을 작성하시오.");
		String name = sc.next();
		
		memberDao dao = memberDao.getInstance();
		memberDto dto = dao.selectOne(name);
		
		return dto;
		
	}
	
}
