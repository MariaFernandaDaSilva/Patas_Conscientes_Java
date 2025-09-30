<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="layouttopo.jsp"></jsp:include>
    <div class="row">
        <div class="card">
            <h1>Alteração de Série</h1>
            <form:form action="/alterarserie" modelAttribute="serie">
                <label for="id">Id:</label>
                <input type="number" value="${serie.getId()}" disabled>
                <input type="hidden" id="id" name="id" value="${serie.getId()}">
                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome" maxlength="100" value="${serie.getNome()}">
                <label for="genero">Gênero:</label>
                <select id="genero" name="genero" value="${serie.getGenero()}">
                    <option value="Ação">Ação</option>
                    <option value="Comédia">Comédia</option>
                    <option value="Drama">Drama</option>
                    <option value="Ficção">Ficção</option>
                    <option value="Terror">Terror</option>
                    <option value="Scifi">Scifi</option>
                    <option value="Suspense">Suspense</option>
                    <option value="Romance">Romance</option>
                    <option value="Outro">Outro</option>
                </select>
                <label for="idade">Idade:</label>
                <input type="number" id="idade" name="idade" min="10" max="120" value="${serie.getIdade()}">
                <label for="ano">Ano de lançamento:</label>
                <input type="number" id="ano" name="ano" value="${serie.getAno()}">
                <button>Alterar</button>
            </form:form>
        </div>
    </div>
<jsp:include page="layoutrodape.jsp"></jsp:include>