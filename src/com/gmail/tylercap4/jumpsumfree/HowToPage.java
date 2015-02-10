package com.gmail.tylercap4.jumpsumfree;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

public class HowToPage extends Activity 
{
	private AdView adMobView;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_to);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        // Load the banner ad
        adMobView = (AdView) findViewById(R.id.adView);
        adMobView.loadAd(new AdRequest.Builder().build());
	}
	
    @Override
    protected void onResume(){
    	super.onResume();
        adMobView.resume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        adMobView.pause();
    }

    
    @Override
    protected void onPause(){
    	super.onPause();
        adMobView.pause();
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
