package za.ac.cput.Entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlertTypeTest {
    private AlertType alertType;

    @Before
    public void setUp() throws Exception {
        alertType = new AlertType.AlertTypeBuilder().setAlertTypeNumber("25555")
                                                    .setDescription("SOS")
                                                    .setSeverity("Medium")
                                                    .build();
    }

    @Test
    public void getAlertTypeNumber() {
        Assert.assertEquals("25555", alertType.getAlertTypeNumber());
    }

    @Test
    public void getDescription() {
        Assert.assertEquals("SOS", alertType.getDescription());
    }

    @Test
    public void getSeverity() {
        Assert.assertEquals("SOS", alertType.getSeverity());
    }
}