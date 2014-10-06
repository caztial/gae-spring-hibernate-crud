package com.japerfect.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.japerfect.entity.Item;
import com.japerfect.entity.FoodOrder;
import com.japerfect.service.ItemService;
import com.japerfect.service.OrderService;

@Controller
public class AdminController {
	
	@Autowired
	ItemService itemService;
	@Autowired
	OrderService orderService;

	@RequestMapping("/admin/index")
	public String blank(){
		return "adminBlank";
	}
	
	@RequestMapping("/admin/additem")
	public String addItem(Model model){
		Item nItem=new Item();
		model.addAttribute("newItem", nItem);
		return "adminAddItem";
	}
	
	@RequestMapping(value="/admin/additem",method=RequestMethod.POST)
	public String doAddItem(Model model,@ModelAttribute Item nItem){
		itemService.saveOneItem(nItem);
		Item nwItem=new Item();
		model.addAttribute("newItem", nwItem);
		model.addAttribute("flag",true);
		return "adminAddItem";
	}
	
	@RequestMapping(value="/admin/edititem",method=RequestMethod.GET)
	public String editItem(Model model, @RequestParam int id){
		Item nItem=itemService.getOneItem(id);
		System.out.println(nItem.getName());
		model.addAttribute("editItem", nItem);
		return "adminEditItem";
	}
	
	@RequestMapping(value="/admin/edititem",method=RequestMethod.POST)
	public String doEditItem(Model model, @ModelAttribute Item eItem){
		itemService.saveOneItem(eItem);
		model.addAttribute("newItem", eItem);
		model.addAttribute("flag",true);
		return "adminEditItem";
	}
	

	@RequestMapping(value="/admin/viewitems")
	public String viewItems(Model model){
		List<Item> items=itemService.getAll();
		model.addAttribute("items", items);
		return "adminViewItem";
	}

	// Order Management
	@RequestMapping("/admin/addorder")
	public String addOrder(Model model){
		FoodOrder order=new FoodOrder();
		model.addAttribute("newOrder", order);
		return "adminAddOrder";
	}
	
	@RequestMapping(value="/admin/addorder",method=RequestMethod.POST)
	public String doAddOrder(Model model,@ModelAttribute FoodOrder order){
		orderService.saveOneItem(order);
		FoodOrder norder = new FoodOrder();
		model.addAttribute("newOrder", norder);
		model.addAttribute("flag",true);
		return "adminAddOrder";
	}
	
	@RequestMapping(value="/admin/vieworders")
	public String viewOrders(Model model){
		List<FoodOrder> orders=orderService.getAll();
		model.addAttribute("orders", orders);
		return "adminViewOrder";
	}
	
	@RequestMapping(value="/admin/editorder",method=RequestMethod.GET)
	public String editOrder(Model model, @RequestParam int id){
		FoodOrder order=orderService.getOneOrder(id);
		model.addAttribute("editOrder", order);
		return "adminEditOrder";
	}
	
	@RequestMapping(value="/admin/editorder",method=RequestMethod.POST)
	public String doEditOrder(Model model, @ModelAttribute FoodOrder order){
		orderService.saveOneItem(order);
		model.addAttribute("editOrder", order);
		model.addAttribute("flag",true);
		return "adminEditOrder";
	}
	
	@RequestMapping(value="/admin/orderitems",method=RequestMethod.GET)
	public String OrderItem(Model model, @RequestParam int id){
		FoodOrder addItem=orderService.getOneOrder(id);
		List<Item> itemsInOrder=addItem.getItems();
		
		List<Item> itemlist=itemService.getAll();
		model.addAttribute("itemlist", itemlist);
		model.addAttribute("orderid", id);
		model.addAttribute("itemsInOrder", itemsInOrder);
		return "adminOrderItems";
	}
	
	@RequestMapping(value="/admin/orderitems",method=RequestMethod.POST)
	public String doOrderItem(Model model, @RequestParam int id,@RequestParam int itemid){
		FoodOrder addItem=orderService.getOneOrder(id);
		List<Item> itemsInOrder=addItem.getItems();
		Item newItem=itemService.getOneItem(itemid);
		itemsInOrder.add(newItem);
		orderService.saveOneItem(addItem);
		model.addAttribute("flag",true);
		List<Item> itemlist=itemService.getAll();
		model.addAttribute("itemlist", itemlist);
		model.addAttribute("orderid", id);
		model.addAttribute("itemsInOrder", itemsInOrder);
		
		return "adminOrderItems";
	}
	
	
	
	
	
	
	
	
	
	
}
