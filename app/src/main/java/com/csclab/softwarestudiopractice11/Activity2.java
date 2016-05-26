package com.csclab.softwarestudiopractice11;

import android.app.Activity;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;


public class Activity2 extends Activity {

    private TextView nameText;
    private ImageView dino;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getIntent().getExtras();
        String name = bundle.getString("name");

        setContentView(R.layout.activity_2);
        nameText = (TextView) findViewById(R.id.nameTextView);
        nameText.setText("Welcome " + name);
        dino = (ImageView) findViewById(R.id.imageView);
        dino.setImageResource(R.drawable.dino);
        dino.setOnTouchListener(imgListener);
        /** To Do:
         * (1) Find the UI element on xml file
         * (2) Use Bundle to retrieve name string
         * (3) Display "Welcome 'username' "
         * (4) Set image resource (Hint: drawable) and its touch listener **/

    }

    private OnTouchListener imgListener = new OnTouchListener() {
        private float x, y; //The x, y position that image exist
        private int mx, my; // The distance from original position to finger dragging

        /** To Do:
         * (1) Handle different touch events in onTouch method
         * (2) You can use v.layout() to change dinosaur's position
         * Hint: The event you may encounter: ACTION_DOWN & ACTION_MOVE **/

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: //ACTION_DOWN
                    x = event.getX();
                    y = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE: //ACTION_MOVE
                    mx = (int) (event.getRawX() - x);
                    my = (int) (event.getRawY() - 50 - y);
                    v.layout(mx, my, mx+v.getWidth(), my+v.getHeight());

                    break;

            }
            return true;
        }
    };


}
