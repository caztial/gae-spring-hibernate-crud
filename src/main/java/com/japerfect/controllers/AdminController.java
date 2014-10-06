package com.japerfect.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.japerfect.entity.Item;
import com.japerfect.service.ItemService;

@Controller
public class AdminController {
	
	@Autowired
	ItemService itemService;

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
}
