/* File: OutsideWeatherActivity.java
 * Course: CST2335
 * Lab Sections: 013 & 015
 * Author: Michael Palmer
 * Date: Dec 2017
 * Description: Final Project
 */

package nineseven.groupproject;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
 * This class extends AppCompatActivity and represents an outside weather activity.
 */
public class OutsideWeatherActivity extends AppCompatActivity {

    public static final String URL_STRING =
            "http://api.openweathermap.org/data/2.5/weather?q=ottawa,ca&APPID=d99666875e0e51521f0040a3d97d0f6a&mode=xml&units=metric";
    protected static final String ACTIVITY_NAME = "OutsideWeatherActivity";
    ProgressBar pBar;

    /**
     * This method initializes outside weather activity, sets layout, handles
     * progress bar, instantiates and executes inner class ForecastQuery.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outside_weather);

        pBar = (ProgressBar)findViewById(R.id.weatherProgBar);
        pBar.setVisibility(View.VISIBLE);

        new ForecastQuery().execute(URL_STRING);
    } // end of method onCreate

    /**
     * This method inflates menu resource from xml layout.
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_launch_screen, menu);
        return true;
    } // end of method onCreateOptionsMenu

    /**
     * This method handles the case when an item ID is selected,
     * inflates appropriate help dialog
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AlertDialog.Builder builder;
        switch(item.getItemId()) {
            case R.id.House_Menu_Item:
                Intent houseIntent = new Intent(OutsideWeatherActivity.this, HouseActivity.class);
                startActivity(houseIntent);
                break;
            case R.id.Living_Room_Menu_Item:
                Intent livingRoomIntent = new Intent(OutsideWeatherActivity.this, LivingRoomActivity.class);
                startActivity(livingRoomIntent);
                break;
            case R.id.Kitchen_Menu_Item:
                Intent kitchenIntent = new Intent(OutsideWeatherActivity.this, Kitchen_Activity.class);
                startActivity(kitchenIntent);
                break;
            case R.id.Automobile_Menu_Item:
                Intent automobileIntent = new Intent(OutsideWeatherActivity.this, AutomobileActivity.class);
                startActivity(automobileIntent);
                break;
            case R.id.Help_Menu_Item:
                builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = this.getLayoutInflater();
                builder.setTitle(R.string.dialog_help_title);
                builder.setView(inflater.inflate(R.layout.dialog_outside_weather, null))
                        .setNegativeButton(R.string.dialog_help_button, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
        }
        return true;
    } // end of method onOptionsItemSelected

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
                                FileInputStream fileInputStream = openFileInput(iconName + ".png");
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
                                FileOutputStream fileOutputStream = openFileOutput(iconName + ".png", Context.MODE_PRIVATE);
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
            TextView curTempTxtView = (TextView) findViewById(R.id.curTempTxtView);
            curTempTxtView.setText("Cur Temp:  " + curTemp + " °C");

            TextView minTempTxtView = (TextView) findViewById(R.id.minTempTxtView);
            minTempTxtView.setText("Min Temp:  " + minTemp + " °C");

            TextView maxTempTxtView = (TextView) findViewById(R.id.maxTempTxtView);
            maxTempTxtView.setText("Max Temp:  " + maxTemp + " °C");

            ImageView weatherForecastImgView = (ImageView) findViewById(R.id.weatherForecastImgView);
            weatherForecastImgView.setImageBitmap(curWeatherImg);

            pBar.setVisibility(View.INVISIBLE);
        } // end of method onPostExecute

        /**
         * This method checks if cloudy, sunny, raining images are already present in local storage directory.
         * @param fname
         * @return
         */
        public boolean fileExistance(String fname) {
            File file = getBaseContext().getFileStreamPath(fname);
            return file.exists();
        } // end of method fileExistance

    } // end of inner class ForecastQuery

} // end of class OutsideWeatherActivity
