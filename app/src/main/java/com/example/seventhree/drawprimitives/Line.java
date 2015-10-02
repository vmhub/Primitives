package com.example.seventhree.drawprimitives;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

class DrawLine extends DrawCanvas {
    private int stroke;
    private int length;
    private int color;
    public DrawLine(Context context, int color, int st, int len) {
        super(context);
       this.color=color;
        stroke=st;
        length = len;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(color);
        if(stroke > getWidth())
            paint.setStrokeWidth(0);
        else
            paint.setStrokeWidth(stroke);
        if (length > getHeight())
            canvas.drawLine(0, 0, 0, 0, paint);
        else
            canvas.drawLine(getWidth()/2,0,getWidth()/2,length,paint);

    }
}
    public class Line extends AppCompatActivity {
        private DrawLine line;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Intent getpar = getIntent();
            String shape_par = getpar.getStringExtra(Input.SHAPE_PARAMS);
            String params[] = shape_par.split("/");
            int stroke;
            int len;
            try {
                stroke = Integer.parseInt(params[1].trim());
                len = Integer.parseInt(params[2].trim());
            } catch (NumberFormatException ex) {
                len = 0;
                stroke = 0;
            }
            switch (params[0].trim()) {
                case "BLUE":
                    line = new DrawLine(this, Color.BLUE, stroke, len);
                    break;
                case "RED":

                    line = new DrawLine(this, Color.RED, stroke, len);
                    break;
                case "GREEN":

                    line = new DrawLine(this, Color.GREEN, stroke, len);
                    break;

            }


            setContentView(line);
        }

    }
