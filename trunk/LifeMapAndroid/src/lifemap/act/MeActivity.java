package lifemap.act;

import clientserver.Client2Server;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;


public class MeActivity extends Activity{
	
	String strResult = "";
	Client2Server clnt2serv = new Client2Server();
	TextView lblName = null;
	
	
	public void setTextResult(String str){
		lblName.setText(str);
	}
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	        View vMain = View.inflate(this, R.layout.profile, null);
	        
	        setContentView(vMain);
	        
	         lblName = (TextView) findViewById(R.id.lblName);
	        
	         
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
