package lifemap.act;

import model.Member;
import android.app.Application;

public class LifeMapApplication extends Application {
	private Member mem;
	
	public Member getMember(){
		return mem;
	}
	
	public void setMember(Member mem){
		this.mem = mem;
	}
	
}
