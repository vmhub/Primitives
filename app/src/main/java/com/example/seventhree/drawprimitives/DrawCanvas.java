package com.example.seventhree.drawprimitives;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawCanvas extends View{
protected Paint paint = new Paint();

    public DrawCanvas(Context context){
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas){
    super.onDraw(canvas);
        paint.setColor(Color.CYAN);
        canvas.drawColor(paint.getColor());
    }

}
