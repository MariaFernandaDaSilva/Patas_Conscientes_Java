<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
        <jsp:include page="layouttopo.jsp"></jsp:include>
        <div class="row">
            <div class="card">
                <div class="card2">
                    <h1>Lista de ONGs</h1>

                    <table>
                        <thead>
                            <tr>

                                <th>ID</th>
                                <th>Nome da ONG</th>
                                <th>Nome do Responsável</th>
                                <th>Gênero do Responsável</th>
                                <th>Cidade</th>
                                <th>Alterar</th>
                                <th>Excluir</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listaOngs}" var="ong">
                                <tr>
                                    <td>${ong.getId()}</td>
                                    <td>${ong.getNome()}</td>
                                    <td>${ong.getResponsavel()}</td>
                                    <td>${ong.getGeneroResponsavel()}</td>
                                    <td>${ong.getCidade()}</td>
                                    <td><a href="/alterarong?id=${ong.getId()}">Alterar</a></td>
                                    <td><a href="#">Excluir</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
        <jsp:include page="layoutrodape.jsp"></jsp:include>