import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testHttpClient {

    @Test
    public void test1() throws ParseException {
        HttpClient tmp = new HttpClient();
        Request req = new Request();
        req.setDestination("bordeaux st jean");
        req.setDeparture("strasbourg");
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        Date t = ft.parse("2021-05-27");
        req.setDate(t);
        tmp.request(req.getUrl());
        System.out.println(tmp.getResult());
        assertTrue(tmp.getResult().contains("5454"));
    }


}
