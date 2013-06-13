<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file = "/WEB-INF/jsp/commons/top.jsp" %>
				<h2 class="title"><a href="#">Gerir Receitas</a></h2>
				<ul>
					<c:forEach var="item" items='${items}'>
						<li>Receita: <a href="/manageRecipes/${item.getExternalId()}">${item.titulo} </a> 
						- <a href="/manageRecipes/del/${item.getExternalId()}">Apagar Receita</a>
						<br>${item.problema}
						</li>
						<br>
					</c:forEach>
				</ul>
<%@ include file = "/WEB-INF/jsp/commons/bottom.jsp" %>