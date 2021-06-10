package za.ac.cput.Entity;
/*  UserRole.java
    Entity for the UserRole
    Author: Adriaan Burger(219014868)
    Date: 10 June 2021
 */
public class UserRole {

    private String userID, roleID;

    private UserRole(Builder builder){
        this.userID = builder.userID;
        this.roleID = builder.roleID;

    }

    public static class Builder{
        private String userID, roleID;
        public Builder setUserID(String userID){
            this.userID = userID;
            return this;
        }

        public Builder setRoleID(String roleID){
            this.roleID = roleID;
            return this;
        }

        public UserRole build(){

            return new UserRole(this);
        }

        public Builder copy(UserRole userRole){
            this.userID = userRole.userID;
            this.roleID =  userRole.roleID;

            return this;
        }

    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userID='" + userID + '\'' +
                ", roleID='" + roleID + '\'' +
                '}';
    }
}
