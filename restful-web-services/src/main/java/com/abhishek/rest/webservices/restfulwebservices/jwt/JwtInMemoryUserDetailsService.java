package com.abhishek.rest.webservices.restfulwebservices.jwt;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

	static {
		inMemoryUserList.add(new JwtUserDetails(1L, "Abhishek",
				"$2a$10$s4cUbcVZnmUN0EMVg.mi5OcAPw.Dlu50nY0ynRmFZbUlHDZ9vGiOq", "ROLE_USER_2"));
		inMemoryUserList.add(new JwtUserDetails(2L, "Abhishek",
				"$2a$10$1Un/Hm9ytkskYce24lNS.uYC0m3VTX7FY9PBQDuk8UTzxgDHO6P.S", "ROLE_USER_2"));
		
		//$2a$10$IetbreuU5KihCkDB6/r1DOJO0VyU9lSiBcrMDT.biU7FOt2oqZDPm
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
				.filter(user -> user.getUsername().equals(username)).findFirst();

		if (!findFirst.isPresent()) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}

		return findFirst.get();
	}

}