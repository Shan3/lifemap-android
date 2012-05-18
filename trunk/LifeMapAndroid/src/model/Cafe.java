package model;

public class Cafe {
	public int id;
	public String title;
	public String address;
	public float distance;//m
	public String file_img;
	
	public Cafe(int id,String title,String address,float distance,String file_img){
		this.id = id;
		this.title = title;
		this.address = address;
		this.distance = distance;
		this.file_img = file_img;
	}
}
