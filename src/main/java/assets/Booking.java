package assets;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "booking", schema = "car_rental")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ PostgreSQL safe
    private int id;

    @Column(name = "car_id", nullable = false)
    private int carid;

    @Column(name = "customer_name", nullable = false)
    private String cname;

    @Column(name = "phone_no", nullable = false)
    private long phno;

    @Column(name = "from_date", nullable = false)
    private String fromDate;

    @Column(name = "to_date", nullable = false)
    private String toDate;

    // Required by JPA
    public Booking() {
    }

    public Booking(int carid, String cname, long phno, String fromDate, String toDate) {
        this.carid = carid;
        this.cname = cname;
        this.phno = phno;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public int getId() {
        return id;
    }

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public long getPhno() {
        return phno;
    }

    public void setPhno(long phno) {
        this.phno = phno;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "Booking [id=" + id + ", carid=" + carid +
               ", cname=" + cname + ", phno=" + phno +
               ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
    }
}
