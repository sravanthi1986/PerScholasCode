package com.perscholas.software_developer_club.servlets;

import java.util.HashMap;
import java.util.Map;

import com.perscholas.software_developer_club.models.Member;

public class MainApp {
	public static void main(String[] args) {
//		List<Member> allMembers = new ArrayList<>();
		Map<Integer, Member> allMembers = new HashMap<>();

		Member m1 = new Member();
		m1.setMemberId(1);
		m1.setName("member1");
//		allMembers.add(m1);
		allMembers.put(m1.getMemberId(), m1);
		
		
		Member m2 = new Member();
		m2.setMemberId(2);
		m2.setName("member2");
//		allMembers.add(m2);
		allMembers.put(m2.getMemberId(), m2);
//		Member m3 = new Member();
//		m3.setMemberId(3);
//		m3.setName("member3");
//		allMembers.add(m3);
		
//		List<Integer> memberIds = new ArrayList<>();
//		for (Member m : allMembers) {
//			memberIds.add(m.getMemberId());
//		}
		
//		System.out.println(memberIds.contains(2));
		
		System.out.println(allMembers.containsKey(3));
	}
}
