package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import clientserver.Client2Server;

public class CategoryTable {
	public List<Category> getAll(){
		Client2Server clnt2Srv = new Client2Server();
		String url = "http://lifemap.vn/web/api.php/pos/getListCategory";
		HashMap< String, String> params = new HashMap<String, String>();
		return getCategories(clnt2Srv.getJSONArray(url, params));
	}
	
	private List<Category> getCategories(JSONArray jArray){
		List<Category> categories = new ArrayList<Category>();
		if (jArray!=null){
			try {
				for (int i = 0; i < jArray.length(); i++) {
					JSONObject json_data = jArray.getJSONObject(i);
					Category cat = new Category(json_data.getInt("id"),json_data.getString("name"),json_data.getString("icon"));
					categories.add(cat);
				}
			} catch (JSONException e) {
				Log.e("log_tag", "Error parsing data " + e.toString());
			}
		}
		Log.v("MyDebug","category size = "+categories.size());
		return categories;
	}
}
