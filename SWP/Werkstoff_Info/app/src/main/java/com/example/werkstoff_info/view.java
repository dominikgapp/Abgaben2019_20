package com.example.werkstoff_info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class view extends AppCompatActivity {

    private WebView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        view = findViewById(R.id.view);
        view.setWebViewClient(new WebViewClient());
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl("https://placing-you.de/blog/post/10-tipps-zum-frasen");

        //https://www.urnitsch.at/prospekte/MillerFräsen.pdf
        //https://developer.android.com

    }



    float x1, x2, y1, y2;
    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if (x1<x2){
                    Intent i = new Intent(view.this, MainActivity.class);
                    startActivity(i);
                }
                break;
        }

        return false;
    }

}
