package com.example.seventhree.drawprimitives;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

class DrawPicture extends DrawCanvas {
     Bitmap pic = BitmapFactory.decodeResource(getResources(),R.drawable.andron);
     private int x ;
     private int y ;
    public DrawPicture(Context context) {

        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        x=(getWidth()/2)-(pic.getWidth()/2);
        y=(getHeight()/2)-(pic.getHeight()/2);
        canvas.drawBitmap(pic,x,y,null);
    }
}
public class Picture extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DrawPicture pic = new DrawPicture(this);

        setContentView(pic);
    }
}
