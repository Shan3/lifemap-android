package lifemap.act;

import java.util.ArrayList;
import java.util.List;

import model.Member;

import userinterface.components.MemberArrayAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class FriendsListActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friends_list);
		
		ArrayList<Member> members = new ArrayList<Member>();
		
		members.add(new Member(0, "Tran Van A", null));
		
		MemberArrayAdapter adapter = new MemberArrayAdapter(getApplicationContext(), R.layout.friends_listitem, members);
		
		ListView lstFriends = (ListView) this.findViewById(R.id.lstFriends);
		lstFriends.setAdapter(adapter);
		
		
	}
}
