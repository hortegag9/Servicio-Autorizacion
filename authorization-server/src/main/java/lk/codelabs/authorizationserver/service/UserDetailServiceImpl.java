package lk.codelabs.authorizationserver.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lk.codelabs.authorizationserver.model.AuthUserDetail;
import lk.codelabs.authorizationserver.model.User;
import lk.codelabs.authorizationserver.repository.UserDetailRepository;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserDetailRepository userDetailRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	System.out.println("public UserDetails loadUserByUsername(String username) "+username);
		// TODO Auto-generated method stub
	Optional<User> optionalUser = userDetailRepository.findByUsername(username);
	optionalUser.orElseThrow(()-> new UsernameNotFoundException("username or password wrong"));
	UserDetails userDetails = new AuthUserDetail(optionalUser.get());
	new AccountStatusUserDetailsChecker().check(userDetails);
		return userDetails;
	}

}
