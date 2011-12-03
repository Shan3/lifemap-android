package lifemap.act;

import java.util.ArrayList;
import java.util.List;

import model.Member;
import model.MemberTable;

import userinterface.components.MemberArrayAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class FriendsListActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friends_list);
		
		MemberTable tabMember = new MemberTable();
		int member_id = ((LifeMapApplication) getApplication() ).getMember().member_id;
		List<Member> members = tabMember.getFriends(member_id);
		
		MemberArrayAdapter adapter = new MemberArrayAdapter(getApplicationContext(), R.layout.friends_listitem, members);
		
		ListView lstFriends = (ListView) this.findViewById(R.id.lstFriends);
		lstFriends.setAdapter(adapter);
		
		
	}
}
