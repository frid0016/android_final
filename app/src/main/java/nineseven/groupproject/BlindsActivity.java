package nineseven.groupproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class BlindsActivity extends AppCompatActivity {

    SeekBar seekBar;
    ImageView imgView1;
    Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blinds);



        bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.liv);
        imgView1=(ImageView)findViewById(R.id.imgroom);
        imgView1.setImageBitmap(bitmap);

        seekBar= (SeekBar) findViewById(R.id.roomseekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                imgView1.setColorFilter(setBrightness(progress));
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
