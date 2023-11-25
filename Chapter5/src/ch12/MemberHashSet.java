package ch12;

import java.util.HashSet;

public class MemberHashSet {
	
	private HashSet<Member> hashSet;
	
	public MemberHashSet() {
		hashSet = new HashSet<>();
	}
	
	
	public void addMember(Member member) {
		hashSet.add(member);
	}
	
	public boolean removeMember(int memberId) {
		
//		for(int i=0; i<hashSet.size(); i++) {
//			Member member = hashSet.get(i);
//			
//			int tempId = member.getMemberId();
//			if(tempId == memberId) {
//				hashSet.remove(i);
//				return true;
//			}
//		}
		
		System.out.println(memberId +"가 존재하지 않습니다.");
		return false;
	}
	
	public void showAllMember() {
		for(Member member : hashSet) {
			System.out.println(member);
		}
		System.out.println();
	}
}


