package za.ac.cput.Factory;

import za.ac.cput.Entity.Alert;

public class AlertFactory {

    public static Alert CreateAlert(String alertNumber, String alertType){
        Alert alert = null;

        if(alertNumber.trim().isEmpty()){
            System.out.println("Alert number cannot be null");

        }else if(alertType.trim().isEmpty()){
            System.out.println("Please enter alert type");

        }else{
            alert = new Alert.AlertBuilder().setAlertNumber(alertNumber).setAlertType(alertType).build();
        }
        return alert;
    }
}
