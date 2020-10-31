package lk.codelabs.authorizationserver.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthUserDetail extends User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AuthUserDetail(User user) {
	    super(user);
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
	System.out.println("---> public Collection<? extends GrantedAuthority> getAuthorities()");
	List<GrantedAuthority> grantedAuthority = new ArrayList<>();
	
	getRoles().forEach(role -> {
		grantedAuthority.add(new SimpleGrantedAuthority(role.getName()));
		role.getPermissions().forEach(permission -> {
			grantedAuthority.add(new SimpleGrantedAuthority(permission.getName()));
		});
	});
	System.out.println(grantedAuthority.get(0));	
	return grantedAuthority;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		//System.out.println("--> getPassword() "+getPassword()); error syso after super
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		//System.out.println("--> getUsername() "+getUsername());
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		//System.out.println("--> isAccountNonExpired() "+isAccountNonExpired());
		return super.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		//System.out.println("--> isAccountNonLocked()");
		return super.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		//System.out.println("--> isCredentialsNonExpired()");
		return super.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		//System.out.println("--> isEnabled() "+isEnabled());
		return super.isEnabled();
	}

}
