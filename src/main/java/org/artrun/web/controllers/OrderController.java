package org.artrun.web.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Predicate;

import javax.transaction.Transactional;

import org.artrun.web.domain.Order;
import org.artrun.web.domain.OrderStatus;
import org.artrun.web.domain.User;
import org.artrun.web.dto.AbstractResponseDto;
import org.artrun.web.dto.PlaceOrderRequestDTO;
import org.artrun.web.repositories.OrderRepository;
import org.artrun.web.repositories.UserRepository;
import org.artrun.web.utils.GenericUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class OrderController {

	@Autowired
	UserRepository uRepository;
	
	@Autowired
	OrderRepository oRepository;
	
	@PostMapping(value="/placeorder")
	@Transactional
	public AbstractResponseDto placeOrder(@RequestBody PlaceOrderRequestDTO po) {
		String status="FAILED";
		User u=uRepository.getOne(po.getUid());
		if(u != null) {
			Order o=new Order();
			o.setAddress(po.getAddress());
			o.setCart(u.getCart());
			o.setStatus(OrderStatus.inprogress);
			new GenericUtil<Order>().setCommonDates(o);
			if(u.getOrders() == null) {
				u.setOrders(new ArrayList<Order>());
			}
			u.getOrders().add(o);
			new GenericUtil<User>().setModified(u);
			uRepository.save(u);
			status="SUCCESS";
		}
		
		return new AbstractResponseDto(status, u);
	}
	
	@PostMapping(value="/cancelorder")
	@Transactional
	public AbstractResponseDto cancelOrder(@RequestBody PlaceOrderRequestDTO po) {
		String status="FAILED";
		User u=uRepository.getOne(po.getUid());
		if(u != null) {
			Predicate<Order> isCancelled = order -> order.getId()==po.getOid();
			Optional<Order> o=u.getOrders().stream().filter(isCancelled).findFirst();
			if(o.isPresent()) {
				o.get().setStatus(OrderStatus.cancelled);
				new GenericUtil<Order>().setCommonDates(o.get());
			}
			new GenericUtil<User>().setModified(u);
			uRepository.save(u);
			status="SUCCESS";
		}
		
		return new AbstractResponseDto(status, u);
	}
	
}
