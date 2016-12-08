package nineseven.groupproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Auto_Temp_Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.auto_temp_fragment, null);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button set1 = (Button) getView().findViewById(R.id.button_front);
        Button set2 = (Button) getView().findViewById(R.id.button_back);

        set1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Front temperature is set", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        set2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Back temperature is set", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    } // end of method onCreate

}
