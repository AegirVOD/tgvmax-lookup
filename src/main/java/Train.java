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
        return "Train no." +
                this.getNumber() +
                ", destination: " +
                this.getDestination() +
                ", departure: " +
                this.getDeparture() +
                ", leaves at " +
                this.getDateTime();
    }
 }
