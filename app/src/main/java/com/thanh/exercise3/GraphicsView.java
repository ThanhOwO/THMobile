package com.thanh.exercise3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Canvas;


public class GraphicsView extends View {

    int x=0;
    int y=0;
    int d=100;
    int r=50;

    Bitmap[] frames = new Bitmap[36];
    int i = 0;
    long last_tick=0;
    long period=200;
    Context ctext;
    MediaPlayer mPlayer;
    public GraphicsView(Context context) {
        super(context);

        ctext = context;
        frames[0]= BitmapFactory.decodeResource(getResources (), R.drawable.win1);
        frames[1] = BitmapFactory.decodeResource(getResources (), R.drawable.win2);
        frames [2]= BitmapFactory.decodeResource(getResources (), R.drawable.win3);
        frames[3]= BitmapFactory.decodeResource(getResources (), R.drawable.win4);
        frames [4]= BitmapFactory.decodeResource(getResources (), R.drawable.win5);
        frames [5] = BitmapFactory.decodeResource(getResources (), R.drawable.win6);
        frames [6]= BitmapFactory.decodeResource(getResources (), R.drawable.win7);
        frames[7]= BitmapFactory.decodeResource(getResources (), R.drawable.win8);
        frames[8] = BitmapFactory.decodeResource(getResources (), R.drawable.win9);
        frames [9]= BitmapFactory.decodeResource(getResources (), R.drawable.win10);
        frames[10]= BitmapFactory.decodeResource(getResources (), R.drawable.win11);
        frames [11]= BitmapFactory.decodeResource(getResources (), R.drawable.win12);
        frames [12] = BitmapFactory.decodeResource(getResources (), R.drawable.win13);
        frames [13]= BitmapFactory.decodeResource(getResources (), R.drawable.win14);
        frames[14]= BitmapFactory.decodeResource(getResources (), R.drawable.win15);
        frames[15] = BitmapFactory.decodeResource(getResources (), R.drawable.win16);
        frames [16]= BitmapFactory.decodeResource(getResources (), R.drawable.win17);
        frames[17]= BitmapFactory.decodeResource(getResources (), R.drawable.win18);
        frames [18]= BitmapFactory.decodeResource(getResources (), R.drawable.win19);
        frames [19] = BitmapFactory.decodeResource(getResources (), R.drawable.win20);
        frames [20]= BitmapFactory.decodeResource(getResources (), R.drawable.win21);
        frames[21]= BitmapFactory.decodeResource(getResources (), R.drawable.win22);
        frames[22] = BitmapFactory.decodeResource(getResources (), R.drawable.win23);
        frames [23]= BitmapFactory.decodeResource(getResources (), R.drawable.win24);
        frames[24]= BitmapFactory.decodeResource(getResources (), R.drawable.win25);
        frames [25]= BitmapFactory.decodeResource(getResources (), R.drawable.win26);
        frames [26] = BitmapFactory.decodeResource(getResources (), R.drawable.win27);
        frames [27]= BitmapFactory.decodeResource(getResources (), R.drawable.win28);
        frames[28]= BitmapFactory.decodeResource(getResources (), R.drawable.win29);
        frames[29] = BitmapFactory.decodeResource(getResources (), R.drawable.win30);
        frames [30]= BitmapFactory.decodeResource(getResources (), R.drawable.win31);
        frames[31]= BitmapFactory.decodeResource(getResources (), R.drawable.win32);
        frames [32]= BitmapFactory.decodeResource(getResources (), R.drawable.win33);
        frames [33] = BitmapFactory.decodeResource(getResources (), R.drawable.win34);
        frames [34]= BitmapFactory.decodeResource(getResources (), R.drawable.win35);
        frames[35]= BitmapFactory.decodeResource(getResources (), R.drawable.win36);

        mPlayer = MediaPlayer.create(ctext, R.raw.music);
        mPlayer.start();
    }

    //Bài 1
    /*@Override
    protected void onDraw(Canvas canvas){

        Rect r=new Rect(40, 40, 400, 200);
        Paint paint = new Paint();
        paint.setStyle (Paint.Style. FILL);
        paint.setColor(Color.RED);
        canvas.drawRect (r, paint);

        invalidate();

    }

    //Bài 2
    /*@Override
    protected void onDraw(Canvas canvas){

        if (x!=0&&y!=0) {
            int right=x+d;
            int bottom=y+r;
            Rect r=new Rect(x, y, right, bottom);
            Paint paint = new Paint();
            paint.setStyle (Paint.Style. FILL);
            paint.setColor(Color.RED);
            canvas.drawRect (r, paint);
        }
        invalidate();
    }

    @Override
    public boolean onTouchEvent (MotionEvent event) {
        x= (int) event.getX();
        y= (int) event.getY();
        return super.onTouchEvent (event);
    }*/

    //Bài 3
    /*@Override
    protected void onDraw(Canvas canvas){

        if (i<36) {
            canvas.drawBitmap (frames [i], 40, 40,  new Paint());
        }
        else{
            i=0;
        }
        invalidate();
    }


    @Override
    public boolean onTouchEvent (MotionEvent event) {
        i++;
        return true;
    }*/

    //Bài 4
    @Override
    protected void onDraw(Canvas canvas){

        if (i<36) {
            long time = (System.currentTimeMillis() - last_tick);
            if (time >= period) //the delay time has passed. set next frame
            {
                last_tick = System.currentTimeMillis();
                canvas.drawBitmap (frames[i], 40, 40, new Paint());
                i++;
                // Again call onDraw method
                postInvalidate();
            }
            else //still within delay. redraw current frame
            {
                canvas.drawBitmap (frames [i], 40, 40, new Paint()); // Again call onDraw method
                postInvalidate();
            }
        }
            else{
                i=0;
                postInvalidate();
            }
    }

}
