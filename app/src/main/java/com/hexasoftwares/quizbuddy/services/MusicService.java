package com.hexasoftwares.quizbuddy.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.hexasoftwares.quizbuddy.R;

public class MusicService extends Service {
    MediaPlayer myPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        myPlayer = MediaPlayer.create(this, R.raw.closer);
        myPlayer.setLooping(false); // Set looping
    }

    @Override
    public void onStart(Intent intent, int startid) {
        if(!myPlayer.isPlaying()){
            myPlayer.start();
        }
    }

    @Override
    public void onDestroy() {
        myPlayer.stop();
    }
}