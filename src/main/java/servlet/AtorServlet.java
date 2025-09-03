/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import java.io.IOException;
import dao.AtorDAO;

/**
 *
 * @author Duda
 */
public class AtorServlet extends  jakarta.servlet.http.HttpServlet{
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AtorServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
		
		 
		String nome = request.getParameter("txt_nome");
		
		System.out.println("wwwwwwwwwwwwwwwww");
		
		if (AtorDAO.incluirAtor(nome) == 0) {
			
			response.sendRedirect("mensagem.jsp?msg='Ator incluído com sucesso!!!'");
			
		}else {
			
			response.sendRedirect("mensagem.jsp?msg='ERRO ao incluir Ator.'");
			
		}
		
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
