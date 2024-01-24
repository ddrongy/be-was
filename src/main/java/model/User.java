package model;

public class User {
    private String userId;
    private String password;
    private String name;
    private String email;

    public User(String userId, String password, String name, String email) {
        validate(userId, password, name, email);
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    private void validate(String userId, String password, String name, String email) {
        if (userId == null || password == null || name == null || email == null) {
            throw new IllegalArgumentException("모든 필드가 입력되야 합니다.");
        }
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void checkPassword(String password){
        // throw 날리기가 나을지 ? 아니면 return이 나을지?
//        return this.password.equals(password);
        if (!this.password.equals(password)){
            throw new IllegalArgumentException("비번이 틀림");
        }
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email + "]";
    }
}