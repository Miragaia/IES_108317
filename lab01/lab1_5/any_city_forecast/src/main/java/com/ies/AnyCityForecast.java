package com.ies;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.ies.IpmaCityForecast; 
import com.ies.IpmaApiClient;
import com.ies.CityForecast;


public class AnyCityForecast {

    private static final int[] RANDOM_CITY_IDS = {1010500, 1011500, 1012200, 1012700, 1012900};
    private static final Random RANDOM = new Random();
    private static final int REQUEST_INTERVAL_SECONDS = 20 * 1000; // 20 seconds

    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                int randomCityId = getRandomCityId();
                IpmaApiClient apiClient = new IpmaApiClient();
                IpmaCityForecast forecast = apiClient.getWeatherForecastForCity(randomCityId);

                if (forecast != null) {
                    CityForecast firstDay = forecast.getData().listIterator().next();

                    System.out.println("Previsão Metereológica para este City Code: " + randomCityId);
                    System.out.println("Data: " + firstDay.getForecastDate());
                    System.out.println("Temperatura Máxima: " + firstDay.getTMax() + "°C");
                    System.out.println("Temperatura Mínima: " + firstDay.getTMin() + "°C");
                    System.out.println("Probabilidade de Precipitação: " + firstDay.getPrecipitaProb() + "%");
                    System.out.println("Velocidade do Vento: " + firstDay.getClassWindSpeed() + " km/h");
                } else {
                    System.out.println("Sem resultados para este City Code: " + randomCityId);
                }
            }
        }, 0, REQUEST_INTERVAL_SECONDS);
    }

    private static int getRandomCityId() {
        int randomIndex = RANDOM.nextInt(RANDOM_CITY_IDS.length);
        return RANDOM_CITY_IDS[randomIndex];
    }
}
