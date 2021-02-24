package com.cognizant.controller;

//import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemServiceImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * MenuItemController class used to handle request from menu items pages
 * 
 * @see MenuItemService
 * @author Danish
 */

@SessionAttributes("userId")
@RestController
@Slf4j
public class MenuItemController {

	@Autowired
	MenuItemServiceImpl service;

	/**
	 * showMenuItemListAdmin method shows items for admin
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/show-menu-list-admin")
	public List<MenuItem> showMenuItemListAdmin() /* throws SystemException */ {
		log.info("showMenuItemListAdmin -Start");
		List<MenuItem> items = service.getMenuItemListAdmin();
		log.debug("AdminList:{}", items);
		log.info("showMenuItemListAdmin -End");
		return items;
	}

	/**
	 * showEditMenuItem method handles get request and display page to edit menu
	 * items for admin
	 * 
	 * @param menuItemId
	 * @param model
	 * @return
	 */
	
	@GetMapping("/show-edit-menu-item/{id}")
	public MenuItem showEditMenuItem(@PathVariable("id") long id) {
		log.info("showEditMenuItem -Start");
		MenuItem item = service.getMenuItem(id);
		System.out.println(item);
		log.debug("Item :{}", item);
		log.info("showEditMenuItem -End");
		return item;
	}

	/**
	 * editMenuItem mehod handles post request from edit menu page it edit the item
	 * in database
	 * 
	 * @param menuItem
	 * @param bindingResult
	 * @return
	 */
	@PutMapping("/edit-menu-item")
	public String editMenuItem(@RequestBody @Valid MenuItem menuItem) {
		log.info("showEditMenuItemPost -Start");
		service.editMenuItem(menuItem);
		log.info("showEditMenuItemPost -End");
		return "editied scuuess";
	}

	/**
	 * showMenuItemListCustomer method display menu items for customer
	 * 
	 * @param model
	 * @return
	 */
	
	@GetMapping("/show-menu-list-customer")
	public List<MenuItem> showMenuItemListCustomer() {
		log.info("showMenuItemListCustomer -Start");
		List<MenuItem> item = service.getMenuItemListCustomer();
		//model.addAttribute("itemList", item);
		log.info("showMenuItemListCustomer -End");
		return item;
	}

	/**
	 * populateCategory method used to populate the 
	 * category in edit menu jsp
	 * 
	 * 
	 * @return
	 * 
	 **/
	@ModelAttribute("categoryList")
	public List<String> populateCategory() {
		log.info("populateCategory -Start");
		List<String> categoryList = new ArrayList<String>();
		categoryList.add("Starters");
		categoryList.add("Main Course");
		categoryList.add("Dessert");
		categoryList.add("Drinks");
		log.info("populateCategory -End");
		return categoryList;
	}
}
