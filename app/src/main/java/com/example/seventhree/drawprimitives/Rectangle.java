package com.example.seventhree.drawprimitives;


import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

class DrawRect extends DrawCanvas {
    private int width ;
    private int height;
    private int color;

    public DrawRect(Context context,int color,int w,int h) {
        super(context);
        this.color=color;
        this.width=w;
        this.height=h;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(color);
        if(width > getHeight() || height > getHeight())
            canvas.drawRect(0, 0, 0, 0, paint);
        else

            canvas.drawRect(0,0,  width, height, paint);

    }
}
public class Rectangle extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent getpar = getIntent();
        String shape_par = getpar.getStringExtra(Input.SHAPE_PARAMS);
        String params [] = shape_par.split("/");
        int w;
        int h;

        try{
            w = Integer.parseInt(params[1].trim());
            h = Integer.parseInt(params[2].trim());
    }catch (NumberFormatException ex) {w=0;h=0;}

        DrawRect rekt = new DrawRect(this,Color.parseColor(params[0].trim()),w,h);


        setContentView(rekt);
    }
}
