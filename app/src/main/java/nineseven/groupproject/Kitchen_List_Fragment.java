package nineseven.groupproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Kitchen_List_Fragment extends Fragment {
    private callbacks interfaceObject;

    public Kitchen_List_Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kitchen_list_fragment_layout, container, false);
        String[] kitchenDevices = {"Microwave", "Fridge", "Light"};
        ListView deviceListView = (ListView) view.findViewById(R.id.Device_ListView);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, kitchenDevices);
        deviceListView.setAdapter(adapter);

        deviceListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                interfaceObject.onItemSelected(position);
            } // end of method onItemClick
        });

        return view;
    } // end of method onCreateView

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.interfaceObject = (callbacks) activity;
    } // end of method onAttach

    public interface callbacks {
        void onItemSelected(int position);
    } // end of method callbacks

} // end of class Kitchen_List_Fragment
