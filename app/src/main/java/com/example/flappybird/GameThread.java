package com.example.flappybird;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread {

    SurfaceHolder surfaceHolder;
    boolean isRunning; //flag to tell whether thread is runnin or not
    long startTime, loopTime;
    long DELAY=33; //delay in ms between screen refresh

    public GameThread(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        isRunning = true;
    }

    @Override
    public void run() {
        super.run();
        //loop until boolean is false
        while (isRunning) {
            startTime = SystemClock.uptimeMillis();

            Canvas canvas = surfaceHolder.lockCanvas(null);
            if (canvas != null) {
                synchronized (surfaceHolder) {
                    AppConstants.getGameEngine().updateAndDrawBackgroundImage(canvas);
                    AppConstants.getGameEngine().updateAndDrawBird(canvas);
                    AppConstants.getGameEngine().updateAndDrawTubes(canvas);
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }

                //loop time
                loopTime = SystemClock.uptimeMillis() - startTime;

                if (loopTime < DELAY) {
                    try {
                        Thread.sleep(DELAY - loopTime);
                    } catch (InterruptedException e) {
                        Log.e("interrupted", "interrupted while sleeping");
                    }
                }
            }
        }
    }

    public boolean isRunning(){
        return isRunning;
    }

    public void setIsRunning(boolean state){
        isRunning = state;
    }
}
