package za.ac.cput.Entity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

public class AlertTest {
    private Alert alert;
    private String id = UUID.randomUUID().toString();

    @Before
    public void setUp() throws Exception {
        alert = new Alert.AlertBuilder().setAlertNumber("646644").setAlertType("Emergency").build();
    }

    @Test
    public void getAlertNumber() {
        Assert.assertEquals("646644", alert.getAlertNumber());
    }

    @Test
    public void getAlertType() {
        Assert.assertEquals("Emergency", alert.getAlertType());
    }
}
