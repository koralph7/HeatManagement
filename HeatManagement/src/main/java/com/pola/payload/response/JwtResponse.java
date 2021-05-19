package com.pola.payload.response;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String username;
	private String email;
	private String id;
	private Collection<? extends GrantedAuthority> authorities;

	public JwtResponse(String accessToken, String username, String email, String id, Collection<? extends GrantedAuthority> authorities) {
		this.token = accessToken;
		this.username = username;
		this.authorities = authorities;
		this.email = email;
		this.id = id;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getUsername() {
		return username;
	}
	
	

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
