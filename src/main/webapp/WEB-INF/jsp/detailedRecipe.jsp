<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/jsp/commons/top.jsp" %>

				<h2 class="title"><a href="#">Titulo: ${items.titulo} | Data: ${items.getDataCriacao()}</a></h2>
				
<h3>Problema</h3> 
<h4>${items.problema} </h4>
<h3>Solução</h3>
<h4> ${items.solucao} </h4>
<h3>Classificações ${class}</h3>
<c:forEach var="item" items='${items.getTags()}'>
<li>XXXX = ${item.tag}</li>
</c:forEach>
<ul>
<c:forEach var="class" items='${class}'>
	<li>${class}
	</li>
	
</c:forEach>
</ul>

<h3>Autor</h3>
<h4> ${items.autor} </h4>

<%@ include file = "/WEB-INF/jsp/commons/bottom.jsp" %>