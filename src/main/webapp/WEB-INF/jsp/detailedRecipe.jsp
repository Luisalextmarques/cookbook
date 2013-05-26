<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file = "/WEB-INF/jsp/commons/top.jsp" %>

				<h2 class="title"><a href="#">Titulo: ${items.titulo} | Data: ${items.getDataCriacao()}</a></h2>
				
<h3>Problema</h3> 
<h4>${items.problema} </h4>
<h3>Solução</h3>
<h4> ${items.solucao} </h4>

<h3>Classificações</h3>
	<c:forEach var="item" items='${items.getTags()}'>
		<h4><a href="#">${item.tag} </a></h4>
	</c:forEach>
</ul>	


<h3>Autor</h3>
<h4> ${items.autor} </h4>

<%@ include file = "/WEB-INF/jsp/commons/bottom.jsp" %>