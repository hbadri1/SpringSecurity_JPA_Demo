package respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.hbadri.spsdb.model.User;

 /**
  * 	
  * @author badri.houssem@gmail.com
  *
  */
public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByName(String username);
}
