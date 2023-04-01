package object;

public class TaiKhoan {
    private String Username,Password;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public TaiKhoan() {
        this.Username = null;
        this.Password = null;
    }

    public TaiKhoan(String username, String password) {
        this.Username = username;
        this.Password = password;
    }
}
