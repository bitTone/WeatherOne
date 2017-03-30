package com.example.tonyjones.weatherone;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tonyjones.weatherone.data.Channel;
import com.example.tonyjones.weatherone.service.WeatherServiceCallback;
import com.example.tonyjones.weatherone.service.YahooWeatherService;

//16:42 finish importing variables
public class MainActivity extends AppCompatActivity implements WeatherServiceCallback {

    private ImageView weatherIconImageView;
    private TextView temperatureTextView;
    private TextView conditionTextView;
    private TextView locationTextView;
    //implements weather service
    private YahooWeatherService service;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service = new YahooWeatherService(this);
        service.refreshWeather("Austin, TX");



    }


    @Override
    public void ServiceSuccess(Channel channel) {

    }

    @Override
    public void ServiceFailure(Exception exception) {

    }
}
