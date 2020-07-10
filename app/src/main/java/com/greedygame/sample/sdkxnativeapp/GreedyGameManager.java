package com.greedygame.sample.sdkxnativeapp;

import android.content.Context;

import com.greedygame.core.AppConfig;
import com.greedygame.core.GreedyGameAds;
import com.greedygame.core.interfaces.GreedyGameAdsEventsListener;

public class GreedyGameManager {

    public static void init(Context context, GreedyGameAdsEventsListener listener){
        AppConfig appConfig = new AppConfig.Builder(context).withAppId("89221032").build();
        GreedyGameAds.initWith(appConfig,listener);
    }
}
