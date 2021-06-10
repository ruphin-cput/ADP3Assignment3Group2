package za.ac.cput.Factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Entity.AlertType;

import java.util.UUID;

import static org.junit.Assert.*;

public class AlertTypeFactoryTest {
    private AlertType alertType;
    private String id = UUID.randomUUID().toString();

    @Before
    public void setUp() throws Exception {
        alertType = new AlertType.AlertTypeBuilder().setAlertTypeNumber(id)
                                                    .setDescription("SOS")
                                                    .setSeverity("Medium")
                                                    .build();
    }

    @Test
    public void testCreateAlertType() {
        Assert.assertNotNull(alertType);
    }
}