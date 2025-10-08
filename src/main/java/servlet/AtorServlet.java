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

    //INSERIR
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("txt_nome");
        if (nome != null || !nome.trim().isEmpty()) {
            Ator ator = new Ator(nome);
            AtorDAO atorDao = new AtorDAO();

            atorDao.inserirAtor(ator);
            System.out.println("Ator" + ator + "Cadastrado com sucesso.");

        }

        response.sendRedirect(request.getContextPath() + "/AtorServlet");
    }

    //LISTAR
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Listando atores");
        AtorDAO atorDAO = new AtorDAO();
        List<Ator> atores = atorDAO.listarAtores();
        System.out.println("NOmeS???????????  \n" + atores.toString());

        request.setAttribute("atores", atores);
        request.getRequestDispatcher("/crudAtor.jsp").forward(request, response);
    }

}
