package com.example.seventhree.drawprimitives;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


class DrawCircle extends DrawCanvas {

    private int rad;
    private int color;
    public DrawCircle(Context context,int color,int rad) {
        super(context);
        this.color =color;
        this.rad=rad;

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(color);

       if(rad > getHeight()/2 || rad > getWidth()/2)
           canvas.drawCircle(getWidth() / 2, getHeight() / 2, 0, paint);
           else
       canvas.drawCircle(getWidth() / 2, getHeight() / 2, rad, paint);
    }
}
public class Circle extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent getpar = getIntent();
        String shape_par = getpar.getStringExtra(Input.SHAPE_PARAMS);
        String params [] = shape_par.split("/");
        int rad;
        try {
             rad = Integer.parseInt(params[1].trim());
        }catch (NumberFormatException ex) {rad=0;}



         DrawCircle circle = new DrawCircle(this,Color.parseColor(params[0].trim()),rad);




        setContentView(circle);
    }


}
