package com.jikexueyuan.audiorecorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnRecorder, btnStopRecorder, btnPlayRecorder;
    private AudioRecorder myRecorder;
    private AudioPlayer myPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRecorder = (Button) findViewById(R.id.btnRecorder);
        btnStopRecorder = (Button) findViewById(R.id.btnStopRecorder);
        btnPlayRecorder = (Button) findViewById(R.id.btnPlayRecorder);

        btnRecorder.setOnClickListener(this);
        btnStopRecorder.setOnClickListener(this);
        btnPlayRecorder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRecorder:
                if (myRecorder == null){
                    myRecorder = new AudioRecorder();
                }
                try {
                    myRecorder.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnStopRecorder:
                if (myRecorder != null){
                    myRecorder.stop();
                }
                break;
            case R.id.btnPlayRecorder:
                if (myPlayer == null){
                    myPlayer = new AudioPlayer();
                    myPlayer.setPlayerPath(myRecorder.getPath());
                }
                myPlayer.play();
                break;
        }
    }
}
