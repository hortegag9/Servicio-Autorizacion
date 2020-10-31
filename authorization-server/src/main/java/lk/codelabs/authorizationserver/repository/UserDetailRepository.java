package lk.codelabs.authorizationserver.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import lk.codelabs.authorizationserver.model.User;

public interface UserDetailRepository extends JpaRepository<User,Integer>{
	
	public abstract Optional<User> findByUsername(String name);

}
