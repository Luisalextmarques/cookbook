l<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/jsp/commons/top.jsp" %>


				<h2 class="title"><a href="#">Create Recipe</a></h2>
				
				

  <form name="createRecipe" action="createRecipe" method="post" id="createRecipe">
    <table width='100%' align="center" border='0' class="tabela">
      <tr >
        <td >Titulo:</td>
        <td colspan="2">
          <input type="text" name="titulo" id ='recipe-text'  size="80" />
        </td>
      </tr>
      <tr>
        <td valign="top">Problema:</td>
        <td colspan="2">
          <textarea type="text" name="problema" id='recipe-textarea'></textarea>
        </td>
      </tr>
      <tr>
        <td valign="top">Solução:</td>
        <td colspan="2">
          <textarea type="text" name="solucao" id='recipe-textarea'></textarea>
        </td>
      </tr>
	  <tr>
        <td valign="top">Classificações:</td>
        <td colspan="1">
          <textarea type="text" name="classificacoes" id='recipe-textarea'></textarea>
        </td>
      </tr>
	  <tr >
        <td>Autor:</td>
        <td colspan="1">
          <input type="text" name="autor" id ='recipe-text'/>
        </td>
        <td align="right" colspan="1">
          <input type="submit" id ='recipe-submit' value="Submeter" />
        </td>
      </tr>
    </table>
  </form>${CSS}</body>
<%@ include file = "/WEB-INF/jsp/commons/bottom.jsp" %>
