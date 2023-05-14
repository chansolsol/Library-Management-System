package Res;

public class UserInfo { //유저 정보 싱글턴으로 저장
    private static UserInfo instance = null;
    private String UserID;
    private String UserPassword;

    private UserInfo() {
        //private 생성자
    }

    public static UserInfo getInstance() {
        if (instance == null) {
            instance = new UserInfo();
        }
        return instance;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public void setUserPassword(String UserPassword) {
        this.UserPassword = UserPassword;
    }

    public String getUserID() {
        return UserID;
    }

    public String getUserPassword() {
        return UserPassword;
    }
}
