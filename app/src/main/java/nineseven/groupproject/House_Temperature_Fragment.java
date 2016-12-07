/* File: House_Temperature_Fragment.java
 * Course: CST2335
 * Lab Sections: 013 & 015
 * Author: Michael Palmer
 * Date: Dec 2017
 * Description: Final Project
 */

package nineseven.groupproject;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * This class extends Fragment and inflates house temperature fragment
 */
public class House_Temperature_Fragment extends Fragment{

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

}
