package lifemap.act;

import model.Member;
import clientserver.Client2Server;
import database.DBAdapter;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class MeActivity extends Activity{
	
	public static final String PREFS_NAME = "MyPrefsFile";
	
	String strResult = "";
	Client2Server clnt2serv = new Client2Server();
	TextView lblName = null;
	
	
	DBAdapter dbAdp = null;
	
	
	public void setTextResult(String str){
		lblName.setText(str);
	}
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        dbAdp = new DBAdapter(this);
	        View vMain = View.inflate(this, R.layout.profile, null);
	        
	        setContentView(vMain);
	        
	         lblName = (TextView) findViewById(R.id.lblName);
	         
	         Member mem = ((LifeMapApplication)getApplicationContext()).getMember();
	         lblName.setText(mem.member_name);
	         
	         Button btnLogin = (Button)findViewById(R.id.btnLogout);
		        btnLogin.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						
//						Member mem = ((LifeMapApplication)getApplicationContext()).getMember();
						
						SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
						SharedPreferences.Editor editor = settings.edit();
						editor.putInt("member_id", -1);
						editor.putString("member_name", null);
						editor.commit();
						finish();
					}
		        });
	         
	        
	         
//	         Thread t = new Thread() {
//	        	    public void run() {
//	        	        runOnUiThread(new Runnable() {
//	        	            @Override
//	        	            public void run() {
//	        	            	lblName.setText("test");
//	        	            }
//	        	        });
//	        	    }
//	        	};
//	        	t.start();
	         
//	         ProgressDialog dialog = ProgressDialog.show(this, "Loading", "Please wait...", false);
//	         strResult = clnt2serv.getStringFromUrl();
//	         lblName.setText(strResult);
//	         dialog.dismiss();
//	        
	        
//	        lblName.setText(strResult);
//	        ImageButton btnAvatar = (ImageButton) findViewById(R.id.btnAvatar);
//	        
//	        btnAvatar.setOnClickListener(new OnClickListener() {
//				@Override
//				public void onClick(View v) {
//					 lblName.setText(clnt2serv.getStringFromUrl());
//				}
//			});
	        
	    }
	 

	 
	 
	 
	 

}
