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
        <title>Cadastro de Atores</title>
    </head>
    <body>
        <header>
            <h1>Cadastrar Ator</h1>
        </header>
        <article>
            <div class="cadastro">
                <h3>Informe o nome do ator:</h3>
                <%
                    Ator atorEdit = (Ator) request.getAttribute("atorEdit");
                    String nome = (atorEdit != null) ? atorEdit.getNome() : "";
                    String id = (atorEdit != null) ? String.valueOf(atorEdit.getId()) : "";
                %>

                <form action="AtorServlet" method="post">
                    <input type="hidden" name="txt_id" value="<%= id%>" />
                    <input type="text" name="txt_nome" placeholder="Nome do(a) ator(a)" value="<%= nome%>" required> 
                    <button type="submit" class="save"><%= (atorEdit != null) ? "Atualizar" : "Salvar"%></button>
                </form>
            </div> 

            <!-- Lista de atores -->
            <div class="atores-list">
                <h2>Atores Cadastrados</h2>

                <%
                    List<Ator> atores = (List<Ator>) request.getAttribute("atores");
                    if (atores != null && !atores.isEmpty()) {
                        for (Ator ator : atores) {
                %>
                <div class="ator-item">
                    <div class="ator-nome"><%= ator.getNome()%></div>

                    <!-- Botões individuais -->
                    <div class="ator-actions">
                        <!-- CORREÇÃO AQUI: mudar "buscar" para "edit" -->
                        <a href="AtorServlet?action=edit&id=<%= ator.getId()%>" class="edit"> Editar</a>
                        <a href="AtorServlet?action=delete&id=<%= ator.getId()%>" class="del" 
                           onclick="return confirm('Tem certeza que deseja excluir este ator?')">  Apagar</a>
                    </div>
                </div>
                <%
                    }
                } else {
                %>
                <div class="empty-list">
                    <p>Nenhum ator cadastrado ainda.</p>
                    <p>👆Use o formulário acima para cadastrar o primeiro!</p>
                </div>
                <%
                    }
                %>  
            </div> <!-- Fechamento da div atores-list -->
        </article>
    </body>
</html>