package com.example.seventhree.drawprimitives;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Input extends AppCompatActivity {
    public final static String SHAPE_PARAMS = "com.example.seventhree.FirstMessageKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Spinner dropdown = (Spinner)findViewById(R.id.colorspinner);
        String[] items = new String[]{"RED", "GREEN", "BLUE"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);








        Intent getshape = getIntent();
        String shape = getshape.getStringExtra(Select.SHAPE);

        if(shape.trim().equals("Rekt")) {
            EditText radius = (EditText) findViewById(R.id.radiusinput);
            TextView radiusv = (TextView) findViewById(R.id.radiusview);

            EditText stroke = (EditText) findViewById(R.id.strokeinput);
            TextView strokev = (TextView) findViewById(R.id.strokeview);

            EditText length = (EditText) findViewById(R.id.lengthinput);
            TextView lengthv = (TextView) findViewById(R.id.lengthview);

            radius.setVisibility(View.INVISIBLE);
            radiusv.setVisibility(View.INVISIBLE);
            stroke.setVisibility(View.INVISIBLE);
            strokev.setVisibility(View.INVISIBLE);
            length.setVisibility(View.INVISIBLE);
            lengthv.setVisibility(View.INVISIBLE);
        }
        else if (shape.trim().equals("Circle")) {
            EditText stroke = (EditText) findViewById(R.id.strokeinput);
            TextView strokev = (TextView) findViewById(R.id.strokeview);

            EditText length = (EditText) findViewById(R.id.lengthinput);
            TextView lengthv = (TextView) findViewById(R.id.lengthview);
            EditText width = (EditText) findViewById(R.id.widthinput);
            TextView widthv = (TextView) findViewById(R.id.widthview);

            EditText height = (EditText) findViewById(R.id.heightinput);
            TextView heightv = (TextView) findViewById(R.id.heightview);



            width.setVisibility(View.INVISIBLE);
            widthv.setVisibility(View.INVISIBLE);
            stroke.setVisibility(View.INVISIBLE);
            strokev.setVisibility(View.INVISIBLE);

            height.setVisibility(View.INVISIBLE);
            heightv.setVisibility(View.INVISIBLE);

            length.setVisibility(View.INVISIBLE);
            lengthv.setVisibility(View.INVISIBLE);
        }
        else{
            EditText width = (EditText) findViewById(R.id.widthinput);
            TextView widthv = (TextView) findViewById(R.id.widthview);

            EditText height = (EditText) findViewById(R.id.heightinput);
            TextView heightv = (TextView) findViewById(R.id.heightview);
            EditText radius = (EditText) findViewById(R.id.radiusinput);
            TextView radiusv = (TextView) findViewById(R.id.radiusview);


            width.setVisibility(View.INVISIBLE);
            widthv.setVisibility(View.INVISIBLE);

            height.setVisibility(View.INVISIBLE);
            heightv.setVisibility(View.INVISIBLE);
            radius.setVisibility(View.INVISIBLE);
            radiusv.setVisibility(View.INVISIBLE);
        }
    }
    public void move(View view){



        Intent drawshape=null;
        Intent getshape = getIntent();
        String shape = getshape.getStringExtra(Select.SHAPE);

        if(shape.trim().equals("Rekt")) {
            Spinner dropdown = (Spinner)findViewById(R.id.colorspinner);
            EditText height = (EditText) findViewById(R.id.heightinput);
            EditText width = (EditText) findViewById(R.id.widthinput);
            String color = dropdown.getSelectedItem().toString();
            String w = width.getText().toString();
            String h = height.getText().toString();
            drawshape = new Intent(this, Rectangle.class);
            drawshape.putExtra(SHAPE_PARAMS,color+"/"+w+"/"+h);
            width.setText("");
            height.setText("");
        }
        else if (shape.trim().equals("Circle")) {
            Spinner dropdown = (Spinner)findViewById(R.id.colorspinner);
            EditText radius = (EditText) findViewById(R.id.radiusinput);
            String color = dropdown.getSelectedItem().toString();
            String rad = radius.getText().toString();
            drawshape = new Intent(this, Circle.class);
            drawshape.putExtra(SHAPE_PARAMS, color+"/"+rad);
            radius.setText("");
        }
        else {
            EditText stroke = (EditText) findViewById(R.id.strokeinput);
            EditText length = (EditText) findViewById(R.id.lengthinput);
            Spinner dropdown = (Spinner)findViewById(R.id.colorspinner);
            String l = length.getText().toString();
            String st = stroke.getText().toString();
            String color = dropdown.getSelectedItem().toString();
            drawshape = new Intent(this, Line.class);
            drawshape.putExtra(SHAPE_PARAMS,color+"/"+st+"/"+l);
            length.setText("");
            stroke.setText("");
        }





        startActivity(drawshape);
    }

}
