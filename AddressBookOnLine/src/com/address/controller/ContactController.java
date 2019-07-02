package com.address.controller;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.address.dao.ContactDao;
import com.address.entity.Contact;
import com.address.entity.PagingResult;
import com.address.service.ContactService;

@RequestMapping("/Contact")
@Controller
public class ContactController {
	@Autowired
	private ContactService ContactService;

	/***
	 * 分页查询
	 * @param airQualityIndex
	 * @param pagingResult
	 * @param model
	 * @return
	 */
	@RequestMapping("/contactByPage")
	public String contactByPage(Contact contact,PagingResult<Contact> pagingResult,Model model) {
//		pagingResult.setPageCount(1);
		pagingResult.setPageSize(5);
		ContactService.contactByPage(contact.getCname(),pagingResult);
		model.addAttribute("pagingResult", pagingResult);
		model.addAttribute("contact", contact);
		return "list";
	}
	/***
	 * 进入添加
	 * @return
	 */
	@RequestMapping("/getoinsert")
	public String getoinsert(Model model) {
		model.addAttribute("contact", new Contact());
		return "insert";
	}
	/***
	 * 添加
	 * @param model
	 * @param contact
	 * @return
	 */
	@RequestMapping("/insert")
	public String insert(Model model,Contact contact) {
		ContactService.insert(contact);
		return "redirect:/Contact/contactByPage.action";
	}
	/***
	 * 根据id查询
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/getById")
	public String getById(Model model,Integer id) {
		model.addAttribute("contact",ContactService.getById(id));
		return "update";
	}
	/***
	 * 修改
	 * @param model
	 * @param contact
	 * @return
	 */
	@RequestMapping("/update")
	public String update(Contact contact) {
		ContactService.update(contact);
		return "redirect:/Contact/contactByPage.action";
	}
}
