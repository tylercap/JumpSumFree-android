package com.gmail.tylercap4.jumpsumfree;

import com.flurry.android.FlurryAgent;
import com.flurry.android.ads.FlurryAdBanner;
import com.flurry.android.ads.FlurryAdBannerListener;
import com.flurry.android.ads.FlurryAdErrorType;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class HowToPage extends Activity 
{
	private static final String FLURRY_API_KEY = "ZN9SPGGB4VB3BNHGNDT8";
	
	private RelativeLayout mBanner;
    private FlurryAdBanner mFlurryAdBanner = null;
    private String bannerAdName = "JS_ANDROID_BANNER";

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_to);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        // configure Flurry
        FlurryAgent.setLogEnabled(false);

        // init Flurry
        FlurryAgent.init(this, FLURRY_API_KEY);
	}
	
    @Override
    protected void onResume(){
    	super.onResume();
    	mBanner = (RelativeLayout)findViewById(R.id.banner);
        mFlurryAdBanner = new FlurryAdBanner(this, mBanner, bannerAdName);
 
        // optional allow us to get callbacks for ad events, 
        mFlurryAdBanner.setListener(bannerAdListener);

        mFlurryAdBanner.fetchAndDisplayAd();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mFlurryAdBanner.destroy();
    }
	
	@Override
	protected void onStop(){
		super.onStop();
		FlurryAgent.onEndSession(this);
	}
	    
    @Override
    protected void onStart(){
    	super.onStart();

		FlurryAgent.onStartSession(this);
    }
    
    @Override
    protected void onPause(){
    	super.onPause();
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

    FlurryAdBannerListener bannerAdListener = new FlurryAdBannerListener() {
        
        @Override
        public void onFetched(FlurryAdBanner adBanner) {
               adBanner.displayAd();
        }

        @Override
        public void onError(FlurryAdBanner adBanner, FlurryAdErrorType adErrorType, int errorCode) {
             adBanner.destroy();
        }
       //..
       //the remainder of the listener callback methods

		@Override
		public void onAppExit(FlurryAdBanner arg0) {
			// Auto-generated method stub
			
		}

		@Override
		public void onClicked(FlurryAdBanner arg0) {
			// Auto-generated method stub
			
		}

		@Override
		public void onCloseFullscreen(FlurryAdBanner arg0) {
			// Auto-generated method stub
			
		}

		@Override
		public void onRendered(FlurryAdBanner arg0) {
			// Auto-generated method stub
			
		}

		@Override
		public void onShowFullscreen(FlurryAdBanner arg0) {
			// Auto-generated method stub
			
		}

		@Override
		public void onVideoCompleted(FlurryAdBanner arg0) {
			// Auto-generated method stub
			
		}
    };
}
