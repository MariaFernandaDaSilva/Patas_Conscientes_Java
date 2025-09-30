<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
		<jsp:include page="layouttopo.jsp"></jsp:include>
    <div class="row">
        <div class="card">
            <h1>Lista de Séries</h1>

            <table>
                <thead>
                    <tr>

                        <th>ID</th>
                        <th>Nome</th>
                        <th>Gênero</th>
                        <th>Idade</th>
                        <th>Ano</th>
                        <th>Alterar</th>
                        <th>Excluir</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaSeries}" var="serie">
                        <tr>
                            <td>${serie.getId()}</td>
                            <td>${serie.getNome()}</td>
                            <td>${serie.getGenero()}</td>
                            <td>${serie.getIdade()}</td>
                            <td>${serie.getAno()}</td>
                            <td><a href="/alterarserie?id=${serie.getId()}">Alterar</a></td>
                            <td><a href="#">Excluir</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <jsp:include page="layoutrodape.jsp"></jsp:include>