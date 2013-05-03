<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/jsp/commons/top.jsp" %>

<div id="page" class="container">
		<div id="content">
			<div class="post">
				<h2 class="title"><a href="#">Titulo: ${items.titulo} | Data: ${items.getDataCriacao()}</a></h2>
				
<h3>Problema</h3> 
<h4>${items.problema} </h4>
<h3>Solução</h3>
<h4> ${items.solucao} </h4>
<h3>Autor</h3>
<h4> ${items.autor} </h4>


</div>
		<div style="clear: both;">&nbsp;</div>
		</div>		
	</div>
<div id="footer">
	<p>© 2013 Untitled Inc. All rights reserved. Design by <a href="http://www.freecsstemplates.org">FCT</a>.</p>
</div>



</body>
</html>