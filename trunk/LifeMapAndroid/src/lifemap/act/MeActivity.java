package lifemap.act;

import storage.sharedpreferences.MemberStorage;
import model.Member;
import clientserver.Client2Server;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MeActivity extends Activity {
	Member mem = null;
	TextView lblName = null;

	public void setTextResult(String str) {
		lblName.setText(str);
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mem = ((LifeMapApplication) getApplicationContext()).getMember();
		lblName.setText(mem.member_name);
		
		View vMain = View.inflate(this, R.layout.profile, null);
		setContentView(vMain);
		lblName = (TextView) findViewById(R.id.lblName);

		

		Button btnLogin = (Button) findViewById(R.id.btnLogout);
		btnLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				logout();
			}
		});

		// Thread t = new Thread() {
		// public void run() {
		// runOnUiThread(new Runnable() {
		// @Override
		// public void run() {
		// lblName.setText("test");
		// }
		// });
		// }
		// };
		// t.start();

		// ProgressDialog dialog = ProgressDialog.show(this, "Loading",
		// "Please wait...", false);
		// strResult = clnt2serv.getStringFromUrl();
		// lblName.setText(strResult);
		// dialog.dismiss();
		//

		// lblName.setText(strResult);
		// ImageButton btnAvatar = (ImageButton) findViewById(R.id.btnAvatar);
		//
		// btnAvatar.setOnClickListener(new OnClickListener() {
		// @Override
		// public void onClick(View v) {
		// lblName.setText(clnt2serv.getStringFromUrl());
		// }
		// });

	}

	private void logout() {
		mem = null;
		new MemberStorage(this).setMember(mem);
		Intent iteLifeMap = new Intent(MeActivity.this,LifeMap.class);
		startActivity(iteLifeMap);
		finish();
	}

}
