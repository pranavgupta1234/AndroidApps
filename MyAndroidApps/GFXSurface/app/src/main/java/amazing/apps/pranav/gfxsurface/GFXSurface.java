package amazing.apps.pranav.gfxsurface;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

/**
 * Created by root on 14/10/16.
 */

public class GFXSurface extends Activity implements OnTouchListener{
    GameSurface ourSurfaceView;
    float x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ourSurfaceView = new GameSurface(this);
        ourSurfaceView.setOnTouchListener(this);
        x=0;
        y=0;
        setContentView(ourSurfaceView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ourSurfaceView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ourSurfaceView.resume();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x=event.getX();
        y=event.getY();
        return true;
    }

    public class GameSurface extends SurfaceView implements Runnable {
        SurfaceHolder ourHolder;
        Thread ourThread;
        boolean isRunnning =true;
        public GameSurface(Context context){
            super(context);
            ourHolder = getHolder();

        }
        public void pause() {
            isRunnning = false;
            while (true) {
                try {
                    ourThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            ourThread =null;
        }
        public void resume(){
            isRunnning=true;
            ourThread = new Thread(this);
            ourThread.start();
        }
        public void run(){
            while(isRunnning){
                if(!ourHolder.getSurface().isValid())
                    continue;
                Canvas canvas = ourHolder.lockCanvas();
                canvas.drawColor(Color.WHITE);
                if(x!=0 && y!=0){
                    Bitmap test = BitmapFactory.decodeResource(getResources(),R.drawable.ball);
                    canvas.drawBitmap(test,x-(test.getWidth())/2,y-(test.getHeight())/2,null);
                }
                ourHolder.unlockCanvasAndPost(canvas);

            }

        }
    }
}
