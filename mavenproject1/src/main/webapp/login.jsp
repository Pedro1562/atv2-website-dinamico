<%-- 
    Document   : login
    Created on : 26/06/2022, 21:58:32
    Author     : T-Gamer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>  ... </head>
   <body>
       <div class="centro">
           <h1>TO DO Dinâmico</h1>
           <hr />
           <h5>Login</h5>
           <form action="/todo/login" method="post">
               <label for="username">Usuário</label> <br />
               <input id="username" type="text"
                      name="username" placeholder="Usuário" /><br />
               <label for="username">Senha</label> <br />
               <input id="password" type="password"
                      name="password" placeholder="Senha"/><br />
               <input type="submit" name="entrar" value="Entrar" />
           </form>
       </div>
   </body>
</html>