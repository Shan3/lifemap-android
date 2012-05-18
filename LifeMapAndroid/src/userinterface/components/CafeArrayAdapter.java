package userinterface.components;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import lifemap.act.R;
import model.Cafe;
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

public class CafeArrayAdapter extends ArrayAdapter<Cafe> {

	private static final String tag = "CountryArrayAdapter";
	private static final String ASSETS_DIR = "images/";
	private Context context;

	private ImageView imgFile_img;
	private TextView txtName;
	private TextView txtAddress;
	private TextView txtDistance;
	
	private List<Cafe> countries = new ArrayList<Cafe>();

	public CafeArrayAdapter(Context context, int textViewResourceId,List<Cafe> objects) {
		super(context, textViewResourceId, objects);
		this.context = context;
		this.countries = objects;
	}
	
	@Override
	public int getCount() {
		return this.countries.size();
	}
	
	@Override
	public Cafe getItem(int index) {
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
			row = inflater.inflate(R.layout.cafe_listitem, parent, false);
			Log.d(tag, "Successfully completed XML Row Inflation!");
		}

		// Get item
		Cafe cafe = getItem(position);
		imgFile_img = (ImageView) row.findViewById(R.id.imgFile_img);
		txtName = (TextView) row.findViewById(R.id.txtTitle);
		txtAddress = (TextView) row.findViewById(R.id.txtAddress);
		txtDistance = (TextView) row.findViewById(R.id.txtDistance);
		txtName.setText(cafe.title);
		txtAddress.setText(cafe.address);
		txtDistance.setText(cafe.distance+"m");
		
		try {
			URL url = new URL(cafe.file_img);
			InputStream is = (InputStream)url.getContent();
			Bitmap bitmap = BitmapFactory.decodeStream(is);
			imgFile_img.setImageBitmap(bitmap);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return row;
	}
}