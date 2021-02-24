package com.cognizant.truyum.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
//@Data
@Table(name = "menu_item")
public class MenuItem {
	@Id
	@Column(name = "me_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "me_name")
	private String name;
	@Column(name = "me_price", columnDefinition = "decimal", precision = 8, scale = 2)
	private double price;
	@Column(name = "me_active")
	private String active;
	@Column(name = "me_date_of_launch")
	private Date dateOfLaunch;
	@Column(name = "me_category")
	private String category;
	@Column(name = "me_free_delivery")
	private boolean freeDelivery;

	@OneToMany(mappedBy = "menuItem", fetch = FetchType.LAZY)
	@JsonIgnore
	//@JsonManagedReference
	private List<Cart> carts;

	

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", dateOfLaunch="
				+ dateOfLaunch + ", category=" + category + ", freeDelivery=" + freeDelivery ;
	}

	

}
