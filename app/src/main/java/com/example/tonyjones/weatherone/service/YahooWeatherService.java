package com.example.tonyjones.weatherone.service;

import android.net.Uri;
import android.os.AsyncTask;

import com.example.tonyjones.weatherone.data.Channel;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by tonyjones on 3/7/17.
 */

public class YahooWeatherService {
    private WeatherServiceCallback callback;
    private String location;
    //do in background not running on the ui thread
    private Exception error;
    public YahooWeatherService(WeatherServiceCallback callback){
        this.callback = callback;
    }

    /**
     * 15:05 mark tutorial finish overriding the onpostexecute method
     * @param location
     */
    public void refreshWeather(String location){

        new AsyncTask<String,Void,String>() {

            @Override
            protected String doInBackground(String... params) {

                Channel channel = new Channel();

                String YQL = String.format("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"&s")

                String endpoint = String.format("https://query.yahooapis.com/v1/public/yql?q=&s&format=json", Uri.encode(YQL));

                try {
                    URL url = new URL(endpoint);

                    URLConnection connection = url.openConnection();

                    InputStream inputStream = connection.getInputStream();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                    StringBuilder result = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        result.append(line);

                    }

                    reader.close();

                    JSONObject data = new JSONObject(result.toString());

                    JSONObject queryResults = data.optJSONObject("query");

                    int count = queryResults.optInt("count");

                    if (count == 0) {
                        error = new LocationWeatherException("No weather information found for " + location);
                        return null;
                    }

                    JSONObject channelJSON = queryResults.optJSONObject("results").optJSONObject("channel");
                    channel.populate(channelJSON);

                    return channel;

                } catch (Exception e) {
                    error = e;
                }

                return null;

            }
                            return result.toString();


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String url =
                return null;
            }

            @Override
            protected void onPostExecute(String s) {


                super.onPostExecute(s);


            }


        }.execute(location);
    }

}
