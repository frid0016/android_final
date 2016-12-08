package nineseven.groupproject;

import android.app.Fragment;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.IOException;

public class Auto_Radio_Fragment extends Fragment {

    private ImageButton buttonPlay;
    private ImageButton buttonStop;
    static MediaPlayer mPlayer;
    private Button b1, b2, b3, b4, b5, b6;

    String url2 = "http://server2.crearradio.com:8371";
    String url = "http://powerhitz.powerhitz.com:5040/";
    String url5 = "http://109.71.41.250:8086";
    String url3 = "http://usa1-vn.mixstream.net:9172/";
    String url4 = "http://rs1.radiostreamer.com:8270/";
    String url6 = "http://96.31.90.115:8230";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.auto_radio_fragment, null);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        buttonPlay = (ImageButton) getView().findViewById(R.id.play);
        buttonPlay.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                mPlayer = new MediaPlayer();
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mPlayer.setDataSource(url);
                } catch (IllegalArgumentException e) {
                } catch (SecurityException e) {
                } catch (IllegalStateException e) {
                } catch (IOException e) {
                }
                try {
                    mPlayer.prepare();
                } catch (IllegalStateException e) {
                } catch (IOException e) {
                }
                mPlayer.start();
            }
        });

        b1 = (Button) getView().findViewById(R.id.station1);
        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Snackbar.make(v, "Station 1 selected", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                mPlayer = new MediaPlayer();
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mPlayer.setDataSource(url);
                } catch (IllegalArgumentException e) {
                } catch (SecurityException e) {
                } catch (IllegalStateException e) {
                } catch (IOException e) {
                }
                try {
                    mPlayer.prepare();
                } catch (IllegalStateException e) {
                } catch (IOException e) {
                }
                mPlayer.start();
            }
        });

        b2 = (Button) getView().findViewById(R.id.station2);
        b2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Snackbar.make(v, "Station 2 selected", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                mPlayer = new MediaPlayer();
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mPlayer.setDataSource(url2);
                } catch (IllegalArgumentException e) {
                } catch (SecurityException e) {
                } catch (IllegalStateException e) {
                } catch (IOException e) {
                }
                try {
                    mPlayer.prepare();
                } catch (IllegalStateException e) {
                } catch (IOException e) {
                }
                mPlayer.start();
            }
        });

        b3 = (Button) getView().findViewById(R.id.station3);
        b3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Snackbar.make(v, "Station 3 selected", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                mPlayer = new MediaPlayer();
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mPlayer.setDataSource(url3);
                } catch (IllegalArgumentException e) {
                } catch (SecurityException e) {
                } catch (IllegalStateException e) {
                } catch (IOException e) {
                }
                try {
                    mPlayer.prepare();
                } catch (IllegalStateException e) {
                } catch (IOException e) {
                }
                mPlayer.start();
            }
        });

        b4 = (Button) getView().findViewById(R.id.station4);
        b4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Snackbar.make(v, "Station 4 selected", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                mPlayer = new MediaPlayer();
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mPlayer.setDataSource(url4);
                } catch (IllegalArgumentException e) {
                } catch (SecurityException e) {
                } catch (IllegalStateException e) {
                } catch (IOException e) {
                }
                try {
                    mPlayer.prepare();
                } catch (IllegalStateException e) {
                } catch (IOException e) {
                }
                mPlayer.start();
            }
        });

        b5 = (Button) getView().findViewById(R.id.station5);
        b5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Snackbar.make(v, "Station 5 selected", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                mPlayer = new MediaPlayer();
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mPlayer.setDataSource(url5);
                } catch (IllegalArgumentException e) {
                } catch (SecurityException e) {
                } catch (IllegalStateException e) {
                } catch (IOException e) {
                }
                try {
                    mPlayer.prepare();
                } catch (IllegalStateException e) {
                } catch (IOException e) {
                }
                mPlayer.start();
            }
        });

        b6 = (Button) getView().findViewById(R.id.station6);
        b6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Snackbar.make(v, "Station 6 selected", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                mPlayer = new MediaPlayer();
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mPlayer.setDataSource(url6);
                } catch (IllegalArgumentException e) {
                } catch (SecurityException e) {
                } catch (IllegalStateException e) {
                } catch (IOException e) {
                }
                try {
                    mPlayer.prepare();
                } catch (IllegalStateException e) {
                } catch (IOException e) {
                }
                mPlayer.start();
            }

        });

        buttonStop = (ImageButton) getView().findViewById(R.id.stop);
        buttonStop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (mPlayer != null && mPlayer.isPlaying()) {
                    mPlayer.stop();
                }
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        // TODO Auto-generated method stub
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }
}
