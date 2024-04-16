package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "Departs")
public class Departs {
	@Id 
	private String Id;
	private String Name;
	@OneToMany(mappedBy = "departs", fetch = FetchType.EAGER)
	private Collection<Staffs> staffs;
	public Departs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departs(String id, String name) {
		super();
		Id = id;
		Name = name;
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
}
