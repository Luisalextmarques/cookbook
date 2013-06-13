<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file = "/WEB-INF/jsp/commons/top.jsp" %>
<p	class="xpto">Titulo  <a	class="xpto">${items.titulo}</a></p>
<p 	class="data">Data:  	${items.getDataCriacao()}</p>	
<h3 class="title">Problema</h3> 
<h4>${items.problema} </h4>
<h3 class="title">Solução</h3>
<h4 > ${items.solucao} </h4>
<br>
<h3 class="title">Autor</h3>
<h4> ${items.autor} </h4>
<br>
<table width='100%' align="left" border='0' >
<h3 class="title">Classificações</h3>
      		<tr>	
			<td valign="top"  width='2%'></td>
				<td>
				<ul>
					<c:forEach var="item" items='${items.getTag()}'>
						<li>${item.tag} 
						</li>		
					</c:forEach>
				</ul>	
			</td>
			</tr>
</table>

<table width='100%' align="left" border='0' >
<h3 class="title">Versões</h3>
				<li><ul>Versão Actual<br> <a href="#">${items.titulo} </a>| ${items.getDataCriacao()}
				<br>${items.problema}
				</li>
						
      		<tr>	
			<td valign="top"  width='2%'></td>
				<td>		
								<ul>
						
					<c:forEach var="item" items='${versoes}'>
						<li><a href="#">${item.titulo} </a>| ${item.getDataCriacao()}
						<br>${item.problema}
						</li>
						
					</c:forEach>
				</ul>
			</td>
			</tr>
</table>

<%@ include file = "/WEB-INF/jsp/commons/bottom.jsp" %>