package org.artrun.web.dto;

import org.artrun.web.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AbstractResponseDto{
	private String status;
	private User user;	
}