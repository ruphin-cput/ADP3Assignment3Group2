package za.ac.cput.factory;

import za.ac.cput.entity.Role;
import za.ac.cput.entity.User;
import za.ac.cput.entity.UserRole;

/*  UserRoleFactory.java
    Factory for the UserRole entity
    Author: Adriaan Burger(219014868)
    Date: 10 June 2021
 */
public class UserRoleFactory {
     private static String userID, roleID;

    public static UserRole createUserRole(User user, Role role){
        // 25-07 | Assignment feedback : "No getters in entities. userId, roleId should NOT be generated in UserRoleFactory."
       // String userID = GenericHelper.generateId();
       // String roleID = GenericHelper.generateId();

        userID = user.getUserID();

        roleID = role.getRoleID();

        UserRole userRole = new UserRole.Builder()
                .setRoleID(userID)
                .setRoleID(roleID)
                .build();
        return userRole;
    }

}
