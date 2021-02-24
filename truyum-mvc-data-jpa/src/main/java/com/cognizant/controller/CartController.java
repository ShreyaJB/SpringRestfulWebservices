package com.cognizant.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.repository.CartEmptyException;
import com.cognizant.truyum.service.CartItemServiceImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Danish
 * 
 * 
 * CartController used to handle request from carts of users
 * @see CartItemService
 *
 */
@SessionAttributes("userId")
@RestController
@Slf4j
public class CartController {

//	private static final log log = logFactory.getlog(MenuItemController.class);

	@Autowired
     CartItemServiceImpl service;

	/**
	 * addToCart method used to add cart to the items
	 * 
	 * @param menuItemId
	 * @param map
	 * @param redirectAttributes
	 * @return
	 * @throws CartEmptyException
	 */

	@GetMapping("/add-to-cart/{id}/{userId}")
	public String addToCart(@PathVariable("id") long id, @PathVariable("userId") int userId) throws CartEmptyException {
		log.info("addToCart -Start");
		System.out.println("================================"+id+" ==="+userId);
		service.addCartItem(userId, id);
		log.info("addToCart -End");
		return "added sucessfully";

	}

	/**
	 * showCart method used to show the user cart
	 * 
	 * @param map
	 * @return
	 */

	@GetMapping("/show-cart")
	public List<Cart> showCart() throws CartEmptyException {
		log.info("showCart -Start");
		//Cart cart = null;
		List<Cart> cart;
		cart =  service.getAllCartItems(1);
		int total=0;
		if(cart.size()==0)
		{
			return null;
		}
		for(Cart carts:cart)
		{
			total+=carts.getMenuItem().getPrice();
		}
	   System.out.println("*************************************************"+total);
		log.info("showCart -End");
		return cart;

	}

	/**
	 * removeCart method used to remove items from cart
	 * 
	 * @param menuItemId
	 * @param map
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping("/remove-cart/{id}")
	public String removeCart(@PathVariable("id") long id) {
		log.info("removeCart -Start");
		service.removeCartItem( id);
		log.info("removeCart -End");
		return "Succesfully removed";
	}

}
