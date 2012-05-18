package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import utilities.MD5;



import clientserver.Client2Server;

public class MemberTable {
	public Member getMember(String username,String password){
		username = "thuc.lehuy@gmail.com";
		password = "12345678";
		password = MD5.md5(password);
		Client2Server clnt2Srv = new Client2Server();
		String url = "http://lifemap.vn/web/api.php/member/checkLogin";
		HashMap< String, String> params = new HashMap<String, String>();
		params.put("pc_email", username);
		params.put("password", "3d217ef7dcca205e4bc1a08281d669d2");
		return getMember(clnt2Srv.getJSONArray(url, params));
	}
	/**
	 * tra ve member theo id
	 * @param member_id
	 * @return
	 */
	public Member getMember(int member_id){
		Client2Server clnt2Srv = new Client2Server();
		String url = "http://lifemap.vn/web/api.php/member/getStatistic";
		HashMap< String, String> params = new HashMap<String, String>();
		params.put("member_id", String.valueOf(member_id));
		return getMember(clnt2Srv.getJSONArray(url, params));
	}
	
	private Member getMember(JSONArray jArray){
		Member mem = null;
		if (jArray!=null){
			try {
				JSONObject json_data = jArray.getJSONObject(0);
				mem = new Member(json_data.getInt("member_id"),json_data.getString("member_name"),json_data.getString("imagePath"));
			} catch (JSONException e) {
				Log.e("log_tag", "Error parsing data " + e.toString());
			}
		}
		return mem;
	}

	/**
	 * tra ve danh sach ban be cuar member co id = member_id
	 * @param member_id
	 * @return
	 */
	public List<Member> getFriends(int member_id){
		Client2Server clnt2Srv = new Client2Server();
		String url = "http://lifemap.vn/web/api.php/member/getFriends";
		HashMap< String, String> params = new HashMap<String, String>();
		params.put("member_id", String.valueOf(member_id));
		return getMembers(clnt2Srv.getJSONArray(url, params));
		
	}
	
	
	private List<Member> getMembers(JSONArray jArray){
		List<Member> members = new ArrayList<Member>();
		if (jArray!=null){
			
			try {
				if (jArray.getJSONObject(0).getBoolean("status")){
					jArray = jArray.getJSONObject(0).getJSONArray("friendList");
					for (int i = 0; i < jArray.length(); i++) {
						JSONObject json_data = jArray.getJSONObject(i);
						Member mem = new Member(json_data.getInt("id"),json_data.getString("name"),json_data.getString("image"));
						members.add(mem);
					}
				}
			} catch (JSONException e) {
				Log.e("log_tag", "Error parsing data " + e.toString());
			}
		}
		return members;
	}
	


}
