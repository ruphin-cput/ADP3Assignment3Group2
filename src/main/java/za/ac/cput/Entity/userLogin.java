package za.ac.cput.Entity;

public class userLogin {
    private String userId, userName, password;


    private userLogin(Builder builder) {
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.password = builder.password;
    }

    @Override
    public String toString() {
        return "userLogin{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{
        private String userId, userName, password;

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public userLogin build(){
            return new userLogin(this);
        }
    }



    public userLogin copy(userLogin user){
        this.userId = user.userId;
        this.userName = user.userName;
        this.password = user.password;
        return this;
    }
}

