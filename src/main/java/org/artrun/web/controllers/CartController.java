package org.artrun.web.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.artrun.web.domain.Cart;
import org.artrun.web.domain.CartStatus;
import org.artrun.web.domain.Painting;
import org.artrun.web.domain.User;
import org.artrun.web.domain.UserType;
import org.artrun.web.repositories.CartRepository;
import org.artrun.web.repositories.PaintingRepository;
import org.artrun.web.repositories.UserRepository;
import org.artrun.web.utils.CartUtils;
import org.artrun.web.utils.GenericUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
public class CartController {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PaintingRepository pRepository;
	
	@RequestMapping(value = "/addtocart/{id}/{uid}")
	@Transactional
	public User addTocart(@PathVariable("id") Long id,@PathVariable("uid") Long cid) {
		if(cid == 0) {
			User anonyms =new User();
			new GenericUtil<User>().setCommonDates(anonyms);
			anonyms.setUserType(UserType.guest);
			Cart cart=new Cart();
			new GenericUtil<Cart>().setCommonDates(cart);
			List<Painting> lop=new ArrayList<>();
			lop.add(pRepository.getOne(id));
			cart.setPaintings(lop);
			cart.setStatus(CartStatus.saved);
			cart.setUser(anonyms);
			anonyms.setCart(CartUtils.updateCartTotal(cart));
			User sAnonyms=userRepository.save(anonyms);
			return anonyms;
		}else {
			User user=userRepository.getOne(cid);
			Cart c= user.getCart();
			c.getPaintings().add(pRepository.getOne(id));
			new GenericUtil<Cart>().setModified(c);
			user.setCart(CartUtils.updateCartTotal(c));
			new GenericUtil<User>().setModified(user);
			return userRepository.save(user);
		}
		
	}
	
	@RequestMapping(value = "/remcart/{uid}/{pid}")
	@Transactional
	public User removeFromCart(@PathVariable("pid") Long id,@PathVariable("uid") Long cid) {
			User user=userRepository.getOne(cid);
			Cart c= user.getCart();
			int j=0;
			Iterator<Painting> i=c.getPaintings().iterator();
			while(i.hasNext()) {
				if(i.next().getId()==id && j==0) {
					i.remove();
					j++;
				}
			}
			user.setCart(CartUtils.updateCartTotal(c));
			new GenericUtil<Cart>().setModified(c);
			new GenericUtil<User>().setModified(user);
			return userRepository.save(user);	
	}
}