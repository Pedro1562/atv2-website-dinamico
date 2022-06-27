<%-- 
    Document   : toDoList
    Created on : 25/06/2022, 18:26:04
    Author     : T-Gamer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TO DO Dinamico</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
        <h1>toDO Dinâmico</h1>

        <h3>Adicione as tarefas desejas na lista a baixo e seleciona uma ação: </h3>
        
        <ul>
            <c:forEach var="tarefa" items="${toDo}">
                <li><c:out value="${tarefa.descricao}" /></li>
            </c:forEach>
        </ul>

        <hr/>
        <hr/>
        
        <form action="/ToDo/">
            <input id="descricao" name="descricao" placeholder="Insira a sua descrição"/>
            <input type="hidden" naem="action" value="create"/>
            <button type="submit"> Salvar </button>
        </form>
    </body>
</html>
