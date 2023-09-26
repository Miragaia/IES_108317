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
    private static final int CITY_ID_AVEIRO = 1010500;

    public static void  main(String[] args ) {

        // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);
        // prepare the call to remote endpoint
        Call<IpmaCityForecast> callSync = service.getForecastForACity(CITY_ID_AVEIRO);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                CityForecast firstDay = forecast.getData().listIterator().next();

                System.out.println("Previsão Metereológica para este City Code: " + CITY_ID_AVEIRO);
                System.out.println("Data: " + firstDay.getForecastDate());
                System.out.println("Temperatura Máxima: " + firstDay.getTMax() + "°C");
                System.out.println("Temperatura Mínima: " + firstDay.getTMin() + "°C");
                System.out.println("Probabilidade de Percipitação: " + firstDay.getPrecipitaProb() + "%");
                System.out.println("Velocidade do Vento: " + firstDay.getClassWindSpeed() + " km/h");
            } else {
                System.out.println("Sem resultados para este city code!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}