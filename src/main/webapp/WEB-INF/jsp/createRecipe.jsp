<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta name="generator"
    content="HTML Tidy for HTML5 (experimental) for Windows https://github.com/w3c/tidy-html5/tree/c63cc39" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>${titulo} - ${autor}</title>
  </head>
  <body>${css}
  <div id="logo" class="container">
    <h1>
      <a href="#">${titulo}</a>
    </h1>
    <p>${autor}</p>
  </div>
  <div id="menu-wrapper">
    <div id="menu" class="container">
      <ul>
        <li class="current_page_item">
          <a href="#">Home</a>
        </li>
        <li>
          <a href="recipes">Lista Receitas</a>
        </li>
        <li>
          <a href="#">Blog</a>
        </li>
        <li>
          <a href="#">Photos</a>
        </li>
        <li>
          <a href="#">About Us</a>
        </li>
        <li>
          <a href="#">Links</a>
        </li>
        <li>
          <a href="#">Contact Us</a>
        </li>
      </ul>
    </div>
  </div>
  <form name="createRecipe" action="createRecipe" method="post" id="createRecipe">
    <table width='780' align="center" border='0'>
      <tr>
        <td width='10' height='50'>Titulo:</td>
        <td colspan="2">
          <input type="text" name="titulo" size="80" />
        </td>
      </tr>
      <tr>
        <td valign="top">Problema:</td>
        <td colspan="2">
          <textarea name="problema" rows="5" cols="80" style="resize: none;"></textarea>
        </td>
      </tr>
      <tr>
        <td valign="top">Solução:</td>
        <td colspan="2">
          <textarea name="solucao" rows="5" cols="80" style="resize: none;"></textarea>
        </td>
      </tr>
      <tr>
        <td>Autor:</td>
        <td width='580'>
          <input type="text" name="autor" size="40" />
        </td>
        <td>
          <input type="submit" value="Submeter" />
        </td>
      </tr>
    </table>
  </form>${CSS}</body>
</html>
