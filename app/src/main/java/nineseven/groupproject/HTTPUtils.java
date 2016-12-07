/* File: HTTPUtils.java
 * Course: CST2335
 * Lab Sections: 013 & 015
 * Author: Michael Palmer
 * Date: Dec 2017
 * Description: Final Project
 */

package nineseven.groupproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPUtils {

    public static Bitmap getImage(URL url) {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                return BitmapFactory.decodeStream(connection.getInputStream());
            } else
                return null;
            // } catch (IOException e) {
        } catch (Exception e) {
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    } // end of method getImage(URL url)

    public static Bitmap getImage(String urlString) {
        try {
            URL url = new URL(urlString);
            return getImage(url);
        } catch (MalformedURLException e) {
            return null;
        }
    } // end of method getImage(String urlString)

} // end of class HTTPUtils
