<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

${css}
<title>${titulo} | ${autor}</title>
</head>


<body>
	<div id="logo" class="container">
		<h1><a href="#">${titulo}</a></h1>
		<p>${autor}</p>
	</div>
	<div id="menu-wrapper">
		<div id="menu" class="container">
			<ul>			${menu}			</ul>
		</div>
	</div>
<div id="page" class="container">
		<div id="content">
			<div class="post">
				<h2 class="title"><a href="#">Receitas</a></h2>
				<ul>
					<c:forEach var="item" items='${items}'>
						<li><a href="/recipes/${item.key}">${item.value.titulo} </a></li>
					</c:forEach>
				</ul>
			</div>
			<div style="clear: both;">&nbsp;</div>
		</div>		
</div>

</body>
</html>