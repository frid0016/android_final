package nineseven.groupproject;


import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

public class Auto_Lights_Fragment extends Fragment {

    SeekBar seekBar;
    ImageView imgView1, imgView2, imgView3;
    Bitmap bitmap1, bitmap2, bitmap3;
    Switch car_switch1, car_switch2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.auto_lights_fragment, null);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        seekBar = (SeekBar) getView().findViewById(R.id.seekBar_car);

        bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.normallight);
        bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.headlight);
        bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.lamp);

        imgView1 = (ImageView) getView().findViewById(R.id.normal_light);
        imgView1.setImageBitmap(bitmap1);
        imgView1.setColorFilter(Color.parseColor("#99000000"));

        imgView2 = (ImageView) getView().findViewById(R.id.high_light);
        imgView2.setImageBitmap(bitmap2);
        imgView2.setColorFilter(Color.parseColor("#99000000"));

        imgView3 = (ImageView) getView().findViewById(R.id.car_light);
        imgView3.setImageBitmap(bitmap3);

        car_switch1 = (Switch) getView().findViewById(R.id.switch_normal);
        car_switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    int color = Color.parseColor("#ffff00"); //The color u want
                    imgView1.setColorFilter(color);
                    Toast.makeText(getActivity().getApplicationContext(), "Normal headlights on", Toast.LENGTH_LONG).show();
                } else {
                    int color = Color.parseColor("#90000000");
                    imgView1.setColorFilter(color);
                    Toast.makeText(getActivity().getApplicationContext(), "Normal headlights off", Toast.LENGTH_LONG).show();
                }

            }
        });

        car_switch2 = (Switch) getView().findViewById(R.id.switch_high);
        car_switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    int color = Color.parseColor("#ffff00");
                    imgView2.setColorFilter(color);
                    Toast.makeText(getActivity().getApplicationContext(), "High headlights on", Toast.LENGTH_LONG).show();
                } else {
                    int color = Color.parseColor("#90000000");
                    imgView2.setColorFilter(color);
                    Toast.makeText(getActivity().getApplicationContext(), "High headlights off", Toast.LENGTH_LONG).show();
                }

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
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
        if (progress >= 100) {
            int value = (int) (progress - 100) * 255 / 100;

            return new PorterDuffColorFilter(Color.argb(value, 255, 255, 255), PorterDuff.Mode.SRC_OVER);

        } else {
            int value = (int) (100 - progress) * 255 / 100;
            return new PorterDuffColorFilter(Color.argb(value, 0, 0, 0), PorterDuff.Mode.SRC_ATOP);


        }
    }
}