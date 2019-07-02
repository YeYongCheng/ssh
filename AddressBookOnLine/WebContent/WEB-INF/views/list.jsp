<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在线通讯录</title>
<style type="text/css">
	table{
		width: 700px;
		margin: 0 auto;
	}
	table td{
		text-align:center
	}
	table tr:nth-child(odd){
			background-color: green;
	}
	.tiaojian{
		width: 500px;
		height:40px;
		margin: 0 auto;
	}
</style>
</head>
<body>
	<h2 style="text-align: center;">在线通讯录</h2>

		<fm:form id="myForm" action="/AddressBookOnLine/Contact/contactByPage.action" modelAttribute="contact">
			<div class="tiaojian">
				查询联系人:<%-- <fm:input path="cname"/> --%>
				<input type="text" name="cname" value="${cname}">
				<input type="button" value="查找" onclick="gotoFirst()"/>
				<a style="margin-left: 20px;" href="/AddressBookOnLine/Contact/getoinsert.action">添加联系人</a>
				<c:if test="${pagingResult.data.size() == 0}">
					<h3>没有找到相关的联系人！</h3>
				</c:if>
			</div>
			<c:if test="${pagingResult.data.size() != 0}">
				<table border="1">
					<tr style="background-color:#eeccff">
						<th>序号</th>
						<th>姓名</th>
						<th>手机</th>
						<th>QQ</th>
						<th>Email</th>
						<th>地址</th>
					</tr>
					<c:forEach items="${pagingResult.data}" var="address" varStatus="i">
						<tr>
							<td>${i.count}</td>
							<td>
								<a href="/AddressBookOnLine/Contact/getById.action?id=${address.id}">${address.cname}</a>
							</td>
							<td>${address.mobile}</td>
							<td>${address.qq}</td>
							<td>${address.email}</td>
							<td>${address.address}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<input id="page" type="hidden" name="pageNo" value="${pagingResult.pageNo}">	
		    
	</fm:form>
	
	<div style="margin: 0 auto;width: 400px;font-size:17px;">&nbsp;
    	<a href="javascript:gotoFirst()">首页</a>&nbsp;|
    	<a href="javascript:gotoprev()">上一页</a>&nbsp;|
    	<a href="javascript:gotoNext()">下一页</a>&nbsp;|
    	<a href="javascript:endPage()">尾页</a>&nbsp;
    	
    	<label>第${pagingResult.pageNo}页/共${pagingResult.pageCount}页 </label>
    </div>
	<script>
    	function gotoFirst(){
    		document.getElementById("page").value = 1;
			document.getElementById("myForm").submit();
    	}
    
    	function gotoprev(){
    		var pageNo = document.getElementById("page").value;
    		if(parseInt(pageNo) == 1){
    			alert("没有上一页了！");
    		}else{
    			pageNo--;
    			document.getElementById("page").value = pageNo;
				document.getElementById("myForm").submit();
    		}
    	}
    
    	function gotoNext(){
    		var pageNo = document.getElementById("page").value;
    		if(parseInt(pageNo) >= parseInt("${pagingResult.pageCount}")){
    			alert("没有下一页了！");
    		}else{
    			pageNo++;
    			document.getElementById("page").value = pageNo;
				document.getElementById("myForm").submit();
    		}
    	}
    	
    	function endPage(){
    		var pageNo = document.getElementById("page").value;
    		if(parseInt(pageNo) >= parseInt("${pagingResult.pageCount}")){
    			alert("已经是尾页了！");
    		}else{
    			document.getElementById("page").value = "${pagingResult.pageCount}";
				document.getElementById("myForm").submit();
    		}
    	}
    </script>
</body>
</html>