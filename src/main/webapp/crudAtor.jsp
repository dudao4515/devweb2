<%-- 
    Document   : crudAtor
    Created on : 16 de set. de 2025, 10:33:55
    Author     : Duda
--%>

<%@page import="java.util.List"%>
<%@page import="model.Ator"%>
<%@page import="model.Ator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/stylesAutor.css">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <h1>Cadastrar Ator</h1>
        </header>
        <%
            if (request.getAttribute("atores") == null) {
                response.sendRedirect("AtorServlet");
                return;
            }
        %>
        <article>
            <div class="cadastro">
                <h3>Informe o nome do ator:</h3>
                <form action="AtorServlet" method="post" >
                    <input type="text" name="txt_nome" placeholder="Nome do(a) ator(a)"> 
                    <button type="submit" class="save">SALVAR<%System.out.println("VAmos Chamas o atorSErvlet");%></button>

                </form>
            </div> 
            <div class="lista">
                <h3>Lista de atores</h3>
                <table border="1">
                    <tr>
                        <th>Nome</th>
                        <th>Ações</th>
                    </tr>

                    <c:forEach var="ator" items="${atores}">
                        <tr>
                            <td>${ator.nome}</td>
                            <td>
                                <a href="AtorServlet?action=edit&id=${ator.id}" class="edit">EDITAR</a>
                                <a href="AtorServlet?action=delete&id=${ator.id}" class="del">APAGAR</a>
                            </td>
                        </tr>
                    </c:forEach>

                    <c:if test="${empty atores}">
                        <tr>
                            <td colspan="2">Nenhum ator cadastrado ainda.</td>
                        </tr>
                    </c:if>
                </table> 
            </div>
        </article>

        <!-- Lista de atores -->
        <div class="atores-list">
            <h2>📋 Atores Cadastrados</h2>

            <%
                List<Ator> atores = (List<Ator>) request.getAttribute("atores");
                if (atores != null && !atores.isEmpty()) {
                    for (Ator ator : atores) {
            %>
            <div class="ator-item">
                <div class="ator-nome"><%= ator.getNome()%></div>
                <div class="ator-id">ID: <%= ator.getId()%></div>
            </div>
            <%
                }
            } else {
            %>
            <div class="empty-list">
                <p>Nenhum ator cadastrado ainda.</p>
                <p>👆 Use o formulário acima para cadastrar o primeiro!</p>
            </div>
            <%
                }
            %>   

    </body>
</html>
