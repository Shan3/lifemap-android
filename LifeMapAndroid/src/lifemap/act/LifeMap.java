package lifemap.act;



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
	public static final String PREFS_NAME = "MyPrefsFile";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        int member_id = settings.getInt("member_id", -1);
        String member_name = settings.getString("member_name", null);
        
        
        if (member_id==-1){
	        Button btnLogin = (Button)findViewById(R.id.btnLogin);
	        btnLogin.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					MemberTable tblMember = new MemberTable();
					Member mem = tblMember.getMember("", "");
					if (mem!=null){
						SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
						SharedPreferences.Editor editor = settings.edit();
						editor.putInt("member_id", mem.member_id);
						editor.putString("member_name", mem.member_name);
						editor.commit();
						
						((LifeMapApplication)getApplicationContext()).setMember(mem);
						
						Intent iteTab = new Intent(LifeMap.this,LifeMapTab.class);
						startActivity(iteTab);
						finish();
						
					}
				}
			});
        }else{
        	MemberTable tblMember = new MemberTable();
//        	Member mem = tblMember.getMember(member_id);
        	
        	Member mem = new Member(member_id, member_name);
        	
        	Log.v("",mem.toString());
        	
        	((LifeMapApplication)getApplicationContext()).setMember(mem);
			Intent iteTab = new Intent(LifeMap.this,LifeMapTab.class);
			startActivity(iteTab);
			finish();
        }
        
    }
}