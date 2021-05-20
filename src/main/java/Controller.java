package main.java;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;

public class Controller {
    private HttpClient httpClient = new HttpClient();
    private Request request = new Request();
    private String jsonString;
    private JsonContainer jsonContainer = new JsonContainer();
    private Gson gson = new Gson();
    private ArrayList<Train> trainList;

    public void setParameters(String departure, String destination, Date date) {
        request.setDeparture(departure);
        request.setDestination(destination);
        request.setDate(date);
    }

    public void launchSearch() {
        httpClient.request(request.getUrl());
        this.jsonString = httpClient.getResult();
    }

    public void parseJson() {
        try {
            jsonContainer = gson.fromJson(jsonString, JsonContainer.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void printJson() {
        System.out.println(gson.toJson(jsonContainer));
    }

    public void getTrainList() {
        this.trainList = jsonContainer.getTrains();
    }

    public void printTrainList() {
        for (Train t : this.trainList)
            System.out.println(t);
    }

}
