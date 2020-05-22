package org.artrun.web.controllers;

import java.util.Optional;

import javax.transaction.Transactional;

import org.artrun.web.domain.Cart;
import org.artrun.web.domain.User;
import org.artrun.web.domain.UserType;
import org.artrun.web.dto.LoginDto;
import org.artrun.web.dto.AbstractResponseDto;
import org.artrun.web.repositories.UserRepository;
import org.artrun.web.utils.GenericUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	UserRepository uRepository;
	
	@PostMapping(value = "/artlogin")
	public AbstractResponseDto login(@RequestBody LoginDto ld) {
		String status="FAILED";
		User user1=null;
		Optional<User> user=this.uRepository.findAll()
				.stream()
				.filter(u -> (u.getEmail() !=null && u.getPassword()!=null && u.getEmail().equalsIgnoreCase(ld.getUsername()) && u.getPassword().equals(ld.getPassword())))
				.findFirst();
		if(user.isPresent()) {
			status="SUCCESS";
			user1=user.get();
		}
		return new AbstractResponseDto(status, user1);
	}
	
	@PostMapping(value = "/artregister")
	@Transactional
	public AbstractResponseDto register(@RequestBody LoginDto ld) {
		String status="FAILED";
		User user=null;
		if(ld.getUserid()==0) {
			user=new User();
			Cart cart=new Cart();
			user.setCart(cart);
			user.setUname(ld.getName());
			user.setEmail(ld.getUsername());
			user.setPassword(ld.getPassword());
			user.setUserType(UserType.user);
			new GenericUtil<User>().setCommonDates(user);
			new GenericUtil<Cart>().setCommonDates(cart);
			user=uRepository.save(user);
			status="SUCCESS";
		}else {
			user=uRepository.getOne(ld.getUserid());
			user.setUname(ld.getName());
			user.setEmail(ld.getUsername());
			user.setPassword(ld.getPassword());
			user.setUserType(UserType.user);
			new GenericUtil<User>().setModified(user);
			user=uRepository.save(user);
			status="SUCCESS";
		}
		return new AbstractResponseDto(status, user);
	}
}

