package kr.or.connect.mavenweb.dto;

public class User {
    String email;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{"+
                "email='"+email+'\''+
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
