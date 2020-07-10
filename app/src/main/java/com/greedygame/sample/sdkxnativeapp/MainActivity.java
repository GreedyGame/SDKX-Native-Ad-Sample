package com.greedygame.sample.sdkxnativeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.greedygame.core.AppConfig;
import com.greedygame.core.GreedyGameAds;
import com.greedygame.core.adview.GGAdview;
import com.greedygame.core.adview.interfaces.AdLoadCallback;
import com.greedygame.core.adview.modals.AdRequestErrors;
import com.greedygame.core.interfaces.GreedyGameAdsEventsListener;
import com.greedygame.core.*;
import com.greedygame.core.AppConfig;
import com.greedygame.core.GreedyGameAds;
import com.greedygame.core.models.InitErrors;

import static com.greedygame.core.AppConfig.*;

public class MainActivity extends AppCompatActivity {
    GGAdview adview;
    FrameLayout adContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAds();
        adContainer = findViewById(R.id.adContainer);
    }

    private void initAds() {
        AppConfig appConfig = new Builder(getApplicationContext()).withAppId("89221032").build();
        GreedyGameAds.initWith(appConfig, new GreedyGameAdsEventsListener() {
            @Override
            public void onInitSuccess(){
                loadAd();
            }

            @Override
            public void onInitFailed(InitErrors cause){

            }

            @Override
            public void onDestroyed(){

            }
        });
    }

    private void loadAd() {
        adview = new GGAdview(this);
        adview.setUnitId("float-4706");
        final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        adContainer.addView(adview,layoutParams);
        adview.loadAd(new AdLoadCallback() {
            @Override
            public void onAdLoaded() {
                // Callback when an ad has been loaded successfully
                Toast.makeText(getApplicationContext(), "AD LOADED", Toast.LENGTH_SHORT).show();
                //If View was already hidden unhide the view
//                if (adview.getVisibility() == View.GONE) {
//                    adview.setVisibility(View.VISIBLE);
//                }

            }

            @Override
            public void onAdLoadFailed(AdRequestErrors cause) {
                // Any Errors encountered during loading of an
                // ad will be available here
                Toast.makeText(getApplicationContext(), "AD LOAD FAILED", Toast.LENGTH_SHORT).show();
                //HIDING THE VIEW
                adview.setVisibility(View.GONE);
                adContainer.removeAllViews();
            }

            @Override
            public void onUiiOpened() {
                // Callback when the engagement window opens
            }

            @Override
            public void onUiiClosed() {
                // Callback when the engagement window closes
            }

            @Override
            public void onReadyForRefresh() {
                // This method will be called only if  the refresh policy of the unit is set to RefreshPolicy.MANUAL    }

            }
        });
    }

}