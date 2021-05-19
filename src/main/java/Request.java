package main.java;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Request {
    private final String urlHeader = "https://data.sncf.com/api/records/1.0/search/?dataset=tgvmax&q=&facet=date&facet=origine&facet=destination";
    private final String depHeader = "refine.origine";
    private final String desHeader = "refine.destination";
    private final String dateHeader = "refine.date";
    private Map<String, String> parameters = new HashMap<>();

    public void setDeparture(String departure) {
        String tmp = departure.replace(' ', '+');
        String key = tmp.toUpperCase(Locale.ROOT);
        if (this.parameters.containsKey(this.depHeader))
            this.parameters.replace(this.depHeader, key);
        else
            this.parameters.put(this.depHeader, key);
    }

    public void setDestination(String destination) {
        String tmp = destination.replace(' ', '+');
        String key = tmp.toUpperCase(Locale.ROOT);
        if (this.parameters.containsKey(this.desHeader))
            this.parameters.replace(this.desHeader, key);
        else
            this.parameters.put(this.desHeader, key);
    }

    public void setDate(Date date) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy%2 MM%2 dd");
        String tmp = ft.format(date);
        tmp = tmp.replace(' ', 'F');
        if (this.parameters.containsKey(this.dateHeader))
            this.parameters.replace(this.dateHeader, tmp);
        else
            this.parameters.put(this.dateHeader, tmp);
    }

    public void clear() {
        this.parameters.clear();
    }

    public String getUrl() {
        StringBuilder url = new StringBuilder();
        url.append(this.urlHeader);
        for (Map.Entry<String, String> tmp : this.parameters.entrySet()) {
            url.append("&");
            url.append(tmp.getKey());
            url.append("=");
            url.append(tmp.getValue());
        }
        return url.toString();
    }
}
