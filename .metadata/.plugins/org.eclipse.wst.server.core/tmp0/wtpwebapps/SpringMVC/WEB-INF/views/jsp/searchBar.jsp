<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.spring.service.*"%>
<%@page import="com.spring.entity.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="navbar" class="navbar-collapse collapse">
	<FORM METHOD="Post"
		action="<%=request.getContextPath()%>/home/recipe.do"
		class="navbar-form navbar">

		<div class="form-group">
			<select size="1" name="kindNo" class="form-control">
				<option value="">料理種類</option>
				<c:forEach var="kindCodeVO" items="${kindCodeList}">
					<option value="${kindCodeVO.kindNo}">${kindCodeVO.kindName}</option>
				</c:forEach>
			</select> <select size="1" name="cookWayNo" class="form-control">
				<option value="">烹調方式</option>
				<c:forEach var="cookWayCodeVO" items="${cookWayCodeList}">
					<option value="${cookWayCodeVO.cookWayNo}">${cookWayCodeVO.cookWayName}</option>
				</c:forEach>
			</select> <INPUT TYPE="text" name="rName" placeholder="請輸入食譜名稱"
				class="form-control"> <INPUT TYPE="SUBMIT" value="送出"
				class="btn btn-success">
		</div>
	</FORM>
</div>
