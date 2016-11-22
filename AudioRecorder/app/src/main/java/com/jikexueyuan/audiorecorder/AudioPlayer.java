package com.jikexueyuan.audiorecorder;

import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by Administrator on 2015/12/23 0023.
 */
public class AudioPlayer {

    private MediaPlayer mediaPlayer;
    private String playerPath;

    public AudioPlayer() {

    }

    public void setPlayerPath(String playerPath) {
        this.playerPath = playerPath;
    }

    public void play() {

        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
        }
        try {
            mediaPlayer.setDataSource(playerPath);
            mediaPlayer.prepare();
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer = null;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
