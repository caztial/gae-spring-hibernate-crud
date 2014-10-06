package com.japerfect.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class FoodOrder {
	
	@Id
	@GeneratedValue
	@Column(name="order_id")
	private Integer orderNo;
	
	@Column(name="payment_method")
	private String paymentMethod;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable
	(
			name="ordered_items",
			joinColumns={@JoinColumn(name="order_no",referencedColumnName="order_id")},
			inverseJoinColumns={@JoinColumn(name="item_no",referencedColumnName="item_id")}
	)
	private List<Item> items;

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
