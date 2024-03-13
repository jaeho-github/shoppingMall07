<!-- 상품목록조회 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>

<%--
<%@ page import="java.util.List"  %>
    
<%@ page import="com.model2.mvc.service.domain.Product" %>
<%@ page import="com.model2.mvc.common.Search" %>
<%@ page import="com.model2.mvc.common.Page"%>
<%@page import="com.model2.mvc.common.util.CommonUtil"%>

<%
	List<Product> list= (List<Product>)request.getAttribute("list");
	Page resultPage=(Page)request.getAttribute("resultPage");
	
	Search search=(Search)request.getAttribute("search");
	
	String searchCondition = CommonUtil.null2str(search.getSearchCondition());
	String searchKeyword = CommonUtil.null2str(search.getSearchKeyword());
	String menu = request.getParameter("menu");
%>
 --%>

<html>
<head>
<title>상품 목록조회</title>

<link rel="stylesheet" href="/css/admin.css" type="text/css">

<script type="text/javascript" src="../javascript/util.js">

</script>
</head>

<body bgcolor="#ffffff" text="#000000">

<div style="width:98%; margin-left:10px;">

<form name="detailForm" action="/listProduct.do?menu=${param.menu }" method="post">

<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td width="15" height="37">
			<img src="/images/ct_ttl_img01.gif" width="15" height="37"/>
		</td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left:10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">
					${(!empty param.menu && param.menu eq 'search') ? '상품 조회목록' : '상품 관리'  }
					</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37">
			<img src="/images/ct_ttl_img03.gif" width="12" height="37"/>
		</td>
	</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
	<c:if test = "${search.searchCondition != null }">
		<td align="right">
			<select name="searchCondition" class="ct_input_g" style="width:80px">
				<c:if test = "${search.searchCondition eq '0' }">
					<option value="0" selected>상품번호</option>
					<option value="1">상품명</option>
					<option value="2">상품가격</option>
				</c:if>
				<c:if test = "${search.searchCondition eq '1' }">
					<option value="0" >상품번호</option>
					<option value="1" selected>상품명</option>
					<option value="2">상품가격</option>
				</c:if>
				<c:if test = "${search.searchCondition ne '0' && search.searchCondition ne '1' }">
					<option value="0" >상품번호</option>
					<option value="1" >상품명</option>
					<option value="2" selected>상품가격</option>
				</c:if>
			</select>
			<input type="text" name="searchKeyword" value="${search.searchKeyword }" 
			class="ct_input_g" style="width:200px; height:19px" />
		</td>
	</c:if>
	
	<c:if test = "${search.searchCondition == null }">
		<td align = "right">
			<select name="searchCondition" class="ct_input_g" style="width:80px">
				<option value="0">상품번호</option>
				<option value="1">상품명</option>
				<option value="2">상품가격</option>
			</select>
			<input type="text" name="searchKeyword"  class="ct_input_g" style="width:200px; height:19px" >
		</td>
	</c:if>
		
		<td align="right" width="70">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17" height="23">
						<img src="/images/ct_btnbg01.gif" width="17" height="23">
					</td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;">
						<a href="javascript:fncGetProductList(1);">검색</a>
					</td>
					<td width="14" height="23">
						<img src="/images/ct_btnbg03.gif" width="14" height="23">
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td colspan="11" >
			전체  ${resultPage.totalCount } 건수, 현재 ${resultPage.currentPage } 페이지
		</td>
	</tr>
	<tr>
		<td class="ct_list_b" width="100">No</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">상품명</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">가격</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">등록일</td>	
		<td class="ct_line02"></td>
		<td class="ct_list_b">현재상태</td>	
	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>
	
	<c:set var = "i" value = "0" />
	<c:forEach var = "product" items = "${list }" >
		<c:set var="i" value="${ i+1 }" />
		<tr class="ct_list_pop">
			<td align="center">${i}</td>
			<td></td>		
			<td align="left">
				<a href="/getProduct.do?prodNo=${product.prodNo }&menu=${param.menu }">${product.prodName }</a>
			</td>
			<td></td>
			<td align="left">${product.price }</td>
			<td></td>
			<td align="left">${product.regDate }</td>
			<td></td>
			<c:if test = "${product.proTranCode == null}">
				<td align="left">판매중</td>
			</c:if>	
		</tr>
		<tr>
			<td colspan="11" bgcolor="D6D7D6" height="1"></td>
		</tr>
	</c:forEach>
</table>

<!-- PageNavigation Start... -->
<table width="100%" border="0" cellspacing="0" cellpadding="0"	style="margin-top:10px;">
	<tr>
		<td align="center">
		   <input type="hidden" id="currentPage" name="currentPage" value=""/>
		   <c:import var = "pageUnit" url = "../common/pageNavigator.jsp" scope="request" />
		   ${pageUnit }
		
    	</td>
	</tr>
</table>
<!-- PageNavigation End... -->

</form>

</div>
</body>
</html>