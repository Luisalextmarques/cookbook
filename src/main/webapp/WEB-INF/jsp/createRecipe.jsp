<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/jsp/commons/top.jsp" %>

				<h2 class="title"><a href="#">Create Recipe</a></h2>
								
  <form name="formCreateRecipe" action="createRecipe" method="post">
    <table width='100%' align="center" border='0' class="tabela" >
      <tr >
        <td class="col1" >Titulo:</td>
        <td colspan="2">
          <input type="text" name="titulo" id ='recipe-text'  size="80" />
        </td>
      </tr>
      <tr>
        <td class="col1" valign="top">Problema:</td>
        <td colspan="2">
          <textarea type="text" name="problema" id='recipe-textarea'></textarea>
        </td>
      </tr>
      <tr>
        <td class="col1" valign="top">Solução:</td>
        <td colspan="2">
          <textarea type="text" name="solucao" id='recipe-textarea'></textarea>
        </td>
      </tr>
	  <tr>
        <td class="col1" valign="top">Classificações:</td>
        <td colspan="1">
          <textarea type="text" name="classificacoes" id='recipe-textarea'></textarea>
        </td>
      </tr>
	  <tr >
        <td class="col1">Autor:</td>
        <td colspan="1">
          <input type="text" name="autor" id ='recipe-text'/>
		 <input type="submit" id ='recipe-submit' value="Submeter" />
        </td>
       <!-- <td align="right" colspan="1">
          <input type="submit" id ='recipe-submit' value="Submeter" />
        </td>-->
      </tr>
    </table>
  </form>
<%@ include file = "/WEB-INF/jsp/commons/bottom.jsp" %>
