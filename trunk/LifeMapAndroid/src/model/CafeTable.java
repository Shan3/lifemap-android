package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import clientserver.Client2Server;

public class CafeTable {
	
	/**
	 * tra ve all cafe 
	 */
	public List<Cafe> getCafes(){
		Client2Server clnt2Srv = new Client2Server();
		String url = "http://dev.lifemap.vn/web/api.php/pos/listPosByCategory";
		HashMap< String, String> params = new HashMap<String, String>();
		params.put("category_code", "pos_cafe");
		params.put("lat", "21.0094620");
		params.put("lng", "105.8377950");
		params.put("page", "1");
		params.put("size", "50");
		
		return getCafes(clnt2Srv.getJSONArray(url, params));
	}
	
	private List<Cafe> getCafes(JSONArray jArray){
		List<Cafe> cafes = new ArrayList<Cafe>();
		if (jArray!=null){
			try {
				
				if (jArray.getJSONObject(0).getBoolean("status")){
					jArray = jArray.getJSONObject(0).getJSONArray("list");
					for (int i = 0; i < jArray.length(); i++) {
						JSONObject json_data = jArray.getJSONObject(i);
						Cafe cafe = new Cafe(json_data.getInt("id"),json_data.getString("title"),json_data.getString("address"),(float)json_data.getLong("distance"),json_data.getString("file_img"));
						cafes.add(cafe);
					}
				}
				
				
			} catch (JSONException e) {
				Log.e("log_tag", "Error parsing data " + e.toString());
			}
		}
		return cafes;
	}
}
