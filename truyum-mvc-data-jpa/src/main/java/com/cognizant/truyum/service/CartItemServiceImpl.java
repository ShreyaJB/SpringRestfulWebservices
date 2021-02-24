package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.repository.CartRepository;
import com.cognizant.truyum.repository.MenuItemRepository;
import com.cognizant.truyum.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartItemServiceImpl 
{

	@Autowired
	CartRepository cartRepository;
	@Autowired
	 UserRepository userRepository;
	@Autowired
	 MenuItemRepository menuRepository;

	
	
	//private static final log log = logFactory.getlog(CartController.class);
	
	public void addCartItem(int userId, long menuItemId) {
		// TODO Auto-generated method stub
		log.info("START");
		log.info("ADD CART ITEM");
		Cart c=new Cart();
		c.setUser(userRepository.getOne(userId));
		c.setMenuItem(menuRepository.getOne((int)menuItemId));
	cartRepository.save(c);
	log.info("END");
		
		
	}

	public void removeCartItem( long menuItemId) {
		// TODO Auto-generated method stub
		log.info("START");
		 cartRepository.removeItem(1,menuItemId);
		 log.info("END");
	}

	public List<Cart> getAllCartItems(int i) {
		// TODO Auto-generated method stub
		log.info("START");
		log.info("Get All Cart Items");
		return cartRepository.findById(i);
		
	}
}
