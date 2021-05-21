package shu.jee.grandgallery.request;

public class UserLoginReq extends UserRequest{
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
