package za.ac.cput.Factory;

import za.ac.cput.Entity.UserRole;
import za.ac.cput.Util.GenericHelper;

/*  UserRoleFactory.java
    Factory for the UserRole entity
    Author: Adriaan Burger(219014868)
    Date: 10 June 2021
 */
public class UserRoleFactory {
    // private String userID, roleID;
    public static UserRole createUserRole(){

        String userID = GenericHelper.generateId();
        String roleID = GenericHelper.generateId();

        UserRole userRole = new UserRole.Builder()
                .setRoleID(userID)
                .setRoleID(roleID)
                .build();
        return userRole;
    }

}
