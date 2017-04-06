package com.example.debuggablecmakeexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mylibrary.MyLibraryManager;

public class MainActivity extends AppCompatActivity {

    private TextView mHelloTextView;
    private Button openGlButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelloTextView = (TextView) findViewById(R.id.hello_textView);
        mHelloTextView.setText(MyLibraryManager.getInstance().getMsgFromNative());

        openGlButton = (Button) findViewById(R.id.openGL_button);
        openGlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // start openGL Activity
                Intent openGLActivity = new Intent(MainActivity.this, OpenGLActivity.class);
                startActivity(openGLActivity);
            }
        });
    }
}
