package ptithcm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "Records")
public class Records {
	@Id @GeneratedValue
	private int Id;
	private int Type;
	private String Reason;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date Date;
	@ManyToOne
	@JoinColumn(name = "StaffId")
	private Staffs staffs;
	public Records() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Records(int id, int type, String reason, java.util.Date date, Staffs staffs) {
		super();
		Id = id;
		Type = type;
		Reason = reason;
		Date = date;
		this.staffs = staffs;
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	
	public Staffs getStaff() {
		return staffs;
	}
	public void setStaff(Staffs staffs) {
		this.staffs = staffs;
	}
	
}
