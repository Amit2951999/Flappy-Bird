package com.example.flappybird;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

public class AppConstants {
    static BitmapBank bitmapBank;
    static GameEngine gameEngine;
    static Context context;
    static int SCREEN_WIDTH, SCREEN_HEIGHT,
            gravity,VELOCITY_WHEN_JUMPED
            ,gapBetweenTopAndBottomTubes,numberOfTubes
            ,tubeVelocity,minTubeOffSetY,maxTubeOffSetY,distanceBetweenTubes;

    static SoundBank soundBank;



    public static  void  initialization(Context context){
        setScreenSize(context);
        setGameConstants();
        bitmapBank=new BitmapBank(context.getResources());
        gameEngine=new GameEngine();
        soundBank=new SoundBank(context);

        Log.e("tube",AppConstants.numberOfTubes+"");
    }

    public static SoundBank getSoundBank() {
        return soundBank;
    }

    public static void setGameConstants(){
        gravity=3;
        AppConstants.VELOCITY_WHEN_JUMPED=-40;
        gapBetweenTopAndBottomTubes=600;
        AppConstants.numberOfTubes=2;
        AppConstants.tubeVelocity=12;
        AppConstants.minTubeOffSetY=(int)(AppConstants.gapBetweenTopAndBottomTubes/2.0);
        AppConstants.maxTubeOffSetY=AppConstants.SCREEN_HEIGHT-AppConstants.minTubeOffSetY-AppConstants.gapBetweenTopAndBottomTubes;
        AppConstants.distanceBetweenTubes=AppConstants.SCREEN_WIDTH*3/4;

    }

    public static BitmapBank getBitmapBank(){
        return bitmapBank;
    }

    public static GameEngine getGameEngine(){
        return gameEngine;
    }

    private static void setScreenSize(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display=wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        AppConstants.SCREEN_WIDTH = width;
        AppConstants.SCREEN_HEIGHT =height;
    }
}
