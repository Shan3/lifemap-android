package dialogs;

import lifemap.act.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

public class LoginDialog extends Dialog {

	public LoginDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
	}
	
}
