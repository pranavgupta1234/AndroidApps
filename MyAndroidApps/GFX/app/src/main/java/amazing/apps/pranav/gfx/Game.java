package amazing.apps.pranav.gfx;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import java.util.Random;

/**
 * Created by root on 13/10/16.
 */

public class Game extends View{
    int changingY,changingX1,changingX2,changingX3,changingX4;
    Bitmap ball1,ball2,ball3,ball4;
    public Game(Context context) {
        super(context);
        ball1 = BitmapFactory.decodeResource(getResources(),R.drawable.ball);
        ball2 = BitmapFactory.decodeResource(getResources(),R.drawable.ball);
        ball3 = BitmapFactory.decodeResource(getResources(),R.drawable.ball);
        ball4 = BitmapFactory.decodeResource(getResources(),R.drawable.ball);
        changingY=0;
        changingX1=0;
        changingX2=0;
        changingX3=0;
        changingX4=0;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(ball1,(changingX1%canvas.getWidth()),changingY,null);
        canvas.drawBitmap(ball2,(changingX2+270)%canvas.getWidth(),changingY,null);
        canvas.drawBitmap(ball3,(changingX3+540)%canvas.getWidth(),changingY,null);
        canvas.drawBitmap(ball4,(changingX4+810)%canvas.getWidth(),changingY,null);
        if(changingY<canvas.getHeight()){
            //Random crazy =new Random();
            changingY+=10;
        }
        else {
            Random crazy = new Random();
            changingY =0;

            changingX1 = (crazy.nextInt(canvas.getWidth()))%canvas.getWidth();
            changingX2 = (changingX1 + 270)%canvas.getWidth();
            changingX3 = (changingX2 +270)%canvas.getWidth();
            changingX4 = (changingX3 +270)%canvas.getWidth();
        }
        /*
        Rect middleRect = new Rect();
        middleRect.set(0,400,canvas.getWidth(),800);
        Paint ourBlue = new Paint();
        ourBlue.setColor(Color.BLUE);
        canvas.drawRect(middleRect,ourBlue);*/
        invalidate();
    }
}
