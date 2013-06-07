<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/jsp/commons/top.jsp" %>


				<h2 class="title"><a href="#">Edit Recipe</a></h2>
				
				

  <form name="editRecipe" action="editRecipe" method="post" id="editRecipe">
    <table width='100%' align="center" border='0' class="tabela">
      <tr >
        <td >Titulo:</td>
        <td colspan="2">
          <input type="text" id ='recipe-text' name="titulo" size="80" value ="${items.titulo}" />
        </td>
      </tr>
      <tr>
        <td valign="top">Problema:</td>
        <td colspan="2">
          <textarea name="problema" id='recipe-textarea'>${items.problema}</textarea>
        </td>
      </tr>
      <tr>
        <td valign="top">Solução:</td>
        <td colspan="2">
          <textarea name="solucao" id='recipe-textarea'>${items.solucao}</textarea>
        </td>
      </tr>
       <tr>
        <td valign="top">Classificações:</td>
        <td colspan="2">
          <textarea type="text" name="classificacoes" id='recipe-textarea'>
		  
		  <c:forEach var="item" items='${items.getTag()}'>
						"{item.tag}, " 
								
					</c:forEach>
		  
		  </textarea>
		</td>
      </tr>
	  <tr >
        <td class='tabelaEsq'>Autor:</td>
        <td>
          <input type="text" name="autor" id ='recipe-text' value=${items.autor} />
        </td>
        <td class='tabelaDir' >
		
          <input type="submit" id ='recipe-submit' value="Submeter" />
        </td>
      </tr>
    </table>
  </form>${CSS}</body>
<%@ include file = "/WEB-INF/jsp/commons/bottom.jsp" %>
