package nineseven.groupproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;

public class LightsActivity extends AppCompatActivity {

    SeekBar seekBar;
    ImageView imgView1, imgView2, imgView3;
    Bitmap bitmap1, bitmap2, bitmap3;
    Switch car_switch1, car_switch2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights);

        seekBar = (SeekBar) findViewById(R.id.seekBar_car);

        bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.normallight);
        bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.headlight);
        bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.lamp);

        imgView1 = (ImageView)findViewById(R.id.normal_light);
        imgView1.setImageBitmap(bitmap1);
        imgView1.setColorFilter(Color.parseColor("#99000000"));

        imgView2 = (ImageView)findViewById(R.id.high_light);
        imgView2.setImageBitmap(bitmap2);
        imgView2.setColorFilter(Color.parseColor("#99000000"));

        imgView3 = (ImageView)findViewById(R.id.car_light);
        imgView3.setImageBitmap(bitmap3);

        car_switch1 = (Switch)findViewById(R.id.switch_normal);
        car_switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    int color = Color.parseColor("#ffff00"); //The color u want
                    imgView1.setColorFilter(color);
                }
                else{
                    int color = Color.parseColor("#90000000");
                    imgView1.setColorFilter(color);
                }

            }
        });

        car_switch2 = (Switch)findViewById(R.id.switch_high);
        car_switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    int color = Color.parseColor("#ffff00");
                    imgView2.setColorFilter(color);
                }
                else{
                    int color = Color.parseColor("#90000000");
                    imgView2.setColorFilter(color);
                }

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                imgView3.setColorFilter(setBrightness(progress));
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

            return new PorterDuffColorFilter(Color.argb(value, 255, 255, 255), PorterDuff.Mode.SRC_OVER);

        }
        else
        {
            int value = (int) (100-progress) * 255 / 100;
            return new PorterDuffColorFilter(Color.argb(value, 0, 0, 0), PorterDuff.Mode.SRC_ATOP);


        }
    }

}
