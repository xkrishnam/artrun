package org.artrun.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDto{
	private Long userid;
	private String name;
	private String username;
	private String password;
}