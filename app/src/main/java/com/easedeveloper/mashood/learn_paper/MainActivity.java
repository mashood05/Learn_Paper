package com.easedeveloper.mashood.learn_paper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText enter;
    Button clickme;
    TextView showTex;
    public static final String TAG_NAME = "GET_VALUE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enter = (EditText) findViewById(R.id.editText);
        clickme = (Button) findViewById(R.id.button);
        showTex = (TextView) findViewById(R.id.textview);


        clickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTex.setText(enter.getText().toString());
            }
        });


        clickme.setOnClickListener((v) -> {
            showTex.setText("max");
        });

        if (savedInstanceState != null) {
            String getName = savedInstanceState.getString(TAG_NAME);
            showTex.setText(getName.toString());

        } else {
            Toast.makeText(this, "new Entry", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString(TAG_NAME, showTex.getText().toString());

        super.onSaveInstanceState(outState);
    }
}
