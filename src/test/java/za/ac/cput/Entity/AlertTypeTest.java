/* Alert.java
   Entity for AlertTypeTest
   Author: Melisa Bhixa (217131085)
   Date: 11 June 2021
 */

package za.ac.cput.Entity;

import org.junit.jupiter.api.Assert;
import org.junit.jupiter.api.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assert.*;

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