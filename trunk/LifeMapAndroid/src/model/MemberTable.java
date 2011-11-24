package model;

import java.util.HashMap;

import org.json.JSONArray;

import clientserver.Client2Server;

public class MemberTable {
	public static Member getMember(String username,String password){
		Client2Server clnt2Srv = new Client2Server();
		String url = "";
		HashMap< String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("passwrod", password);
		clnt2Srv.getJSONArray(url, params);
		return null;
	}
	
	private Member getMember(JSONArray jsonarray){
		
		return null;
	}
}
