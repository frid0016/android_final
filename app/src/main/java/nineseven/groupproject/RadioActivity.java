package nineseven.groupproject;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import java.io.IOException;

public class RadioActivity extends AppCompatActivity {

    private ImageButton buttonPlay;
    private ImageButton buttonStopPlay;
    private MediaPlayer player;
    private ProgressBar playSeekBar;
    private Button b1, b2, b3, b4, b5, b6;

    String url1 = "http://server2.crearradio.com:8371";
    String url2 = "http://sc5.radiocaroline.net:8010/";
    String url3 = "http://powerhitz.powerhitz.com:5040/";
    String url4 = "http://usa8-vn.mixstream.net:8138";
    String url5 = "http://usa1-vn.mixstream.net:9172/";
    String url6 = "http://rs1.radiostreamer.com:8270/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        b1 = (Button)findViewById(R.id.station1);
        b2 = (Button)findViewById(R.id.station2);
        b3 = (Button)findViewById(R.id.station3);
        b4 = (Button)findViewById(R.id.station4);
        b5 = (Button)findViewById(R.id.station5);
        b6 = (Button)findViewById(R.id.station6);

        initializeMediaPlayer(url1);

        playSeekBar = (ProgressBar) findViewById(R.id.progressBar);
        playSeekBar.setMax(100);
        playSeekBar.setVisibility(View.INVISIBLE);

        buttonPlay = (ImageButton) findViewById(R.id.play);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startPlaying();
            }
        });

        buttonStopPlay = (ImageButton) findViewById(R.id.stop);
        buttonStopPlay.setEnabled(false);

        buttonStopPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopPlaying();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                initializeMediaPlayer(url2);
                startPlaying();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                initializeMediaPlayer(url3);
                startPlaying();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                initializeMediaPlayer(url4);
                startPlaying();
            }
        });
    }


    private void startPlaying() {
        buttonStopPlay.setEnabled(true);
        buttonPlay.setEnabled(false);

        playSeekBar.setVisibility(View.VISIBLE);

        player.prepareAsync();

        player.setOnPreparedListener(new OnPreparedListener() {

            public void onPrepared(MediaPlayer mp) {
                player.start();
            }
        });

    }

    private void stopPlaying() {
        if (player.isPlaying()) {
            player.stop();
            player.release();
            initializeMediaPlayer(url1);
        }

        buttonPlay.setEnabled(true);
        buttonStopPlay.setEnabled(false);
        playSeekBar.setVisibility(View.INVISIBLE);
    }

    private void initializeMediaPlayer(String url) {
        player = new MediaPlayer();
        try {
            player.setDataSource(url);
            // http://www.surfmusic.de/radio-station/cbc-radio-1,115
            //http://powerhitz.powerhitz.com:5040
            // http://usa8-vn.mixstream.net:8138
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        player.setOnBufferingUpdateListener(new OnBufferingUpdateListener() {
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                playSeekBar.setSecondaryProgress(percent);
                Log.i("Buffering", "" + percent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player.isPlaying()) {
            player.stop();
        }
    }

    private void initializeMediaPlayer2() {
        player = new MediaPlayer();
        try {
            player.setDataSource("http://powerhitz.powerhitz.com:5040/");
            // http://www.surfmusic.de/radio-station/cbc-radio-1,115
            //http://powerhitz.powerhitz.com:5040
            // http://usa8-vn.mixstream.net:8138
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        player.setOnBufferingUpdateListener(new OnBufferingUpdateListener() {
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                playSeekBar.setSecondaryProgress(percent);
                Log.i("Buffering", "" + percent);
            }
        });
    }
}