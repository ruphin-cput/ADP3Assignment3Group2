/* Alert.java
   Entity for AlertTest
   Author: Melisa Bhixa (217131085)
   Date: 11 June 2021
 */

package za.ac.cput.Entity;

import org.junit.jupiter.api.Assert;
import org.junit.jupiter.api.Before;
import org.junit.jupiter.api.Test;

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
