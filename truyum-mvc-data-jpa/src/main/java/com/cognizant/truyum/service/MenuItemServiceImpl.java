package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MenuItemServiceImpl  {

	/**
	 * MenuItemService class is the implementation of the service layer
	 * menuItemDao attribute is injected using spring-config.xml
	 * bean menuItemDao is auto wired with MenuItemCollectionDaoImpl object
	 */
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	
	
	/**
	 * getMenuItemListAdmin() method return the list of menu items which are
	 * displayed to admin
	 * 
	 * @return list of menu items for admin
	 */

	@Transactional
	public List<MenuItem> getMenuItemListAdmin() {
		log.info("Start");
		return this.menuItemRepository.findAll();
		
	}

	/**
	 * getMenuItemListCustomer() returns list of menu items which are available for
	 * customers
	 * 
	 * @return list of menu items for customers
	 */

	public List<MenuItem> getMenuItemListCustomer() {
		log.info("Start");
		return this.menuItemRepository.findCustomerMenuItems();
	}

	/**
	 * getMenuItem() returns the MenuItem based on menuItemId menuItemDao is used
	 * for invoking the methods for getting MenuItem
	 * 
	 * @param menuItemId
	 * @return MenuItem for the given menuItemId
	 */

	
	public MenuItem getMenuItem(long menuItemId) {

		return menuItemRepository.getOne((int)menuItemId);
	}

	/**
	 * editMenuItem() takes
	 * 
	 * @param menuItem modifies the menu item and gets the updated menu item
	 */

	@Transactional
	public void editMenuItem(MenuItem menuItem) {
		log.info("Start");
		MenuItem menu=menuItemRepository.getOne(menuItem.getId());
		menu.setName(menuItem.getName());
		menu.setActive(menuItem.getActive());
		menu.setFreeDelivery(menuItem.isFreeDelivery());
		menu.setDateOfLaunch(menuItem.getDateOfLaunch());
		menu.setId(menuItem.getId());
		menu.setPrice(menuItem.getPrice());
		menu.setCategory(menuItem.getCategory());
		menuItemRepository.save(menu);
		log.info("End");

	}
}
