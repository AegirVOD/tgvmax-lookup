package main.java;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

class Field {
    private String heure_depart;
    private String heure_arrivee;
    private String code_equip;
    private String destination;
    private int train_no;
    private String entity;
    private String origine;
    private String destination_iata;
    private String origine_iata;
    private String od_happy_card;
    private String axe;
    private String date;

    public int getTrain_no() {
        return this.train_no;
    }

    //Return Train with the data provided in Field.
    public Train getTrain() {
        try {
            Train res = new Train(train_no, origine, destination, DateParser.stringToDate_DateTime(date + " " + heure_depart));
            return res;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class Record {
    private String datasetid;
    private String recordid;
    private Field fields;
    private String record_timestamp;

    public Field getFields() {
        return fields;
    }
}

public class JsonContainer {
    private int nhits;
    private Object parameters;
    private List<Record> records;
    private List<Object> facet_groups;

    public void printTrainNumber() {
        for(Record record : this.records) {
            System.out.println(record.getFields().getTrain_no());
        }
    }

    public ArrayList<Train> getTrains()  {
        ArrayList<Train> trains = new ArrayList<>();
        for (Record record : this.records) {
            Field tmp = record.getFields();
            trains.add(tmp.getTrain());
        }
        return trains;
    }
}
