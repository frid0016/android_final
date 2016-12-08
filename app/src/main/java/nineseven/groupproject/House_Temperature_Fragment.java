/* File: House_Temperature_Fragment.java
 * Course: CST2335
 * Lab Sections: 013 & 015
 * Author: Michael Palmer
 * Date: Dec 2017
 * Description: Final Project
 */

package nineseven.groupproject;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This class extends Fragment and inflates house temperature fragment
 */
public class House_Temperature_Fragment extends Fragment{

    TextView curTempValueTV;
    EditText newTempValueET;
    Button htSetButton;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    /**
     * This callback inflates the UI house_temperature_fragment
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.house_temperature_fragment, null);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        curTempValueTV = (TextView) getView().findViewById(R.id.curTempValueTV);
        newTempValueET = (EditText) getView().findViewById(R.id.newTempValueET);
        htSetButton = (Button) getView().findViewById(R.id.htSetButton);
        sharedPreferences = getActivity().getSharedPreferences("temperature", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        curTempValueTV.setText(sharedPreferences.getString("houseTemp", " "));

        htSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (Integer.parseInt(newTempValueET.getText().toString()) < 15
                            || Integer.parseInt((newTempValueET.getText().toString())) > 25) {
                        Toast.makeText(getActivity().getApplicationContext(), "Enter a temperature between 15 and 25", Toast.LENGTH_LONG).show();
                    } else {
                        editor.putString("houseTemp", newTempValueET.getText().toString());
                        editor.commit();
                        curTempValueTV.setText(sharedPreferences.getString("houseTemp", " "));
                        Toast.makeText(getActivity().getApplicationContext(), "House temperature has been set", Toast.LENGTH_LONG).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity().getApplicationContext(), "Enter a temperature between 15 and 25", Toast.LENGTH_LONG).show();
                }
                newTempValueET.setText("");
            }
        });

    } // end of method onActivityCreated

} // end of House_Temperature_Fragment
