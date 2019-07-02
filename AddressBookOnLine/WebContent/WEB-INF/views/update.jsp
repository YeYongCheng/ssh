<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改联系人</title>
</head>
<body>
	<h2>修改联系人</h2>
	<div>
		<fm:form action="/AddressBookOnLine/Contact/update.action" modelAttribute="contact">
			<p>姓名:<fm:input path="cname"/></p>
			<p>手机:<fm:input path="mobile"/></p>	
			<p>QQ:<fm:input path="qq"/></p>	
			<p>Email:<fm:input path="email"/></p>	
			<p>地址:<fm:input path="address"/></p>
			<input type="submit" value="保存" >
			<input id="btn" type="button" value="重置" >
			<fm:hidden path="id"/>
		</fm:form>
		<!-- 重置 -->
		<script type="text/javascript" src="/AddressBookOnline/js/jquery-1.8.3.js"></script>
		<script type="text/javascript">
			$("#btn").click(function(){
				$("form input").each(function(){
					$(this).val('');
				});
			})
		</script>
	</div>
</body>
</html>