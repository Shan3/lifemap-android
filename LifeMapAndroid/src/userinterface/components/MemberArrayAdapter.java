package userinterface.components;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import lifemap.act.R;
import model.Member;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MemberArrayAdapter extends ArrayAdapter<Member> {

	private static final String tag = "CountryArrayAdapter";
	private static final String ASSETS_DIR = "images/";
	private Context context;

	private ImageView imgAvatar;
	private TextView txtName;
	
	private List<Member> countries = new ArrayList<Member>();

	public MemberArrayAdapter(Context context, int textViewResourceId,	List<Member> objects) {
		super(context, textViewResourceId, objects);
		this.context = context;
		this.countries = objects;
	}
	
	@Override
	public int getCount() {
		return this.countries.size();
	}
	
	@Override
	public Member getItem(int index) {
		return this.countries.get(index);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		if (row == null) {
			// ROW INFLATION
			Log.d(tag, "Starting XML Row Inflation ... ");
			LayoutInflater inflater = (LayoutInflater) this.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.friends_listitem, parent, false);
			Log.d(tag, "Successfully completed XML Row Inflation!");
		}

		// Get item
		Member country = getItem(position);
		imgAvatar = (ImageView) row.findViewById(R.id.imgAvatar);
		txtName = (TextView) row.findViewById(R.id.txtName);
		txtName.setText(country.member_name);
		try {
			URL url = new URL(R.string.domain + country.imagePath);
			InputStream is = (InputStream)url.getContent();
			Bitmap bitmap = BitmapFactory.decodeStream(is);
			imgAvatar.setImageBitmap(bitmap);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return row;
	}
}