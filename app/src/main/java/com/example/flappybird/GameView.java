package com.example.flappybird;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    GameThread gameThread;

    public GameView(Context context) {
        super(context);
        initView();
    }

    void initView(){
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);
        gameThread = new GameThread(holder);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if(!gameThread.isRunning()){
            gameThread= new GameThread(surfaceHolder);
            gameThread.start();
        }
        else{
            gameThread.start();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if(gameThread.isRunning()){
            gameThread.setIsRunning(false);
            boolean retry=true;
            while (retry){
                try {
                    gameThread.join();
                    retry = false;
                }catch (InterruptedException e){}
            }
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action=event.getAction();

        if(action==MotionEvent.ACTION_DOWN){
            if(AppConstants.getGameEngine().gameState==0) {
                AppConstants.getGameEngine().gameState = 1;
                AppConstants.getSoundBank().playSwoosh();
            }
            else {
                AppConstants.getSoundBank().playWing();
            }
                AppConstants.getGameEngine().bird.setVelocity(AppConstants.VELOCITY_WHEN_JUMPED);
        }
        return true;
    }
}
