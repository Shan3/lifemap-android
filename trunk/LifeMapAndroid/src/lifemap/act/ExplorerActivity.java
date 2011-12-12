package lifemap.act;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import model.Category;
import model.CategoryTable;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ExplorerActivity extends Activity{
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.explorer);

	        CategoryTable tblCat = new CategoryTable();
	        List<Category> categories = tblCat.getAll();
	        
	        LinearLayout lyaExplorer = (LinearLayout) findViewById(R.id.lyaExplorer);
	        for (Category category : categories) {
	       	 	View v = View.inflate(this, R.layout.buttons_category, null);
	       	 	Button btnCategoryItem = (Button) v.findViewById(R.id.btnCategory);
	       	 	btnCategoryItem.setText(category.name);
	       	 	URL url;
				try {
					url = new URL(category.icon);
					InputStream is = (InputStream)url.getContent();
					btnCategoryItem.setBackgroundDrawable((Drawable.createFromStream(is , "src")));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	       	 	lyaExplorer.addView(v);
        	}
	    }
}
