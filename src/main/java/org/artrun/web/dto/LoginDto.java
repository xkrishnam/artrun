package org.artrun.web.dto;

import org.springframework.lang.Nullable;

// import lombok.AllArgsConstructor;
// import lombok.Data;

//@Data
public class LoginDto {
	@Nullable
	private Long userid;
	@Nullable
	private String name;
	private String username;
	private String password;

	public LoginDto(String username, String password) {
		this.userid = null;
		this.name = null;
		this.username = username;
		this.password = password;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginDto() {
	}

	public LoginDto(Long userid, String name, String username, String password) {
		this.userid = userid;
		this.name = name;
		this.username = username;
		this.password = password;
	}

}