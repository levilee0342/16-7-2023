package ptithcm.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "Staffs")
public class Staffs {
	@Id @GeneratedValue
	private String Id;
	private String Name;
	private Boolean Gender;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date Birthday;
	private String Photo;
	private String Email;
	private String Phone;
	private Float Salary;
	private String Notes;
	@ManyToOne
	@JoinColumn(name = "DepartId")
	private Departs departs;
	@OneToMany(mappedBy = "staffs", fetch = FetchType.EAGER)
	private Collection<Records> records;
	public Staffs() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Staffs(String id, String name, Boolean gender, Date birthday, String photo, String email, String phone,
			Float salary, String notes, String departId, Departs depart, Collection<Records> record) {
		super();
		Id = id;
		Name = name;
		Gender = gender;
		Birthday = birthday;
		Photo = photo;
		Email = email;
		Phone = phone;
		Salary = salary;
		Notes = notes;
		this.departs = depart;
		this.records = record;
	}
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public Boolean getGender() {
		return Gender;
	}
	public void setGender(Boolean gender) {
		Gender = gender;
	}
	
	public Date getBirthday() {
		return Birthday;
	}
	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}
	
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	
	public float getSalary() {
		return Salary;
	}
	public void setSalary(float salary) {
		Salary = salary;
	}
	
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
//	public String getDepartId() {
//		return DepartId;
//	}
//	public void setDepartId(String departId) {
//		DepartId = departId;
//	}
	public Departs getDepart() {
		return departs;
	}
	public void setDepart(Departs depart) {
		this.departs = depart;
	}
	public Collection<Records> getRecord() {
		return records;
	}
	public void setRecord(Collection<Records> records) {
		this.records = records;
	}
}
