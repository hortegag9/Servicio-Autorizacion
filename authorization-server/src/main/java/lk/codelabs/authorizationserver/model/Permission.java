package lk.codelabs.authorizationserver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "permission")
@Data
public class Permission implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;
    
	public Integer getId() {
		//System.out.println("--> getId() permission: "+id);
		return id;
	}
	public void setId(Integer id) {
		//System.out.println("--> setId() permission");
		this.id = id;
	}
	public String getName() {
		//System.out.println("--> getName() permission: "+name);
		return name;
	}
	public void setName(String name) {
		//System.out.println("--> setName() permission");
		this.name = name;
	}

}
