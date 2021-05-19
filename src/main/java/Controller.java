package main.java;

import main.java.HttpClient;
import main.java.Request;

import java.util.Date;

class container {

}

public class Controller {
    private HttpClient httpClient;
    private Request request;
    private String jsonString;

    public void init() {
        this.httpClient = new HttpClient();
        this.request = new Request();
    }

    public void setParameters(String departure, String destination, Date date) {
        request.setDeparture(departure);
        request.setDestination(destination);
        request.setDate(date);
        httpClient.request(request.getUrl());
        jsonString = httpClient.getResult();
    }

}
