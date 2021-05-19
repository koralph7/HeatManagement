package com.pola.models;


//https://www.javamadesoeasy.com/2017/04/many-1-relationship-in-mongodb-many-to.html

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "users")
public class User {
  @Id
  private String id;
  
  @NotBlank
  @Size(min=3, max = 50)
  private String name;

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

  @DBRef
  private Set<Role> roles = new HashSet<>();
  
  private List<Battery> batteries;
 

  public User() {
  }

  public User(String name, String username, String email, String password) {
    this.name = name;
	this.username = username;
    this.email = email;
    this.password = password;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
  
  public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
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

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

public List<Battery> getBatteries() {
	return batteries;
}

public void setBatteries(List<Battery> batteries) {
	this.batteries = batteries;
}
  
  
}
