/* File: Fridge_Fragment.java
 * Course: CST2335
 * Lab Sections: 013 & 015
 * Author: Mahesh Bagde
 * Date: Dec 2017
 * Description: Final Project
 */

package nineseven.groupproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * This class manages the user interaction to manage the settings for a fridge
 */
public class Fridge_Fragment extends Fragment {

    private TextView freezerCurrent;
    private TextView fridgeCurrent;
    private EditText fridgeNewTemperature;
    private EditText freezerNewTemperature;
    private Button setFreezer;
    private Button setFridge;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    public Fridge_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fridge_fragment_layout, container, false);
    } // end of method onCreateView

    // allows the user to set a desired temperature within limits for the
    // fridge and freezer sections

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        freezerCurrent = (TextView) view.findViewById(R.id.Freezer_Value);
        fridgeCurrent = (TextView) view.findViewById(R.id.Fridge_Value);
        freezerNewTemperature = (EditText) view.findViewById(R.id.Set_Freezer_Input);
        fridgeNewTemperature = (EditText) view.findViewById(R.id.Set_Fridge_Input);
        setFreezer = (Button) view.findViewById(R.id.Freezer_Set_Button);
        setFridge = (Button) view.findViewById(R.id.Fridge_Set_Button);

        sharedPreferences = getActivity().getSharedPreferences("FridgeData", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        freezerCurrent.setText(sharedPreferences.getString("freezer", " "));
        fridgeCurrent.setText(sharedPreferences.getString("fridge", " "));

        setFreezer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (Integer.parseInt(freezerNewTemperature.getText().toString()) < -25
                            || Integer.parseInt(freezerNewTemperature.getText().toString()) > -18) {
                        Toast.makeText(getContext(), "Choose a temperature between -18 to -25", Toast.LENGTH_SHORT).show();
                    } else {
                        editor.putString("freezer", freezerNewTemperature.getText().toString());
                        editor.commit();
                        freezerCurrent.setText(sharedPreferences.getString("freezer", " "));

                        Toast.makeText(getContext(), "New temperature set for Freezer", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getContext(), "Please choose a temperature\n between -18 to -25", Toast.LENGTH_SHORT).show();
                }
            } // end onClick
        });

        setFridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (Integer.parseInt(fridgeNewTemperature.getText().toString()) < 0
                            || Integer.parseInt(fridgeNewTemperature.getText().toString()) > 4) {
                        Toast.makeText(getContext(), "Choose a temperature between 0 to 4", Toast.LENGTH_SHORT).show();
                    } else {
                        editor.putString("fridge", fridgeNewTemperature.getText().toString());
                        editor.commit();
                        fridgeCurrent.setText(sharedPreferences.getString("fridge", " "));

                        Toast.makeText(getContext(), "New temperature set for Fridge", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getContext(), "Please choose a temperature\n between 0 to 4", Toast.LENGTH_SHORT).show();
                }
            } // end onClick
        });

    } // end of method onViewCreated

} // end of class Fridge_Fragment
