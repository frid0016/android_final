/* File: Outside_Weather_Fragment.java
 * Course: CST2335
 * Lab Sections: 013 & 015
 * Author: Michael Palmer
 * Date: Dec 2017
 * Description: Final Project
 */

package nineseven.groupproject;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This class extends Fragment and inflates outside weather fragment
 */
public class Outside_Weather_Fragment extends Fragment{

    public static final String URL_STRING =
            "http://api.openweathermap.org/data/2.5/weather?q=ottawa,ca&APPID=d99666875e0e51521f0040a3d97d0f6a&mode=xml&units=metric";
    protected static final String ACTIVITY_NAME = "OutsideWeatherActivity";
    ProgressBar pBar;

    /**
     * This callback inflates the UI outside_weather_fragment
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.outside_weather_fragment, null);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        pBar = (ProgressBar) getView().findViewById(R.id.weatherProgBar);
        pBar.setVisibility(View.VISIBLE);

        new ForecastQuery().execute(URL_STRING);
    } // end of method onCreate

    /**
     * This inner class extends AsyncTask and represents a forecast query
     */
    public class ForecastQuery extends AsyncTask<String, Integer, String> {
        String curTemp;
        String minTemp;
        String maxTemp;
        String iconName;
        Bitmap curWeatherImg;
        InputStream inputStream;

        /**
         * This method handles the network connection in background.
         * @param args
         * @return
         */
        @Override
        protected String doInBackground(String... args) {
            try {
                URL url = new URL(URL_STRING);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000);     // milliseconds
                conn.setConnectTimeout(15000);  // milliseconds
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                // Starts the query
                conn.connect();
                inputStream = conn.getInputStream();

                XmlPullParser parser = Xml.newPullParser();
                parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                parser.setInput(inputStream, null);
                parser.nextTag();

                while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
                    if (parser.getEventType() == XmlPullParser.START_TAG) {
                        if (parser.getName().equals("temperature")) {
                            curTemp = parser.getAttributeValue(null, "value");
                            SystemClock.sleep(1000);
                            publishProgress(25);

                            minTemp = parser.getAttributeValue(null, "min");
                            SystemClock.sleep(1000);
                            publishProgress(50);

                            maxTemp = parser.getAttributeValue(null, "max");
                            SystemClock.sleep(1000);
                            publishProgress(75);
                        }
                        if (parser.getName().equals("weather")) {
                            iconName = parser.getAttributeValue(null, "icon");
                            String imgURL = "http://openweathermap.org/img/w/" + iconName + ".png";
                            if (fileExistance(iconName + ".png")) {
                                FileInputStream fileInputStream = getActivity().openFileInput(iconName + ".png");
                                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                                curWeatherImg = BitmapFactory.decodeStream(bufferedInputStream);
                                bufferedInputStream.close();
                                SystemClock.sleep(1000);
                                publishProgress(100);
                                Log.i(ACTIVITY_NAME, "Found " + iconName + ".png locally");
                            } else {
                                curWeatherImg = HTTPUtils.getImage(imgURL);
                                SystemClock.sleep(1000);
                                publishProgress(100);
                                Log.i(ACTIVITY_NAME, "Downloaded " + iconName + ".png");
                                // Save bitmap object to local app storage
                                FileOutputStream fileOutputStream = getActivity().openFileOutput(iconName + ".png", Context.MODE_PRIVATE);
                                curWeatherImg.compress(Bitmap.CompressFormat.PNG, 80, fileOutputStream);
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            }
                        }
                    }
                    parser.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
            return null;
        } // end of method doInBackground

        /**
         * This method sets visibility of progressBar to visible, sets progress of progressBar
         * to variable value[0] being passed in.
         * @param value
         */
        @Override
        protected void onProgressUpdate(Integer... value) {
            pBar.setVisibility(View.VISIBLE);
            pBar.setProgress(value[0]);
        } // end of method onProgressUpdate

        /**
         * This method will update GUI components with min, max, and current temperature read from XML;
         * update ImageView with Bitmap, and set visibility of progress bar to invisible.
         * @param s
         */
        @Override
        protected void onPostExecute(String s) {
            TextView curTempTxtView = (TextView) getView().findViewById(R.id.curTempTxtView);
            curTempTxtView.setText("Cur Temp:  " + curTemp + " °C");

            TextView minTempTxtView = (TextView) getView().findViewById(R.id.minTempTxtView);
            minTempTxtView.setText("Min Temp:  " + minTemp + " °C");

            TextView maxTempTxtView = (TextView) getView().findViewById(R.id.maxTempTxtView);
            maxTempTxtView.setText("Max Temp:  " + maxTemp + " °C");

            ImageView weatherForecastImgView = (ImageView) getView().findViewById(R.id.weatherForecastImgView);
            weatherForecastImgView.setImageBitmap(curWeatherImg);

            pBar.setVisibility(View.INVISIBLE);
        } // end of method onPostExecute

        /**
         * This method checks if cloudy, sunny, raining images are already present in local storage directory.
         * @param fname
         * @return
         */
        public boolean fileExistance(String fname) {
            File file = getActivity().getBaseContext().getFileStreamPath(fname);
            return file.exists();
        } // end of method fileExistance

    } // end of inner class ForecastQuery

} // end of class Outside_Weather_Fragment
