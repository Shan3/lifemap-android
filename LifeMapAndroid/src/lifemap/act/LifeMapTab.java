package lifemap.act;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class LifeMapTab extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Resources res = getResources(); 
        TabHost tabHost = getTabHost();  
        TabHost.TabSpec spec;  
        Intent intent; 
        
     // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, FriendsActivity.class);
        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("friends").setIndicator("Friends",
                          res.getDrawable(R.drawable.tab_icon1))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, Tab2Activity.class);
        spec = tabHost.newTabSpec("tab2").setIndicator("Tab2",
                          res.getDrawable(R.drawable.tab_icon2))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, Tab3Activity.class);
        spec = tabHost.newTabSpec("tab3").setIndicator("Tab3",
                          res.getDrawable(R.drawable.tab_icon3))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, MeActivity.class);
        spec = tabHost.newTabSpec("Me").setIndicator("Me",
                          res.getDrawable(R.drawable.tab_icon4))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        tabHost.setCurrentTab(2);
        
    }
}