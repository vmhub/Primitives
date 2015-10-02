package com.example.seventhree.drawprimitives;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Select extends AppCompatActivity {
    public final static String SHAPE = "com.example.seventhree.FirstMessageKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }


    public void getshape(View view){

        int id = view.getId();
        Intent shapeshift;
        if(id==R.id.line) {
            shapeshift=new Intent(this,Input.class);
            shapeshift.putExtra(SHAPE,"Line");
        }
        else if (id==R.id.rectangle) {
            shapeshift=new Intent(this,Input.class);
            shapeshift.putExtra(SHAPE,"Rekt");
        }
        else if (id==R.id.circle) {
            shapeshift=new Intent(this,Input.class);
            shapeshift.putExtra(SHAPE,"Circle");
        }
       else {shapeshift=new Intent(this,Picture.class);}
        startActivity(shapeshift);
    }
}
