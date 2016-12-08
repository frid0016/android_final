/* File: Garage_Fragment.java
 * Course: CST2335
 * Lab Sections: 013 & 015
 * Author: Michael Palmer
 * Date: Dec 2017
 * Description: Final Project
 */

package nineseven.groupproject;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

/**
 * This class extends Fragment and inflates garage door fragment
 */
public class Garage_Fragment extends Fragment{

    ImageView glImageView;
    Bitmap glBitmap;
    Switch glSwitch;

    /**
     * This callback inflates the UI garage_door_fragment
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.garage_door_fragment, null);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        glBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lamp);
        glImageView =(ImageView)getView().findViewById(R.id.glImageView);
        glImageView.setImageBitmap(glBitmap);
        glImageView.setColorFilter(Color.parseColor("#99000000"));
        glSwitch = (Switch) getView().findViewById(R.id.glSwitch);

        Button gdOpenButton = (Button) getView().findViewById(R.id.gdOpenButton);
        Button gdCloseButton = (Button) getView().findViewById(R.id.gdCloseButton);
        final ImageView garageImageView = (ImageView) getView().findViewById(R.id.garageImageView);

        glSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    int color = Color.parseColor("#80ffff00");
                    glImageView.setColorFilter(color);
                }
                else{
                    int color = Color.parseColor("#90000000");
                    glImageView.setColorFilter(color);
                }
            }
        });

        gdOpenButton.setOnClickListener(new View.OnClickListener() {
            boolean isChecked;
            @Override
            public void onClick(View view) {
                garageImageView.setImageResource(R.drawable.garageopen);
                if(!glSwitch.isChecked()){
                    int color = Color.parseColor("#80ffff00");
                    glImageView.setColorFilter(color);
                    glSwitch.toggle();
                }
                Snackbar.make(view, "Garage Door Opens / Garage Light Turns On", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        gdCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                garageImageView.setImageResource(R.drawable.garageclosed);
                Snackbar.make(view, "Garage Door Closes", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    } // end of method onCreate

} // end of class Garage_Fragment