package org.artrun.web.utils;

import java.util.stream.Collectors;

import org.artrun.web.domain.Cart;

public class CartUtils {
	
public static Cart updateCartTotal(Cart cart) {
	Integer total=cart.getPaintings().stream().collect(Collectors.summingInt(p-> p.getPrice()));
	cart.setCartTotal(total);
	return cart;
}
}
