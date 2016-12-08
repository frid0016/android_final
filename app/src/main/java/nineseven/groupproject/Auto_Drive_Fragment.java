package nineseven.groupproject;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Auto_Drive_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.auto_drive_fragment, null);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button save = (Button) getView().findViewById(R.id.save);
        Button reset = (Button) getView().findViewById(R.id.reset);
        Button save_fuel = (Button) getView().findViewById(R.id.save_fuel);
        Button fill = (Button) getView().findViewById(R.id.fill_tank);

        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                        Toast.makeText(getActivity().getApplicationContext(), "Number of km saved", Toast.LENGTH_LONG).show();
                    }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "Total km is 0", Toast.LENGTH_LONG).show();
            }
        });

        save_fuel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                        Toast.makeText(getActivity().getApplicationContext(), "Fuel Level Saved", Toast.LENGTH_LONG).show();

            }
        });

        fill.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "Fuel level is 70", Toast.LENGTH_LONG).show();
            }
        });
    }

}