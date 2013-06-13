<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file = "/WEB-INF/jsp/commons/top.jsp" %>
				<h2 class="title"><a href="#">Receitas</a></h2>
				
					<c:forEach var="item" items='${items}'>
						<p class="listTitulo"><a class="list"  href="/recipes/${item.getRecipe().getExternalId()}">${item.titulo} | ${item.getDataCriacao()} </a></p>
						<p class="listProblema">${item.problema}</p>
						<p class="listSolucao">${item.solucao}</p>
						<p class="listAutor">${item.autor}</p>
						<c:forEach var="tag" items='${item.getTag()}'><a class="list"  href="/search/${tag.tag}">${tag.tag}</a> 				
						</c:forEach>
						<br>
						<br>
					</c:forEach>
				
<%@ include file = "/WEB-INF/jsp/commons/bottom.jsp" %>