
        

		
		<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
${css}
<title>${titulo} - ${autor}</title>
</head>


<body>
	<div id="logo" class="container">
		<h1><a href="#">${titulo}</a></h1>
		<p>${autor}</p>
	</div>
		<div id="menu-wrapper">
			<div id="menu" class="container">
				<ul>
					<li class="current_page_item"><a href="#">Home</a></li>
					<li><a href="recipes">Lista Receitas</a></li>
					<li><a href="#">Blog</a></li>
					<li><a href="#">Photos</a></li>
					<li><a href="#">About Us</a></li>
					<li><a href="#">Links</a></li>
					<li><a href="#">Contact Us</a></li>
				</ul>
			</div>
		</div>
<div id="page" class="container">
		<div id="content">
			<div class="post">
				<h3> Receita inserida com sucesso!</h3>
			</div>
			<div style="clear: both;">&nbsp;</div>
		</div>		
</div>

</body>
</html>