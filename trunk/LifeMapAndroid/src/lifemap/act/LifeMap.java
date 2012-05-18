package lifemap.act;



import storage.sharedpreferences.MemberStorage;
import model.CafeTable;
import model.Member;
import model.MemberTable;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LifeMap extends Activity {
	
	Member mem = null;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        MemberStorage loginMng = new MemberStorage(this);
        mem = loginMng.getMember();
        Log.v("MyDebug","mem = "+mem);
        
//        mem = new Member(123456, "phucT9", "");
        
        if (mem==null){
	        Button btnLogin = (Button)findViewById(R.id.btnLogin);
	        btnLogin.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					login("", "");
				}
			});
        }else{
        	((LifeMapApplication)getApplicationContext()).setMember(mem);
			Intent iteTab = new Intent(LifeMap.this,LifeMapTab.class);
			startActivity(iteTab);
			finish();
        }
        
    }
    
    
    
    private void login(String username,String password){
    	CafeTable tbCafe = new CafeTable();
		tbCafe.getCafes();
		
    	MemberTable tblMember = new MemberTable();
		mem = tblMember.getMember(username, password);
		if (mem!=null){
			MemberStorage loginMng = new MemberStorage(this);
			loginMng.setMember(mem);
			((LifeMapApplication)getApplicationContext()).setMember(mem);
			Intent iteTab = new Intent(LifeMap.this,LifeMapTab.class);
			startActivity(iteTab);
			finish();
		}
    }
}