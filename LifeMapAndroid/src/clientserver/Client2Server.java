package clientserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import lifemap.act.MeActivity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Client2Server{
	
	Thread gameThread = null;
	ProgressDialog dialog = null;
	TextView txtName = null;
	View view = null;
	
	MeActivity act ;
	
	public String getStringFromUrl(){
//
//		this.act = act;		
//		
//		this.dialog = dialog;
//		this.txtName = txtName;
//		this.view = view;
//		gameThread = new Thread() {
//			public void run() {
			return 	threadMain();
//			}
//		};
//		gameThread.start();
		
		
//			
//			Handler handler;
//	
//
//			    Thread t =new Thread(){
//			    public void run() {
//			        handler.post(new Runnable() {
//			            public void run() {
//			                pc.setText("test");
//			            }
//			        });
//			    }};
//			    t.start();
		
		
		
		
	}
	
	
	private String threadMain(){
		String strResult = "";
		HashMap< String, String> params = new HashMap<String, String>();
		params.put("id", "0");
		JSONArray jArray = getJSONArray("http://phuct9.byethost22.com/helloMySQL.php", params);
		if (jArray!=null){
			try {
				for (int i = 0; i < jArray.length(); i++) {
					JSONObject json_data = jArray.getJSONObject(i);
					strResult+="id = " + json_data.getInt("ID") + ", name = "+ json_data.getString("Name") + ", url = "+ json_data.getString("Url");
				}
			} catch (JSONException e) {
				Log.e("log_tag", "Error parsing data " + e.toString());
			}
		}
//		txtName.setText(strResult);
//		dialog.dismiss();
//		view.invalidate();
		
//		act.setTextResult(strResult);
		Log.v("MyDebug","ket thuc");
		
		return strResult;
		
	}
	

	
	/**
	 * nhan vao mot url va tra ve json array
	 * @param url : vd "http://phuct9.byethost22.com/helloMySQL.php"
	 * @param params : tham so chuyen di vd name="Tran Van A" , age=20
	 * @return JSONArray
	 */
	private JSONArray getJSONArray(String url,Map params){
		InputStream is = null;
		String result = "";
		// the params to send
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	 	Iterator it = params.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        nameValuePairs.add(new BasicNameValuePair( String.valueOf(pairs.getKey()), String.valueOf(pairs.getValue())));
	    }
	    //send request
	    try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(url);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();
		} catch (Exception e) {
			Log.e("log_tag", "Error in http connection " + e.toString());
		}	
			
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
//			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result = sb.toString();
		} catch (Exception e) {
			Log.e("log_tag", "Error converting result " + e.toString());
		}
		JSONArray jArray = null;
		try {
			jArray = new JSONArray(result);
		} catch (JSONException e) {
			Log.e("log_tag", "Error parsing data " + e.toString());
		}
		return jArray;
	}

	
}
