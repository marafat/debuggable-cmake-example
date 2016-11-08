package com.example.debuggablecmakeexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mylibrary.MyLibraryManager;

public class MainActivity extends AppCompatActivity {

    private TextView mHelloTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelloTextView = (TextView) findViewById(R.id.hello_textView);
        mHelloTextView.setText(MyLibraryManager.getInstance().getMsgFromNative());
    }
}
