package com.jikexueyuan.playmp3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPlayRaw;
    private Button btnStop;
    private Button btnPlayIntent;
    private Button btnPlaySource;
    private MediaPlayer mediaPlayer;
    private String fileName = "music.map3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlayRaw = (Button) findViewById(R.id.btnPlayRaw);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnPlayIntent = (Button) findViewById(R.id.btnPlayIntent);
        btnPlaySource = (Button) findViewById(R.id.btnPlaySource);

        btnPlayRaw.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnPlayIntent.setOnClickListener(this);
        btnPlaySource.setOnClickListener(this);

        if (!fileExist(fileName)){
            copyToMobile(fileName);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPlayRaw:
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.music);
                    mediaPlayer.start();
                }
                break;
            case R.id.btnStop:
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
                break;
            case R.id.btnPlayIntent:
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setDataAndType(Uri.parse("file://" + getDir() + fileName),"audio/mp3");
                startActivity(i);
                break;
            case R.id.btnPlaySource:
                if (mediaPlayer == null) {
                    mediaPlayer = new MediaPlayer();
                    try {
                        mediaPlayer.setDataSource(getDir() + fileName);
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    //---------------拷贝mp3到手机中-----------------
    private String getDir(){
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/myplayer/";
    }

    private boolean fileExist(String fileName){
        File file = new File(getDir() + fileName);
        return file.exists();
//        if (file.exists())
//            return true;
//        return false;
    }

    private void copyToMobile(final String fileName){

        new Thread(){
            @Override
            public void run() {
                super.run();

                File dir = new File(getDir());
                if (!dir.exists()){
                    dir.mkdir();
                }

                InputStream is = null;//用于读取文件中的数据流
                OutputStream os = null;//用于把数据写入到文件中
                //从资源文件中获取到raw下的music.mp3到输入流，用来读取文件
                is = getResources().openRawResource(R.raw.music);
                //创建一个被写入数据的文件
                File to = new File(getDir(),fileName);

                try {
                    //创建一个文件输出流来把数据写入文件
                    os = new FileOutputStream(to);

                    byte[] buf = new byte[4096];
                    while (true){
                        int r = is.read(buf);
                        if (r == -1){
                            break;
                        }
                        os.write(buf);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (os != null){
                        try {
                            os.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (is != null){
                        try {
                            is.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
    }
}
