/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


/**
 *
 * @author Pedro
 */
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Tarefa;
import Model.TarefasList;

@WebServlet(name = "TodoList", urlPatterns = {"/"})
public class List extends HttpServlet {

    private TarefasList lista = new TarefasList();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String descricao = req.getParameter("descricao");
        String acao = req.getParameter("acao");

        Tarefa tarefa = new Tarefa();

        tarefa.setDescricao(descricao);

        if (acao == null) {
            acao = "read";
        }

        if (acao.equals("create")) {
            lista.criar(tarefa);
            resp.sendRedirect("/ToDo/");
        } 
        else if (acao.equals("read")) {
            java.util.List<Tarefa> toDo = lista.ler();
            req.setAttribute("toDo", toDo);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/toDoList.jsp");
            rd.forward(req, resp);
        }

    }
}
