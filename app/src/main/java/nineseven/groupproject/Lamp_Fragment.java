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
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

public class Lamp_Fragment extends Fragment {

    SeekBar seekBar;
    ImageView imgView2, imgView1, imgView3;
    Bitmap bitmap;
    Switch lamp_switch;
    Button green, red, blue, purple;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lamp_fragment, null);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.lamp);

        green = (Button)getView().findViewById(R.id.green_light);
        red =  (Button)getView().findViewById(R.id.red_light);
        blue =  (Button)getView().findViewById(R.id.blue_light);
        purple =  (Button)getView().findViewById(R.id.purple_light);

        bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.lamp);

        imgView2=(ImageView)getView().findViewById(R.id.lamp2);
        imgView2.setImageBitmap(bitmap);

        imgView1=(ImageView)getView().findViewById(R.id.lamp1);
        imgView1.setImageBitmap(bitmap);
        imgView1.setColorFilter(Color.parseColor("#99000000"));

        imgView3=(ImageView)getView().findViewById(R.id.lamp3);
        imgView3.setImageBitmap(bitmap);

        seekBar= (SeekBar) getView().findViewById(R.id.seekBar_lamp);

        green.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = Color.parseColor("#80008000"); //The color u want
                imgView3.setColorFilter(color);
                Toast.makeText(getActivity().getApplicationContext(), "Green light on", Toast.LENGTH_LONG).show();
            }
        });

        red.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = Color.parseColor("#80ff0000"); //The color u want
                imgView3.setColorFilter(color);
                Toast.makeText(getActivity().getApplicationContext(), "Red light on", Toast.LENGTH_LONG).show();
            }
        });

        blue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = Color.parseColor("#804793cb"); //The color u want
                imgView3.setColorFilter(color);
                Toast.makeText(getActivity().getApplicationContext(), "Red light on", Toast.LENGTH_LONG).show();
            }
        });

        purple.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = Color.parseColor("#80800080"); //The color u want
                imgView3.setColorFilter(color);
                Toast.makeText(getActivity().getApplicationContext(), "Purple light on", Toast.LENGTH_LONG).show();
            }
        });

        lamp_switch = (Switch)getView().findViewById(R.id.switch_lamp);
        lamp_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    int color = Color.parseColor("#80ffff00"); //The color u want
                    imgView1.setColorFilter(color);
                    Toast.makeText(getActivity().getApplicationContext(), "Standard light on", Toast.LENGTH_LONG).show();
                }
                else{
                    int color = Color.parseColor("#90000000");
                    imgView1.setColorFilter(color);
                    Toast.makeText(getActivity().getApplicationContext(), "Standard light off", Toast.LENGTH_LONG).show();
                }

            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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

            return new PorterDuffColorFilter(Color.argb(value, 255, 255, 255), PorterDuff.Mode.SRC_OVER);

        }
        else
        {
            int value = (int) (100-progress) * 255 / 100;
            return new PorterDuffColorFilter(Color.argb(value, 0, 0, 0), PorterDuff.Mode.SRC_ATOP);


        }
    }

}