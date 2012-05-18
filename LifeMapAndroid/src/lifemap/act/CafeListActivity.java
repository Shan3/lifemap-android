package lifemap.act;

import java.util.List;

import model.Cafe;
import model.CafeTable;
import userinterface.components.CafeArrayAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class CafeListActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cafe_list);
		
		CafeTable tabCafe = new CafeTable();
		List<Cafe> cafes = tabCafe.getCafes();
		
		CafeArrayAdapter adapter = new CafeArrayAdapter(getApplicationContext(), R.layout.cafe_listitem, cafes);
		
		ListView lstCafe = (ListView) this.findViewById(R.id.lstCafe);
		lstCafe.setAdapter(adapter);
		
		
	}
}
