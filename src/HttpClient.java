import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpClient {
    //https://data.sncf.com/api/records/1.0/search/?dataset=tgvmax&q=&facet=date&facet=origine&facet=destination&refine.origine=STRASBOURG&refine.destination=BORDEAUX+ST+JEAN&refine.od_happy_card=OUI&refine.date=2021%2F04%2F27
    private String result;
    public void testFunction() {
        try {
            URL urlTest = new URL("https://data.sncf.com/api/records/1.0/search/?dataset=tgvmax&q=&facet=date&facet=origine&facet=destination&facet=od_happy_card&refine.origine=STRASBOURG&refine.destination=BORDEAUX+ST+JEAN&refine.od_happy_card=OUI&refine.date=2021%2F04%2F27");
            String result;
            HttpURLConnection con = (HttpURLConnection) urlTest.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int rpCode = con.getResponseCode();
            if (rpCode == HttpURLConnection.HTTP_OK) {
                InputStream is = con.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
                System.out.println(result);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void request(String strURL) {
        try {
            URL url = new URL(strURL);
            HttpURLConnection connec = (HttpURLConnection) url.openConnection();
            connec.setRequestMethod("GET");
            connec.connect();
            int rpCode = connec.getResponseCode();
            if (rpCode == HttpURLConnection.HTTP_OK) {
                InputStream is = connec.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuffer sbf = new StringBuffer();
                String tmp = null;
                while((tmp = br.readLine()) != null) {
                    sbf.append(tmp);
                    sbf.append("\r\n");
                }
                this.result = sbf.toString();
            }
            else
                throw new ConnectException("Connection failed!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getResult() {
        return this.result;
    }


}
