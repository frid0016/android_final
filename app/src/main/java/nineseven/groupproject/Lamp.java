package nineseven.groupproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuffColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.graphics.PorterDuff.Mode;
import android.widget.Switch;

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
            }
        });

        red.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = Color.parseColor("#80ff0000"); //The color u want
                imgView3.setColorFilter(color);
            }
        });

        blue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = Color.parseColor("#804793cb"); //The color u want
                imgView3.setColorFilter(color);
            }
        });

        purple.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = Color.parseColor("#80800080"); //The color u want
                imgView3.setColorFilter(color);
            }
        });

        lamp_switch = (Switch)findViewById(R.id.switch_lamp);
        lamp_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    int color = Color.parseColor("#80ffff00"); //The color u want
                    imgView1.setColorFilter(color);
                }
                else{
                    int color = Color.parseColor("#90000000");
                    imgView1.setColorFilter(color);
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

}