package com.csclab.softwarestudiopractice11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Button send;
    private EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** To Do:
         * (1) Find the UI element on xml file
         * **/
        this.send = (Button) findViewById(R.id.button);
        this.edt = (EditText) findViewById(R.id.enterName);

        send.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View view)
            {
                sendName();
            }
        });

    }

    public void sendName(){

        String name = this.edt.getText().toString();
        /** To Do:
         * (1) Use intent and Bundle to pass string
         * (2) Change activity to Activity2
         * **/
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, Activity2.class);
        Bundle bundle = new Bundle();

        bundle.putString("name", name);
        intent.putExtras(bundle);
        startActivity(intent);
    }



}
