package ex01_member;

// 사용자가 입력한 회원 가입에 필요한 정보를 담고 있는 객체
public class RegisterRequest {
    private String email;
    private String password;
    private String confirmPassword;
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPasswordEqualToConfirmPassword() {
        return this.password.equals(this.confirmPassword);
    }
}
