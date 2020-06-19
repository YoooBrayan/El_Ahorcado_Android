package com.example.el_ahorcado;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );

        params.setMargins(15, 1185, 15, 5);
        relativeLayout.setLayoutParams(params);
        setContentView(relativeLayout);

        int le = 0;
        int top = 0;

        for(int i=65; i<91; i++){


            Button bn = new Button(this);
            RelativeLayout.LayoutParams bns = new RelativeLayout.LayoutParams(125, 125);

            if(le>920){
                le = 0;
                top = top + 105;
            }

            bns.setMargins(le, top, 0, 0);
            bn.setLayoutParams(bns);
            bn.setText(Character.toString((char) i));
            relativeLayout.addView(bn);
            le = le + 115;

        }

        /*Button bn = new Button(this);
        RelativeLayout.LayoutParams bns = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        bns.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        bns.setMargins(0, 55, 0, 0);
        bn.setLayoutParams(bns);
        bn.setText("A");

        Button bn1 = new Button(this);
        RelativeLayout.LayoutParams bns1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        bns1.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        bns1.setMargins(135, 55, 0, 0);
        bn1.setLayoutParams(bns1);
        bn1.setText("B");

        relativeLayout.addView(bn);
        relativeLayout.addView(bn1);*/

    }
}
