package model;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import utilities.MD5;

import android.util.Log;

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
	
	private Member getMember(JSONArray jArray){
		String strResult = "";
		if (jArray!=null){
			try {
				for (int i = 0; i < jArray.length(); i++) {
					JSONObject json_data = jArray.getJSONObject(i);
					//{"status":true,"member_id":"3","member_name":"thuc.lehuy","imagePath":"\/web\/cache\/img\/jpg\/w40_h40\/m_3_bc447b8dec15935861b74b4ad4d4e96652a2ae50_jpg_crop.jpg"}
					strResult+="member_id = " + json_data.getInt("member_id") + "\n"
					+ "member_name = " + json_data.getString("member_name") + "\n"
					+ "imagePath = " + json_data.getString("imagePath");
				}
			} catch (JSONException e) {
				Log.e("log_tag", "Error parsing data " + e.toString());
			}
		}
		Log.v("MyDebug",strResult);
		return null;
	}
}
