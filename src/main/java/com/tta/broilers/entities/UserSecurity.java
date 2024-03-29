package com.tta.broilers.entities;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table( name = "usersecurity", 
        uniqueConstraints = { 
          @UniqueConstraint(columnNames = "username"),
          @UniqueConstraint(columnNames = "email") 
        })
public class UserSecurity {

	
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long idSecurity;

	  @NotBlank
	  @Size(max = 20)
	  private String username;

	  @NotBlank
	  @Size(max = 50)
	  @Email
	  private String email;

	  @NotBlank
	  @Size(max = 120)
	  private String password;

	  @ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_idSecurity"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	  private Set<RoleSecurity> roles = new HashSet<>();
	  
	  @NotBlank
	    private String userDetails;

	  public UserSecurity() {
	  }

	  public UserSecurity(String username, String email, String password, String userDetails) {
	    this.username = username;
	    this.email = email;
	    this.password = password;
	    this.userDetails= userDetails; 
	  }

	public Long getId() {
		return idSecurity;
	}

	public void setId(Long id) {
		this.idSecurity = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<RoleSecurity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleSecurity> roles) {
		this.roles = roles;
	}

	public Long getIdSecurity() {
		return idSecurity;
	}

	public void setIdSecurity(Long idSecurity) {
		this.idSecurity = idSecurity;
	}

	public String getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(String userDetails) {
		this.userDetails = userDetails;
	}

	

	  
	  
}
