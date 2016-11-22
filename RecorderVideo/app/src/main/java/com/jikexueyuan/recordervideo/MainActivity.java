package com.jikexueyuan.recordervideo;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnRecorder,btnPlay;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRecorder = (Button) findViewById(R.id.btnRecorder);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        videoView = (VideoView) findViewById(R.id.videoView);

        btnRecorder.setOnClickListener(this);
        btnPlay.setOnClickListener(this);

    }

    private final int VIDEO_RECORDER = 1;
    private Uri outPutUri;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRecorder:

                //自定义存储
                File file = new File(Environment.getExternalStorageDirectory(),"myRecorder.mp4");
                outPutUri = Uri.fromFile(file);

                Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

                i.putExtra(MediaStore.EXTRA_OUTPUT,outPutUri);//*********自定义需要加上！！！！！**********

                startActivityForResult(i, VIDEO_RECORDER);
                break;
            case R.id.btnPlay:
                videoView.setVideoURI(outPutUri);
                videoView.start();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
//            outPutUri = data.getData();//自定义时不需要这一句
        }
    }
}
