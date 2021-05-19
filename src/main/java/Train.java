import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Train {

    private int number;
    private String type;
    private String departure;
    private String destination;
    private Date time;

    public int getNumber() {
        return this.number;
    }

    public String getType() {
        return this.type;
    }

    public String getDeparture() {
        return this.departure;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getDate() {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        return ft.format(this.time);
    }

    public String getTime() {
        SimpleDateFormat ft = new SimpleDateFormat ("hh:mm");
        return ft.format(this.time);
    }

    public String getDateTime() {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm");
        return ft.format(this.time);
    }

    public String toString () {
        return null;
    }
 }
