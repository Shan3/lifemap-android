package model;

public class Member {
	public int member_id;
	public String member_name;
	public String imagePath;
	
	public Member(int member_id,String member_name,String imagePath){
		this.member_id = member_id;
		this.member_name = member_name;
		this.imagePath = imagePath;
	}
	
}
