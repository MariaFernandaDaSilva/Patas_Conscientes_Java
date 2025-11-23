<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<jsp:include page="layouttopo.jsp"></jsp:include>

<div class="row">
    <div class="card_container">
        
        <div class="headertabela">
            <h1>Lista de ONGs</h1>
            
            <form action="/pesquisarong" method="get" class="form_pesquisa">
                <input type="text" name="termo" placeholder="Nome ou Responsável">
                <button type="submit">🔎</button>
            </form>
        </div>

        <div class="ongs-grid">
            <c:forEach items="${listaOngs}" var="ong">
                <div class="ong-card">
                    <div class="card-header">
                        <h2>${ong.getNome()}</h2>
                        <span class="ong-id">ID: ${ong.getId()}</span>
                    </div>

                    <div class="card-body">
                        <p><strong>Responsável:</strong> ${ong.getResponsavel()}</p>
                        <p><strong>Gênero:</strong> ${ong.getGeneroResponsavel()}</p>
                        <p><strong>Cidade:</strong> ${ong.getCidade()}</p>
                    </div>

                    <div class="card-actions">
                        <a href="/alterarong?id=${ong.getId()}" class="btn-alterar">Alterar</a>
                        <a href="/excluirong?id=${ong.getId()}" class="btn-excluir">Excluir</a>
                    </div>
                </div>
            </c:forEach>
            </div>
        
    </div>
</div>

<jsp:include page="layoutrodape.jsp"></jsp:include>