package assets;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "login", schema = "car_rental")
public class Login {

    @Id
    @Column(name = "mobile_no", nullable = false)
    private long mobileNo;

    @Column(name = "password", nullable = false)
    private String password;

    // Required by JPA
    public Login() {
    }

    public Login(long mobileNo, String password) {
        this.mobileNo = mobileNo;
        this.password = password;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login [mobileNo=" + mobileNo + "]";
        // ❌ never print password
    }
}
