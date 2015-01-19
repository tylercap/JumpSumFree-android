package com.gmail.tylercap4.jumpsumfree;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class HowToPage extends Activity 
{
	//private com.google.android.gms.ads.AdView adMobView;
	private com.adsdk.sdk.banner.AdView mobFoxAdView;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_to);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        // Load the banner ad
        //adMobView = (AdView) findViewById(R.id.adView);
        //adMobView.loadAd(new AdRequest.Builder().build());
        
        // Load the banner ad
        FrameLayout layout = (FrameLayout) findViewById(R.id.banner_layout);
        mobFoxAdView = new com.adsdk.sdk.banner.AdView(this, "http://my.mobfox.com/request.php", getString(R.string.mob_fox_publisher_id), true, true);
        mobFoxAdView.setAdspaceWidth(320); // Optional, used to set the custom size of banner placement. Without setting it, the SDK will use default size of 320x50 or 300x50 depending on device type.
        mobFoxAdView.setAdspaceHeight(50);  
        mobFoxAdView.setAdspaceStrict(false); // Optional, tells the server to only supply banner ads that are exactly of the desired size. Without setting it, the server could also supply smaller Ads when no ad of desired size is available.
        // mobFoxAdView.setAdListener(this);
        layout.addView(mobFoxAdView);
	}
	
    @Override
    protected void onResume(){
    	super.onResume();
        //adMobView.resume();
    	mobFoxAdView.resume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //adMobView.pause();
    	mobFoxAdView.pause();
    }

    
    @Override
    protected void onPause(){
    	super.onPause();
        //adMobView.pause();
    	mobFoxAdView.pause();
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        // Respond to the action bar's Up/Home button
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
