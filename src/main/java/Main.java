package main.java;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Controller controller = new Controller();
        String userInputDate;
        Scanner sc = new Scanner(System.in);
        System.out.println("Date?");
        userInputDate = sc.nextLine();
        controller.setParameters("bordeaux st jean", "strasbourg", DateParser.stringToDate_Date(userInputDate));
        controller.launchSearch();
        controller.parseJson();
        controller.getTrainList();
        controller.printTrainList();
    }
}
