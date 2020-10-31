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
import javax.persistence.JoinColumn;


import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User implements Serializable{
	
	public User() {
		   
    }
	
	public User(User user) {
	        
	  this.username = user.username;
	  this.password = user.getPassword();
	  this.email = user.getEmail();
	  this.enabled = user.isEnabled();
	  this.accountNonExpired = user.isAccountNonExpired();
	  this.credentialsNonExpired = user.isCredentialsNonExpired();
	  this.accountNonLocked = user.isAccountNonLocked();
	  this.roles = user.getRoles();
	     
	}
	
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;

   @Column(name = "username")
   private String username;
   @Column(name = "password")
   private String password;
   @Column(name = "email")
   private String email;
   @Column(name = "enabled")
   private boolean enabled;
   @Column(name = "accountNonExpired")
   private boolean accountNonExpired;
   @Column(name = "credentialsNonExpired")
   private boolean credentialsNonExpired;
   @Column(name = "accountNonLocked")
   private boolean accountNonLocked;
   
   
   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "role_user", joinColumns = {
           @JoinColumn(name = "user_id", referencedColumnName = "id")},inverseJoinColumns = {
           @JoinColumn(name = "role_id", referencedColumnName = "id")})
   private List<Role> roles;	
   
   public Integer getId() {
	  // System.out.println("--> getId() user: "+id);
	return id;
}

public void setId(Integer id) {
	//System.out.println("--> setId() user");
	this.id = id;
}

public String getUsername() {
	//System.out.println("--> getUsername() user: "+username);
	return username;
}

public void setUsername(String username) {
	//System.out.println("--> setUsername() user");
	this.username = username;
}

public String getPassword() {
	//System.out.println("--> getPassword() user: "+password);
	return password;
}

public void setPassword(String password) {
	//System.out.println("--> setPassword() user");
	this.password = password;
}

public String getEmail() {
	//System.out.println("--> getEmail() user: "+email);
	return email;
}

public void setEmail(String email) {
	//System.out.println("--> setEmail() user");
	this.email = email;
}

public boolean isEnabled() {
	//System.out.println("--> isEnabled() user");
	return enabled;
}

public void setEnabled(boolean enabled) {
	//System.out.println("--> setEnabled() user");
	this.enabled = enabled;
}

public boolean isAccountNonExpired() {
	//System.out.println("--> isAccountNonExpired() user");
	return accountNonExpired;
}

public void setAccountNonExpired(boolean accountNonExpired) {
	//System.out.println("--> setAccountNonExpired() user");
	this.accountNonExpired = accountNonExpired;
}

public boolean isCredentialsNonExpired() {
	//System.out.println("--> isCredentialsNonExpired() user");
	return credentialsNonExpired;
}

public void setCredentialsNonExpired(boolean credentialsNonExpired) {
	//System.out.println("--> setCredentialsNonExpired() user");
	this.credentialsNonExpired = credentialsNonExpired;
}

public boolean isAccountNonLocked() {
	//System.out.println("--> isAccountNonLocked() user");
	return accountNonLocked;
}

public void setAccountNonLocked(boolean accountNonLocked) {
	//System.out.println("--> setAccountNonLocked() user");
	this.accountNonLocked = accountNonLocked;
}

public List<Role> getRoles() {
	//System.out.println("--> getRoles() user");
	return roles;
}

public void setRoles(List<Role> roles) {
	//System.out.println("--> setRoles() user");
	this.roles = roles;
}
   
   

}
