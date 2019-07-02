package com.address.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.address.dao.ContactDao;
import com.address.entity.Contact;
import com.address.entity.PagingResult;
import com.address.service.ContactService;

@Service
public class ContactServiceimpl implements ContactService{
	
	@Autowired
	private ContactDao contactDao;
	
	@Override
	public void contactByPage(String cname,PagingResult<Contact>  pagingResult) {
		int rowCount = contactDao.contactCount(cname,pagingResult);
		pagingResult.setRowCount(rowCount);
		List<Contact> contactList = contactDao.contactByPage(cname,pagingResult);
		pagingResult.setData(contactList);
	}

	@Override
	public int insert(Contact contact) {
		return contactDao.insert(contact);
	}

	@Override
	public Contact getById(Integer id) {
		return contactDao.getById(id);
	}

	@Override
	public int update(Contact contact) {
		return contactDao.update(contact);
	}

}
