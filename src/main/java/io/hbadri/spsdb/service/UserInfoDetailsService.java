package io.hbadri.spsdb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.hbadri.spsdb.model.User;
import io.hbadri.spsdb.model.UserInfo;
import respositories.UserRepository;

/**
 * 
 * @author badri.houssem@gmail.com
 *
 */
@Service
public class UserInfoDetailsService implements UserDetailsService{

	@Autowired UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser = userRepository.findByName(username);
		
		optionalUser
		.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
		return optionalUser.map(UserInfo::new).get();
	}

}
