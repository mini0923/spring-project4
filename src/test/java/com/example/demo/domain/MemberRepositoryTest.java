package com.example.demo.domain;

import java.util.List;

import org.junit.jupiter.api.Test;

public class MemberRepositoryTest {

	MemberRepository repository = new MemberRepository();
	
	@Test
	public void 테스트() {
		
		// 1. 회원 등록(2명)
			Member member1 = new Member(0, "user1", "1234");
			repository.save(member1);
			
			Member member2 = new Member(0, "user1", "1234");														
			repository.save(member2);
			
		// 2. 회원 목록 조회
			List<Member> findList = repository.findAll();
			System.out.println("회원 목록 : ");
			for (Member member : findList) {
				System.out.println(member); 				
			}
			
			
		// 3. 1번째 회원 조회
			System.out.println("1번째 회원 : " + repository.findById(1));		
			
		// 4. 모든 회원 삭제
			repository.clearStore();
			System.out.println("삭제 후 회원 목록 : " );
			List<Member> clearList = repository.findAll();
			for (Member member  : clearList) {
				System.out.println(member);
			}
			
		
	}
	
}
