<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/jsp/commons/top.jsp" %>

	<h2 class="title"><a href="#">About Us</a></h2>
		<p>Requisitos - Projeto ES</p>
		<p>
Na avaliação do projecto, serão considerados os seguintes requisitos funcionais
e não funcionais:
</p>
<ul>
<li>
R1 - Criar Receita<br>
Deve ser possivel criar novas receitas, para isso providenciando um título, uma descrição do problema, uma descrição da solução, e o nome do autor. O sistema deve guardar automaticamente a data e hora (timestamp) da criação da receita.
</li>
<li>
R2 - Listar Receitas<br>
Deve ser possivel listar receitas existentes, essa listagem deve estar ordenada por ordem alfabética do titulo da receita.
</li>
<li>
R3 - Ver Receita em Detalhe<br>
Deve ser possivel clicar numa receita da lista de receitas, e ver essa receita em detalhe. Essa vista detalhe da receita deve incluir o título da receita, o problema e a sua respectiva descrição. Deve também estar presente nessa vista em detalhe, qual o nome do autor e a respectiva data e hora (timestamp) da criação dessa receita.
</li>
<li>
R4 - Apagar Receita<br>
Deve ser possivel apagar receitas, removendo-as da lista de receitas.
</li>
<li>
R5 - Classificar Receitas<br>
Deve ser possivel associar tags a receitas, i.e. associar palavras separadas por virgulas a uma dada receita.
</li>
<li>
R6 - Procurar Receitas<br>
Deve ser possivel procurar receitas, utilizando o texto das receitas (titulo, problema e resposta), bem como as tags associadas à mesma.
</li>
<li>
R7 - Edição de Receitas<br>
Deve ser possivel editar receitas, mantendo o histórico das alterações feitas nessa edição. Como consequência, devem ser sempre criadas novas versões e nunca modificar o texto ou tags das versões anteriores. Assim, na vista detalhada da receita, deve aparecer igualmente uma lista das várias versões existentes, bem como a data em que cada uma das versões foi editada. Na vista de listagem de receitas, deve aparecer sempre a ultima versão de cada receita.
</li>
<li>
R8 - Persistência<br>
Quando a aplicação reinicia, ou seja, quando é feito um redeploy da mesma,esta deve manter os dados da aplicação (receitas, etc...). Essa persistência deve ser feita utilizando a FénixFramework leccionada nas aulas de laboratório.
</li>

<%@ include file = "/WEB-INF/jsp/commons/bottom.jsp" %>