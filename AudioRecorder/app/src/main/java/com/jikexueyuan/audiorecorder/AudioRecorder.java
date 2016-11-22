package com.jikexueyuan.audiorecorder;

import android.media.MediaRecorder;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2015/12/23 0023.
 */
public class AudioRecorder {

    private String dir;
    private String fileName;
    private MediaRecorder mediaRecorder;

    public AudioRecorder(){

        dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/myrecorder/";

    }

    public void start() throws IOException {

        String state = Environment.getExternalStorageState();
        if (!state.equals(Environment.MEDIA_MOUNTED)){
            throw new IOException("没有可用的存储空间");
        }

        File myDir = new File(dir);
        if (!myDir.exists()){
            myDir.mkdir();
        }

        fileName = dir + System.currentTimeMillis() + ".amr";

        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mediaRecorder.setAudioSamplingRate(8000);
        mediaRecorder.setOutputFile(fileName);
        mediaRecorder.prepare();
        mediaRecorder.start();

    }

    public void stop(){

        if (mediaRecorder != null){
            mediaRecorder.stop();
            mediaRecorder.release();
            mediaRecorder = null;
        }

    }

    public String getPath(){
        return fileName;
    }
}
