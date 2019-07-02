package com.address.service;

import org.apache.ibatis.annotations.Param;

import com.address.entity.Contact;
import com.address.entity.PagingResult;

public interface ContactService {
	/***
	 * 分页查询
	 * @param cname
	 * @param id
	 * @param pagingResult
	 */
	public void contactByPage(
			@Param("cname")String cname,
			@Param("pagingResult")PagingResult<Contact> pagingResult);
	/***
	 * 添加
	 * @param contact
	 * @return
	 */
	public int insert(Contact contact);
	/***
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Contact getById(Integer id);
	/***
	 * 修改
	 * @param contact
	 * @return
	 */
	public int update(Contact contact);
}
