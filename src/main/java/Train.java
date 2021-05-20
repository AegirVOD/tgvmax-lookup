package main.java;

import java.util.Date;

public class Train {

    private int number;
    //private String type;
    private String departure;
    private String destination;
    private Date time;

    public Train(int number, String departure, String destination, Date time) {
        this.number = number;
        this.departure = departure;
        this.destination = destination;
        this.time = time;
    }

    public int getNumber() {
        return this.number;
    }

    /*public String getType() {
        return this.type;
    }*/

    public String getDeparture() {
        return this.departure;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getDate() {
        return DateParser.dateToString_Date(this.time);
    }

    public String getTime() {
        return DateParser.dateToString_Time(this.time);
    }

    public String getDateTime() {
        return DateParser.dateToString_DateTime(this.time);
    }

    public String toString () {
        StringBuilder res = new StringBuilder();
        res.append("Train no.");
        res.append(this.getNumber());
        res.append(", destination: ");
        res.append(this.getDestination());
        res.append(", departure: ");
        res.append(this.getDeparture());
        res.append(", leaves at ");
        res.append(this.getDateTime());
        return res.toString();
    }
 }
