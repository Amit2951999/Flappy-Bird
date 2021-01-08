package com.example.flappybird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.Log;

public class BitmapBank {

    Bitmap background;
    Bitmap[] bird;
    Bitmap tubeTop,tubeBottom;
    Bitmap redTubeTop,redTubeBottom;


    public BitmapBank(Resources resources) {
        background= BitmapFactory.decodeResource(resources,R.drawable.background);
        background = scaleImage(background);


        bird = new Bitmap[8];
        bird[0] = BitmapFactory.decodeResource(resources,R.drawable.frame_1);
        bird[1] = BitmapFactory.decodeResource(resources,R.drawable.frame_2);
        bird[2] = BitmapFactory.decodeResource(resources,R.drawable.frame_3);
        bird[3] = BitmapFactory.decodeResource(resources,R.drawable.frame_4);
        bird[4] = BitmapFactory.decodeResource(resources,R.drawable.frame_5);
        bird[5] = BitmapFactory.decodeResource(resources,R.drawable.frame_6);
        bird[6] = BitmapFactory.decodeResource(resources,R.drawable.frame_7);
        bird[7] = BitmapFactory.decodeResource(resources,R.drawable.frame_8);
        bird[0] =Bitmap.createScaledBitmap(bird[0],160,160,true);
        bird[1] =Bitmap.createScaledBitmap(bird[1],160,160,true);
        bird[2] =Bitmap.createScaledBitmap(bird[2],160,160,true);
        bird[3] =Bitmap.createScaledBitmap(bird[3],160,160,true);
        bird[4] =Bitmap.createScaledBitmap(bird[4],160,160,true);
        bird[5] =Bitmap.createScaledBitmap(bird[5],160,160,true);
        bird[6] =Bitmap.createScaledBitmap(bird[6],160,160,true);
        bird[7] =Bitmap.createScaledBitmap(bird[7],160,160,true);

        tubeTop=BitmapFactory.decodeResource(resources,R.drawable.tube_top);
        tubeBottom=BitmapFactory.decodeResource(resources,R.drawable.tube_bottom);
        redTubeTop=BitmapFactory.decodeResource(resources,R.drawable.red_tube_top);
        redTubeBottom=BitmapFactory.decodeResource(resources,R.drawable.red_tube_bottom);

    }

    public Bitmap getRedTubeTop() {
        return redTubeTop;
    }

    public Bitmap getRedTubeBottom() {
        return redTubeBottom;
    }


    public Bitmap getTubeBottom() {
        return tubeBottom;
    }

    public Bitmap getTubeTop() {
        return tubeTop;
    }
    public int getTubeWidth(){
        return tubeTop.getWidth();
    }
    public int getTubeHeight(){
        return tubeTop.getHeight();
    }


    public Bitmap getBird(int frame){
        return bird[frame];
    }


    public int getBirdWidth(){
        return bird[0].getWidth();
    }

    public int getBirdHeight(){
        return bird[0].getHeight();
    }

    public Bitmap getBackground(){
        return background;
    }

    public int getBackgroundWidth(){
        return background.getWidth();
    }

    public int getBackgroundHeight(){
        return background.getHeight();
    }


    public Bitmap scaleImage(Bitmap bitmap){
        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();
        int backgroundScaledWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap, backgroundScaledWidth, AppConstants.SCREEN_HEIGHT, false);
    }
}
