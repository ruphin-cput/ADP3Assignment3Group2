package za.ac.cput.Factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Entity.Alert;

import java.util.UUID;

import static org.junit.Assert.*;

public class AlertFactoryTest {
    private Alert alert;
    private String id = UUID.randomUUID().toString();

    @Before
    public void setUp() throws Exception {
        alert = new Alert.AlertBuilder().setAlertNumber(id).setAlertType("Emergency").build();
    }

    @Test
    public void testCreateAlert() {
        Assert.assertNotNull(alert);
    }
}