package com.example.tonyjones.weatherone.service;

import com.example.tonyjones.weatherone.data.Channel;

/**
 * Created by tonyjones on 3/7/17.
 */

public interface WeatherServiceCallback  {
    void ServiceSuccess(Channel channel);
    void ServiceFailure(Exception exception);
}
