/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import java.io.IOException;
import dao.AtorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import model.Ator;

/**
 *
 * @author Duda
 */
@WebServlet(name = "AtorServlet", urlPatterns = {"/AtorServlet"})
public class AtorServlet extends jakarta.servlet.http.HttpServlet {
 
   //INSERIR - ATUALIOZAR
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("txt_id");
        String nome = request.getParameter("txt_nome");

        AtorDAO atorDao = new AtorDAO();

        if (idStr == null || idStr.isEmpty()) {
            if (nome != null && !nome.trim().isEmpty()) {
                Ator ator = new Ator(nome);
                atorDao.inserirAtor(ator);
                System.out.println("Ator " + ator.getNome() + " cadastrado com sucesso!");
            }
        } else {
            Long id = Long.valueOf(idStr);
            atorDao.alterarAtor(id, nome);
            System.out.println("Ator atualizado com sucesso!");
        }

        response.sendRedirect(request.getContextPath() + "/AtorServlet");
    }

    //LISTAR - DELETAR
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        AtorDAO atorDao = new AtorDAO();

        if (action != null && action.equals("edit")) {
            String idParam = request.getParameter("id");
            if (idParam != null && !idParam.isEmpty()) {
                Long id = Long.valueOf(idParam);
                Ator ator = atorDao.listarAtorId(id);
                request.setAttribute("atorEdit", ator);

                List<Ator> atores = atorDao.listarAtores();
                request.setAttribute("atores", atores);

                request.getRequestDispatcher("/crudAtor.jsp").forward(request, response);
                return;
            }
        } else if (action != null && action.equals("delete")) {
            String idParam = request.getParameter("id");
            System.out.println("Id  foi recebido: " + idParam);
            if (idParam != null && !idParam.isEmpty()) {
                Long id = Long.valueOf(idParam);
                atorDao.excluirAtor(id);
                System.out.println("Ator " + id + " excluído!");
            }
            response.sendRedirect(request.getContextPath() + "/AtorServlet");
            return;
        }
        List<Ator> atores = atorDao.listarAtores();
        request.setAttribute("atores", atores);
        request.getRequestDispatcher("/crudAtor.jsp").forward(request, response);
    }

}
