package assets;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int carid;
	private String cname;
	private long phno;
	private String fromDate;
	private String toDate;
	public Booking(int carid, String cname, long phno, String fromDate, String toDate) {
		super();
		this.carid = carid;
		this.cname = cname;
		this.phno = phno;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Booking [id=" + id + ", carid=" + carid + ", cname=" + cname + ", phno=" + phno + ", fromDate="
				+ fromDate + ", toDate=" + toDate + "]";
	}
	
}
