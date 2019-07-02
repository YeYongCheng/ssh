package com.address.entity;
/***
 * 
 * @author Xin
 *联系人
 */
public class Contact {
	private Integer id;
	private String cname;//联系人姓名
	private String mobile;//手机
	private String qq;
	private String email;
	private String address;//地址
	
	public Contact() {
		
	}
	public Contact(Integer id, String cname, String mobile, String qq, String email, String address) {
		this.id = id;
		this.cname = cname;
		this.mobile = mobile;
		this.qq = qq;
		this.email = email;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", cname=" + cname + ", mobile=" + mobile + ", qq=" + qq + ", email=" + email
				+ ", address=" + address + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
