package storage.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import model.Member;

public class MemberStorage {
	private final String PREFS_NAME = "MyPrefsFile";
	private Context context;
	public MemberStorage(Context context){
		this.context = context;
	}
	
	public Member getMember(){
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
        int member_id = settings.getInt("member_id", -1);
        String member_name = settings.getString("member_name", null);
        String imagePath = settings.getString("imagePath", null);
        if (member_id==-1)	return null;
        else 
        	return new Member(member_id, member_name,imagePath);
	}
	
	public void setMember(Member mem){
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		if (mem!=null){
			editor.putInt("member_id", mem.member_id);
			editor.putString("member_name", mem.member_name);
			editor.putString("imagePath", mem.imagePath);
		}else{
			editor.putInt("member_id", -1);
			editor.putString("member_name", null);
		}
		editor.commit();
	}
	
}
