package nineseven.groupproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;

public class RadioActivity extends AppCompatActivity {

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        buttonPlay = (ImageButton) findViewById(R.id.play);
        buttonPlay.setOnClickListener(new OnClickListener() {

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

        b1 = (Button) findViewById(R.id.station1);
        b1.setOnClickListener(new OnClickListener() {

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

        b2 = (Button) findViewById(R.id.station2);
        b2.setOnClickListener(new OnClickListener() {

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

        b3 = (Button) findViewById(R.id.station3);
        b3.setOnClickListener(new OnClickListener() {

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

        b4 = (Button) findViewById(R.id.station4);
        b4.setOnClickListener(new OnClickListener() {

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

        b5 = (Button) findViewById(R.id.station5);
        b5.setOnClickListener(new OnClickListener() {

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

        b6 = (Button) findViewById(R.id.station6);
        b6.setOnClickListener(new OnClickListener() {

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

        buttonStop = (ImageButton) findViewById(R.id.stop);
        buttonStop.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(mPlayer!=null && mPlayer.isPlaying()){
                    mPlayer.stop();
                }
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        // TODO Auto-generated method stub
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_launch_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AlertDialog.Builder builder;
        switch(item.getItemId()) {
            case R.id.House_Menu_Item:
                Intent houseIntent = new Intent(RadioActivity.this, HouseActivity.class);
                startActivity(houseIntent);
                break;
            case R.id.Living_Room_Menu_Item:
                Intent livingRoomIntent = new Intent(RadioActivity.this, LivingRoomActivity.class);
                startActivity(livingRoomIntent);
                break;
            case R.id.Kitchen_Menu_Item:
                Intent kitchenIntent = new Intent(RadioActivity.this, Kitchen_Activity.class);
                startActivity(kitchenIntent);
                break;
            case R.id.Automobile_Menu_Item:
                Intent automobileIntent = new Intent(RadioActivity.this, AutomobileActivity.class);
                startActivity(automobileIntent);
                break;
            case R.id.Help_Menu_Item:
                builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = this.getLayoutInflater();
                builder.setTitle(R.string.dialog_help_title);
                builder.setView(inflater.inflate(R.layout.dialog_radio, null))
                        .setNegativeButton(R.string.dialog_help_button, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
        }
        return true;
    } // end of method onOptionsItemSelected

}
