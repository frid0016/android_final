package nineseven.groupproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuffColorFilter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.graphics.PorterDuff.Mode;
import android.widget.Switch;
import android.widget.Toast;

public class Lamp extends AppCompatActivity {

    SeekBar seekBar;
    ImageView imgView2, imgView1, imgView3;
    Bitmap bitmap;
    Switch lamp_switch;
    Button green, red, blue, purple;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamp);

        green = (Button)findViewById(R.id.green_light);
        red =  (Button)findViewById(R.id.red_light);
        blue =  (Button)findViewById(R.id.blue_light);
        purple =  (Button)findViewById(R.id.purple_light);

        bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.lamp);

        imgView2=(ImageView)findViewById(R.id.lamp2);
        imgView2.setImageBitmap(bitmap);

        imgView1=(ImageView)findViewById(R.id.lamp1);
        imgView1.setImageBitmap(bitmap);
        imgView1.setColorFilter(Color.parseColor("#99000000"));

        imgView3=(ImageView)findViewById(R.id.lamp3);
        imgView3.setImageBitmap(bitmap);

        seekBar= (SeekBar) findViewById(R.id.seekBar_lamp);

        green.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = Color.parseColor("#80008000"); //The color u want
                imgView3.setColorFilter(color);
                Toast.makeText(getApplicationContext(), "Green light on", Toast.LENGTH_LONG).show();
            }
        });

        red.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = Color.parseColor("#80ff0000"); //The color u want
                imgView3.setColorFilter(color);
                Toast.makeText(getApplicationContext(), "Red light on", Toast.LENGTH_LONG).show();
            }
        });

        blue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = Color.parseColor("#804793cb"); //The color u want
                imgView3.setColorFilter(color);
                Toast.makeText(getApplicationContext(), "Blue light on", Toast.LENGTH_LONG).show();
            }
        });

        purple.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = Color.parseColor("#80800080"); //The color u want
                imgView3.setColorFilter(color);
                Toast.makeText(getApplicationContext(), "Purple light on", Toast.LENGTH_LONG).show();
            }
        });

        lamp_switch = (Switch)findViewById(R.id.switch_lamp);
        lamp_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    int color = Color.parseColor("#80ffff00"); //The color u want
                    imgView1.setColorFilter(color);
                    Toast.makeText(getApplicationContext(), "Standard light on", Toast.LENGTH_LONG).show();
                }
                else{
                    int color = Color.parseColor("#90000000");
                    imgView1.setColorFilter(color);
                    Toast.makeText(getApplicationContext(), "Standard light off", Toast.LENGTH_LONG).show();
                }

            }
         });


    seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                imgView2.setColorFilter(setBrightness(progress));
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }

    public static PorterDuffColorFilter setBrightness(int progress) {
        if (progress >=	100)
        {
            int value = (int) (progress-100) * 255 / 100;

            return new PorterDuffColorFilter(Color.argb(value, 255, 255, 255), Mode.SRC_OVER);

        }
        else
        {
            int value = (int) (100-progress) * 255 / 100;
            return new PorterDuffColorFilter(Color.argb(value, 0, 0, 0), Mode.SRC_ATOP);


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
                Intent houseIntent = new Intent(Lamp.this, HouseActivity.class);
                startActivity(houseIntent);
                break;
            case R.id.Living_Room_Menu_Item:
                Intent livingRoomIntent = new Intent(Lamp.this, LivingRoomActivity.class);
                startActivity(livingRoomIntent);
                break;
            case R.id.Kitchen_Menu_Item:
                Intent kitchenIntent = new Intent(Lamp.this, Kitchen_Activity.class);
                startActivity(kitchenIntent);
                break;
            case R.id.Automobile_Menu_Item:
                Intent automobileIntent = new Intent(Lamp.this, AutomobileActivity.class);
                startActivity(automobileIntent);
                break;
            case R.id.Help_Menu_Item:
                builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = this.getLayoutInflater();
                builder.setTitle(R.string.dialog_help_title);
                builder.setView(inflater.inflate(R.layout.dialog_lamp, null))
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
