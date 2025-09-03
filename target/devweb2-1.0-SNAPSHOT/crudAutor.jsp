<%-- 
    Document   : crudAutor
    Created on : 2 de set. de 2025, 17:04:56
    Author     : Duda
--%>

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
            <h1>Cadastrar Autor</h1>
        </header>
        <article>
            <div class="cadastro">
            <h3>Informe o nome do autor:</h3>
            <form name="cadastroator" method="POST" action="CadastrarAtor" >
                <input type="text" name="nomeAutor"> 
            </form>
            <button class="save">SALVAR</button>
        </div> 
        <div class="lista">
            <h3>Lista de autores</h3>
            <table>
                <tr>
                    <th>Nome</th>
                    <th>Ações</th>
                </tr>
                <tr>
                    <td>Nome 1</td>
                    <td>
                        <button class="edit">EDITAR</button>
                        <button class="del">APAGAR</button>
                    </td>
                </tr>
            </table> 
        </div>
        </article>
        
    </body>
</html>
