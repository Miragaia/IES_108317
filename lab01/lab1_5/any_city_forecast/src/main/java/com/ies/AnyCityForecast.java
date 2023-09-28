package com.ies;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.awt.Toolkit;
import java.io.IOException; 

public class AnyCityForecast {

    Toolkit toolkit;//j  av  a2  s .  c o m
    private static int CITY_ID = 1010500;
    Timer timer;
  
    public AnyCityForecast() {
      toolkit = Toolkit.getDefaultToolkit();
      timer = new Timer();
      timer.scheduleAtFixedRate(new RemindTask(), 0, //initial delay
          20 * 1000); //subsequent rate
    }
  
    class RemindTask extends TimerTask {
      int numWarningBeeps = 3;
  
      public void run() {
        if (true) {
          long time = System.currentTimeMillis();
          if (time - scheduledExecutionTime() > 5) {
            return;
          }
          toolkit.beep();
          System.out.println("Beep!");
        
        // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);
        int randomCityCode = 0;

        // Create a call to get all cities
            Call<IpmaCityForecast> citiesCall = service.getAllCities();
            
            Response<IpmaCityForecast> citiesResponse;
            try {
              citiesResponse = citiesCall.execute();
              if (citiesResponse.isSuccessful()) {
                IpmaCityForecast cityList = citiesResponse.body();
                List<CityForecast> data_cities = cityList.getData();

                Random random = new Random();
                randomCityCode = random.nextInt(data_cities.size());
                System.out.println("City name: " + data_cities.get(randomCityCode).getLocal());

                CITY_ID = Integer.parseInt(data_cities.get(randomCityCode).getglobalIdLocal());
                // for (CityForecast city : data) {
                //   System.out.println("City Name: " + city.getLocal() + " NR: " + city.getglobalIdLocal());
                // }
              } else {
                System.out.println("Failed to retrieve the list of cities.");
              }
            } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
        // prepare the call to remote endpoint
        Call<IpmaCityForecast> callSync = service.getForecastForACity(CITY_ID);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null && !forecast.getData().isEmpty()) {
                CityForecast firstDay = forecast.getData().get(0); // Get the first day's forecast

                System.out.println("Previsão Metereológica para este City Code: " + CITY_ID);
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


        } else {
          toolkit.beep();
          System.out.println("Time's up!");
          System.exit(0);
        }
      }
    }
  
    public static void main(String args[]) {
      new AnyCityForecast();
    }
}
