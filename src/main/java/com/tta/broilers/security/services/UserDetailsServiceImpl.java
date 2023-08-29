package com.tta.broilers.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tta.broilers.entities.UserSecurity;
import com.tta.broilers.repositories.UserSecurityRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserSecurityRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserSecurity user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return UsersDetailsImpl.build(user);
  }

}
