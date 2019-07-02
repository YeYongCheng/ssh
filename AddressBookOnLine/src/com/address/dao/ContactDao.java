package com.address.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.address.entity.Contact;
import com.address.entity.PagingResult;

public interface ContactDao {
	/***
	 * 按姓名和id查询带分页
	 * @param cname
	 * @param id
	 * @param pagingResult
	 * @return
	 */
	public List<Contact> contactByPage(@Param("cname")String cname,
			@Param("pagingResult")PagingResult<Contact> pagingResult);
	/***
	 * 总条数
	 * @param cname
	 * @param id
	 * @param pagingResult
	 * @return
	 */
	public int contactCount(@Param("cname")String cname,
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
	public int update(@Param("contact")Contact contact);
}
