package lk.codelabs.authorizationserver.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "role")
@Data
public class Role implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "permission_role", joinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "permission_id", referencedColumnName = "id")})    
    private List<Permission> permissions;

	public Integer getId() {
		//System.out.println("--> getId() role: "+id);
		return id;
	}

	public void setId(Integer id) {
		//System.out.println("--> setId() role");
		this.id = id;
	}

	public String getName() {
		//System.out.println("--> getName() role: "+name);
		return name;
	}

	public void setName(String name) {
		//System.out.println("--> setName() role");
		this.name = name;
	}

	public List<Permission> getPermissions() {
		//System.out.println("--> getPermissions() role");
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		//System.out.println("--> setPermissions() role");
		this.permissions = permissions;
	}

}
