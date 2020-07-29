package com.example.music;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageView iv1, iv2;
    Button next;
    TextView tv1;
    MediaPlayer mediaPlayer1, mediaPlayer2, mediaPlayer3;
    String[] song = {"Imagination", "Despasito", "Love Me Like You Do"};
    LinearLayout layout;
    int position;
    SeekBar bar1,bar2,bar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1 = findViewById(R.id.play);
        iv2 = findViewById(R.id.pause);
        next = findViewById(R.id.next);
        bar1=findViewById(R.id.seekBar1);
        bar2=findViewById(R.id.seekBar2);
        bar3=findViewById(R.id.seekBar3);
        tv1 = findViewById(R.id.song_name);
        layout = (LinearLayout) findViewById(R.id.song_lay);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.track1);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.track2);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.trac3);
        bar1.setVisibility(View.GONE);
        bar2.setVisibility(View.GONE);
        bar3.setVisibility(View.GONE);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar1.setVisibility(View.GONE);
                bar2.setVisibility(View.GONE);
                bar3.setVisibility(View.GONE);

                onobject();

                final AlertDialog.Builder mbuild = new AlertDialog.Builder(MainActivity.this);
                mbuild.setTitle("Choose a song")
                        .setSingleChoiceItems(song, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                position = which;

                            }
                        })

                        .setPositiveButton("Play", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (position == 0) {
                                    mediaPlayer1.start();
                                    bar1.setVisibility(View.VISIBLE);
                                    bar1.setMax(mediaPlayer1.getDuration());
                                    Timer t1=new Timer();
                                    t1.scheduleAtFixedRate(new TimerTask() {
                                        @Override
                                        public void run() {
                                            bar1.setProgress(mediaPlayer1.getCurrentPosition());
                                        }
                                    },0,300);


                                } else if (position == 1) {
                                    mediaPlayer2.start();
                                    bar2.setVisibility(View.VISIBLE);
                                    bar2.setMax(mediaPlayer1.getDuration());
                                    Timer t2=new Timer();
                                    t2.scheduleAtFixedRate(new TimerTask() {
                                        @Override
                                        public void run() {
                                            bar2.setProgress(mediaPlayer2.getCurrentPosition());
                                        }
                                    },0,300);

                                } else {
                                    mediaPlayer3.start();
                                    bar3.setVisibility(View.VISIBLE);
                                    bar3.setMax(mediaPlayer1.getDuration());
                                    Timer t3=new Timer();
                                    t3.scheduleAtFixedRate(new TimerTask() {
                                        @Override
                                        public void run() {
                                            bar3.setProgress(mediaPlayer3.getCurrentPosition());
                                        }
                                    },0,300);

                                }


                                tv1.setText(song[position]);

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.cancel();

                            }
                        });
                AlertDialog dilog = mbuild.create();
                dilog.show();


            }

        });

        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer1.isPlaying()) {
                    mediaPlayer1.pause();
                }
                if (mediaPlayer2.isPlaying()) {
                    mediaPlayer2.pause();
                }
                if (mediaPlayer3.isPlaying()) {
                    mediaPlayer3.pause();
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer1.isPlaying()) {
                    mediaPlayer1.pause();
                }
                if (mediaPlayer2.isPlaying()) {
                    mediaPlayer2.pause();
                }
                if (mediaPlayer3.isPlaying()) {
                    mediaPlayer3.pause();
                }

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("code", position);
                startActivity(intent);
            }
        });


    }

    private void onobject() {
        if (mediaPlayer1.isPlaying()) {
            mediaPlayer1.stop();
            bar1.setProgress(0);
            mediaPlayer1 = MediaPlayer.create(this, R.raw.track1);
        } else {

            if (mediaPlayer1 == null) {
                mediaPlayer1 = MediaPlayer.create(this, R.raw.track1);
            }
        }
        if (mediaPlayer2.isPlaying()) {
            mediaPlayer2.stop();
            bar2.setProgress(0);
            mediaPlayer2 = MediaPlayer.create(this, R.raw.track2);

        } else {

            if (mediaPlayer2 == null) {
                mediaPlayer2 = MediaPlayer.create(this, R.raw.track1);
            }

        }
        if (mediaPlayer3.isPlaying()) {
            mediaPlayer3.stop();
            bar3.setProgress(0);
            mediaPlayer3 = MediaPlayer.create(this, R.raw.trac3);

        } else {
            if (mediaPlayer3 == null) {
                mediaPlayer3 = MediaPlayer.create(this, R.raw.track1);
            }

        }
    }


}
