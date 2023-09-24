package com.ies;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    //todo: should generalize for a city passed as argument
    //private static final int CITY_ID_AVEIRO = 1010500;

    public static void  main(String[] args ) {

        if (args.length != 1) {
            System.out.println("Modo de uso: WeatherStarter <city_code>");
            return;
        }

        int cityCode = Integer.parseInt(args[0]);
        
        // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);
        // prepare the call to remote endpoint
        Call<IpmaCityForecast> callSync = service.getForecastForACity(cityCode);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null && !forecast.getData().isEmpty()) {
                CityForecast firstDay = forecast.getData().get(0); // Get the first day's forecast

                System.out.println("Weather forecast for City Code: " + cityCode);
                System.out.println("Date: " + firstDay.getForecastDate());
                System.out.println("Max Temperature: " + firstDay.getTMax() + "°C");
                System.out.println("Min Temperature: " + firstDay.getTMin() + "°C");
                System.out.println("Precipitation Probability: " + firstDay.getPrecipitaProb() + "%");
                System.out.println("Wind Speed: " + firstDay.getClassWindSpeed() + " km/h");
            } else {
                System.out.println("No results for this city code!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}