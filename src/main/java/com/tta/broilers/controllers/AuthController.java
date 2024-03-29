package com.tta.broilers.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.broilers.entities.ERole;
import com.tta.broilers.entities.RoleSecurity;
import com.tta.broilers.entities.User;
import com.tta.broilers.entities.UserSecurity;
import com.tta.broilers.entities.rest.ResetPassword;
import com.tta.broilers.payload.request.LoginRequest;
import com.tta.broilers.payload.request.SignupRequest;
import com.tta.broilers.payload.response.JwtResponse;
import com.tta.broilers.payload.response.MessageResponse;
import com.tta.broilers.repositories.RoleSecurityRepository;
import com.tta.broilers.repositories.UserRepository;
import com.tta.broilers.repositories.UserSecurityRepository;
import com.tta.broilers.security.jwt.JwtUtils;
import com.tta.broilers.security.services.MailService;
import com.tta.broilers.security.services.UsersDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserSecurityRepository userRepository;

  @Autowired
  RoleSecurityRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;
  
  @Autowired
  UserRepository userDetailsRepository;

  @Autowired
  JwtUtils jwtUtils;
  
  @Autowired
  MailService mailService;

  
  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UsersDetailsImpl userDetails = (UsersDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());
    UserSecurity userSecurity= userRepository.findByUsername(loginRequest.getUsername()).get();
    User user=userDetailsRepository.findByID(userSecurity.getUserDetails()).get(0);

    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getEmail(), 
                         roles, user));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
	  System.out.println(signUpRequest);
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    UserSecurity user = new UserSecurity(signUpRequest.getUsername(), 
               signUpRequest.getEmail(),
               encoder.encode(signUpRequest.getPassword()),null);

    Set<String> strRoles = signUpRequest.getRole();
    Set<RoleSecurity> roles = new HashSet<>();

    if (strRoles == null) {
      RoleSecurity userRole = roleRepository.findByName(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          RoleSecurity adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          
          roles.add(adminRole);

          break;
        case "mod":
        	RoleSecurity modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(modRole);

          break;
        default:
        	RoleSecurity userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    System.out.println(user);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
  
  //
  @PostMapping("/mpoublier")
	public String MPoublier(@RequestBody String email) {
	  System.out.println(email);
	  System.out.println(userRepository.existsByEmail(email));
	  UserSecurity userSecurity =userRepository.getByEmail(email);
	  User user=userDetailsRepository.findByID(userSecurity.getUserDetails()).get(0);
		mailService.EnvoyerEmail(userSecurity,user);
		return null;
		
	}
  
  @PostMapping("/resetPassword")
  public void resetPassword(@RequestBody ResetPassword resetPassword) {
      String token = resetPassword.getToken();
      if (Boolean.FALSE.equals(jwtUtils.isTokenExpired(token))) {
          String email = jwtUtils.getUsernameFromToken(token);
          mailService.resetPassword(resetPassword, email);
      } else throw new RuntimeException("Token expired");

  }


}
