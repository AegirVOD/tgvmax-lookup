import static org.junit.jupiter.api.Assertions.*;

import  org.junit.jupiter.api.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testRequest {

    String res = "https://data.sncf.com/api/records/1.0/search/?dataset=tgvmax&q=&facet=date&facet=origine&facet=destination&refine.date=2021%2F04%2F27&refine.destination=BORDEAUX+ST+JEAN&refine.origine=STRASBOURG";
    Request req = new Request();

    @BeforeEach
    public void init() throws ParseException {
        req.setDeparture("Strasbourg");
        req.setDestination("Bordeaux St Jean");
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        Date t = ft.parse("2021-04-27");
        req.setDate(t);
    }

    @Test
    public void test1() {
        assertEquals(res, req.getUrl());
    }

    @Test
    public void test2() {
        req.setDestination("Paris");
        req.setDestination("Bordeaux ST JEAN");
        req.setDeparture("Paris");
        req.setDeparture("strasbourg");
           assertEquals(res, req.getUrl());
    }
}
